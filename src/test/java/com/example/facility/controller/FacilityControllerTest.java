package com.example.facility.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.facility.dto.FacilityDto;
import com.example.facility.dto.ResponseFacilityDto;
import com.example.facility.model.Facility;
import com.example.facility.service.FacilityService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FacilityControllerTest {
	@InjectMocks
	FacilityController facilityController;
	@Mock
	FacilityService facilityService;
	
	@Test
	public void testSaveFacility() {
		Facility facility = new Facility();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(10);
		ResponseFacilityDto responseDto = new ResponseFacilityDto();
		responseDto.setFacilityBranch(facility.getFacilityBranch());
		responseDto.setFacilityCity(facility.getFacilityCity());
		responseDto.setFacilityId(facility.getFacilityId());
		Mockito.when(facilityService.saveFacility(Mockito.any())).thenReturn(responseDto);
		Assert.assertNotNull(responseDto);
		
	}
	@Test
	public void testUpdateFacility() {
		Facility facility = new Facility();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(10);
		FacilityDto responseDto = new FacilityDto();
		responseDto.setFacilityBranch(facility.getFacilityBranch());
		responseDto.setFacilityCity(facility.getFacilityCity());
		responseDto.setFacilityId(facility.getFacilityId());
		Mockito.when(facilityService.updateFacility(Mockito.any())).thenReturn(responseDto);
		Assert.assertNotNull(responseDto);
	}
	@Test
	public void testGetFacility() {
		FacilityDto facility = new FacilityDto();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(10L);
		Facility facility1 = new Facility();
		facility1.setFacilityBranch("siruseri");
		facility1.setFacilityCity("chennai");
		facility1.setFacilityId(10L);
		Mockito.when(facilityService.getFacility(10L)).thenReturn(facility);
		Assert.assertEquals(facility1.getFacilityId(), facility.getFacilityId());
		
	}
	@Test
	public void testGetFacility1() {
		Facility facility = new Facility();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(10L);
		Facility facility1 = new Facility();
		facility1.setFacilityBranch("siruseri");
		facility1.setFacilityCity("chennai");
		facility1.setFacilityId(10L);
		Mockito.when(facilityService.getFacilityById(10L)).thenReturn(facility);
		Assert.assertEquals(facility1.getFacilityId(), facility.getFacilityId());
	}
	@Test
	public void testDeleteFacility() {
		Facility facility = new Facility();
		facility.setFacilityBranch("siruseri");
		facility.setFacilityCity("chennai");
		facility.setFacilityId(10L);
		Facility facility1 = new Facility();
		facility1.setFacilityBranch("siruseri");
		facility1.setFacilityCity("chennai");
		facility1.setFacilityId(20L);
		facilityService.deleteFacility(10L);
		Assert.assertNotNull(facility1);
	}

}
