package com.example.webrtc.demo.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentContoller {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @PostMapping("/makeAppointment")
    ResponseEntity<String> makeAppointment(@RequestBody  AppointmentEntity appointmentEntity){
        System.out.println(appointmentEntity);
        appointmentRepo.save(appointmentEntity);
        return ResponseEntity.ok("Appointment Made");
    }


}
