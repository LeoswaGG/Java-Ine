    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
        <head>
            <link rel="stylesheet" href="index.css">
            <link rel="icon" type="image/jpg" href="ine_logo.png"/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Registrar Votantes</title>
            <style>
                .v-c{
                    display: flex;
                    justify-content: center;
                    align-items: center;
                }
                .v-form-container {
                    width: 350px;
                    height: 500px;
                    background-color: #fff;
                    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
                    border-radius: 10px;
                    box-sizing: border-box;
                    padding: 20px 30px;
                }

                .v-title {
                    text-align: center;
                    margin: 10px 0 30px 0;
                    font-size: 28px;
                    font-weight: bold;
                }

                .v-form {
                    width: 100%;
                    display: flex;
                    flex-direction: column;
                    gap: 18px;
                    margin-bottom: 15px;
                }

                .v-input {  
                    border-radius: 20px;
                    border: 1px solid #c0c0c0;
                    outline: 0 !important;
                    box-sizing: border-box;
                    padding: 12px 15px;
                }

                .v-form-btn {
                    padding: 10px 15px;
                    border-radius: 20px;
                    border: 0 !important;
                    outline: 0 !important;
                    background-color: #e8047c;;
                    color: white;
                    cursor: pointer;
                    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
                }

                .v-form-btn:active {
                    box-shadow: none;
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
            <h2 style="text-align: center">Admin: ${ name } <br> Id: ${ id_admin }</h2>
            <a href="Admin.jsp">
                <button class="Btn">
                    <div class="sign"><svg viewBox="0 0 512 512"><path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"></path></svg></div>
                    <div class="text">Regresar</div>
                </button>
            </a>
            <div class="v-c">
                <div class="v-form-container">
                    <p class="v-title">Registra a tus ${tVotantes} votantes</p>
                    <form class="v-form" method="post" action="votanteData">
                        <input type="text" class="v-input" placeholder="Nombre(s)" name="vName" required>
                        <input type="text" class="v-input" placeholder="Apellidos" name="vLastName" required>
                        <% Object a = request.getAttribute("ageError");
                            if (a != null) { %>
                        <p style="color: red; font-weight: bold">${ageError}</p>
                        <%}%>
                        <input type="number"  class="v-input" placeholder="Edad" name="age" required>
                        <input type="date" class="v-input" placeholder="Fecha de nacimiento" name="birthday" required>           
                        <input type="submit" class="v-form-btn" value="Registrar">
                    </form>
                </div>
            </div>
        </body>
    </html>
