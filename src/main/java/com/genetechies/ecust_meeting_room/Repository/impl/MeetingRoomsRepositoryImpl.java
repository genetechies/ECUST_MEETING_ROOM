package com.genetechies.ecust_meeting_room.Repository.impl;

import com.genetechies.ecust_meeting_room.Repository.MeetingRoomsRepository;
import com.genetechies.ecust_meeting_room.RowMapper.MeetingRoomRowMapper;
import com.genetechies.ecust_meeting_room.pojo.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeetingRoomsRepositoryImpl implements MeetingRoomsRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MeetingRoom> getAllMeetingRooms(){
        return jdbcTemplate.query("select * from meeting_room",new MeetingRoomRowMapper());
    }

    @Override
    public void addMeetingRoom(MeetingRoom meetingRoom) {
        String sql = "insert meeting_rooms(name,capacity,equipment,address,status) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,meetingRoom.getName(),meetingRoom.getCapacity(),meetingRoom.getEquipment(),meetingRoom.getAddress(),meetingRoom.getStatus());
    }

    @Override
    public MeetingRoom getMeetingRoomById(String roomId) {
        String sql = "SELECT * FROM meeting_room WHERE room_id=?";
        return jdbcTemplate.queryForObject(sql,new MeetingRoomRowMapper(),roomId);
    }
}
