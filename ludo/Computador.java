package ludo;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Computador extends Jogador{

  public Computador(String nome,String cor,int qt) {
   super(nome,cor,qt);
  }
  //AI do PC
  public Peao fazJogada(int dado){
    Peao p=null;
    if(dado==6){
      try{
        p=(Peao)qtdNaBase.get(0);
      }catch(Exception ex){
        for(int i=0;i<qtdNoJogo.size();i++){
          p = (Peao) qtdNoJogo.get(i);
          if((p.getCasasPercorridas()<49)||(p.getCasasPercorridas()+dado==54)){
            return p;
          }
        }
      }
    }else{
      for(int i=0;i<qtdNoJogo.size();i++){
        p = (Peao) qtdNoJogo.get(i);
        if((p.getCasasPercorridas()<49)||(p.getCasasPercorridas()+dado==54)){
          return p;
        }
      }
    }
    return p;
  }

}
