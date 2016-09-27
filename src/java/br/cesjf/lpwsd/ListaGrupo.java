package br.cesjf.lpwsd;

import br.cesjf.lpwsd.dao.AlunoJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "ListaGrupo", urlPatterns = {"/listagrupo.html"})
public class ListaGrupo extends HttpServlet {

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

        RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/ListaGrupo.jsp");

        //lista filtros 
        EntityManager em = emf.createEntityManager();
        List<Aluno> x = em.createQuery("SELECT DISTINCT(a.codGrupo) FROM Aluno a").getResultList();
        System.out.println(x);

        request.setAttribute("grupos", x);
        
        String CodGrups = request.getParameter("codgrupo");
         System.out.println("z: " +CodGrups);
        //lista alunos com grupos
       if ( CodGrups == null || CodGrups == "" || Integer.parseInt(CodGrups) == 9) {
            AlunoJpaController DaoAluno = new AlunoJpaController(ut, emf);

            List<Aluno> rs = DaoAluno.findAlunoEntities();
            System.out.println(rs);

            request.setAttribute("alunos", rs);
            
              List<Historico> pontos = em.createNativeQuery("SELECT SUM(h.ponto) as x FROM Historico h JOIN Aluno a ON h.ALUNO_CODALUNO = a.CODALUNO").getResultList();
            System.out.println("pontos" + pontos);
            request.setAttribute("pontos", pontos);
       } else if(CodGrups != "") {
           List<Aluno> filtro = em.createQuery("SELECT a FROM Aluno a WHERE a.codGrupo =" + request.getParameter("codgrupo")).getResultList();
           System.out.println(filtro);
                                   
            request.setAttribute("alunos", filtro);
            
            List<Historico> pontos = em.createNativeQuery("SELECT SUM(h.ponto) as x FROM Historico h JOIN Aluno a ON h.ALUNO_CODALUNO = a.CODALUNO  WHERE a.CODGRUPO =" + request.getParameter("codgrupo")).getResultList();
            System.out.println("pontos" + pontos);
            request.setAttribute("pontos", pontos);
       }

        //
        dispachante.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int G = Integer.parseInt(request.getParameter("kaka"));
        System.out.println(G);
        response.sendRedirect("listagrupo.html?codgrupo=" + G);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
