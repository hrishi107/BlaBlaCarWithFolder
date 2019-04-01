package com.Hibernet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Hibernet.bean.CountryBean;
import com.Hibernet.bean.CountryOutBean;
import com.Hibernet.bean.DistrictBean;
import com.Hibernet.bean.DistrictOutBean;
import com.Hibernet.bean.InputRegistrationBean;
import com.Hibernet.bean.LocationBean;
import com.Hibernet.bean.LocationOutBean;
import com.Hibernet.bean.StateBean;
import com.Hibernet.bean.StateOutBean;
import com.Hibernet.helper.CommonHelper;
import com.Hibernet.pojo.Country;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = false;
		boolean loginResult = false;
		String action=request.getParameter("action");
		String actionState=request.getParameter("actionState");
		String actionUpdateCountry=request.getParameter("actionUpdateCountry");
		String actionDistrict=request.getParameter("actionDistrict");
		String actionLocation=request.getParameter("actionLocation");
		String actionUpdateState=request.getParameter("actionUpdateState");
		String actionUpdateLocation=request.getParameter("actionUpdateLocation");
		if(action!=null && !"".equals(action))
		{
			 if("addcountry".equals(action))
			{	
				 String adminId=request.getParameter("adminId");
				 CountryOutBean countryOutBean=new CountryOutBean();
				  CountryBean  countryBean=new CountryBean();
				  
				  countryBean.setCountryname(request.getParameter("firstname"));
				  CommonHelper commonHelper= new CommonHelper();
				 countryBean=commonHelper.addCountry(adminId,countryBean);
				  if(countryBean!=null)
				  {
					  countryOutBean.setStatusMessage("Successfully Saved!");
					  	HttpSession session=request.getSession();
						session.setAttribute("CountryId", countryBean.getPkcountryid());
					  request.setAttribute("message",countryOutBean.getStatusMessage());
					  
					  RequestDispatcher rd=request.getRequestDispatcher("/jsp/adminpage.jsp");
					  rd.forward(request, response);
				  }
				  else
				  {
					  	countryOutBean.setStatusMessage("Records not found!");
						request.setAttribute("error",countryOutBean.getStatusMessage());
						RequestDispatcher rd=request.getRequestDispatcher("/jsp/error.jsp");
						rd.forward(request, response);
				  }
			}
		}
		if(actionState!=null && !"".equals(actionState))
		{
			if("addstate".equals(actionState))
			 {
				 String adminId=request.getParameter("adminId");
				 String CountryId=request.getParameter("selectCountry");
				 StateBean stateBean=new StateBean();
				 stateBean.setStatename(request.getParameter("stateName"));
				 StateOutBean stateOutBean=new StateOutBean();
				 CommonHelper commonHelper=new CommonHelper();
				 stateBean=commonHelper.addState(adminId,CountryId,stateBean);
				 if(stateBean!=null)
				 {
					 
					 request.setAttribute("message",stateOutBean.getStatusMessage());
					 HttpSession session=request.getSession();
						session.setAttribute("StateId", stateBean.getPkstateid());
					 RequestDispatcher rd=request.getRequestDispatcher("/jsp/adminpage.jsp");
					  rd.forward(request, response);
				 }
				 else
				  {
					  	stateOutBean.setStatusMessage("Records Not Found!");
						request.setAttribute("error",stateOutBean.getStatusMessage());
						RequestDispatcher rd=request.getRequestDispatcher("/jsp/error.jsp");
						rd.forward(request, response);
				  }
			 }
		}
		if(actionDistrict!=null && !"".equals(actionDistrict))
		{
			if("addistrict".equals(actionDistrict))
			{
				String adminId=request.getParameter("adminId");
				String StateId=request.getParameter("selectState");
				DistrictBean districtBean=new DistrictBean();
				districtBean.setDistrictname(request.getParameter("districtName"));
				DistrictOutBean districtOutBean=new DistrictOutBean();
				CommonHelper commonHelper=new CommonHelper();
				districtBean=commonHelper.addDistrict(adminId,StateId,districtBean);
				if(districtBean!=null)
				{
				 
				 request.setAttribute("message",districtOutBean.getStatusMessage());
				 HttpSession session=request.getSession();
					session.setAttribute("DisId", districtBean.getPkdistrictid());
				 RequestDispatcher rd=request.getRequestDispatcher("/jsp/adminpage.jsp");
				  rd.forward(request, response);
				}
				else
				{
				  	districtOutBean.setStatusMessage("Records Not Found!");
					request.setAttribute("error",districtOutBean.getStatusMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/error.jsp");
					rd.forward(request, response);
				}
			}
		}
		if(actionLocation!=null && !"".equals(actionLocation))
		{
			if("addLocation".equals(actionLocation))
			{
				String adminId=request.getParameter("adminId");
				LocationBean locationBean=new LocationBean();
				locationBean.setLocationname(request.getParameter("LocationName"));
				LocationOutBean locationOutBean=new LocationOutBean();
				CommonHelper commonHelper=new CommonHelper();
				locationBean=commonHelper.addLocation(adminId,locationBean);
				if(locationBean!=null)
				{
				 
				 request.setAttribute("message",locationOutBean.getStatusMessage());
				 HttpSession session=request.getSession();
					session.setAttribute("LocId", locationBean.getPklocationid());
				 RequestDispatcher rd=request.getRequestDispatcher("/jsp/adminpage.jsp");
				  rd.forward(request, response);
				}
				else
				{
				  	locationOutBean.setStatusMessage("Records Not Found!");
					request.setAttribute("error",locationOutBean.getStatusMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/error.jsp");
					rd.forward(request, response);
			  }
			}
		}

		if(actionUpdateCountry!=null && !"".equals(actionUpdateCountry))
		{
			if("updateCountry".equals(actionUpdateCountry))
			 {
				 	String adminId=request.getParameter("adminId");
				 	String countryId=request.getParameter("sel");
				 	String countryName=request.getParameter("countryName");
				 	
				 	CountryOutBean countryOutBean=new CountryOutBean();
				 	CountryBean countryBean=new CountryBean();
				  
				  countryBean.setCountryname(request.getParameter("countryName"));
				  
				  CommonHelper commonHelper= new CommonHelper();
				  countryBean=commonHelper.updateCountry(adminId,countryBean,countryId);
				  if(countryBean!=null)
				  {
					  countryOutBean.setStatusMessage("Successfully Saved!");
					  request.setAttribute("contryname",countryBean.getCountryname());
					  request.setAttribute("message",countryOutBean.getStatusMessage());
					  
					  RequestDispatcher rd=request.getRequestDispatcher("/jsp/adminpage.jsp");
					  rd.forward(request, response);
				  }
				  else
				  {
					  	countryOutBean.setStatusMessage("Records not found!");
						request.setAttribute("error",countryOutBean.getStatusMessage());
						RequestDispatcher rd=request.getRequestDispatcher("/jsp/error.jsp");
						rd.forward(request, response);
				  }
			 }

		}
		if(actionUpdateState!=null && !"".equals(actionUpdateState))
		{
			if("UpdateState".equals(actionUpdateState))
			 {
				 	String adminId=request.getParameter("adminId");
				 	String stateId=request.getParameter("sel1");
				 	String stateName=request.getParameter("stateName");
				 	
				 	StateOutBean stateOutBean=new StateOutBean();
				 	StateBean stateBean=new StateBean();
				  
				  stateBean.setStatename(stateName);
				  
				  CommonHelper commonHelper= new CommonHelper();
				  stateBean=commonHelper.updateState(adminId,stateBean,stateId);
				  if(stateBean!=null)
				  {
					  stateOutBean.setStatusMessage("Successfully Saved!");
					  //request.setAttribute("contryname",stateBean.getStatename());
					  request.setAttribute("message",stateOutBean.getStatusMessage());
					  
					  RequestDispatcher rd=request.getRequestDispatcher("/jsp/adminpage.jsp");
					  rd.forward(request, response);
				  }
				  else
				  {
					  	stateOutBean.setStatusMessage("Records not found!");
						request.setAttribute("error",stateOutBean.getStatusMessage());
						RequestDispatcher rd=request.getRequestDispatcher("/jsp/error.jsp");
						rd.forward(request, response);
				  }
			 }

		}
		if(actionUpdateLocation!=null && !"".equals(actionUpdateLocation))
		{
			if("UpdateLocation".equals(actionUpdateLocation))
			 {
				 	String adminId=request.getParameter("adminId");
				 	String locationId=request.getParameter("sel3");
				 	String locationName=request.getParameter("locationName");
				 	
				 	LocationOutBean locationOutBean=new LocationOutBean();
				 	LocationBean locationBean=new LocationBean();
				  
				  locationBean.setLocationname(locationName);
				  
				  CommonHelper commonHelper= new CommonHelper();
				  locationBean=commonHelper.updateLocation(adminId,locationBean,locationId);
				  if(locationBean!=null)
				  {
					  locationOutBean.setStatusMessage("Successfully Saved!");
					  request.setAttribute("location",locationBean.getLocationname());
					  request.setAttribute("message",locationOutBean.getStatusMessage());
					  
					  RequestDispatcher rd=request.getRequestDispatcher("/jsp/adminpage.jsp");
					  rd.forward(request, response);
				  }
				  else
				  {
					  	locationOutBean.setStatusMessage("Records not found!");
						request.setAttribute("error",locationOutBean.getStatusMessage());
						RequestDispatcher rd=request.getRequestDispatcher("/jsp/error.jsp");
						rd.forward(request, response);
				  }
			 }
		}
		
	}
	}


