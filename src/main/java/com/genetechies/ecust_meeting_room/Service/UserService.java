package com.genetechies.ecust_meeting_room.Service;

import com.genetechies.ecust_meeting_room.domain.User;

public interface UserService {

    void register(User user);

    User getUserByUsername(String username);
}
