package com.senai.weg.exercicios.controller;

import com.senai.weg.exercicios.dto.request.PedidoRequestDto;
import com.senai.weg.exercicios.dto.response.PedidoResponseDto;
import com.senai.weg.exercicios.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<PedidoResponseDto> criar(@RequestBody PedidoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarPedido(dto));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> listar() {
        return ResponseEntity.ok(service.listarPedido());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PedidoResponseDto>> buscarPorClienteId(@PathVariable Long clienteId) {
        return ResponseEntity.ok(service.buscarPorClienteId(clienteId));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PedidoResponseDto>> buscarPorClienteNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorClienteNome(nome));
    }

    @GetMapping("/filtro")
    public ResponseEntity<PedidoResponseDto> buscarPorIdAndDescricao(
            @RequestParam Long id,
            @RequestParam String descricao) {
        return service.buscarPorIdAndDescricao(id, descricao)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}