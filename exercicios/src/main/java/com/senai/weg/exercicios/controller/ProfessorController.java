package com.senai.weg.exercicios.controller;

import com.senai.weg.exercicios.dto.request.ProfessorRequestDto;
import com.senai.weg.exercicios.dto.response.ProfessorComCursosResponseDto;
import com.senai.weg.exercicios.dto.response.ProfessorResponseDto;
import com.senai.weg.exercicios.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> criar(@RequestBody ProfessorRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarProfessor(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> listar() {
        return ResponseEntity.ok(service.listarProfessores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ProfessorResponseDto>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }
    @GetMapping("/{id}/cursos")
    public ResponseEntity<ProfessorComCursosResponseDto> buscarProfessorComCursos(@PathVariable Long id) {
        return service.buscarProfessorComCursos(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}