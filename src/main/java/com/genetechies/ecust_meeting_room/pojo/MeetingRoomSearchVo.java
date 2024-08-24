package com.genetechies.ecust_meeting_room.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class MeetingRoomSearchVo {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime endTime;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "MeetingRoomSearchVo{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}


