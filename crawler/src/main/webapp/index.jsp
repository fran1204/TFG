<%-- 
    Document   : index
    Created on : 27-ago-2017, 19:45:57
    Author     : fran
--%>

<%@page import="com.mycompany.mavenproject2.SoloStockCrawler"%>
<%@page import="java.util.Timer"%>
<%@page import="com.mycompany.mavenproject2.MerkandiCrawler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            //SoloStockCrawler s = new SoloStockCrawler();
            MerkandiCrawler m = new MerkandiCrawler();
            //n.retrieveAdvices();
            Timer timer = new Timer();
            //timer.schedule(s, 0, 86400000);//cada día
            timer.schedule(m, 0, 86400000);//cada día
        %>
    </body>
</html>
