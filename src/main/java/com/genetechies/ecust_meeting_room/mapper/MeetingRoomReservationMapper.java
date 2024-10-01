package com.genetechies.ecust_meeting_room.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.genetechies.ecust_meeting_room.domain.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface MeetingRoomReservationMapper extends BaseMapper<MeetingRoom> {

    IPage<MeetingRoom> selectReserveMeetingRoom(IPage<MeetingRoom> page,@Param("roomId") Integer roomId, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    IPage<Reservation> selectReserveMeetingRoomByAdminId(IPage<Reservation> page, @Param("adminId") Integer adminId, @Param("status") String status);

}
