package classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

@Entity
public class Aluno2 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAluno;
    private String nomeAluno;
    @OneToMany
    private List<Atividade> listaAtividades;
    @OneToMany
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

    public double getTotalPagamentos() {
        List<Pagamento> Pagamentos = getPagamentos();
        double total = 0;
        for (int j = 0; j < Pagamentos.size(); j++) {
            if (Pagamentos.get(j).isPago() != true) {
                total += Pagamentos.get(j).getValor();
            }
        }
        return total;
    }
     public List<Pagamento> getPagamentos() {
        List<Pagamento> Pagamentos = this.listaPagamentos;
        return Pagamentos;
    }

    @Override
    public String toString() {
        return this.nomeAluno; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idAluno);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno2 other = (Aluno2) obj;
        if (!Objects.equals(this.idAluno, other.idAluno)) {
            return false;
        }
        return true;
    }

}
