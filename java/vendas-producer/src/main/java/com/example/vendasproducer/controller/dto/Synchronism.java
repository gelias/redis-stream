package com.example.vendasproducer.controller.dto;

public class Synchronism {

    private String data;
    private String agent;
    private String customer;

    public Synchronism() {
    }

    public Synchronism(String data, String agent, String customer){
        this.data = data;
        this.agent = agent;
        this.customer = customer;
    }

    public String getData() {
        return data;
    }

    public String getAgent() {
        return agent;
    }

    public String getCustomer() {
        return customer;
    }
}
