package com.genetechies.ecust_meeting_room.utils;

import com.genetechies.ecust_meeting_room.domain.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {

    public static User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            return (User)authentication.getPrincipal();
        }
        return null;
    }
}
