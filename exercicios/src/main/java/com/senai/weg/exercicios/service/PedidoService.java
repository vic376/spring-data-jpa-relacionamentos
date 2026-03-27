package com.senai.weg.exercicios.service;

import com.senai.weg.exercicios.dto.request.PedidoRequestDto;
import com.senai.weg.exercicios.dto.response.ClienteResponseDto;
import com.senai.weg.exercicios.dto.response.PedidoResponseDto;
import com.senai.weg.exercicios.mapper.PedidoMapper;
import com.senai.weg.exercicios.model.Cliente;
import com.senai.weg.exercicios.model.Pedido;
import com.senai.weg.exercicios.repository.ClienteRepository;
import com.senai.weg.exercicios.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoMapper mapper;

    public PedidoResponseDto criarPedido (PedidoRequestDto dto){
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Pedido pedido = mapper.toEntity(dto, cliente);
        repository.save(pedido);
        return mapper.toResponseDto(pedido);
    }

    public Optional<PedidoResponseDto> buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto);
    }

    public List<PedidoResponseDto> listarPedido(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public List<PedidoResponseDto> buscarPorClienteId(Long clienteId) {
        return repository.findByClienteId(clienteId)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public List<PedidoResponseDto> buscarPorClienteNome(String nome) {
        return repository.findByClienteNomeContainingIgnoreCase(nome)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    public Optional<PedidoResponseDto> buscarPorIdAndDescricao(Long id, String descricao) {
        return repository.findByIdAndDescricao(id, descricao)
                .map(mapper::toResponseDto);
    }


}
