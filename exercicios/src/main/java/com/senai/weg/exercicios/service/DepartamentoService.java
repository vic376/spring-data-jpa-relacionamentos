package com.senai.weg.exercicios.service;


import com.senai.weg.exercicios.dto.request.DepartamentoRequestDto;
import com.senai.weg.exercicios.mapper.DepartamentoMapper;
import com.senai.weg.exercicios.model.Departamento;
import com.senai.weg.exercicios.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;

    @Autowired
    private DepartamentoMapper mapper;

    public Departamento criarDepartamento (DepartamentoRequestDto dto){
        Departamento departamento = mapper.toEntity(dto);
        return repository.save(departamento);
    }

    public List<Departamento> listarDepartamentos(){
        return repository.findAll();
    }

    public Optional<Departamento> buscarPorId(Long id){
        return repository.findById(id);
    }


}
