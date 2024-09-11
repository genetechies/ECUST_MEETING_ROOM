package com.genetechies.ecust_meeting_room.mapper;

import com.genetechies.ecust_meeting_room.domain.RoomAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 98025
* @description 针对表【room_admin】的数据库操作Mapper
* @createDate 2024-08-21 22:24:41
* @Entity com.genetechies.ecust_meeting_room.domain.RoomAdmin
*/
@Mapper
public interface RoomAdminMapper extends BaseMapper<RoomAdmin> {


    List<RoomAdmin> getAdminsByRoomId(@Param("roomId") String roomId);
}




