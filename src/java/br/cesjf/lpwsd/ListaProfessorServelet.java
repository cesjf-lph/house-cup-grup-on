package br.cesjf.lpwsd;

import br.cesjf.lpwsd.Professor;
import br.cesjf.lpwsd.dao.ProfessorJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

@WebServlet(urlPatterns = {"/listaprof.html"})
public class ListaProfessorServelet extends HttpServlet {

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

      
        RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/ListaProfs.jsp");
        
        ProfessorJpaController DaoProf = new ProfessorJpaController(ut, emf);

        List<Professor> rs = DaoProf.findProfessorEntities();
        System.out.println(rs); 

        request.setAttribute("professores", rs);
        
        dispachante.forward(request, response);
         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
