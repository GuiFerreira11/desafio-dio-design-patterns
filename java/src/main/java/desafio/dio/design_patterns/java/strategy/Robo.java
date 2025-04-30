package desafio.dio.design_patterns.java.strategy;

public class Robo {
  
  private Comportamento comportamento;

  public void setComportamento(Comportamento comportamento){
    this.comportamento = comportamento;
  }

  public void mover(){
    if(comportamento == null){
      System.out.println("Nenhum comportamento foi atribuido a movimentação do robo!");
    } else{
      this.comportamento.mover();
    }
  }
}
