package com.Hibernet.bean;

import java.util.Date;
import java.util.Set;

import com.Hibernet.pojo.Location;
import com.Hibernet.pojo.UserInfo;

	public class RidesBean {
		private Long pkrideid;
		//private Long LocationId;
		private String fromlocation;
		private String tolocation;
		private Date date;
		private Long totalseat;
		private Long availableseat;
		private Long price;
		private String leavetime;
		private String reachedtime;
		private String isactive="Y";
		private String createddate;
		private Long createdby;
		private String modifieddate;
		private Long modifiedby;
		private Set bookingSet;
		private Location location;
		private UserInfo userInfo;
		private Location tolocationObj;
		private String Username;
		private Long pkUserId;
		
		
		public Long getPkUserId() {
			return pkUserId;
		}
		public void setPkUserId(Long pkUserId) {
			this.pkUserId = pkUserId;
		}
		public String getUsername() {
			return Username;
		}
		public void setUsername(String username) {
			Username = username;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Location getTolocationObj() {
			return tolocationObj;
		}
		public void setTolocationObj(Location tolocationObj) {
			this.tolocationObj = tolocationObj;
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
		public String getCreateddate() {
			return createddate;
		}
		public void setCreateddate(String createddate) {
			this.createddate = createddate;
		}
		public Long getCreatedby() {
			return createdby;
		}
		public void setCreatedby(Long createdby) {
			this.createdby = createdby;
		}
		public String getModifieddate() {
			return modifieddate;
		}
		public void setModifieddate(String modifieddate) {
			this.modifieddate = modifieddate;
		}
		public Long getModifiedby() {
			return modifiedby;
		}
		public void setModifiedby(Long modifiedby) {
			this.modifiedby = modifiedby;
		}
		public Set getBookingSet() {
			return bookingSet;
		}
		public void setBookingSet(Set bookingSet) {
			this.bookingSet = bookingSet;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public UserInfo getUserInfo() {
			return userInfo;
		}
		public void setUserInfo(UserInfo userInfo) {
			this.userInfo = userInfo;
		}
		
	}


