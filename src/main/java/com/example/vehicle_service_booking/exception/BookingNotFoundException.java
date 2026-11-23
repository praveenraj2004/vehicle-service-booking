package com.example.vehicle_service_booking.exception;

public class BookingNotFoundException extends RuntimeException {

	public BookingNotFoundException(String message) {
		super(message);
	}
}
