package servlet;

import Banque.Finance;
import banque_dotnet.DotNetWebServiceClient;
import foncier_java.EJBFoncierClient;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import objets.Citoyen;
import objets.Foncier;
//import objets.Foncier;
import objets.Sante;
import sante_java.EJBSanteClient;

public class ConsultationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String cin = request.getParameter("CIN");
            
            EJBSanteClient eJBSanteClient = new EJBSanteClient();
            EJBFoncierClient eJBFoncierClient = new EJBFoncierClient();
            Citoyen citoyen = eJBSanteClient.getCitoyenByCINWithoutConsultation(cin);
            Sante sante = eJBSanteClient.consulteSante(citoyen.getIdCIN());
            Foncier foncier = eJBFoncierClient.consulteFoncier(citoyen.getIdCIN());
            Finance finance = DotNetWebServiceClient.consulteFinance(cin);
            
            citoyen.setSante(sante);
            citoyen.setFoncier(foncier);
            citoyen.setFinance(finance);
            
            request.setAttribute("citoyen", citoyen);
            RequestDispatcher dispatch = request.getRequestDispatcher("result.jsp");
            dispatch.forward(request, response);

//            out.print("Citoyen "+  citoyen);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ConsultationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ConsultationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
