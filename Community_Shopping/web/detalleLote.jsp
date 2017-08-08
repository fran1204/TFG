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
                    <div>


                    </div>
                    <div class="col-md-5">
                        <h2>Ofertas</h2>
                        <table class="table">
                            <tr>
                                <th>Título</th>
                                <th>Cant. Lote</th>
                                <th>Color</th>
                                <th>Tamaño</th>
                                <th>Capacidad</th>
                                <th>ME LO PIDO</th>
                            </tr>
                            <s:iterator value="details">
                                <s:url var="adherirse" namespace="/" action="AdherirseOferta" >
                                    <s:param name="idDetail" value="%{id}"/>
                                    <s:param name="idLot" value="%{lot.id}"/>
                                </s:url>
                                <s:if test="%{publish==true}">
                                    <tr>
                                        <td><s:property value="%{title}"/></td>
                                        <td><s:property  value="%{quantity}"/></td>
                                        <td><s:property value="%{color}"/></td>
                                        <td><s:property value="%{size}"/></td>
                                        <td><s:property value="%{capacity}"/></td>
                                        <s:if test="%{#session.id != null && #session.id != '' }">
                                            <td><s:a href="%{adherirse}">
                                                    Lo quiero!
                                                </s:a></td>
                                            </s:if>
                                            <s:else>
                                            <td><s:a href="login.jsp">
                                                    Lo quiero!
                                                </s:a></td>
                                            </s:else>
                                    </tr>
                                </s:if>
                            </s:iterator>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
