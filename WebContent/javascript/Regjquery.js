
var demo=new Demo();

function Demo()
{
		this.isEmpty=isEmpty;
		this.checkBoxValid=checkBoxValid;
		this.firstName=firstName;
		this.lastName=lastName;
		this.mobNumber=mobNumber;
		this.emailId=emailId;
		this.address=address;
		this.date=date;
		this.pin=pin;
		this.pass=pass;
		this.confirmpass=confirmpass;
		this.firstNameAlpha=firstNameAlpha;
		this.lastNameAlpha=lastNameAlpha;
		this.numOnly=numOnly;
		this.numOnlyPin=numOnlyPin;
		this.validateRegForm=validateRegForm;
		this.popUp=popUp;
		this.loginPopUp=loginPopUp;
		this.loginemailId=loginemailId;
		this.loginpass=loginpass;
		this.validateRegForm1=validateRegForm1;
		this.errorHide=errorHide;
		this.errorHideforLogin=errorHideforLogin;
		this.resetRegForm=resetRegForm;
		this.resetLogForm=resetLogForm;
		this.bodyclick=bodyclick;
		this.RegisterForm=RegisterForm;
		this.validateMob=validateMob;
		this.validateEmail=validateEmail;
		this.openRegistrationForm=openRegistrationForm;
		var flag;
		var flag1;
		this.autoCompleteFunction=autoCompleteFunction;
		var countSeats=1;
		var countvar=1;
		this.getLocation=getLocation;
		this.autoCompleteFunctionTolocation=autoCompleteFunctionTolocation;
		this.getToLocation=getToLocation;
		this.autocompleteFromLocation=autocompleteFromLocation;
		this.autocompleteToLocation=autocompleteToLocation;
		this.dateFunction=dateFunction;
		this.minusTheCount=minusTheCount;
		this.plusTheCount=plusTheCount;
		this.validateRideForm=validateRideForm;
		var seatCount=1;
		this.bookRideNow=bookRideNow;
		this.OverlaySeatavilabilityPopupHide=OverlaySeatavilabilityPopupHide;
		this.validateFeild=validateFeild;
		this.selectcountry=selectcountry;
		//this.lastName=lastName;
		this.validateStateFeild=validateStateFeild;
		this.validateDistrictFeild=validateDistrictFeild;
		this.district=district;
		this.location=location;
		this.validateLocation=validateLocation;
		this.selectState=selectState;
		this.selectLocation=selectLocation;
		this.validateRide=validateRide;
		this.selectcountryforState=selectcountryforState;
		this.selectStateToAddDistrict=selectStateToAddDistrict;
		function selectStateToAddDistrict()
		{
			if(formDistrict.selectState.selectedIndex==0)
			{
				$("#distmessage").css("display", "block");
				$("#distmessage").text("* Please select contry!");
				$("#distmessage").css("color", "red");
				frm.sel.focus();
				return false;
			}
			else
			{
				var selectedvalue=$("#selectState").val();
				var countryName=$("#selectState :selected").text()
				
				$("#distmessage").css("display", "none");
				return true;
			}

		}
		function validateDistrictFeild()
		{
			if(district() && selectStateToAddDistrict())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	
		function selectcountryforState()
		{
			if(stateform.selectCountry.selectedIndex==0)
			{
				$("#statemessage").css("display", "block");
				$("#statemessage").text("* Please select contry!");
				$("#statemessage").css("color", "red");
				frm.sel.focus();
				return false;
			}
			else
			{
				var selectedvalue=$("#selectcountry").val();
				var countryName=$("#selectcountry :selected").text()
				
				$("#statemessage").css("display", "none");
				return true;
			}
			
		}
		function validateStateFeild()
		{
			if(lastName() && selectcountryforState())
			{
				return true
			}
			else
			{
				
				return false;
			}
			
		}
		function validateRide()
		{	
			if((autocompleteFromLocation())&&(autocompleteToLocation())&&(dateFunction()))
			{
				if(frm.sel.selectedIndex==0)
				{
					$("#onDate").css("display", "block");
					$("#onDate").text("* Please enter Time!");
					$("#onDate").css("color", "red");
					frm.sel.focus();
					return false;
				}
				else
				{
					var selectedvalue=$("#list").val();
					$("#onDate").css("display", "none");
					var userId=$("#userId").val();
					if(userId==null || userId=="" || userId==undefined || userId=="null")
					{
						loginPopUp();
						return false;
					}
				}
			}
			else
			{
				$("#onDate").css("display", "block");
				$("#onDate").text("* Please enter Time!");
				$("#onDate").css("color", "red");
				return false;
			}
	
			
		}
		function selectLocation()
		{
			if(form1.sel3.selectedIndex==0)
			{
				$("#onDate2").css("display", "block");
				$("#onDate2").text("* Please select contry!");
				$("#onDate2").css("color", "red");
				frm.sel.focus();
				return false;
			}
			else
			{
				var selectedvalue=$("#list2").val();
				var countryName=$("#list2 :selected").text();
				$("#DistrictIn").val(countryName);
				$("#onDate2").css("display", "none");
				return true;
			}

		}
		function selectState()
		{
			if(frm1.sel1.selectedIndex==0)
			{
				$("#onDate1").css("display", "block");
				$("#onDate1").text("* Please select contry!");
				$("#onDate1").css("color", "red");
				frm.sel.focus();
				return false;
			}
			else
			{
				var selectedvalue=$("#list1").val();
				var countryName=$("#list1 :selected").text();
				$("#stateIn").val(countryName);
				$("#onDate1").css("display", "none");
				return true;
			}
			
		}
		function validateLocation()
		{
			if(location())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		function location()
		{
			var district=$("#loc").val();	
			if(isEmpty(district))
			{
				$("#loc").css("border", "none");
				//$("#ON4").css("display", "none");
				return true;
			}
			else
			{
				$("#loc").css("border", "1px solid red");
				//$("#ON4").css("display", "block");
				//$("#ON4").text("* Address cant be blank!");
				//$("#ON4").css("color", "red");
				return false;
			}
		}
		function district()
		{
			var district=$("#dis").val();	
			if(isEmpty(district))
			{
				$("#dis").css("border", "none");
				//$("#ON4").css("display", "none");
				return true;
			}
			else
			{
				$("#dis").css("border", "1px solid red");
				//$("#ON4").css("display", "block");
				//$("#ON4").text("* Address cant be blank!");
				//$("#ON4").css("color", "red");
				return false;
			}
		}
		function selectcountry()
		{
			if(frm.sel.selectedIndex==0)
			{
				$("#onDate").css("display", "block");
				$("#onDate").text("* Please select contry!");
				$("#onDate").css("color", "red");
				frm.sel.focus();
				return false;
			}
			else
			{
				var selectedvalue=$("#list").val();
				var countryName=$("#list :selected").text();
				$("#countryIn").val(countryName);
				
				$("#onDate").css("display", "none");
				return true;
			}
		}
		function validateFeild()
		{
			if(firstName())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		function bookRideNow()
		{
			var avlSeat=$("#avlSeat").html();
			//$("#sectedSeatCount").val(x);//default vala
			var x=$("#countSeat").html();//span wala
			var userId=$("#userId").val();
			if(userId==null || userId=="" || userId==undefined || userId=="null")
			{
				loginPopUp();
				return false;
			}			
			
		}
		function OverlaySeatavilabilityPopupHide()
		{
			$('#OverlaySeatavilabilityPopup').hide();
			$("#RegisterContainer1").css("display","none");
			$("#hrishi1").css("display","none");
			$("#hrishi").css("display","none");
			$("#RegisterContainer").css("display","none");
		}
		function minusTheCount()
		{
			seatCount--
			var Citypath=$("#contextpath").val();
			var avlSeat=$("#avlSeat").html();
			$("#countSeat").text(seatCount);
			var x=$("#countSeat").html();
			if(x==2 && x<avlSeat)
			{
				$("#minus").show();
			}
			if(x < avlSeat && x >=1)
			{
				$("#plus").show();
				$("#minus").hide();
				
			}
			$("#sectedSeatCount").val(x);
			
			//window.location=Citypath+"/jsp/rideuserdetails.jsp?name="+encodeURIComponent(x);
		}
		function plusTheCount()
		{
			seatCount++
			var Citypath=$("#contextpath").val();
			var avlSeat=$("#avlSeat").html();
			$("#countSeat").text(seatCount);
			var x=$("#countSeat").html();
			if(x==1 && avlSeat==1)
			{
			    $("#plus").attr("disabled", true);
				
			}
			if(x==2 && x<=avlSeat)
			{
				$("#minus").show();
			}
			if(avlSeat==x && x>=avlSeat)
			{
				$("#plus").hide();
				$("#minus").show();
			}
			$("#sectedSeatCount").val(x);
		
		}
		function validateRideForm()
		{
			if((autocompleteFromLocation())&&(autocompleteToLocation())&&(dateFunction()))
			{
				if(frm.sel.selectedIndex==0)
				{
					$("#onDate").css("display", "block");
					$("#onDate").text("* Please enter Time!");
					$("#onDate").css("color", "red");
					frm.sel.focus();
					return false;
				}
				else
				{
					var selectedvalue=$("#list").val();
					$("#onDate").css("display", "none");
					return true;
				}
			}
			else
			{
				$("#onDate").css("display", "block");
				$("#onDate").text("* Please enter Time!");
				$("#onDate").css("color", "red");
				return false;
			}
			
		}
		/*//function getSelectedvalue()
		{
			
		}
		*/
		function dateFunction()
		{
			var date=$("#onDateVal").val();
			var dateRegEx=/(^(((0[1-9]|1[0-9]|2[0-8])[-](0[1-9]|1[012]))|((29|30|31)[-](0[13578]|1[02]))|((29|30)[-](0[4,6,9]|11)))[-](19|[2-9][0-9])\d\d$)|(^29[-]02[-](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)/;
			if(isEmpty(date)&& dateRegEx.test(date))
			{
				$("#onDateVal").css("border", "none");
				$("#dateId").css("display", "none");
				return true;
			}
			else
			{
				$("#onDateVal").css("border", "1px solid red");
				$("#dateId").css("display", "block");
				$("#dateId").text("* Please enter Date!");
				$("#dateId").css("color", "red");
				return false;
			}
		}
		function autocompleteToLocation()
		{
			var toLoactionVar=$("#Serching1").val();
			if (isEmpty(toLoactionVar)) 
			{
				$("#Serching1").css("border","none");
				$("#ONNN").css("display", "none");
				return true;
			}  
			else 
			{
				$("#Serching1").css("border","1px solid red");
				$("#ONNN").css("display", "block");
				$("#ONNN").text("* Please enter valid details!");
				$("#ONNN").css("color", "red");
				return false;
			}

		}
		function autocompleteFromLocation()
		{
			var fromLoactionVar=$("#Serching").val();
			if (isEmpty(fromLoactionVar)) 
			{
				$("#Serching").css("border","none");
				$("#ONN").css("display", "none");
				return true;
			}  
			else 
			{
				$("#Serching").css("border","1px solid red");
				$("#ONN").css("display", "block");
				$("#ONN").text("* Please enter valid details!");
				$("#ONN").css("color", "red");
				return false;
			}
		}
		
		function getLocation(id)
		{
			$("#Serching").val("");
			$("#fromLocation").val("");
			var str=$("#"+id).text();
			var count = id.split("_")[1];
			var av=$("#locationId_"+count).val();
			$("#Serching").val(str);
			$("#fromLocation").val(av);	
			$("#autopopup").empty();
		}
		function getToLocation(id)
		{
			$("#Serching1").val("");
			$("#tolocation").val("");
			var str=$("#"+id).text();
			var count = id.split("_")[1];
			var av=$("#tolocationId_"+count).val();
			$("#Serching1").val(str);
			$("#tolocation").val(av);	
			$("#autopopup1").empty();
		}
	//Ajax Call for autoComplete fromlocation
	function autoCompleteFunction()
	{
		var Citypath=$("#contextpath").val();
		var autoCompletVar=$("#Serching").val();
		if(autoCompletVar.length>=3)
		{
			$.post(Citypath+"/AjaxHandler/ajaxHandler.jsp",
				{
					action : "checkWordsForAutoComplete",
					searchKey:autoCompletVar
				},
				function(data)
				{
					$("#autopopup").empty();
					var JsonData=$.parseJSON(data);
				
					var serchData = JsonData;
					var abc="<div class='inputBox'>";
					for(var i=0;i<serchData.length;i++)
					{
						var xy=serchData[i];
						abc += "<span class='autoComplete' id='location_"+(i+1)+"' onclick='demo.getLocation(this.id)'>"+xy[1]+"<input type='hidden' id='locationId_"+(i+1)+"' value='"+xy[0]+"'></span><hr class='hrClass'>";
					}
					abc +="</div>";
					$("#autopopup").append(abc);
				});
		}
	}
	//Ajax Call for autoComplete tolocation
	function autoCompleteFunctionTolocation()
	{
		var Citypath=$("#contextpath").val();
		var autoCompletVar=$("#Serching1").val();
		if(autoCompletVar.length>=3)
		{
			$.post(Citypath+"/AjaxHandler/ajaxHandler.jsp",
				{
					action : "checkWordsForAutoCompleteToLocation",
					searchKey:autoCompletVar
				},
				function(data)
				{
					$("#autopopup1").empty();
					var JsonData=$.parseJSON(data);
				
					var serchData = JsonData;
					var abc="<div class='inputBox'>";
					for(var i=0;i<serchData.length;i++)
					{
						var xy=serchData[i];
						abc += "<span class='autoComplete' id='location_"+(i+1)+"' onclick='demo.getToLocation(this.id)'>"+xy[1]+"<input type='hidden' id='tolocationId_"+(i+1)+"' value='"+xy[0]+"'></span><hr class='hrClass'>";
						
					}
					abc +="</div>";
					$("#autopopup1").append(abc);
				});
		}
	}
	
		
		var regex=/^[a-zA-Z]{1,10}$/;
		var txt="";
		var count=1;
		var count1=1;
		function firstName()
		{
			
			var fName=$("#name").val();
			if (isEmpty(fName) && regex.test(fName)) 
			{
				$("#name").css("border","none");
				$("#ON").css("display", "none");
				return true;
			}  
			else 
			{
				$("#name").css("border","1px solid red");
				$("#ON").css("display", "block");
				$("#ON").text("* Please enter valid name!");
				$("#ON").css("color", "red");
				return false;
            }
		
		}
		function lastName()
		{
			var lName=$("#lname").val();
			if (isEmpty(lName) && regex.test(lName)) 
			{
				$("#lname").css("border", "none");
				$("#ON1").css("display", "none");
				return true;
			} 
			else 
			{	

				$("#lname").css("border", "1px solid red");
				$("#ON1").css("display", "block");
				$("#ON1").text("* Please enter valid name!");
				$("#ON1").css("color", "red");
				return false;
            
			}
		};
		//Checkbox validation
		function checkBoxValid()
		{
			var count=0;
			$("input:checkbox[name='Hobbies']").each(function()
			{
				if($(this).is(':checked'))
				{
					$("#ON10").css("display","none");
					count++;
					
				}
			});
				if(count<0 || count==0)
				{
					$("#ON10").css("display","block");
					$("#ON10").text("* please check atlst one Box");
					$("#ON10").css("color", "red");	
					return false;				
				}
				else
				{
					return true;
				}
			
		}
		//mobile number
		function mobNumber()
		{
			var mbNumber=$("#MbNum").val();
			var mbRegEx=/^[789]+[0-9]{9}$/;
			
			if(isEmpty(mbNumber)&& mbRegEx.test(mbNumber))
			{
				$("#MbNum").css("border", "none");
				$("#ON2").css("display", "none");
				/*var flag=demo.validateMob();
				if(flag)
					{
						return true;
						
					}
					else
					{
						return false;
					}
				*/
				var contextPath=$("#contextpath").val();
				var MbNumber=$("#MbNum").val();
				$.post(contextPath+"/AjaxHandler/ajaxHandler.jsp",
				{
					action : "checkmobNumber",
					mobile : MbNumber
					
				},
				function(data)
				{
					var JsonData=$.parseJSON(data);
					if(JsonData.statusFlag)
					{
						$("#ON2").css("display", "block");
						$("#ON2").text(JsonData.statusMessage);
						$("#ON2").css("color", "red");
						flag=false;
						
					}
					else
					{
						flag=true;
						
					}
					//return flag;
				});
				
				//return true;
			} 
			else 
			{	
				$("#MbNum").css("border", "1px solid red");
				$("#ON2").css("display", "block");
				$("#ON2").text("* please Enter valid Mobile Number");
				$("#ON2").css("color", "red");
				return false;
			}
			return flag;
		}//EmailId 
		function emailId()
		{
			var emailId=$("#emailID").val();
			var emailRegEx=/^[a-zA-Z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
			if(isEmpty(emailId)&& emailRegEx.test(emailId))
			{
				$("#emailID").css("border", "none");
				$("#ON3").css("display", "none");
				
				/*var flag=demo.validateEmail();
				if(flag)
				{
					return true;
				}
				else
				{
					return false;
				}*/
				var contextPath=$("#path").val();
				var emailvar=$("#emailID").val();
				$.post(contextPath+"/AjaxHandler/ajaxHandler.jsp",
						{
							action : "checkEmail",
							email : emailvar
						},
						function(data)
						{
							
							var JsonData=$.parseJSON(data);
							if(JsonData.statusFlag)
							{
								$("#ON3").css("display", "block");
								$("#ON3").text(JsonData.statusMessage);
								$("#ON3").css("color", "red");
								flag1 = false;
								
							}
							else
							{
								flag1=true;
								
							}
							//return flag;
						});	
					//return flag;
				//return true;
			} 
			else 
			{	
				$("#emailID").css("border", "1px solid red");
				$("#ON3").css("display", "block");
				$("#ON3").text("* Please Enter valid Email!");
				$("#ON3").css("color", "red");
				return false;
			}
			return flag1;
		}
		//Ajax call for emailId
		function validateEmail()
		{
			/*var contextPath=$("#path").val();
			var emailvar=$("#emailID").val();
			$.post(contextPath+"/AjaxHandler/ajaxHandler.jsp",
					{
						action : "checkEmail",
						email : emailvar
					},
					function(data)
					{
						
						var JsonData=$.parseJSON(data);
						if(!JsonData.statusFlag)
						{
							$("#ON3").css("display", "block");
							$("#ON3").text(JsonData.statusMessage);
							$("#ON3").css("color", "red");
							flag = false;
							
						}
						else
						{
							flag=true;
							
						}
						return flag;
					});	
				*/
		}
	
		//AJAX call for mobile*----
		function validateMob()
		{
			
			/*var contextPath=$("#contextpath").val();
			var MbNumber=$("#MbNum").val();
			$.post(contextPath+"/AjaxHandler/ajaxHandler.jsp",
			{
				action : "checkmobNumber",
				mobile : MbNumber
				
			},
			function(data)
			{
				var JsonData=$.parseJSON(data);
				if(!JsonData.statusFlag)
				{
					$("#ON2").css("display", "block");
					$("#ON2").text(JsonData.statusMessage);
					$("#ON2").css("color", "red");
					flag=false;
					
				}
				else
				{
					flag=true;
					
				}
				return flag;
			});*/
			//return flag;
		}
		
		//email
		function address()
		{
			var address=$("#Address").val();	
			if(isEmpty(address))
			{
				$("#Address").css("border", "none");
				$("#ON4").css("display", "none");
				return true;
			}
			else
			{
				$("#Address").css("border", "1px solid red");
				$("#ON4").css("display", "block");
				$("#ON4").text("* Address cant be blank!");
				$("#ON4").css("color", "red");
				return false;
			}
		}
		//address focus validation
		function date()
		{
			var date=$("#date").val();
			var dateRegEx=/(^(((0[1-9]|1[0-9]|2[0-8])[-](0[1-9]|1[012]))|((29|30|31)[-](0[13578]|1[02]))|((29|30)[-](0[4,6,9]|11)))[-](19|[2-9][0-9])\d\d$)|(^29[-]02[-](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)/;
			//var dateRegEx=/^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$/;
			if(isEmpty(date)&& dateRegEx.test(date))
			{
				$("#date").css("border", "none");
				$("#ON8").css("display", "none");
				return true;
			}
			else
			{
				$("#date").css("border", "1px solid red");
				$("#ON8").css("display", "block");
				$("#ON8").text("* Please enter Date!");
				$("#ON8").css("color", "red");
				return false;
			}
		}
		//date focus validation
		function pin()
		{
			var pin=$("#pin").val();
			var pinRegEx=/^[1-9][0-9]{5}$/
			if(isEmpty(pin)&& pinRegEx.test(pin))
			{
				$("#pin").css("border", "none");
				$("#ON5").css("display", "none");
				return true;
			} 
		else 
			{	
				$("#pin").css("border", "1px solid red");
				$("#ON5").css("display", "block");
				$("#ON5").text("* Please Enter your pin!");
				$("#ON5").css("color", "red");
				return false;
			}
		}
		//pin focus validation
		function pass()
		{
			var pass=$("#Pass").val();
			var passRegEx=/^[a-zA-Z]{3,5}?[_@]{1,2}[0-9]{2,3}$/;
			if(isEmpty(pass)&& passRegEx.test(pass))
			{
				$("#Pass").css("border", "none");
				$("#ON6").css("display", "none");
				return true;
			} 
		else 
			{	
				$("#Pass").css("border", "1px solid red");
				$("#ON6").css("display", "block");
				$("#ON6").text("* Please Enter your password!");
				$("#ON6").css("color", "red");
				return false;
			}
		}
		//ConfirmPass validation
		function confirmpass()
		{
			var pass=$("#Pass1").val();
			var passRegEx=/^[a-zA-Z]{3,5}?[_@]{1,2}[0-9]{2,3}$/;
			if(isEmpty(pass)&& passRegEx.test(pass))
			{
				$("#Pass1").css("border", "none");
				$("#ON7").css("display", "none");
				return true;
			} 
		else 
			{	
				$("#Pass1").css("border", "1px solid red");
				$("#ON7").css("display", "block");
				$("#ON7").text("* Please Enter your password!");
				$("#ON7").css("color", "red");
				return false;
			}
		}
		//Only Text Allowed for firstName
		function firstNameAlpha()
		{
			var key = event.keyCode;
			if (key > 31 && (key < 48 || key > 57)|| key==8 || key==9|| key==0)
			{
				$(".textFeild").css("border","none");
				$("#ON").css("display", "none");
				return true;
			}
			else
			{
				$("#ON").css("display", "block");
				$("#ON").text("* Enter Characters Only!").css("color","red");
				$(".textFeild").css("border","1px solid red");
				return false;
			}
		
		}
		//alphabet input only for Lastname
		function lastNameAlpha()
		{
			var key = event.keyCode;
			if (key > 31 && (key < 48 || key > 57)|| key==8 || key==9|| key==0)
			{
				$(".textFeild1").css("border","none")
				$("#ON1").css("display", "none");
				return true;
			}
			else
			{
				$("#ON1").css("display", "block");
				$("#ON1").text("* Enter Characters Only!").css("color","red");
				$(".textFeild1").css("border","1px solid red")
				return false;
			        
			}
		};
	

		//Only Number Input for phone
		function numOnly()
		{
			var key = event.keyCode;
			//this.key=key;
			if(key < 31 && (key > 48 || key < 57)|| key==8 || key==9)
			{
				$(".numfeild").css("border","none");
				$("#ON2").css("display", "none");
				return true;
                    
			}
			if (key > 31 && (key < 48 || key > 57))
			{
				$("#ON2").css("display", "block");
				$("#ON2").text("* Enter number Only!").css("color","red");
				$(".numfeild").css("border","1px solid red");
				return false;
			}
        
		}
		//Number input for pin
		function numOnlyPin()
		{
			var key = event.keyCode;
			if(key < 31 && (key > 48 || key < 57)|| key==8 || key==9)
			{
				$(".numfeild1").css("border","none");
				$("#ON5").css("display", "none");
				return true;
                    
			}
			if (key > 31 && (key < 48 || key > 57))
			{
				$("#ON5").css("display", "block");
				$(".numfeild1").css("border","1px solid red");
				$("#ON5").text("* Enter number Only!").css("color","red");
				return false;
			}
        
		}
		function popUp()
		{	count1=count1+1;
			if(count1>2){
				resetRegForm();
				$("#hrishi").css("display","block");
				$("#RegisterContainer").css("display","block");
				$('#OverlaySeatavilabilityPopup').show();
				
			}
			else{
				$("#hrishi").css("display","block");
				$("#RegisterContainer").css("display","block");
				$('#OverlaySeatavilabilityPopup').show();
			}
		
		}
		//Login Popup
		function loginPopUp()
		{
			count =count+1;
			if(count>2){
				resetLogForm();
				$("#hrishi1").css("display","block");
				$("#RegisterContainer1").css("display","block");
				$('#OverlaySeatavilabilityPopup').show();
				
			}
			else{
				$("#hrishi1").css("display","block");
				$("#RegisterContainer1").css("display","block");
				$('#OverlaySeatavilabilityPopup').show();
			
			}
	}
		//Functions for login
		function loginemailId()
		{
			var emailId1=$("#emailID1").val();
			var emailRegEx=/^[a-zA-Z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
			if(isEmpty(emailId1)&& emailRegEx.test(emailId1))
			{
				$("#emailID1").css("border", "none");
				$("#ON13").css("display", "none");
				return true;
			} 
			else 
			{	
				$("#emailID1").css("border", "1px solid red");
				$("#ON13").css("display", "block");
				$("#ON13").text("* Please Enter valid Email!");
				$("#ON13").css("color", "red");
				return false;
			}
		}
		//Password
		function loginpass()
		{
			var pass2=$("#Pass2").val();
			var passRegEx=/^[a-zA-Z]{3,5}?[_@]{1,2}[0-9]{2,3}$/;
			if(isEmpty(pass2)&& passRegEx.test(pass2))
			{
				$("#Pass2").css("border", "none");
				$("#ON14").css("display", "none");
				return true;
			} 
		else 
			{	
				$("#Pass2").css("border", "1px solid red");
				$("#ON14").css("display", "block");
				$("#ON14").text("* Please Enter your password!");
				$("#ON14").css("color", "red");
				return false;
			}
		}
	
	//common Empty function
	function isEmpty(value)
	{
		if(value!="" && value!=null && value!=undefined)
		{
			return true;
		
		}
		else
		{
			return false;
		}
	}
	//hide error/delete png
	function errorHide()
	{
		$("#RegisterContainer").css("display","none");
		//$("#Over").css("display","none");
		$('#OverlaySeatavilabilityPopup').hide();
		resetRegForm();
		resetLogForm();
	
	}
	//error png hide for Login
	function errorHideforLogin()
	{
	
		$("#RegisterContainer1").css("display","none");
		$('#OverlaySeatavilabilityPopup').hide();
		resetRegForm();
		resetLogForm();
	}
	function openRegistrationForm()//////////////////yaha pe likh do jo likhna he
	{
		resetRegForm();
		$("#hrishi").css("display","block");
		$("#RegisterContainer").css("display","block");
		$("#Over").css("display","none");
		$("#hrishi1").css("display","none");
		$("#RegisterContainer1").css("display","none");
		$('#OverlaySeatavilabilityPopup').show();
	}
	//validateRegFormLogin		
	function validateRegForm1()
	{
		
		if((loginemailId())&&(loginpass()))
		{	var id;
			$("#hrishi1").css("display","none");
			$('#OverlaySeatavilabilityPopup').show();
			$('.SeatavilabilityPopup').show();	
			bookTickits(id);
			//bookTickits();
			
			//var contextPath=$("#login").val();
			
			/*//var arrayOfSeatsValue=new array(arrayOfSeats);
			$.post(contextPath+"/Ajaxhandler/ajaxHandler.jsp",
			{
				action : "checkSeatAvailability",
				searchingKey :arrayOfSeats
				
			},
			function(data)
			{
				var JsonData=$.parseJSON(data);
				
					
			});
	*/		
				return true;
		}
		else
		{
				return false;
		}
	}
	//Function if click on register button to validate all the feilds
	function validateRegForm()
	{
		if((firstName())&&(lastName())&&(checkBoxValid())&&(mobNumber())&&(emailId())&&(address())&&(date())&&(pin()))
		{		//For Gender Values
				var gender=$("input[name='gender']:checked").val();
				//For Checkboxes
				$("input:checkbox[name='Hobbies']").each(function(){
				
					if($(this).is(':checked'))
					txt+=$(this).val();
				
				})
				
				//For Password match Validation
				var pass=$("#Pass").val();
				var pass1=$("#Pass1").val();
				if(pass==pass1)
				{
					//$("#ON7").css("display","none");
					//return false;
				}
				else
				{
					$("#pass1").css("border","1px solid red");
					$("#ON7").css("display","block");
					$("#ON7").text("* Password does not match!").css("color","red");
					
					return false;
				}
				//for City Values
				var City=$("#Select").val();
				
				
				$("#hrishi").css("display","none");
				$("#MainDisplay").show();
				$("#Span12").text("You Have SuccessFully Registered!").css("color","green");
				$("#Span").text($("#name").val());
				$("#Span1").text($("#lname").val());
				$("#Span2").text(gender);
				$("#Span3").text(txt);
				$("#Span4").text($("#MbNum").val());
				$("#Span5").text($("#emailID").val());
				$("#Span6").text($("#Address").val());
				$("#Span7").text($("#Select").val());
				$("#Span8").text($("#date").val());
				$("#Span9").text($("#pin").val());
				$("#Span10").text($("#Pass").val());
				$("#Span11").text($("#Pass1").val());
				setTimeout(function(){$("#MainDisplay").hide();$("#Over").css("display","none");}, 2000);////TimeOut 5 secs for Login after that popup will disappear;

				
					return true;
		
		}
		else
		{
			return false;
			
		}
	
	}
	//Function to clear All Errors registration form
	function resetRegForm()
	{
		$("#reset").closest('form').find("input[type=text], textarea").val("");
		$("#reset").closest('form').find("input[type=password], textarea").val("");
		$("#reset").closest('form').find("input[type=text], textarea").css("border","none");
		$("#reset").closest('form').find("input[type=password], textarea").css("border","none");
		$(".Span").hide();
	}
	//function clear All Errors login Form
	function resetLogForm()
	{
		$("#reset1").closest('form').find("input[type=text], textarea").val("");
		$("#reset1").closest('form').find("input[type=password], textarea").val("");
		$("#reset1").closest('form').find("input[type=text], textarea").css("border","none");
		$("#reset1").closest('form').find("input[type=password], textarea").css("border","none");
		$(".Span").hide();
	}
	//bodyclick blurr
	function bodyclick()
	{	
		if (!$(event.target).closest('#register').length) 
		{
			$("#Over").css("display","none");
			$('#RegisterContainer').hide();
			$('#RegisterContainer1').hide();
			resetRegForm();
			resetLogForm();
			
		}
		else 
		{
			$("#Over").css("display","block");	
			$('#RegisterContainer').show();
			$('#RegisterContainer1').show();
			 
		}
		if (!$(event.target).closest('#login').length) 
		{
			$("#over").css("display","none");
			$('#RegisterContainer').hide();
			$('#RegisterContainer1').hide();
			resetRegForm();
			resetLogForm();
			
		}
		else 
		{
				$("#Over").css("display","block");
				$('#RegisterContainer').show();
				$('#RegisterContainer1').show();
				
		}
		
	}
	function RegisterForm ()
	{

			
			event.stopPropagation();
	}
	
	
	
	
	
   
		

}//main function of class Demo ends
