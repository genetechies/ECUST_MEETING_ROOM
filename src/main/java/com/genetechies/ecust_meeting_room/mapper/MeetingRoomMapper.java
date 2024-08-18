package com.genetechies.ecust_meeting_room.mapper;

import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 98025
* @description 针对表【meeting_room】的数据库操作Mapper
* @createDate 2024-08-18 23:41:46
* @Entity com.genetechies.ecust_meeting_room.domain.MeetingRoom
*/

@Mapper
public interface MeetingRoomMapper extends BaseMapper<MeetingRoom> {

}




