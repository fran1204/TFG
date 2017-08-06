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

        <title>Perfil</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/dashboard.css" rel="stylesheet">
        <%@ include file="javascript.html" %>
    </head>
    <body>
        <%@ include file="nav2.jsp" %>


        <div class="container-fluid">
            <div class="col-lg-offset-1" >

                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">Actualizar Lote</h1>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <img src="img/<s:property value="%{lote.photo}"/>" class="img-thumbnail" alt="foto perfil"/>
                        <center>
                            <s:form method="POST" enctype="multipart/form-data" action="updateFotoLote"><s:hidden name="nombre_foto" value="%{lote.photo}"/><label class="btn btn-default btn-file"><span class="glyphicon glyphicon-pencil"/><s:file name="fileUpload" cssStyle="display:none" onchange="this.form.submit();"/></label></s:form>
                            <s:form method="POST" action="deleteFotoLote"><button class="btn btn-default"><s:hidden name="nombre_foto" value="%{lote.photo}"/><span class="glyphicon glyphicon-trash"/></button></s:form>
                            </center>
                        </div>

                        <div class="col-md-5">
                        <s:form cssClass="form-signin col-lg-offset-2" cssStyle="display: inline-block" action="updateLote">
                            <s:label value="Titulo"/><s:textfield cssClass="form-control" name="title" value="%{lote.title}"/>
                            <s:label value="Descripcion"/><s:textfield cssClass="form-control" name="desciption" value="%{lote.desciption}"/>
                            <s:select name="category" cssClass="form-control" list="category" listKey="id" listValue="type"/>
                            <s:label value="Cantidad del lote"/><s:textfield cssClass="form-control" name="numSet" value="%{lote.numSet}"/>
                            <s:label value="Precio por unidad"/><s:textfield cssClass="form-control" name="price" value="%{lote.price}"/>
                            <s:label value="Fecha de expiración"/><s:textfield cssClass="form-control" name="expiryDate" value="%{lote.expiryDate}"/>
                        </div>
                        <div class="col-md-4">
                            <s:hidden name="loteId" value="%{lote.id}"/>
                            <s:submit cssClass="btn btn-primary" value="Actualizar" />
                        </s:form>
                        <s:form>
                            <s:hidden name="loteId" value="%{lote.id}"/>
                            <s:submit cssClass="btn btn-primary" cssStyle="background-color: rgba(220, 38, 7, 0.94);border-color: rgba(220, 38, 7, 0.94);" value="Eliminar" action="eliminarLote"/>
                        </s:form>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
