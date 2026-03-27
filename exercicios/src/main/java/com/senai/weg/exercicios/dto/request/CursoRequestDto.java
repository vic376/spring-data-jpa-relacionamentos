package com.senai.weg.exercicios.dto.request;

public record CursoRequestDto(
        String titulo,
        Integer cargaHoraria,
        Long professorId
) {
}