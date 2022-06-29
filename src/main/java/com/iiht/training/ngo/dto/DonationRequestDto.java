package com.iiht.training.ngo.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DonationRequestDto {

	@NotNull(message="Type cannot be empty")
	private Long requestId;
	
	@NotNull(message="Type cannot be empty")
	private Double amount;
	
	@NotNull(message="Type cannot be empty")
	private Long donarId;
	
	@NotNull(message="Type cannot be empty")
	private Long ngoId;
	
	@NotEmpty(message="Type cannot be empty")
	@Size(min = 3, max = 100, message 
    = " must be between 3 and 100 characters")
	private String requestStatus;
	
	@NotNull(message="Type cannot be empty")
	@Future
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate donationEndDate;

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

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

	public LocalDate getDonationEndDate() {
		return donationEndDate;
	}

	public void setDonationEndDate(LocalDate donationEndDate) {
		this.donationEndDate = donationEndDate;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, donarId, donationEndDate, ngoId, requestId, requestStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonationRequestDto other = (DonationRequestDto) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(donarId, other.donarId)
				&& Objects.equals(donationEndDate, other.donationEndDate) && Objects.equals(ngoId, other.ngoId)
				&& Objects.equals(requestId, other.requestId) && Objects.equals(requestStatus, other.requestStatus);
	}

}
