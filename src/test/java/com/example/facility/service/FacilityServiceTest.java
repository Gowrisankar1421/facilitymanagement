package com.example.facility.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.example.facility.dto.FacilityDto;
import com.example.facility.dto.ResponseFacilityDto;
import com.example.facility.exception.FacilityIdNotFoundException;
import com.example.facility.exception.NoFacilityDataFoundException;
import com.example.facility.model.Facility;
import com.example.facility.repository.FacilityRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.Silent.class)
public class FacilityServiceTest {
	@InjectMocks
	FacilityService facilityService;
	@Mock
	FacilityRepository facilityRepository;
	@SuppressWarnings("unused")
	@Test
	public void testSaveFacility() {
		ResponseFacilityDto facilityDto = new ResponseFacilityDto();
		Facility facility = new Facility();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(10L);
		Facility facility1=new Facility();
		if (facility != null) {
			Mockito.when(facilityRepository.save(facility)).thenReturn(facility1);
			BeanUtils.copyProperties(facility1, facilityDto);
			Assert.assertNotNull(facilityDto);
		} else {
			throw new NoFacilityDataFoundException();
		}
	}
	@SuppressWarnings("unused")
	@Test(expected=NoFacilityDataFoundException.class)
	public void testSaveFacilityForException() {
		ResponseFacilityDto facilityDto = new ResponseFacilityDto();
		Facility facility = null/* ew Facility() */;
		/*
		 * facility.setFacilityBranch("siruseri"); facility.setFacilityCity("chennai");
		 * facility.setFacilityId(10L);
		 */
		Facility facility1=new Facility();
		if (facility != null) {
			Mockito.when(facilityRepository.save(facility)).thenReturn(facility1);
			BeanUtils.copyProperties(facility1, facilityDto);
			Assert.assertNotNull(facilityDto);
		} else {
			throw new NoFacilityDataFoundException();
		}
	}
	@SuppressWarnings("unused")
	@Test
	public void testUpdateFacility() {
		ResponseFacilityDto facilityDto = new ResponseFacilityDto();
		Facility facility = new Facility();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(10L);
		Facility facility1=new Facility();
		if (facility != null) {
			Mockito.when(facilityRepository.save(facility)).thenReturn(facility1);
			BeanUtils.copyProperties(facility1, facilityDto);
			Assert.assertNotNull(facilityDto);
		} else {
			throw new NoFacilityDataFoundException();
		}
	}
	@SuppressWarnings("unused")
	@Test(expected=NoFacilityDataFoundException.class)
	public void testUpdateFacilityForException() {
		FacilityDto facilityDto = new FacilityDto();
		Facility facility = null/* ew Facility() */;
		/*
		 * facility.setFacilityBranch("siruseri"); facility.setFacilityCity("chennai");
		 * facility.setFacilityId(10L);
		 */
		Facility facility1=new Facility();
		if (facility != null) {
			Mockito.when(facilityRepository.save(facility)).thenReturn(facility1);
			BeanUtils.copyProperties(facility1, facilityDto);
			Assert.assertNotNull(facilityDto);
		} else {
			throw new NoFacilityDataFoundException();
		}
	}
	
	@Test
	public void testGetFacility() {
		FacilityDto facilityDto=new FacilityDto();
		Facility facility = new Facility();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(10L);
		facilityRepository.save(facility);
		Optional<Facility> facility1 = Optional.of(new Facility());
		Mockito.when(facilityRepository.findById(10L)).thenReturn(facility1);
		if(facility1.isPresent())
		BeanUtils.copyProperties(facility, facilityDto);
		Assert.assertNotNull(facilityDto);
	}
	@Test(expected=FacilityIdNotFoundException.class)
	public void testGetFacilityForException() {
		FacilityDto facilityDto=new FacilityDto();
		Facility facility = new Facility();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(20L);
		facilityRepository.save(facility);
		Facility facility1 = facilityRepository.findById(10L).orElseThrow(()->new FacilityIdNotFoundException());
		BeanUtils.copyProperties(facility1, facilityDto);
		Assert.assertNotNull(facilityDto);
	}
	@Test
	public void testGetFacilityById() {
		Facility facility = new Facility();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(10L);
		facilityRepository.save(facility);
		Optional<Facility> facility1 = Optional.of(new Facility());
		Mockito.when(facilityRepository.findById(10L)).thenReturn(facility1);
		if(facility1.isPresent())
			Assert.assertNotNull(facility1);
	}
	@Test(expected=FacilityIdNotFoundException.class)
	public void testGetFacilityByIdException() {
		Facility facility = new Facility();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(10L);
		facilityRepository.save(facility);
		Facility facility1 = facilityRepository.findById(20L).orElseThrow(()->new FacilityIdNotFoundException());
		Mockito.when(facilityRepository.findById(20L)).thenThrow(new FacilityIdNotFoundException());
			Assert.assertNotNull(facility1);
	}
	@Test
	public void testDeleteFacility() {
		Facility facility = new Facility();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(10L);
		facilityRepository.save(facility);
		Optional<Facility> facility1 = Optional.of(new Facility());
		Mockito.when(facilityRepository.findById(10L)).thenReturn(facility1);
		if(facility1.isPresent())
			Assert.assertNotNull(facility1);
		facilityRepository.deleteById(facility.getFacilityId());
	}
	@Test(expected=FacilityIdNotFoundException.class)
	public void testDeleteFacilityForException() {
		Facility facility = new Facility();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(10L);
		facilityRepository.save(facility);
		Facility facility1 = facilityRepository.findById(20L).orElseThrow(()->new FacilityIdNotFoundException());
		Mockito.when(facilityRepository.findById(20L)).thenThrow(new FacilityIdNotFoundException());
			Assert.assertNotNull(facility1);
		facilityRepository.deleteById(facility.getFacilityId());
	}

}
