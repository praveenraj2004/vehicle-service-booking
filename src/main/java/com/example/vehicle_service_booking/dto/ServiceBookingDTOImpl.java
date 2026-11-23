package com.example.vehicle_service_booking.dto;

import org.springframework.stereotype.Component;

import com.example.vehicle_service_booking.entity.ServiceBookingEntity;

@Component
public class ServiceBookingDTOImpl {

	// map Entity to DTO
	public ServiceBookingDTO toDTO(ServiceBookingEntity entity) {
		
		ServiceBookingDTO dto = new ServiceBookingDTO();
		          
						dto.setBookingId(entity.getBookingId());
						dto.setCustomerName(entity.getCustomerName());
						dto.setVehicleNumber(entity.getVehicleNumber());
						dto.setVehicleType(entity.getVehicleType());
						dto.setServiceType(entity.getServiceType());
						dto.setBookingDate(entity.getBookingDate());
						dto.setServiceCost(entity.getServiceCost());
						dto.setStatus(entity.getStatus());
		return dto;
	}
	
	//map DTO to Entity
	
	public ServiceBookingEntity toEntity(ServiceBookingDTO dto) {
		ServiceBookingEntity entity = new ServiceBookingEntity();
		
		entity.setBookingId(dto.getBookingId());
		entity.setCustomerName(dto.getCustomerName());
		entity.setVehicleNumber(dto.getVehicleNumber());
		entity.setVehicleType(dto.getVehicleType());
		entity.setServiceType(dto.getServiceType());
		entity.setBookingDate(dto.getBookingDate());
		entity.setServiceCost(dto.getServiceCost());
		entity.setStatus(dto.getStatus());
		
		return entity;
	}
}
