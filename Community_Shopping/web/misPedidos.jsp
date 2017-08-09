<%-- 
    Document   : misLotes
    Created on : 05-ago-2017, 17:02:50
    Author     : fran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/dashboard.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <%@ include file="javascript.html" %>
    </head>
    <body>
        <%@ include file="nav2.jsp" %>
        <h1>Mis Pedidos</h1>
        <s:if test="%{message!='' && message !=null}">
            <div class="alert alert-success fade in">
                <s:property value="%{message}"/>
            </div>
        </s:if>
        <table class="table">
            <tbody>
                <s:iterator value="orderDetail"> 
                    <s:url var="ver" namespace="/" action="verPedido" >
                        <s:param name="id" value="%{id}"/>
                    </s:url>
                    <s:url var="borrar" namespace="/" action="eliminarPedido" >
                        <s:param name="id" value="%{id}"/>
                    </s:url>
                    <tr>
                        <th><s:property value='%{order.lot.title}'/></th>
                        <td><s:a href="%{ver}">Ver</s:a></td>                
                        <td><s:a href="%{borrar}">Eliminar</s:a></td>        
                        </tr>
                </s:iterator>
            </tbody>
        </table>
        <script>
            $('.alert').fadeOut(3000, "linear");
        </script>
    </body>
</html>
