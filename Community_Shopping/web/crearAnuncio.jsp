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

        <title>Crear Anuncio</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/signin.css" rel="stylesheet">
        <link href="bootstrap/css/dashboard.css" rel="stylesheet">

        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>

        <%@ include file="javascript.html" %>

    </head>

    <body>
        <%@ include file="nav2.jsp" %>
        <s:form cssClass="form-signin" action="addAnuncio" method="POST" enctype="multipart/form-data">
            <h2 class="form-signin-heading">Crear Anuncio </h2>
            <s:file  name="fileUpload"/>
            <s:textfield cssClass="form-control" name="url"/>
            <s:select name="category" cssClass="form-control" list="category" listKey="id" listValue="type"/>
            <select name="duration" class="form-control">
                <option value="1">1 Mes - 30€</option>
                <option value="3">3 Meses - 75€</option>
            </select>
            <s:submit cssClass="btn btn-lg btn-primary btn-bloc" value="Crear"/>
        </s:form>

        <!-- ==========================================JAVASCRIPT======================================== -->              

    </body>
</html>

