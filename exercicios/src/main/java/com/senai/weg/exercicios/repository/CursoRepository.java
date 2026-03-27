package com.senai.weg.exercicios.repository;

import com.senai.weg.exercicios.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByProfessorId(Long professorId);

    List<Curso> findByProfessorNomeContainingIgnoreCase(String nomeProfessor);

    Optional<Curso> findByIdAndTitulo(Long id, String titulo);
}