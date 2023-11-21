package Controler;

import Model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "totalVotantes", urlPatterns = {"/totalVotantes"})
public class totalVotantes extends HttpServlet {

    Admin admin = new Admin();
    DaoUsuario dao = new DaoUsuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id_admin = Integer.parseInt(String.valueOf(request.getSession().getAttribute("id_admin")));
        int canRegister = Integer.parseInt(dao.hasNVotanes(id_admin));
        if (canRegister != 0) {
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } else {
            int nV = Integer.parseInt(String.valueOf(request.getSession().getAttribute("tVotantes")));
            if (nV == 0) {
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            } else {
                int tV = Integer.parseInt(request.getParameter("n_votantes"));
                request.getSession().setAttribute("tVotantes", tV);
                admin.setNVotantes(tV);
                admin.setIdAdmin(id_admin);
                boolean isCreate = dao.insertNVotantes(admin);
                if (isCreate) {
                    request.getRequestDispatcher("Registrar.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Admin.jsp").forward(request, response);
                }
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
