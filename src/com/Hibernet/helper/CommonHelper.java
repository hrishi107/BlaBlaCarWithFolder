package com.Hibernet.helper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Hibernet.bean.BookingOutBean;
import com.Hibernet.bean.CommonHistoryBean;
import com.Hibernet.bean.CountryBean;
import com.Hibernet.bean.CountryOutBean;
import com.Hibernet.bean.DistrictBean;
import com.Hibernet.bean.LocationBean;
import com.Hibernet.bean.LocationOutBean;
import com.Hibernet.bean.RidesBean;
import com.Hibernet.bean.RidesOutBean;
import com.Hibernet.bean.StateBean;
import com.Hibernet.bean.StateOutBean;
import com.Hibernet.dao.BookingDao;
import com.Hibernet.dao.RidesDao;
import com.Hibernet.dao.commonDao;
import com.Hibernet.pojo.Booking;
import com.Hibernet.pojo.Country;
import com.Hibernet.pojo.District;
import com.Hibernet.pojo.Location;
import com.Hibernet.pojo.Rides;
import com.Hibernet.pojo.State;
import com.Hibernet.pojo.UserInfo;
import com.Hibernet.util.HibernetConnection;



public class CommonHelper {
	/** 
	 * Method to GetBooking History*/
	public List getBookingHistory(Long pkUserId,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{	
		SessionFactory sessionFactory=null;
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		List listData=new ArrayList();
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		Booking booking=new Booking();
		
		try{
			sessionObj=hibernetConnectionObj.openConnection();
			Query query=sessionObj.createQuery("select user.pkuserid, user.firstname,ridess.fromlocation,ridess.tolocation,ridess.date,ridess.leavetime,ridess.reachedtime,booking.bookedseat"
					+ " From Booking booking"
					+ " join booking.rides ridess"
					+ " join ridess.userInfo user"
					+ " where user.pkuserid=:User"
					+ " and booking.isactive='Y'");
				query.setParameter("User",pkUserId);
				listObj= query.list();
				if(listObj!=null && !"".equals(listObj)){
					Iterator it=listObj.iterator();
					while(it.hasNext())
					{	
						
						Object rows[] =(Object[])it.next();
						CommonHistoryBean CommonHistoryBean=new CommonHistoryBean();
						CommonHistoryBean.setPkuserid((Long)rows[0]);
						CommonHistoryBean.setFirstname((String)rows[1]);
						CommonHistoryBean.setFromlocation((String)rows[2]);
						CommonHistoryBean.setTolocation((String)rows[3]);
						CommonHistoryBean.setDate((Date)rows[4]);
						CommonHistoryBean.setLeavetime((String)rows[5]);
						CommonHistoryBean.setReachedtime((String)rows[6]);
						CommonHistoryBean.setBookedseat((Long)rows[7]);
						listData.add(CommonHistoryBean);
					}
				}
				else{
					String message="Incorrect details";
					 response.sendRedirect(request.getContextPath()+"/jsp/bookinghistory.jsp?message="+message);
				}
	} catch (Exception e) 
	{
		e.printStackTrace();
	    tx.rollback();
	}
	finally
	{
		hibernetConnectionObj.closeConnection(sessionObj);
		hibernetConnectionObj.closeConnectSessionFactory();
	}
	
		return listData;
	}
	/** 
	 * Method to GetBooking Details*/

	public List getBookingDetails(Long pkUserId,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{	
		SessionFactory sessionFactory=null;
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		List listData=new ArrayList();
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		Booking booking=new Booking();
		
		try{
			sessionObj=hibernetConnectionObj.openConnection();
			Query query=sessionObj.createQuery("select user.pkuserid, user.firstname,ridess.fromlocation,ridess.tolocation,ridess.date,ridess.leavetime,ridess.reachedtime,booking.bookedseat"
					+ " From Booking booking"
					+ " join booking.userInfo user"
					+ " join booking.rides ridess"
					+ " where user.pkuserid=:User"
					+ " and booking.isactive='Y'");
				query.setParameter("User",pkUserId);
				listObj= query.list();
				if(listObj!=null && !"".equals(listObj)){
					Iterator it=listObj.iterator();
					while(it.hasNext())
					{	
						
						Object rows[] =(Object[])it.next();
						CommonHistoryBean CommonHistoryBean=new CommonHistoryBean();
						CommonHistoryBean.setPkuserid((Long)rows[0]);
						CommonHistoryBean.setFirstname((String)rows[1]);
						CommonHistoryBean.setFromlocation((String)rows[2]);
						CommonHistoryBean.setTolocation((String)rows[3]);
						CommonHistoryBean.setDate((Date)rows[4]);
						CommonHistoryBean.setLeavetime((String)rows[5]);
						CommonHistoryBean.setReachedtime((String)rows[6]);
						CommonHistoryBean.setBookedseat((Long)rows[7]);
						listData.add(CommonHistoryBean);
					}
				}
				else{
					String message="Incorrect details";
					 response.sendRedirect(request.getContextPath()+"/jsp/bookindetails.jsp?message="+message);
				}
	} catch (Exception e) 
	{
		e.printStackTrace();
	    tx.rollback();
	}
	finally
	{
		hibernetConnectionObj.closeConnection(sessionObj);
		hibernetConnectionObj.closeConnectSessionFactory();
	}
	
		return listData;
	}
	/** 
	 * Method to check words for auto complete*/

	public List checkWordsForAutoComplete(HttpServletRequest request, HttpServletResponse response, String autoComplete){
		commonDao commondaoObj=new commonDao();
		Location locationObj=new Location();
		locationObj.setLocationname(autoComplete);
		List ll=commondaoObj.checkWordsForAutoComplete(locationObj);
		
		return ll;
	}
	/** 
	 * Method auto complete for ToLocation*/
	public List AutoCompleteToLocation(HttpServletRequest request, HttpServletResponse response, String autoComplete){
		commonDao commondaoObj=new commonDao();
		Location locationObj=new Location();
		locationObj.setLocationname(autoComplete);
		List ll=commondaoObj.AutoCompleteTolocation(locationObj);
		
		return ll;
	}
	/** 
	 * Method to Search Rides*/
	public List searchRides(RidesBean ridesBean,String fromLocation,String toLocation,RidesOutBean ridesOutBean){
		RidesDao riesdaoObj=new RidesDao();
		Long fromLocationId=Long.parseLong(fromLocation);
		Long toLocationId=Long.parseLong(toLocation);
		Rides ridesPojoObj=new Rides();
		ridesPojoObj.setDate(ridesBean.getDate());
		ridesPojoObj.setLeavetime(ridesBean.getLeavetime());
		List ll=riesdaoObj.searchRides(ridesPojoObj,fromLocationId,toLocationId,ridesOutBean);
		if(ll!=null && !ll.isEmpty())
		{
			ridesOutBean.setStatusFlag(true);
			ridesOutBean.setStatusMessage("Correct!");
		}
		else
		{
			ridesOutBean.setStatusFlag(false);
			ridesOutBean.setStatusMessage("Records not found");
		}
		return ll;
	}
	/** 
	 * Method to get driver details*/
	public RidesBean getDriverDetail(String pkRideId,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		Long rideId=Long.parseLong(pkRideId);
		
		Session sessionObj=null;
		Transaction tx=null;
		RidesBean ridesBean=new RidesBean();
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try{	
			sessionObj=hibernetConnectionObj.openConnection();	
			
			Rides rides = (Rides) sessionObj.load(Rides.class,rideId);
			UserInfo userInfo=rides.getUserInfo();
			if(rides!=null && userInfo!=null)
			{
				ridesBean.setPkrideid(rides.getPkrideid());
				ridesBean.setFromlocation(rides.getFromlocation());
				ridesBean.setTolocation(rides.getTolocation());
				ridesBean.setDate(rides.getDate());
				ridesBean.setTotalseat(rides.getTotalseat());
				ridesBean.setAvailableseat(rides.getAvailableseat());
				ridesBean.setPrice(rides.getPrice());
				ridesBean.setLeavetime(rides.getLeavetime());
				ridesBean.setReachedtime(rides.getReachedtime());
				ridesBean.setPkUserId(userInfo.getPkuserid());
				ridesBean.setUsername(userInfo.getFirstname());
				HttpSession session=request.getSession();
				session.setAttribute("Bean",ridesBean);
			}
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			hibernetConnectionObj.closeConnection(sessionObj);
			hibernetConnectionObj.closeConnectSessionFactory();
		}
		return ridesBean;
			
			
	}
	/** 
	 * Method To book seats*/
	public BookingOutBean bookSeats(String pkrideId, String pkuserId, String sectedSeatCount) {
		BookingOutBean bookingOutBean=new BookingOutBean(); 
		Long rideId=Long.parseLong(pkrideId);
		Long userId=Long.parseLong(pkuserId);
		Long sectedSeat=Long.parseLong(sectedSeatCount);
		
		BookingDao bookingDao=new BookingDao();
		
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try 
		{
			sessionObj=hibernetConnectionObj.openConnection();
			Booking booking=new Booking();
			
			UserInfo userInfo=(UserInfo)sessionObj.get(UserInfo.class,userId);
			Rides rides = (Rides)sessionObj.get(Rides.class,rideId);
			
			booking.setBookedseat(sectedSeat);
			booking.setRides(rides);
			booking.setUserInfo(userInfo);
			booking.setIsactive("Y");
			booking.setCreatedby(userId);
			booking.setCreateddate(new Date());
			tx=sessionObj.beginTransaction();
			
			Long bookingId=(Long)sessionObj.save(booking);						
			rides.setAvailableseat(rides.getAvailableseat() -sectedSeat);
			sessionObj.update(rides);
			tx.commit();
			
			bookingOutBean.setUserName(userInfo.getFirstname());
			bookingOutBean.setPkbookingid(bookingId);
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			hibernetConnectionObj.closeConnection(sessionObj);
			hibernetConnectionObj.closeConnectSessionFactory();
		}
		return bookingOutBean;
	}
	/** 
	 * Method to add country*/
	public CountryBean addCountry( String adminId,CountryBean countryBean) {
		Country country=new Country();
		Long id=Long.parseLong(adminId);
		
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try 
		{
			sessionObj=hibernetConnectionObj.openConnection();
			
			country.setCountryname(countryBean.getCountryname());
			country.setIsactive("Y");
			country.setCreatedby(id);
			country.setCreateddate(new Date());
			tx=sessionObj.beginTransaction();
			sessionObj.save(country);
			tx.commit();
			countryBean.setCountryname(country.getCountryname());
		
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			hibernetConnectionObj.closeConnection(sessionObj);
			hibernetConnectionObj.closeConnectSessionFactory();
		}
		return countryBean;
	}
	/** 
	 * Method to Update COuntry*/
	public CountryBean updateCountry(String adminId, CountryBean countryBean, String countryId) {
		//Country country=new Country();
		Long id=Long.parseLong(adminId);
		Long countrId=Long.parseLong(countryId);
		//country.setCountryname(countryBean.getCountryname());
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try 
		{
			sessionObj=hibernetConnectionObj.openConnection();
			
			
			Country country =(Country)sessionObj.get(Country.class,countrId);
			country.setCountryname(countryBean.getCountryname());
			tx=sessionObj.beginTransaction();
			sessionObj.update(country);
			
			tx.commit();
			countryBean.setCountryname(country.getCountryname());
		
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			hibernetConnectionObj.closeConnection(sessionObj);
			hibernetConnectionObj.closeConnectSessionFactory();
		}
		return countryBean;
	}
	/** 
	 * Method for List drop down for Select Country*/
	public List selectCountry()
	{
		SessionFactory sessionFactory=null;
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		List listData=new ArrayList();
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		CountryOutBean countryOutBean=new CountryOutBean();
		
		try{
			sessionObj=hibernetConnectionObj.openConnection();
			Query query=sessionObj.createQuery("select country.pkcountryid, country.countryname, country.isactive from Country country"
					+ " where country.isactive='Y' ");
				listObj= query.list();
				if(listObj!=null && !"".equals(listObj)){
					Iterator it=listObj.iterator();
					while(it.hasNext())
					{	
						CountryBean countryBean=new CountryBean();
						Object rows[] =(Object[])it.next();
						countryBean.setPkcountryid((Long)rows[0]);
						countryBean.setCountryname((String)rows[1]);
						countryBean.setIsactive((String)rows[2]);
						listData.add(countryBean);
					}
				}
				else{
					countryOutBean.setStatusMessage("Information is correct");
				}
	} catch (Exception e) 
	{
		e.printStackTrace();
	    tx.rollback();
	}
	finally
	{
		hibernetConnectionObj.closeConnection(sessionObj);
		hibernetConnectionObj.closeConnectSessionFactory();
	}
	
		return listData;
	}
	/** 
	 * Method for List drop down for Select State*/
	public List selectState()
	{
		SessionFactory sessionFactory=null;
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		List listData=new ArrayList();
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		StateOutBean stateOutBean=new StateOutBean();
		
		try{
			sessionObj=hibernetConnectionObj.openConnection();
			Query query=sessionObj.createQuery("select state.pkstateid, state.statename, state.isactive from State state"
					+ " where state.isactive='Y'");
				listObj= query.list();
				if(listObj!=null && !"".equals(listObj)){
					Iterator it=listObj.iterator();
					while(it.hasNext())
					{	
						StateBean stateBean=new StateBean();
						Object rows[] =(Object[])it.next();
						stateBean.setPkstateid((Long)rows[0]);
						stateBean.setStatename((String)rows[1]);
						stateBean.setIsactive((String)rows[2]);
						listData.add(stateBean);
					}
				}
				else{
					stateOutBean.setStatusMessage("Information is incorrect");
				}
	} catch (Exception e) 
	{
		e.printStackTrace();
	    tx.rollback();
	}
	finally
	{
		hibernetConnectionObj.closeConnection(sessionObj);
		hibernetConnectionObj.closeConnectSessionFactory();
	}
	
		return listData;
	}
	/** 
	 * Method for List drop down for Select Location*/
	public List selectLocation()
	{
		SessionFactory sessionFactory=null;
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		List listData=new ArrayList();
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		LocationOutBean locationOutBean=new LocationOutBean();
		
		try{
			sessionObj=hibernetConnectionObj.openConnection();
			Query query=sessionObj.createQuery("select location.pklocationid, location.locationname, location.isactive from Location location"
					+ " where location.isactive='Y'");
				listObj= query.list();
				if(listObj!=null && !"".equals(listObj)){
					Iterator it=listObj.iterator();
					while(it.hasNext())
					{	
						LocationBean locationBean=new LocationBean();
						Object rows[] =(Object[])it.next();
						locationBean.setPklocationid((Long)rows[0]);
						locationBean.setLocationname((String)rows[1]);
						locationBean.setIsactive((String)rows[2]);
						listData.add(locationBean);
					}
				}
				else{
					locationOutBean.setStatusMessage("Information is incorrect");
				}
	} catch (Exception e) 
	{
		e.printStackTrace();
	    tx.rollback();
	}
	finally
	{
		hibernetConnectionObj.closeConnection(sessionObj);
		hibernetConnectionObj.closeConnectSessionFactory();
	}
	
		return listData;
	}/** 
	 * Method for List drop down for add State*/
	public StateBean addState(String adminId, String countryId, StateBean stateBean) {
		State state=new State();
		Long id=Long.parseLong(adminId);
		Long cntryId=Long.parseLong(countryId);
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try 
		{
			sessionObj=hibernetConnectionObj.openConnection();
			Country country=(Country)sessionObj.get(Country.class,cntryId);
			
			state.setStatename(stateBean.getStatename());
			state.setCountryObj(country);
			state.setIsactive("Y");
			state.setCreatedby(id);
			state.setCreateddate(new Date());
			tx=sessionObj.beginTransaction();
			sessionObj.save(state);
			tx.commit();
			stateBean.setStatename(state.getStatename());
		
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			hibernetConnectionObj.closeConnection(sessionObj);
			hibernetConnectionObj.closeConnectSessionFactory();
		}
		return stateBean;
		}
	/** 
	 * Method for add district*/
	public DistrictBean addDistrict(String adminId, String stateId, DistrictBean districtBean) {
		District district=new District();
		Long id=Long.parseLong(adminId);
		Long pkstateId=Long.parseLong(stateId);
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try 
		{
			sessionObj=hibernetConnectionObj.openConnection();
			
			State state=(State)sessionObj.get(State.class,pkstateId);
			district.setDistrictname(districtBean.getDistrictname());
			district.setStateObj(state);
			district.setIsactive("Y");
			district.setCreatedby(id);
			district.setCreateddate(new Date());
			tx=sessionObj.beginTransaction();
			sessionObj.save(district);
			tx.commit();
			districtBean.setDistrictname(district.getDistrictname());
		
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			hibernetConnectionObj.closeConnection(sessionObj);
			hibernetConnectionObj.closeConnectSessionFactory();
		}
		return districtBean;
		}
	/** 
	 * Method for add Location*/
	public LocationBean addLocation(String adminId, LocationBean locationBean) {
		Location location=new Location();
		Long id=Long.parseLong(adminId);
		
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try 
		{
			sessionObj=hibernetConnectionObj.openConnection();
			
			location.setLocationname(locationBean.getLocationname());
			location.setIsactive("Y");
			location.setCreatedby(id);
			location.setCreateddate(new Date());
			tx=sessionObj.beginTransaction();
			sessionObj.save(location);
			tx.commit();
			locationBean.setLocationname(location.getLocationname());
		
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			hibernetConnectionObj.closeConnection(sessionObj);
			hibernetConnectionObj.closeConnectSessionFactory();
		}
		return locationBean;
		}
	/** 
	 * Method To update State*/
	public StateBean updateState(String adminId, StateBean stateBean,String countryId) {
		Long id=Long.parseLong(adminId);
		Long stateId=Long.parseLong(countryId);
		
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try 
		{
			sessionObj=hibernetConnectionObj.openConnection();
			
			
			State state =(State)sessionObj.get(State.class,stateId);
			state.setStatename(stateBean.getStatename());
			tx=sessionObj.beginTransaction();
			sessionObj.update(state);
			
			tx.commit();
			stateBean.setStatename(state.getStatename());
		
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			hibernetConnectionObj.closeConnection(sessionObj);
			hibernetConnectionObj.closeConnectSessionFactory();
		}
		return stateBean;

	}
	/** 
	 * Method To update Location*/
	public LocationBean updateLocation(String adminId,LocationBean locationBean, String locationId) 
	{
		Long id=Long.parseLong(adminId);
		Long LocationId=Long.parseLong(locationId);
		
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try 
		{
			sessionObj=hibernetConnectionObj.openConnection();
			
			
			Location location =(Location)sessionObj.get(Location.class,LocationId);
			location.setLocationname(locationBean.getLocationname());
			tx=sessionObj.beginTransaction();
			sessionObj.update(location);
			
			tx.commit();
			locationBean.setLocationname(location.getLocationname());
		
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			hibernetConnectionObj.closeConnection(sessionObj);
			hibernetConnectionObj.closeConnectSessionFactory();
		}
		return locationBean;
	}
	/** 
	 * Method To Create new Ride*/
	public RidesOutBean createRide(RidesBean ridesBeanObj, String fromLocationId,String toLocationId, String userid2, RidesOutBean ridesOutBean,String fromLocation, String toLocation) {
		Long fromLocationid=Long.parseLong(fromLocationId);
		Long toLocationid=Long.parseLong(toLocationId);
		Long userId=Long.parseLong(userid2);
		Long avlseat=Long.parseLong("5");
		Long totalSeat=Long.parseLong("8");
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try 
		{
			sessionObj=hibernetConnectionObj.openConnection();
			UserInfo userInfo=(UserInfo)sessionObj.get(UserInfo.class,userId);
			Location location=(Location)sessionObj.get(Location.class,fromLocationid);
			Location location1=(Location)sessionObj.get(Location.class,toLocationid);
			Rides ridesPojoObj=new Rides();
			
			ridesPojoObj.setUserInfo(userInfo);
			ridesPojoObj.setDate(ridesBeanObj.getDate());
			ridesPojoObj.setLeavetime(ridesBeanObj.getLeavetime());
			ridesPojoObj.setReachedtime("11.35");
			ridesPojoObj.setFromlocation(fromLocation);
			ridesPojoObj.setTolocation(toLocation);
			ridesBeanObj.setAvailableseat(avlseat);
			ridesBeanObj.setTotalseat(totalSeat);
			ridesPojoObj.setFromlocationObj(location);
			ridesPojoObj.setTolocationObj(location1);
			ridesPojoObj.setIsactive("Y");
			ridesPojoObj.setCreatedby(userId);
			ridesPojoObj.setCreateddate(new Date());
			tx=sessionObj.beginTransaction();
			sessionObj.save(ridesPojoObj);
			tx.commit();
			
			ridesOutBean.setPkrideid(ridesPojoObj.getPkrideid());
				
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			hibernetConnectionObj.closeConnection(sessionObj);
			hibernetConnectionObj.closeConnectSessionFactory();
		}
		
		
		return ridesOutBean;
	}	
	
}
			
