package com.senai.weg.exercicios.mapper;

import com.senai.weg.exercicios.dto.request.ClienteRequestDto;
import com.senai.weg.exercicios.dto.request.PedidoRequestDto;
import com.senai.weg.exercicios.dto.response.ClienteResponseDto;
import com.senai.weg.exercicios.dto.response.PedidoResponseDto;
import com.senai.weg.exercicios.model.Cliente;
import com.senai.weg.exercicios.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteResponseDto toResponseDto (Cliente cliente){
        return new ClienteResponseDto(
                cliente.getId(),
                cliente.getNome()
        );
    }

    public Cliente toEntity (ClienteRequestDto dto){
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        return cliente;
    }
}
