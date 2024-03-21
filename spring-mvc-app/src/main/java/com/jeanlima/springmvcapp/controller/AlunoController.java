package com.jeanlima.springmvcapp.controller;

import java.util.List;

import com.jeanlima.springmvcapp.service.CursoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeanlima.springmvcapp.model.Aluno;
import com.jeanlima.springmvcapp.service.AlunoService;
import com.jeanlima.springmvcapp.service.MockDataService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/aluno")
public class AlunoController {


    @Autowired
    @Qualifier("alunoServiceImpl")
    AlunoService alunoService;

    @Autowired
    MockDataService mockDataService;

    @Autowired
    @Qualifier("cursoServiceImpl")
    CursoService cursoService;


    @RequestMapping("/showForm")
    public String showFormAluno(Model model){

        model.addAttribute("aluno", new Aluno());
        model.addAttribute("cursos", cursoService.getListaCurso());
        model.addAttribute("sistemasOperacionais", mockDataService.getSistemasOperacionais());
        model.addAttribute("linguagens", mockDataService.getLinguagens());
        return "aluno/formAluno";
    }

    @RequestMapping("/addAluno")
    public String showFormAluno(@ModelAttribute("aluno") Aluno aluno,  Model model){

        alunoService.salvarAluno(aluno);
        model.addAttribute("aluno", aluno);
        return "aluno/paginaAluno";
    }

    @RequestMapping("/detalhesAluno/{aluno_id}")
    public String showDetalhesAluno(@PathVariable("aluno_id") String id, Model model){
        model.addAttribute("aluno", alunoService.getAlunoById(id));
        return "aluno/paginaAluno";
    }

    @RequestMapping("/removeAluno/{aluno_id}")
    public String removeAluno(@PathVariable("aluno_id") String id, Model model, RedirectAttributes redirectAttributes){
        alunoService.deletarAluno(alunoService.getAlunoById(id));
        redirectAttributes.addFlashAttribute("successMessage", "Aluno removido");
        return "redirect:/aluno/getListaAlunos";
    }

    @RequestMapping("/getListaAlunos")
    public String showListaAluno(Model model){

        List<Aluno> alunos = alunoService.getListaAluno();
        model.addAttribute("alunos",alunos);
        return "aluno/listaAlunos";

    }

    @RequestMapping("/getListaAlunoByCurso")
    public String showListaAlunoByCurso(Model model){
        model.addAttribute("listas", alunoService.getListaAlunoByCurso());
        return "aluno/listaAlunosPorCurso";
    }

    @RequestMapping("/getListaAlunoByLinguagem")
    public String showListaAlunoByLinguagem(Model model){
        model.addAttribute("listas", alunoService.getListaAlunoByLingProg());
        return "aluno/listaAlunosPorLinguagem";
    }

    @RequestMapping("/getListaAlunoBySistemaOp")
    public String showListaAlunoBySistemaOp(Model model){
        model.addAttribute("sistemas", mockDataService.getSistemasOperacionais());
        model.addAttribute("listas", alunoService.getListaAlunoBySistOper());
        return "aluno/listaAlunosPorSistemaOp";
    }
}
