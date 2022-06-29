package com.iiht.training.ngo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.ngo.dto.DonarDto;
import com.iiht.training.ngo.dto.DonationDto;
import com.iiht.training.ngo.entity.DonarEntity;
import com.iiht.training.ngo.entity.DonationEntity;
import com.iiht.training.ngo.repository.DonationRepository;
import com.iiht.training.ngo.service.DonationService;

@Service
public class DonationServiceImpl implements DonationService {

	@Autowired
	private DonationRepository donationRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DonationDto registerDonation(DonationDto donationDto) {
		return convertToDto(donationRepository.save(convertToEntity(donationDto)));
	}

	@Override
	public DonationDto updateDonation(DonationDto donationDto) {
		
		DonationEntity donation = donationRepository.findById(donationDto.getDonarId()).get();
		
		donation.setDonationId(donationDto.getDonationId());
		donation.setDonarId(donationDto.getDonarId());
		donation.setNgoId(donationDto.getNgoId());
		donation.setDonationType(donationDto.getDonationType());
		donation.setAmount(donationDto.getAmount());
		donation.setDonationDate(donationDto.getDonationDate());
   
		return convertToDto(donationRepository.save(donation));
		
	}

	@Override
	public Boolean deleteDonation(Long donationId) {
		if ( donationRepository.existsById(donationId)==false) {
			return false;
		}		
		donationRepository.deleteById(donationId);
		return true;
	}

	@Override
	public DonationDto getDonationById(Long donationId) {
		return convertToDto(donationRepository.findById(donationId).get());
	}

	@Override
	public List<DonationDto> getAllDonations() {
		List<DonationEntity> dnrList = donationRepository.findAll();
		return dnrList.stream()
          .map(s -> convertToDto(s))
          .collect(Collectors.toList());
 
	}

	@Override
	public List<DonationDto> getDonationsByDonorId(Long donarId) {
		List<DonationEntity> dnc = donationRepository.findByDonarId(donarId);
		return dnc.stream()
		          .map(s -> convertToDto(s))
		          .collect(Collectors.toList());
	}

	@Override
	public List<DonationDto> getDonationsByNgoId(Long ngoId) {
		List<DonationEntity> dnc = donationRepository.findByNgoId(ngoId);
		return dnc.stream()
		          .map(s ->  convertToDto(s))
		          .collect(Collectors.toList());
	}
	
	private DonationDto convertToDto(DonationEntity donation) {
        DonationDto donorDto = modelMapper.map(donation, DonationDto.class);
  
        return donorDto;
    }
    
    private DonationEntity convertToEntity(DonationDto donationDto) {
        DonationEntity donor = modelMapper.map(donationDto, DonationEntity.class);

      
        return donor;
    }
}
