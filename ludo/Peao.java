package ludo;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Peao {
  private int casasPercorridas;
  private String cor;
  private int base;
  public Peao(String cor,int base) {
    this.cor=cor;
    this.base=base;
    casasPercorridas=0;
  }

  //metodos para controlar as casas percorridas!!
  public void setPercorridas(int x){
    casasPercorridas=x;
  }

  public void anda(){
    casasPercorridas++;
  }

  public void volta(){
    casasPercorridas--;
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


  public int getBase(){
    return base;
  }

  public String getCor(){
    return cor;
  }

}
