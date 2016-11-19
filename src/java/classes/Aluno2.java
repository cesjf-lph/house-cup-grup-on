package classes;

import dao.AtividadeJpaController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

@Entity
public class Aluno2 implements Serializable {

    @PersistenceUnit(unitName = "GroupOn-pu")
    EntityManagerFactory emf;
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAluno;
    private String nomeAluno;
    private List<Atividade> listaAtividades;
    private List<Pagamento> listaPagamentos;

    public Aluno2() {
        idAluno = null;
        nomeAluno = "";
        listaAtividades = new ArrayList<>();
        listaPagamentos = new ArrayList<>();
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public List<Atividade> getListaAtividades() {

        return this.listaAtividades;
    }

    public void setListaAtividades(List<Atividade> listaAtividades) {
        this.listaAtividades = listaAtividades;
    }
    
     public List<Pagamento> getListaPagamentos() {
        return listaPagamentos;
    }

    public void setListaPagamentos(List<Pagamento> listaPagamentos) {
        this.listaPagamentos = listaPagamentos;
    }

    public void matricula(Atividade atividade) {
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(atividade.getValor() + pagamento.aumentaPorcentagem(atividade.getValor()));
        this.listaPagamentos.add(pagamento);
        this.listaAtividades.add(atividade);
    }

    public List<Pagamento> getPagamentos() {
        List<Pagamento> Pagamentos = this.listaPagamentos;
        return Pagamentos;
    }

}
