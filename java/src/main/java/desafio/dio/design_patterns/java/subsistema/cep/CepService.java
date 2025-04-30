package desafio.dio.design_patterns.java.subsistema.cep;

public class CepService {

  private static CepService instance;

  private CepService() {
  };

  public static CepService getInstance() {
    if (instance == null) {
      instance = new CepService();
    }
    return instance;
  }

  public String recuperarCidade(String cep) {
    return "São Paulo";
  }

  public String recuperarEstado(String cep) {
    return "SP";
  }
}
