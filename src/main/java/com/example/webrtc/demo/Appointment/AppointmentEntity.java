package com.example.webrtc.demo.Appointment;


import com.example.webrtc.demo.Doctor.DoctorEntity;
import com.example.webrtc.demo.Patient.PatientEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="appointment")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="roomId")
    private String roomId;

    @ManyToOne
    @JoinColumn(name="doctorId",nullable = false)
    @JsonIgnoreProperties("appointments")
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(name="patientId",nullable = false)
    @JsonIgnoreProperties("appointments")
    private PatientEntity patient;

}
