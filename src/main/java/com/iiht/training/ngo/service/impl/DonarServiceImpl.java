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
	
	@Override
	public DonarDto updateDonar(DonarDto donarDto) {
		DonarEntity cus = donarRepository.findById(donarDto.getDonarId()).get();
		
		cus.setAddress(donarDto.getAddress());
		cus.setPhoneNumber(donarDto.getPhoneNumber());
        cus.setEmailId(donarDto.getEmailId());
        cus.setUsername(donarDto.getUsername());
        cus.setPassword(donarDto.getPassword());
        cus.setNgoId(donarDto.getNgoId());
		return convertToDto(donarRepository.save(cus));
	}

	@Override
	public Boolean deleteDonar(Long donarid) {
		if ( donarRepository.existsById(donarid)==false) {
			return false;
		}		
		donarRepository.deleteById(donarid);
		return true;
	}

	@Override
	public DonarDto getDonarById(Long donarId) {
		return convertToDto(donarRepository.findById(donarId).get());
	}

	@Override
	public List<DonarDto> getAllDonars() {
		List<DonarEntity> dnrList = donarRepository.findAll();
		return dnrList.stream()
          .map(s -> convertToDto(s))
          .collect(Collectors.toList());

	}


	@Override
	public List<DonarDto> getDonarsRegisteredWithNgo(Long ngoId) {
		List<DonarEntity> dnrList = donarRepository.findByNgoId(ngoId);
		return dnrList.stream()
          .map(s -> convertToDto(s))
          .collect(Collectors.toList());
	}


	private DonarDto convertToDto(DonarEntity donor) {
        DonarDto donorDto = modelMapper.map(donor, DonarDto.class);

        return donorDto;
    }
    
    private DonarEntity convertToEntity(DonarDto donorDto) {
        DonarEntity donor = modelMapper.map(donorDto, DonarEntity.class);

        return donor;
    }

}
