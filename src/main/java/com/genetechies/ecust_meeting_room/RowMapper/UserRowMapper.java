package com.genetechies.ecust_meeting_room.RowMapper;

import com.genetechies.ecust_meeting_room.pojo.MeetingRoom;
import com.genetechies.ecust_meeting_room.pojo.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setEmpoyeeId(rs.getString("employee_id"));
        user.setPhone(rs.getString("phone"));
        user.setRole(rs.getString("role"));
        user.setStatus(rs.getString("status"));
        user.setCreateAt(rs.getDate("created_at"));
        return user;
    }
}
