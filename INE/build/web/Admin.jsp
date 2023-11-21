<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/jpg" href="ine_logo.png"/>
        <link rel="stylesheet" href="index.css">
        <title>DashBoard Admin</title>
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
                margin-left: 1rem;
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
            /*formulario de busqueda*/
            .ip{
                margin-left: 1rem;
                position: relative;
                align-items: center;
            }

            .i {
                width: 40px;
                height: 40px;
                border-radius: 20px;
                border: none;
                outline: none;
                padding: 18px 16px;
                background-color: transparent;
                cursor: pointer;
                transition: all .5s ease-in-out;
            }

            .i::placeholder {
                color: transparent;
            }

            .i:focus::placeholder {
                color: rgb(131, 128, 128);
            }

            .i:focus,.i:not(:placeholder-shown) {
                background-color: #fff;
                border: 1px solid rgb(91, 107, 255);
                width: 290px;
                cursor: none;
                padding: 18px 16px 18px 45px;
            }

            .icon {
                position: absolute;
                left: 0;
                height: 45px;
                width: 45px;
                background-color: #fff;
                border-radius: 99px;
                z-index: -1;
                fill: rgb(91, 107, 255);
                border: 1px solid rgb(91, 107, 255);
            }

            .i:focus + .icon,.i:not(:placeholder-shown) + .icon {
                z-index: 0;
                background-color: transparent;
                border: none;
            }
            .iconsContainer{
                display: flex;
                flex-direction: row;
            }
            input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none; 
                margin: 0; 
            }
            .green{
                background-color: RGB(29, 185, 84);
            }
        </style>
    </head>
    <body>
        <h2 style="text-align: center">Bienvenido Admin: ${ name } con el id: ${ id_admin }</h2>
        <div class="iconsContainer">
            <a href="<%= request.getContextPath()%>/logOut">
                <button class="Btn">
                    <div class="sign"><svg viewBox="0 0 512 512"><path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"></path></svg></div>
                    <div class="text">Cerrar Sesión</div>
                </button>
            </a>
            <a href="Results">
                <button class="Btn green">
                    <div class="text">Resultados</div>
                    <div class="sign"><svg viewBox="0 0 24 24" fill="none"> <path d="M8 8H13M8 12H16M8 16H11M7.2 4H16.8C17.9201 4 18.4802 4 18.908 4.21799C19.2843 4.40973 19.5903 4.71569 19.782 5.09202C20 5.51984 20 6.0799 20 7.2V16.8C20 17.9201 20 18.4802 19.782 18.908C19.5903 19.2843 19.2843 19.5903 18.908 19.782C18.4802 20 17.9201 20 16.8 20H7.2C6.0799 20 5.51984 20 5.09202 19.782C4.71569 19.5903 4.40973 19.2843 4.21799 18.908C4 18.4802 4 17.9201 4 16.8V7.2C4 6.0799 4 5.51984 4.21799 5.09202C4.40973 4.71569 4.71569 4.40973 5.09202 4.21799C5.51984 4 6.0799 4 7.2 4Z" stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/> </svg><div>
                </button>
            </a>
            <div class="ip">
                <form autocomplete="off" action="SearchVotante" class="SV" method="post">
                    <input type="number" id="s" name="idVotante" class="i" placeholder="Id del votante">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="" viewBox="0 0 24 24" class="icon"><g stroke-width="0" id="SVGRepo_bgCarrier"></g><g stroke-linejoin="round" stroke-linecap="round" id="SVGRepo_tracerCarrier"></g><g id="SVGRepo_iconCarrier"> <rect fill="white" height="24" width="24"></rect> <path fill="" d="M2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12ZM9 11.5C9 10.1193 10.1193 9 11.5 9C12.8807 9 14 10.1193 14 11.5C14 12.8807 12.8807 14 11.5 14C10.1193 14 9 12.8807 9 11.5ZM11.5 7C9.01472 7 7 9.01472 7 11.5C7 13.9853 9.01472 16 11.5 16C12.3805 16 13.202 15.7471 13.8957 15.31L15.2929 16.7071C15.6834 17.0976 16.3166 17.0976 16.7071 16.7071C17.0976 16.3166 17.0976 15.6834 16.7071 15.2929L15.31 13.8957C15.7471 13.202 16 12.3805 16 11.5C16 9.01472 13.9853 7 11.5 7Z" clip-rule="evenodd" fill-rule="evenodd"></path> </g></svg>
                </form>
            </div>

        </div>
        <div class="v-c">
            <div class="v-form-container">
                <p class="v-title">Ingresa el número de votantes en tu casilla</p>
                <form class="v-form" method="post" action="totalVotantes">
                    <input type="number"  class="v-input" placeholder="Votantes" name="n_votantes" required>
                    <input type="submit" class="v-form-btn" value="Registrar">
                    <p style="text-align: center; font-weight: bold">${votanteData}</p>
                </form>
            </div>
        </div>
    </script>
</body>
</html>
