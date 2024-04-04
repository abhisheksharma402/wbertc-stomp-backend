package com.example.webrtc.demo.Patient;


import com.example.webrtc.demo.Doctor.DoctorEntity;
import com.example.webrtc.demo.Doctor.DoctorRepo;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @PostMapping("/signup")
    ResponseEntity<String> signup(@RequestBody PatientEntity patient){
        patientRepo.save(patient);
        return ResponseEntity.ok("Signed Up");
    }

    @PostMapping("/login")
    ResponseEntity<PatientEntity> login(@RequestBody Map<String, Object> details){
        String email = details.get("email").toString();
        String pass = details.get("password").toString();


        if(email.isEmpty() || pass.isEmpty()){
//            return ResponseEntity.ok()
        }

        PatientEntity patient = patientRepo.getByEmail(email);

        if(patient==null){
            return ResponseEntity.status(400).build();
        }
        if(patient.getPassword().compareTo(pass) != 0){
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.ok(patient);
    }


    @GetMapping("/doctors")
    List<DoctorEntity> getDoctors(){
        return doctorRepo.findAll();
    }


}
