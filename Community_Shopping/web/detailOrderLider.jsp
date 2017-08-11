<%-- 
    Document   : detailOrderLider
    Created on : 10-ago-2017, 18:49:24
    Author     : fran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/signin.css" rel="stylesheet">
        <link href="bootstrap/css/dashboard.css" rel="stylesheet">

        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>

        <%@ include file="javascript.html" %>
        <link href="jquery-calendar/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <script src="jquery-calendar/jquery-ui.min.js" type="text/javascript"></script>
    </head>
    <body>
        <%@ include file="nav2.jsp" %>
        <h1>Pedido</h1>

        <table class="table">
            <tbody>
                <tr>
                    <th>Nombre</th>
                    <th>Cantidad</th>
                    <th>Pagado</th>
                    <th>Fecha del pago</th>
                    <th>Cantidad Total abonar</th>
                    <th></th>
                    <th></th>
                </tr>
                <s:hidden value="%{price}" cssClass="price" />
                <s:iterator value="io"> 
                    <s:url var="actualizar" namespace="/" action="updateOrderUser" >
                        <s:param name="id" value="%{id}"/>
                    </s:url>
                    <s:url var="email" namespace="/" action="sendEmail" >
                        <s:param name="id" value="%{id}"/>
                    </s:url>
                    
                    <s:form cssClass="form-signin" action="updateOrderUser">
                        <tr>
                            <th><s:property value='%{user.name}'/></th>
                            <td><s:textfield name="amount" value="%{amount}" cssClass="totalpagado"/></td>
                            <td><s:textfield name="paidTotal" value="%{paidTotal}"/></td>
                            <td><s:textfield name="datePurchase" value="%{datePurchase}" cssClass="calendar" /></td>
                            <td><s:property value="amount" /></td>
                            <td><p>hola</p></td>
                            <td><s:a href="%{actualizar}">Actualizar</s:a></td>                
                            <td><s:a href="%{email}">Recordatorio de pago</s:a></td>        
                            </tr>
                    </s:form>
                </s:iterator>
            </tbody>
        </table>


        <!-- ==========================================JAVASCRIPT======================================== -->              
        <script>
            $(document).ready(function () {
                $(".calendar").datepicker({
                    dateFormat: 'yy-mm-dd'
                });
                
                $(".totalpagado").keyup(function(){
                    var padre=$(this).parent();
                    //alert($(".price").val());
                    alert(padre.val());
                    for(var i=0; i<2;i++){
                       // alert($(this).prev().val());
                    }
                    
                });

            });
        </script>
    </body>
</html>
