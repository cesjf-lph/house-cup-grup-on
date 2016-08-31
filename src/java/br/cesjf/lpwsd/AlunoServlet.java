package br.cesjf.lpwsd;


import br.cesjf.lpwsd.dao.AlunoJpaController;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "AlunoServlet", urlPatterns = {"/NovoAluno.html"})
public class AlunoServlet extends HttpServlet {

    @PersistenceUnit(unitName = "WebD_1-pu")
    EntityManagerFactory emf;
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    /**
     * model view controler
     *
     * mvc dao - html/jsp - servelet
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/NovoAluno.jsp");
        dispachante.forward(request, response);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        Aluno aluno = new Aluno();
        aluno.setNomeAluno(nome);

        AlunoJpaController dao = new  AlunoJpaController(ut, emf);
        try {
            dao.create(aluno);
        } catch (Exception ex) {
            Logger.getLogger(NovoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        response.sendRedirect("listaaluno.html");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
