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
        <link href="bootstrap/css/navbar.css" rel="stylesheet">
        <link href="bootstrap/css/style.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/dashboard.css" rel="stylesheet">
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

            <s:iterator value="lotes"> 
                <div class="col-md-3 col-sm-3">
                    <div class="feature-gallery">
                        <s:url var="detalle" namespace="/" action="detalleLote" >
                            <s:param name="id" value="%{id}"/>
                        </s:url>
                        <s:a href="%{detalle}">
                            <img class="thumb" src="img/<s:property value='photo'/>" alt="" title="">

                            <div class="fg-overlay">
                                <h2><s:property value='title'/></h2>
                                <p><s:property value='desciption'/></p>
                                <p>Lote: <s:property value='numSet'/> und.</p>
                                <p>Precio: <s:property value='price'/>€</p>
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
                    </div>
                    <div>
                        <s:url var="adherirse" namespace="/" action="adherirse" >
                            <s:param name="id" value="%{id}"/>
                        </s:url>
                        <s:a href="%{adherirse}">
                            Lo quiero!
                        </s:a>
                    </div>
                </div>
            </s:iterator>
        </div>


        <!-- ==========================================JAVASCRIPT======================================== -->  

        <script>
            $(document).ready(function () {
                $("#filtro_nombre").attr("placeholder", "Inserta nombre del evento...");
            });
        </script>
    </body>
</html>
