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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
}
