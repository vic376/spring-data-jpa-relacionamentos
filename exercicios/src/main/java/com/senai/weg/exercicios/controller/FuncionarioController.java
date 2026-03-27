package com.senai.weg.exercicios.controller;

import com.senai.weg.exercicios.dto.request.DepartamentoRequestDto;
import com.senai.weg.exercicios.dto.request.FuncionarioRequestDto;
import com.senai.weg.exercicios.dto.response.FuncionarioResponseDto;
import com.senai.weg.exercicios.model.Departamento;
import com.senai.weg.exercicios.model.Funcionario;
import com.senai.weg.exercicios.service.DepartamentoService;
import com.senai.weg.exercicios.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> criar(@RequestBody FuncionarioRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarFuncionario(dto));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> listar() {
        return ResponseEntity.ok(service.listarFuncionario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}






