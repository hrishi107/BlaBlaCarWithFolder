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
		<div class="findRide">
			<div class="findRideDiv">
				<h1 >Find a Ride</h1>
				<form name="frm" action="<%=request.getContextPath()%>/CommonController">				
				<div class="inputSearch">
					<span class="Span" id="ONN"></span>
					<input id="Serching" onblur="demo.autocompleteFromLocation()" onkeyup="demo.autoCompleteFunction()" class="searchboxheader" type="text" placeholder="Leaving from" spellcheck="false" background-color: transparent;">
					<div id="autopopup"></div>
					<input type="hidden" name="fromLocation" id="fromLocation" value="">
					
					<span class="Span" id="ONNN"></span>
					<input id="Serching1" onblur="demo.autocompleteToLocation()" onkeyup="demo.autoCompleteFunctionTolocation()" class="searchboxheader" type="text" placeholder="Going to" spellcheck="false" background-color: transparent;">
					<div id="autopopup1"></div>
					<input type="hidden" name="tolocation" id="tolocation" value="">
				</div>
				<div>
				<hr class="blackLine">
					<p><label for="Date"><b class="k">Date</b></label><span class="Span" id="dateId"></span><br></p>
					<input class="searchboxheader" onblur="demo.dateFunction()" placeholder="Enter date" id="onDateVal" type="text" name="date" onpaste="return false">
					<p><label for="Date"><b class="k">Time</b></label><span class="Span" id="onDate"></span><br></p>
					<select name="sel" id="list" class="searchboxheader">
  						<option value="">Select</option>
  						<option value="8:00">8:00</option>
  						<option value="9:00">9:00</option>
  						<!-- <option value="10:00">10:00</option>
  						<option value="11:00">11:00</option>
  						<option value="12:00">12:00</option>
  						<option value="1:00">1:00</option>
  						<option value="2:00">2:00</option>
  						<option value="3:00">3:00</option>
  						<option value="4:00">4:00</option>
  						<option value="5:00">5:00</option> -->
					</select>
				<hr class="blackLine">
				</div>
				<input onclick="return demo.validateRideForm()" id="submit" class="registerbtn" type="submit" value="Search Rides">
				<!-- <button onclick="return demo.resetRideForm()"  id="reset" type="reset" class="registerbtn1">Clear</button> -->
				<input type="hidden" name="action" value="Search">
				</form>
			</div>
			
		</div>
	
	
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
			<div class="over" onclick="demo.bodyclick()" id="Over"></div>
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