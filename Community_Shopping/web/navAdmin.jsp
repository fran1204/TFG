<!-- MENU DE NAVEGACION -->
<s:url var="usuarios" namespace="/" action="allUser">
</s:url>
<s:url var="lotess" namespace="/" action="allLotess">
</s:url>
<s:url var="pedidos" namespace="/" action="allOrders">
</s:url>
<s:url var="anun" namespace="/" action="allAdvertisings">
</s:url>
<s:url var="crawler" namespace="/" action="lanzarCrawler" ></s:url>

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
                <li><s:a href="%{crawler}">Lanzar Crawler</s:a></li>
                <li><s:a href="%{anun}">Ver Anuncios</s:a></li>
                <li><s:a href="%{lotess}">Ver Lotes</s:a></li>
                <li><s:a href="%{pedidos}">Ver Pedidos</s:a></li>
                <li><s:a href="%{usuarios}">Ver Usuarios</s:a></li>
                <li><s:a action="logout">Logout</s:a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- FIN MENU -->