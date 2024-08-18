package com.genetechies.ecust_meeting_room.Repository;

import com.genetechies.ecust_meeting_room.pojo.User;

public interface UserRepository {
    public User loadUserByUsername(String username);
}
