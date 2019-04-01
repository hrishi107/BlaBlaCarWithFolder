package com.Hibernet.pojo;

import java.util.Date;

public class Booking {
	private Long pkbookingid;
	private Long bookedseat;
	private String isactive="Y";
	private Date createddate;
	private Long createdby;
	private Date modifieddate;
	private Long modifiedby;
	private Rides rides;
	private UserInfo userInfo;
	public Rides getRides() {
		return rides;
	}
	public void setRides(Rides rides) {
		this.rides = rides;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Long getPkbookingid() {
		return pkbookingid;
	}
	public void setPkbookingid(Long pkbookingid) {
		this.pkbookingid = pkbookingid;
	}
	public Long getBookedseat() {
		return bookedseat;
	}
	public void setBookedseat(Long bookedseat) {
		this.bookedseat = bookedseat;
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
