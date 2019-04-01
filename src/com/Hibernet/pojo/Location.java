package com.Hibernet.pojo;

import java.util.Date;
import java.util.Set;

public class Location {
	private Long pklocationid;
	private String locationname;
	private String isactive;
	private Date createddate;
	private Long createdby;
	private Date modifieddate;
	private Long modifiedby;
	private Set ridesSet;
	private District districtObj;
	public District getDistrictObj() {
		return districtObj;
	}
	public void setDistrictObj(District districtObj) {
		this.districtObj = districtObj;
	}
	public Set getRidesSet() {
		return ridesSet;
	}
	public void setRidesSet(Set ridesSet) {
		this.ridesSet = ridesSet;
	}
	public Long getPklocationid() {
		return pklocationid;
	}
	public void setPklocationid(Long pklocationid) {
		this.pklocationid = pklocationid;
	}
	public String getLocationname() {
		return locationname;
	}
	public void setLocationname(String locationname) {
		this.locationname = locationname;
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
