package com.genetechies.ecust_meeting_room;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.genetechies.ecust_meeting_room.domain.MeetingRoom;
import com.genetechies.ecust_meeting_room.mapper.MeetingRoomReservationMapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class MappTest {

    @Autowired
    private MeetingRoomReservationMapper meetingRoomReservationMapper;

    @Test
    void testMeetingRoomReservation(){
        IPage<MeetingRoom> page = new Page<>(1, 2);
        LocalDateTime startTime = LocalDateTime.of(2024,8,18,16,40);
        LocalDateTime endTime = LocalDateTime.of(2024,8,18,17,43);
        IPage<MeetingRoom> meetingRoomList = meetingRoomReservationMapper.selectReserveMeetingRoom(page,1,startTime,endTime);
        System.out.println(meetingRoomList.getRecords());
    }
}
