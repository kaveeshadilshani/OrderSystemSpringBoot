package com.hellokoding.springboot.Service;

import com.hellokoding.springboot.bean.City;

import java.util.List;

public interface ICityService {

    public List<City> findAll();
}