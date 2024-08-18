package com.genetechies.ecust_meeting_room.Service.impl;

import com.genetechies.ecust_meeting_room.Repository.ReservationsRepository;
import com.genetechies.ecust_meeting_room.Service.ReservationsService;
import com.genetechies.ecust_meeting_room.pojo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationsService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Override
    public void createReservations(Reservation reservation) {
        reservationsRepository.createReservation(reservation);
    }
}
