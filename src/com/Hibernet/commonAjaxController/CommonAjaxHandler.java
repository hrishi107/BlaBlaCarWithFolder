package com.Hibernet.commonAjaxController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Hibernet.bean.InputRegistrationBean;
import com.Hibernet.bean.OutputRegistrationBean;
import com.Hibernet.bean.SearchOutputBean;
import com.Hibernet.helper.CommonHelper;
import com.Hibernet.helper.RegistartionHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CommonAjaxHandler {

	
	public String toJSON(Object jsonObject)
	{
		Gson gson= new GsonBuilder().create();
		return gson.toJson(jsonObject);
	}
	
	public String checkMobileNum(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException
	{
		InputRegistrationBean regBeanObj=new InputRegistrationBean();
		regBeanObj.setMobileno(Long.parseLong(request.getParameter("mobile")));
		
		RegistartionHelper reghelperObj=new RegistartionHelper();
		
		OutputRegistrationBean flag = reghelperObj.vlidateMobile(regBeanObj);
		return toJSON(flag);
	}
	public String checkEmail(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException
	{
		InputRegistrationBean regBeanObj=new InputRegistrationBean();
		regBeanObj.setEmail(request.getParameter("email"));
		
		RegistartionHelper reghelperObj=new RegistartionHelper();
		OutputRegistrationBean flag = reghelperObj.validateEmail(regBeanObj);
		return toJSON(flag);
	}
	public String checkWordsForAutoComplete(HttpServletRequest request,HttpServletResponse response,String autoComplete) throws ClassNotFoundException, IOException, SQLException
	{
		CommonHelper commonhelperobj=new CommonHelper();
		
		List ll=commonhelperobj.checkWordsForAutoComplete(request,response,autoComplete);
		Iterator it=ll.iterator();
		List dataList=new ArrayList();
		while(it.hasNext())
		{
			List listObj=new ArrayList();
			Object Obj[] = (Object[])it.next();
			String location=Obj[0].toString()+","+Obj[1].toString()+","+Obj[2].toString()+","+Obj[3].toString();
			Long locationid=(Long) Obj[4];
			listObj.add(locationid);
			listObj.add(location);
			dataList.add(listObj);
		}
		
		return toJSON(dataList);
	}
	public String AutoCompleteToLocation(HttpServletRequest request,HttpServletResponse response,String autoComplete) throws ClassNotFoundException, IOException, SQLException
	{
		CommonHelper commonhelperobj=new CommonHelper();
		
		List ll=commonhelperobj.AutoCompleteToLocation(request,response,autoComplete);
		Iterator it=ll.iterator();
		List dataList=new ArrayList();
		while(it.hasNext())
		{
			List listObj=new ArrayList();
			Object Obj[] = (Object[])it.next();
			String location=Obj[0].toString()+","+Obj[1].toString()+","+Obj[2].toString()+","+Obj[3].toString();
			Long locationid=(Long) Obj[4];
			listObj.add(locationid);
			listObj.add(location);
			dataList.add(listObj);
		}
		
		return toJSON(dataList);
	}
}
