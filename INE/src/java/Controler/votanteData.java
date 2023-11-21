package Controler;

import Model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "votanteData", urlPatterns = {"/votanteData"})
public class votanteData extends HttpServlet {

    Votante votante = new Votante();
    DaoUsuario dao = new DaoUsuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String vName = request.getParameter("vName");
        String vLastName = request.getParameter("vLastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String birthday = request.getParameter("birthday");
        int idAdmin = Integer.parseInt(String.valueOf(request.getSession().getAttribute("id_admin")));
        // asigna los parametros recuperados a los setters de la clase Votante
        votante.setvName(vName);
        votante.setvLastName(vLastName);
        votante.setvAge(age);
        votante.setvBirthday(birthday);
        votante.setIdAdmin(idAdmin);
        int nV = Integer.parseInt(String.valueOf(request.getSession().getAttribute("tVotantes")));
        if (nV == 0) {
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } else {
            //            si no ha llegado a 0, comparamos que la edad sea mayor a 18
            if (age < 18) {
                request.setAttribute("ageError", "Something went wrong: <br> El votante debe ser mayor de 18 años");
                request.getRequestDispatcher("Registrar.jsp").forward(request, response);
            } else {
//                si la edad es mayor de 18 años, intenta crear el registro
                boolean isCreate = dao.createVotante(votante);
//                si se creo bien...
                if (isCreate) {
                    nV-=1;
                    request.getSession().setAttribute("tVotantes", nV);
                    request.getRequestDispatcher("Registrar.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
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
