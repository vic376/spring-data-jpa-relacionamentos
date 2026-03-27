package com.senai.weg.exercicios.mapper;

import com.senai.weg.exercicios.dto.request.FuncionarioRequestDto;
import com.senai.weg.exercicios.dto.response.FuncionarioResponseDto;
import com.senai.weg.exercicios.model.Departamento;
import com.senai.weg.exercicios.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public FuncionarioResponseDto toResponseDto (Funcionario funcionario){
        return new FuncionarioResponseDto(
                Math.toIntExact(funcionario.getId()),
                funcionario.getNome()
        );
    }

    public Funcionario toEntity (FuncionarioRequestDto dto, Departamento departamento){
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.nome());
        funcionario.setDepartamento(departamento);
        return funcionario;
    }


}
