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
        <%@ include file="javascript.html" %>
    </head>
    <body>
        <%@ include file="navAdmin.jsp" %>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <h1 class="page-header text-center">Todos los Lotes</h1>
                    </div>
                    <div class="col-md-3"></div>
                </div>

                <div class="row">
                    <table class="table">
                        <tr>
                            <th>Proveedor</th>
                            <th>Categoria</th>
                            <th>Titulo</th>
                            <th>Descripción</th>
                            <th>NumSet</th>
                            <th>Precio unidad</th>
                            <th>Fecha Expiración</th>
                            <th>Url Externo</th>
                            <th>Fecha de alta</th>
                        </tr>
                    <s:iterator value="lotess">
                        <tr>
                            <td><s:property value="user.companyName" /></td>
                            <td><s:property value="category.type" /></td>
                            <td><s:property value="title" /></td>
                            <td><s:property value="description" /></td>
                            <td><s:property value="numSet" /></td>
                            <td><s:property value="price" /></td>
                            <td><s:property value="expiryDate" /></td>
                            <td><s:property value="urlExternal" /></td>
                            <td><s:property value="createDate" /></td>
                        </tr>
                    </s:iterator>
                </table>
            </div>
        </div> 
    </div>
</body>
</html>
