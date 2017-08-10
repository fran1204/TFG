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

        <title>Crear Lote</title>

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
        <s:form cssClass="form-signin" action="addLote">
            <h2 class="form-signin-heading">Crear Lote </h2>
            <span style="color:red"><s:property value="fechaErronea"/></span>
            <s:fielderror/>
            <s:textfield cssClass="form-control" name="title"/>
            <s:textfield cssClass="form-control" name="desciption"/>
            <s:file name="photo" multiple="multiple"/>
            <s:textfield cssClass="form-control" name="numSet"/>
            <s:textfield cssClass="form-control" name="price"/>
            <s:select name="category" cssClass="form-control" list="category" listKey="id" listValue="type"/>
            <s:textfield cssClass="form-control" name="expiryDate" size="10" />
            <s:submit cssClass="btn btn-lg btn-primary btn-bloc" value="Crear"/>
        </s:form>

        <!-- ==========================================JAVASCRIPT======================================== -->              
        <script>
            $(document).ready(function () {
                $("#addLote_title").attr("placeholder", "Titulo");
                $("#addLote_title").attr("autofocus", "");
                $("#addLote_desciption").attr("placeholder", "Descripción");
                $("#addLote_numSet").attr("placeholder", "Cantidad del lote");
                $("#addLote_price").attr("placeholder", "Precio unidad");
                $("#addLote_category").attr("placeholder", "Categoria del producto");
                $("#addLote_expiryDate").attr("placeholder", "Fecha final de venta (aaaa-mm-dd)");
                $("#addLote_expiryDate").datepicker({
                    dateFormat: 'yy-mm-dd'
                });
            });

        </script>

    </body>
</html>

