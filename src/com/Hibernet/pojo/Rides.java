package com.Hibernet.pojo;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Hibernet.util.HibernetConnection;

public class Rides {
	private Long pkrideid;
	private String fromlocation;
	private String tolocation;
	private Date date;
	private Long totalseat;
	private Long availableseat;
	private Long price;
	private String leavetime;
	private String reachedtime;
	private String isactive;
	private Date createddate;
	private Long createdby;
	private Date modifieddate;
	private Long modifiedby;
	private Set bookingSet;
	
	
	private Location fromlocationObj;
	private UserInfo userInfo;
	private Location tolocationObj;
	
	public Location getFromlocationObj() {
		return fromlocationObj;
	}
	public void setFromlocationObj(Location fromlocationObj) {
		this.fromlocationObj = fromlocationObj;
	}
	public Location getTolocationObj() {
		return tolocationObj;
	}
	public void setTolocationObj(Location tolocationObj) {
		this.tolocationObj = tolocationObj;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Set getBookingSet() {
		return bookingSet;
	}
	public void setBookingSet(Set bookingSet) {
		this.bookingSet = bookingSet;
	}
	public Long getPkrideid() {
		return pkrideid;
	}
	public void setPkrideid(Long pkrideid) {
		this.pkrideid = pkrideid;
	}
	public String getFromlocation() {
		return fromlocation;
	}
	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}
	public String getTolocation() {
		return tolocation;
	}
	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getTotalseat() {
		return totalseat;
	}
	public void setTotalseat(Long totalseat) {
		this.totalseat = totalseat;
	}
	public Long getAvailableseat() {
		return availableseat;
	}
	public void setAvailableseat(Long availableseat) {
		this.availableseat = availableseat;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getLeavetime() {
		return leavetime;
	}
	public void setLeavetime(String leavetime) {
		this.leavetime = leavetime;
	}
	public String getReachedtime() {
		return reachedtime;
	}
	public void setReachedtime(String reachedtime) {
		this.reachedtime = reachedtime;
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
