<!-- BARRA DE NAVEGACIÓN PARA UN USUARIO REGISTRADO -->

<s:url var="perfilPrivado" namespace="/" action="getUsuario">
    <s:param name="perfil_email"><%= session.getAttribute("email")%></s:param>
</s:url>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <s:a cssClass="navbar-brand" action="validarSesion">E-Sport</s:a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><s:a href="%{perfilPrivado}">Perfil</s:a></li>
                <li><s:a action="mensajes">Mensajes</s:a></li>
                <li id="notificacion" style="display:none"><s:a action="mensajes"><span class="glyphicon glyphicon-comment" style="color:red"/></s:a></li>
                <li><s:a action="misEventos">Mis eventos</s:a></li>
                <li><s:a action="grupos">Grupos</s:a></li>
                <li><s:a action="logout">Logout</s:a></li>
                <!--<span id="notificacion" class="glyphicon glyphicon-comment"/>--> 
            </ul>
            <s:form method="post" action="buscarEvento" cssClass="navbar-form navbar-left">
                <s:hidden cssClass="filtro_ciudad" name="filtro_ciudad" value=""/>
                <s:textfield cssClass="form-control" name="filtro_nombre"/>
                <button class="btn btn-link"><span style="color:white" class="glyphicon glyphicon-search"/></button>
            </s:form>
        </div>
    </div>
</nav>

<% String email = (String) session.getAttribute("email");%>
<script>
    $(document).ready(function () {
        //Notificaciones de mensajes
        if ($("#notificacion").css("display") === "none") {
            var email = "<%=email%>";
            $.post('hayNotificacion', {
                email: email
            }, function (respuesta) {
                if (respuesta === "nuevaNotificacion") {
                    $("#notificacion").show();
                }
            });
        }
    });
</script>
<script>
    $(document).ready(setInterval(function () {
        //Notificaciones de mensajes
        if ($("#notificacion").css("display") === "none") {
            var email = "<%=email%>";
            $.post('hayNotificacion', {
                email: email
            }, function (respuesta) {
                if (respuesta === "nuevaNotificacion") {
                    $("#notificacion").show();
                }
            });
        }
    }, 5000));
</script>