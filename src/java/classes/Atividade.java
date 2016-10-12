package classes;


import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Atividade implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) 
    private long idAtividade;
    private String nomeAtividade;
    private boolean sitAtividade;

    public Atividade() {
    }

    public long getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(long idAtividade) {
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
    
    
    
    
    
    
    
}
