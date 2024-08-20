package com.genetechies.ecust_meeting_room.controller;

import com.genetechies.ecust_meeting_room.domain.Reservation;
import com.genetechies.ecust_meeting_room.pojo.ECUSTException;
import com.genetechies.ecust_meeting_room.pojo.ECUSTResponse;
import com.genetechies.ecust_meeting_room.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/reservation/")
public class ReservationsController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private ReservationService reservationsService;

    @RequestMapping(value = "createReservation",method = RequestMethod.POST)
    public ECUSTResponse<Void> createReservation(@RequestBody Reservation reservation){
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            reservationsService.save(reservation);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw ECUSTException.instance(ex.getMessage(),ex);
        }
        return ecustResponse;
    }
}
