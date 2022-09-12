package com.example.crm.controller;

import com.example.crm.livrocaixaservice.LivroCaixaService;
import com.example.crm.model.LivroCaixa;
import com.example.crm.repository.LivroCaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class LivroCaixaController {

    @Autowired
    private LivroCaixaService livroCaixaService;
    @Autowired
    private LivroCaixaRepository livroCaixaRepository;
    @RequestMapping("/livrocaixa")
    public ResponseEntity<List<LivroCaixa>> listaLivroCaixa(){
        List<LivroCaixa> livroCaixaList = livroCaixaService.listAll();
        return ResponseEntity.ok().body(livroCaixaList);
    }

    @GetMapping("/livrocaixa/cliente/{id}")
    public ResponseEntity <List<LivroCaixa>> listaLivroCaixa(@PathVariable(value = "id") Integer id){
        List<LivroCaixa> obj = livroCaixaService.findIdClientes(id);
        return ResponseEntity.ok().body(obj);
    }

 @RequestMapping("/livrocaixa/{id}")
    public ResponseEntity<LivroCaixa> listaCliente(@Valid @PathVariable(value = "id") Integer id){
        LivroCaixa obj = livroCaixaService.get(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/livrocaixa")
    public ResponseEntity<LivroCaixa> criarLivroCaixa(@RequestBody LivroCaixa livroCaixa){
        LivroCaixa obj = livroCaixaService.save(livroCaixa);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/livrocaixa/{id}")
    public ResponseEntity<Integer> deletaLivrocaixa(@PathVariable("id") Integer id){
        livroCaixaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/livrocaixa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LivroCaixa> atualizaLivroCAixa(@RequestBody LivroCaixa livroCaixa,@PathVariable("id") Integer id){
        LivroCaixa obj = livroCaixaService.save(livroCaixa);
        return ResponseEntity.ok().body(obj);
    }
}



