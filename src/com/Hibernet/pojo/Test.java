package com.Hibernet.pojo;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Hibernet.util.HibernetConnection;

public class Test {
	/*public static void main(String[] args) {
		Session sessionObj=null;
		Transaction tx=null;
		List listObj=null;
		HibernetConnection hibernetConnectionObj=new HibernetConnection();
			
			sessionObj=hibernetConnectionObj.openConnection();
			tx=sessionObj.beginTransaction();
			Rides rides  = (Rides)sessionObj.get(Rides.class, 1L);
			
			Rides rides=new Rides();
			UserInfo userInfo = new UserInfo();
			userInfo.setPkuserid(1L);
			rides.setUserInfo(userInfo);
			Location location = new Location();
			location.setPklocationid(1L);
			Location location2 = new Location();
			location2.setPklocationid(2L);
			rides.setFromlocationObj(location);
			rides.setTolocationObj(location2);
			rides.setDate(new Date());
			rides.setAvailableseat(2L);
			rides.setCreateddate(new Date());
			rides.setCreatedby(1L);
			rides.setIsactive("Y");
			rides.setModifieddate(new Date());
			
	
			sessionObj.save(rides);

						tx.commit();
						sessionObj.close();

	}
}

Query query=sessionObj.createQuery("select rides.pkrideid,user.firstname,user.pkuserid,user.lastname"
		+ " from Rides rides "
		+ " join rides.userInfo user"
		+ " where user.pkuserid=1");
			listObj= query.list();
			Iterator itr=listObj.iterator();
			while(itr.hasNext())
			{
				Object object[]=(Object[])itr.next();
				System.out.println(object[0]+""+object[1]+""+object[2]);*/
			}