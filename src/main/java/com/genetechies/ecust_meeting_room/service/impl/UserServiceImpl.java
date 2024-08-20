package com.genetechies.ecust_meeting_room.service.impl;

import com.genetechies.ecust_meeting_room.service.UserService;
import com.genetechies.ecust_meeting_room.domain.User;
import com.genetechies.ecust_meeting_room.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserByUsername(String username) {
       return userMapper.findOneByUsername(username);
    }
}
