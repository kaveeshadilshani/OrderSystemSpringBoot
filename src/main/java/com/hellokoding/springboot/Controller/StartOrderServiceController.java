package com.hellokoding.springboot.Controller;

import com.hellokoding.springboot.HelloController;
import com.hellokoding.springboot.Service.IOrderService;
import com.hellokoding.springboot.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.hellokoding.springboot.HelloController.hash_map;
import static com.hellokoding.springboot.HelloController.hash_map_readtext;

@RestController
public class StartOrderServiceController {
    @Autowired
    IOrderService orderService;

    String action;
    //@ModelAttribute
   // @RequestMapping(value = "/startOrder")
    public String startOrder(ModelMap model) {

        WebSocketRunner webSocketRunner = new WebSocketRunner();
        String textLocation = (webSocketRunner.TEXT_PATH);

        //String check=this.getWithText();
        TextRead textRead =new TextRead();
        String checkReadText=textRead.getWithTextRead();
        if (textLocation != null) {
            //Scanner scanner = new Scanner(System.in);

            System.out.println("\nPlace Order : \n1) With Text Reading\n2) Without Text Reading");
            action = "1";
            webSocketRunner.currentAction = action;
            System.out.println(hash_map_readtext.get("readText"));
        }
        if (hash_map_readtext.get("readText").equals("1")) {

            webSocketRunner.operatingMethod = true;

        } else {

            webSocketRunner.operatingMethod = false;
        }
        System.out.println(webSocketRunner.operatingMethod);
        boolean threadStatus = true;
        try {
//            String restrictedTrdIDS = System.getProperty(webSocketRunner.SYS_PROPERTY_SKIPPED_TRD_IDS);
//            if (restrictedTrdIDS != null) {
//                webSocketRunner.tradeIDSkipped = Arrays.asList(restrictedTrdIDS.split(","));
//            }
            //Args have to be declared
          //  String []args = new String[10];
           // WebSocketRunnerSetting settings = new WebSocketRunnerSetting();
            //=processArgs(args);


//            settings.setIp("192.168.17.3");
//            settings.setPort(4545);
//            settings.setGWClient(false);
//            settings.setNumOfEndPoints(1);
            List<WebSocketClientEndPoint> clientEndPoints = populateEndPoints(hash_map.get("sett"));
            int sentCount;
            String orderPerTimeSLice = "700:1";
            int a=1;
            if (orderPerTimeSLice != null) {
                String orderPerSlice = orderPerTimeSLice.split(":")[0];
                String timePeriod = orderPerTimeSLice.split(":")[1];
                int ordersPerSec = Integer.parseInt(orderPerSlice);
                int i = 0;
                long timeSpread = 0;
                long startTime = System.currentTimeMillis();
                long timePeriodForOrders = Long.parseLong(timePeriod) * 2000;
                System.out.println("== Placing timed orders, Order per period:" + orderPerSlice + ", period(Seconds):" + timePeriod);
                int orderLoopCount = 0;
                while (threadStatus && a==1) {
                    if (webSocketRunner.operatingMethod) {
                        System.out.println("jdgf");
                        WebClientDB webClientDB_internalTemp = new WebClientDB(textLocation);
                        webSocketRunner.status = webClientDB_internalTemp.inputCommandLine();
                        webSocketRunner.requestList = webClientDB_internalTemp.getRequestList();
                    } else {
                        System.out.println("not");
                        WebClientUtils webClientUtilsInternalTmp = new WebClientUtils();
                        webSocketRunner.status = webClientUtilsInternalTmp.processCommandLind();
                        webSocketRunner.requestList = WebClientUtils.getRequestList();
                    }
                    if (webSocketRunner.status) {
                        for (int j = 0; j < webSocketRunner.requestList.size(); j++) {
                            i++;
                            String s = webSocketRunner.requestList.get(j);
                            orderLoopCount++;
                            if (hash_map.get("sett").getNumOfEndPoints() > 1) {
                                clientEndPoints.get(j % hash_map.get("sett").getNumOfEndPoints()).sendMessage(s);
                                model.addAttribute("ms1",s);
                            } else {
                                clientEndPoints.get(0).sendMessage(s);
                                model.addAttribute("ms2",s);
                            }
                            if (i >= ordersPerSec) {
                                timeSpread = System.currentTimeMillis() - startTime;
                                if (timeSpread < timePeriodForOrders) {
                                    Thread.sleep(timePeriodForOrders - timeSpread); //sleep time time period per orders is reached
                                }
                                i = 0; // reInit order count
                                startTime = System.currentTimeMillis(); //re init time spread calc
                            }
                        }
                    }
                    a++;
                    webSocketRunner.requestList.clear();
                    System.out.println("\n Request sent count:" + orderLoopCount + "\n\n\n");
                    //logger.info("LN:138", "==Orders placed:" + orderLoopCount);
                    if (orderLoopCount >= Integer.MAX_VALUE) {
                        threadStatus = false;
                    }

                }

            } else {
                while (threadStatus) {
                    sentCount = 0;
                    if (webSocketRunner.operatingMethod) {
                        WebClientDB webClientDB_internalTemp = new WebClientDB(textLocation);
                        webSocketRunner.status = webClientDB_internalTemp.inputCommandLine();
                        webSocketRunner.requestList = webClientDB_internalTemp.getRequestList();
                    } else {
                        WebClientUtils webClientUtilsInternalTmp = new WebClientUtils();
                        webSocketRunner.status = webClientUtilsInternalTmp.processCommandLind();
                        webSocketRunner.requestList = WebClientUtils.getRequestList();
                    }
                    WebSocketClientEndPoint.responseCount = 0;
                    if (webSocketRunner.status) {
                        for (int i = 0; i < webSocketRunner.requestList.size(); i++) {
                            String s = webSocketRunner.requestList.get(i);
//                        System.out.println(" Message "+ i + " : "+ s);
                            if (hash_map.get("sett").getNumOfEndPoints() > 1) {
                                clientEndPoints.get(i % hash_map.get("sett").getNumOfEndPoints()).sendMessage(s);
                                model.addAttribute("ms3",s);
                            } else {
                                clientEndPoints.get(0).sendMessage(s);
                                model.addAttribute("ms4",s);
                            }
                            sentCount++;
                        }
                        webSocketRunner.requestList.clear();
                    }
                    System.out.println("\n Request sent count:" + sentCount + "\n\n\n");
                  //  logger.info("LN:172", "==Orders placed:" + sentCount);
                    if (sentCount >= Integer.MAX_VALUE) {
                        threadStatus = false;
                    }
                }
            }



        } catch (Exception ex) {
            System.err.println("client exception...: " + ex);
        }return "order";
    }


    public static WebSocketRunnerSetting processArgs(String args[]) {
        WebSocketRunnerSetting settings = new WebSocketRunnerSetting();
        if (args != null && args.length > 0) {
            settings.setIp(args[0]);
            if (args.length > 1) {
                settings.setPort(Integer.parseInt(args[1]));
            }
            try {
                settings.setGWClient(Boolean.parseBoolean(args[2]));
            } catch (Exception e) {
                settings.setGWClient(false);
            }
            try {
                settings.setNumOfEndPoints(Integer.parseInt(args[3]));
            } catch (Exception e) {
                settings.setNumOfEndPoints(1);
            }
        }
        return settings;
    }

    public static List<WebSocketClientEndPoint> populateEndPoints(WebSocketRunnerSetting settings) throws Exception {
        System.out.println("\nNumber of end points:" + settings.getNumOfEndPoints());
        List<WebSocketClientEndPoint> clientEndPoints = new ArrayList<WebSocketClientEndPoint>();
        if (!settings.isGWClient()) {//web socket
            System.out.println("\n Connecting to :" + settings.getIp() + ":" + settings.getPort());
            for (int i = 0; i < settings.getNumOfEndPoints(); i++) {
                 WebSocketClientEndPoint clientEndPoint = new WebSocketClientEndPoint(new URI("ws://"
                        + settings.getIp() + ":" + settings.getPort() + "/OMSRestConnect/WebSocketServices"));
                clientEndPoints.add(clientEndPoint);

                clientEndPoint.addMessageHandler(new WebSocketClientEndPoint.MessageHandler() {
                    @Override
                    public void handleMessage(String message) {
                        System.out.println("\n Response:" + message);
                    }
                });
            }
        } else {//rest
            System.out.println("\n Connecting to :" + "ws://127.0.0.1:9080/streaming-api");
            WebSocketClientEndPoint clientEndPoint = new WebSocketClientEndPoint(new URI("ws://127.0.0.1:9080/streaming-api"));
            clientEndPoints.add(clientEndPoint);
            clientEndPoint.addMessageHandler(new WebSocketClientEndPoint.MessageHandler() {
                @Override
                public void handleMessage(String message) {
                    System.out.println("\n Response:" + message);
                }
            });
        }
        return clientEndPoints;
    }

    //@RequestMapping(value = "/withText")
    public String getWithText(){
       return orderService.chooseWithTextOrNot();


    }









}
