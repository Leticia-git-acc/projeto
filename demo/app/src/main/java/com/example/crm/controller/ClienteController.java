package com.example.crm.controller;

import com.example.crm.model.Cliente;
import com.example.crm.repository.ClienteRepository;
import com.example.crm.services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ReportService repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping("/filtrar")
	List<Cliente> findByQuery(@RequestParam(value = "nome",defaultValue = "") String nome,
			@RequestParam(value = "cpfecnpj", defaultValue = "")String cpfecnpj,
			
			@RequestParam(value = "cidade", defaultValue = "")String cidade,
			
			@RequestParam(value = "uf", defaultValue = "")String uf)
	{
	return clienteRepository.findByNomeLikeOrCpfecnpjLikeOrCidadeLikeOrUfLike(nome,cpfecnpj,cidade,uf);

		//comparação
	//	if (nome != null && cpfecnpj != null && cidade != null && uf != null) {
	//		return clienteRepository.findByNomeAndCpfecnpjAndCidadeAndUf(nome,cpfecnpj,cidade,uf);
	//
	//	}else if(nome != null ) {
	//		return clienteRepository.findByNome(nome);
	//	}else if(cpfecnpj != null ) {
	//		return clienteRepository.findByCpfecnpj(cpfecnpj);
	//	}else if(cidade != null ) {
	//		return clienteRepository.findByCidade(cidade);
	//
	//
	//	}else if(uf != null ) {
	//		return clienteRepository.findByUf(uf);
	//	}else {
	//		return clienteRepository.findAll();
	//				}
	//
	}

//	@PostMapping("/clientes")
//	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
//	    Cliente obj = clienteRepository.save(cliente);M
//	    return ResponseEntity.ok().body(obj);
//	}
	@PutMapping("/cliente/alterar")
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<Cliente> alterar(@RequestBody Cliente cliente)
	{ clienteRepository.save(cliente);
		return new ResponseEntity(cliente, HttpStatus.OK);
	}
	//apagar pelo id
	@DeleteMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void remover(@PathVariable Integer id) {
		clienteRepository.deleteById(id);
	}
	@PostMapping("/cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	@GetMapping("/clientes")
	public List<Cliente> listClientes(){
		return clienteRepository.findAll();	}
	@GetMapping("/cliente/{id}")
	public Optional<Cliente> read (@PathVariable Integer id) {
		 return clienteRepository.findById(id);
	}

	@GetMapping("/cliente/report/{format}")
	public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
		return repository.exportReport(format);
	}
	

}