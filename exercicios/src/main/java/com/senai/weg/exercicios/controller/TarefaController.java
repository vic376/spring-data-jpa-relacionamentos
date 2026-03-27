package com.senai.weg.exercicios.controller;

import com.senai.weg.exercicios.dto.request.TarefaRequestDto;
import com.senai.weg.exercicios.dto.response.TarefaResponseDto;
import com.senai.weg.exercicios.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaResponseDto> criar(@RequestBody TarefaRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarTarefa(dto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDto>> listar() {
        return ResponseEntity.ok(service.listarTarefas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/projeto/{projetoId}")
    public ResponseEntity<List<TarefaResponseDto>> buscarPorProjetoId(@PathVariable Long projetoId) {
        return ResponseEntity.ok(service.buscarPorProjetoId(projetoId));
    }

    @GetMapping("/filtro")
    public ResponseEntity<TarefaResponseDto> buscarPorIdAndTitulo(
            @RequestParam Long id,
            @RequestParam String titulo) {
        return service.buscarPorIdAndTitulo(id, titulo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TarefaResponseDto>> buscarPorStatus(@PathVariable String status) {
        return ResponseEntity.ok(service.buscarPorStatus(status));
    }
    @GetMapping("/projeto/{projetoId}/status/{status}")
    public ResponseEntity<List<TarefaResponseDto>> buscarPorProjetoIdAndStatus(
            @PathVariable Long projetoId,
            @PathVariable String status) {
        return ResponseEntity.ok(service.buscarPorProjetoIdAndStatus(projetoId, status));
    }
}