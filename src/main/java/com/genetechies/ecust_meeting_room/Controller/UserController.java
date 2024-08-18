package com.genetechies.ecust_meeting_room.Controller;

import com.genetechies.ecust_meeting_room.pojo.User;
import com.genetechies.ecust_meeting_room.utils.UserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/api/user/currentUser",method = RequestMethod.GET)
    public User getCurrentUser(){
        return UserUtils.getCurrentUser();
    }
}
