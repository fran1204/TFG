<%-- 
PERFIL DEL USUARIO
    Document   : perfil
    Created on : 30-abr-2016, 14:24:00
    Author     : cayetano
--%>

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
                        <h1 class="page-header">Perfil</h1>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <img src="img/perfil/<s:property value="%{usuario.photo}"/>" class="img-thumbnail" alt="foto perfil"/>
                        <s:if test="%{sesion_email==usuario.email}">
                        <center>
                            <s:form method="post" enctype="multipart/form-data" action="updateFotoPerfil"><s:hidden name="perfil_email" value="%{usuario.email}"/><s:hidden name="nombre_foto" value="%{usuario.photo}"/><label class="btn btn-default btn-file"><span class="glyphicon glyphicon-pencil"/><s:file name="fileUpload" cssStyle="display:none" onchange="this.form.submit();"/></label></s:form>
                            <s:form method="post" action="deleteFotoPerfil"><button class="btn btn-default"><s:hidden name="perfil_email" value="%{usuario.email}"/><s:hidden name="nombre_foto" value="%{usuario.photo}"/><span class="glyphicon glyphicon-trash"/></button></s:form>
                        </center>
                        </s:if>
                    </div>

                        <div class="col-md-5">
                        <s:if test="%{sesion_email!=usuario.email}">
                            <%--Si NO es tu perfil:--%>
                            <ul style="display: inline-block;">
                                <li><strong>Nombre:</strong> <s:property value="%{usuario.name}"/></li>
                                <li><strong>Email:</strong> <s:property value="%{usuario.email}"/></li>
                            </ul>
                        </s:if>
                        <s:else>
                            <%--Si es tu perfil:--%>
                            <s:fielderror/>
                            <s:form cssClass="form-signin col-lg-offset-2" cssStyle="display: inline-block">
                                <s:label value="Nombreee"/><s:textfield cssClass="form-control" name="nombre" value="%{usuario.name}"/>
                                <s:label value="Contraseña"/><s:textfield cssClass="form-control" name="password" value="%{usuario.password}"/>
                                <s:label value="Email"/><s:textfield id="Usuario_email" cssClass="form-control" name="email" value="%{usuario.email}"/>
                               
                                <%--</s:form>--%>

                            </div>
                            <div class="col-md-4">
                                <%--<s:form method="post">--%>
                                <s:submit cssClass="btn btn-primary" value="Actualizar" action="updateUsuario"/>
                                <s:submit cssClass="btn btn-primary" cssStyle="background-color: rgba(220, 38, 7, 0.94);border-color: rgba(220, 38, 7, 0.94);" value="Eliminar" action="deleteUsuario"/>
                            </s:form>
                        </s:else>
                    </div>
                </div>

            </div>
        </div>





        <!-- ==========================================JAVASCRIPT======================================== --> 
        <script>
            $(document).ready(function(){
                $("#Usuario_email").attr("disabled","");
            });
            
        </script>
    </body>
</html>
