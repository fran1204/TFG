<%-- 
PANTALLA PRINCIPAL CUANDO EL USUARIO ESTÁ REGISTRADO
    Document   : principal2
    Created on : 23-abr-2016, 16:59:49
    Author     : cayetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="img/favicon.ico">

        <title>Principal</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/dashboard.css" rel="stylesheet">
        

    </head>

    <body>

        <%@ include file="nav2.jsp" %>


        <div class="container-fluid">
            <div class="col-md-offset-1">

                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">Deportes</h1>
                    </div>
                </div>
                <div class="row placeholders">
                    <s:url var="futbol" namespace="/" action="buscarEvento">
                        <s:param name="filtro_deporte">Futbol</s:param>
                    </s:url>
                    <s:url var="baloncesto" namespace="/" action="buscarEvento">
                        <s:param name="filtro_deporte">Baloncesto</s:param>
                    </s:url>
                    <s:url var="padel" namespace="/" action="buscarEvento">
                        <s:param name="filtro_deporte">Deporte</s:param>
                    </s:url>
                    <s:url var="tenis" namespace="/" action="buscarEvento">
                        <s:param name="filtro_deporte">Tenis</s:param>
                    </s:url>
                    <div class="col-xs-6 col-md-3 placeholder">
                        <s:a href="%{futbol}"><img src="img/futbol.jpg" width="200" height="200" class="img-responsive" alt="futbol"></s:a>
                            <h4>Fútbol</h4>
                            <span class="text-muted">Eventos sobre fútbol</span>
                        </div>
                        <div class="col-xs-6 col-md-3 placeholder">
                        <s:a href="%{baloncesto}"><img src="img/baloncesto.jpg" width="200" height="200" class="img-responsive" alt="baloncesto"></s:a>
                            <h4>Baloncesto</h4>
                            <span class="text-muted">Eventos sobre baloncesto</span>
                        </div>
                        <div class="col-xs-6 col-md-3 placeholder">
                        <s:a href="%{padel}"><img src="img/padel.jpg" width="200" height="200" class="img-responsive" alt="padel"></s:a>
                            <h4>Padel</h4>
                            <span class="text-muted">Eventos sobre padel</span>
                        </div>
                        <div class="col-xs-6 col-md-3 placeholder">
                        <s:a href="%{tenis}"><img src="img/tenis.jpg" width="200" height="200" class="img-responsive" alt="tenis"></s:a>
                            <h4>Tenis</h4>
                            <span class="text-muted">Eventos sobre tenis</span>
                        </div>
                    </div>  
                    <div class="row">
                        <div class="col-md-12">
                            <h2 class="sub-header">Últimos eventos</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Fecha Inicio</th>
                                            <th>Fecha Fin</th>
                                            <th>Deporte</th>
                                            <th>Ciudad</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <s:iterator value="eventos">
                                        <tr>
                                            <td><s:property value="nombre"/></td>
                                            <td><s:property value="fechaInicio"/></td>
                                            <td><s:property value="fechaFin"/></td>
                                            <td><s:property value="%{deporte.nombre}"/></td>
                                            <td><s:property value="%{ciudad.nombre}"/></td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>


            </div>
        </div>


        <!-- ==========================================JAVASCRIPT======================================== -->  

    </body>
</html>
