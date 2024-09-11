package com.genetechies.ecust_meeting_room.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.genetechies.ecust_meeting_room.domain.RoomAdmin;
import com.genetechies.ecust_meeting_room.service.RoomAdminService;
import com.genetechies.ecust_meeting_room.mapper.RoomAdminMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 98025
* @description 针对表【room_admin】的数据库操作Service实现
* @createDate 2024-08-21 22:24:41
*/
@Service
public class RoomAdminServiceImpl extends ServiceImpl<RoomAdminMapper, RoomAdmin>
    implements RoomAdminService{

    @Resource
    private RoomAdminMapper roomAdminMapper;

    @Override
    public List<RoomAdmin> getAdminsByRoomId(String roomId) {
        return roomAdminMapper.getAdminsByRoomId(roomId);
    }
}




