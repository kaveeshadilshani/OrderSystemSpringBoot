package com.hellokoding.springboot.bean;

public class TextRead {
    private String WithTextRead;
    private String WithoutTextRead;

    public String getWithTextRead() {
        return WithTextRead;
    }

    public String getWithoutTextRead() {
        return WithoutTextRead;
    }

    public void setWithoutTextRead(String withoutTextRead) {
        WithoutTextRead = withoutTextRead;
    }

    public void setWithTextRead(String withTextRead) {
        WithTextRead = withTextRead;
    }
}
