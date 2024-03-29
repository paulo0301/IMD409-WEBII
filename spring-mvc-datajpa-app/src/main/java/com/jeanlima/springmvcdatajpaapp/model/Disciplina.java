package com.jeanlima.springmvcdatajpaapp.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 7)
    private String codigo;

    @Column(length = 70)
    private String nome;

    @Column(length = 250)
    private String ementa;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE})
    @JoinTable(name="disciplina_curso",
    joinColumns=@JoinColumn(name="disciplina_id"), 
    inverseJoinColumns=@JoinColumn(name="curso_id"))
    private List<Curso> cursos;

    public Disciplina() {
    }

    public Disciplina(Integer id, String codigo, String nome, String ementa) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.ementa = ementa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disciplina that = (Disciplina) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(codigo, that.codigo)) return false;
        if (!Objects.equals(nome, that.nome)) return false;
        if (!Objects.equals(ementa, that.ementa)) return false;
        return Objects.equals(cursos, that.cursos);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (ementa != null ? ementa.hashCode() : 0);
        result = 31 * result + (cursos != null ? cursos.hashCode() : 0);
        return result;
    }
}
