package desafio.dio.design_patterns.java.singleton;

public class SingletonEager {

  private static SingletonEager instance = new SingletonEager();

  private SingletonEager() {
  };

  public static SingletonEager getInstance() {
    return instance;
  }
}
