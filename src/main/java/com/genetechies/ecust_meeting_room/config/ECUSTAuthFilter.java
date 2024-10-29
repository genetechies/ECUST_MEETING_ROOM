package com.genetechies.ecust_meeting_room.config;

import org.hepeng.commons.spring.security.web.filter.SkipOverSpringSecurityFilterChainFilter;

import javax.servlet.http.HttpServletRequest;

public class ECUSTAuthFilter extends SkipOverSpringSecurityFilterChainFilter {
    @Override
    protected boolean isSkipOver(HttpServletRequest httpServletRequest) {
        return Boolean.parseBoolean(httpServletRequest.getHeader("ECUSTAUTH"));
    }
}
