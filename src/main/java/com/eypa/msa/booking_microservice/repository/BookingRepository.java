package com.eypa.msa.booking_microservice.repository;

import com.eypa.msa.booking_microservice.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
}
