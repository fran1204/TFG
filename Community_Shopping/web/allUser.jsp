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
                        <h1 class="page-header text-center">Todos los Usuarios</h1>
                    </div>
                    <div class="col-md-3"></div>
                </div>

                <div class="row">
                    <h3>Interlocutores</h3>
                    <table class="table">
                        <tr>
                            <th>Nombre</th>
                            <th>Email</th>
                            <th>Fecha de alta</th>
                        </tr>
                    <s:iterator value="interlocutor">
                        <tr>
                            <td><s:property value="name" /></td>
                            <td><s:property value="email" /></td>
                            <td><s:property value="createDate" /></td>
                        </tr>
                    </s:iterator>
                </table></br>

                <h3>Proveedores</h3>
                <table class="table">
                    <tr>
                        <th>Nombre</th>
                        <th>Email</th>
                        <th>Compañia</th>
                        <th>Sector</th>
                        <th>Cuent. Banco</th>
                        <th>Fecha de alta</th>
                    </tr>
                    <s:iterator value="proveedor">
                        <tr>
                            <td><s:property value="name" /></td>
                            <td><s:property value="email" /></td>
                            <td><s:property value="companyName" /></td>
                            <td><s:property value="sector.sector" /></td>
                            <td><s:property value="bank" /></td>
                            <td><s:property value="createDate" /></td>
                        </tr>
                    </s:iterator>
                </table>
            </div>
        </div> 
    </div>
</body>
</html>
