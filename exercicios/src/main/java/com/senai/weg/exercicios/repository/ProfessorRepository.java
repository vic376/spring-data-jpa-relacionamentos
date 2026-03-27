package com.senai.weg.exercicios.repository;

import com.senai.weg.exercicios.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    List<Professor> findByNomeContainingIgnoreCase(String nome);
    List<Professor> findByNomeIgnoreCase(String nome);
}