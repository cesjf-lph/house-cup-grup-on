package br.cesjf.lpwsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TemporalType;
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
        if (Ano == null) {
            Ano = "2016";
        } else if (Semestre == null) {
                         Semestre = "1";
            System.out.println("caiui aq"+Semestre);
        }
        Date datai;
        Date dataf;
        try {
         
            if (Semestre == "2") {
                datai = DateFormat.getDateInstance().parse("01/06/" + Ano);
            } else {
                datai = DateFormat.getDateInstance().parse("01/01/" + Ano);
            }
                Calendar c = Calendar.getInstance();
                c.setTime(datai);
                c.add(Calendar.MONTH, 6);
                dataf = c.getTime();

            List<Object[]> xis = new ArrayList<Object[]>();
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT h.aluno.codGrupo, SUM(h.ponto) FROM Historico h  WHERE h.data BETWEEN ?1 AND ?2 GROUP BY h.aluno.codGrupo");
            q.setParameter(1, datai, TemporalType.DATE);
            q.setParameter(2, dataf, TemporalType.DATE);
            xis = q.getResultList();
            System.out.println("datai: " + datai);
            System.out.println("dataf: " + dataf);
            String listagem = "";
            for (Object[] object : xis) {
                listagem += "Grupo: " + object[0] + " | Pontos " + object[1] + "<br>";

            }

            request.setAttribute("listagem", listagem);
            //
            dispachante.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ListaSemestreServelet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ano = request.getParameter("ano");
        String semestre = request.getParameter("semestre");
        if (ano == null) {
            ano = "2016";
        } else if (semestre == null) {
            semestre = "1";
        }
        response.sendRedirect("listasemestre.html?ano=" + ano + "&semestre=" + semestre);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
