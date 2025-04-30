package desafio.dio.design_patterns.java.strategy;

public class ComportamentoDefensivo implements Comportamento {

	@Override
	public void mover() {
    System.out.println("Implementação do robo se movendo defensivamente!");
	}
  
}
