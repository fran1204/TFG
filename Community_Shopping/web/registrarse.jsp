<%-- 
PÁGINA ENCARGADA DE REGISTRAR UN USUARIO
    Document   : registrarse
    Created on : 24-abr-2016, 17:18:34
    Author     : cayetano
--%>

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

        <title>Registrarse</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/signin.css" rel="stylesheet">
        <link href="bootstrap/css/dashboard.css" rel="stylesheet">
        <%@ include file="javascript.html" %>

    </head>

    <body>
        <%@ include file="nav1.jsp" %>
        <s:form cssClass="form-signin" action="addUsuario">
            <h2 class="form-signin-heading">Regístrate </h2>
            <%--<s:actionerror></s:actionerror>--%>
            <span style="color:red"><s:property value="existeUsuario"/></span>
            <s:fielderror/>
            <s:checkbox name="provider" fieldValue="true" label="¿Eres proveedor?"/>
            <s:textfield cssClass="form-control" name="email"/>
            <s:textfield cssClass="form-control" name="name"/>
            <s:textfield cssClass="form-control" name="company_name"/>
            <s:select name="sector" cssClass="form-control" list="sectores" listKey="id" listValue="sector"/>
            <s:textfield cssClass="form-control" name="bank"/>
            <s:password cssClass="form-control" name="password"/>


            <s:submit cssClass="btn btn-lg btn-primary btn-bloc" value="registrarse"/>
        </s:form>


        <!-- ==========================================JAVASCRIPT======================================== -->              
        <script>
            $("#addUsuario_email").attr("placeholder", "Email");
            $("#addUsuario_email").attr("autofocus", "");
            $("#addUsuario_name").attr("placeholder", "Nombre");
            $("#addUsuario_company_name").attr("placeholder", "Nombre empresa");
            $("#addUsuario_password").attr("placeholder", "Password");
            $("#addUsuario_sector").attr("placeholder", "Elige el sector de tu empresa");
            $("#addUsuario_bank").attr("placeholder", "Cuenta bancaria");
        </script>

    </body>
</html>

