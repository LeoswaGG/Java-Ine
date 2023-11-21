package Controler;

import Model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Votos", urlPatterns = {"/Votos"})
public class Votos extends HttpServlet {

    Voto voto = new Voto();
    DaoUsuario dao = new DaoUsuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String votoUser = request.getParameter("boton");
        int idVotante = Integer.parseInt(String.valueOf(request.getSession().getAttribute("id_votante")));
        boolean cannotVote = dao.hasVote(idVotante);

        if (cannotVote) {
            request.getSession().setAttribute("vError", "No puedes ingresar mas de 1 voto/No puedes votar otra vez");
            request.getRequestDispatcher("VotosError.jsp").forward(request, response);
        } else {
            voto.setidVotante(idVotante);
            voto.setIdPartido(votoUser);
            boolean isCreate = dao.setVoto(voto);
            if (isCreate) {
                request.getRequestDispatcher("Partidos.jsp").forward(request, response);
            }
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
