package com.genetechies.ecust_meeting_room.controller;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.genetechies.ecust_meeting_room.domain.*;
import com.genetechies.ecust_meeting_room.pojo.*;
import com.genetechies.ecust_meeting_room.service.*;
import com.genetechies.ecust_meeting_room.service.impl.MeetingRoomReservationServiceImpl;
import io.swagger.annotations.ApiOperation;
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
    private MeetingRoomReservationServiceImpl meetingRoomReservationService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "get reservation info by admin id",notes = "param: {\"pageNo\":1,\"pageSize\":5,\"userId\":6,\"status\":\"approval\"}")
    @RequestMapping(value = "getReservationsByUserId",method = RequestMethod.POST)
    public ECUSTResponse<PageResponse<Reservation>> getReservationsByUserId(@RequestBody ReservationUserVo reservationUserVo){
        logger.info("call:/api/reservation/getReservationsByUserId");
        ECUSTResponse<PageResponse<Reservation>> ecustResponse = new ECUSTResponse<>();
        try{
            IPage<Reservation> page = new Page<>(reservationUserVo.getPageNo(), reservationUserVo.getPageSize());

            QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id",reservationUserVo.getUserId());
            queryWrapper.eq("status",reservationUserVo.getStatus());
            IPage<Reservation> reservationIPage = reservationsService.page(page,queryWrapper);
            ecustResponse.setData(new PageResponse<>(reservationIPage.getTotal(),reservationIPage.getPages(),reservationIPage.getSize(),reservationIPage.getCurrent(),reservationIPage.getRecords()));
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @ApiOperation(value = "get reservation info ",notes = "param: {\"userId\":1,\"startTime\":\"2024-08-30 08:30:00\",\"endTime\":\"2024-08-30 18:30:00\",\"status\":\"approval\"}")
    @RequestMapping(value = "getReservationsByUserIdAndDateRangeAndStatus",method = RequestMethod.POST)
    public ECUSTResponse<List<Reservation>> getReservationsByUserIdAndDateRangeAndStatus(@RequestBody ReservationUserDataRangeStatusVo reservationUserDataRangeStatusVo){
        logger.info("call:/api/reservation/getReservationsByUserIdAndDateRangeAndStatus");
        ECUSTResponse<List<Reservation>> ecustResponse = new ECUSTResponse<>();
        try{
            User user = userService.getById(reservationUserDataRangeStatusVo.getUserId());
            QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
            if(!user.getRole().equals(Constants.SYS_ADMIN)){
                queryWrapper.eq("user_id",reservationUserDataRangeStatusVo.getUserId());
            }
            queryWrapper.eq("status",reservationUserDataRangeStatusVo.getStatus());
            queryWrapper.ge("start_time",reservationUserDataRangeStatusVo.getStartTime());
            queryWrapper.le("end_time",reservationUserDataRangeStatusVo.getEndTime());
            List<Reservation> reservationList = reservationsService.list(queryWrapper);
            ecustResponse.setData(reservationList);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }


    @ApiOperation(value = "get reservation info by admin id",notes = "param: {\"adminId\":1,\"pageNo\":1,\"pageSize\":2}")
    @RequestMapping(value = "getReservationsByAdminId",method = RequestMethod.POST)
    public ECUSTResponse<PageResponse<Reservation>> getReservationsByAdminId(@RequestBody ReservationAdminIdVo reservationAdminIdVo){
        logger.info("call:/api/reservation/getReservationsByAdminId");
        ECUSTResponse<PageResponse<Reservation>> ecustResponse = new ECUSTResponse<>();
        try{
            IPage<Reservation>  reservationIPage= meetingRoomReservationService.selectReserveMeetingRoomByAdminId(reservationAdminIdVo);
            ecustResponse.setData(new PageResponse<>(reservationIPage.getTotal(),reservationIPage.getPages(),reservationIPage.getSize(),reservationIPage.getCurrent(),reservationIPage.getRecords()));
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @ApiOperation(value = "get all waited reservation ",notes = "param: {\"pageNo\":1,\"pageSize\":5,\"status\":\"approval\"}")
    @RequestMapping(value = "getAllReservation",method = RequestMethod.POST)
    public ECUSTResponse<PageResponse<Reservation>> getAllReservation(@RequestBody ReservationVo reservationVo){
        logger.info("call:/api/reservation/getAllReservation");
        ECUSTResponse<PageResponse<Reservation>> ecustResponse = new ECUSTResponse<>();
        try{
            IPage<Reservation> page = new Page<>(reservationVo.getPageNo(), reservationVo.getPageSize());
            QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("status",reservationVo.getStatus());

            IPage<Reservation>  reservationIPage= reservationsService.page(page,queryWrapper);
            ecustResponse.setData(new PageResponse<>(reservationIPage.getTotal(),reservationIPage.getPages(),reservationIPage.getSize(),reservationIPage.getCurrent(),reservationIPage.getRecords()));
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    @ApiOperation(value = "create reservation",notes = "param: {\"roomId\":1,\"userId\":1,\"subject\":\"测试\",\"status\":\"pending_approval\",\"startTime\":\"2024-03-12 15:30:00\",\"endTime\":\"2024-03-12 17:30:00\",\"attendees\":6}")
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
            notification.setMessage(Message.NOTIFICATION);
            return notification;
        }).toList();
    }


    @ApiOperation(value = "update reservation status",notes = "param: {\"reservationId\":1,\"status\":\"approval\",\"startTime\":\"2024-08-18 16:44:00\",\"endTime\":\"2024-08-18 17:44:00\"}")
    @RequestMapping(value = "updateReservationStatusById",method = RequestMethod.POST)
    public ECUSTResponse<Void> updateReservationStatusById(@RequestBody Reservation reservation){
        logger.info("call:/api/reservation/updateReservationStatusById");
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            updateReservationStatus(reservation);
            if(reservation.getStatus().equals(Status.APPROVAL)){
                rejectOverlapReservation(reservation);
            }
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw ECUSTException.instance(e.getMessage(),e);
        }
        return ecustResponse;
    }

    private void updateReservationStatus(Reservation reservation){
        UpdateWrapper<Reservation> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("status", reservation.getStatus());
        updateWrapper.eq("reservation_id",reservation.getReservationId());
        reservationsService.update(updateWrapper);

    }

    private void rejectOverlapReservation(Reservation reservation){
        UpdateWrapper<Reservation> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("status", Status.REFUSAL);
        updateWrapper.or(r->r.lt("start_time",reservation.getStartTime()).gt("end_time",reservation.getEndTime()))
                .or(r-> r.gt("start_time",reservation.getStartTime()).lt("start_time",reservation.getEndTime()))
                .or(r->r.gt("end_time",reservation.getStartTime()).lt("end_time",reservation.getEndTime()))
                .or(r->r.lt("start_time",reservation.getStartTime()).lt("end_time",reservation.getEndTime()))
                .ne("reservation_id",reservation.getReservationId()).eq("status",Status.PENDING_APPROVAL)
                .eq("room_id",reservation.getRoomId());
        reservationsService.update(updateWrapper);
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
