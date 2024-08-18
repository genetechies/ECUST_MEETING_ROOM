package com.genetechies.ecust_meeting_room.Controller;

import com.genetechies.ecust_meeting_room.Service.ReservationsService;
import com.genetechies.ecust_meeting_room.pojo.MeetingRoom;
import com.genetechies.ecust_meeting_room.pojo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    @RequestMapping(value = "/api/reservation/createReservation",method = RequestMethod.POST)
    public void createReservation(@RequestBody Reservation reservation){
        reservationsService.createReservations(reservation);
    }
}
