package com.genetechies.ecust_meeting_room.config;

import org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "CASValidationFilter",urlPatterns ="/*",initParams = {
        @WebInitParam(name="casServerUrlPrefix",value="https://sso.ecust.edu.cn/authserver"),
        @WebInitParam(name="serverName",value="http://127.0.0.1:8080")
})
public class ECUSTTicketValidationFilter extends Cas20ProxyReceivingTicketValidationFilter {
}
