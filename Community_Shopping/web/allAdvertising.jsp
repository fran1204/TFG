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
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
        <%@ include file="javascript.html" %>
        <link href="jquery-calendar/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <script src="jquery-calendar/jquery-ui.min.js" type="text/javascript"></script>
    </head>
    <body>
        <%@ include file="navAdmin.jsp" %>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <h1 class="page-header text-center">Todos los Anuncios</h1>
                    </div>
                    <div class="col-md-3"></div>
                </div>

                <div class="row">
                    <table class="table">
                        <tr>
                            <th>Proveedor</th>
                            <th>Categoria</th>
                            <th>Url</th>
                            <th>Duración</th>
                            <th>Total</th>
                            <th>Pagado</th>
                            <th>Fecha del cobro</th>
                            <th>Fecha de alta</th>
                            <th>Orden Pago</th>
                            <th></th>
                        </tr>
                    <s:iterator value="anuncios">
                        <tr>
                            <td><s:property value="user.name" /></td>
                            <td><s:property value="category.type" /></td>
                            <td><s:property value="url" /></td>
                            <td><s:property value="duration" /></td>
                            <td><s:if test="%{duration==1}">30€</s:if><s:else>75€</s:else></td>
                            <s:form cssClass="form-signin" action="updatePurchaseAdver">
                                <td>
                                    <select name="pago">
                                        <option value="false"<s:if test="%{!pagado}">selected="true"</s:if>>No</option>
                                        <option value="true"<s:if test="%{pagado}">selected="true"</s:if>>Si</option>
                                        </select>
                                    </td>
                                    <td><s:textfield  id="%{id}" name="datePurchase" value="%{purshaceDate}" cssClass="calendar" /></td>
                                <td><s:property value="createdDate" /></td>
                                <s:set name="idOrder" value="%{id}" />
                                <s:iterator value="payOrder">
                                    <s:if test="%{#idOrder == advertising.id}">
                                        <td><a href="pdf/<s:property value="%{pdf}" />">PDF</a></td>
                                    </s:if>
                                </s:iterator>
                                <s:hidden name="id" value="%{id}" />
                                <td><s:submit value="Actualizar" /></td>
                            </s:form>
                        </tr>
                    </s:iterator>
                </table>
            </div>
        </div> 
    </div>
    <script>
        $(document).ready(function () {
            $(".calendar").each(function () {
                $(this).datepicker({
                    dateFormat: 'yy-mm-dd'
                });
            });
        });
    </script>
</body>
</html>
