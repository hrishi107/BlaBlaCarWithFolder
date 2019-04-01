package com.Hibernet.bean;

import java.util.Date;
import java.util.Set;

import com.Hibernet.pojo.Rides;
import com.Hibernet.pojo.UserInfo;

public class CommonHistoryBean {
	private Long pkuserid;
	private String firstname;
	private String lastname;
	private String gender;
	private String hobbies;
	private Long mobileno;
	private String email;
	private String address;
	private Date dateofbirth;
	private Long pincode;
	private String password;
	private String repeatpassword;
	private Set rideSet;
	private Set bookingset;
	private String isadmin;
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
	private Long pkbookingid;
	private Long bookedseat;
	private boolean statusFlag;
	private String statusMessage;
	public boolean isStatusFlag() {
		return statusFlag;
	}
	public void setStatusFlag(boolean statusFlag) {
		this.statusFlag = statusFlag;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Long getPkuserid() {
		return pkuserid;
	}
	public void setPkuserid(Long pkuserid) {
		this.pkuserid = pkuserid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatpassword() {
		return repeatpassword;
	}
	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}
	public Set getRideSet() {
		return rideSet;
	}
	public void setRideSet(Set rideSet) {
		this.rideSet = rideSet;
	}
	public Set getBookingset() {
		return bookingset;
	}
	public void setBookingset(Set bookingset) {
		this.bookingset = bookingset;
	}
	public String getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
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
	public Set getBookingSet() {
		return bookingSet;
	}
	public void setBookingSet(Set bookingSet) {
		this.bookingSet = bookingSet;
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
	private Rides rides;
	private UserInfo userInfo;

}
