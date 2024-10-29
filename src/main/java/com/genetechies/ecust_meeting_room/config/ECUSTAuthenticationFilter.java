package com.genetechies.ecust_meeting_room.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "CASFilter",urlPatterns ="/*", initParams = {
    @WebInitParam(name="casServerLoginUrl",value="https://sso.ecust.edu.cn/authserver/login"),
    @WebInitParam(name="serverName",value="http://127.0.0.1:8080")
})
public class ECUSTAuthenticationFilter extends AuthenticationFilter {

}
