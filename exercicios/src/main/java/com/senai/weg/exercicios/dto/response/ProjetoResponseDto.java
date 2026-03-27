package com.senai.weg.exercicios.dto.response;

import java.time.LocalDate;

public record ProjetoResponseDto(
        Long id,
        String nome,
        String descricao,
        LocalDate dataInicio,
        LocalDate dataFim
) {
}