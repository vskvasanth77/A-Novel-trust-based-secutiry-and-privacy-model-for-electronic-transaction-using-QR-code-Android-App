<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Bus information</title>
		<meta name="description" content="Sticky Table Headers Revisited: Creating functional and flexible sticky table headers" />
		<meta name="keywords" content="Sticky Table Headers Revisited" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	</head>
        <style>
  .button {
  display: inline-block;
  border-radius: 4px;
  background-color: #000000;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 20px;
  padding: 5px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>


	<body align="center">
             <form name="formm" action="Analysis.jsp" method="POST" >
		<div class="container">
			<!-- Top Navigation -->
			
			<header>
				<h1>Bus Timing Analysis</h1>	
                         </header>
                       
    
			
			<div class="component">
				
				<table>
					<thead>
						<tr>
							<th>Date</th>
							<th>06:00 AM - 08:59 AM</th>
							<th>09:00 AM - 11:59 AM</th>
							<th>12:00 PM - 02:59 PM</th>
							<th>03:00 PM - 05:59 PM</th>
							<th>06:00 PM - 08:59 PM</th>
                                                        <th>09:00 PM - 12:00 AM</th>
						</tr>
					</thead>
					<tbody>
                    <%
                    String d1=request.getParameter("date1");
                    System.out.println(d1);
                    //String query="SELECT * FROM infowell WHERE Dateofday BETWEEN '"+d1+"','"+d2+"'";
                    String query1="SELECT * FROM booklist WHERE currentdate='"+d1+"' and time BETWEEN '06:00' and '08:59' ";
                    String query2="SELECT * FROM booklist WHERE currentdate='"+d1+"' and time BETWEEN '09:00' and '11:59' ";
                    String query3="SELECT * FROM booklist WHERE currentdate='"+d1+"' and time BETWEEN '12:00' and '14:59' ";
                    String query4="SELECT * FROM booklist WHERE currentdate='"+d1+"' and time BETWEEN '15:00' and '17:59' ";
                    String query5="SELECT * FROM booklist WHERE currentdate='"+d1+"' and time BETWEEN '18:00' and '20:59' ";
                    String query6="SELECT * FROM booklist WHERE currentdate='"+d1+"' and time BETWEEN '21:00' and '23:59' ";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","password");
                    Statement st=con.createStatement();
                    if(d1.equals(request.getParameter("date1")))
                    {
                        int result1=0;
                        ResultSet rs1=st.executeQuery(query1);
                        while(rs1.next())
                        {
                            String amount=rs1.getString("amount");
                            System.out.println(amount);
                            int a=Integer.parseInt(amount);
                            result1 += a;
                            System.out.println("Result For 6-9: "+result1);
                        }
                        int result2=0;
                        ResultSet rs2=st.executeQuery(query2);
                        while(rs2.next())
                        {
                            String amount=rs2.getString("amount");
                            System.out.println(amount);
                            int a=Integer.parseInt(amount);
                            result2 += a;
                            System.out.println("Result For 9-12: "+result2);
                        }
                        int result3=0;
                        ResultSet rs3=st.executeQuery(query3);
                        while(rs3.next())                           
                        {
                            String amount=rs3.getString("amount");
                            System.out.println(amount);
                            int a=Integer.parseInt(amount);
                            result3 += a;
                            System.out.println("Result For 12-3: "+result3);
                        }
                        int result4=0;
                        ResultSet rs4=st.executeQuery(query4);
                        while(rs4.next())
                        {
                            String amount=rs4.getString("amount");
                            System.out.println(amount);
                            int a=Integer.parseInt(amount);
                            result4 += a;
                            System.out.println("Result For 3-6: "+result4);
                        }
                        int result5=0;
                        ResultSet rs5=st.executeQuery(query5);
                        while(rs5.next())
                        {
                            String amount=rs5.getString("amount");
                            System.out.println(amount);
                            int a=Integer.parseInt(amount);
                            result5 += a;
                            System.out.println("Result For 6-9: "+result5);
                        }
                        int result6=0;
                        ResultSet rs6=st.executeQuery(query6);
                        while(rs6.next())
                        {
                            String amount=rs6.getString("amount");
                            System.out.println(amount);
                            int a=Integer.parseInt(amount);
                            result6 += a;
                            System.out.println("Result For 9-12: "+result6);
                        }
                    %>
                    <tr>
                        <td><%=d1%></td>
                        <td><%=result1%></td>
                        <td><%=result2%></td>
                        <td><%=result3%></td>
                        <td><%=result4%></td>
                        <td><%=result5%></td>
                        <td><%=result6%></td>
                    </tr>
                    <%
                        if(result1>100)
                        {
                            %><h1>06:00 AM - 08:59 AM -- Arrange another Bus for This timing</h1><%
                            System.out.println("Arrange Another Bus to This Timing");
                        }
                        else
                        {
                            %><h1>06:00 AM - 08:59 AM -- No Need to Arrange Bus for This timing</h1><%
                            System.out.println("No Need for Arrange Bus");
                        }
                        if(result2>100)
                        {
                            %><h1>09:00 AM - 11:59 AM -- Arrange another Bus for This timing</h1><%
                            System.out.println("Arrange Another Bus to This Timing");
                        }
                        else
                        {
                            %><h1>09:00 AM - 11:59 AM -- No Need to Arrange Bus for This timing</h1><%
                            System.out.println("No Need for Arrange Bus");
                        }
                        if(result3>100)
                        {
                            %><h1>12:00 PM - 02:59 PM -- Arrange another Bus for This timing</h1><%
                            System.out.println("Arrange Another Bus to This Timing");
                        }
                        else
                        {
                            %><h1>12:00 PM - 02:59 PM -- No Need to Arrange Bus for This timing</h1><%
                            System.out.println("No Need for Arrange Bus");
                        }
                        if(result4>100)
                        {
                            %><h1>03:00 PM - 05:59 PM -- Arrange another Bus for This timing</h1><%
                            System.out.println("Arrange Another Bus to This Timing");
                        }
                        else
                        {
                            %><h1>03:00 PM - 05:59 PM -- No Need to Arrange Bus for This timing</h1><%
                            System.out.println("No Need for Arrange Bus");
                        }
                        if(result5>100)
                        {
                            %><h1>06:00 PM - 08:59 PM -- Arrange another Bus for This timing</h1><%
                            System.out.println("Arrange Another Bus to This Timing");
                        }
                        else
                        {
                            %><h1>06:00 PM - 08:59 PM -- No Need to Arrange Bus for This timing</h1><%
                            System.out.println("No Need for Arrange Bus");
                        }
                        if(result6>100)
                        {
                            %><h1>09:00 PM - 12:00 AM -- Arrange another Bus for This timing</h1><%
                            System.out.println("Arrange Another Bus to This Timing");
                        }
                        else
                        {
                            %><h1>09:00 PM - 12:00 AM -- No Need to Arrange Bus for This timing</h1><%
                            System.out.println("No Need for Arrange Bus");
                        }
                    }
                    
                    %>
                </tbody>
				</table>
                    <%
                        
                    %>
                        </div>
            
                
		  		
		</div><!-- /container -->
                
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js"></script>
		<script src="js/jquery.stickyheader.js"></script>
            </form>      
	</body>
</html>