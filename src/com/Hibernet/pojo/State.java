package com.Hibernet.pojo;

import java.util.Date;
import java.util.Set;

public class State {
	private Long pkstateid;
	private String statename;
	private String isactive;
	private Date createddate;
	private Long createdby;
	private	Date modifieddate;
	private Long modifiedby;
	private Country countryObj;
	private Set districtSet;
	public Country getCountryObj() {
		return countryObj;
	}
	public void setCountryObj(Country countryObj) {
		this.countryObj = countryObj;
	}
	public Set getDistrictSet() {
		return districtSet;
	}
	public void setDistrictSet(Set districtSet) {
		this.districtSet = districtSet;
	}
	public Long getPkstateid() {
		return pkstateid;
	}
	public void setPkstateid(Long pkstateid) {
		this.pkstateid = pkstateid;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
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
