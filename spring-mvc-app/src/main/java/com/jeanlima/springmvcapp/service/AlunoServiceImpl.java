package com.jeanlima.springmvcapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.jeanlima.springmvcapp.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jeanlima.springmvcapp.model.Aluno;

@Component
public class AlunoServiceImpl implements  AlunoService{

    public List<Aluno> alunos = new ArrayList<Aluno>(
        List.of(
            new Aluno("Pedro", "Silva", new Curso("BTI"), "Java", new ArrayList<>(List.of("OSX", "Windows", "Linux")), "email1"),
            new Aluno("Gabriel", "Santos", new Curso("BTI"), "Javascript", new ArrayList<>(List.of("OSX", "Linux")),"email2"),
            new Aluno("Luiz", "Oliveira", new Curso("BTI"), "C++", new ArrayList<>(List.of("Windows", "Linux")),"email3"),
            new Aluno("Fernanda", "Souza", new Curso("BTI"), "Python", new ArrayList<>(List.of("OSX", "Windows", "Linux")),"amail4"),
            new Aluno("Camila", "Pereira", new Curso("BTI"), "Java", new ArrayList<>(List.of("OSX", "Linux")),"email5"),
            new Aluno("Mariana", "Ferreira", new Curso("EngSoft"), "Javascript", new ArrayList<>(List.of("Windows", "Linux")),"email6"),
            new Aluno("Rafael", "Almeida", new Curso("EngSoft"), "C++", new ArrayList<>(List.of("OSX", "Windows")),"email7"),
            new Aluno("Juliana", "Rocha", new Curso("EngComp"), "Python", new ArrayList<>(List.of("Windows", "Linux")),"email8"),
            new Aluno("Lucas", "Martins", new Curso("EngComp"), "Java", new ArrayList<>(List.of("OSX", "Linux")),"email9"),
            new Aluno("Gustavo", "Gomes", new Curso("EngComp"), "Javascript", new ArrayList<>(List.of("OSX", "Windows")),"email10"),
            new Aluno("Amanda", "Almeida", new Curso("EngSoft"), "C++", new ArrayList<>(List.of("Windows", "Linux")),"email11"),
            new Aluno("Carla", "Rocha", new Curso("EngSoft"), "Python", new ArrayList<>(List.of("OSX", "Linux")),"email12"),
            new Aluno("Vinicius", "Martins", new Curso("EngComp"), "Java", new ArrayList<>(List.of("OSX", "Windows")),"email13"),
            new Aluno("Thiago", "Gomes", new Curso("EngComp"), "Javascript", new ArrayList<>(List.of("OSX", "Linux")),"email14"),
            new Aluno("Ana", "Almeida", new Curso("EngSoft"), "Python", new ArrayList<>(List.of("Windows", "Linux")),"email15")
        )
    );

    @Autowired
    MockDataService mockDataService;

    @Autowired
    @Qualifier("cursoServiceImpl")
    CursoService cursoService;

    @Override
    public void salvarAluno(Aluno aluno) {
        System.out.println(aluno.toString());
        try{
            this.alunos.add(aluno);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    @Override
    public void deletarAluno(Aluno aluno) {
       this.alunos.remove(aluno);
    }

    @Override
    public Aluno getAlunoById(String id) {
        for (Aluno aluno : alunos) {
            if(aluno.getId().equals(id)){
                return aluno;
            }
        }
        return null;
    }

    @Override
    public List<Aluno> getListaAluno() {
        return this.alunos;
    }

    @Override
    public List<List<Aluno>> getListaAlunoByCurso() {
        List<List<Aluno>> listas = new ArrayList<>();

        for (Curso curso : cursoService.getListaCurso()) {
            List<Aluno> listaAlunos = new ArrayList<>();
            for (Aluno aluno : alunos) {
                if(aluno.getCurso().equals(curso)){
                    listaAlunos.add(aluno);
                }
            }
            if(!listaAlunos.isEmpty()) listas.add(listaAlunos);
        }

        return listas;
    }

    @Override
    public List<List<Aluno>> getListaAlunoByLingProg() {
        List<List<Aluno>> listas = new ArrayList<>();

        for (String linguagem : mockDataService.getLinguagens()) {
            List<Aluno> listaAlunos = new ArrayList<>();
            for (Aluno aluno : alunos) {
                if(aluno.getLinguagem().equals(linguagem)){
                    listaAlunos.add(aluno);
                }
            }
            if(!listaAlunos.isEmpty()) listas.add(listaAlunos);
        }

        return listas;
    }

    @Override
    public List<List<Aluno>> getListaAlunoBySistOper() {
        List<List<Aluno>> listas = new ArrayList<>();

        for (String sistema : mockDataService.getSistemasOperacionais()) {
            List<Aluno> listaAlunos = new ArrayList<>();
            for (Aluno aluno : alunos) {
                for(String sistAluno : aluno.getSistemasOperacionas()){
                    if(sistAluno.equals(sistema)){
                        listaAlunos.add(aluno);
                    }
                }
            }
            listas.add(listaAlunos);
        }

        return listas;
    }

}
