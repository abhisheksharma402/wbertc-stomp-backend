package com.example.webrtc.demo.Patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<PatientEntity, Integer>{

    PatientEntity getByEmail(String email);


}
