package com.example.webrtc.demo.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<AppointmentEntity, Integer> {

}
