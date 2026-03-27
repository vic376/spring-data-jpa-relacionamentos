package com.senai.weg.exercicios.service;

import com.senai.weg.exercicios.dto.request.ProjetoRequestDto;
import com.senai.weg.exercicios.dto.response.ProjetoComTarefasResponseDto;
import com.senai.weg.exercicios.dto.response.ProjetoResponseDto;
import com.senai.weg.exercicios.dto.response.TarefaResponseDto;
import com.senai.weg.exercicios.mapper.ProjetoMapper;
import com.senai.weg.exercicios.mapper.TarefaMapper;
import com.senai.weg.exercicios.model.Projeto;
import com.senai.weg.exercicios.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    @Autowired
    private ProjetoMapper mapper;

    @Autowired
    private TarefaMapper tarefaMapper;

    public ProjetoResponseDto salvarProjeto(ProjetoRequestDto dto) {
        Projeto projeto = mapper.toEntity(dto);
        return mapper.toResponseDto(repository.save(projeto));
    }

    public List<ProjetoResponseDto> listarProjetos() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public Optional<ProjetoResponseDto> buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto);
    }

    public List<ProjetoResponseDto> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public Optional<ProjetoComTarefasResponseDto> buscarProjetoComTarefas(Long id) {
        return repository.findById(id)
                .map(projeto -> {
                    List<TarefaResponseDto> tarefas = projeto.getTarefas()
                            .stream()
                            .map(tarefaMapper::toResponseDto)
                            .toList();
                    return mapper.toResponseDtoWithTarefas(projeto, tarefas);
                });
    }
}