package com.genetechies.ecust_meeting_room.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.genetechies.ecust_meeting_room.domain.Reservation;
import com.genetechies.ecust_meeting_room.domain.User;
import com.genetechies.ecust_meeting_room.pojo.*;
import com.genetechies.ecust_meeting_room.service.UserService;
import com.genetechies.ecust_meeting_room.utils.UserUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/user/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

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
        logger.info("call:/api/user/getAllUserInfo");
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

    @RequestMapping(value = "getRequestResettingUserForAdmin",method = RequestMethod.GET)
    public ECUSTResponse<List<User>> getRequestResettingUserForAdmin(){
        logger.info("call:/api/user/getRequestResettingUserForAdmin");
        ECUSTResponse<List<User>> ecustResponse = new ECUSTResponse<>();
        try{
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("resetting",Boolean.TRUE);

            List<User> userList = userService.list(queryWrapper);
            ecustResponse.setData(userList);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @ApiOperation(value = "reset user password with default value",notes = "param: ")
    @RequestMapping(value = "resettingPasswordByAdmin",method = RequestMethod.POST)
    public ECUSTResponse<Void> resettingPasswordByAdmin(@RequestBody ResettingPasswordVo resettingPasswordVo){
        logger.info("call:/api/user/resettingPasswordByAdmin");
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("user_id",resettingPasswordVo.getUserId()).set("password",passwordEncoder.encode("888888")).set("resetting",Boolean.FALSE);
            userService.update(updateWrapper);
            ecustResponse.setCode(ECUSTResponse.OK);
            ecustResponse.setMessage("reset password successfully");
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @ApiOperation(value = "chang password for user",notes = "{\"passowrd\":\"1234\"}")
    @RequestMapping(value = "changPasswordByUser",method = RequestMethod.POST)
    public ECUSTResponse<PageResponse<Void>> changPasswordByUser(@RequestBody PasswordVo passwordVo){
        logger.info("call:/api/user/getAllUserInfo");
        ECUSTResponse<PageResponse<Void>> ecustResponse = new ECUSTResponse<>();
        try{
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            User user = UserUtils.getCurrentUser();
            updateWrapper.eq("user_id",user.getUserId()).set("password",passwordEncoder.encode(passwordVo.getPassword()));
            userService.update(updateWrapper);
            ecustResponse.setCode(ECUSTResponse.OK);
            ecustResponse.setMessage("change password successfully");
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }
}
