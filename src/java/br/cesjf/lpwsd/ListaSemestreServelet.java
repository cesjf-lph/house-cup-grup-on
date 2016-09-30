package br.cesjf.lpwsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

@WebServlet(name = "ListaSemestreServelet", urlPatterns = {"/listasemestre.html"})
public class ListaSemestreServelet extends HttpServlet {

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
        RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/ListaSemestre.jsp");

        String Ano = request.getParameter("ano");
        String Semestre = request.getParameter("semestre");
        String where = "";

        List<Object[]> xis = new ArrayList<Object[]>();
        EntityManager em = emf.createEntityManager();
        xis = em.createNativeQuery("SELECT DISTINCT(a.CODGRUPO), SUM(h.PONTO) FROM Historico h JOIN Aluno a ON a.CODALUNO = h.ALUNO_CODALUNO GROUP BY a.CODGRUPO" + where).getResultList();

        String listagem = "";
        for (Object[] object : xis) {
            listagem += "Grupo: " + object[0] + " | Pontos " + object[1] + "<br>";

        }

        request.setAttribute("listagem", listagem);
        //
        dispachante.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ano = request.getParameter("ano");
        String semestre = request.getParameter("semestre");
        if (ano == null) {
            ano = "2016";
        }  else if(semestre == null) {
            semestre = "1";
        }
       
        response.sendRedirect("listasemestre.html?ano=" + ano + "&semestre=" + semestre);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
