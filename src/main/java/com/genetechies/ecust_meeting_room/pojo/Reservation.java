package com.genetechies.ecust_meeting_room.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Reservation {

    public Integer reservationId;

    public Integer roomId;

    public Integer userId;

    public String subject;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date endTime;

    public Integer attendees;

    public String status;

    public Integer getReservationId() {
        return reservationId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getSubject() {
        return subject;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Integer getAttendees() {
        return attendees;
    }

    public String getStatus() {
        return status;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setAttendees(Integer attendees) {
        this.attendees = attendees;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
