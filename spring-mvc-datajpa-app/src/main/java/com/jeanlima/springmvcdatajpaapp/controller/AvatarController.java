package com.jeanlima.springmvcdatajpaapp.controller;

import com.jeanlima.springmvcdatajpaapp.model.Aluno;
import com.jeanlima.springmvcdatajpaapp.model.Avatar;
import com.jeanlima.springmvcdatajpaapp.service.AlunoService;
import com.jeanlima.springmvcdatajpaapp.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/avatar")
public class AvatarController {

    @Autowired
    AvatarService avatarService;

    @Autowired
    AlunoService alunoService;

    @RequestMapping("/showForm")
    public String showFormAvatar(Model model){

        model.addAttribute("avatar", new Avatar());
        model.addAttribute("alunos", alunoService.getListaAluno());
        return "avatar/formAvatar";
    }

    @RequestMapping("/addAvatar")
    public String showFormAvatar(@ModelAttribute("avatar") Avatar avatar, RedirectAttributes redirectAttributes){

        Aluno alunoSelecionado = alunoService.getAlunoById(avatar.getAluno().getId());
        avatar.setAluno(alunoSelecionado);
        avatarService.salvarAvatar(avatar);

        alunoSelecionado.setAvatar(avatar);
        alunoService.salvarAluno(alunoSelecionado);


        redirectAttributes.addFlashAttribute("successMessage", "Avatar adicionado");
        return "redirect:/avatar/getListaAvatares";
    }

    @RequestMapping("/getListaAvatares")
    public String showListaAvatares(Model model){

        List<Avatar> avatares = avatarService.getAvatares();

        model.addAttribute("avatares", avatares);
        return "avatar/listaAvatares";
    }
}
