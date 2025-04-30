package desafio.dio.design_patterns.java.facade;

import desafio.dio.design_patterns.java.subsistema.cep.CepService;
import desafio.dio.design_patterns.java.subsistema.crm.CrmService;

public class Facade {
  
  public void migrarCliente(String nome, String cep){
    String cidade = CepService.getInstance().recuperarCidade(cep);
    String estado = CepService.getInstance().recuperarEstado(cep);

    CrmService.gravarCliente(nome, cep, cidade, estado);
  }
}
