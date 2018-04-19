package com.liweijian.controller.exception;

public class MesException extends Exception {

    private String mes;

    public MesException(String mes) {
        this.mes = mes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
