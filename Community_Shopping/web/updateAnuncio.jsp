<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <style>form{display:inline-block;}</style>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="img/favicon.ico">

        <title>Actualizar Anuncio</title>

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


        <div class="container-fluid">
            <div class="col-lg-offset-1" >

                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">Actualizar Anuncio</h1>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <img src="img/<s:property value="%{ad.image}"/>" class="img-thumbnail" alt="foto anuncio"/>
                        <center>
                            <s:form method="POST" enctype="multipart/form-data" action="updateFotoAnuncio"><s:hidden name="nombre_foto" value="%{ad.image}"/><s:hidden name="idAnuncio" value="%{ad.id}"/><label class="btn btn-default btn-file"><span class="glyphicon glyphicon-pencil"/><s:file name="fileUpload" cssStyle="display:none" onchange="this.form.submit();"/></label></s:form>
                            <s:form method="POST" action="deleteFotoAnuncio"><button class="btn btn-default"><s:hidden name="nombre_foto" value="%{ad.image}"/><span class="glyphicon glyphicon-trash"/></button></s:form>
                            </center>
                        </div>

                        <div class="col-md-5">
                        <s:form cssClass="form-signin col-lg-offset-2" cssStyle="display: inline-block" action="updateAnuncio">
                            <s:label value="Url"/><s:textfield cssClass="form-control" name="url" value="%{ad.url}"/>
                            <s:select name="category" cssClass="form-control" list="categoris" listKey="id" listValue="type"/>
                        </div>
                        <div class="col-md-4">
                            <s:hidden name="anuncioId" value="%{ad.id}"/>
                            <s:submit cssClass="btn btn-primary" value="Actualizar" />
                        </s:form>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
