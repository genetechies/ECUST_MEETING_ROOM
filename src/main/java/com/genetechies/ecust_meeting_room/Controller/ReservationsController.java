package com.genetechies.ecust_meeting_room.Controller;

import com.genetechies.ecust_meeting_room.Service.ReservationsService;
import com.genetechies.ecust_meeting_room.pojo.ECUSTException;
import com.genetechies.ecust_meeting_room.pojo.ECUSTResponse;
import com.genetechies.ecust_meeting_room.pojo.MeetingRoom;
import com.genetechies.ecust_meeting_room.pojo.Reservation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationsController {

    private static final Logger logger = Logger.getLogger(ReservationsController.class);

    @Autowired
    private ReservationsService reservationsService;

    @RequestMapping(value = "/api/reservation/createReservation",method = RequestMethod.POST)
    public ECUSTResponse<Void> createReservation(@RequestBody Reservation reservation){
        ECUSTResponse<Void> ecustResponse = new ECUSTResponse<>();
        try{
            reservationsService.createReservations(reservation);
            ecustResponse.setCode(ECUSTResponse.OK);
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw ECUSTException.instance(ex.getMessage(),ex);
        }
        return ecustResponse;
    }
}
