package com.iiht.training.ngo.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NgoDto {

	@NotNull(message="Id cannot be empty")
	private Long ngoId;
	
	@NotEmpty(message="Name cannot be empty")
	@Size(min = 3, max = 100, message 
    = " Name be between 3 and 100 characters")
	private String ngoName;
	
	@NotEmpty(message="Username cannot be empty")
	@Size(min = 3, max = 50, message 
    = "Username must be between 3 and 50 characters")
	private String username;
	
	@NotEmpty(message="Password cannot be empty")
	@Size(min = 3, max = 50, message 
    = " must be between 3 and 100 characters")
	private String password;
	
	@NotEmpty(message="Type cannot be empty")
	@Size(min = 3, max = 100, message 
    = " must be between 3 and 100 characters")
	private String address;
	
	@NotNull(message="Type cannot be empty")
	@Range(min = 10, max= 10, message = "phone_no should be exact 10 characters." )
	private Long phoneNumber;
	
	@NotNull(message="Date cannot be empty")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Past
	private LocalDate startedIn;
	
	@NotEmpty(message="Type cannot be null")
	@Size(min = 3, max = 100, message 
    = " must be between 3 and 100 characters")
	private String documents;

	public Long getNgoId() {
		return ngoId;
	}

	public void setNgoId(Long ngoId) {
		this.ngoId = ngoId;
	}

	public String getNgoName() {
		return ngoName;
	}

	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getStartedIn() {
		return startedIn;
	}

	public void setStartedIn(LocalDate startedIn) {
		this.startedIn = startedIn;
	}

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, documents, ngoId, ngoName, password, phoneNumber, startedIn, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NgoDto other = (NgoDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(documents, other.documents)
				&& Objects.equals(ngoId, other.ngoId) && Objects.equals(ngoName, other.ngoName)
				&& Objects.equals(password, other.password) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(startedIn, other.startedIn) && Objects.equals(username, other.username);
	}
	
	

}
