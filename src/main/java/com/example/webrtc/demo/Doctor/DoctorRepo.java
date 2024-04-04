package com.example.webrtc.demo.Doctor;

import com.example.webrtc.demo.Appointment.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<DoctorEntity, Integer> {

    DoctorEntity getByEmail(String email);

}
