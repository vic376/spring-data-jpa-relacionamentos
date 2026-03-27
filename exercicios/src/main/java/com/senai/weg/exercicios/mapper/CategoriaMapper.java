package com.senai.weg.exercicios.mapper;

import com.senai.weg.exercicios.dto.request.CategoriaRequestDto;
import com.senai.weg.exercicios.dto.response.CategoriaResponseDto;
import com.senai.weg.exercicios.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public CategoriaResponseDto toResponseDto(Categoria categoria) {
        return new CategoriaResponseDto(
                categoria.getId(),
                categoria.getNome()
        );
    }

    public Categoria toEntity(CategoriaRequestDto dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.nome());
        return categoria;
    }
}
