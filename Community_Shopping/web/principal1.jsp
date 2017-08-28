<!-- Landing principal de la APP -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="img/favicon.ico">

        <title>Principal</title>
        <!-- Bootstrap core CSS -->
        <link href="bootstrap/css/style.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/dashboard.css" rel="stylesheet">
        <%@ include file="javascript.html" %>

    </head>

    <body>

        <%@ include file="nav1.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <h1 class="page-header text-center">Chollos de hoy!!</h1>
                </div>
                <div class="col-md-3"></div>
            </div>
            <!--Prueba de anuncio y oferta -->
            <s:iterator value="anuncio"> 
                <div class="col-md-3 col-sm-3">
                    <s:if test="%{url!=null && url!=''}">
                        <div class="feature-gallery">
                            <a href="<s:url value='%{url}'/>">
                                <img class="thumb" src="img/<s:property value='image'/>" alt="" title="">
                            </a>

                        </div>
                        <div>
                            <a href="<s:url value='%{url}'/>">
                                Ir al anuncio
                            </a>
                        </div>
                    </s:if>
                    <s:elseif test="%{numSet == null}">
                        <div class="feature-gallery">
                            <s:a href="%{urlExternal}">
                                <img class="thumb" src="<s:property value='photo'/>" alt="" title="">

                                <div class="fg-overlay">
                                    <h2><s:property value='title'/></h2>
                                    <p><s:property value='description'/></p>
                                    <p>Precio: <s:property value='price'/>€ und.</p>
                                </div>
                            </s:a>
                        </div>
                    </s:elseif>
                    <s:else>
                        <div class="feature-gallery">
                            <s:url var="detalle" namespace="/" action="detalleLote">
                                <s:param name="id" value="%{id}"/>
                            </s:url>
                            <s:url var="login" namespace="/" action="loginAnonimo">
                                <s:param name="idLote" value="%{id}"/>
                            </s:url>
                            <s:a href="%{detalle}">
                                <img class="thumb" src="img/<s:property value='photo'/>" alt="" title="">

                                <div class="fg-overlay">
                                    <h2><s:property value='title'/></h2>
                                    <p><s:property value='description'/></p>
                                    <p>Lote: <s:property value='numSet'/> und.</p>
                                    <p>Precio: <s:property value='price'/>€</p>
                                    <p>Cantidad Disponible: <s:property value='quantityAvailable'/></p>
                                </div>
                            </s:a>

                        </div>
                        <div>                       
                            <s:a href="%{login}">
                                Compartir!
                            </s:a>
                        </div>
                        <div>
                            <s:a href="%{login}">
                                Lo quiero!
                            </s:a>
                        </div>
                    </s:else>
                </div>
            </s:iterator>
        </div>
    </body>
</html>
