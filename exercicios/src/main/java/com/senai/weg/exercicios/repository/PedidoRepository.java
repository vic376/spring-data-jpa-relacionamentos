package com.senai.weg.exercicios.repository;

import com.senai.weg.exercicios.model.Cliente;
import com.senai.weg.exercicios.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Optional<Pedido> findByClienteNomeContainingIgnoreCase(String nome);
    List<Pedido> findByClienteId(Long id);
    Optional<Pedido> findByIdAndDescricao(Long id, String descricao);



}
