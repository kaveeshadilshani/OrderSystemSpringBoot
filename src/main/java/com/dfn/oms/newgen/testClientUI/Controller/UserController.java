package com.dfn.oms.newgen.testClientUI.Controller;

import com.dfn.oms.newgen.testClientUI.Repository.JMSRepository;
import com.dfn.oms.newgen.testClientUI.Repository.ParameterRepository;
import com.dfn.oms.newgen.testClientUI.Repository.UserRepository;
import com.dfn.oms.newgen.testClientUI.bean.AmendCancelComponent.AmendOrder;
import com.dfn.oms.newgen.testClientUI.bean.AmendCancelComponent.CancelOrder;
import com.dfn.oms.newgen.testClientUI.bean.JMSComponent.JMS;
import com.dfn.oms.newgen.testClientUI.bean.JMSComponent.JMSSender;
import com.dfn.oms.newgen.testClientUI.bean.CreateOrderComponent.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import static com.dfn.oms.newgen.testClientUI.bean.CreateOrderComponent.WebSocketClientEndPoint.responseCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.dfn.oms.newgen.testClientUI.Controller.OrderController.*;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private int i = 1;
    private int j = 1;
    private int k = 1;
    private int l = 1;

    public UserController(UserRepository userRepository, ParameterRepository parameterRepository) {
        this.userRepository = userRepository;
        this.parameterRepository = parameterRepository;
       
    }
    public static  UserRepository userRepository;
    public static ParameterRepository parameterRepository;
    public static JMSRepository jmsRepository;
    public static HashMap<String, AmendOrder> hashMap_amendOrder = new HashMap<>();
    public static HashMap<String, CancelOrder> hashMap_cancelOrder = new HashMap<>();
   public static HashMap<String, OrdersPerTimeSlice> hashMap_ordersPerTimeSlice = new HashMap<>();


    @GetMapping("/users/home")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users/home")
    void addUser(@RequestBody User user) {
//        clientEndPoints.clear();
          userRepository.save(user);
          System.out.println(user);
//        WebSocketRunnerSetting settings = new WebSocketRunnerSetting();
//        long noOfRequests = userRepository.count();
//        settings.setIp(userRepository.findById((long) noOfRequests).get().getIp());
//        settings.setPort(userRepository.findById((long) noOfRequests).get().getPort());
//        settings.setGWClient(false);
//        settings.setNumOfEndPoints(userRepository.findById((long) noOfRequests).get().getEndpoint());
//        System.out.println(settings.getIp());
//        try {
//           clientEndPoints = populateEndPoints(settings);
//        } catch (Exception ex) {
//            System.err.println("client exception...: " + ex);
//        }
    }
    @GetMapping("/users/params")
    public List<OrderParams> getParams() {
        // OrderParams orderParams =new OrderParams("sgdh","shgdh","ghdhgs");
        //  parameterRepository.save(orderParams);
        return (List<OrderParams>) parameterRepository.findAll();
    }

    @PostMapping("/users/params")
    void addParams(@RequestBody OrderParams orderParams) {

        // System.out.println("fjhjsfhjjh");
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
