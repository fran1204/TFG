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
        <h1>Mis Anuncios</h1>


        <div class="row">
            <s:iterator value="anuncios"> 
                <div class="col-sm-6 col-md-4">
                    <s:url var="actualizar" namespace="/" action="actualizarAnuncio" >
                        <s:param name="id" value="%{id}"/>
                    </s:url>
                    <s:url var="borrar" namespace="/" action="eliminarAnuncio" >
                        <s:param name="id" value="%{id}"/>
                    </s:url>
                    <div class="thumbnail">
                        <img src="img/<s:property value='image'/>" alt="" title="">
                        <div class="caption">
                            <p>URl: <s:property value='url'/></p>
                            <p>
                                <s:a href="%{actualizar}" cssClass="btn btn-primary" role="button">Actualizar</s:a>
                                <s:a href="%{borrar}" cssClass="btn btn-default" role="button">Eliminar</s:a>
                                </p>
                            </div>
                        </div>
                    </div>
            </s:iterator>
        </div>
    </body>
</html>
