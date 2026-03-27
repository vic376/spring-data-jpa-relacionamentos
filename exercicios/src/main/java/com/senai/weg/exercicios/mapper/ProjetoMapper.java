package com.senai.weg.exercicios.mapper;

import com.senai.weg.exercicios.dto.request.ProjetoRequestDto;
import com.senai.weg.exercicios.dto.response.ProjetoComTarefasResponseDto;
import com.senai.weg.exercicios.dto.response.ProjetoResponseDto;
import com.senai.weg.exercicios.dto.response.TarefaResponseDto;
import com.senai.weg.exercicios.model.Projeto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjetoMapper {

    public ProjetoResponseDto toResponseDto(Projeto projeto) {
        return new ProjetoResponseDto(
                projeto.getId(),
                projeto.getNome(),
                projeto.getDescricao(),
                projeto.getDataInicio(),
                projeto.getDataFim()
        );
    }

    public ProjetoComTarefasResponseDto toResponseDtoWithTarefas(Projeto projeto, List<TarefaResponseDto> tarefas) {
        return new ProjetoComTarefasResponseDto(
                projeto.getId(),
                projeto.getNome(),
                projeto.getDescricao(),
                projeto.getDataInicio(),
                projeto.getDataFim(),
                tarefas
        );
    }

    public Projeto toEntity(ProjetoRequestDto dto) {
        Projeto projeto = new Projeto();
        projeto.setNome(dto.nome());
        projeto.setDescricao(dto.descricao());
        projeto.setDataInicio(dto.dataInicio());
        projeto.setDataFim(dto.dataFim());
        return projeto;
    }
}