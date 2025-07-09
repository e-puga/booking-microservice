package com.eypa.msa.booking_microservice.controller;

import com.eypa.msa.booking_microservice.entity.BookingEntity;
import com.eypa.msa.booking_microservice.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService _bookingService;

    public BookingController(BookingService bookingService){
        this._bookingService = bookingService;
    }

    @PostMapping("/add")
    public ResponseEntity<BookingEntity> add(@RequestBody BookingEntity booking) {
        BookingEntity savedBooking = _bookingService.addBooking(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @GetMapping("/views")
    public List<BookingEntity> views(){
        return _bookingService.getAllBookings();
    }

    @GetMapping("/views/{id}")
    public ResponseEntity<BookingEntity> views(@PathVariable Long id){
        try{
            BookingEntity booking = _bookingService.getBookingById(id);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<BookingEntity> update(@RequestBody BookingEntity booking) {
        try{
            BookingEntity updatedBooking = _bookingService.updateBooking(booking);
            return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try{
            _bookingService.deleteBooking(id);
            return new ResponseEntity<>("Booking deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("booking not found", HttpStatus.NOT_FOUND);
        }
    }
}
