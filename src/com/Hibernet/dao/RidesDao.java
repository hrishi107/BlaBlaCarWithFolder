package com.Hibernet.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Hibernet.bean.RidesOutBean;
import com.Hibernet.pojo.Rides;
import com.Hibernet.pojo.UserInfo;
import com.Hibernet.util.HibernetConnection;

public class RidesDao {

	public List searchRides(Rides ridesPojoObj, Long fromLocationId,Long toLocationId,RidesOutBean ridesOutBean) {
			Session sessionObj=null;
			Transaction tx=null;
			List listObj=null;
			HibernetConnection hibernetConnectionObj=new HibernetConnection();
			try{
				
				sessionObj=hibernetConnectionObj.openConnection();			
				Query query=sessionObj.createQuery("select rides.pkrideid,rides.fromlocation,rides.tolocation,rides.date,rides.totalseat,rides.availableseat,rides.price,rides.leavetime,rides.reachedtime"
						+ " from Rides rides "
						+ " join rides.fromlocationObj location "
						+ " join rides.tolocationObj locationw "
						+ " where location.pklocationid=:fromLocation and locationw.pklocationid=:toLocation"
						+ " and rides.leavetime=:leavetimes"
						+ " and rides.date=:date"
						+ " and rides.availableseat >0"
						+ " and rides.isactive='Y'");
						query.setParameter("fromLocation", fromLocationId);
						query.setParameter("toLocation", toLocationId);
						query.setParameter("leavetimes", ridesPojoObj.getLeavetime());
						query.setDate("date", ridesPojoObj.getDate());
						listObj= query.list();
					return listObj;
				
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
			return listObj;
	}
			
				
            
}
