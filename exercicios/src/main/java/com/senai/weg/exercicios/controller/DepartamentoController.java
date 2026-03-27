package com.senai.weg.exercicios.controller;


import com.senai.weg.exercicios.dto.request.DepartamentoRequestDto;
import com.senai.weg.exercicios.model.Departamento;
import com.senai.weg.exercicios.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @PostMapping
    public ResponseEntity<Departamento> criar(@RequestBody DepartamentoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarDepartamento(dto));
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> listar() {
        return ResponseEntity.ok(service.listarDepartamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}



