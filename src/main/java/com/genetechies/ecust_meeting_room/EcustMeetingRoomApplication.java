package com.genetechies.ecust_meeting_room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ServletComponentScan
public class EcustMeetingRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcustMeetingRoomApplication.class, args);
    }

}
