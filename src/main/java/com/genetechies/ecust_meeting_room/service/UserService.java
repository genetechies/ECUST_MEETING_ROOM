package com.genetechies.ecust_meeting_room.service;

import com.genetechies.ecust_meeting_room.domain.User;

public interface UserService {

    void register(User user);

    User getUserByUsername(String username);
}
