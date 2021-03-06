<!-- BARRA DE NAVEGACIÓN PARA UN USUARIO NO REGISTRADO -->

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
                <li><s:a action="login">Login</s:a></li>
                <li><s:a action="registrarse">Registrarse</s:a></li>
            </ul>
            <s:if test="%{categoris!=null}">
                <s:form method="post" action="buscar" cssClass="navbar-form navbar-left">
                    <s:select name="idCategory" cssClass="form-control" list="categoris" listKey="id" listValue="type"/>
                    <button class="btn btn-link"><span style="color:white" class="glyphicon glyphicon-search"/></button>
                </s:form>
            </s:if>
        </div>
    </div>
</nav>