package com.genetechies.ecust_meeting_room.service;

import com.genetechies.ecust_meeting_room.domain.RoomAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 98025
* @description 针对表【room_admin】的数据库操作Service
* @createDate 2024-08-21 22:24:41
*/
public interface RoomAdminService extends IService<RoomAdmin> {

    List<RoomAdmin> getAdminsByRoomId(String roomId);

    List<RoomAdmin> getAllRoomsOwnedByAdminId(String adminId);
}
