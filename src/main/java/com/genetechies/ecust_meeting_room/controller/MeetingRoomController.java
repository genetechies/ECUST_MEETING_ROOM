package com.genetechies.ecust_meeting_room.controller;

import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.genetechies.ecust_meeting_room.pojo.ECUSTException;
import com.genetechies.ecust_meeting_room.pojo.ECUSTResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meetingRooms/")
public class MeetingRoomController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private com.genetechies.ecust_meeting_room.service.MeetingRoomService meetingRoomService;

    @RequestMapping(value = "getAllMeetingRooms",method = RequestMethod.GET)
    public ECUSTResponse<List<MeetingRoom>> getAllMeetingRooms(){
        logger.info("call:/api/meetingRooms/getAllRooms");
        ECUSTResponse<List<MeetingRoom>> ecustResponse = new ECUSTResponse<>();
        try{
            List<MeetingRoom> meetingRooms = meetingRoomService.list();
            ecustResponse.setData(meetingRooms);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @RequestMapping(value = "getMeetingroomById",method = RequestMethod.GET)
    public ECUSTResponse<MeetingRoom> getMeetingRoomById(@RequestParam(value = "roomId") String roomId){
        logger.info("call:/api/meetingRooms/getMeetingroomById");
        ECUSTResponse<MeetingRoom> ecustResponse = new ECUSTResponse<>();
        try{
            MeetingRoom meetingRoom = meetingRoomService.getById(roomId);
            ecustResponse.setData(meetingRoom);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @RequestMapping(value = "addMeetingRoom",method = RequestMethod.POST)
    public ECUSTResponse<Void> addMeetingRoom(@RequestBody MeetingRoom meetingRoom){
        logger.info("call:/api/meetingRooms/addMeetingRoom");
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            meetingRoomService.save(meetingRoom);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }
}
