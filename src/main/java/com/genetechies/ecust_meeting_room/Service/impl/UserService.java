package com.genetechies.ecust_meeting_room.Service.impl;

import com.genetechies.ecust_meeting_room.Repository.UserRepository;
import com.genetechies.ecust_meeting_room.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.loadUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("账户不存在");
        }
        return user;
    }
}
