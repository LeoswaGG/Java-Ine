<!DOCTYPE html>
<html>
    <head>
        <title>INE</title>
        <meta charset="UTF-8">
        <link rel="icon" type="image/jpg" href="ine_logo.png"/>
        <link rel="stylesheet" href="index.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .error {
                font-family: sans-serif;
                width: 320px;
                padding: 12px;
                display: flex;
                flex-direction: row;
                align-items: center;
                justify-content: start;
                background: #EF665B;
                border-radius: 8px;
                box-shadow: 0px 0px 5px -3px #111;
                margin-bottom: 16rem;
            }

            .error__icon {
                width: 20px;
                height: 20px;
                transform: translateY(-2px);
                margin-right: 8px;
            }

            .error__icon path {
                fill: #fff;
            }

            .error__title {
                font-weight: 500;
                font-size: 14px;
                color: #fff;
            }
            .container{
                display: flex;
                flex-direction: column;
            }
        </style>

    </head>
    <body>
        <header class="header">
            <h1>Instituto Nacional Electoral</h1><img src="ine_logo.png" class='ine'>
            <nav class="menu">
                <ul>
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="Votante.jsp">Votar</a></li>
                </ul>
            </nav>
        </header
        <main>            
            <article class="hero-image">
                <div class="container">
                    <% Object a = request.getSession().getAttribute("attempts");
                        if (a != null) { %>
                        <div class="error">
                            <div class="error__icon">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" viewBox="0 0 24 24" height="24" fill="none"><path fill="#393a37" d="m13 13h-2v-6h2zm0 4h-2v-2h2zm-1-15c-1.3132 0-2.61358.25866-3.82683.7612-1.21326.50255-2.31565 1.23915-3.24424 2.16773-1.87536 1.87537-2.92893 4.41891-2.92893 7.07107 0 2.6522 1.05357 5.1957 2.92893 7.0711.92859.9286 2.03098 1.6651 3.24424 2.1677 1.21325.5025 2.51363.7612 3.82683.7612 2.6522 0 5.1957-1.0536 7.0711-2.9289 1.8753-1.8754 2.9289-4.4189 2.9289-7.0711 0-1.3132-.2587-2.61358-.7612-3.82683-.5026-1.21326-1.2391-2.31565-2.1677-3.24424-.9286-.92858-2.031-1.66518-3.2443-2.16773-1.2132-.50254-2.5136-.7612-3.8268-.7612z"></path></svg>
                            </div>
                            <div class="error__title">Acceso denegado. Te quedan: ${ attempts } intentos</div>
                        </div>
                    
                    <%}%>
                    <form class="form" method="post" action="validSession" autocomplete="off">
                        <p class="form-title">Iniciar Sesión</p>
                        <div class="input-container">
                            <input type="text" placeholder="Ingresa tu usuario" name="userName" required>
                            <span>
                            </span>
                        </div>
                        <div class="input-container">
                            <input type="password" placeholder="Ingresa tu contraseña" name="adminPassword" required>
                        </div>
                        <input type="submit" class="submit" value='Acceder'>
                    </form
                </div>
            </article>
        </main>
                    <a href="prueba.jsp">
                        ir
                        </a>
    </body>
</html>
