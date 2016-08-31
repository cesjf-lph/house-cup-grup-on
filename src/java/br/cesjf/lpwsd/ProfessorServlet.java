package br.cesjf.lpwsd;

import br.cesjf.lpwsd.dao.ProfessorJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "ProfessorServlet", urlPatterns = {"/NovoProfessor.html"})
public class ProfessorServlet extends HttpServlet {

    @PersistenceUnit(unitName = "WebD_1-pu")
    EntityManagerFactory emf;
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/NovoProfessor.jsp");
        dispachante.forward(request, response);
     
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        Professor professor = new Professor();
        professor.setNomeProfessor(nome);

        ProfessorJpaController dao = new ProfessorJpaController(ut, emf);
        try {
            dao.create(professor);
        } catch (Exception ex) {
            Logger.getLogger(NovoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        response.sendRedirect("listaprof.html");
     //response.sendRedirect("/listaprof.html");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
