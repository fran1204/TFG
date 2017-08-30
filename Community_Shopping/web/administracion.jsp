<%-- 
    Document   : administracion
    Created on : 30-ago-2017, 11:57:59
    Author     : fran
--%>

<!-- Landing principal de la APP -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
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
        <%@ include file="navAdmin.jsp" %>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <h1 class="page-header text-center">¡Bienvenido Admin!</h1>
                    </div>
                    <div class="col-md-3"></div>
                </div>

                <div class="row placeholders">
                    <div class="col-md-5 center-block placeholder">
                    <s:a href="%{usuarios}"><img src="img/user.jpg" width="300" height="300" class="img-responsive" alt="crear lote"></s:a>
                        <h4>Ver Usuarios</h4>
                    </div>

                    <div class="col-md-5 center-block placeholder">
                    <s:a href="%{lotess}"><img src="img/lotes.jpg" width="355" height="355" class="img-responsive" alt="crear anuncio"></s:a>
                        <h4>Ver Lotes</h4>
                    </div>

                    <div class="col-md-5 center-block placeholder">
                    <s:a href="%{pedidos}"><img src="img/crearLote.jpg" width="300" height="300" class="img-responsive" alt="crear anuncio"></s:a>
                        <h4>Ver Pedidos</h4>
                    </div>

                    <div class="col-md-5 center-block placeholder">
                    <s:a href="%{anun}"><img src="img/crearAnuncio2.png" width="300" height="300" class="img-responsive" alt="crear anuncio"></s:a>
                    <h4>Ver Anuncios</h4>
                    
                </div>
            </div> 
        </div>
    </body>
</html>
