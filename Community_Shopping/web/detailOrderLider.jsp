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
        <s:if test="%{comprar}">
            <s:if test="%{paid}">
                <a href="pdf/<s:property value="%{pdf}" />" class="btn btn-info">PDF</a>
            </s:if>
            <s:else>
                Banco del proveedor para realizar el pago: <s:property value="%{bank}" />
                <s:url var="pagar" namespace="/" action="pagoRealizado" >
                    <s:param name="id" value="%{id}"/><!--Id del pedido -->
                </s:url>
                <div>
                    <s:a href="%{pagar}" cssClass="btn btn-success">Pagado!</s:a>
                    </div>
            </s:else>

        </s:if>

        <table class="table">
            <tbody>
                <tr>
                    <th>Nombre</th>
                    <th>Cantidad</th>
                    <th>Pagado</th>
                    <th>Fecha del pago</th>
                    <th>Cantidad Total abonar</th>
                    <th>Estado del pago</th>
                    <th></th>
                    <th></th>
                </tr>
                <s:hidden value="%{price}" cssClass="price" />
                <s:hidden value="%{cantidadOferta}" cssClass="cantidadSet" />
                <s:iterator value="io"> 
                    <s:if test="%{order.stateOrder != 'Caducado'}">
                        <s:url var="actualizar" namespace="/" action="updateOrderUser" >
                            <s:param name="id" value="%{id}"/>
                        </s:url>
                        <s:url var="email" namespace="/" action="sendEmail" >
                            <s:param name="idInterOrder" value="%{id}"/>
                            <s:param name="emailUser" value="%{user.email}"/>
                            <s:param name="op" value="1"/>
                        </s:url>

                        <s:form cssClass="form-signin" action="updateOrderUser">
                            <tr class="caye">
                                <s:hidden name="id" value="%{id}" />
                                <th><s:property value='%{user.name}'/></th>
                                <td><s:textfield name="amount" value="%{amount}" cssClass="totalpagado amount"/></td>
                                <td><s:textfield name="paidTotal" value="%{paidTotal}" cssClass="paid" /></td>
                                <td><s:textfield  id="%{id}" name="datePurchase" value="%{datePurchase}" cssClass="calendar" /></td>
                                <td class="total">
                                </td>
                                <td>
                                    <select name="estadoPago">
                                        <option value="pendiente"<s:if test="%{state == 'pendiente'}">selected="true"</s:if>>Pendiente</option>
                                        <option value="pagado"<s:if test="%{state == 'pagado'}">selected="true"</s:if>>Pagado</option>
                                        </select>

                                    </td>
                                    <td><s:submit value="Actualizar" /></td>                
                                <td><s:a href="%{email}">Recordatorio de pago</s:a></td>        
                                </tr>
                        </s:form>
                    </s:if>
                    <s:else>
                        <tr class="caye">
                            <th><s:property value='%{user.name}'/></th>
                            <td><s:textfield name="amount" value="%{amount}" cssClass="totalpagado amount" readonly="true"/></td>
                            <td><s:textfield name="paidTotal" value="%{paidTotal}" cssClass="paid" readonly="true"/></td>
                            <td><s:textfield name="datePurchase" value="%{datePurchase}"  readonly="true"/></td>
                            <td class="total">
                            </td>
                            <td><s:textfield value="%{state}" readonly="true"/></td>
                        </tr>
                    </s:else>
                </s:iterator>
            </tbody>
        </table>


        <!-- ==========================================JAVASCRIPT======================================== -->              
        <script>
            $(document).ready(function () {
                var price = parseFloat($(".price").val());

//                $(".calendar").datepicker({
//                    dateFormat: 'yy-mm-dd'
//                });

                $(".calendar").each(function () {
                    $(this).datepicker({
                        dateFormat: 'yy-mm-dd'
                    });
                });


                $(".caye").keyup(function () {
                    var t = $(this).find("input.amount").val() * price;
                    $(this).find("td.total").html(t - $(this).find("input.paid").val());
                });


                $('.caye').each(function () {
                    var t = $(this).find("input.amount").val() * price;
                    $(this).find("td.total").html(t - $(this).find("input.paid").val());
                });

            });
        </script>
    </body>
</html>
