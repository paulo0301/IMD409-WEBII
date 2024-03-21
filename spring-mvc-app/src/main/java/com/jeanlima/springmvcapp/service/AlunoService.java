package com.jeanlima.springmvcapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jeanlima.springmvcapp.model.Aluno;

@Service
public interface AlunoService {

    public void salvarAluno(Aluno aluno);
    public void deletarAluno(Aluno aluno);
    public Aluno getAlunoById(String id);
    public List<Aluno> getListaAluno();
    public List<List<Aluno>> getListaAlunoByCurso();
    public List<List<Aluno>> getListaAlunoByLingProg();
    public List<List<Aluno>> getListaAlunoBySistOper();
}
