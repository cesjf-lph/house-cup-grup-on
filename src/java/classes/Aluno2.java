package classes;



import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno2 implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idAluno;
    private String nomeAluno;
    private ArrayList<Atividade> listaAtividades;

    public Aluno2() {
    }

    public long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public ArrayList<Atividade> getListaAtividades() {
        return listaAtividades;
    }

    public void setListaAtividades(ArrayList<Atividade> listaAtividades) {
        this.listaAtividades = listaAtividades;
    }

    
    
    
    
    
    
}
