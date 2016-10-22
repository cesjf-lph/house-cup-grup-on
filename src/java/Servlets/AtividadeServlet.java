
package Servlets;

import classes.Atividade;
import dao.AtividadeJpaController;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "AtividadeServlet", urlPatterns = {"/novaatividade.html"})
public class AtividadeServlet extends HttpServlet {
    
     @PersistenceUnit(unitName = "GroupOn-pu")
    EntityManagerFactory emf;
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher dispachante = request.getRequestDispatcher("/NovaAtividade.jsp");
         
           AtividadeJpaController atividadeDao = new AtividadeJpaController(ut, emf);
           
           List<Atividade> atividades = atividadeDao.findAtividadeEntities();
           System.out.println(atividades); 
          
          request.setAttribute("atividades", atividades);
         
        dispachante.forward(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recebe as strings
        String nome = request.getParameter("nome");
        String situacao = request.getParameter("situacao");
        //enche a classe
        Atividade obj1 = new Atividade();
        obj1.setNomeAtividade(nome);
        if("1".equals(situacao)){
        obj1.setSitAtividade(true);
        }else
        obj1.setSitAtividade(false);
      //envia para o bd  
        AtividadeJpaController atividadeDao = new AtividadeJpaController(ut, emf);
         try {
             atividadeDao.create(obj1);
         } catch (Exception ex) {
             Logger.getLogger(AtividadeServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
        response.sendRedirect("novaatividade.html");
    } 

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
