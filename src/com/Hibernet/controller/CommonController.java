package com.Hibernet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Hibernet.bean.BookingOutBean;
import com.Hibernet.bean.InputRegistrationBean;
import com.Hibernet.bean.OutputRegistrationBean;
import com.Hibernet.bean.RidesBean;
import com.Hibernet.bean.RidesOutBean;
import com.Hibernet.bean.SearchOutputBean;
import com.Hibernet.helper.CommonHelper;
import com.Hibernet.helper.RegistartionHelper;
import com.Hibernet.pojo.Booking;
import com.Hibernet.pojo.Location;
import com.Hibernet.pojo.Rides;

public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CommonController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = false;
		boolean loginResult = false;
		String action=request.getParameter("action");
		
		if(action!=null && !"".equals(action))
		{
			 if("registration".equals(action))
			{
				 InputRegistrationBean regBeanObj=new InputRegistrationBean();
				 
				 regBeanObj.setFirstname(request.getParameter("firstname"));
				 regBeanObj.setLastname(request.getParameter("lastname"));
				 regBeanObj.setGender(request.getParameter("gender"));
				 regBeanObj.setHobbies(request.getParameter("Hobbies"));    
				 regBeanObj.setMobileno(Long.parseLong(request.getParameter("mbnum")));
				 regBeanObj.setEmail(request.getParameter("email"));
				 regBeanObj.setAddress(request.getParameter("address"));
				 regBeanObj.setDateofbirth(request.getParameter("dateOfBirth"));
				 regBeanObj.setPincode(Long.parseLong(request.getParameter("pincode")));
				 regBeanObj.setPassword(request.getParameter("psw"));
				 regBeanObj.setRepeatpassword(request.getParameter("psw-repeat"));
				
				 		/*........Helper method calling.............*/
				 RegistartionHelper reghelperObj=new RegistartionHelper();
				 
				try {
					result = reghelperObj.validateFeilds(regBeanObj);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				 
				 if(!result)
				 {
					  //redirection to error page
					 response.sendRedirect(request.getContextPath()+"/jsp/error.jsp");
				 }
				 else
				 {
					 System.out.println(result);
					response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
				 }
				 
			}//If StateMent for Registartion ends
			 else if("login".equals(action))
				{
					 OutputRegistrationBean outRegBeanObj=new OutputRegistrationBean();
					 InputRegistrationBean regBeanObj=new InputRegistrationBean();
					 
					 regBeanObj.setEmail(request.getParameter("email"));
					 regBeanObj.setPassword(request.getParameter("psw"));
					 RegistartionHelper reghelperObj=new RegistartionHelper();
					 String isadmin=null;
					 String active=null;
					 try {
						regBeanObj=reghelperObj.validLogin(regBeanObj);
						isadmin=regBeanObj.getIsadmin();
						active =regBeanObj.getIsactive();
					} catch (ClassNotFoundException | SQLException e) {
						
						e.printStackTrace();
					}
					if("Y".equalsIgnoreCase(isadmin) && "Y".equalsIgnoreCase(active))
					 {
							HttpSession session=request.getSession();
							session.setAttribute("Id", regBeanObj.getUserid());
						 	
							RequestDispatcher rd=request.getRequestDispatcher("/jsp/adminpage.jsp");
							rd.forward(request, response);
					 }
					 if(outRegBeanObj.isStatusFlag())
					 {
						 String error="Incorrect details";
						 response.sendRedirect(request.getContextPath()+"/jsp/error.jsp?error="+error);
						 
					 }
					 if("N".equalsIgnoreCase(isadmin) && "Y".equalsIgnoreCase(active))
					 {
						
						 HttpSession session=request.getSession();
						 session.setAttribute("email", regBeanObj.getEmail());
						 session.setAttribute("userId", regBeanObj.getUserid());
						 String actionType=request.getParameter("actionType");
						 String actionMark=request.getParameter("actionMark");
						 if("offerRide".equals(actionType))
							{
								response.sendRedirect(request.getContextPath()+"/jsp/offerride.jsp");
							}
						 	
						 else if("ridesDetails".equals(actionMark))
							{
							 	response.sendRedirect(request.getContextPath()+"/jsp/rideuserdetails.jsp?pkRideId="+session.getAttribute("pkRideId"));
							}
						 else{
							 response.sendRedirect(request.getContextPath()+"/index.jsp");
						 	}
					 }
				}
			 else if("Search".equals(action))
				{
					 OutputRegistrationBean outRegBeanObj=new OutputRegistrationBean();
					 RidesBean ridesBeanObj=new RidesBean();
					 RidesOutBean ridesOutBean=new RidesOutBean();
					 
					 String fromLocation=request.getParameter("fromLocation");
					 String toLocation=request.getParameter("tolocation");
					 String rideDate=request.getParameter("date");
					 String  datArr[]=rideDate.split("-");
					 Date date=new Date(datArr[1] +"/" +datArr[0] +"/"+datArr[2]);
					 
						ridesBeanObj.setDate(date);
						ridesBeanObj.setLeavetime(request.getParameter("sel"));
						if(fromLocation!=null && !"".equals(fromLocation) && toLocation!=null && !"".equals(toLocation))
						{	
							CommonHelper commonhelperObj=new CommonHelper(); 
							String location=null;
							Long rideId=null;
							try {
								List listObj=new ArrayList();
								List listdata=null;
								listdata=new ArrayList();
								listObj=commonhelperObj.searchRides(ridesBeanObj,fromLocation,toLocation,ridesOutBean);
								Iterator itr=listObj.iterator();
								if(listObj!=null && !listObj.isEmpty())
								{
									while(itr.hasNext())
									{
										RidesBean ridesbeanObj=new RidesBean();
										Object Obj[] = (Object[])itr.next();
										ridesbeanObj.setPkrideid((Long)Obj[0]);
										ridesbeanObj.setFromlocation((String)Obj[1]);
										ridesbeanObj.setTolocation((String)Obj[2]);
										ridesbeanObj.setDate((Date)Obj[3]);
										ridesbeanObj.setTotalseat((Long)Obj[4]);
										ridesbeanObj.setAvailableseat((Long)Obj[5]);
										ridesbeanObj.setPrice((Long)Obj[6]);
										ridesbeanObj.setLeavetime((String)Obj[7]);
										ridesbeanObj.setReachedtime((String)Obj[8]);
										listdata.add(ridesbeanObj);
										//=Obj[1].toString()+","+Obj[2].toString()+","+Obj[3].toString()+","+Obj[4].toString()+","+Obj[5].toString()+","+Obj[6].toString()+","+Obj[7].toString();
									}
							 
									if(listdata!=null && !listdata.isEmpty() && ridesOutBean.isStatusFlag())
									{
										request.setAttribute("rideDetails", listdata);
										RequestDispatcher rd=request.getRequestDispatcher("/jsp/ridedetails.jsp");
										rd.forward(request, response);
									}
									else
									{	
										ridesOutBean.setStatusMessage("Records not found!");
										request.setAttribute("error",ridesOutBean.getStatusMessage());
										RequestDispatcher rd=request.getRequestDispatcher("/jsp/error.jsp");
										rd.forward(request, response);
									}
							 
								}else
								{	
									ridesOutBean.setStatusMessage("Records not found!");
									request.setAttribute("error",ridesOutBean.getStatusMessage());
									RequestDispatcher rd=request.getRequestDispatcher("/jsp/error.jsp");
									rd.forward(request, response);
						 }
						
						} catch (Exception e) {
							
							e.printStackTrace();
					}
				}else{
					
					ridesOutBean.setStatusMessage("Records not found!");
					request.setAttribute("error",ridesOutBean.getStatusMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/error.jsp");
					rd.forward(request, response);
				}
			}
			 else if("createRide".equals(action))
			 {
			
				 RidesBean ridesBeanObj=new RidesBean();
				 RidesOutBean ridesOutBean=new RidesOutBean();
				 
				 String fromLocationId=request.getParameter("fromLocation");
				 String toLocationId=request.getParameter("tolocation");
				 String fromLocation=request.getParameter("from");
				 String toLocation=request.getParameter("to");
				 String userid=request.getParameter("userId");
				 String rideDate=request.getParameter("date");
				 String  datArr[]=rideDate.split("-");
				 Date date=new Date(datArr[1] +"/" +datArr[0] +"/"+datArr[2]);
				 
				 
					ridesBeanObj.setDate(date);
					ridesBeanObj.setLeavetime(request.getParameter("sel"));
					if(fromLocationId!=null && !"".equals(fromLocationId) && toLocationId!=null && !"".equals(toLocationId) && fromLocation!=null && !"".equals(fromLocation) && toLocation!=null && !"".equals(toLocation))
					{	
						CommonHelper commonhelperObj=new CommonHelper(); 
						String location=null;
						Long rideId=null;
						try {
							ridesOutBean=commonhelperObj.createRide(ridesBeanObj,fromLocationId,toLocationId,userid,ridesOutBean,fromLocation,toLocation);
							if(ridesOutBean!=null)
							{
								 
								 String message="Rides Booked Succesfully. BookingId="+ridesOutBean.getPkrideid();
								 response.sendRedirect(request.getContextPath()+"/jsp/offerride.jsp?message="+message);

							}
					} catch (Exception e) {
						
						e.printStackTrace();
				}
			}else{
				
				ridesOutBean.setStatusMessage("Records not found!");
				request.setAttribute("error",ridesOutBean.getStatusMessage());
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/error.jsp");
				rd.forward(request, response);
			}				 
			 }
			 else if("Book".equals(action))
			 {
				 String pkrideId=request.getParameter("rideId");
				 String pkuserId=request.getParameter("userId");
				 String sectedSeatCount=request.getParameter("sectedSeatCount");
				 BookingOutBean bookingOutBean=null;
				 CommonHelper commonHelper=new CommonHelper();
				 bookingOutBean=commonHelper.bookSeats(pkrideId,pkuserId,sectedSeatCount);
				 
				if(bookingOutBean!=null)
				 {
					 HttpSession session=request.getSession();
					 String message="Rides Booked Succesfully. BookingId="+bookingOutBean.getPkbookingid();
					 session.setAttribute("Bean", null);	 
					 
					 response.sendRedirect(request.getContextPath()+"/jsp/rideuserdetails.jsp?message="+message);
				 }
				 else
				 {
					bookingOutBean.setStatusMessage("Records not found!");
					request.setAttribute("error",bookingOutBean.getStatusMessage());
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/error.jsp");
					rd.forward(request, response);
					 
				 }
			
			 }
		}
	}

}
