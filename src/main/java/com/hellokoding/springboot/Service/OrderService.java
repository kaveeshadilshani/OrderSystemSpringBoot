package com.hellokoding.springboot.Service;

import com.hellokoding.springboot.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService implements IOrderService {


    @Override
    public String printsth() {
        return "Order Activated";
    }



    @Override
    public String chooseWithTextOrNot() {
        return "1";
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



}
