package com.genetechies.ecust_meeting_room.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.genetechies.ecust_meeting_room.domain.Reservation;
import com.genetechies.ecust_meeting_room.mapper.MeetingRoomMapper;
import com.genetechies.ecust_meeting_room.mapper.MeetingRoomReservationMapper;
import com.genetechies.ecust_meeting_room.pojo.MeetingRoomDateVo;
import com.genetechies.ecust_meeting_room.pojo.ReservationAdminIdVo;
import com.genetechies.ecust_meeting_room.service.MeetingRoomReservationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 98025
* @description 针对表【meeting_room】的数据库操作Service实现
* @createDate 2024-08-20 15:19:20
*/
@Service
public class MeetingRoomReservationServiceImpl extends ServiceImpl<MeetingRoomReservationMapper, MeetingRoom>
    implements MeetingRoomReservationService {

    @Resource
    private MeetingRoomMapper meetingRoomMapper;

    @Resource
    private MeetingRoomReservationMapper meetingRoomReservationMapper;

    @Override
    public IPage<MeetingRoom> selectReserveMeetingRoom(MeetingRoomDateVo meetingRoomDateVo) {
        IPage<MeetingRoom> page = new Page<>(meetingRoomDateVo.getPageNo(), meetingRoomDateVo.getPageSize());
        return meetingRoomReservationMapper.selectReserveMeetingRoom(page,meetingRoomDateVo.getRoomId(),meetingRoomDateVo.getStartTime(),meetingRoomDateVo.getEndTime());

    }

    @Override
    public IPage<Reservation> selectReserveMeetingRoomByAdminId(ReservationAdminIdVo reservationAdminIdVo) {
        IPage<Reservation> page = new Page<>(reservationAdminIdVo.getPageNo(),reservationAdminIdVo.getPageSize());
        return meetingRoomReservationMapper.selectReserveMeetingRoomByAdminId(page,reservationAdminIdVo.getAdminId());
    }
}







