package com.jeanlima.springmvcdatajpaapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeanlima.springmvcdatajpaapp.model.Disciplina;



public interface DisciplinaRepository extends JpaRepository<Disciplina,Integer>{

}
