package com.example.vehicle_service_booking.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.vehicle_service_booking.dto.ServiceBookingDTO;
import com.example.vehicle_service_booking.entity.BookingStatus;

public interface ServiceBookingService {

			ServiceBookingDTO createBooking(ServiceBookingDTO dto);
			
			List<ServiceBookingDTO>getAllBooking();
			
			ServiceBookingDTO getBookingById(Long id);
			
			ServiceBookingDTO updateBooking(Long id , ServiceBookingDTO dto);
			
			void deleteBooking(Long id);
			
			List<ServiceBookingDTO> getBookingByStatus(BookingStatus status);
			
			List<ServiceBookingDTO> getBookingByVehicleNumber(String vehicleNumber);
			
			BigDecimal getTotalCompletedRevenue();
			
			List<ServiceBookingDTO> getBookingsAboveCost(BigDecimal amount);
}
