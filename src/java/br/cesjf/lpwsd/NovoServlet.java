/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd;

import br.cesjf.lpwsd.dao.PessoaJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@WebServlet(name = "NovoServlet", urlPatterns = {"/index.html"})
public class NovoServlet extends HttpServlet {
    @PersistenceUnit
     (unitName="WebD_1-pu")
   EntityManagerFactory emf;
   @Resource(name="java:comp/UserTransaction")
   UserTransaction ut;

  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
            
       Pessoa pessoa = new Pessoa();
         
        String nome = request.getParameter("nome") +"";
        int idade =  0;
        if(request.getParameter("idade") != null){
             idade = Integer.parseInt( request.getParameter("idade") + "");
        }
        String senha = request.getParameter("senha") + "";
        request.setAttribute("x", pessoa);
        pessoa.setNome(nome);
        pessoa.setIdade(idade);
     
        PessoaJpaController dao = new PessoaJpaController(ut, emf);
        try {
            dao.create(pessoa);
        } catch (Exception ex) {
            Logger.getLogger(NovoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if (senha!=null && senha.equals("1234")){
            RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/Oi.jsp");
        dispachante.forward(request, response);       
        }
        else{
            RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/AcessoProibido.html");
        dispachante.forward(request, response);
            
        }
        
       
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
