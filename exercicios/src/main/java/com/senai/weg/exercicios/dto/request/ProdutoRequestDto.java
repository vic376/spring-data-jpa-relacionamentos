package com.senai.weg.exercicios.dto.request;

public record ProdutoRequestDto(

        String nome,
        double preco,
        Long categoriaId

) {
}
