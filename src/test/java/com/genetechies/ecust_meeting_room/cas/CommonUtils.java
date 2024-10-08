package com.genetechies.ecust_meeting_room.cas;

import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

public class CommonUtils {


    @Test
    public void testConstruct(){
        String casServerLoginUrl= "https://sso.ecust.edu.cn/authserver/login";

    }

    public String getServiceParameterName(){
        return "service";
    }

    public static String constructRedirectUrl(String casServerLoginUrl, String serviceParameterName, String serviceUrl, boolean renew, boolean gateway) {
        try {
            return casServerLoginUrl + ((casServerLoginUrl.indexOf("?") != -1) ? "&" : "?") + serviceParameterName + "=" +
                    URLEncoder.encode(serviceUrl, "UTF-8") + (renew ? "&renew=true" : "") + (gateway ? "&gateway=true" : "");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
