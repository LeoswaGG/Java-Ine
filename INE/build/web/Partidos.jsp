<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/jpg" href="ine_logo.png"/>
        <link rel="stylesheet" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partidos</title>
        <style>
            .img-container{
                max-width: 90%;
                height: 90%;  
                margin: 0 auto;
                display: flex;
            }
            .img-container .item {
                margin: 0 auto;
                border-radius: 10px ;
                text-align: center;
                width: 30%;
                padding: 1rem;
                height: 400px;
                color: black;
                font-weight: bold;
                margin-bottom: 10px;
                transition: 400ms;
                box-shadow: 15px 15px 30px #bebebe,
                    -15px -15px 30px #ffffff;
            }
            img {
                max-width: 100%;
                width: 100%;
            }
            .img-container .item:hover{
                transform: scale(1.1, 1.1);
            }

            .img-container:hover > .item:not(:hover) {
                filter: blur(10px);
                transform: scale(0.9, 0.9);
            }
            .h3, .h2{
                margin-bottom: 2rem;
            }
            .h2{
                margin-top: 2rem;
            }
            .votar{
                border: none;
                background-color: #e8047c;
                color: #ffffff;
                font-size: 0.875rem;
                line-height: 1.25rem;
                font-weight: bold;
                width: 100%;
                border-radius: 0.5rem;
                text-transform: uppercase;
                padding: 0.5rem;
                cursor: pointer;
            }
            .Btn {
                display: flex;
                align-items: center;
                justify-content: flex-start;
                width: 45px;
                height: 45px;
                border: none;
                border-radius: 50%;
                cursor: pointer;
                position: relative;
                overflow: hidden;
                transition-duration: .3s;
                box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.199);
                background-color: rgb(255, 65, 65);
            }

            .sign {
                width: 100%;
                transition-duration: .3s;
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .sign svg {
                width: 17px;
            }

            .sign svg path {
                fill: white;
            }
            .text {
                position: absolute;
                right: 0%;
                width: 0%;
                opacity: 0;
                color: white;
                font-weight: 600;
                font-family: 1.3em;
                transition-duration: .3s;
            }
            .Btn:hover {
                width: 125px;
                border-radius: 40px;
                transition-duration: .3s;
            }

            .Btn:hover .sign {
                width: 30%;
                transition-duration: .3s;
                padding-left: 20px;
            }
            .Btn:hover .text {
                opacity: 1;
                width: 70%;
                transition-duration: .3s;
                padding-right: 10px;
            }
            .Btn:active {
                transform: translate(2px ,2px);
            }
        </style>
    </head>
    <body>
        <h2 class="h2" style="text-align: center">Bienvenido Votante ${ votanteName } con el id ${ id_votante }</h2>
        <h3 class="h3" style="text-align: center">Ingresa tu voto</h3>
        <a href="<%= request.getContextPath() %>/logOut">
            <button class="Btn">
                <div class="sign"><svg viewBox="0 0 512 512"><path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"></path></svg></div>
                <div class="text">Cerrar Sesión</div>
            </button>
        </a>
        <div class="img-container">
            <div class="item">
                Enrique Peña Nieto
                <img src="pri.webp">
                <form action="Votos" method="post">
                    <input class="votar" type="submit" name="boton" value="PRI">
                </form>
            </div>    
            <div class="item">
                Ricardo Anaya
                <img src="pan.webp">
                <form action="Votos" method="post">
                    <input class="votar" type="submit" name="boton" value="PAN">
                </form>
            </div>
            <div class="item">
                Andres Manuel Lopez Obrador
                <img src="m.png">
                <form action="Votos" method="post">
                    <input class="votar" type="submit" name="boton" value="MORENA">
                </form>
            </div>
    </body>
</html>
        