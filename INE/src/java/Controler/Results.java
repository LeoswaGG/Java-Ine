package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;

@WebServlet(name = "Results", urlPatterns = {"/Results"})
public class Results extends HttpServlet {

    DaoUsuario dao = new DaoUsuario();
    int totalVotantes = Integer.parseInt(dao.getTotalVotantes());
    int priVotos = Integer.parseInt(dao.getPriVotos());
    int panVotos = Integer.parseInt(dao.getPanVotos());
    int morenaVotos = Integer.parseInt(dao.getMorenaVotos());
    int totalVotosPartido = priVotos + panVotos + morenaVotos;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Results</title>");
            out.println("<link rel=\"icon\" type=\"image/jpg\" href=\"ine_logo.png\"/>");
            out.println("<link rel=\"stylesheet\" href=\"index.css\">");
            out.println("<style>.Btn {\n"
                    + "                display: flex;\n"
                    + "                align-items: center;\n"
                    + "                justify-content: flex-start;\n"
                    + "                width: 45px;\n"
                    + "                height: 45px;\n"
                    + "                border: none;\n"
                    + "                border-radius: 50%;\n"
                    + "                cursor: pointer;\n"
                    + "                position: relative;\n"
                    + "                overflow: hidden;\n"
                    + "                transition-duration: .3s;\n"
                    + "                box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.199);\n"
                    + "                background-color: rgb(255, 65, 65);\n"
                    + "                margin-left: 1rem;\n"
                    + "            }\n"
                    + "\n"
                    + "            .sign {\n"
                    + "                width: 100%;\n"
                    + "                transition-duration: .3s;\n"
                    + "                display: flex;\n"
                    + "                align-items: center;\n"
                    + "                justify-content: center;\n"
                    + "            }\n"
                    + "\n"
                    + "            .sign svg {\n"
                    + "                width: 17px;\n"
                    + "            }\n"
                    + "\n"
                    + "            .sign svg path {\n"
                    + "                fill: white;\n"
                    + "            }\n"
                    + "            .text {\n"
                    + "                position: absolute;\n"
                    + "                right: 0%;\n"
                    + "                width: 0%;\n"
                    + "                opacity: 0;\n"
                    + "                color: white;\n"
                    + "                font-weight: 600;\n"
                    + "                font-family: 1.3em;\n"
                    + "                transition-duration: .3s;\n"
                    + "            }\n"
                    + "            .Btn:hover {\n"
                    + "                width: 125px;\n"
                    + "                border-radius: 40px;\n"
                    + "                transition-duration: .3s;\n"
                    + "            }\n"
                    + "\n"
                    + "            .Btn:hover .sign {\n"
                    + "                width: 30%;\n"
                    + "                transition-duration: .3s;\n"
                    + "                padding-left: 20px;\n"
                    + "            }\n"
                    + "            .Btn:hover .text {\n"
                    + "                opacity: 1;\n"
                    + "                width: 70%;\n"
                    + "                transition-duration: .3s;\n"
                    + "                padding-right: 10px;\n"
                    + "            }\n"
                    + "            .Btn:active {\n"
                    + "                transform: translate(2px ,2px);\n"
                    + "            } img{max-width: 100%;} h2,h3,h1{text-align: center;} .img-c{display: flex; justify-content: center; align-items:center;} </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='Admin.jsp'>");
            out.println("<button class='Btn'>");
            out.println("<div class=\"sign\"><svg viewBox=\"0 0 512 512\"><path d=\"M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z\"></path></svg></div>");
            out.println("<div class=\"text\">Regresar</div>");
            out.println("</button>");
            out.println("</a>");
            out.println("<h1>Total votantes: " + totalVotantes + "</h1>");
            out.println("<hr></hr>");
            out.println("<h2>Enrique Peña Nieto</h2>");
            out.println("<h2>Votos para el PRI: " + priVotos + "</h2>");
            out.println("<hr></hr>");
            out.println("<h2>Ricardo Anaya</h2>");
            out.println("<h2>Votos para el PAN: " + panVotos + "</h2>");
            out.println("<hr></hr>");
            out.println("<h2>Andres Manuel Lopez Obrador </h2>");
            out.println("<h2>Votos para MORENA: " + morenaVotos + "</h2>");
            out.println("<hr></hr>");
            out.println("<br>");
            if (totalVotantes == totalVotosPartido) {
                if (priVotos > panVotos && priVotos > morenaVotos) {
                    out.println("<h2>El ganador es el PRI con su candidato Enrique Peña Nieto y un total de " + priVotos + " votos </h2>");
                    out.println("<div class='img-c'>");
                    out.println("<img src='pena.jpg'>");
                    out.println("</div>");
                } else if (panVotos > priVotos && panVotos > morenaVotos) {
                    out.println("<h2>El ganador es el PAN con su candidato Ricardo Anaya y un total de " + panVotos + " votos </h2>");
                    out.println("<div class='img-c'>");
                    out.println("<img src='anaya.png' style='width:500px; height:300px;'>");
                    out.println("</div>");
                } else if (morenaVotos > priVotos && morenaVotos > panVotos) {
                    out.println("<h2>El ganador es MORENA con su candidato Andres Manuel Lopez Obrador y un total de " + morenaVotos + " votos </h2>");
                    out.println("<div class='img-c'>");
                    out.println("<img src='pelon.jpg'>");
                    out.println("</div>");
                } else {
                    out.println("<h2>Hubo un empate entre los candidatos: </h2>");
                    out.println("<br>");
                    out.println("<h3>Pri: " + priVotos+"</h3>");
                    out.println("<br>");
                    out.println("<h3>Morena: " + morenaVotos+"</h3>");
                    out.println("<br>");
                    out.println("<h3>Pan: " + panVotos+"</h3>");
                    out.println("<br>");
                }
            } else {
                out.println("<h2>Faltan votantes que efectuen su voto para determinar al ganador</h2>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
