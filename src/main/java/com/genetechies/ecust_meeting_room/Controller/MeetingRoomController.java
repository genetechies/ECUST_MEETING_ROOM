package com.genetechies.ecust_meeting_room.Controller;

import com.genetechies.ecust_meeting_room.Service.MeetingRoomsService;
import com.genetechies.ecust_meeting_room.pojo.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MeetingRoomController {

    @Autowired
    private MeetingRoomsService meetingRoomsService;

    @RequestMapping(value = "/api/meetingRooms/getAllRooms",method = RequestMethod.GET)
    public List<MeetingRoom> getMeetingRooms(){
        return meetingRoomsService.getAllMeetingRooms();
    }
}
