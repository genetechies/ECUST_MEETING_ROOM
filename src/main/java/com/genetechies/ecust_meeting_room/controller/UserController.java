package com.genetechies.ecust_meeting_room.controller;

import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.genetechies.ecust_meeting_room.domain.User;
import com.genetechies.ecust_meeting_room.pojo.ECUSTException;
import com.genetechies.ecust_meeting_room.pojo.ECUSTResponse;
import com.genetechies.ecust_meeting_room.service.UserService;
import com.genetechies.ecust_meeting_room.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "updateUserInfoById",method = RequestMethod.POST)
    public ECUSTResponse<Void> updateUserInfoById(@RequestBody User user){
        logger.info("call:/api/user/updateUserInfoById");
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            userService.updateById(user);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @RequestMapping(value = "getAllUserInfo",method = RequestMethod.GET)
    public ECUSTResponse<List<User>> getAllUserInfo(){
        logger.info("call:/api/meetingRooms/getAllUserInfo");
        ECUSTResponse<List<User>> ecustResponse = new ECUSTResponse<>();
        try{
            List<User> users = userService.list();
            ecustResponse.setData(users);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }
}
