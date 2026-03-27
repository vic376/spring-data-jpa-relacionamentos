package com.senai.weg.exercicios.mapper;

import com.senai.weg.exercicios.dto.request.DepartamentoRequestDto;
import com.senai.weg.exercicios.dto.response.DepartamentoResponseDto;
import com.senai.weg.exercicios.model.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoMapper {

    public DepartamentoResponseDto toResponseDto (Departamento departamento){
        return new DepartamentoResponseDto(
         Math.toIntExact(departamento.getId()),
          departamento.getNome()
        );
    }

    public Departamento toEntity (DepartamentoRequestDto dto){
        Departamento departamento = new Departamento();
        departamento.setNome(dto.nome());
        return departamento;
    }



}
