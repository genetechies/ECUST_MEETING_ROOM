package com.genetechies.ecust_meeting_room.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.genetechies.ecust_meeting_room.mapper.MeetingRoomMapper;
import com.genetechies.ecust_meeting_room.mapper.MeetingRoomReservationMapper;
import com.genetechies.ecust_meeting_room.pojo.MeetingRoomDateVo;
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
    public IPage<MeetingRoom> selectReserveMeetingRoom(MeetingRoomDateVo meetingRoomSearchVo) {
        IPage<MeetingRoom> page = new Page<>(meetingRoomSearchVo.getPageNo(), meetingRoomSearchVo.getPageSize());
        return meetingRoomReservationMapper.selectReserveMeetingRoom(page,meetingRoomSearchVo.getRoomId(),meetingRoomSearchVo.getStartTime(),meetingRoomSearchVo.getEndTime());

    }
}







