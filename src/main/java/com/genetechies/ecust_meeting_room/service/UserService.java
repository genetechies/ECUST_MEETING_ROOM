package com.genetechies.ecust_meeting_room.service;

import com.genetechies.ecust_meeting_room.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 98025
* @description 针对表【user】的数据库操作Service
* @createDate 2024-08-20 20:59:00
*/
public interface UserService extends IService<User> {
    void register(User user);

    User getUserByUsername(String username);
}
