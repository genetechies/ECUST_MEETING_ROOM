package com.genetechies.ecust_meeting_room.Controller;

import com.genetechies.ecust_meeting_room.Service.MeetingRoomsService;
import com.genetechies.ecust_meeting_room.pojo.ECUSTException;
import com.genetechies.ecust_meeting_room.pojo.ECUSTResponse;
import com.genetechies.ecust_meeting_room.pojo.MeetingRoom;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MeetingRoomController {

    private static final Logger logger = Logger.getLogger(MeetingRoomController.class);

    @Autowired
    private MeetingRoomsService meetingRoomsService;

    @RequestMapping(value = "/api/meetingRooms/getAllRooms",method = RequestMethod.GET)
    public ECUSTResponse<List<MeetingRoom>> getAllMeetingRooms(){
        logger.info("call:/api/meetingRooms/getAllRooms");
        ECUSTResponse<List<MeetingRoom>> ecustResponse = new ECUSTResponse<>();
        try{
            List<MeetingRoom> meetingRooms =  meetingRoomsService.getAllMeetingRooms();
            ecustResponse.setCode(ECUSTResponse.OK);
            ecustResponse.setData(meetingRooms);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @RequestMapping(value = "/api/meetingRooms/getMeetingroomById",method = RequestMethod.GET)
    public ECUSTResponse<MeetingRoom> getMeetingRoomById(@RequestParam(value = "roomId") String roomId){
        logger.info("call:/api/meetingRooms/getMeetingroomById");
        ECUSTResponse<MeetingRoom> ecustResponse = new ECUSTResponse<>();
        try{
            MeetingRoom meetingRoom = meetingRoomsService.getMeetingRoomById(roomId);
            ecustResponse.setData(meetingRoom);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @RequestMapping(value = "/api/meetingRooms/addMeetingRoom",method = RequestMethod.POST)
    public ECUSTResponse<Void> addMeetingRoom(@RequestBody MeetingRoom meetingRoom){
        logger.info("call:/api/meetingRooms/addMeetingRoom");
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            meetingRoomsService.addMeetingRoom(meetingRoom);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }
}
