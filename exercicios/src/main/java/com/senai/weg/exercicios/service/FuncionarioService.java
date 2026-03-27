package com.senai.weg.exercicios.service;

import com.senai.weg.exercicios.dto.request.DepartamentoRequestDto;
import com.senai.weg.exercicios.dto.request.FuncionarioRequestDto;
import com.senai.weg.exercicios.dto.response.FuncionarioResponseDto;
import com.senai.weg.exercicios.mapper.FuncionarioMapper;
import com.senai.weg.exercicios.model.Departamento;
import com.senai.weg.exercicios.model.Funcionario;
import com.senai.weg.exercicios.repository.DepartamentoRepository;
import com.senai.weg.exercicios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    public FuncionarioResponseDto criarFuncionario (FuncionarioRequestDto dto){
      Departamento departamento = departamentoRepository.findById(dto.departamentoId())
        .orElseThrow(() -> new RuntimeException("Departamento não encontrado!"));

      Funcionario funcionario = funcionarioMapper.toEntity(dto, departamento);
         repository.save(funcionario);
        return funcionarioMapper.toResponseDto(funcionario);
    }

    public List<FuncionarioResponseDto> listarFuncionario() {
        return repository.findAll()
                .stream()
                .map(funcionarioMapper::toResponseDto)
                .toList();
    }

    public Optional<FuncionarioResponseDto> buscarPorId(Long id) {
        return repository.findById(id)
                .map(funcionarioMapper::toResponseDto);
    }

    public List<FuncionarioResponseDto> buscarPorNome(String nome){
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(funcionarioMapper::toResponseDto)
                .toList();
    }

    public List<FuncionarioResponseDto> buscarPorIdDepartamento(Long departamentoId){
        return repository.findByDepartamentoId(departamentoId)
                .stream()
                .map(funcionarioMapper::toResponseDto)
                .toList();
    }

    public Optional<FuncionarioResponseDto> buscarPorIdENome(Long id, String nome) {
        return repository.findByIdAndNome(id, nome)
                .map(funcionarioMapper::toResponseDto);
    }


}
