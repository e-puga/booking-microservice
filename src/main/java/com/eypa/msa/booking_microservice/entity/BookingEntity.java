package com.eypa.msa.booking_microservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.aot.generate.GeneratedTypeReference;

@Entity
@Data
@Table(name = "booking")

public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
}
