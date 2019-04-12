package com.hellokoding.springboot.bean;

public interface ErrorCodesI {
    public String getDescription();

    public int getId();

    public <T extends ErrorCodesI> T getErrorCode();
}
