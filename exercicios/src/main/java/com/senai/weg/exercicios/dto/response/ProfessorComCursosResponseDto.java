package com.senai.weg.exercicios.dto.response;

import java.util.List;

public record ProfessorComCursosResponseDto(
        Long id,
        String nome,
        String email,
        List<CursoResponseDto> cursos
) {
}