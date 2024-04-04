package com.example.webrtc.demo.Doctor;

import com.example.webrtc.demo.Appointment.AppointmentEntity;
import com.example.webrtc.demo.Patient.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepo doctorRepo;

    @PostMapping("/signup")
    ResponseEntity<String> signup(@RequestBody DoctorEntity doctor){
        doctorRepo.save(doctor);
        return ResponseEntity.ok("Signed Up");
    }

    @PostMapping("/login")
    ResponseEntity<DoctorEntity> login(@RequestBody Map<String, Object> details){
        String email = details.get("email").toString();
        String pass = details.get("password").toString();


        if(email.isEmpty() || pass.isEmpty()){
//            return ResponseEntity.ok()
        }

        DoctorEntity doctor = doctorRepo.getByEmail(email);

        if(doctor==null){
            return ResponseEntity.status(400).build();
        }
        if(doctor.getPassword().compareTo(pass) != 0){
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.ok(doctor);

    }

    @GetMapping("/allDoctors")
    List<DoctorEntity> getAllDocs(){
        return doctorRepo.findAll();
    }

    @GetMapping("/appointments")
    List<AppointmentEntity> getAppointments(@RequestParam int doctorId){
        System.out.println(doctorId);
        DoctorEntity doctor = doctorRepo.getReferenceById(doctorId);

        return doctor.getAppointments();

//        return ResponseEntity.ok("good");
//
////        assert doctor != null;
//        List<AppointmentEntity> appointmentEntities = doctor.getAppointments();
//
//        return ResponseEntity.ok(appointmentEntities);
    }

}
