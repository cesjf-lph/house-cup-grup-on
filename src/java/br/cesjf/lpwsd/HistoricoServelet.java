package br.cesjf.lpwsd;

import br.cesjf.lpwsd.dao.AlunoJpaController;
import br.cesjf.lpwsd.dao.HistoricoJpaController;
import br.cesjf.lpwsd.dao.ProfessorJpaController;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "HistoricoServelet", urlPatterns = {"/historico.html"})
public class HistoricoServelet extends HttpServlet {

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
        //###### LISTA ALUNOS
        RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/Historico.jsp");

        AlunoJpaController DaoAluno = new AlunoJpaController(ut, emf);

        List<Aluno> rs = DaoAluno.findAlunoEntities();
        System.out.println(rs);

        request.setAttribute("alunos", rs);

        //###### LISTA PROFESSORES
        ProfessorJpaController DaoProf = new ProfessorJpaController(ut, emf);

        List<Professor> rs2 = DaoProf.findProfessorEntities();
        System.out.println(rs2);

        request.setAttribute("professores", rs2);

        //####### LISTA HISTORICO
        HistoricoJpaController DaoHistorico = new HistoricoJpaController(ut, emf);
        List<Historico> rs3 = DaoHistorico.findHistoricoEntities();
        System.out.println(rs3);

        request.setAttribute("historicos", rs3);

        //##### 
        /* try {
         EntityManager em = emf.createEntityManager();
            List<Object[]> l = em.createQuery("").getResultList();
        
            String grupo = (String) object[0];
            Integer total = (Integer) object[1];
         
         em.close();
      } catch (Exception e) {
        System.err.println("Erro:" + e);
      }*/
        dispachante.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vDescricao = request.getParameter("txtDescricao");
        int vNota = Integer.parseInt(request.getParameter("txtNota"));
        int codAluno = Integer.parseInt(request.getParameter("aluno"));
        int codProfessor = Integer.parseInt(request.getParameter("professor"));

        Historico historico = new Historico();
        //
        Aluno aluno = new Aluno();
        aluno.setCodAluno(codAluno);
        //
        Professor professor = new Professor();
        professor.setCodProfessor(codProfessor);
            
        historico.setDescricao(vDescricao);
        historico.setPonto(vNota);
        historico.setAluno(aluno);
        historico.setProfessor(professor);
        Date d = new Date();
        historico.setData(d);

        HistoricoJpaController dao = new HistoricoJpaController(ut, emf);
        try {
            dao.create(historico);
        } catch (Exception ex) {
            Logger.getLogger(NovoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("historico.html");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
