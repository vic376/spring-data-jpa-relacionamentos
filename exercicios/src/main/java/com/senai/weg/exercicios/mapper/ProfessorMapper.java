package com.senai.weg.exercicios.mapper;

import com.senai.weg.exercicios.dto.request.ProfessorRequestDto;
import com.senai.weg.exercicios.dto.response.CursoResponseDto;
import com.senai.weg.exercicios.dto.response.ProfessorComCursosResponseDto;
import com.senai.weg.exercicios.dto.response.ProfessorResponseDto;
import com.senai.weg.exercicios.model.Professor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfessorMapper {

    public ProfessorResponseDto toResponseDto(Professor professor) {
        return new ProfessorResponseDto(
                professor.getId(),
                professor.getNome(),
                professor.getEmail()
        );
    }

    public ProfessorComCursosResponseDto toResponseDtoWithCursos(Professor professor, List<CursoResponseDto> cursos) {
        return new ProfessorComCursosResponseDto(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                cursos
        );
    }

    public Professor toEntity(ProfessorRequestDto dto) {
        Professor professor = new Professor();
        professor.setNome(dto.nome());
        professor.setEmail(dto.email());
        return professor;
    }
}