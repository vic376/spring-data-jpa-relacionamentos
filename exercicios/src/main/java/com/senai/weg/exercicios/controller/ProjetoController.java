package com.senai.weg.exercicios.controller;

import com.senai.weg.exercicios.dto.request.ProjetoRequestDto;
import com.senai.weg.exercicios.dto.response.ProjetoComTarefasResponseDto;
import com.senai.weg.exercicios.dto.response.ProjetoResponseDto;
import com.senai.weg.exercicios.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService service;

    @PostMapping
    public ResponseEntity<ProjetoResponseDto> criar(@RequestBody ProjetoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarProjeto(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponseDto>> listar() {
        return ResponseEntity.ok(service.listarProjetos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoResponseDto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ProjetoResponseDto>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }

    @GetMapping("/{id}/tarefas")
    public ResponseEntity<ProjetoComTarefasResponseDto> buscarProjetoComTarefas(@PathVariable Long id) {
        return service.buscarProjetoComTarefas(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}