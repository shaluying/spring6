package com.shaluy.spring6.bean;

public class Math {
    private String result;

    @Override
    public String toString() {
        return "Math{" +
                "result='" + result + '\'' +
                '}';
    }

    public void setResult(String result) {
        this.result = result;
    }
}
