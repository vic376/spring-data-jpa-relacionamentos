package com.senai.weg.exercicios.dto.response;

import java.time.LocalDate;
import java.util.List;

public record ProjetoComTarefasResponseDto(
        Long id,
        String nome,
        String descricao,
        LocalDate dataInicio,
        LocalDate dataFim,
        List<TarefaResponseDto> tarefas
) {
}