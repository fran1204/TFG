<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="img/favicon.ico">

        <title>Crear Oferta</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/signin.css" rel="stylesheet">
        <link href="bootstrap/css/dashboard.css" rel="stylesheet">

        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>

        <%@ include file="javascript.html" %>
        <link href="jquery-calendar/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <script src="jquery-calendar/jquery-ui.min.js" type="text/javascript"></script>

    </head>

    <body>
        <%@ include file="nav2.jsp" %>
        <h2 class="form-signin-heading">Crear Oferta para el Lote <s:property value="title" /></h2>
        <s:form cssClass="form-signin" method="POST" enctype="multipart/form-data" action="addDetail" >

            <span style="color:red"><s:property value="formatoErroneo"/></span>
            <s:fielderror/>
            <s:if test="%{lote.id!=null && lote.id!=''}">
                <s:hidden cssClass="form-control" name="idLote" value="%{lote.id}"/>
            </s:if>
            <s:elseif test="%{#parameters.idLote!=null && #parameters.idLote!=''}">
                <s:hidden cssClass="form-control" name="idLote" value="%{#parameters.idLote}"/>
            </s:elseif>
            <s:textfield cssClass="form-control" name="titleDetail"/>
            <s:textfield cssClass="form-control" name="quantity"/>
            <s:textfield cssClass="form-control" name="color"/>
            <s:textfield cssClass="form-control" name="size"/>
            <s:textfield cssClass="form-control" name="capacity" size="10" />
            <s:label>Imagen 1</s:label><s:file label="Imagen 1" name="fileUpload"/>
            <s:label>Imagen 2</s:label><s:file label="Imagen 2" name="fileUpload"/>
            <s:label>Imagen 3</s:label><s:file label="Imagen 3" name="fileUpload"/>
            <s:submit cssClass="btn btn-lg btn-primary btn-bloc" value="Crear"/>
        </s:form>

        <!-- ==========================================JAVASCRIPT======================================== -->              
        <script>
            $(document).ready(function () {
                $("#addDetail_titleDetail").attr("placeholder", "Titulo");
                $("#addDetail_titleDetail").attr("autofocus", "");
                $("#addDetail_quantity").attr("placeholder", "Cantidad de la oferta");
                $("#addDetail_color").attr("placeholder", "Color");
                $("#addDetail_size").attr("placeholder", "Talla");
                $("#addDetail_capacity").attr("placeholder", "Capacidad");
            });

        </script>

    </body>
</html>