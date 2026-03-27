package com.senai.weg.exercicios.service;

import com.senai.weg.exercicios.dto.request.ProfessorRequestDto;
import com.senai.weg.exercicios.dto.response.CursoResponseDto;
import com.senai.weg.exercicios.dto.response.ProfessorComCursosResponseDto;
import com.senai.weg.exercicios.dto.response.ProfessorResponseDto;
import com.senai.weg.exercicios.mapper.CursoMapper;
import com.senai.weg.exercicios.mapper.ProfessorMapper;
import com.senai.weg.exercicios.model.Professor;
import com.senai.weg.exercicios.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private ProfessorMapper mapper;

    @Autowired
    private CursoMapper cursoMapper;

    public ProfessorResponseDto salvarProfessor(ProfessorRequestDto dto) {
        Professor professor = mapper.toEntity(dto);
        return mapper.toResponseDto(repository.save(professor));
    }

    public List<ProfessorResponseDto> listarProfessores() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public Optional<ProfessorResponseDto> buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto);
    }

    public List<ProfessorResponseDto> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public Optional<ProfessorComCursosResponseDto> buscarProfessorComCursos(Long id) {
        return repository.findById(id)
                .map(professor -> {
                    List<CursoResponseDto> cursos = professor.getCursos()
                            .stream()
                            .map(cursoMapper::toResponseDto)
                            .toList();
                    return mapper.toResponseDtoWithCursos(professor, cursos);
                });
    }
}