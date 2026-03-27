package com.senai.weg.exercicios.controller;

import com.senai.weg.exercicios.dto.request.CursoRequestDto;
import com.senai.weg.exercicios.dto.response.CursoResponseDto;
import com.senai.weg.exercicios.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    public ResponseEntity<CursoResponseDto> criar(@RequestBody CursoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarCurso(dto));
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> listar() {
        return ResponseEntity.ok(service.listarCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<CursoResponseDto>> buscarPorProfessorId(@PathVariable Long professorId) {
        return ResponseEntity.ok(service.buscarPorProfessorId(professorId));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<CursoResponseDto>> buscarPorNomeProfessor(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNomeProfessor(nome));
    }
    @GetMapping("/filtro")
    public ResponseEntity<CursoResponseDto> buscarPorIdAndTitulo(
            @RequestParam Long id,
            @RequestParam String titulo) {
        return service.buscarPorIdAndTitulo(id, titulo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}