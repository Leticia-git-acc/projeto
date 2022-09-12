package com.example.crm.controller;

import com.example.crm.model.Usuario;
import com.example.crm.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping("/autenticação")
	String findByLogin(@RequestParam("login") String login,
					   @RequestParam(value = "senha") String senha) {

		Usuario dadoslogin = usuarioRepository.findByLoginAndSenha(login, senha);
		if (dadoslogin == null) {
			return "usuario incorreto";
		} else if (dadoslogin.getStatus() == 'A') {
			return "usuario logado";
		} else {
			return "usuario desligado";
		}
	}

	@GetMapping("/filtro")
	Iterable<Usuario> findByQuery(@RequestParam(value = "nome", required = false) String nome,
								  @RequestParam(value = "email", required = false) String email) {
		//comparação
		if (nome != null && email != null) {
			return usuarioRepository.findByNomeAndEmail(nome, email);
		} else if (nome != null) {
			return usuarioRepository.findByNome(nome);
		} else if (email != null) {
			return usuarioRepository.findByEmail(email);
		} else {
			return usuarioRepository.findAll();
		}

	}




	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void remover(@PathVariable Integer id) {
		usuarioRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<Usuario> alterar(@PathVariable Integer id,@RequestBody Usuario usuario) {
		usuario.setId(id);
		usuarioRepository.save(usuario);
		return new ResponseEntity(usuario, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	Optional<Usuario> findById(@PathVariable Integer id) {
		return usuarioRepository.findById(id);

	}


	@GetMapping
	public List<Usuario> listUsuario() {
		return usuarioRepository.findAll();
	}


}