
package classes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AtividadeTest {
    
    public AtividadeTest() {
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

    
    /*@Test
    public void testListaTodos(){
       System.out.println("ListaTodos");
       Atividade instance = new Atividade();
       
       
    } */
    
    @Test
    public void testGetIdAtividade() {
        System.out.println("getIdAtividade");
        Atividade instance = new Atividade();
        assertNull(instance.getIdAtividade());
       
    }

    
    @Test
    public void testSetIdAtividade() {
        System.out.println("setIdAtividade");
        long idAtividade = 0L;
        Atividade instance = new Atividade();
        instance.setIdAtividade(idAtividade);
        
    }

    
    @Test
    public void testGetNomeAtividade() {
        System.out.println("getNomeAtividade");
        Atividade instance = new Atividade();
        String expResult = "";
        String result = instance.getNomeAtividade();
        assertEquals(expResult, result);

    }

   
    @Test
    public void testSetNomeAtividade() {
        System.out.println("setNomeAtividade");
        String nomeAtividade = "";
        Atividade instance = new Atividade();
        instance.setNomeAtividade(nomeAtividade);

    }

    
    @Test
    public void testIsSitAtividade() {
        System.out.println("isSitAtividade");
        Atividade instance = new Atividade();
        boolean expResult = false;
        boolean result = instance.isSitAtividade();
        assertEquals(expResult, result);

    }

    
    @Test
    public void testSetSitAtividade() {
        System.out.println("setSitAtividade");
        boolean sitAtividade = false;
        Atividade instance = new Atividade();
        instance.setSitAtividade(sitAtividade);

    }
    
}
