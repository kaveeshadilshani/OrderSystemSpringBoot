package com.hellokoding.springboot.Controller;

import com.hellokoding.springboot.Service.IOrderService;
import com.hellokoding.springboot.bean.TextRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    IOrderService orderService;

    @RequestMapping(value = "/getOrder")
    public String getOrder(){
        return orderService.printsth();

    }



    @RequestMapping("/withText1")
    public String withText(Model model, @RequestParam(value="order", required=false, defaultValue="served") String order) {
        model.addAttribute("order", order);
        return "WithTextOrWithoutText";
    }




}
