package com.meicai.ppblossom.theone.api.response;

import java.io.Serializable;

public class Error implements Serializable {

    private int code;

    private String name;

    private String type;

    private String msg;

    public Error(int code, String name, String type, String msg) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.msg = msg;
    }

    public Error(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
