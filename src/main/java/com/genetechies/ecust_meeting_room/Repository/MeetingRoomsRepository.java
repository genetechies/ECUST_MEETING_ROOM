package com.genetechies.ecust_meeting_room.Repository;

import com.genetechies.ecust_meeting_room.pojo.MeetingRoom;

import java.util.List;

public interface MeetingRoomsRepository {
    public List<MeetingRoom> getAllMeetingRooms();

    public void addMeetingRoom(MeetingRoom meetingRoom);
}
