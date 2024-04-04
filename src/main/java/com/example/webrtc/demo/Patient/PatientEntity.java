package com.example.webrtc.demo.Patient;

import com.example.webrtc.demo.Appointment.AppointmentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name="patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private @Getter int id;

    private @Getter String name;
    private @Getter String email;
    private @Getter String password;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private @Getter List<AppointmentEntity> appointments = new ArrayList<>();
}
