package com.hellokoding.springboot.Controller;

import com.hellokoding.springboot.Service.ICityService;
import com.hellokoding.springboot.bean.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    ICityService cityService;

    @RequestMapping(value = "/getCities")
    public List<City> getCities() {

        List<City> cities = cityService.findAll();

        return cities;
    }
}