<%-- 
    Document   : index
    Created on : 1 Mar, 2018, 1:33:16 AM
    Author     : Anbuu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body align="center">
        <h1>Bus Ticket System</h1>
        <form name="f1" action="Login" method="POST">
            <table border="0" align="center">
               
                <tbody>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Submit" name="b1" />
        </form>
    </body>
</html>
