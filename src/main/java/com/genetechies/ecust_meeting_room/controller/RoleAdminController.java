package com.genetechies.ecust_meeting_room.controller;

import com.genetechies.ecust_meeting_room.domain.RoomAdmin;
import com.genetechies.ecust_meeting_room.pojo.ECUSTException;
import com.genetechies.ecust_meeting_room.pojo.ECUSTResponse;
import com.genetechies.ecust_meeting_room.service.RoomAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/roleadmin/")
public class RoleAdminController {

    private static final Logger logger = LoggerFactory.getLogger(RoleAdminController.class);

    @Autowired
    private RoomAdminService roomAdminService;

    @RequestMapping(value = "getAdminInfoByRoomId",method = RequestMethod.GET)
    public ECUSTResponse<List<RoomAdmin>> getUserInfoByRoomId(@RequestParam String roomId){
        logger.info("call:/api/roleadmin/getAllRoomAdmin");
        ECUSTResponse<List<RoomAdmin>> ecustResponse = new ECUSTResponse<>();
        try{
            List<RoomAdmin> roomAdmins = roomAdminService.getAdminsByRoomId(roomId);
            ecustResponse.setData(roomAdmins);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }


    @RequestMapping(value = "getAllRoomsOwnedByAdminId",method = RequestMethod.GET)
    public ECUSTResponse<List<RoomAdmin>> getAllRoomsOwnedByAdminId(@RequestParam String adminId){
        logger.info("call:/api/roleadmin/getAllRoomsOwnedByAdminId");
        ECUSTResponse<List<RoomAdmin>> ecustResponse = new ECUSTResponse<>();
        try{
            List<RoomAdmin> roomAdmins = roomAdminService.getAllRoomsOwnedByAdminId(adminId);
            ecustResponse.setData(roomAdmins);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @RequestMapping(value = "addRoomAdmin",method = RequestMethod.POST)
    public ECUSTResponse<Void> addRoomAdmin(@RequestBody RoomAdmin roomAdmin){
        logger.info("call:/api/roleadmin/addRoomAdmin");
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            roomAdminService.save(roomAdmin);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @RequestMapping(value = "removeRoomAdminById",method = RequestMethod.POST)
    public ECUSTResponse<Void> removeRoomAdminById(@RequestParam(value = "id")String id){
        logger.info("call:/api/roleadmin/removeRoomAdminById");
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            roomAdminService.removeById(id);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }
}
