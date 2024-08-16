package com.genetechies.ecust_meeting_room.RowMapper;

import com.genetechies.ecust_meeting_room.pojo.MeetingRoom;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MeetingRoomRowMapper implements RowMapper<MeetingRoom> {

    @Override
    public MeetingRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setRoomId(rs.getInt("room_id"));
        meetingRoom.setName(rs.getString("name"));
        meetingRoom.setCapacity(rs.getInt("capacity"));
        meetingRoom.setEquipment(rs.getString("equipment"));
        meetingRoom.setAddress(rs.getString("address"));
        meetingRoom.setStatus(rs.getString("status"));
        meetingRoom.setCreatedAt(rs.getDate("created_at"));
        return meetingRoom;
    }
}
