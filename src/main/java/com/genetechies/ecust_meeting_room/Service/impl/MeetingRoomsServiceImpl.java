package com.genetechies.ecust_meeting_room.Service.impl;

import com.genetechies.ecust_meeting_room.Repository.MeetingRoomsRepository;
import com.genetechies.ecust_meeting_room.Service.MeetingRoomsService;
import com.genetechies.ecust_meeting_room.pojo.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomsServiceImpl implements MeetingRoomsService {

    @Autowired
    private MeetingRoomsRepository meetingRoomsDao;

    @Override
    public List<MeetingRoom> getAllMeetingRooms() {
        return meetingRoomsDao.getAllMeetingRooms();
    }

    @Override
    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRoomsDao.addMeetingRoom(meetingRoom);
    }

    @Override
    public MeetingRoom getMeetingRoomById(String roomId) {
       return meetingRoomsDao.getMeetingRoomById(roomId);
    }


}
