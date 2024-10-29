package com.genetechies.ecust_meeting_room.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.genetechies.ecust_meeting_room.domain.User;
import com.genetechies.ecust_meeting_room.service.UserService;
import com.genetechies.ecust_meeting_room.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 98025
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-08-20 20:59:00
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int register(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.findOneByUsername(username);
    }
}




