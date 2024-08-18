package com.genetechies.ecust_meeting_room.Service;

import com.genetechies.ecust_meeting_room.pojo.MeetingRoom;

import java.util.List;

public interface MeetingRoomsService {
    public List<MeetingRoom> getAllMeetingRooms();

    public void addMeetingRoom(MeetingRoom meetingRoom);

    public MeetingRoom getMeetingRoomById(String roomId);
}
