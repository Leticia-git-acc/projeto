package com.example.crm.repository;

import com.example.crm.model.LivroCaixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Integer> {
    @Query("SELECT t FROM LivroCaixa t WHERE t.cliente.id = :cliente")
    List<LivroCaixa> findIdCliente(Integer cliente);
}