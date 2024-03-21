package com.jeanlima.springmvcapp.controller;

import com.jeanlima.springmvcapp.model.Curso;
import com.jeanlima.springmvcapp.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    @Qualifier("cursoServiceImpl")
    CursoService cursoService;

    @RequestMapping("/showForm")
    public String showFormCurso(Model model){
        model.addAttribute("curso", new Curso());

        return "curso/formCurso";
    }

    @RequestMapping("/addCurso")
    public String showFormAluno(@ModelAttribute("curso") Curso curso, Model model){

        cursoService.salvarAluno(curso);
        model.addAttribute("curso", curso);
        return "curso/paginaCurso";
    }

    @RequestMapping("/getListaCursos")
    public String showListaCurso(Model model){
        List<Curso> cursos = cursoService.getListaCurso();
        model.addAttribute("cursos", cursos);
        return "curso/listaCursos";
    }
}
