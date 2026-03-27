package com.senai.weg.exercicios.service;

import com.senai.weg.exercicios.dto.request.TarefaRequestDto;
import com.senai.weg.exercicios.dto.response.TarefaResponseDto;
import com.senai.weg.exercicios.mapper.TarefaMapper;
import com.senai.weg.exercicios.model.Projeto;
import com.senai.weg.exercicios.model.Tarefa;
import com.senai.weg.exercicios.repository.ProjetoRepository;
import com.senai.weg.exercicios.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private TarefaMapper mapper;

    public TarefaResponseDto criarTarefa(TarefaRequestDto dto) {
        Projeto projeto = projetoRepository.findById(dto.projetoId())
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        Tarefa tarefa = mapper.toEntity(dto, projeto);
        return mapper.toResponseDto(repository.save(tarefa));
    }

    public List<TarefaResponseDto> listarTarefas() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public Optional<TarefaResponseDto> buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto);
    }

    public List<TarefaResponseDto> buscarPorProjetoId(Long projetoId) {
        return repository.findByProjetoId(projetoId)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public Optional<TarefaResponseDto> buscarPorIdAndTitulo(Long id, String titulo) {
        return repository.findByIdAndTitulo(id, titulo)
                .map(mapper::toResponseDto);
    }

    public List<TarefaResponseDto> buscarPorStatus(String status) {
        return repository.findByStatus(status)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public List<TarefaResponseDto> buscarPorProjetoIdAndStatus(Long projetoId, String status) {
        return repository.findByProjetoIdAndStatus(projetoId, status)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }
}