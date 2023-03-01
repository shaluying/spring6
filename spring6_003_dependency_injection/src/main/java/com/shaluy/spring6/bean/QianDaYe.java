package com.shaluy.spring6.bean;

import java.util.Arrays;

public class QianDaYe {
    private String[] aiHaos;
    private Woman[] women;

    @Override
    public String toString() {
        return "QianDaYe{" +
                "aiHaos=" + Arrays.toString(aiHaos) +
                ", women=" + Arrays.toString(women) +
                '}';
    }

    public void setAiHaos(String[] aiHaos) {
        this.aiHaos = aiHaos;
    }

    public void setWomen(Woman[] women) {
        this.women = women;
    }
}
