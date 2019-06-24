package com.dfn.oms.newgen.testClientUI.bean;

import com.dfn.oms.newgen.testClientUI.UserController1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
public class WebClientDB {
    public class MultiExchangeReq_InternalTmp {
        private String symbol;
        private String exchange;
        private int tradingAcntID;
        private int loginID;
        private int execBrokerID;
    }

    public class DatabaseEntries {
        private int loginID;
        private int cashAcntID;
        private int tradingAcntID;
    }

    private static JSONHandler jsonHandler = new JSONHandler();
    private static List<String> requestList = new ArrayList<>();
    BufferedReader bufferedReader;
    FileReader fileReader;
    private static String currentAction;
    private int orderQty;
    private static final String EXCHANGE_TDWL = "TDWL";
    private static final String SYMBOL_1010 = "1010";
    private static final String MKT_CODE_ALL = "ALL";
    private static double price = 5.00;
    private static final int qty = 1;
    private static final int customerID = 270;
    private static final String dealerID = "1471";
    private static final int execBrokerID = 1;
    private static int populatedRequestsCount = 1;
    private String textLocation;

    public WebClientDB.MultiExchangeReq_InternalTmp multiExchangeReq_internalTmp;

    public WebClientDB(String textLocation) {
        this.textLocation = textLocation;
    }


    public static JSONHandler getJsonHandler() {
        return jsonHandler;
    }

    public static void setJsonHandler(JSONHandler jsonHandler) {
        WebClientDB.jsonHandler = jsonHandler;
    }

    public static List<String> getRequestList() {
        return requestList;
    }

    public static void setRequestList(List<String> requestList) {
        WebClientDB.requestList = requestList;
    }

    public static String getCurrentAction() {
        return currentAction;
    }

    public static void setCurrentAction(String currentAction) {
        WebClientDB.currentAction = currentAction;
    }

    public static String getExchangeTdwl() {
        return EXCHANGE_TDWL;
    }

    public static String getSymbol1010() {
        return SYMBOL_1010;
    }

    public static String getMktCodeAll() {
        return MKT_CODE_ALL;
    }

    public static double getPrice() {
        return price;
    }

    public static void setPrice(double price) {
        WebClientDB.price = price;
    }

    public static int getQty() {
        return qty;
    }

    public static int getCustomerID() {
        return customerID;
    }

    public static String getDealerID() {
        return dealerID;
    }

    public static int getExecBrokerID() {
        return execBrokerID;
    }

    public static int getPopulatedRequestsCount() {
        return populatedRequestsCount;
    }

    public static void setPopulatedRequestsCount(int populatedRequestsCount) {
        WebClientDB.populatedRequestsCount = populatedRequestsCount;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public WebClientDB.MultiExchangeReq_InternalTmp getMultiExchangeReqMeta_internalTmp() {
        return multiExchangeReq_internalTmp;
    }

    public void setMultiExchangeReqMeta_internalTmp(WebClientDB.MultiExchangeReq_InternalTmp multiExchangeReq_internalTmp) {
        this.multiExchangeReq_internalTmp = multiExchangeReq_internalTmp;
    }

    public void populateRequests(boolean clearAndPopulate, int requestsCount, int requestType, ArrayList<DatabaseEntries> databaseEntries) {

        if (clearAndPopulate) {
            requestList.clear();
        }
        populatedRequestsCount = 0;
        Order order = new Order();
        List<String> duplicateRequest = new ArrayList<>();//to improve memory/performance
        String request;
        int counter = 0;
        List cashAccountsList = null;
        int cashAccountsCounter = 0;
        DatabaseEntries databaseEntries1 = null;


        while (requestsCount > 0) {
            if (cashAccountsList != null && counter > databaseEntries.size()) {//300 is number or unique requests
                String requestReplay = duplicateRequest.get(requestsCount % (populatedRequestsCount - 1));
                if (requestReplay != null) {
                    requestList.add(requestReplay);
                }
            } else {

                if (databaseEntries != null && databaseEntries.size() > 0) {
                    databaseEntries1 = databaseEntries.get(cashAccountsCounter);
                    cashAccountsCounter++;
                    if (cashAccountsCounter >= databaseEntries.size()) {
                        cashAccountsCounter = 0;
                    }
                }
                request = generateRequest(order, requestType, requestsCount, databaseEntries1);
                if (request != null) {
                    requestList.add(request);
                    duplicateRequest.add(request);
                }
            }
            counter++;
            requestsCount--;
        }

    }

    private String generateRequest(Order order, int requestType, int requestSequence, DatabaseEntries databaseEntries) {
        String request = null;
        switch (requestType) {
            case OMSConst.SERVICE_ID_CREATE_ORDER_NEW:
                request = generateOrderRequest(order, requestSequence, databaseEntries);
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

    private String generateOrderRequest(Order order, int requestSequence, DatabaseEntries databaseEntries) {
        return generateOrderRequest(order, requestSequence, null, databaseEntries);
    }

    private String statGatherRequest(int statMonRequestType) {
        StatMonReqResBean statMonReqResBean = new StatMonReqResBean();
        statMonReqResBean.getOmsMsgHeader().setRequestType(OMSConst.SERVICE_ID_STAT_MON);
        statMonReqResBean.setAction(statMonRequestType);
        return jsonHandler.getJSonString(statMonReqResBean);
    }


    private String generateOrderRequest(Order order, int requestSequence,
                                        List<WebClientDB.MultiExchangeReq_InternalTmp> multiExchangeReq_internalTmps, DatabaseEntries databaseEntries) {
        OrderParams orderParams = UserController1.parameterRepository.findById((long) UserController1.parameterRepository.count()).get();
        System.out.println(orderParams.getOrderChannel() );
        System.out.println(orderParams.getPrice());
        System.out.println(orderParams.getType() );
        System.out.println(orderParams.getSymbol() );
        System.out.println(orderParams.getTenantCode() );
        System.out.println(orderParams.getMarketCode() );
        System.out.println(orderParams.getExchange() );


        int orderChannel = orderParams.getOrderChannel();   //DT-1, AT-3
        OrderRequestBean orderRequestBean = new OrderRequestBean();
        orderRequestBean.getOmsMsgHeader().setRequestType(OMSConst.SERVICE_ID_CREATE_ORDER_NEW);
        orderRequestBean.getOmsMsgHeader().setChannel(orderChannel);
//        orderRequestBean.getOmsMsgHeader().setLoginID(customerID);
        long startTime = LocalDateTime.now().getMinute();
        String uniqueID = String.valueOf(startTime) + "_" + String.valueOf(requestSequence);
        orderRequestBean.getOmsMsgHeader().setUnqReqId(uniqueID);
        orderRequestBean.setOrder(order);
        order.setTenantCode(OMSConst.DEFAULT_TENANCY_CODE);
        order.setTenantCode(orderParams.getTenantCode());
        order.setOrderMode(OMSConst.ORDER_MODE_NORMAL);
        order.setOrderMode(orderParams.getOrderMode());
        order.setType(FIX.T40_LIMIT);//1:Market,2:Limit
        order.setType(orderParams.getType().charAt(0));
        order.setQuantity(orderQty);
        if (orderQty <= 0) {
            order.setQuantity(qty);
        }
//        order.setCustomerID(customerID);
        order.setCustomerID(requestSequence);
        order.setSide(FIX.T54_BUY);//1:Buy,2:Sell
        order.setSide(orderParams.getSide());
        order.setCashAcntID(databaseEntries.cashAcntID);
        if (multiExchangeReq_internalTmps == null || multiExchangeReq_internalTmps.size() == 0) {
            order.setSymbol(SYMBOL_1010);
            order.setSymbol(orderParams.getSymbol());
            order.setExchange(EXCHANGE_TDWL);
            order.setExchange(orderParams.getExchange());
//            order.setTradingAccountID((requestSequence % 298) + 1);
            order.setTradingAccountID(databaseEntries.tradingAcntID);
            order.setExecBrokerID(execBrokerID);
            orderRequestBean.getOmsMsgHeader().setLoginID(Integer.parseInt(dealerID)); //since testing was done for DT user sdealer
            // id is set as login id this value can be get from text reading
        } else {
            int index = requestSequence % (multiExchangeReq_internalTmps.size());
            multiExchangeReq_internalTmp = multiExchangeReq_internalTmps.get(index);
            order.setSymbol(multiExchangeReq_internalTmp.symbol);
            order.setExchange(multiExchangeReq_internalTmp.exchange);
            order.setTradingAccountID(multiExchangeReq_internalTmp.tradingAcntID);
            order.setExecBrokerID(multiExchangeReq_internalTmp.execBrokerID);
            orderRequestBean.getOmsMsgHeader().setLoginID(multiExchangeReq_internalTmp.loginID);
            System.out.println("======placing exchange:" + order.getExchange());
        }

//        order.setTradingAccountId(5);
//        System.out.println("=== Trading accnt id:" + order.getTradingAccountId());
//        order.setTradingAccountId(262);
        order.setMarketCode(MKT_CODE_ALL);
//        order.setExecBrokerID(execBrokerID);
        order.setAction(OMSConst.ORDER_ACTION_NEW);
        order.setTIF(FIX.T59_DAY);
        order.setOrderMode(OMSConst.ORDER_MODE_NORMAL);
        order.setPriceInstType(FIX.T167_INSTRUMENT_BOND);
        if (orderChannel == OMSConst.CHANNEL_DT) { //channel id set for DT value 12
            order.setDealerID(dealerID);
        }
        if (FIX.T40_LIMIT == order.getType()) {
            order.setPrice(price);
        }
        order.setUnqReqId(Long.toString(System.nanoTime()));
        if (isNotInSkippedList(order.getTradingAccountID())) {
            System.out.println(" Request with trading id:" + order.getTradingAccountID() + " skipped.");
            return null;
        }
        String jsonResponse = jsonHandler.getJSonString(orderRequestBean);
       // System.out.println("\n Order Request: cashAcntID:" + order.getCashAcntID() + ",trdAcntId:" + order.getTradingAccountID() + ":" + requestSequence);
        return jsonResponse;
    }

    private boolean isNotInSkippedList(int count) {
        if (WebSocketRunner.tradeIDSkipped != null) {
            return WebSocketRunner.tradeIDSkipped.contains(count + "");
        }
        return false;
    }

    public boolean inputCommandLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*******************  V 0.0.2 ***********************************");
        System.out.println("*******************  Skipped Trading Account IDS:" + System.getProperty(WebSocketRunner.SYS_PROPERTY_SKIPPED_TRD_IDS) + " ***********************************");
        System.out.println("******************* Connect to gateway:" + WebSocketRunnerSetting.isGWClient + "," +
                " EntPoint(WebSocket) Count:" + WebSocketRunnerSetting.numOfEndPoints);
        Integer totalEntries;
        ArrayList<DatabaseEntries> readDetails;
        System.out.println("******************* IS Timed orders flag set(ORDERS_PER_TIME_SLICE):" + System.getProperty("ORDERS_PER_TIME_SLICE") + " , Ex. 100:5 (i.e 100 orders per 5 seconds)");
        readDetails = readCustomerDetails(textLocation);
        System.out.print("\nSelect Action  : c(2:CreateOrders\n3:Amend Order\n4:Cancel Order\n" +
                "7:Order List\n-2:Stat Gather,ReGrp,Persist\n-3:Stat Clear,\n-4:Print Rest Response,\n5:JMS MSG SEND\n9:CreateOrders For DefinedExchanges\n21:Approve Order\n42:Resend Order\nDefault:Print) :- ");

        String action = "2";

        currentAction = action;

        if (action.trim().equals(Integer.toString(OMSConst.SERVICE_ID_CREATE_ORDER_NEW)) || action.trim().equals("9")) {
            System.out.print("Number of orders:");
            System.out.println(UserController1.userRepository1.findById((long) UserController1.userRepository1.count()).get().getNoOfOrders() );
            System.out.print("Order Quantity:");
            System.out.println(UserController1.userRepository1.findById((long) UserController1.userRepository1.count()).get().getOrderQty());
            try {
                orderQty = UserController1.userRepository1.findById((long) UserController1.userRepository1.count()).get().getOrderQty();
            } catch (NumberFormatException e) {

            }
            populateRequests(true, UserController1.userRepository1.findById((long) UserController1.userRepository1.count()).get().getNoOfOrders(), Integer.parseInt(action), readDetails);
        }
        return true;
    }

    public ArrayList<DatabaseEntries> readCustomerDetails(String path) {
        ArrayList<DatabaseEntries> databaseEntriesObjects = new ArrayList<>();
        try {
            String line = null;
            File file = new File(path);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "\t");
                DatabaseEntries databaseEntries = new DatabaseEntries();
                databaseEntries.loginID = Integer.parseInt(st.nextToken());
                databaseEntries.cashAcntID = Integer.parseInt(st.nextToken());
                databaseEntries.tradingAcntID = Integer.parseInt(st.nextToken());
                databaseEntriesObjects.add(databaseEntries);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File Read Exception...: " + e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.err.println("File Close Exception...: " + e);
                }
            }
        }
        return databaseEntriesObjects;
    }

}
