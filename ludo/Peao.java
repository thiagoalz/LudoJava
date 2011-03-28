package ludo;

public class Peao implements java.io.Serializable {
  private int casasPercorridas;
  private String cor;
  private int base;
  public Peao(String cor,int base) {
    this.cor=cor;
    this.base=base;
    casasPercorridas=0;
  }

  public void setPercorridas(int x){
    casasPercorridas=x;
  }
  public void anda(int i){
    casasPercorridas=casasPercorridas+i;
  }
  public int getBase(){
    return base;
  }

  public String getCor(){
    return cor;
  }
  public int getCasasPercorridas(){
    return casasPercorridas;
  }
  public void voltaBase(){
    casasPercorridas=0;
  }
  public void vaiProJogo(){
    casasPercorridas=1;
  }
}
