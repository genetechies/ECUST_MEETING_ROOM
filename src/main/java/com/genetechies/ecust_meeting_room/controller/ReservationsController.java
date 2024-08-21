package com.genetechies.ecust_meeting_room.controller;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.genetechies.ecust_meeting_room.domain.Notification;
import com.genetechies.ecust_meeting_room.domain.Reservation;
import com.genetechies.ecust_meeting_room.domain.RoomAdmin;
import com.genetechies.ecust_meeting_room.pojo.ECUSTException;
import com.genetechies.ecust_meeting_room.pojo.ECUSTResponse;
import com.genetechies.ecust_meeting_room.service.MeetingRoomService;
import com.genetechies.ecust_meeting_room.service.NotificationService;
import com.genetechies.ecust_meeting_room.service.ReservationService;
import com.genetechies.ecust_meeting_room.service.RoomAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/reservation/")
public class ReservationsController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private ReservationService reservationsService;

    @Autowired
    private RoomAdminService roomAdminService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "getReservationsByUserId",method = RequestMethod.GET)
    public ECUSTResponse<List<Reservation>> getReservationsByUserId(@RequestParam(value = "userId") String userId){
        logger.info("call:/api/reservation/getReservationsByUserId");
        ECUSTResponse<List<Reservation>> ecustResponse = new ECUSTResponse<>();
        try{
            QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id",userId);
            List<Reservation> reservations = reservationsService.list(queryWrapper);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }


    @RequestMapping(value = "createReservation",method = RequestMethod.POST)
    public ECUSTResponse<Void> createReservation(@RequestBody Reservation reservation){
        logger.info("call:/api/reservation/createReservation");
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            reservationsService.save(reservation);

            QueryWrapper<RoomAdmin> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("room_id",reservation.getRoomId());
            List<RoomAdmin> roomAdmins = roomAdminService.list(queryWrapper);
            List<Notification> notifications = createNotification(roomAdmins);
            notificationService.saveBatch(notifications);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw ECUSTException.instance(ex.getMessage(),ex);
        }
        return ecustResponse;
    }


    private List<Notification> createNotification(List<RoomAdmin> roomAdmins){
        List<Integer> roomAdminIds = roomAdmins.stream().map(RoomAdmin::getAdminId).toList();
        return roomAdminIds.stream().map(roomAdminId -> {
            Notification notification = new Notification();
            notification.setUserId(roomAdminId);
            return notification;
        }).toList();
    }


    @RequestMapping(value = "updateReservationById",method = RequestMethod.POST)
    public ECUSTResponse<Void> updateReservationById(@RequestBody Reservation reservation){
        logger.info("call:/api/reservation/updateReservationById");
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            reservationsService.updateById(reservation);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @RequestMapping(value = "removeReservationById",method = RequestMethod.POST)
    public ECUSTResponse<Void> removeReservationById(@RequestParam(value = "reservation_id")String reservation_id){
        logger.info("call:/api/reservation/removeReservationById");
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            reservationsService.removeById(reservation_id);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

}
