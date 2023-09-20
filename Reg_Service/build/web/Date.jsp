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
<script>
    function one()
    {
        var a1=document.formm.date1.value;
        
        if(a1=="")
        {
            alert("First Select Date");
            return false;
        }
        return true;
    }
</script>

	<body align="center">
             <form name="formm" action="Date.jsp" method="POST" onsubmit="return one()">
		<div class="container">
			<!-- Top Navigation -->
			
			<header>
				<h1>Date Wise Information</h1>	
                         </header>
                       
    <nav class="codrops-demos">
        <a>Date: <input type="date" name="date1" value=""/></a>&nbsp;&nbsp;&nbsp;&nbsp;<br><br>
        <button class="button" type="submit" name="search" style="vertical-align:middle"><span>Search </span></button>
        <button class="button" type="submit" name="analysis" style="vertical-align:middle" onclick="form.action='Analysis.jsp';"><span>Analysis </span></button>
        
    </nav>
			
			<div class="component">
				
				<table>
					<thead>
						<tr>
							<th>Username</th>
							<th>Bus Number</th>
							<th>From</th>
							<th>To</th>
							<th>Time</th>
							<th>Amount</th>
						</tr>
					</thead>
					<tbody>
                    <%
                    String d1=request.getParameter("date1");
                    //String query="SELECT * FROM infowell WHERE Dateofday BETWEEN '"+d1+"','"+d2+"'";
                    String query="SELECT * FROM booklist WHERE currentdate='"+d1+"' ";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","password");
                    Statement st=con.createStatement();
                    ResultSet rs1=st.executeQuery(query);
                    while(rs1.next())
                     //ArrayList li=new ArrayList();
                    //ResultSet rs1=Common_DB.ViewParticularData("petrol", "infowell", "Dateofday", d1); 
                    //int rs1=Common_DB.FreeQuery("petrol", "SELECT * FROM 'infowell' WHERE Dateofday BETWEEN '"+d1+"' and '"+d2+"'");
                    //while(rs1.next())
                    //if(rs1>0)
                    
                                                 {
                    %>
                    <tr>
                        <td><%=rs1.getString("username") %></td>
                        <td><%=rs1.getString("busnumber") %></td>
                        <td><%=rs1.getString("fromst") %></td>
                        <td><%=rs1.getString("tost") %></td>
                        <td><%=rs1.getString("time") %></td>
                        <td><%=rs1.getString("amount") %></td>
                    </tr>
                    <%
                                       }
                     %>
                </tbody>
				</table>
                        </div>
            
                
		  		
		</div><!-- /container -->
                
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js"></script>
		<script src="js/jquery.stickyheader.js"></script>
            </form>      
	</body>
</html>