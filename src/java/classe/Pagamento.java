package classe;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long idPagamento;
    private Aluno2 aluno;
    private Atividade atividade;
    private double valor;
    private boolean pago;

    public Pagamento() {
        aluno = new Aluno2();
        atividade = new Atividade();
        valor = 0f;
        pago = false;
    }

    public Aluno2 getAluno() {
        return aluno;
    }

    public void setAluno(Aluno2 aluno) {
        this.aluno = aluno;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public double aumentaPorcentagem(double x) {
        if (x != 0) {
            x = (x * 150)/100;
        }
        return x;
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

}
