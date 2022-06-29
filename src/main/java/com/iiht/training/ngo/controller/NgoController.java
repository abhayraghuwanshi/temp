package com.iiht.training.ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.ngo.dto.DonarDto;
import com.iiht.training.ngo.dto.DonationRequestDto;
import com.iiht.training.ngo.dto.NgoDto;
import com.iiht.training.ngo.service.DonarService;
import com.iiht.training.ngo.service.DonationRequestService;
import com.iiht.training.ngo.service.NgoService;

@RestController
@RequestMapping("/ngos")
public class NgoController {

	@Autowired
	private NgoService ngoService;

	@Autowired
	private DonationRequestService donationRequestService;

	@Autowired
	private DonarService donarService;
	
	@RequestMapping(value="register-ngo", method=RequestMethod.POST) //post, return dto, parameter - dto
	public NgoDto registerNgo(@RequestBody NgoDto don) {
		return ngoService.registerNgo(don);
	}
    
	@RequestMapping(value="=/update-ngo", method=RequestMethod.PUT) //put parameter-dto, return dto
	public NgoDto updateNgo(@RequestBody NgoDto ngo) {
		return ngoService.updateNgo(ngo);
	}

	@RequestMapping(value="/get/{ngoId}", method=RequestMethod.GET) // get, donarId, DonarDto
	public NgoDto getANgo(@PathVariable(value = "ngoId") Long ngoId) {
		return ngoService.getNgoById(ngoId);
	}

	@RequestMapping(value="/all", method=RequestMethod.GET)
	 public List<NgoDto> getAllNgos() {
		return ngoService.getAllNgos();
		
	}

	@RequestMapping(value="/delete/{ngoId}", method=RequestMethod.DELETE) //delete, donarId, boolean
	public Boolean deleteNgo(@PathVariable(value = "ngoId") Long ngoId) {
		return ngoService.deleteNgo(ngoId);
    }

	@RequestMapping(value="/create-donation-request")
	public DonationRequestDto createDonationRequest(@RequestBody DonationRequestDto don) {
		return donationRequestService.createDonationRequest(don);
	}
	@RequestMapping(value="/donation-request-by-ngo/{ngold}") 
	public List<DonationRequestDto> getDonationRequestNotification(@PathVariable(value = "ngoId") Long ngoId) {
		return donationRequestService.getDonationRequestNotification(ngoId);
	}
	
	@RequestMapping(value="/donation-request-by-donar/{donorId}") 
	public List<DonationRequestDto> getDonationRequestByDonarId(@PathVariable(value = "donorId") Long donorId) {
		return donationRequestService.getDonationRequestByDonarId(donorId);
	}

	
}
