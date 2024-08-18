package com.genetechies.ecust_meeting_room.pojo;

public class ECUSTResponse <T>{
    public static final Integer OK = 200;

    public static final Integer ERROR = 500;

    public static final Integer UNAUTHORIZED = 401;

    private Integer code;

    private T data;

    private String message;

    public Integer getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
