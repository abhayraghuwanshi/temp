package com.iiht.training.ngo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.ngo.entity.DonationEntity;
import com.iiht.training.ngo.entity.DonationRequestEntity;

@Repository
public interface DonationRepository extends JpaRepository<DonationEntity, Long> {
	
	List<DonationEntity> findByDonarId(Long donorId);
	
	List<DonationEntity> findByNgoId(Long ngoId);
	
}
