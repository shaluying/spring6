package com.shaluy.spring6.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
    private List<String> onlineNames;
    private Set<String> address;
    private Map<Integer, String> phone;
    private Properties properties;

    @Override
    public String toString() {
        return "Person{" +
                "onlineNames=" + onlineNames +
                ", address=" + address +
                ", phone=" + phone +
                ", properties=" + properties +
                '}';
    }

    public void setPhone(Map<Integer, String> phone) {
        this.phone = phone;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setOnlineNames(List<String> onlineNames) {
        this.onlineNames = onlineNames;
    }

    public void setAddress(Set<String> address) {
        this.address = address;
    }
}
