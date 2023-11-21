package Controler;
import Model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "validVotante", urlPatterns = {"/validVotante"})
public class validVotante extends HttpServlet {

    Votante votante = new Votante();
    DaoUsuario dao = new DaoUsuario();
    int attempts;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//            recupero los datos
        int idVotante = Integer.parseInt(request.getParameter("idVotante")); 
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("fechaNacimiento");
        votante.setIdVotante(idVotante);
        votante.setvName(name);
        votante.setvLastName(lastName);
        votante.setvBirthday(birthDay);
        attempts = dao.validVotante(votante);
        if (attempts == 5) {
            request.getSession().setAttribute("votanteName", name);
            request.getSession().setAttribute("id_votante", idVotante);
            request.getRequestDispatcher("Partidos.jsp").forward(request, response);
        } else {
            if (attempts == 0) {
                System.exit(0);
            }
            request.getSession().setAttribute("attempts", attempts);
            request.getRequestDispatcher("Votante.jsp").forward(request, response);
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
