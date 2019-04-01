package com.Hibernet.bean;

import java.util.Date;
import java.util.Set;

public class CountryBean {

	private Long pkcountryid;
	private String countryname;
	private String isactive="Y";
	private Date createddate;
	private Long createdby;
	private Date modifieddate;
	private Long modifiedby;
	private Set stateSet;
	

	public Set getStateSet() {
		return stateSet;
	}
	public void setStateSet(Set stateSet) {
		this.stateSet = stateSet;
	}
	public Long getPkcountryid() {
		return pkcountryid;
	}
	public void setPkcountryid(Long pkcountryid) {
		this.pkcountryid = pkcountryid;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Long getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}
	public Date getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}
	public Long getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(Long modifiedby) {
		this.modifiedby = modifiedby;
	}

}
