package com.senai.weg.exercicios.service;

import com.senai.weg.exercicios.dto.request.CategoriaRequestDto;
import com.senai.weg.exercicios.dto.response.CategoriaResponseDto;
import com.senai.weg.exercicios.mapper.CategoriaMapper;
import com.senai.weg.exercicios.model.Categoria;
import com.senai.weg.exercicios.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private CategoriaMapper mapper;

    public CategoriaResponseDto salvarCategoria(CategoriaRequestDto dto) {
        Categoria categoria = mapper.toEntity(dto);
        return mapper.toResponseDto(repository.save(categoria));
    }

    public List<CategoriaResponseDto> listarCategorias() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public Optional<CategoriaResponseDto> buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto);
    }
}
