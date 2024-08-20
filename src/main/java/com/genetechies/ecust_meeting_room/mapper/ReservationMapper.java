package com.genetechies.ecust_meeting_room.mapper;

import com.genetechies.ecust_meeting_room.domain.Reservation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 98025
* @description 针对表【reservation】的数据库操作Mapper
* @createDate 2024-08-20 19:03:39
* @Entity com.genetechies.ecust_meeting_room.domain.Reservation
*/
@Mapper
public interface ReservationMapper extends BaseMapper<Reservation> {

}




