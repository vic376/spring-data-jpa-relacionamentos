package com.senai.weg.exercicios.service;

import com.senai.weg.exercicios.dto.request.ClienteRequestDto;
import com.senai.weg.exercicios.dto.response.ClienteResponseDto;
import com.senai.weg.exercicios.mapper.ClienteMapper;
import com.senai.weg.exercicios.model.Cliente;
import com.senai.weg.exercicios.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteMapper mapper;

    public ClienteResponseDto salvarCliente (ClienteRequestDto dto){
        Cliente cliente = mapper.toEntity(dto);
        return mapper.toResponseDto(repository.save(cliente));
    }

    public List<ClienteResponseDto> listarClientes (){
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public Optional<ClienteResponseDto> buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto);
    }


    public List<ClienteResponseDto> buscarPorNome(String nome){
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }


}
