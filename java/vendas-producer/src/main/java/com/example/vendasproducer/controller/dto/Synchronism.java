package com.example.vendasproducer.controller.dto;

import java.util.UUID;

public class Synchronism {

    private String data;
    private String agent;
    private String customer;

    public Synchronism() {
    }

    public Synchronism(String data, String agent, String customer){
        this.data = UUID.randomUUID() + data;
        this.agent = agent + System.currentTimeMillis();
        this.customer = customer + System.currentTimeMillis();
    }

    public String getData() {
        return this.data;
    }

    public String getAgent() {
        return agent;
    }

    public String getCustomer() {
        return customer;
    }

    public Synchronism refreshValues() {
        this.data = UUID.randomUUID() + data;
        this.agent = agent + System.currentTimeMillis();
        this.customer = customer + System.currentTimeMillis();
        return this;
    }
}
