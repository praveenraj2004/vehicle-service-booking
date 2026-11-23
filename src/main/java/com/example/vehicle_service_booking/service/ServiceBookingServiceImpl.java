package com.example.vehicle_service_booking.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehicle_service_booking.dto.ServiceBookingDTO;
import com.example.vehicle_service_booking.dto.ServiceBookingDTOImpl;
import com.example.vehicle_service_booking.repository.ServiceBookingRepository;
import com.example.vehicle_service_booking.entity.BookingStatus;
import com.example.vehicle_service_booking.entity.ServiceBookingEntity;
import com.example.vehicle_service_booking.exception.BookingNotFoundException;

@Service
public class ServiceBookingServiceImpl implements ServiceBookingService{

	@Autowired	
	private ServiceBookingRepository repo;
	@Autowired
	private ServiceBookingDTOImpl dtoImpl;
	@Override
	public ServiceBookingDTO createBooking(ServiceBookingDTO dto) {
		// TODO Auto-generated method stub
		     ServiceBookingEntity entity = dtoImpl.toEntity(dto);
		      
		     ServiceBookingEntity saved = repo.save(entity);
		     	
		     	return dtoImpl.toDTO(saved);
	}

	@Override
	public List<ServiceBookingDTO> getAllBooking() {
		// TODO Auto-generated method stub
		
		    List<ServiceBookingEntity> entities = repo.findAll();
		    
		   List<ServiceBookingDTO> dtoList = new ArrayList<>();
		    for(ServiceBookingEntity entity : entities) {
		     ServiceBookingDTO dto =	dtoImpl.toDTO(entity);
		     dtoList.add(dto);
		    }
		    return dtoList;
		
	/*	return repo.findAll()
				.stream()
				//convert each entity object into DTO object
				.map(entity -> dtoImpl.toDTO(entity))
				.toList();*/
	}

	@Override
	public ServiceBookingDTO getBookingById(Long id) {
		// TODO Auto-generated method stub
	ServiceBookingEntity dataEntity = repo.findById(id)
			                    .orElseThrow(()-> new BookingNotFoundException("Service booking not found with id "+id));
	   return dtoImpl.toDTO(dataEntity);
		
	}

	@Override
	public ServiceBookingDTO updateBooking(Long id, ServiceBookingDTO dto) {
		// TODO Auto-generated method stub
		ServiceBookingEntity existedEntity = repo.findById(id)
                .orElseThrow(()-> new BookingNotFoundException("Service booking not found with id "+id));
		
		                     existedEntity.setCustomerName(dto.getCustomerName());
		                     existedEntity.setVehicleNumber(dto.getVehicleNumber());
		                     existedEntity.setVehicleType(dto.getVehicleType());
		                     existedEntity.setServiceType(dto.getServiceType());
		                     existedEntity.setBookingDate(dto.getBookingDate());
		                     existedEntity.setServiceCost(dto.getServiceCost());
		                     existedEntity.setStatus(dto.getStatus());
		                     
		                   ServiceBookingEntity updatedEntity = repo.save(existedEntity);
		 
		      return dtoImpl.toDTO(updatedEntity);
	}

	@Override
	public void deleteBooking(Long id) {
		// TODO Auto-generated method stub
	ServiceBookingEntity entity	= repo.findById(id)
			                    .orElseThrow(()-> new BookingNotFoundException("Booking service not found with id "+id));
		    repo.delete(entity);;
	}

	@Override
	public List<ServiceBookingDTO> getBookingByStatus(BookingStatus status) {
		// TODO Auto-generated method stub
		
		return repo.findByStatus(status)
				.stream()
				.map((entity) -> dtoImpl.toDTO(entity))
				.toList();
	}

	@Override
	public List<ServiceBookingDTO> getBookingByVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		return repo.findByVehicleNumber(vehicleNumber)
				.stream()
				.map(entity -> dtoImpl.toDTO(entity))
				.toList();
	}

	@Override
	public BigDecimal getTotalCompletedRevenue() {
		// TODO Auto-generated method stub
		
	List<ServiceBookingEntity>bookings = repo.findByStatus(BookingStatus.COMPLETED);
		BigDecimal totalRevenue = BigDecimal.ZERO;
		
		for(ServiceBookingEntity booking : bookings) {
			totalRevenue = totalRevenue.add(booking.getServiceCost());
		}
		
		return totalRevenue;
	/*	return repo.findByStatus(BookingStatus.COMPLETED)
				.stream()
				.map(entity ->entity.getServiceCost())
				.reduce(BigDecimal.ZERO, BigDecimal ::add); */
	}

	@Override
	public List<ServiceBookingDTO> getBookingsAboveCost(BigDecimal amount) {
		// TODO Auto-generated method stub
		
	List<ServiceBookingEntity>	entities = repo.findByServiceCostGreaterThan(amount);
	List<ServiceBookingDTO> dtoList = new ArrayList<>();
	for(ServiceBookingEntity entity : entities) {
	  ServiceBookingDTO	dto = dtoImpl.toDTO(entity);
	  dtoList.add(dto);
	}
	return dtoList;
	/*	return repo.findByServiceCostGreaterThan(amount)
	            .stream()
	            .map(dtoImpl::toDTO)
	            .toList(); */
	}

}
