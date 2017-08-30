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
        <s:if test="%{#session.id != null && #session.id != '' }">
            <%@ include file="nav2.jsp" %>
        </s:if>
        <s:else>
            <%@ include file="nav1.jsp" %>
        </s:else>

        <div class="container-fluid">
            <div class="col-lg-offset-1" >

                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">Detalle del pedido <s:property value="%{io.order.lot.title}"  /></h1>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <img src="img/<s:property value="%{io.order.lot.photo}"/>" class="img-thumbnail" alt="foto perfil"/>
                    </div>

                    <div class="col-md-5">
                        <p><s:label value="Titulo "/> <s:property value="%{io.order.lot.title}"/></p>
                        <p><s:label value="Descripcion "/> <s:property value="%{io.order.lot.description}"/></p>
                        <p><s:label value="Estado del Pedido "/> <s:property value="%{io.order.stateOrder}"/>
                        <p><s:label value="Cantidad pedida "/> <s:property value="%{io.amount}"/></p>
                        <p><s:label value="Precio por unidad " /> <s:property value="%{io.order.lot.price}"/>€</p>
                        <p><s:label value="Cantidad Pagada "/> <s:property value="%{io.paidTotal}"/>€</p>
                        <p><s:label value="Fecha de expiración "/> <s:property value="%{io.order.lot.expiryDate}"/></p>
                        <p><s:label value="Color pedido "/> <s:property value="%{io.lotDetail.color}"/></p>
                        <p><s:label value="Talla pedida "/> <s:property value="%{io.lotDetail.size}"/></p>
                        <s:if test="%{io.lotDetail.capacity != 0}">
                            <p><s:label value="Capacidad "/> <s:property value="%{io.lotDetail.capacity}"/></p>
                        </s:if>
                        <s:if test="%{pdf != null}">
                            <p><s:label value="PDF Compra "/> <a href="pdf/<s:property value="%{pdf}" />">PDF</a></p>
                        </s:if>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
