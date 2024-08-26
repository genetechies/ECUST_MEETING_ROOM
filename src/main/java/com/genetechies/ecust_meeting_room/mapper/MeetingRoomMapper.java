package com.genetechies.ecust_meeting_room.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 98025
* @description 针对表【meeting_room】的数据库操作Mapper
* @createDate 2024-08-20 15:19:20
* @Entity com.genetechies.ecust_meeting_room.domain.MeetingRoom
*/
@Mapper
public interface MeetingRoomMapper extends BaseMapper<MeetingRoom> {


}




