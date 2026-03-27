package com.senai.weg.exercicios.dto.request;

import java.time.LocalDate;

public record ProjetoRequestDto(
        String nome,
        String descricao,
        LocalDate dataInicio,
        LocalDate dataFim
) {
}