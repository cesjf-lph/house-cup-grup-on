


import classe.Aluno2;
import classe.Atividade;
import classe.Pagamento;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PagamentoTest {
    
    public PagamentoTest() {
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

   
    @Test
    public void testGetAluno() {
        System.out.println("getAluno");
        Pagamento instance = new Pagamento();
        //Aluno2 expResult = new Aluno2();
        Aluno2 result = instance.getAluno();
        //assertEquals(expResult, result);
        assertNotNull(result);
     
    }

   
    @Test
    public void testSetAluno() {
        System.out.println("setAluno");
        Aluno2 aluno = null;
        Pagamento instance = new Pagamento();
        instance.setAluno(aluno);
      
    }

    
    @Test
    public void testGetAtividade() {
        System.out.println("getAtividade");
        Pagamento instance = new Pagamento();
       // Atividade expResult = new Atividade();
        Atividade result = instance.getAtividade();
        //assertEquals(expResult, result);
        assertNotNull(result);
    }

    
    @Test
    public void testSetAtividade() {
        System.out.println("setAtividade");
        Atividade atividade = null;
        Pagamento instance = new Pagamento();
        instance.setAtividade(atividade);

    }

    @Test
    public void testGetValor() {
        System.out.println("getValor");
        Pagamento instance = new Pagamento();
        double expResult = 0.0;
        double result = instance.getValor();
        assertEquals(expResult, result, 0.0);

    }

    @Test
    public void testSetValor() {
        System.out.println("setValor");
        double valor = 0.0;
        Pagamento instance = new Pagamento();
        instance.setValor(valor);

    }

 
    @Test
    public void testIsPago() {
        System.out.println("isPago");
        Pagamento instance = new Pagamento();
        boolean expResult = false;
        boolean result = instance.isPago();
        assertEquals(expResult, result);
     
    }


    @Test
    public void testSetPago() {
        System.out.println("setPago");
        boolean pago = false;
        Pagamento instance = new Pagamento();
        instance.setPago(pago);
     
    }
    
}
