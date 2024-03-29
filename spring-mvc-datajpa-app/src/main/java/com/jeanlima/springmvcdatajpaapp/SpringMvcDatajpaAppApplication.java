package com.jeanlima.springmvcdatajpaapp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jeanlima.springmvcdatajpaapp.model.Aluno;
import com.jeanlima.springmvcdatajpaapp.model.Curso;
import com.jeanlima.springmvcdatajpaapp.model.Disciplina;
import com.jeanlima.springmvcdatajpaapp.repository.AlunoRepository;
import com.jeanlima.springmvcdatajpaapp.repository.CursoRepository;
import com.jeanlima.springmvcdatajpaapp.repository.DisciplinaRepository;

@SpringBootApplication
public class SpringMvcDatajpaAppApplication {

	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	AlunoRepository alunoRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;

	@Bean
	public CommandLineRunner init(){
		return args -> {

//            System.out.println("Cursos cadastrados");
//            List<Curso> cursos = cursoRepository.findAll();
//            cursos.forEach(System.out::println);
//
//            System.out.println("Disciplinas cadastradas");
//            List<Disciplina> disciplinas = disciplinaRepository.findAll();
//            disciplinas.forEach(System.out::println);

//             Aluno aluno = new Aluno("Aluno A");
//            aluno.setCurso(cursos.get(0));
//            aluno.setDisciplinas(disciplinas);
//             Aluno aluno2 = new Aluno("Aluno B");
//            aluno2.setCurso(cursos.get(1));
//            aluno2.setDisciplinas(disciplinas.stream().map(disciplina -> { if(disciplina.getDescricao().contains("Web")){return disciplina;} else {return null;}}).collect(Collectors.toList()));
//            Aluno aluno3 = new Aluno("Aluno C");
//            aluno3.setCurso(cursos.get(2));
//            aluno3.setDisciplinas(disciplinas);

//            alunoRepository.save(aluno);
//            alunoRepository.save(aluno2);
//            alunoRepository.save(aluno3);
 
                        
            //FETCH LAZY OR EAGER?
            //List<Aluno> alunos = alunoRepository.findAll();
//            List<Aluno> alunos = alunoRepository.findAllFetchDisciplinas();
//           System.out.println("LISTANDO ESTUDANTES E DISCIPLINAS - FETCH");
//            alunos.forEach(
//                e -> {
//                    System.out.println(e.toString());
//                    System.out.println(e.getDisciplinas().toString());
//                }
//
//            );
            
            
//            List<Aluno> alunoPorDisciplina = alunoRepository.findAllByDisciplinaId(disciplinas.get(1).getId());
//            System.out.println("Lista Alunos por Disciplina");
//            alunoPorDisciplina.forEach(
//                e -> {
//                    System.out.println(e.toString());
//                    //System.out.println(e.getDisciplinas().toString());
//
//
//                }
//
//            );

            
//            Aluno alunoDisciplinas = alunoRepository.findById(29).map(e -> {return e;}).orElseThrow();
//            List<Disciplina> disciplinasPorAluno = disciplinaRepository.findAllByAlunoId(alunoDisciplinas.getId());
            System.out.println("Aluno");
//            System.out.println(alunoDisciplinas.toString());
//            alunoDisciplinas.setDisciplinas(disciplinasPorAluno);
//            System.out.println("Disciplinas");
//            System.out.println(alunoDisciplinas.getDisciplinas().toString());

            


            

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcDatajpaAppApplication.class, args);
	}

}
