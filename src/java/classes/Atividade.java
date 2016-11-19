package classes;

import dao.AtividadeJpaController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

@Entity
public class Atividade implements Serializable {

    @PersistenceUnit(unitName = "GroupOn-pu")
    EntityManagerFactory emf;
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAtividade;
    private String nomeAtividade;
    private boolean sitAtividade;
    private double valor;

    public Atividade() {
        idAtividade = null;
        nomeAtividade = "";
        sitAtividade = false;
    }

    public List<Atividade> ListaTodos() {
        AtividadeJpaController atividadeDao = new AtividadeJpaController(ut, emf);
        List<Atividade> Lista = atividadeDao.findAtividadeEntities();
        return Lista;
    }

    public Long getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Long idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public boolean isSitAtividade() {
        return sitAtividade;
    }

    public void setSitAtividade(boolean sitAtividade) {
        this.sitAtividade = sitAtividade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
