package com.genetechies.ecust_meeting_room.controller;

import com.genetechies.ecust_meeting_room.domain.User;
import com.genetechies.ecust_meeting_room.pojo.ECUSTResponse;
import com.genetechies.ecust_meeting_room.pojo.LoginResponse;
import com.genetechies.ecust_meeting_room.service.UserService;
import com.genetechies.ecust_meeting_room.utils.JwtUtil;
import com.genetechies.ecust_meeting_room.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtUtil jwtUtil;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ECUSTResponse<String> register(@RequestBody User userVo){
        logger.info("call:/api/auth/register");
        ECUSTResponse<String> ecustResponse = new ECUSTResponse<>();
        User user = userService.getUserByUsername(userVo.getUsername());

        if(user != null){
           ecustResponse.setCode(ECUSTResponse.OK);
           ecustResponse.setMessage("user has already been existed");
           return ecustResponse;
        }
        userService.register(userVo);
        ecustResponse.setCode(ECUSTResponse.OK);
        ecustResponse.setMessage("user register successfully");
        return ecustResponse;
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ECUSTResponse<LoginResponse> login(@RequestBody User userVo){
        logger.info("call:/api/auth/login");
        ECUSTResponse<LoginResponse> ecustResponse = new ECUSTResponse<>();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userVo.getUsername(),userVo.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        ecustResponse.setCode(ECUSTResponse.OK);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtUtil.generateToken(authentication));
        ecustResponse.setData(loginResponse);
        ecustResponse.setMessage("login successfully");
        return ecustResponse;
    }

    @RequestMapping(value = "currentUser",method = RequestMethod.GET)
    public User getCurrentUser(){
        return UserUtils.getCurrentUser();
    }
}


