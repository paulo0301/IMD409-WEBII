package com.jeanlima.springmvcdatajpaapp.controller;

import com.jeanlima.springmvcdatajpaapp.model.Aluno;
import com.jeanlima.springmvcdatajpaapp.model.Curso;
import com.jeanlima.springmvcdatajpaapp.model.Disciplina;
import com.jeanlima.springmvcdatajpaapp.service.CursoService;
import com.jeanlima.springmvcdatajpaapp.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @Autowired
    CursoService cursoService;

    @RequestMapping("/showForm")
    public String showFormDisciplina(Model model){

        Disciplina disciplina = new Disciplina();
        List<Curso> cursos = new ArrayList<>();
        disciplina.setCursos(cursos);


        model.addAttribute("disciplina", disciplina);
        model.addAttribute("cursos", cursoService.getCursos());
        return "disciplina/formDisciplina";
    }

    @RequestMapping("/addDisciplina")
    public String showFormAluno(@ModelAttribute("disciplina") Disciplina disciplina, RedirectAttributes redirectAttributes){

        disciplinaService.salvarDisciplina(disciplina);

        redirectAttributes.addFlashAttribute("successMessage", "Aluno adicionado");
        return "redirect:/disciplina/getListaDisciplinas";
    }

    @RequestMapping("/getListaDisciplinas")
    public String showListaDisciplina(Model model){
        model.addAttribute("disciplinas", disciplinaService.getDisciplinas());
        return "disciplina/listaDisciplinas";
    }
}
