package com.iiht.training.ngo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.ngo.dto.DonarDto;
import com.iiht.training.ngo.dto.DonationRequestDto;
import com.iiht.training.ngo.entity.DonarEntity;
import com.iiht.training.ngo.entity.DonationRequestEntity;
import com.iiht.training.ngo.repository.DonationRequestRepository;
import com.iiht.training.ngo.service.DonationRequestService;

@Service(value = "donationRequestService")
public class DonationRequestServiceImpl implements DonationRequestService {

	@Autowired
	private DonationRequestRepository donationRequestRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DonationRequestDto createDonationRequest(DonationRequestDto donationRequestDto) {
		return convertToDto(donationRequestRepository.save(convertToEntity(donationRequestDto)));
	}

	@Override
	public List<DonationRequestDto> getDonationRequestNotification(Long ngoId) {
		List<DonationRequestEntity> dnrList = donationRequestRepository.findByNgoId(ngoId);
		return dnrList.stream()
          .map(s -> convertToDto(s))
          .collect(Collectors.toList());
	}

	@Override
	public List<DonationRequestDto> getDonationRequestByDonarId(Long donarId) {
		
		List<DonationRequestEntity> dnrList = donationRequestRepository.findByDonarId(donarId);
		return dnrList.stream()
          .map(s -> convertToDto(s))
          .collect(Collectors.toList());
	}
	
	
	
	private DonationRequestDto convertToDto(DonationRequestEntity donor) {
		DonationRequestDto donorDto = modelMapper.map(donor, DonationRequestDto.class);

        return donorDto;
    }
    
    private DonationRequestEntity convertToEntity(DonationRequestDto donorDto) {
    	DonationRequestEntity donorreq = modelMapper.map(donorDto, DonationRequestEntity.class);
        return donorreq;
    }

}
