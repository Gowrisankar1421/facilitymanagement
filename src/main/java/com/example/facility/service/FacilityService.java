package com.example.facility.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facility.dto.FacilityDto;
import com.example.facility.dto.ResponseFacilityDto;
import com.example.facility.exception.FacilityIdNotFoundException;
import com.example.facility.exception.NoFacilityDataFoundException;
import com.example.facility.model.Facility;
import com.example.facility.repository.FacilityRepository;
@Service
public class FacilityService {
	@Autowired
	FacilityRepository facilityRepository;
	
	public ResponseFacilityDto saveFacility(FacilityDto response) {
		Facility facility = new Facility();
		BeanUtils.copyProperties(response, facility);
		ResponseFacilityDto facilityDto = new ResponseFacilityDto();
		Facility facility1;
		facility1= facilityRepository.save(facility);
		if (facility1 != null) {
			
			BeanUtils.copyProperties(facility1, facilityDto);
			return facilityDto;
		} else {
			throw new NoFacilityDataFoundException();
		}

	}
	public FacilityDto updateFacility(FacilityDto response) {
		Facility facility = new Facility();
		BeanUtils.copyProperties(response, facility);
		FacilityDto facilityDto = new FacilityDto();
		Facility facility1;
		facility1= facilityRepository.save(facility);
		if (facility1 != null) {
			BeanUtils.copyProperties(facility1, facilityDto);
			return facilityDto;
		} else {
			throw new NoFacilityDataFoundException();
		}

	}


	public FacilityDto getFacility(Long id) {
		FacilityDto facilityDto=new FacilityDto();
		Facility facility = facilityRepository.findById(id).orElseThrow(()->new FacilityIdNotFoundException());
		BeanUtils.copyProperties(facility, facilityDto);
		return facilityDto;
	}

	public void deleteFacility(Long id) {
		Facility facility = facilityRepository.findById(id).orElseThrow(()->new FacilityIdNotFoundException());
		facilityRepository.deleteById(facility.getFacilityId());
	}
	public Facility getFacilityById(Long id) {
		Facility facility = facilityRepository.findById(id).orElseThrow(()->new FacilityIdNotFoundException());
		return facility;
	}


}

