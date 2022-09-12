package com.example.crm.repository;

import com.example.crm.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
//Iterable<Cliente>findByNomeAndCpfecnpjAndCidadeAndUf(String nome,String cpfecnpj,String cidade,String uf);
List<Cliente>findByNomeLikeOrCpfecnpjLikeOrCidadeLikeOrUfLike(String nome, String cpfecnpj, String cidade, String uf);
Iterable<Cliente>findByNome(String nome);
Iterable<Cliente>findByCpfecnpj(String cpfecnpj);
Iterable<Cliente>findByCidade(String cidade);
Iterable<Cliente>findByUf(String uf);


//
//	void saveAndFlush(Cliente cliente);

}
