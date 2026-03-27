package com.senai.weg.exercicios.repository;

import com.senai.weg.exercicios.dto.response.FuncionarioResponseDto;
import com.senai.weg.exercicios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByDepartamentoId(Long departamentoId);

    List<Funcionario> findByNomeContainingIgnoreCase(String nome);

    Optional<Funcionario> findByIdAndNome(Long id, String nome);
}
