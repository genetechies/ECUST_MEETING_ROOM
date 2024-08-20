package com.genetechies.ecust_meeting_room.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.genetechies.ecust_meeting_room.domain.Reservation;
import com.genetechies.ecust_meeting_room.service.ReservationService;
import com.genetechies.ecust_meeting_room.mapper.ReservationMapper;
import org.springframework.stereotype.Service;

/**
* @author 98025
* @description 针对表【reservation】的数据库操作Service实现
* @createDate 2024-08-20 19:03:39
*/
@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation>
    implements ReservationService{

}




