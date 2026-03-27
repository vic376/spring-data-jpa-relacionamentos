package com.senai.weg.exercicios.dto.response;

public record CursoResponseDto(
        Long id,
        String titulo,
        Integer cargaHoraria,
        Long professorId,
        String nomeProfessor
) {
}