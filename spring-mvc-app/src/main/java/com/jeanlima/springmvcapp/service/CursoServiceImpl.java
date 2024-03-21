package com.jeanlima.springmvcapp.service;

import com.jeanlima.springmvcapp.model.Curso;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CursoServiceImpl implements CursoService{
    private List<Curso> cursoList = new ArrayList<>(
            List.of(
                    new Curso("BTI"),
                    new Curso("EngComp"),
                    new Curso("EngSoft")
            )
    );


    @Override
    public void salvarAluno(Curso curso) {
        System.out.println(curso.toString());
        try{
            this.cursoList.add(curso);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    @Override
    public Curso getCursoById(Integer id) {
        for (Curso curso : cursoList) {
            if(Objects.equals(curso.getId(), id)){
                return curso;
            }
        }
        return null;
    }

    @Override
    public List<Curso> getListaCurso() {
        return cursoList;
    }
}
