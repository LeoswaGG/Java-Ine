package Controler;

import Model.Admin;
import Model.DaoUsuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "validSession", urlPatterns = {"/validSession"})
public class validSession extends HttpServlet {

    Admin admin = new Admin();
    DaoUsuario dao = new DaoUsuario();
    int attempts;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userName = request.getParameter("userName");
        String adminPassword = request.getParameter("adminPassword");
        admin.setUserName(userName);
        admin.setPasswordAdmin(adminPassword);
        attempts = dao.validAdmin(admin);
        int idAdmin = admin.getIdAdmin();
        if (attempts == 5) {
            request.getSession().setAttribute("tVotantes", 1);
            request.getSession().setAttribute("name", userName);
            request.getSession().setAttribute("id_admin", idAdmin);
            request.getRequestDispatcher("Admin.jsp").forward(request, response);
        } else {
            if(attempts == 0) {
                System.exit(0);
            }
            request.getSession().setAttribute("attempts", attempts);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
