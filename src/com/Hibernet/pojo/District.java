package com.Hibernet.pojo;

import java.util.Date;
import java.util.Set;

public class District {
	private Long pkdistrictid;
	private String districtname;
	private String isactive="Y";
	private Date createddate;
	private Long createdby;
	private Date modifieddate;
	private Long modifiedby;
	private Set locationSet;
	private State stateObj;
	
	public State getStateObj() {
		return stateObj;
	}
	public void setStateObj(State stateObj) {
		this.stateObj = stateObj;
	}
	public Set getLocationSet() {
		return locationSet;
	}
	public void setLocationSet(Set locationSet) {
		this.locationSet = locationSet;
	}
	public Long getPkdistrictid() {
		return pkdistrictid;
	}
	public void setPkdistrictid(Long pkdistrictid) {
		this.pkdistrictid = pkdistrictid;
	}
	public String getDistrictname() {
		return districtname;
	}
	public void setDistrictname(String districtname) {
		this.districtname = districtname;
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
