package com.upside.upside.service;

import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl {

    public String dbHeathCheck() {
        return "Success";
    }
}
