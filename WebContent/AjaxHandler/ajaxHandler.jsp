<%@page import="com.Hibernet.helper.*"%>
<%@page import="javax.jms.Session"%>
<%@ page import="com.Hibernet.commonAjaxController.*" %>
<%!long seatTbaleId=0;
long screenId=0;
long id1=0;
String autoComplete=null;
%>
<%!
public String Ajaxhandler(HttpServletRequest request,HttpServletResponse response)
{
	
	CommonAjaxHandler CommonajxControllerobj=new CommonAjaxHandler();
	//long seatTableId=0;
	HttpSession session=request.getSession();
	
	String action=request.getParameter("action");
	try{
		if(action!=null && !"".equals(action))
		{
			 if("checkmobNumber".equals(action))
			{
				try{
					//return CommonajxControllerobj.checkMobileNum(request, response);
				}
				catch(Exception e)
				{
					
					
				}
			}
			if("checkEmail".equals(action))
			{
				try{
					//return CommonajxControllerobj.checkEmail(request, response);
				}
				catch(Exception e)
				{
					
				}
			}
			if("checkWordsForAutoComplete".equals(action))
			{
				
				autoComplete=request.getParameter("searchKey");
				return CommonajxControllerobj.checkWordsForAutoComplete(request,response,autoComplete);
				
			}
			if("checkWordsForAutoCompleteToLocation".equals(action))
			{
				String SearchVal=request.getParameter("searchKey");
				return CommonajxControllerobj.AutoCompleteToLocation(request,response,SearchVal);	
			}
					
		}					
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	return "";
}

%>

<%=Ajaxhandler(request,response) %>
