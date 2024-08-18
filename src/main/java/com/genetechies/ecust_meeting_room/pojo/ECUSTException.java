package com.genetechies.ecust_meeting_room.pojo;

public class ECUSTException extends RuntimeException{

    public ECUSTException(String message){super(message);}

    public ECUSTException(String message,Throwable e){super(message,e);}

    public static ECUSTException instance(String message,Throwable e){
        return new ECUSTException(message,e);
    }
}
