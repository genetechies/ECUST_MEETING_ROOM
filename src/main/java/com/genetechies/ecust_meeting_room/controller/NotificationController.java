package com.genetechies.ecust_meeting_room.controller;


import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.genetechies.ecust_meeting_room.domain.Reservation;
import com.genetechies.ecust_meeting_room.domain.RoomAdmin;
import com.genetechies.ecust_meeting_room.pojo.ECUSTException;
import com.genetechies.ecust_meeting_room.pojo.ECUSTResponse;
import com.genetechies.ecust_meeting_room.pojo.NotificationVo;
import com.genetechies.ecust_meeting_room.service.NotificationService;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/notification/")
public class NotificationController {


    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.appId}")
    private String secret;

    @Value("${wx.templateId}")
    private String templateId;

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationService notificationService;


    @RequestMapping(value = "sendNotification",method = RequestMethod.POST)
    public void sendNotification(@RequestBody NotificationVo notificationVo){
        String token = queryToken();

        //send(token);


    }

    public String queryToken(){
        String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
        tokenUrl = tokenUrl = "&appid=" + appId + "&secret=" + secret;
        String result = HttpUtil.get(tokenUrl);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        return jsonObject.get("access_token").toString();
    }

    public void send(String token,String openId){
        String msgUrl = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send";
        msgUrl = msgUrl + "?access_token=" + token;

        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("touser",openId);
        paramMap.put("template_id",templateId);
    }


}
