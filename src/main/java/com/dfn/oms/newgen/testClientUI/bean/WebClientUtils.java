package com.dfn.oms.newgen.testClientUI.bean;

import com.dfn.oms.newgen.testClientUI.UserController1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.dfn.oms.newgen.testClientUI.OrderController.orderAction;
import static com.dfn.oms.newgen.testClientUI.OrderController.sessionID;
public class WebClientUtils {

    public class MultiExchangeReqMeta_InternalTmp {
        private String symbol;
        private String exchange;
        private int tradingAcntID;
        private int loginID;
        private int execBrokerID;
    }

    private static JSONHandler jsonHandler = new JSONHandler();
    private static List<String> requestList = new ArrayList<>();
    private static String currentAction ="2";
    private int orderQty;
    private static final String EXCHANGE_TDWL = "TDWL";
    private static final String SYMBOL_1010 = "1010";
    private static final String MKT_CODE_ALL = "ALL";
    private static double price = 5.00;
    private static final int qty = 1;
    private static final int customerID = 270;
    private static final String dealerID = "1";
    private static final int execBrokerID = 1;
    private static int populatedRequestsCount = 1;
    private MultiExchangeReqMeta_InternalTmp multiExchangeReqMeta_internalTmp;
    private static String request;

    public static JSONHandler getJsonHandler() {
        return jsonHandler;
    }

    public static void setJsonHandler(JSONHandler jsonHandler) {
        WebClientUtils.jsonHandler = jsonHandler;
    }

    public static List<String> getRequestList() {
        return requestList;
    }

    public static void setRequestList(List<String> requestList) {
        WebClientUtils.requestList = requestList;
    }

    public static String getCurrentAction() {
        return currentAction;
    }

    public static void setCurrentAction(String currentAction) {
        WebClientUtils.currentAction = currentAction;
    }

    private void populateRequests(boolean clearAndPopulate, int requestsCount, int requestType, String listOfCashAccounts) {
        if (clearAndPopulate) {
            requestList.clear();
        }
        populatedRequestsCount = 0;
        Order order = new Order();
        List<String> duplicateRequest = new ArrayList<>();//to improve memory/performance
        String request;
        int counter = 0;
        List cashAccountsList = null;
        if (listOfCashAccounts != null && listOfCashAccounts.length() > 0) {
            cashAccountsList = Arrays.asList(listOfCashAccounts.split(","));
        }
        int cashAccountsCounter = 0;
        int cashAcntID = -1;
        while (requestsCount > 0) {
            if (counter > 300 || (cashAccountsList != null && counter > cashAccountsList.size())) {//300 is number or unique requests
                String requestReplay = duplicateRequest.get(requestsCount % (populatedRequestsCount - 1));
                if (requestReplay != null) {
                    requestList.add(requestReplay);
                }
            } else {
                if (cashAccountsList != null && cashAccountsList.size() > 0) {
                    cashAcntID = Integer.parseInt(cashAccountsList.get(cashAccountsCounter) + "");
                    cashAccountsCounter++;
                    if (cashAccountsCounter >= cashAccountsList.size()) {
                        cashAccountsCounter = 0;
                    }
                }
                request = generateRequest(order, requestType, requestsCount, cashAcntID);
                if (request != null) {
                    requestList.add(request);
                    duplicateRequest.add(request);
                }
            }
            counter++;
            requestsCount--;
        }
    }

    private boolean isNotInSkippedList(int count) {
        if (WebSocketRunner.tradeIDSkipped != null) {
            return WebSocketRunner.tradeIDSkipped.contains(count + "");
        }
        return false;
    }

    private void populateAmendOrCancelRequest(boolean clearAndPopulate, int requestType, String clOrdID) {
        if (clearAndPopulate) {
            requestList.clear();
        }
        Order order = new Order();
        order.setClOrdID(clOrdID);      //This is the UniversalApp Amend/Cancel request parameters
        String request = generateRequest(order, requestType, 1, -1);
        requestList.add(request);
    }

    private void populateResendOrderRequest(boolean clearAndPopulate, int requestType, String clOrdID) {
        if (clearAndPopulate) {
            requestList.clear();
        }
        Order order = new Order();
        order.setClOrdID(clOrdID);
        String request = generateRequest(order, requestType, 1, -1);
        requestList.add(request);
    }


    public boolean processCommandLind() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*******************  V 0.0.2 ***********************************");
        System.out.println("*******************  Skipped Trading Account IDS:" + System.getProperty(WebSocketRunner.SYS_PROPERTY_SKIPPED_TRD_IDS) + " ***********************************");
        System.out.println("******************* Connect to gateway:" + WebSocketRunnerSetting.isGWClient + "," +
                " EntPoint(WebSocket) Count:" + WebSocketRunnerSetting.numOfEndPoints);
        String cashAcntCountsString = System.getProperty("CASH_ACCOUNT_LIST");
        System.out.println("******************* IS Timed orders flag set(ORDERS_PER_TIME_SLICE):" + System.getProperty("ORDERS_PER_TIME_SLICE") + " , Ex. 100:5 (i.e 100 orders per 5 seconds)");
        if (cashAcntCountsString != null) {
            System.out.println("\n******************* Cash account list defined:" + cashAcntCountsString);
        } else {
            System.out.println("\n******************* Cash accounts not defined, using default 300s");
        }
        System.out.print("\nSelect Action  : \n(2:CreateOrders\n3:Amend Order\n4:Cancel Order\n" +
                "7:Order List\n-2:Stat Gather,ReGrp,Persist\n-3:Stat Clear,\n-4:Print Rest Response,\n5:JMS MSG SEND\n9:CreateOrders For DefinedExchanges\n21:Approve Order\n42:Resend Order\nDefault:Print) :- ");
        String action ;//="4";
        action = orderAction;

        if (action.trim().equals(Integer.toString(OMSConst.SERVICE_ID_CREATE_ORDER_NEW)) || action.trim().equals("9")) {


            populateRequests(true, UserController1.userRepository1.findById((long) UserController1.userRepository1.count()).get().getNoOfOrders(), Integer.parseInt(action), cashAcntCountsString);

        } else if ("3".equals(action.trim())) {
            //System.out.print("ClOrderID:");
            String clOrdID = UserController1.hashMap_amendOrder.get(Integer.toString(UserController1.hashMap_amendOrder.size())).getClOrdID();
            // System.out.print("Order qty:");
            // String orderQtyStr = scanner.next();

            orderQty = UserController1.hashMap_amendOrder.get(Integer.toString(UserController1.hashMap_amendOrder.size())).getOrderQty();

//            System.out.print("Price:");
            String priceStr = UserController1.hashMap_amendOrder.get(Integer.toString(UserController1.hashMap_amendOrder.size())).getPrice();
            try {
                price = Integer.parseInt(priceStr);
            } catch (NumberFormatException e) {

            }
            populateAmendOrCancelRequest(true, OMSConst.SERVICE_ID_CREATE_ORDER_CHANGE, clOrdID);
        } else if ("4".equals(action.trim())) {
            //System.out.print("ClOrderID:");
            String clOrdID = UserController1.hashMap_cancelOrder.get(Integer.toString(UserController1.hashMap_cancelOrder.size())).getClOrdID();
            populateAmendOrCancelRequest(true, OMSConst.SERVICE_ID_CREATE_ORDER_CANCEL, clOrdID);
        } else if ("21".equals(action.trim())) {
            System.out.print("ClOrderID:");
            String clOrdID = scanner.next().trim();
            System.out.println("Approve = 1, Reject = 0");
            int status = Integer.parseInt(scanner.next().trim());
            populateApproveOrderRequest(true, status , clOrdID);
        } else if ("42".equals(action.trim())) {
            System.out.print("ClOrderID:");
            String clOrdID = scanner.next().trim();
            populateResendOrderRequest(true, Integer.parseInt(action), clOrdID);
        } else if ("-2".equals(action.trim()) || "-3".equals(action.trim())) {
            populateRequests(true, 1, Integer.parseInt(action), cashAcntCountsString);
        } else if (action.trim().equals(Integer.toString(OMSConst.SERVICE_ID_ORDER_LIST))) {
            populateRequests(true, 1, Integer.parseInt(action), cashAcntCountsString);
        } else if (action.trim().equals(Integer.toString(OMSConst.SERVICE_ID_TEST_JMS))) {
            System.out.print("JMS Message:");
            scanner.nextLine();
            String message = scanner.nextLine();
            if (message == null || "".equals(message.trim()) || "-1".equals(message.trim())) {
//                message = "TDWL\u001C0\u001C23041\u001C8=FIXT.1.1" + OMSConst.FD + "9=000151" + OMSConst.FD + "35=h" + OMSConst.FD + "49=XSAU" + OMSConst.FD + "56=014" + OMSConst.FD + "34=844" + OMSConst.FD + "57=0140002" + OMSConst.FD + "143=null" + OMSConst.FD + "52=20170723-06:30:00.001" + OMSConst.FD + "335=1500780671363" + OMSConst.FD + "1300=ALL" + OMSConst.FD + "336=1" + OMSConst.FD + "625=2" + OMSConst.FD + "340=4" + OMSConst.FD + "1368=2" + OMSConst.FD + "341=20170723-06:30:00.000" + OMSConst.FD + "10=219" + OMSConst.FD + "";
                message = "TDWL\u001C0\u001C23041\u001C8=FIXT.1.1\u00019=115\u000135=U29\u000134=316\u000152=20171228-08:06:49.594\u000149=998\u000156=080\u000157=M0800001\u00019742=U2815360521\u00019730=0\u00019701=180904000000263\u00019729=1365245876\u0001900=5\u000110=124\u0001";
                System.out.println("\n Empty Message Found, Sending Sample Message:" + message);
            }
            System.out.print("\nQueue Name(default:jms/queue/FromExchange):");
            String queueName = scanner.next();
            if (queueName == null || "".equals(queueName.trim()) || "-1".equals(queueName.trim())) {
                queueName = "jms/queue/FromExchangePreProcessed";//jms/queue/FromExchange
            }
            StatMonReqResBean statMonReqResBean = new StatMonReqResBean();
            statMonReqResBean.getOmsMsgHeader().setRequestType(OMSConst.SERVICE_ID_TEST_JMS);
            StatMonReqResBean.JMSMessageRequest jmsMessageRequest = statMonReqResBean.new JMSMessageRequest();
            jmsMessageRequest.setMessage(message);
            jmsMessageRequest.setQueueName(queueName);
            statMonReqResBean.setJmsMessageRequest(jmsMessageRequest);
            requestList.clear();
            requestList.add(jsonHandler.getJSonString(statMonReqResBean));
        } else if ("-4".equals(action.trim())) {
            System.out.println("\n Printing rest response:");
        } else {
            System.out.println("\nInput Command Invalid");
            return false;
        }
        return true;
    }

    private String generateOrderRequest(Order order, int requestSequence, int cashAcntID) {
        return generateOrderRequest(order, requestSequence, null, cashAcntID);
    }

    private String generateOrderRequest(Order order, int requestSequence,
                                        List<MultiExchangeReqMeta_InternalTmp> multiExchangeReqMeta_internalTmps, int cashAcntID) {
        OrderParams orderParams = UserController1.parameterRepository.findById((long) UserController1.parameterRepository.count()).get();
        if (cashAcntID > 0) {
            requestSequence = cashAcntID;
        } else {
            requestSequence = requestSequence % 500;
        }
        int orderChannel = orderParams.getOrderChannel();   //DT-1, AT-3
        OrderRequestBean orderRequestBean = new OrderRequestBean();
        orderRequestBean.getOmsMsgHeader().setRequestType(OMSConst.SERVICE_ID_CREATE_ORDER_NEW);
        orderRequestBean.getOmsMsgHeader().setChannel(orderChannel);
        orderRequestBean.getOmsMsgHeader().setSessionID(sessionID);
       orderRequestBean.getOmsMsgHeader().setLoginID(customerID);
        orderRequestBean.getOmsMsgHeader().setUnqReqId(Integer.toString(requestSequence));
        orderRequestBean.setOrder(order);
        order.setTenantCode(OMSConst.DEFAULT_TENANCY_CODE);
        order.setTenantCode(orderParams.getTenantCode());
        order.setOrderMode(OMSConst.ORDER_MODE_NORMAL);
        order.setOrderMode(orderParams.getOrderMode());
        order.setType(FIX.T40_LIMIT);//1:Market,2:Limit
        order.setType(orderParams.getType().charAt(0));
        orderQty = UserController1.userRepository1.findById((long) UserController1.userRepository1.count()).get().getOrderQty();
        order.setQuantity(orderQty);
        if (orderQty <= 0) {
            order.setQuantity(qty);
        }
//        order.setCustomerID(customerID);
        order.setCustomerID(requestSequence);
        order.setSide(FIX.T54_BUY);//1:Buy,2:Sell
        order.setSide(orderParams.getSide());
        order.setCashAcntID((requestSequence % 298) + 1);
        if (multiExchangeReqMeta_internalTmps == null || multiExchangeReqMeta_internalTmps.size() == 0) {
            order.setSymbol(SYMBOL_1010);
            order.setSymbol(orderParams.getSymbol());
            order.setExchange(EXCHANGE_TDWL);
            order.setExchange(orderParams.getExchange());
            order.setTradingAccountID((requestSequence % 298) + 1);
            order.setExecBrokerID(execBrokerID);
            orderRequestBean.getOmsMsgHeader().setLoginID(1471); //for the timebeing tradingAcntID=loginID mapping is exist in DB
        } else {
            int index = requestSequence % (multiExchangeReqMeta_internalTmps.size());
            multiExchangeReqMeta_internalTmp = multiExchangeReqMeta_internalTmps.get(index);
            order.setSymbol(multiExchangeReqMeta_internalTmp.symbol);
            order.setSymbol(orderParams.getSymbol());
            order.setExchange(multiExchangeReqMeta_internalTmp.exchange);
            order.setExchange(orderParams.getExchange());
            order.setTradingAccountID(multiExchangeReqMeta_internalTmp.tradingAcntID);
            order.setExecBrokerID(multiExchangeReqMeta_internalTmp.execBrokerID);
            orderRequestBean.getOmsMsgHeader().setLoginID(1471);
            System.out.println("======placing exchange:" + order.getExchange());
        }

//        order.setTradingAccountId(5);
//        System.out.println("=== Trading accnt id:" + order.getTradingAccountId());
//        order.setTradingAccountId(262);
        order.setMarketCode(MKT_CODE_ALL);
//        order.setExecBrokerID(execBrokerID);
        order.setAction(OMSConst.ORDER_ACTION_NEW);
        order.setTIF(FIX.T59_DAY);
      //  order.setOrderMode(OMSConst.ORDER_MODE_NORMAL);
        order.setPriceInstType(FIX.T167_INSTRUMENT_BOND);
        if (orderChannel == OMSConst.CHANNEL_DT) {
            order.setDealerID(dealerID);
        }
        order.setDealerID(orderParams.getDealerID());
        if (FIX.T40_LIMIT == order.getType()) {
            order.setPrice(price);
        }
        order.setUnqReqId(Long.toString(System.nanoTime()));
        if (isNotInSkippedList(order.getTradingAccountID())) {
            System.out.println(" Request with trading id:" + order.getTradingAccountID() + " skipped.");
            return null;
        }
        String jsonResponse = jsonHandler.getJSonString(orderRequestBean);
        System.out.println("\n Order Request: cashAcntID:" + order.getCashAcntID() + ",trdAcntId:" + order.getTradingAccountID() + ":" + requestSequence);
        return jsonResponse;
    }

    private String generateAmendOrderRequest(Order order) {
        int orderChannel = OMSConst.CHANNEL_WEB;   //DT-1, AT-3
        OrderRequestBean orderRequestBean = new OrderRequestBean();
        orderRequestBean.getOmsMsgHeader().setRequestType(OMSConst.SERVICE_ID_CREATE_ORDER_CHANGE);
        orderRequestBean.getOmsMsgHeader().setChannel(orderChannel);
        orderRequestBean.getOmsMsgHeader().setUnqReqId(Integer.toString(1));
        orderRequestBean.setOrder(order);
        order.setTenantCode(OMSConst.DEFAULT_TENANCY_CODE);
        order.setOrderMode(OMSConst.ORDER_MODE_NORMAL);
        order.setType(FIX.T40_LIMIT);//1:Market,2:Limit
        order.setQuantity(orderQty);
        if (orderQty <= 0) {
            order.setQuantity(qty);
        }
        order.setCustomerID(customerID);
        order.setSide(FIX.T54_BUY);//1:Buy,2:Sell
        order.setSymbol(SYMBOL_1010);
        order.setExchange(EXCHANGE_TDWL);
        order.setTradingAccountID(2);
        orderRequestBean.getOmsMsgHeader().setLoginID(1471); //for the timebeing tradingAcntID=loginID mapping is exist in DB
        order.setMarketCode(MKT_CODE_ALL);
        order.setExecBrokerID(execBrokerID);
        order.setAction(OMSConst.ORDER_ACTION_CHANGE);
        order.setTIF(FIX.T59_DAY);
        order.setOrderMode(OMSConst.ORDER_MODE_NORMAL);
        order.setPriceInstType(FIX.T167_INSTRUMENT_BOND);
        if (orderChannel == OMSConst.CHANNEL_DT) {
            order.setDealerID(dealerID);
        }
        if (FIX.T40_LIMIT == order.getType()) {
            order.setPrice(price);
        }
        order.setUnqReqId(Long.toString(System.nanoTime()));
        String jsonResponse = jsonHandler.getJSonString(orderRequestBean);
        System.out.println("\n Amend Request: OrigClOrdId:" + order.getOrigClOrdID() + "cashAcntID:" + order.getCashAcntID() + ",trdAcntId:" + order.getTradingAccountID());
        return jsonResponse;
    }

    private String generateResendOrderRequest(Order order) {
        int orderChannel = 12;   //DT-1, AT-3
        OrderRequestBean orderRequestBean = new OrderRequestBean();
        orderRequestBean.getOmsMsgHeader().setRequestType(OMSConst.SERVICE_ID_RESEND_ORDER);
        orderRequestBean.getOmsMsgHeader().setChannel(orderChannel);
        orderRequestBean.getOmsMsgHeader().setUnqReqId(Integer.toString(1));
        orderRequestBean.setOrder(order);
        order.setUnqReqId(Long.toString(System.nanoTime()));
        String jsonResponse = jsonHandler.getJSonString(orderRequestBean);
        System.out.println("\n Cancel Request: OrigClOrdId:" + order.getOrigClOrdID() + "cashAcntID:" + order.getCashAcntID() + ",trdAcntId:" + order.getTradingAccountID());
        return jsonResponse;
    }

    private String generateCancelOrderRequest(Order order) {
        int orderChannel = OMSConst.CHANNEL_WEB;   //DT-1, AT-3
        OrderRequestBean orderRequestBean = new OrderRequestBean();
        orderRequestBean.getOmsMsgHeader().setRequestType(OMSConst.SERVICE_ID_CREATE_ORDER_CANCEL);
        orderRequestBean.getOmsMsgHeader().setChannel(orderChannel);
        orderRequestBean.getOmsMsgHeader().setUnqReqId(Integer.toString(1));
        orderRequestBean.setOrder(order);
        order.setTenantCode(OMSConst.DEFAULT_TENANCY_CODE);
        order.setOrderMode(OMSConst.ORDER_MODE_NORMAL);
        order.setType(FIX.T40_LIMIT);//1:Market,2:Limit // for TIF validation against mktStatus

        order.setCustomerID(customerID);
        order.setSide(FIX.T54_BUY);//1:Buy,2:Sell
        order.setSymbol(SYMBOL_1010);
        order.setExchange(EXCHANGE_TDWL);
        order.setTradingAccountID(2);
        orderRequestBean.getOmsMsgHeader().setLoginID(1471); //for the timebeing tradingAcntID=loginID mapping is exist in DB
        order.setMarketCode(MKT_CODE_ALL);
        order.setExecBrokerID(execBrokerID);
        order.setAction(OMSConst.ORDER_ACTION_CANCEL);
        if (orderChannel == OMSConst.CHANNEL_DT) {
            order.setDealerID(dealerID);
        }
        order.setUnqReqId(Long.toString(System.nanoTime()));
        String jsonResponse = jsonHandler.getJSonString(orderRequestBean);
        System.out.println("\n Cancel Request: OrigClOrdId:" + order.getOrigClOrdID() + "cashAcntID:" + order.getCashAcntID() + ",trdAcntId:" + order.getTradingAccountID());
        return jsonResponse;
    }

    private void populateApproveOrderRequest(boolean clearAndPopulate, int status, String clOrdID) {
        if (clearAndPopulate) {
            requestList.clear();
        }
        OrderApproveRequestBean approveRequestBean = new OrderApproveRequestBean();
        approveRequestBean.getOmsMsgHeader().setRequestType(OMSConst.SERVICE_ID_APROVE_ORDER);
        approveRequestBean.getOmsMsgHeader().setChannel(OMSConst.CHANNEL_DT);
        approveRequestBean.setClOrdID(clOrdID);
        approveRequestBean.setStatus(status);
        approveRequestBean.setApprovedBy(Integer.parseInt(dealerID));
        String request = jsonHandler.getJSonString(approveRequestBean);
        requestList.add(request);
    }


    private String generateRequest(Order order, int requestType, int requestSequence, int cashAcntID) {
        String request = null;
        switch (requestType) {
            case OMSConst.SERVICE_ID_CREATE_ORDER_NEW:
                request = generateOrderRequest(order, requestSequence, cashAcntID);
                break;
            case OMSConst.SERVICE_ID_CREATE_ORDER_CHANGE:
                request = generateAmendOrderRequest(order);
                break;
            case OMSConst.SERVICE_ID_CREATE_ORDER_CANCEL:
                request = generateCancelOrderRequest(order);
                break;
            case OMSConst.SERVICE_ID_RESEND_ORDER:
                request = generateResendOrderRequest(order);
                break;
            case 9:
                MultiExchangeReqMeta_InternalTmp multiExchangeReqMeta_internalTmp11 = new MultiExchangeReqMeta_InternalTmp();
                multiExchangeReqMeta_internalTmp11.symbol = "1010";
                multiExchangeReqMeta_internalTmp11.exchange = "TDWL";
                multiExchangeReqMeta_internalTmp11.tradingAcntID = 2;
                multiExchangeReqMeta_internalTmp11.loginID = 2;
                multiExchangeReqMeta_internalTmp11.execBrokerID = 1;
                MultiExchangeReqMeta_InternalTmp multiExchangeReqMeta_internalTmp12 = new MultiExchangeReqMeta_InternalTmp();
                multiExchangeReqMeta_internalTmp12.symbol = "EMAAR";
                multiExchangeReqMeta_internalTmp12.exchange = "DFM";
                multiExchangeReqMeta_internalTmp12.tradingAcntID = 3932;
                multiExchangeReqMeta_internalTmp12.loginID = 64;
                multiExchangeReqMeta_internalTmp12.execBrokerID = 10;
                MultiExchangeReqMeta_InternalTmp multiExchangeReqMeta_internalTmp13 = new MultiExchangeReqMeta_InternalTmp();
                multiExchangeReqMeta_internalTmp13.symbol = "ADCB";
                multiExchangeReqMeta_internalTmp13.exchange = "ADSM";
                multiExchangeReqMeta_internalTmp13.tradingAcntID = 3935;
                multiExchangeReqMeta_internalTmp13.loginID = 64;
                multiExchangeReqMeta_internalTmp13.execBrokerID = 99;
//                return generateOrderRequest(order, requestSequence);
                List<MultiExchangeReqMeta_InternalTmp> mExgList = new ArrayList<>();
                mExgList.add(multiExchangeReqMeta_internalTmp11);
                mExgList.add(multiExchangeReqMeta_internalTmp12);
                mExgList.add(multiExchangeReqMeta_internalTmp13);
                request = generateOrderRequest(order, requestSequence, mExgList, -1);
                break;
            case OMSConst.SERVICE_ID_ORDER_LIST:
                request = generateOrderInquiryRequest();
                break;
            case -2:
                request = statGatherRequest(StatGatherPersistHandler_InternalTmp.ACTION_REGROUP_AND_PERSIST);
                break;
            case -3:
                request = statGatherRequest(StatGatherPersistHandler_InternalTmp.ACTION_REINIT);
                break;
            default:
                request = statGatherRequest(StatGatherPersistHandler_InternalTmp.ACTION_REGROUP_AND_PERSIST);
                break;
        }
        if (request != null) {
            populatedRequestsCount++;
        }
        return request;
    }

    private String generateOrderInquiryRequest() {
        OrderInquiryBean orderInquiryRequest = new OrderInquiryBean();
        orderInquiryRequest.getOmsMsgHeader().setRequestType(OMSConst.SERVICE_ID_ORDER_LIST);
        return jsonHandler.getJSonString(orderInquiryRequest);
    }


    private String statGatherRequest(int statMonRequestType) {
        StatMonReqResBean statMonReqResBean = new StatMonReqResBean();
        statMonReqResBean.getOmsMsgHeader().setRequestType(OMSConst.SERVICE_ID_STAT_MON);
        statMonReqResBean.setAction(statMonRequestType);
        return jsonHandler.getJSonString(statMonReqResBean);
    }
}

