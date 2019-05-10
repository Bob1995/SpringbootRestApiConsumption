package com.citrix.saphosynergy.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "synergy_sapho_users")
public class SynergySaphoUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String middleName;
	private String lastName;
	private String companyName;
	private String phoneNumber;
	private String emailAddress;
	private String status;

	@OneToMany
	@JoinTable(name = "synergy_user_apps", 
			joinColumns = { @JoinColumn(name = "user_id") }, 
			inverseJoinColumns = {@JoinColumn(name = "app_id") }
	)
	private List<SynergyApp> selectedApps;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt")
	private Date createAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifiedAt")
	private Date modifiedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<SynergyApp> getSelectedApps() {
		return selectedApps;
	}

	public void setSelectedApps(List<SynergyApp> selectedApps) {
		this.selectedApps = selectedApps;
	}
	
	

}
