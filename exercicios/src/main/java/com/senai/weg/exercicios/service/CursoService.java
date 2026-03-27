package com.senai.weg.exercicios.service;

import com.senai.weg.exercicios.dto.request.CursoRequestDto;
import com.senai.weg.exercicios.dto.response.CursoResponseDto;
import com.senai.weg.exercicios.mapper.CursoMapper;
import com.senai.weg.exercicios.model.Curso;
import com.senai.weg.exercicios.model.Professor;
import com.senai.weg.exercicios.repository.CursoRepository;
import com.senai.weg.exercicios.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CursoMapper mapper;

    public CursoResponseDto criarCurso(CursoRequestDto dto) {
        Professor professor = professorRepository.findById(dto.professorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        Curso curso = mapper.toEntity(dto, professor);
        return mapper.toResponseDto(repository.save(curso));
    }

    public List<CursoResponseDto> listarCursos() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public Optional<CursoResponseDto> buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto);
    }
    public List<CursoResponseDto> buscarPorProfessorId(Long professorId) {
        return repository.findByProfessorId(professorId)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public List<CursoResponseDto> buscarPorNomeProfessor(String nomeProfessor) {
        return repository.findByProfessorNomeContainingIgnoreCase(nomeProfessor)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public Optional<CursoResponseDto> buscarPorIdAndTitulo(Long id, String titulo) {
        return repository.findByIdAndTitulo(id, titulo)
                .map(mapper::toResponseDto);
    }
}