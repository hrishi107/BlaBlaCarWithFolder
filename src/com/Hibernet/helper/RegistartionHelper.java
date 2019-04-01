package com.Hibernet.helper;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.Hibernet.bean.InputRegistrationBean;
import com.Hibernet.bean.OutputRegistrationBean;
import com.Hibernet.dao.commonDao;
import com.Hibernet.pojo.UserInfo;
public class RegistartionHelper {

	public boolean validateFeilds(InputRegistrationBean regBeanObj) throws ClassNotFoundException, IOException, SQLException {
		if(regBeanObj.getFirstname() == null || " ".equals(regBeanObj.getFirstname()))
		{
			return false;		
		}
		if(regBeanObj.getLastname() ==null || "".equals(regBeanObj.getLastname()))
		{
				return false;		
		}
		if(regBeanObj.getGender() ==null || "".equals(regBeanObj.getGender()))
		{
			return false;		
		}
		if(regBeanObj.getHobbies() ==null || "".equals(regBeanObj.getHobbies()))
		{
			return false;			
		}
		if(String.valueOf(regBeanObj.getMobileno())==null || "".equals(regBeanObj.getMobileno()))
		{
			return false;			
		}
		if(regBeanObj.getEmail()==null || "".equals(regBeanObj.getEmail()))
		{
			return false;			
		}
		if(regBeanObj.getAddress()==null || "".equals(regBeanObj.getAddress()))
		{
			return false;			
		}
		
		if(regBeanObj.getDateofbirth()==null || "".equals(regBeanObj.getDateofbirth()))
		{
			return false;			
		}
		if(String.valueOf(regBeanObj.getPincode())==null || "".equals(regBeanObj.getPincode()))
		{
			return false;			
		}
		if(regBeanObj.getPassword()==null || "".equals(regBeanObj.getPassword()))
		{
			return false;			
		}
		if(regBeanObj.getRepeatpassword()==null || "".equals(regBeanObj.getRepeatpassword()))
		{
			return false;			
		}
		else
		{
			UserInfo userInfoObj=new UserInfo();
			//userInfoObj.setId(regBeanObj.getId());
			userInfoObj.setFirstname(regBeanObj.getFirstname());
			userInfoObj.setLastname(regBeanObj.getLastname());
			userInfoObj.setGender(regBeanObj.getGender());
			userInfoObj.setAddress(regBeanObj.getAddress());
			String date=regBeanObj.getDateofbirth();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
			Date changedate=null;
			try {
				changedate=sdf.parse(date);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
				
			java.sql.Date dd=new java.sql.Date(changedate.getTime());
			userInfoObj.setDateofbirth(dd);
			
			userInfoObj.setEmail(regBeanObj.getEmail());
			userInfoObj.setMobileno(regBeanObj.getMobileno());
			userInfoObj.setHobbies(regBeanObj.getHobbies());
			userInfoObj.setPincode(regBeanObj.getPincode());
			userInfoObj.setPassword(regBeanObj.getPassword());
			userInfoObj.setRepeatpassword(regBeanObj.getRepeatpassword());
			userInfoObj.setIsactive(regBeanObj.getIsactive());
			userInfoObj.setCreateddate(new Date());
			userInfoObj.setCreatedby(1001);
			
			commonDao CommDaoObj=new commonDao();
			boolean flag=CommDaoObj.insertData(userInfoObj);
			//System.out.println(flag);
			return true;
		}
		
	}
	/*Ajax call mobile*/
	public OutputRegistrationBean vlidateMobile(InputRegistrationBean regBeanObj) throws ClassNotFoundException, IOException, SQLException {
		OutputRegistrationBean outRegBeanObj=new OutputRegistrationBean();
		
		if(String.valueOf(regBeanObj.getMobileno())==null || "".equals(regBeanObj.getMobileno()))
		{
			outRegBeanObj.setStatusFlag(false);
			outRegBeanObj.setStatusMessage("Ok!");
			return outRegBeanObj;
		}
		else
		{
			commonDao CommDaoObj=new commonDao();
			UserInfo userInfoObj=new UserInfo();
			userInfoObj.setMobileno(regBeanObj.getMobileno());
			
			boolean flag=CommDaoObj.vlidateMobile(userInfoObj);
			System.out.println(flag);
			outRegBeanObj.setStatusFlag(flag);
			outRegBeanObj.setStatusMessage("Mb no already exist");;
			return outRegBeanObj;
			
		}
	}
	/*Ajax call email*/
	public OutputRegistrationBean validateEmail(InputRegistrationBean regBeanObj) throws ClassNotFoundException, IOException, SQLException {
		OutputRegistrationBean outRegBeanObj=new OutputRegistrationBean();
		if(regBeanObj.getEmail()==null || "".equals(regBeanObj.getEmail()))
		{
			outRegBeanObj.setStatusFlag(false);
			outRegBeanObj.setStatusMessage("Ok!");
			return outRegBeanObj;
			
		}
		else
		{
			commonDao CommDaoObj=new commonDao();
			UserInfo userInfoObj=new UserInfo();
			userInfoObj.setEmail(regBeanObj.getEmail());
			boolean flag=CommDaoObj.vlidateEmail(userInfoObj);
			System.out.println(flag);
			outRegBeanObj.setStatusFlag(flag);
			outRegBeanObj.setStatusMessage("Email already exist");;
			return outRegBeanObj;
			
		}
		
	}
	public InputRegistrationBean validLogin(InputRegistrationBean regBeanObj) throws ClassNotFoundException, IOException, SQLException {
			
			OutputRegistrationBean outRegBeanObj=new OutputRegistrationBean();
			InputRegistrationBean iBean=new InputRegistrationBean();
			if(regBeanObj.getEmail()==null || "".equals(regBeanObj.getEmail()))
			{
				outRegBeanObj.setStatusFlag(false);
				outRegBeanObj.setStatusMessage("Ok!");
				return regBeanObj;
			}
			if(regBeanObj.getPassword()==null || "".equals(regBeanObj.getPassword()))
			{
				outRegBeanObj.setStatusFlag(false);
				outRegBeanObj.setStatusMessage("Ok!");
				return regBeanObj;			
			}
			else
			{
				commonDao CommDaoObj=new commonDao();
				UserInfo userInfObj=new UserInfo();
				userInfObj.setEmail(regBeanObj.getEmail());
				userInfObj.setPassword(regBeanObj.getPassword());
				userInfObj=CommDaoObj.validateLogin(userInfObj);
				
								
				iBean.setEmail(userInfObj.getEmail());
				iBean.setPassword(userInfObj.getPassword());
				iBean.setUserid(userInfObj.getPkuserid());
				iBean.setIsadmin(userInfObj.getIsadmin());
				iBean.setIsactive(userInfObj.getIsactive());
				
				outRegBeanObj.setStatusFlag(true);
				outRegBeanObj.setStatusMessage("Correct details");
				
			}
			return iBean;
		}
	
}
