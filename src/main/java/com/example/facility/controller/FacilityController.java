package com.example.facility.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.facility.dto.FacilityDto;
import com.example.facility.dto.ResponseFacilityDto;
import com.example.facility.model.Facility;
import com.example.facility.service.FacilityService;

@RestController
public class FacilityController {
	@Autowired
	FacilityService facilityService;
	@PostMapping("/facility")
	public ResponseEntity<ResponseFacilityDto> saveFacility(@Valid @RequestBody FacilityDto facility) {
		ResponseFacilityDto facility1 = facilityService.saveFacility(facility);
		facility1.setMessage("Facility created successfully");
		return new ResponseEntity<>(facility1, HttpStatus.OK);
	}

	@PutMapping("/facility")
	public ResponseEntity<String> UpdateFacility(@Valid @RequestBody FacilityDto facility) {
		facilityService.updateFacility(facility);
		return new ResponseEntity<>("Facility is Updated successfully", HttpStatus.OK);
	}

	@GetMapping("/facility")
	public ResponseEntity<FacilityDto> getFacility(@RequestParam Long id) {
		FacilityDto facility = facilityService.getFacility(id);
		return new ResponseEntity<>(facility, HttpStatus.OK);

	}
	@GetMapping("/facility/{id}")

	 public ResponseEntity<Facility> getFacility1(@PathVariable Long id) {
	 Facility facility = facilityService.getFacilityById(id);
	 return new ResponseEntity<>(facility, HttpStatus.OK);

	 }


	@DeleteMapping("/acility")
	public ResponseEntity<String> deleteFacility(@RequestParam Long id) {
		facilityService.deleteFacility(id);
		return new ResponseEntity<>("employee with id "+id+" is  deleted successfully", HttpStatus.OK);

	}


}
