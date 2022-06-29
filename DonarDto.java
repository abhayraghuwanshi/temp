package com.iiht.training.ngo.dto;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

/*
Use appropriate annotations from the Java Bean Validation API for validating attributes of this class. 
(Refer Business Validation section for validation rules).

●	Donor name is not null, min 3 and max 100 characters.
●	Donor username is not null, min 3 and max 50 characters.
●	Donor password is not null, min 3 and max 50 characters.
●	Donor email is not null, min 3 and max 100 characters and should be in email format
●	Donor phone number is not null and have min 10 and max 10 digits
●	Donor address is not null, min 3 and max 100 characters

*/
public class DonarDto {

	private Long donarId;
	
	private Long ngoId;
	
	@Size(min = 3, max = 100, message 
      = "donarName must be between 3 and 100 characters")
	private String donarName;
	
	 @Size(min = 3, max = 100, message 
      = "username must be between 3 and 100 characters")
	private String username;
	
	@Size(min = 3, max = 50, message 
      = "password must be between 3 and 100 characters")
	private String password;
	
	@Size(min = 3, max = 100, message 
      = "Email must be between 3 and 100 characters")
    @Email(message = "Email should be valid")
	private String emailId;
	

    @Size(min=10, max=10)
	private Long phoneNumber;
	
	@Size(min = 3, max = 100, message 
      = "username must be between 3 and 100 characters")
	private String address;

	public Long getDonarId() {
		return donarId;
	}

	public void setDonarId(Long donarId) {
		this.donarId = donarId;
	}

	public Long getNgoId() {
		return ngoId;
	}

	public void setNgoId(Long ngoId) {
		this.ngoId = ngoId;
	}

	public String getDonarName() {
		return donarName;
	}

	public void setDonarName(String donarName) {
		this.donarName = donarName;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, donarId, donarName, emailId, ngoId, password, phoneNumber, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonarDto other = (DonarDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(donarId, other.donarId)
				&& Objects.equals(donarName, other.donarName) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(ngoId, other.ngoId) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(username, other.username);
	}
	
	

}
