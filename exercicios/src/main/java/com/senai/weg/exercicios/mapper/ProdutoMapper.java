package com.senai.weg.exercicios.mapper;

import com.senai.weg.exercicios.dto.request.ProdutoRequestDto;
import com.senai.weg.exercicios.dto.response.ProdutoResponseDto;
import com.senai.weg.exercicios.model.Categoria;
import com.senai.weg.exercicios.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoResponseDto toResponseDto(Produto produto) {
        return new ProdutoResponseDto(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getCategoria().getNome()
        );
    }

    public Produto toEntity(ProdutoRequestDto dto, Categoria categoria) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setCategoria(categoria);
        return produto;
    }
}
