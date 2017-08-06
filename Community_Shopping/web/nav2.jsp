<!-- BARRA DE NAVEGACIÓN PARA UN USUARIO REGISTRADO -->

<s:url var="perfilPrivado" namespace="/" action="getUsuario">
    <s:param name="perfil_email"><%= session.getAttribute("email")%></s:param>
</s:url>
<s:url var="misPedidos" namespace="/" action="misPedidos">
    <s:param name="id"><%= session.getAttribute("email")%></s:param>
</s:url>
<s:url var="misAnuncios" namespace="/" action="misAnuncios">
    <s:param name="id"><%= session.getAttribute("email")%></s:param>
</s:url>
<s:url var="misLotes" namespace="/" action="misLotes">
    <s:param name="id"><%= session.getAttribute("email")%></s:param>
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
            <s:a cssClass="navbar-brand" action="validarSesion">Community Shopping</s:a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><s:a href="%{perfilPrivado}">Perfil</s:a></li>
                <s:if test="%{#session.proveedor ==true}">
                    <li><s:a href="%{misAnuncios}">Mis Anuncios</s:a></li>
                    <li><s:a href="%{misLotes}">Mis Lotes</s:a></li>
                </s:if>
                <s:else>
                    <li><s:a href="%{misPedidos}">Mis Pedidos</s:a></li>
                </s:else>
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
