package com.example.webrtc.demo.Doctor;

import com.example.webrtc.demo.Appointment.AppointmentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="doctor")
public class DoctorEntity {

    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Getter
    private String name;
    @Getter
    private String email;
    @Getter
    private String password;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<AppointmentEntity> appointments = new ArrayList<>();
}
