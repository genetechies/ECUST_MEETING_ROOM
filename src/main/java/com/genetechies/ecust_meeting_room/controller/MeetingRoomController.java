package com.genetechies.ecust_meeting_room.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.genetechies.ecust_meeting_room.pojo.*;
import com.genetechies.ecust_meeting_room.service.MeetingRoomService;
import com.genetechies.ecust_meeting_room.service.impl.MeetingRoomReservationServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meetingRooms/")
public class MeetingRoomController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    @Qualifier("meetingRoomServiceImpl")
    private MeetingRoomService meetingRoomService;

    @Autowired
    private MeetingRoomReservationServiceImpl meetingRoomReservationService;

    @ApiOperation(value = "get all meeting room with page",notes = "param: {\"pageSize\":2,\"pageNo\":1}")
    @RequestMapping(value = "getAllMeetingRooms",method = RequestMethod.POST)
    public ECUSTResponse<PageResponse<MeetingRoom>> getAllMeetingRooms(@RequestBody PageQuery pageQuery){
        logger.info("call:/api/meetingRooms/getAllMeetingRooms");
        ECUSTResponse<PageResponse<MeetingRoom>> ecustResponse = new ECUSTResponse<>();
        try{
            IPage<MeetingRoom> page = new Page<>(pageQuery.getPageNo(), pageQuery.getPageSize());

            IPage<MeetingRoom> meetingRoomIPage = meetingRoomService.page(page);
            ecustResponse.setData(new PageResponse<>(meetingRoomIPage.getTotal(),meetingRoomIPage.getPages(),meetingRoomIPage.getSize(),meetingRoomIPage.getCurrent(),meetingRoomIPage.getRecords()));
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }


    @ApiOperation(value = "get  meeting room by name",notes = "param: {\"pageSize\":10,\"pageNo\":1,\"meetingRoomName\":\"201\"}")
    @RequestMapping(value = "getMeetingRoomsByName",method = RequestMethod.POST)
    public ECUSTResponse<PageResponse<MeetingRoom>> getMeetingRoomsByName(
            @RequestBody MeetingRoomNameVo meetingRoomNameVo){
        logger.info("call:/api/meetingRooms/getMeetingRoomsByName");
        ECUSTResponse<PageResponse<MeetingRoom>> ecustResponse = new ECUSTResponse<>();
        try{
            IPage<MeetingRoom> page = new Page<>(meetingRoomNameVo.getPageNo(), meetingRoomNameVo.getPageSize());
            QueryWrapper<MeetingRoom> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("name",meetingRoomNameVo.getMeetingRoomName());
            IPage<MeetingRoom> meetingRoomIPage = meetingRoomReservationService.page(page,queryWrapper);

            ecustResponse.setData(new PageResponse<>(meetingRoomIPage.getTotal(),meetingRoomIPage.getPages(),meetingRoomIPage.getSize(),meetingRoomIPage.getCurrent(),meetingRoomIPage.getRecords()));
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @ApiOperation(value = "get meeting room by date range and roomID", notes = "parma: {\"pageSize\":2,\"pageNo\":1,\"roomId\":1,\"startTime\":\"2024-08-17 16:40:00\",\"endTime\":\"2024-08-19 17:43:00\"}")
    @RequestMapping(value = "getMeetingRoomsByDateRangeAndRoomId",method = RequestMethod.POST)
    public ECUSTResponse<PageResponse<MeetingRoom>> getMeetingRoomsByDateRange(
            @RequestBody MeetingRoomDateVo meetingRoomDateVo){
        logger.info("call:/api/meetingRooms/getMeetingRoomsByDateRangeAndRoomId{}",meetingRoomDateVo);
        ECUSTResponse<PageResponse<MeetingRoom>> ecustResponse = new ECUSTResponse<>();
        try{
            IPage<MeetingRoom> meetingRoomIPage = meetingRoomReservationService.selectReserveMeetingRoom(meetingRoomDateVo);
            ecustResponse.setData(new PageResponse<>(meetingRoomIPage.getTotal(),meetingRoomIPage.getPages(),meetingRoomIPage.getSize(),meetingRoomIPage.getCurrent(),meetingRoomIPage.getRecords()));
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

    @RequestMapping(value = "removeMeetingRoomById",method = RequestMethod.POST)
    public ECUSTResponse<Void> removeMeetingRoomById(@RequestParam(value = "roomId")String roomId){
        logger.info("call:/api/meetingRooms/removeMeetingRoomById");
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            meetingRoomService.removeById(roomId);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @RequestMapping(value = "updateMeetingRoomById",method = RequestMethod.POST)
    public ECUSTResponse<Void> updateMeetingRoom(@RequestBody MeetingRoom meetingRoom){
        logger.info("call:/api/meetingRooms/updateMeetingRoom");
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            meetingRoomService.updateById(meetingRoom);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

}
