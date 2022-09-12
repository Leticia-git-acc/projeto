package com.example.crm.livrocaixaservice;

import com.example.crm.exceptions.ObjectNotFoundException;
import com.example.crm.model.Cliente;
import com.example.crm.model.LivroCaixa;
import com.example.crm.repository.ClienteRepository;
import com.example.crm.repository.LivroCaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroCaixaService {

    @Autowired
	private LivroCaixaRepository livroCaixaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<LivroCaixa> listAll() {

        return livroCaixaRepository.findAll();
    }




        public LivroCaixa save(LivroCaixa livroCaixa) {
                    if(livroCaixa.getCliente().getId() == null || livroCaixa.getDataLancamento() == null || livroCaixa.getDescricao() == null || livroCaixa.getTipo() == null){
                       throw new ObjectNotFoundException("Não são permitidos campos marcados como null no livro caixa");
                  } else if (livroCaixa.getTipo().equals('C') || livroCaixa.getTipo().equals('D')){
                        Cliente cli = clienteRepository.findById(livroCaixa.getCliente().getId())
                                .orElseThrow(()->new ObjectNotFoundException("Cliente não existe"));
                        livroCaixa.setCliente(cli);
                        livroCaixaRepository.save(livroCaixa);

                      return livroCaixa;
                  } else {
                        throw new ObjectNotFoundException("Tipo de pagamento diferente de Crédito ou Débito");
              }
          //  if ((livroCaixa.getTipo().equals('C') || livroCaixa.getTipo().equals('D'))) {
           //     livroCaixaRepository.save(livroCaixa);
           //     return livroCaixa;
          //  } else {
             //   throw new ObjectNotFoundException("Tipo de pagamento diferente de Crédito ou Débito");
         //   }
        }


    public LivroCaixa get(Integer id) {
        return livroCaixaRepository.findById(id).get();
    }

    public List<LivroCaixa> findIdClientes(Integer id) {
        return livroCaixaRepository.findIdCliente(id);
    }


    public void delete(Integer id) {
        if (livroCaixaRepository.findById(id).isPresent()) {
            livroCaixaRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException("LivroCaixa não encontrado pelo id " + id);
        }

    }
}

