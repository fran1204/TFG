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
        <%@ include file="javascript.html" %>
    </head>

    <body>

        <%@ include file="nav2.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <h1 class="page-header text-center">¡Bienvenido @USER!</h1>
                </div>
                <div class="col-md-3"></div>
            </div>

            <div class="row placeholders">
                <s:url var="lote" namespace="/" action="crearLote">
                </s:url>
                <s:url var="anunc" namespace="/" action="crearAnuncio">
                </s:url>
              
                <div class="col-md-5 center-block placeholder">
                    <s:a href="%{lote}"><img src="img/crearLote.jpg" width="300" height="300" class="img-responsive" alt="crear lote"></s:a>
                    <h4>Crear lote</h4>
                    
                </div>
                <div class="col-md-5 center-block placeholder">
                    <s:a href="%{anunc}"><img src="img/crearAnuncio2.png" width="300" height="300" class="img-responsive" alt="crear anuncio"></s:a>
                    <h4>Crear anuncio</h4>
                </div>
            </div> 
        </div>
    </body>
</html>
