package com.jeanlima.springmvcapp.service;

import com.jeanlima.springmvcapp.model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CursoService {
    public void salvarAluno(Curso curso);
    public Curso getCursoById(Integer id);
    public List<Curso> getListaCurso();
}
