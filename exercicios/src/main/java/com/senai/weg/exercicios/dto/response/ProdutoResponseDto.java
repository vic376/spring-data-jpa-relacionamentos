package com.senai.weg.exercicios.dto.response;

public record ProdutoResponseDto(
        Long id,
        String nome,
        Double preco,
        String nomeCategoria
) {
}
