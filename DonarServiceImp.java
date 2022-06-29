package com.iiht.training.ngo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.ngo.dto.DonarDto;
import com.iiht.training.ngo.repository.DonarRepository;
import com.iiht.training.ngo.service.DonarService;
import com.iiht.training.ngo.entity.DonarEntity;
import org.modelmapper.ModelMapper;
import java.util.stream.Collectors;
/*
●	Implements DonarService. Contains template method implementation. 
●	Need to provide implementation for Donar related functionalities
●	Add required repository dependency

*/
@Service(value = "donarService")
public class DonarServiceImpl implements DonarService {

	@Autowired
	private DonarRepository donarRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DonarDto registerDonar(DonarDto donarDto) {
		return convertToDto(donarRepository.save(convertToEntity(donarDto)));
	}
	
	// NEED A LOOK
	@Override
	public DonarDto updateDonar(DonarDto donarDto) {
		DonarEntity cus = donarRepository.findById(donarDto.getDonarId()).get();
		
		cus.setAddress(donarDto.getAddress());
		cus.setPhoneNumber(donarDto.getPhoneNumber());
        cus.setEmailId(donarDto.getEmailId());
        cus.setUsername(donarDto.getUsername());
        cus.setPassword(donarDto.getPassword());
        cus.setNgoId(donarDto.getNgoId());
        // return sellerRepository.save(sellerDto);
        // return customerRepository.save(cus);
		return convertToDto(donarRepository.save(cus));
	}

	@Override
	public Boolean deleteDonar(Long donarid) {
		donarRepository.deleteById(donarid);
		return false;
	}

	@Override
	public DonarDto getDonarById(Long donarId) {
		return convertToDto(donarRepository.findById(donarId).get());
	}

	@Override
	public List<DonarDto> getAllDonars() {
		List<DonarEntity> dnrList = donarRepository.findAll();
		return dnrList.stream()
          .map(this::convertToDto)
          .collect(Collectors.toList());

	}

	//NEED A LOOK
	@Override
	public List<DonarDto> getDonarsRegisteredWithNgo(Long ngoId) {
		List<DonarEntity> dnrList = donarRepository.findAll();
		return dnrList.stream()
          .map(this::convertToDto)
          .collect(Collectors.toList());
	}


	private DonarDto convertToDto(DonarEntity donor) {
        DonarDto donorDto = modelMapper.map(donor, DonarDto.class);
        /*
        donor.setSubmissionDate(post.getSubmissionDate(), 
            userService.getCurrentUser().getPreference().getTimezone());
        */
        return donorDto;
    }
    
    private DonarEntity convertToEntity(DonarDto donorDto) {
        DonarEntity donor = modelMapper.map(donorDto, DonarEntity.class);
        /*
        post.setSubmissionDate(postDto.getSubmissionDateConverted(
          userService.getCurrentUser().getPreference().getTimezone()));
      
        if (postDto.getId() != null) {
            Post oldPost = postService.getPostById(postDto.getId());
            post.setRedditID(oldPost.getRedditID());
            post.setSent(oldPost.icdsSent());
        }
        */
        return donor;
    }

}
