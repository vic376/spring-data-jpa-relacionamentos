package com.senai.weg.exercicios.mapper;

import com.senai.weg.exercicios.dto.request.CursoRequestDto;
import com.senai.weg.exercicios.dto.response.CursoResponseDto;
import com.senai.weg.exercicios.model.Curso;
import com.senai.weg.exercicios.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public CursoResponseDto toResponseDto(Curso curso) {
        return new CursoResponseDto(
                curso.getId(),
                curso.getTitulo(),
                curso.getCargaHoraria(),
                curso.getProfessor().getId(),
                curso.getProfessor().getNome()
        );
    }

    public Curso toEntity(CursoRequestDto dto, Professor professor) {
        Curso curso = new Curso();
        curso.setTitulo(dto.titulo());
        curso.setCargaHoraria(dto.cargaHoraria());
        curso.setProfessor(professor);
        return curso;
    }
}