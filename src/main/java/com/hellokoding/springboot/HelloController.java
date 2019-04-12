package com.hellokoding.springboot;

import com.hellokoding.springboot.Controller.StartOrderServiceController;
import com.hellokoding.springboot.bean.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import java.net.URI;
import java.util.*;
import java.util.Map;

@Controller
public class HelloController {

    public  Map<String,WebSocketRunnerSetting> modelMap ;
    public static HashMap<String,WebSocketRunnerSetting> hash_map = new HashMap<String,WebSocketRunnerSetting>();
    public static HashMap<String,String> hash_map_readtext = new HashMap<String,String>();

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
    @RequestMapping("/test")
    @ResponseStatus(value = HttpStatus.OK)
    public void test() {

    }

    @RequestMapping("/order")
    public String order(Model model, @RequestParam(value="order", required=false, defaultValue="served") String order) {
        model.addAttribute("order", order);
        return "order";
    }
    @RequestMapping("/withoutText")
    public String withoutText(Model model, @RequestParam(value="order", required=false, defaultValue="served") String order) {
        model.addAttribute("order", order);
        return "WithTextOrWithoutText";
    }
    @RequestMapping("/withText")
    public String withText(Model model, @RequestParam(value="order", required=false, defaultValue="served") String order) {
        model.addAttribute("order", order);
        return "WithTextOrWithoutText";
    }
    @RequestMapping("/message")
   // @ResponseBody
    //@ModelAttribute
    @ResponseStatus(value = HttpStatus.OK)
    public void processForm(@PathVariable("with")  String with,
                              Model model) {
        if("on".equals(with)){
            hash_map_readtext.put("readText","1");
        }
        else{
            hash_map_readtext.put("readText","2");
        }
        System.out.println(hash_map_readtext.get("readText"));
        System.out.println(with);

       // return "WithTextOrWithoutText";
    }
    //@ModelAttribute
    @RequestMapping("/arguments")
    // @ResponseBody

    public String SetArguments(@RequestParam(required = true) String ip,
                              @RequestParam(required = true) int port,
                               @RequestParam(required = false) int noOfEndPoints,
                               @RequestParam(required = false) String GWClient,
                               Model model) {

       WebSocketRunnerSetting settings = new WebSocketRunnerSetting();
        settings.setIp(ip);
        settings.setPort(port);
       settings.setNumOfEndPoints(noOfEndPoints);
       settings.setGWClient("on".equals(GWClient)?true:false);
       // StartOrderServiceController sosc =new StartOrderServiceController();
        //model.addAttribute("settings",settings);
        hash_map.put("sett",settings);
        model.addAttribute("ip",settings.getIp());
        model.addAttribute("port",settings.getPort());
        //sosc.startOrder();
        return "nextView";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome!");
    }
    @RequestMapping("/next")
    public String next() {

        return "createOrder";
    }

    @RequestMapping("/createOrder")
    // @ResponseBody
    //@ModelAttribute
    public String createOrder(@RequestParam(required = false) String createOrders,
                              @RequestParam(required = false) String amendOrders,
                              @RequestParam(required = false) String cancelOrders,
                              @RequestParam(required = false) String resendOrders,
                              @RequestParam(required = false) String createForDefined) {

        String readParam = "on".equals(createForDefined) ? "9" : "0";
        switch (readParam){
            case "9":hash_map_readtext.put("readParam","9");
           // case "2":hash_map_readtext.put("readText","2");
        }


        return "defineOrder";
    }

    @RequestMapping("/parameters")
    // @ResponseBody
    //@ModelAttribute
    public String setParameters(@RequestParam(required = false) String noOfOrders,
                              @RequestParam(required = false) String orderQty,Model model
                             ) {

        hash_map_readtext.put("noOfOrders",noOfOrders);
        hash_map_readtext.put("orderQty",orderQty);

model.addAttribute("noOfOrders",noOfOrders);
model.addAttribute("orderQty",orderQty);
        return "Final";
    }

    String action;
    //@ModelAttribute
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/startOrder")
    public String startOrder() {

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
       // if (hash_map_readtext.get("readText").equals("1")) {
        if(action=="1"){

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
             WebSocketRunnerSetting settings = new WebSocketRunnerSetting();
            //=processArgs(args);

            settings.setIp("192.168.16.67");
            settings.setPort(4545);
            settings.setGWClient(false);
            settings.setNumOfEndPoints(1);
            List<WebSocketClientEndPoint> clientEndPoints = populateEndPoints(settings);
            int sentCount;
            String orderPerTimeSLice = "700:1";
            int a=1;
            if (orderPerTimeSLice != null) {
                String orderPerSlice = orderPerTimeSLice.split(":")[0];
                String timePeriod = orderPerTimeSLice.split(":")[1];
                int ordersPerSec = Integer.parseInt(orderPerSlice);
                int i = 0;
                long timeSpread = 0;
                List<String> msgs= new ArrayList<>();
                long startTime = System.currentTimeMillis();
                long timePeriodForOrders = Long.parseLong(timePeriod) * 2000;
                System.out.println("== Placing timed orders, Order per period:" + orderPerSlice + ", period(Seconds):" + timePeriod);
                int orderLoopCount = 0;
                while (threadStatus && a==1) {
                    if (webSocketRunner.operatingMethod) {
                        WebClientDB webClientDB_internalTemp = new WebClientDB(textLocation);
                        webSocketRunner.status = webClientDB_internalTemp.inputCommandLine();
                        webSocketRunner.requestList = webClientDB_internalTemp.getRequestList();
                    } else {
                        WebClientUtils webClientUtilsInternalTmp = new WebClientUtils();
                        webSocketRunner.status = webClientUtilsInternalTmp.processCommandLind();
                        webSocketRunner.requestList = WebClientUtils.getRequestList();
                    }
                    if (webSocketRunner.status) {
                        for (int j = 0; j < webSocketRunner.requestList.size(); j++) {
                            i++;
                            String s = webSocketRunner.requestList.get(j);

                            msgs.add(s);


                            orderLoopCount++;
                            //if (hash_map.get("sett").getNumOfEndPoints() > 1) {
                            if(settings.getNumOfEndPoints()>1){
                                clientEndPoints.get(j % settings.getNumOfEndPoints()).sendMessage(s);
                            } else {
                                clientEndPoints.get(0).sendMessage(s);
                                System.out.println("\n just checking");
                                WebSocketClientEndPoint clientEndPoint2 = new WebSocketClientEndPoint(new URI("ws://127.0.0.1:8080/endpoint"));
//                                clientEndPoint2.addMessageHandler(new WebSocketClientEndPoint.MessageHandler() {
//                                    @Override
//                                    public void handleMessage(String message) {
//
//                                        System.out.println("\n Response22:" + message);
//                                    }
//                                });
//                                clientEndPoint2.sendMessage(s);
//                                clientEndPoint2.onMessage(s);
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
                      //  model.addAttribute("msgs",msgs);
                    }
                    a++;
                    threadStatus = false;
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
                            if (settings.getNumOfEndPoints() > 1) {
                                clientEndPoints.get(i % settings.getNumOfEndPoints()).sendMessage(s);
                            } else {
                                clientEndPoints.get(0).sendMessage(s);


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
      //  WebSocketClientEndPoint clientEndPoint2 = new WebSocketClientEndPoint(new URI("ws://127.0.0.1:8080/endpoint"));
        System.out.println("hfh");
       // clientEndPoints.add(clientEndPoint2);
//        clientEndPoint2.addMessageHandler(new WebSocketClientEndPoint.MessageHandler() {
//            @Override
//            public void handleMessage(String message) {
//                System.out.println("\n Response Back: "+ message);
//            }
//        });
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

             //   WebSocketClientEndPoint clientEndPoint2 = new WebSocketClientEndPoint(new URI("ws://127.0.0.1:9080/streaming-api"));
//                clientEndPoint2.addMessageHandler(new WebSocketClientEndPoint.MessageHandler() {
//                    @Override
//                    public void handleMessage(String message) {
//
//                        System.out.println("\n Response2:" + message);
//                    }
//                });

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

    public static WebSocketClientEndPoint getWebsocket() throws Exception {
        WebSocketClientEndPoint clientEndPoint2 = new WebSocketClientEndPoint(new URI("ws://127.0.0.1:8080/endpoint"));
        return clientEndPoint2;
    }





}
