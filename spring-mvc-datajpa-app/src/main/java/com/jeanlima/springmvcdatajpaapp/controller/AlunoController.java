package com.jeanlima.springmvcdatajpaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers.IntegerSerializer;
import com.jeanlima.springmvcdatajpaapp.model.Aluno;
import com.jeanlima.springmvcdatajpaapp.model.Curso;
import com.jeanlima.springmvcdatajpaapp.model.Disciplina;
import com.jeanlima.springmvcdatajpaapp.service.AlunoService;
import com.jeanlima.springmvcdatajpaapp.service.CursoService;
import com.jeanlima.springmvcdatajpaapp.service.DisciplinaService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/aluno")
public class AlunoController {


    @Autowired
    @Qualifier("alunoServiceImpl")
    AlunoService alunoService;

    @Autowired
    CursoService cursoService;

//    @Autowired
//    DisciplinaService disciplinaService;


    @RequestMapping("/showForm")
    public String showFormAluno(Model model){

        model.addAttribute("aluno", new Aluno());
        model.addAttribute("cursos", cursoService.getCursos());
        return "aluno/formAluno";
    }

    @RequestMapping("/addAluno")
    public String showFormAluno(@ModelAttribute("aluno") Aluno aluno, RedirectAttributes redirectAttributes){

        Curso cursoSelecionado = cursoService.getCursoById(aluno.getCurso().getId());
        aluno.setCurso(cursoSelecionado);

        alunoService.salvarAluno(aluno);

        redirectAttributes.addFlashAttribute("successMessage", "Aluno adicionado");
        return "redirect:/aluno/getListaAlunos";
    }

    @RequestMapping("/getListaAlunos")
    public String showListaAluno(Model model){

        List<Aluno> alunos = alunoService.getListaAluno();
        model.addAttribute("alunos",alunos);
        return "aluno/listaAlunos";
    }

    @RequestMapping("/removeAluno/{id}")
    public String removeAluno(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        alunoService.deletarAluno(alunoService.getAlunoById(id));

        redirectAttributes.addFlashAttribute("successMessage", "Aluno removido");
        return "redirect:/aluno/getListaAlunos";
    }
    
}
