/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aluno
 */
public class Aluno2Test {
    
    public Aluno2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdAluno method, of class Aluno2.
     */
    @Test
    public void testGetIdAluno() {
        System.out.println("getIdAluno");
        Aluno2 aluno = new Aluno2();
        assertEquals(null, aluno.getIdAluno());
    }

    /**
     * Test of setIdAluno method, of class Aluno2.
     */
    @Test
    public void testSetIdAluno() {
        System.out.println("setIdAluno");
        Aluno2 instance = new Aluno2();
        instance.setIdAluno(123L);
        assertEquals(123L, (long)instance.getIdAluno());
    }

    /**
     * Test of getNomeAluno method, of class Aluno2.
     */
    @Test
    public void testGetNomeAluno() {
        System.out.println("getNomeAluno");
        Aluno2 aluno = new Aluno2();
        assertEquals("", aluno.getNomeAluno());
    }

    /**
     * Test of setNomeAluno method, of class Aluno2.
     */
    @Test
    public void testSetNomeAluno() {
        System.out.println("setNomeAluno");
        String nomeAluno = "";
        Aluno2 instance = new Aluno2();
        instance.setNomeAluno(nomeAluno);
       
    }

    /**
     * Test of getListaAtividades method, of class Aluno2.
     */
    @Test
    public void testGetListaAtividades() {
        System.out.println("getListaAtividades");
        Aluno2 instance = new Aluno2();
        List<Atividade> expResult = new ArrayList<>();;
        List<Atividade> result = instance.getListaAtividades();
        assertEquals(expResult, result);

    }

    /**
     * Test of setListaAtividades method, of class Aluno2.
     */
    @Test
    public void testSetListaAtividades() {
        System.out.println("setListaAtividades");
        ArrayList<Atividade> listaAtividades = new ArrayList<>();
        Aluno2 instance = new Aluno2();
        instance.setListaAtividades(listaAtividades);
   
    }
    @Test
    public void testMatricula() {
        System.out.println("matricula");
        Aluno2 aluno = new Aluno2();
        Atividade atividade = new Atividade();
        aluno.matricula(atividade);
        assertTrue(aluno.getListaAtividades().contains(atividade));
    }
    @Test
    public void testMatriculaMensalidade() {
        System.out.println("matricula");
        Aluno2 aluno = new Aluno2();
        Atividade atividade = new Atividade();
        //assertEquals(0, aluno.getMensalidades().size());
        aluno.matricula(atividade);
        //assertEquals(1, aluno.getMensalidades().size());
    }
}
