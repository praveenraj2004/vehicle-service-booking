package com.example.vehicle_service_booking.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;
@Entity
@Table(name="service_bookings")
public class ServiceBookingEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
	@Column(nullable = false)
	private String customerName;
	
	@Column(nullable = false)
	private String vehicleNumber;
	
	@Column(nullable = false)
	private String vehicleType;
	
	@Column(nullable = false)
	private String serviceType;
	
	@Column(nullable = false)
	private LocalDate bookingDate;
	
	@Column(nullable = false)
	private BigDecimal serviceCost;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private BookingStatus status;
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
	public ServiceBookingEntity(Long bookingId, String customerName, String vehicleNumber, String vehicleType,
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
	public ServiceBookingEntity() {
		
	}
	@Override
	public String toString() {
		return "ServiceBookingEntity [bookingId=" + bookingId + ", customerName=" + customerName + ", vehicleNumber="
				+ vehicleNumber + ", vehicleType=" + vehicleType + ", serviceType=" + serviceType + ", bookingDate="
				+ bookingDate + ", serviceCost=" + serviceCost + ", status=" + status + "]";
	}	
}
