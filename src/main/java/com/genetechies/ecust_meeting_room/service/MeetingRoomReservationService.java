package com.genetechies.ecust_meeting_room.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.genetechies.ecust_meeting_room.pojo.MeetingRoomDateVo;

/**
* @author 98025
* @description 针对表【meeting_room】的数据库操作Service
* @createDate 2024-08-20 15:19:20
*/
public interface MeetingRoomReservationService extends IService<MeetingRoom> {

    IPage<MeetingRoom> selectReserveMeetingRoom(MeetingRoomDateVo meetingRoomSearchVo);

}
