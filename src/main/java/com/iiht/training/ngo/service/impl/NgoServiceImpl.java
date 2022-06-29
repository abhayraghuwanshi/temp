package com.iiht.training.ngo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.ngo.dto.DonationRequestDto;
import com.iiht.training.ngo.dto.NgoDto;
import com.iiht.training.ngo.entity.DonarEntity;
import com.iiht.training.ngo.entity.DonationRequestEntity;
import com.iiht.training.ngo.entity.NgoEntity;
import com.iiht.training.ngo.repository.NgoRepository;
import com.iiht.training.ngo.service.NgoService;

@Service
public class NgoServiceImpl implements NgoService {

	@Autowired
	private NgoRepository ngoRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public NgoDto registerNgo(NgoDto ngoDto) {
		return convertToDto(ngoRepository.save(convertToEntity(ngoDto)));
	}

	@Override
	public NgoDto updateNgo(NgoDto ngoDto) {
		NgoDto cus = ngoRepository.findById(ngoDto.getNgoId()).get();
		
		cus.setNgoId(ngoDto.getNgoId());
		cus.setNgoName(ngoDto.getNgoName());
        cus.setUsername(ngoDto.getUsername());
        cus.setPassword(ngoDto.getPassword());
        cus.setAddress(ngoDto.getAddress());
        cus.setPassword(ngoDto.getPassword());
        cus.setPhoneNumber(ngoDto.getPhoneNumber());
        cus.setStartedIn(ngoDto.getStartedIn());
        cus.setDocuments(ngoDto.getDocuments());
        
        
		return convertToDto(ngoRepository.save(cus));
		
	}

	@Override
	public Boolean deleteNgo(Long ngoId) {
		if (ngoRepository.existsById(ngoId)) {
			ngoRepository.deleteById(ngoId);
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public NgoDto getNgoById(Long ngoId) {
		return convertToDto(ngoRepository.findById(ngoId).get());
	}

	@Override
	public List<NgoDto> getAllNgos() {
		List<NgoEntity> dnrList = ngoRepository.findAll();
		return dnrList.stream()
		          .map(s -> convertToDto(s))
		          .collect(Collectors.toList());
		
	}
	
	private NgoDto convertToDto(NgoEntity ngo) {
		NgoDto ngoDto = modelMapper.map(ngo, NgoDto.class);

        return ngoDto;
    }
    
    private NgoEntity convertToEntity(NgoDto ngoDto) {
    	NgoEntity donorreq = modelMapper.map(ngoDto, NgoEntity.class);
        return donorreq;
    }

}
