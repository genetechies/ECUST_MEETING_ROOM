package com.genetechies.ecust_meeting_room.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.genetechies.ecust_meeting_room.domain.Reservation;
import com.genetechies.ecust_meeting_room.domain.User;
import com.genetechies.ecust_meeting_room.pojo.ECUSTException;
import com.genetechies.ecust_meeting_room.pojo.ECUSTResponse;
import com.genetechies.ecust_meeting_room.pojo.PageResponse;
import com.genetechies.ecust_meeting_room.pojo.UserQueryVo;
import com.genetechies.ecust_meeting_room.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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

    @ApiOperation(value = "get user info",notes = "param: {\"pageSize\":3,\"pageNo\":1} or {\"pageSize\":3,\"pageNo\":1,\"name\":\"san\"} or {\"pageSize\":3,\"pageNo\":1,\"role\":\"admin\"}")
    @RequestMapping(value = "getAllUserInfo",method = RequestMethod.POST)
    public ECUSTResponse<PageResponse<User>> getAllUserInfo(@RequestBody UserQueryVo userQueryVo){
        logger.info("call:/api/meetingRooms/getAllUserInfo");
        ECUSTResponse<PageResponse<User>> ecustResponse = new ECUSTResponse<>();

        IPage<User> page = new Page<>(userQueryVo.getPageNo(), userQueryVo.getPageSize());

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        if(StringUtils.isNoneEmpty(userQueryVo.getName())){
            queryWrapper.like("name",userQueryVo.getName());
        }
        if(StringUtils.isNoneEmpty(userQueryVo.getRole())){
            queryWrapper.eq("role",userQueryVo.getRole());
        }

        try{
            IPage<User> userIPage = userService.page(page,queryWrapper);
            ecustResponse.setData(new PageResponse<>(userIPage.getTotal(),userIPage.getPages(),userIPage.getSize(),userIPage.getCurrent(),userIPage.getRecords()));
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }
}
