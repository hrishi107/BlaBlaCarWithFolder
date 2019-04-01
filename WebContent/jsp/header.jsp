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

<header class="Header">
			<div class="primaryheader">
				
					<div class="">
					
					<a href="<%=request.getContextPath()%>/index.jsp"><span class="bookmyshowpng"></span></a>
					<input type="hidden" name="action" value="Search">
					</div>
					<!-- </form> -->
				<div class="innernav">
					<ul id="citydiv" class="headerlinks">
						<li class="swing">
						<a href="<%=request.getContextPath()%>/jsp/searchingride.jsp" class="nav-link">Find a Ride</a>
						</li>
						<li class="swing">
						<a href="<%=request.getContextPath()%>/jsp/offerride.jsp" class="nav-link">Offer a Ride</a>
						</li>
						<%Long id=(Long)session.getAttribute("userId");
							if(id!=null && !"".equals(id))
							{%>
								<li class="swing">
								<a id="register" href="<%=request.getContextPath()%>/jsp/bookinghistory.jsp" class="nav-link">Check History</a>
								</li>
								<li class="swing">
								<a id="register" href="<%=request.getContextPath()%>/jsp/bookindetails.jsp" class="nav-link">Booking details</a>
								</li>
								<li class="swing">
								<a href="<%=request.getContextPath()%>/jsp/logout.jsp" id="login" class="nav-link">LogOut</a>
								</li>
							<%}
							else{
						%>
						<li class="swing">
						<a id="login" onclick="demo.loginPopUp()" class="nav-link">Login</a>
						</li>
						<li class="swing">
						<a id="register" onclick="demo.popUp()" class="nav-link">Register</a>
						</li>
						<%}%>
						<li  id="CurrentCity" class="swing">
							
						</li>
						
						<div class="clr"></div>
					</ul>
					
				
					</div>
					
					 
		</div><!--primary heder-->
				
				
				
	</header><!-- main header -->


</body>
</html>