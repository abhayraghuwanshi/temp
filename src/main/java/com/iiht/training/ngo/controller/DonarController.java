package com.iiht.training.ngo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.ngo.dto.DonarDto;
import com.iiht.training.ngo.dto.DonationDto;
import com.iiht.training.ngo.repository.DonarRepository;
import com.iiht.training.ngo.service.DonarService;
import com.iiht.training.ngo.service.DonationService;
import com.iiht.training.ngo.entity.DonarEntity;
import java.util.List;
/*
●	Controller class to expose all rest-endpoints for Donar and Donations related activities.
●	May also contain local exception handler methods
*/

@RestController
@RequestMapping("/")
public class DonarController {

	@Autowired
	private DonarService donarService;

	@Autowired
	private DonationService donationService;



	@RequestMapping(value="donars/register-donar", method=RequestMethod.POST) //post, return dto, parameter - dto
	public DonarDto registerDonar (@RequestBody DonarDto don) {
//		if (don == null) {
//			throw new exception
//		}
		return donarService.registerDonar(don);
	}
    
	@RequestMapping(value="donars/update-donar", method=RequestMethod.PUT) //put parameter-dto, return dto
	public DonarDto updateDonar(@RequestBody DonarDto don) {
		
		return donarService.updateDonar(don);
	}

	@RequestMapping(value="donars/get/{donarId}", method=RequestMethod.GET) // get, donarId, DonarDto
	public DonarDto getASellers(@PathVariable(value = "donarId") Long donarId) {
		return donarService.getDonarById(donarId);
	}

	@RequestMapping(value="donar/all", method=RequestMethod.GET)
	 public List<DonarDto> getAllDonar() {
//		System.out.println(donarService.getAllDonars());
		return donarService.getAllDonars();
		
	}

	@RequestMapping(value="donars/delete/{donarId}", method=RequestMethod.DELETE) //delete, donarId, boolean
	public Boolean deleteDonar(@PathVariable(value = "customerID") Long customerId) {
		return donarService.deleteDonar(customerId);
    }

	@RequestMapping(value="donars/get-by-ngo/{ngold}") 
	public DonarDto getAllDonarByNGOs(@PathVariable(value = "ngoId") Long ngoId) {
		return donarService.getDonarById(ngoId);
	}
	//////////////////////////////////////////////////////

	
	@RequestMapping(value="/donations/add-donation", method=RequestMethod.POST) //get,ngold, list donlardto
	public DonationDto addDonation(@RequestBody DonationDto don) {
		return donationService.registerDonation(don);
	}

	@RequestMapping(value="/donations/update-donation", method=RequestMethod.PUT) //get,ngold, list donlardto
	public DonationDto updateDonation(@RequestBody DonationDto don) {
		return donationService.updateDonation(don);
	}

	@RequestMapping(value="/donations/delete/{donationId}", method=RequestMethod.DELETE) 
	public boolean deleteDonation(@PathVariable(value = "donationId") Long donationId) {
		return donationService.deleteDonation(donationId);
	}

	@RequestMapping(value="/donations/get/{donationId}", method=RequestMethod.GET) 
	public DonationDto getDonationById(@PathVariable(value = "donationId") Long donationId) {
		return donationService.getDonationById(donationId);
	}

	@RequestMapping(value="/donations/all", method=RequestMethod.GET) 
	public List<DonationDto> getAllDonations() {
		return donationService.getAllDonations();
	}

	@RequestMapping(value="/donations/get-by-donor/{donorId}", method=RequestMethod.GET) 
	public List<DonationDto> getDonationsByDonorId(@PathVariable(value = "donorId") Long donorId) {
		return donationService.getDonationsByDonorId(donorId);
	}

	@RequestMapping(value="/donations/get-by-ngo/{ngoId}", method=RequestMethod.GET) 
	public List<DonationDto> getByNgoDonation(@PathVariable(value = "ngoId") Long ngoId) {
		return donationService.getDonationsByNgoId(ngoId);
	}

}