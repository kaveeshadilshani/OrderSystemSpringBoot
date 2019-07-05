package com.dfn.oms.newgen.testClientUI;

import com.dfn.oms.newgen.testClientUI.bean.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.dfn.oms.newgen.testClientUI.OrderController.*;
import static com.dfn.oms.newgen.testClientUI.bean.WebSocketClientEndPoint.responseCount;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController1 {

    private int i = 1;
    private int j = 1;
    private int k = 1;
    private int l = 1;

    public UserController1(UserRepository userRepository, ParameterRepository parameterRepository) {
        this.userRepository1 = userRepository;
        this.parameterRepository = parameterRepository;
        //this.jmsRepository = jmsRepository;
    }
    public static  UserRepository userRepository1;
    public static ParameterRepository parameterRepository;
    public static JMSRepository jmsRepository;
    public static HashMap<String,AmendOrder> hashMap_amendOrder = new HashMap<>();
    public static HashMap<String, CancelOrder> hashMap_cancelOrder = new HashMap<>();
    public static HashMap<String, OrdersPerTimeSlice> hashMap_ordersPerTimeSlice = new HashMap<>();
    public static GatewayUser gatewayUser = new GatewayUser();

    @GetMapping("/users/home")
    public List<User> getUsers() {
        return (List<User>) userRepository1.findAll();
    }

    @PostMapping("/users/home")
    void addUser(@RequestBody User user) {
//        clientEndPoints.clear();
          userRepository1.save(user);
          System.out.println(user);
//        WebSocketRunnerSetting settings = new WebSocketRunnerSetting();
//        long noOfRequests = userRepository1.count();
//        settings.setIp(userRepository1.findById((long) noOfRequests).get().getIp());
//        settings.setPort(userRepository1.findById((long) noOfRequests).get().getPort());
//        settings.setGWClient(false);
//        settings.setNumOfEndPoints(userRepository1.findById((long) noOfRequests).get().getEndpoint());
//        System.out.println(settings.getIp());
//        try {
//           clientEndPoints = populateEndPoints(settings);
//        } catch (Exception ex) {
//            System.err.println("client exception...: " + ex);
//        }
    }

    @PostMapping("/users/home/gw")
    void addGwUser(@RequestBody GatewayUser gwUser){
        this.gatewayUser = gwUser;

        System.out.println("Successfully Connected..");
    }

    @GetMapping("/params")
    public List<OrderParams> getParams() {
        return (List<OrderParams>) parameterRepository.findAll();
    }

    @PostMapping("/params")
    void addParams(@RequestBody OrderParams orderParams) {

        orderParams.setId((long)i);
        i++;
        parameterRepository.save(orderParams);
        System.out.println(orderParams);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/ResponseCount")
    // @ResponseBody
    public List<String> getResponseCount() {
        ArrayList<String> list = new ArrayList<String>();
        list.add(0,Integer.toString(responseCount));
        // System.out.println(responseCount);
        return list;


    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/ResponseData")
    // @ResponseBody
    public List<String> getResponseData() {
        List<String> listNew = new ArrayList<>() ;
        // listNew.add("dhdh");
        if(responseList.size() != 0) {
            for (int i = 0; i < responseList.size(); i++) {
                listNew.add(responseList.get(i));
            }
        }
        return listNew;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/ResponseTime")
    // @ResponseBody
    public List<Long> getResponseTime() {
        return timeList;
    }

    @GetMapping("/jmsSend")
    public List<JMS> getJMS() {
        return (List<JMS>) jmsRepository.findAll();
    }

    @PostMapping("/jmsSend")
    void addJMS(@RequestBody JMS jms) {
        jms.setId((long)j);
        System.out.println(jms);
        String jmsMessage = jms.getJmsMessage();
        JMS jmsObject = new JMS();
        jmsObject.setExchange(jms.getExchange());
        System.out.println(jmsMessage);
        j++;
        WebSocketRunner.currentAction = "5";
        JMSSender jmsSender = createMiddlewareConnection();
        sendMessage(jmsSender, jmsMessage);
    }

    public JMSSender createMiddlewareConnection(){
        JMSSender jmsSender = new JMSSender();
        jmsSender.createConnection();
        return jmsSender;
    }
    public void sendMessage(JMSSender jmsSender, String message){
        jmsSender.sendMessage("23041", Settings.SID, message);
    }

    @PostMapping("/amendOrder")
    void addAmendOrder(@RequestBody AmendOrder amendOrder) {
        System.out.println(amendOrder);
        hashMap_amendOrder.put(Integer.toString(k),amendOrder);
        k++;
        orderAction = "3";

    }

    @PostMapping("/cancelOrder")
    void addCancelOrder(@RequestBody CancelOrder cancelOrder) {
        System.out.println(cancelOrder);
        hashMap_cancelOrder.put(Integer.toString(k),cancelOrder);
        k++;
        orderAction = "4";

    }
    @PostMapping("/ordersPerTimeSlice")
    void addOrdersPerTimeSlice(@RequestBody OrdersPerTimeSlice ordersPerTimeSlice) {
        System.out.println(ordersPerTimeSlice);
        ordersPerTimeSlice.setId((long)l);
        hashMap_ordersPerTimeSlice.put(Integer.toString(l),ordersPerTimeSlice);
        l++;
    }


}
