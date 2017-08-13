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
        <%@ include file="javascript.html" %>
    </head>
    <body>
        <%@ include file="nav2.jsp" %>
        <h1>Mis Lotes</h1>

        <table class="table">
            <tbody>
                <s:iterator value="lotes"> 
                    <s:url var="actualizar" namespace="/" action="getLoteUpdate" >
                        <s:param name="id" value="%{id}"/>
                    </s:url>
                    <s:url var="borrar" namespace="/" action="eliminarLote" >
                        <s:param name="id" value="%{id}"/>
                    </s:url>
                    <s:url var="crearDetail" value="crearDetailLote.jsp" >
                        <s:param name="idLote" value="%{id}"/>
                    </s:url>
                    <tr>
                        <th><s:property value='title'/></th>
                        <td><s:a href="%{actualizar}">Actualizar</s:a></td>                
                        <td><s:a href="%{borrar}">Eliminar</s:a></td>        
                        <td><s:a href="%{crearDetail}">Añadir Oferta</s:a></td>        
                        </tr>
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>
