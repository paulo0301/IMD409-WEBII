package com.jeanlima.springmvcdatajpaapp.service;

import com.jeanlima.springmvcdatajpaapp.model.Avatar;
import com.jeanlima.springmvcdatajpaapp.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvatarService {

    @Autowired
    AvatarRepository avatarRepository;

    @Autowired
    AlunoService alunoService;

    public void salvarAvatar(Avatar avatar){
        avatarRepository.save(avatar);
    }

    public List<Avatar> getAvatares(){
        List<Avatar> avatares = avatarRepository.findAll();
        for (Avatar avatar : avatares) {
            avatar.setAluno(alunoService.getAlunoByIdAvatar(avatar.getId()));
        }
        return avatares;
    }

    public Avatar getAvatarById(Integer id){
        return avatarRepository.findById(id).map(avatar -> {
            return avatar;
        }).orElseThrow(() -> null);
    }

}
