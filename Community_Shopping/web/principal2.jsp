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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <%@ include file="javascript.html" %>

    </head>

    <body>

        <%@ include file="nav2.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <h1 class="page-header text-center">¡Chollos a compartir! Principal 11</h1>
                </div>
                <div class="col-md-3"></div>
            </div>

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
                                Compartir!
                            </a>
                        </div>
                        <div>
                            <a href="<s:url value='%{url}'/>">
                                Lo quiero!
                            </a>
                        </div>
                    </s:if>
                    <s:else>
                        <div class="feature-gallery">
                            <s:url var="detalle" namespace="/" action="detalleLote" >
                                <s:param name="id" value="%{id}"/>
                            </s:url>
                            <div class="fecha"><s:date name="expiryDate" nice="true" /></div>
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
                            <s:url var="compartir" namespace="/" action="compartirRedes" >
                                <s:param name="id" value="%{id}"/>
                            </s:url>
                            <s:a href="%{compartir}">
                                Compartir!
                            </s:a>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#redes<s:property value="id"/>">
                                Compartir!
                            </button>
                        </div>
                    </s:else>
                </div>
                <!--                MODAL PARA COMPARTIR
                                <div class="modal fade" id="redes<s:property value="id"/>" tabindex="-1" role="dialog" aria-labelledby="RedesSociales" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel">Elige la red social para compartir</h4>
                                            </div>
                                            <div class="modal-body">
                                                Texto del modal
                                            </div>
                                        </div>
                                    </div>
                                </div>-->
            </s:iterator>
        </div>



    </body>
</html>
