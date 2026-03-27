package com.senai.weg.exercicios.dto.request;

import java.time.LocalDate;

public record TarefaRequestDto(
        String titulo,
        String descricao,
        String status,
        LocalDate dataLimite,
        Long projetoId
) {
}