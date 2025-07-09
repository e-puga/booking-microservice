package com.eypa.msa.booking_microservice.service;

import com.eypa.msa.booking_microservice.entity.BookingEntity;
import com.eypa.msa.booking_microservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository _bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        _bookingRepository = bookingRepository;
    }

    public BookingEntity addBooking(BookingEntity booking){
        return _bookingRepository.save(booking);
    }

    public List<BookingEntity> getAllBookings(){
        return _bookingRepository.findAll();
    }

    public BookingEntity getBookingById(long id){
        return _bookingRepository.findById(id).orElseThrow(() ->  new RuntimeException("Booking no exists"));
    }

    public BookingEntity updateBooking(BookingEntity booking){
        if(!_bookingRepository.existsById(booking.getId())){
            throw new RuntimeException("Booking not found with id " + booking.getId());
        }
        return _bookingRepository.save(booking);
    }

    public void deleteBooking(Long id){
        if(!_bookingRepository.existsById(id)){
            throw new RuntimeException("Booking not found with id " + id);
        }
        _bookingRepository.deleteById(id);
    }
}