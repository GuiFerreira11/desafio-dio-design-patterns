package desafio.dio.design_patterns.java;

import desafio.dio.design_patterns.java.facade.Facade;
import desafio.dio.design_patterns.java.singleton.SingletonEager;
import desafio.dio.design_patterns.java.singleton.SingletonLazy;
import desafio.dio.design_patterns.java.strategy.Comportamento;
import desafio.dio.design_patterns.java.strategy.ComportamentoAgressivo;
import desafio.dio.design_patterns.java.strategy.ComportamentoDefensivo;
import desafio.dio.design_patterns.java.strategy.ComportamentoNormal;
import desafio.dio.design_patterns.java.strategy.Robo;

public class Main {
  public static void main(String[] args) {

    System.out.println("==================================");
    System.out.println("==== Design Pattern Singleton ====");
    System.out.println("==================================");

    System.out.println();

    SingletonLazy lazy1 = SingletonLazy.getInstance();
    SingletonLazy lazy2 = SingletonLazy.getInstance();

    SingletonEager eager1 = SingletonEager.getInstance();
    SingletonEager eager2 = SingletonEager.getInstance();

    System.out.println("A instância lazy1 é igual a lazy2? " + (lazy1 == lazy2));
    System.out.println("A instância eager1 é igual a eager2? " + (eager1 == eager2));

    System.out.println();

    System.out.println("==================================");
    System.out.println("==== Design Pattern Strategy  ====");
    System.out.println("==================================");

    System.out.println();

    Robo robo = new Robo();
    robo.mover();

    Comportamento normal = new ComportamentoNormal();
    Comportamento agressivo = new ComportamentoAgressivo();
    Comportamento defensivo = new ComportamentoDefensivo();

    robo.setComportamento(normal);
    robo.mover();
    robo.mover();
    robo.mover();
    robo.setComportamento(agressivo);
    robo.mover();
    robo.mover();
    robo.setComportamento(normal);
    robo.mover();
    robo.setComportamento(defensivo);
    robo.mover();
    robo.mover();
    robo.mover();
    robo.setComportamento(agressivo);
    robo.mover();
    robo.mover();
    robo.setComportamento(normal);
    robo.mover();

    System.out.println();

    System.out.println("==================================");
    System.out.println("===== Design Pattern Facade  =====");
    System.out.println("==================================");

    System.out.println();

    Facade facede = new Facade();
    facede.migrarCliente("Gui", "12345678");


  }
}
