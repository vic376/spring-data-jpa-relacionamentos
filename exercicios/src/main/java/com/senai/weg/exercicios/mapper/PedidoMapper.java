package com.senai.weg.exercicios.mapper;
//varios

import com.senai.weg.exercicios.dto.request.PedidoRequestDto;
import com.senai.weg.exercicios.dto.response.PedidoResponseDto;
import com.senai.weg.exercicios.model.Cliente;
import com.senai.weg.exercicios.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public PedidoResponseDto toResponseDto (Pedido pedido){
        return new PedidoResponseDto(
                pedido.getId(),
                pedido.getDescricao()
        );
    }

    public Pedido toEntity (PedidoRequestDto dto, Cliente cliente){
        Pedido pedido = new Pedido();
        pedido.setDescricao(dto.descricao());
        pedido.setCliente(cliente);
        return pedido;
    }
}
