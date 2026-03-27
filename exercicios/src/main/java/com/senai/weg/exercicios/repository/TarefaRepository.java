package com.senai.weg.exercicios.repository;

import com.senai.weg.exercicios.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByProjetoId(Long projetoId);
    Optional<Tarefa> findByIdAndTitulo(Long id, String titulo);
    List<Tarefa> findByStatus(String status);
    List<Tarefa> findByProjetoIdAndStatus(Long projetoId, String status);
}