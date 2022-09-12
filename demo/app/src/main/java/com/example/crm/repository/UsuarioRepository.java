package com.example.crm.repository;

import com.example.crm.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Iterable<Usuario>findByNomeAndEmail(String nome, String email);
	Iterable<Usuario>findByNome(String nome);
	Iterable<Usuario>findByEmail(String email);
	Usuario findByLoginAndSenha(String login, String senha);


}