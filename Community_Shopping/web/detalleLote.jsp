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
                        <h1 class="page-header">Detalle del lote <s:property value="%{lot.title}"  /></h1>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <img src="img/<s:property value="%{lote.photo}"/>" class="img-thumbnail" alt="foto perfil"/>
                    </div>

                    <div class="col-md-5">
                        <s:label value="Titulo"/><s:label cssClass="form-control" name="title" value="%{lote.title}"/>
                        <s:label value="Descripcion"/><s:label cssClass="form-control" name="desciption" value="%{lote.desciption}"/>
                        <s:label value="Categoria"/><s:label cssClass="form-control" name="category" value="%{category}"/>
                        <s:label value="Cantidad del lote"/><s:label cssClass="form-control" name="numSet" value="%{lote.numSet}"/>
                        <s:label value="Precio por unidad"/><s:label cssClass="form-control" name="price" value="%{lote.price}"/>
                        <s:label value="Fecha de expiración"/><s:label cssClass="form-control" name="expiryDate" value="%{lote.expiryDate}"/>
                    </div>
                    
                    <div class="col-md-5">
                        <h2>Ofertas</h2>
                        <s:iterator value="details">
                            <s:if test="%{publish==true}">
                                <s:label value="Titulo"/><s:label cssClass="form-control" name="titleDetail" value="%{title}"/>
                                <s:label value="Cantidad"/><s:label cssClass="form-control" name="quantityDetail" value="%{quantity}"/>
                                <s:label value="Color"/><s:label cssClass="form-control" name="colorDetail" value="%{color}"/>
                                <s:label value="Tamaño"/><s:label cssClass="form-control" name="sizeDetail" value="%{size}"/>
                                <s:label value="Capacidad"/><s:label cssClass="form-control" name="capacityDetail" value="%{capacity}"/>
                            </s:if>
                        </s:iterator>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
