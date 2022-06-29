package com.iiht.training.ngo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@SpringBootApplication
public class DonationManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonationManagementSystemApplication.class, args);
	}

//    @Bean
//    ModelMapper getMapper() {
//        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        return mapper;
//    }
}
