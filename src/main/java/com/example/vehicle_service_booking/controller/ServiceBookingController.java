package com.example.vehicle_service_booking.controller;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.vehicle_service_booking.dto.ServiceBookingDTO;
import com.example.vehicle_service_booking.entity.BookingStatus;
import com.example.vehicle_service_booking.service.ServiceBookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookings")
public class ServiceBookingController {

	private final ServiceBookingService service;
	public ServiceBookingController(ServiceBookingService service) {
		this.service = service;
	}
	//create booking
	@PostMapping
	public ResponseEntity<ServiceBookingDTO> createbooking(@Valid @RequestBody ServiceBookingDTO dto) {
		
		 return new ResponseEntity<>(service.createBooking(dto), HttpStatus.CREATED);
	}
	//get booking
	@GetMapping
	public ResponseEntity<List<ServiceBookingDTO>> getAllBooking() {
		
		return new ResponseEntity<>(service.getAllBooking(), HttpStatus.OK);
	}
	
	//get booking by id
	@GetMapping("/{id}")
	public ResponseEntity<ServiceBookingDTO> getBookingById(@PathVariable Long id){
		return new ResponseEntity<>(service.getBookingById(id), HttpStatus.OK);
	}
	
	//update booking by id
	@PutMapping("/{id}")
	public ResponseEntity<ServiceBookingDTO> updateBookingById(@PathVariable Long id ,@Valid @RequestBody ServiceBookingDTO dto ){
		return new ResponseEntity<>(service.updateBooking(id, dto), HttpStatus.OK);
	}
	
	//delete by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		service.deleteBooking(id);
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
	}
	
	//get booking by status
	@GetMapping("/status/{status}")
	public ResponseEntity<List<ServiceBookingDTO>> getBookingByStatus(@PathVariable BookingStatus status){
		return new ResponseEntity<>(service.getBookingByStatus(status) , HttpStatus.OK);
	}
	
	//get booking by vehicle number
	@GetMapping("/vehicle/{vehicleNumber}")
	public ResponseEntity<List<ServiceBookingDTO>> getBookingByVehicleNumber(@PathVariable String vehicleNumber){
		return new ResponseEntity<>(service.getBookingByVehicleNumber(vehicleNumber) , HttpStatus.OK);
	}
	
	//get total revenue from completed status
	@GetMapping("/revenue")
	public ResponseEntity<BigDecimal> getTotalRevenue(){
		return new ResponseEntity<>(service.getTotalCompletedRevenue(), HttpStatus.OK);
	}

	//get booking above a particular service cost
	@GetMapping("/cost/above/{amount}")
	public ResponseEntity<List<ServiceBookingDTO>> getBookingsAboveCost(@PathVariable BigDecimal amount){
		return new ResponseEntity<>(service.getBookingsAboveCost(amount), HttpStatus.OK);
	}
}
