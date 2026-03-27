package com.senai.weg.exercicios.mapper;

import com.senai.weg.exercicios.dto.request.TarefaRequestDto;
import com.senai.weg.exercicios.dto.response.TarefaResponseDto;
import com.senai.weg.exercicios.model.Projeto;
import com.senai.weg.exercicios.model.Tarefa;
import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {

    public TarefaResponseDto toResponseDto(Tarefa tarefa) {
        return new TarefaResponseDto(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getDataLimite(),
                tarefa.getProjeto().getId(),
                tarefa.getProjeto().getNome()
        );
    }

    public Tarefa toEntity(TarefaRequestDto dto, Projeto projeto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setStatus(dto.status());
        tarefa.setDataLimite(dto.dataLimite());
        tarefa.setProjeto(projeto);
        return tarefa;
    }
}