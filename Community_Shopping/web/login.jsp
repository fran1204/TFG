<%-- 
PÁGINA ENCARGADA DEL LOGIN
    Document   : login
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

        <title>Login</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/signin.css" rel="stylesheet">
        <link href="bootstrap/css/dashboard.css" rel="stylesheet">


    </head>

    <body>

        <%@ include file="nav1.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4">
                </div>
                <div class="col-md-4">
                    <s:form id="log" cssClass="form-signin" action="validarLogin">
                        <h2 class="form-signin-heading">Identifícate</h2>
                        <span style="color:red"><s:property value="mensajeError"/></span>
                        <s:actionerror></s:actionerror>
                        <s:fielderror></s:fielderror>
                        <s:textfield cssClass="form-control" name="email"/>
                        <s:password cssClass="form-control" name="password"/>

                        <s:submit cssClass="btn btn-lg btn-primary btn-bloc" value="login"/>
                    </s:form>
                    <s:a action="registrarse">¿No estás registrado?</s:a>
                    <br/><br/><br/><br/><center><p style="display:none"><img src='img/loading.gif' width='75' height='75'/></p></center>
                </div>
                <div class="col-md-4">
                </div>
            </div>
        </div>
        <!-- ==========================================JAVASCRIPT======================================== -->            
        <script>
            $(document).ready(function () {
                $("#log_email").attr("placeholder", "email");
                $("#log_email").attr("autofocus", "");
                $("#log_password").attr("placeholder", "password");
                $("#log").submit(function () {
                    $(this).hide();
                    $("p").show();
                    return;
                });
            });
        </script>

    </body>
</html>

