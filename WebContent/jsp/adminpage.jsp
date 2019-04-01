<%@page import="com.Hibernet.bean.LocationBean"%>
<%@page import="com.Hibernet.bean.StateBean"%>
<%@page import="com.Hibernet.bean.CountryBean"%>
<%@page import="com.Hibernet.bean.CountryOutBean"%>
<%@page import="java.util.List"%>
<%@page import="com.Hibernet.helper.CommonHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/blablacar.css">
<link href="<%=request.getContextPath()%>/css/jquery-ui.css" rel="Stylesheet"></link>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jquery-3.3.1.js"></script>
<script src="<%=request.getContextPath()%>/javascript/jquery-ui.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/Regjquery.js"></script>
</head>
<body>
	<div class="MainWrapper">
		<%-- <jsp:include page="../jsp/header.jsp" ></jsp:include> --%>
	<%@ include file="../jsp/header.jsp"%> 
	<%
		if(request.getAttribute("message")!=null && !"".equals(request.getAttribute("message")))
		{
			String message=(String)request.getAttribute("message");
			
			%>
				
				<div class="adminh1">
							<Span><%=request.getAttribute("message")%></span>
						</div>
						<%}
						%> 
				<%-- <form  id="form" action="<%=request.getContextPath()%>/AdminController"> --%>
						<div class="adminh1"><h1>Admin Panel</h1></div>
						
					<div class="adminForm">
					<form  id="form" action="<%=request.getContextPath()%>/AdminController">
						<span class="lable">Country</span><input class="inputFeild" id="name" onblur="demo.firstName()" onkeypress="return demo.firstNameAlpha(event)" type="text" placeholder="Enter Deatials" name="firstname" class="textFeild" maxlength="10" onpaste="return false">
						<input onclick="return demo.validateFeild()" id="addcountry" class="countrybutton" type="submit" value="ADD">
						<input type="hidden" name="action" value="addcountry">
						<input type="hidden" name="adminId" value="<%=session.getAttribute("Id")%>">
						<input type="hidden" name="adminId" value="<%=session.getAttribute("CountryId")%>">
				</form><!-- Admin first addc contry Form Ends -->
						
					<form id="stateform" action="<%=request.getContextPath()%>/AdminController">
						<span class="lable1">State</span><input	class="inputFeild" id="lname" onblur="demo.lastName()" onkeypress="return demo.lastNameAlpha(event)" type="text" placeholder="Enter Deatials" name="stateName" class="textFeild" maxlength="10" onpaste="return false">
						<input onclick="return demo.validateStateFeild()" id="addcountry" class="countrybutton" type="submit" value="ADD">
						<input type="hidden" name="actionState" value="addstate">
						<input type="hidden" name="adminId" value="<%=session.getAttribute("Id")%>">
							<span class="Span" id="statemessage"></span>
							<span class="lable">Country</span><select name="selectCountry" id="selectCountry" class="inputFeild" onchange="demo.selectcountryforState()">
  						<option value="">Select</option>
  						<%
  							CommonHelper commonHelper=new CommonHelper();
  							List listdat=(List)commonHelper.selectCountry();
  							if(listdat!=null)
  							{
  								for(int i=0;i<listdat.size();i++)
  								{
									CountryBean countryBean=(CountryBean)listdat.get(i);%>
									<option  value="<%=countryBean.getPkcountryid()%>"><%=countryBean.getCountryname()%></option>		
	
  								<% }
  							}
  							%>
					</select>
					</form><!-- Admin first addc contry Form Ends -->	
						
					<form id="formDistrict" action="<%=request.getContextPath()%>/AdminController">
						<span class="lable2">District</span><input	class="inputFeild" id="dis" onblur="demo.district()" onkeypress="return demo.lastNameAlpha(event)" type="text" placeholder="Enter Deatials" name="districtName" class="textFeild" maxlength="10" onpaste="return false">
						<input onclick="return demo.validateDistrictFeild()" id="addcountry" class="countrybutton" type="submit" value="ADD">
						<input type="hidden" name="actionDistrict" value="addistrict">
						<input type="hidden" name="adminId" value="<%=session.getAttribute("Id")%>">
						<span class="Span" id="distmessage"></span>
 						<span class="lable5">State</span><select name="selectState" id="selectState" class="inputFeild" onchange="demo.selectStateToAddDistrict()">
  						<option value="">Select</option>
  						<%
  							CommonHelper commonHelperState=new CommonHelper();
  							List listState=(List)commonHelperState.selectState();
  							if(listdat!=null)
  							{
  								for(int i=0;i<listState.size();i++)
  								{
									StateBean stateBean=(StateBean)listState.get(i);%>
									<option value="<%=stateBean.getPkstateid()%>"><%=stateBean.getStatename()%></option>		
	
  								<% }
  							}
  							%>
					</select>
							
					</form><!-- Admin first addc contry Form Ends -->	
					
					<form id="form" action="<%=request.getContextPath()%>/AdminController">
						<span class="lable3">Location</span><input	class="inputFeild" id="loc" onblur="demo.location()" onkeypress="return demo.lastNameAlpha(event)" type="text" placeholder="Enter Deatials" name="LocationName" class="textFeild" maxlength="10" onpaste="return false">
						<input onclick="return demo.validateLocation()" id="addcountry" class="countrybutton" type="submit" value="ADD">
						<input type="hidden" name="actionLocation" value="addLocation">
						<input type="hidden" name="adminId" value="<%=session.getAttribute("Id")%>">
						<!-- State Dropdown -->
						
					</form><!-- Admin first addc contry Form Ends -->	
						<hr class="blackLine">					
					<div>
 					<form name="frm" id="form" action="<%=request.getContextPath()%>/AdminController">
 						<span class="Span" id="onDate"></span>
 						<span class="lable">Country</span><select name="sel" id="list" class="inputFeild" onchange="demo.selectcountry()">
  						<option value="">Select</option>
  						<%
  							CommonHelper commonHelper2=new CommonHelper();
  							List listdatList=(List)commonHelper.selectCountry();
  							if(listdat!=null)
  							{
  								for(int i=0;i<listdat.size();i++)
  								{
									CountryBean countryBean=(CountryBean)listdatList.get(i);%>
									<option  value="<%=countryBean.getPkcountryid()%>"><%=countryBean.getCountryname()%></option>		
	
  								<% }
  							}
  							%>
					</select>
					
						<input class="inputFeild" id="countryIn" onblur="" onkeypress="" type="text" placeholder="Enter Deatials" name="countryName" class="textFeild" maxlength="10" onpaste="return false">
						<input onclick="" id="submit" class="countrybutton" type="submit" value="UPDATE">
						<input type="hidden" name="actionUpdateCountry" value="updateCountry">
						<input type="hidden" name="adminId" value="<%=session.getAttribute("Id")%>">
						<hr class="blackLine">
						</form>
 					</div><!-- DropdownList Div Closed-->
 					
 					<div>
 					<form name="frm1" id="form" action="<%=request.getContextPath()%>/AdminController">
 						<span class="Span" id="onDate1"></span>
 						<span class="lable">State</span><select name="sel1" id="list1" class="inputFeild" onchange="demo.selectState()">
  						<option value="">Select</option>
  						<%
  							CommonHelper commonHelperObj=new CommonHelper();
  							List listStatedata=(List)commonHelper.selectState();
  							if(listdat!=null)
  							{
  								for(int i=0;i<listStatedata.size();i++)
  								{
									StateBean stateBean=(StateBean)listStatedata.get(i);%>
									<option value="<%=stateBean.getPkstateid()%>"><%=stateBean.getStatename()%></option>		
	
  								<% }
  							}
  							%>
					</select>
					
						<input class="inputFeild" id="stateIn" onblur="" onkeypress="" type="text" placeholder="Enter Deatials" name="stateName" class="textFeild" maxlength="10" onpaste="return false">
						<input onclick="" id="submit" class="countrybutton" type="submit" value="UPDATE">
						<input type="hidden" name="actionUpdateState" value="UpdateState">
						<input type="hidden" name="adminId" value="<%=session.getAttribute("Id")%>">
						<hr class="blackLine">
						</form>
 					</div><!-- Dropdownlist Div Closed -->
 					
 					<div>
 					<form name="form1" id="form" action="<%=request.getContextPath()%>/AdminController">
 						<span class="Span" id="onDate2"></span>
 						<span class="lable">Location</span><select name="sel3" id="list2" class="inputFeild" onchange="demo.selectLocation()">
  						<option value="">Select</option>
  						<%
  							CommonHelper commonHelper3=new CommonHelper();
  							List locationList=(List)commonHelper.selectLocation();
  							if(locationList!=null)
  							{
  								for(int i=0;i<locationList.size();i++)
  								{
									LocationBean locationBean=(LocationBean)locationList.get(i);%>
									<option value="<%=locationBean.getPklocationid()%>"><%=locationBean.getLocationname()%></option>		
	
  								<%}
  							}%>
					</select>
					
						<input class="inputFeild" id="DistrictIn" onblur="" onkeypress="" type="text" placeholder="Enter Deatials" name="locationName" class="textFeild" maxlength="10" onpaste="return false">
						<input onclick="" id="submit" class="countrybutton" type="submit" value="UPDATE">
						<input type="hidden" name="actionUpdateLocation" value="UpdateLocation">
						<input type="hidden" name="adminId" value="<%=session.getAttribute("Id")%>">
						<hr class="blackLine">
						</form>
 					</div><!-- Dropdownlist Div Closed -->
 	
 						
 					
				</div><!-- Admin form wala div closed -->
				
				
				
					<!-- registerdiv -->
					<div class="Registerdiv" onclick="demo.RegisterForm()">
						<div id="hrishi"  class="form">
							<div id="RegisterContainer" class="container1" >
								<form class="formHeight" id="form" action="<%=request.getContextPath()%>/CommonController">
									<h1 class="Heading1">Register<a onclick="demo.errorHide()"><span class="cross"><span></a></h1>
										<p>Please fill in this form to create an account.</p>
									<hr>

									<p><label for="email"><b style="float:left">FirstName</b><span class="Span" id="ON"></span><br></label><p>
										<input id="name" onblur="demo.firstName()" onkeypress="return demo.firstNameAlpha(event)" type="text" placeholder="Enter FirstName" name="firstname" class="textFeild" maxlength="10" onpaste="return false">
						

									<p><label for="email"><b style="float:left">LastName</b></label><span class="Span" id="ON1"></span><br></p>
										<input id="lname" onblur="demo.lastName()" onkeypress="return demo.lastNameAlpha(event)" type="text" placeholder="Enter LastName" name="lastname" class="textFeild1" maxlength="10" onpaste="return false">
						
	
									<p><span class="Span" id="ON9"></span><br><br>
										<label for="Gender"><b style="float:left">Gender</b></label>
										<input  type="radio" name="gender" value="male" checked> Male
										<input  type="radio" name="gender" value="female"> Female
									</p>

										<p onblur="demo.checkBoxValid()"><span  class="Span"id="ON10"></span><br><br>
											<label class="All" for="Hobbies"><b style="float:left">Hobbies</b></label>
											<input class="chBox" id="Read" type="checkbox" name="Hobbies" value="Rading">Reading
											<input class="chBox" id="Play" type="checkbox" name="Hobbies" value="Play">Playing
											<input class="chBox" id="Sing" type="checkbox" name="Hobbies" value="Sing">Singing
										</p>

										<p><label><b style="float:left">Mobile Number</b></label><span class="Span" id="ON2"></span><br></p>
										<input onblur="demo.mobNumber()" onkeypress="return demo.numOnly(event)" id="MbNum" type="text" placeholder="Enter Mobile Number" name="mbnum" class="numFeild" maxlength="10" onpaste="return false">
						

										<p><label for="email"><b style="float:left">Email</b></label><span class="Span" id="ON3"></span><br></p>
										<input onblur="demo.emailId()" id="emailID" type="text" placeholder="Enter Email" name="email" maxlength="20" onpaste="return false">
						

										<p><label for="Address"><b style="float:left">Adress</b></label><span class="Span" id="ON4"></span><br><br></p>
										<input onblur="demo.address()" id="Address" type="text" placeholder="Enter Address" name="address" maxlength="255" onpaste="return false">
						
    
										<p><label for="Date"><b style="float:left">Date Of Birth</b></label><span class="Span" id="ON8"></span><br></p>
										<input onblur="demo.date()" id="date" type="text" placeholder="Enter date" name="dateOfBirth" onpaste="return false">
						

										<p><label for="PinCode"><b style="float:left">Pincode</b></label><span class="Span" id="ON5"></span><br></p>
										<input onblur="demo.pin()" onkeypress="return demo.numOnlyPin(event)" id="pin" type="text" placeholder="Enter Pincode" name="pincode" class="numFeild1" maxlength="6" onpaste="return false">
						

										</p><label for="psw"><b style="float:left">Password</b></label><span class="Span" id="ON6"></span><br></p>
										<input onblur="demo.pass()" id="Pass" type="password" placeholder="Enter Password" name="psw" maxlength="10" onpaste="return false">
						

										<p><label for="psw-repeat"><b style="float:left">Repeat Password</b></label><span class="Span" id="ON7"></span></p>
										<input onblur="demo.confirmpass()" id="Pass1" type="password" placeholder="Repeat Password" name="psw-repeat" maxlength="10" onpaste="return false">
						
							<hr>
    
						<input onclick="return demo.validateRegForm()" id="submit" class="registerbtn" type="submit" value="register">
						<button onclick="return demo.resetRegForm()"  id="reset" type="reset" class="registerbtn1">Clear</button>
						<input type="hidden" name="action" value="registration">
						<input type="hidden" name="contextpath" value="<%=request.getContextPath()%>" id="contextpath">
						<input type="hidden" name="contextpath" value="<%=request.getContextPath()%>" id="path">
				</form>
				</div><!--container-->
				

			</div>
		</div><!-- class form wala div-->
					
					<!--LOgin HTML-->
			
			<div class="Registerdiv" onclick="demo.RegisterForm()">
				<div id="hrishi1"  class="form">
					<div id="RegisterContainer1" class="container2">
						<form id="form" action="<%=request.getContextPath()%>/CommonController">
							<h1 class="Heading1">Login<a onclick="demo.errorHideforLogin()"><span class="cross"><span></a></h1>
							<p>Please fill in this form to create an account.</p>
							<hr>
							<p><label for="email"><b style="float:left">Email</b></label><span class="Span" id="ON13"></span><br></p>
							<input onblur="demo.loginemailId()" id="emailID1" type="text" placeholder="Enter Email" name="email" maxlength="40" onpaste="return false">
							

							</p><label for="psw"><b style="float:left">Password</b></label><span class="Span" id="ON14"></span><br></p>
							<input onblur="demo.loginpass()" id="Pass2" type="password" placeholder="Enter Password" name="psw" maxlength="10" onpaste="return false">
							

							<input onclick="return demo.validateRegForm1()" id="submit1" class="registerbtn" type="submit" value="Login">
							<button onclick="return demo.resetLogForm()"  id="reset1" type="reset" class="registerbtn1">Clear</button>
							<a id="reglink" onclick="demo.openRegistrationForm()">Registartion</a>
							<input  type="hidden" name="action" value="login">
						</form>
					</div><!--register Container-->
				</div><!--Hrishi div-->

				<div class="Display">
					<div id="MainDisplay1" class="DisplayDiv1">
					<h2><span class="displaySpan" id="Span15"></span></h2>
					<p>Email:<span class="displaySpan" id="Span16"></span></p>
					<p>Pass:<span class="displaySpan" id="Span17"></span></p>
		
				</div>
			</div>
		</div><!--Registered Div-->
			<!-- </div> -->
		<!-- <div class="citypoup">
		</div>-->
		<%-- <%@ include file="../jsp/footer.jsp"%> --%>
		
		
		
		
	</div><!-- main wrapper ends -->
</body>
</html>