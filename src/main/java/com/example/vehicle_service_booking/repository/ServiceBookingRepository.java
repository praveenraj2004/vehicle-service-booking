package com.example.vehicle_service_booking.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vehicle_service_booking.entity.BookingStatus;
import com.example.vehicle_service_booking.entity.ServiceBookingEntity;

@Repository
public interface ServiceBookingRepository extends JpaRepository<ServiceBookingEntity , Long> {

			//find by status
			List<ServiceBookingEntity> findByStatus(BookingStatus status);
			
			//find by vehicle number
			List<ServiceBookingEntity> findByVehicleNumber( String vehicleNumber);
			
			//find booking where service cost is greater than given amount
			List<ServiceBookingEntity> findByServiceCostGreaterThan(BigDecimal amount);
			
}
