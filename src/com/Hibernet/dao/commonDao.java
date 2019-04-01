package com.Hibernet.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Hibernet.bean.OutputRegistrationBean;
import com.Hibernet.pojo.Location;
import com.Hibernet.pojo.UserInfo;
import com.Hibernet.util.HibernetConnection;
public class commonDao {
	//AutoComplete
	public  List checkWordsForAutoComplete(Location locationObj) {
		SessionFactory sessionFactory=null;
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try{
			sessionObj=hibernetConnectionObj.openConnection();
			Query query=sessionObj.createQuery("select location.locationname,district.districtname,state.statename,country.countryname,location.pklocationid"
					+ " from Location location "
					+ " join  location.districtObj district"
					+ " join district.stateObj state"
					+ " join state.countryObj country "
					+ "where location.locationname like ?"
					+ " and location.isactive='Y'");
					query.setString(0, "%"+locationObj.getLocationname()+"%");

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
		//return ll;
		return listObj;
	}
	public  List AutoCompleteTolocation(Location locationObj) {
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try{
			sessionObj=hibernetConnectionObj.openConnection();			
			Query query=sessionObj.createQuery("select location.locationname,district.districtname,state.statename,country.countryname,location.pklocationid"
					+ " from Location location "
					+ " join  location.districtObj district"
					+ " join district.stateObj state"
					+ " join state.countryObj country "
					+ "where location.locationname like ?"
					+ " and location.isactive='Y'");
					query.setString(0, "%"+locationObj.getLocationname()+"%");

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
	/*public  List searchRides(Long fromLocationId,Long toLocationId) {
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		try{
			HibernetConnection hibernetConnectionObj=new HibernetConnection();
			sessionObj=hibernetConnectionObj.getConnection().openSession();			
			Query query=sessionObj.createQuery("select rides.pkrideid,rides.fromlocation,rides.tolocation,rides.date,rides.totalseat,rides.availableseat,rides.price,rides.leavetime,rides.reachedtime"
					+ " from Rides rides "
					+ " join rides.fromlocationObj location "
					+ " join rides.tolocationObj locationw "
					+ " where location.pklocationid=:fromLocation and locationw.pklocationid=:toLocation");
					query.setParameter("fromLocation", fromLocationId);
					query.setParameter("toLocation", toLocationId);
					listObj= query.list();
				return listObj;
			
	} catch (Exception e) 
	{
		e.printStackTrace();
	    tx.rollback();
	}
	finally
	{
		sessionObj.close();
		
	}
		return listObj;
	}
*/
	public boolean insertData(UserInfo userInfoObj) throws ClassNotFoundException, IOException, SQLException {
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		try 
		{		 
			sessionObj=hibernetConnectionObj.openConnection();
			tx=sessionObj.beginTransaction();
			OutputRegistrationBean outerRegbeanObj=new OutputRegistrationBean();
			//boolean message=outerRegbeanObj.isStatusFlag();
			//if(!message)
			//{
				sessionObj.save(userInfoObj);
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			hibernetConnectionObj.closeConnection(sessionObj);
			hibernetConnectionObj.closeConnectSessionFactory();
		}
		return true;
	}

	public UserInfo validateLogin(UserInfo userInfoObj) throws ClassNotFoundException, IOException, SQLException {
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		boolean flag=false;
		try{
			sessionObj=hibernetConnectionObj.openConnection();
			Query qry= sessionObj.createQuery("select user.email, user.password ,user.pkuserid, user.isadmin, user.isactive from UserInfo user"
					+ " where user.email=:Email and user.password=:Password"
					+ " and user.isactive='Y'");
			
			qry.setParameter("Email",userInfoObj.getEmail());
			qry.setParameter("Password",userInfoObj.getPassword());
			
			List listData = qry.list();
			if(listData!=null && !listData.isEmpty())
			{
				Iterator it=listData.iterator();
				while(it.hasNext())
				{
					Object rows[] = (Object[])it.next();
					userInfoObj.setEmail((String)rows[0]);
					userInfoObj.setPassword((String)rows[1]);
					userInfoObj.setPkuserid((Long)rows[2]);
					userInfoObj.setIsadmin((String)rows[3]);
					userInfoObj.setIsactive((String)rows[4]);
				}
			}
			}
			catch(Exception e)
		    {
		    	  e.printStackTrace();
		    }
			finally
			{
				hibernetConnectionObj.closeConnection(sessionObj);
				hibernetConnectionObj.closeConnectSessionFactory();
			
			}
		return userInfoObj;

	}
	public boolean vlidateMobile(UserInfo userInfoObj) throws SQLException, ClassNotFoundException, IOException {
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		boolean flag=false;
		
		try{

			sessionObj=hibernetConnectionObj.openConnection();
			Query qry= sessionObj.createQuery("select U.mobileno from UserInfo U where U.mobileno=:mobile"
					+ " and U.isactive='Y'");
			qry.setParameter("mobile",userInfoObj.getMobileno());
			List ll = qry.list();
				if(ll!=null && !ll.isEmpty())
				{
					flag=true;
				}
				else
				{
					flag= false;
				}
			}
			catch(Exception e)
		    {
		    	  e.printStackTrace();
		    }
			finally
			{
				hibernetConnectionObj.closeConnection(sessionObj);
				hibernetConnectionObj.closeConnectSessionFactory();
			}
			return flag;

	}

	public boolean vlidateEmail(UserInfo userInfoObj) throws ClassNotFoundException, IOException, SQLException {
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
		boolean flag=false;
		
		try{
			sessionObj=hibernetConnectionObj.openConnection();
			Query qry= sessionObj.createQuery("select U.email from UserInfo U where U.email=:email"
					+ " and U.isactive='Y'");
			qry.setParameter("email",userInfoObj.getEmail());
			List ll = qry.list();
				if(ll!=null && !ll.isEmpty())
				{
					flag= true;
				}
				else
				{
					flag= false;
				}
			}

			catch(Exception e)
		    {
		    	  e.printStackTrace();
		    }
			finally
			{
				hibernetConnectionObj.closeConnection(sessionObj);
				hibernetConnectionObj.closeConnectSessionFactory();
			}

		return flag;
		
	}
	
}
