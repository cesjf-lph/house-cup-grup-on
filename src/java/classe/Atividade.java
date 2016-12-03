package classe;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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

    //public List<Atividade> ListaTodos() {
       // AtividadeJpaController atividadeDao = new AtividadeJpaController(ut, emf);
       // List<Atividade> Lista = atividadeDao.findAtividadeEntities();
        //return Lista;
    //}

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

    @Override
    public String toString() {
        return this.nomeAtividade; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idAtividade);
        hash = 61 * hash + Objects.hashCode(this.nomeAtividade);
        hash = 61 * hash + (this.sitAtividade ? 1 : 0);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
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
        final Atividade other = (Atividade) obj;
        if (this.sitAtividade != other.sitAtividade) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.nomeAtividade, other.nomeAtividade)) {
            return false;
        }
        if (!Objects.equals(this.idAtividade, other.idAtividade)) {
            return false;
        }
        return true;
    }


    
    

}
