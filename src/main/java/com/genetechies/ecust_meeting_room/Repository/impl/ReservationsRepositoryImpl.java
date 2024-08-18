package com.genetechies.ecust_meeting_room.Repository.impl;

import com.genetechies.ecust_meeting_room.Repository.ReservationsRepository;
import com.genetechies.ecust_meeting_room.pojo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationsRepositoryImpl implements ReservationsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createReservation(Reservation reservation) {
        String sql = "insert reservations(room_id,user_id,subject,start_time,end_time,attendees,status) VALUES(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,reservation.getRoomId(),reservation.getUserId(),reservation.getSubject(),reservation.getStartTime(),reservation.getEndTime(),reservation.getAttendees(),reservation.getStatus());
    }
}
