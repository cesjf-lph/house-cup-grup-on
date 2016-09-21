package br.cesjf.lpwsd;

import java.util.Date;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Historico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long codHistorico;
    private Date data;
    private int ponto;
    private String descricao;
    private Aluno aluno;
    private Professor professor;

    public Historico() {
    }

    public long getCodHistorico() {
        return codHistorico;
    }

    public void setCodHistorico(long codHistorico) {
        this.codHistorico = codHistorico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPonto() {
        return ponto;
    }

    public void setPonto(int ponto) {
        this.ponto = ponto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

   
  
}
