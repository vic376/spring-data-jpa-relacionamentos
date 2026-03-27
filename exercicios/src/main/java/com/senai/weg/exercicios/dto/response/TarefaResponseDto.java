package com.senai.weg.exercicios.dto.response;

import java.time.LocalDate;

public record TarefaResponseDto(
        Long id,
        String titulo,
        String descricao,
        String status,
        LocalDate dataLimite,
        Long projetoId,
        String nomeProjeto
) {
}