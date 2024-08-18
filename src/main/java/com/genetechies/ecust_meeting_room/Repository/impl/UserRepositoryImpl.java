package com.genetechies.ecust_meeting_room.Repository.impl;

import com.genetechies.ecust_meeting_room.Repository.UserRepository;
import com.genetechies.ecust_meeting_room.RowMapper.UserRowMapper;
import com.genetechies.ecust_meeting_room.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User loadUserByUsername(String username) {
        String sql = "select * from users where username=?";
        return jdbcTemplate.queryForObject(sql,new UserRowMapper(),username);
    }
}
