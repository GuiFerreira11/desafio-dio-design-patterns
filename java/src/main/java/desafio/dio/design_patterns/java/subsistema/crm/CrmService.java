package desafio.dio.design_patterns.java.subsistema.crm;

public class CrmService {

  private CrmService() {
  };

  public static void gravarCliente(String nome, String cep, String cidade, String estado) {
    System.out.println("Cliente salvo no sistema de CRM com sucesso!");
    System.out.println(nome);
    System.out.println(cep);
    System.out.println(cidade);
    System.out.println(estado);
  }
}
