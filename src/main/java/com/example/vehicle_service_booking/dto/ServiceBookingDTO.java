package com.example.vehicle_service_booking.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.vehicle_service_booking.entity.BookingStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.FutureOrPresent;

public class ServiceBookingDTO {
    
	private Long bookingId;
	
	@NotBlank(message= "Customer name is required")
	private String customerName;
	
	@NotBlank(message = "Vehicle number is required")
	private String vehicleNumber;
	
	@NotBlank(message = "vehicle type is required")
	private String vehicleType;
	
	@NotBlank(message = "Service type is required")
	private String serviceType;
	
	@NotNull(message = "Booking date is required")
	@FutureOrPresent(message = "Booking date cannot be in the past")
	private LocalDate bookingDate;
	
	@NotNull(message =" Service cost is required")
	@Positive(message="Service cost must be greater than zero")
	private BigDecimal serviceCost;
	
	@NotNull(message = "Booking status is required")
	private BookingStatus status;
	
	
	public ServiceBookingDTO() {
		
	}


	public ServiceBookingDTO(Long bookingId, String customerName, String vehicleNumber, String vehicleType,
			String serviceType, LocalDate bookingDate, BigDecimal serviceCost, BookingStatus status) {
		super();
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.serviceType = serviceType;
		this.bookingDate = bookingDate;
		this.serviceCost = serviceCost;
		this.status = status;
	}


	public Long getBookingId() {
		return bookingId;
	}


	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getVehicleNumber() {
		return vehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public String getServiceType() {
		return serviceType;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	public LocalDate getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}


	public BigDecimal getServiceCost() {
		return serviceCost;
	}


	public void setServiceCost(BigDecimal serviceCost) {
		this.serviceCost = serviceCost;
	}


	public BookingStatus getStatus() {
		return status;
	}


	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	
	
}
