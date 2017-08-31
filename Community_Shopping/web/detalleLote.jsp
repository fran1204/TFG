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
        <link href="bootstrap/css/styleGaleri.css" rel="stylesheet">
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
                    <div class="col-md-5">
                        <div id="panel">
                            <img id="largeImage" src="img/<s:property value="%{lote.photo}"/>" height="400em" width="400em" />
                        </div>
                        <div id="thumbs">
                            <s:iterator value="gallery">
                                <img src="img/<s:property value="%{url}"/>" alt="5th image description" height="95em" width="95em"/>
                            </s:iterator>
                            <img  src="img/<s:property value="%{lote.photo}"/>" height="95em" width="95em" />
                        </div>
                    </div>

                    <div class="col-md-5">
                        <s:label value="Titulo"/><s:label cssClass="form-control" name="title" value="%{lote.title}"/>
                        <s:label value="Descripcion"/><s:label cssClass="form-control" name="description" value="%{lote.description}"/>
                        <s:label value="Categoria"/><s:label cssClass="form-control" name="category" value="%{category}"/>
                        <s:label value="Cantidad del lote"/><s:label cssClass="form-control" name="numSet" value="%{lote.numSet}"/>
                        <s:label value="Precio por unidad"/><s:label cssClass="form-control" name="price" value="%{lote.price}"/>
                        <s:label value="Fecha de expiración"/><s:label cssClass="form-control" name="expiryDate" value="%{lote.expiryDate}"/>
                    </div>
                    <div>


                    </div>
                    <div class="col-md-12">
                        <h2>Ofertas</h2>
                        <table class="table">
                            <tr>
                                <th>Título</th>
                                <th>Cant. disponible</th>
                                <th>Color</th>
                                <th>Tamaño</th>
                                <th>Capacidad</th>
                                <th>Cant. Pedida</th>
                                <th></th>
                            </tr>
                            <s:iterator value="details">
                                <s:url var="adherirse" namespace="/" action="AdherirseOferta" >
                                    <s:param name="idDetail" value="%{id}"/>
                                    <s:param name="idLot" value="%{lot.id}"/>
                                </s:url>
                                <s:if test="%{publish==true}">
                                    <tr>
                                        <td><s:property value="%{title}"/></td>
                                        <td><s:property  value="%{quantityAvailable}"/></td>
                                        <td><s:property value="%{color}"/></td>
                                        <td><s:property value="%{size}"/></td>
                                        <td><s:property value="%{capacity}"/></td>
                                        <s:set var="breakloop" value="%{false}"/>
                                        <s:set var="idetail" value="%{id}"/>
                                        <s:set var="idlot" value="%{lot.id}"/>
                                        <s:iterator value="io">
                                            <s:if test="%{#idetail == lotDetail.id}">
                                                <s:url var="verPedido" namespace="/" action="verPedido" >
                                                    <s:param name="id" value="%{id}"/>
                                                </s:url>
                                                <td><s:property value="%{amount}"/></td>
                                                <td><s:a href="%{verPedido}">
                                                        Pedido!
                                                    </s:a></td>
                                                    <s:set var="breakloop" value="%{true}"/>
                                                </s:if>
                                            </s:iterator>
                                            <s:if test="!#breakloop">
                                                <s:if test="%{#session.id != null && #session.id != ''}">
                                                    <s:form action="AdherirseOferta">
                                                    <td><s:textfield name="amount" size="3" /></td>
                                                    <s:hidden name="idDetail" value="%{#idetail}"/>
                                                    <s:hidden name="idLot" value="%{#idlot}"/>
                                                    <td><s:submit value="Lo quiero!"/></td>
                                                </s:form>
                                            </s:if>
                                            <s:else>
                                                <td></td>
                                                <td><s:a href="login.jsp">
                                                        Lo quiero!
                                                    </s:a></td>
                                                </s:else>
                                            </s:if>
                                    </tr>
                                </s:if>
                            </s:iterator>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $('#thumbs').delegate('img', 'click', function () {
                    $('#largeImage').attr('src', $(this).attr('src').replace('thumb', 'large'));
                });
            });
        </script>
    </body>
</html>
