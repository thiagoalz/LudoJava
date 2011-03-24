package ludo;
import java.util.*;
import javax.swing.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class CasaCoroa extends Casa{
  boolean corDif;
  public CasaCoroa() {
    super();
    corDif=false;
  }

  public ArrayList addPeao(Peao p){
    ArrayList aux=new ArrayList();
    if(ocupantes.size() != 0){//testa se o novo peao e da mesma cor dos demais!
      Peao paux = (Peao) ocupantes.get(0);
      if (!paux.getCor().equals(p.getCor())) {
        corDif = true;
      }
    }
    ocupantes.add(p);
    trocaIcone();
    return aux;
  }

  public Peao tiraPeao(Jogador jog){
    Peao p=null;
    Peao aux;
    for(int i=0;i<ocupantes.size();i++){
      aux=(Peao)ocupantes.get(i);
      if(jog.getCor().equals(aux.getCor())){
        if(p==null){
          p=aux;
        }else if(aux.getCasasPercorridas()>p.getCasasPercorridas()){
          p=aux;
        }

      }
    }
    ocupantes.remove(p);
    corDif=false;
    for(int i=0;i<ocupantes.size();i++){
      Peao p_aux1=(Peao)ocupantes.get(i);
      if(i+1<ocupantes.size()){
        Peao p_aux2=(Peao)ocupantes.get(i+1);
        if(!p_aux1.getCor().equals(p_aux2.getCor())){
          corDif=true;
        }
      }
    }
    trocaIcone();
    return p;
  }

  protected void trocaIcone(){//sobrescreve o metodo da superclasse pois pode conter poes de cores diferentes
    if (corDif) {
      this.setIcon(new ImageIcon(CasaSimples.class.getResource(
          "pecaMisturada.gif")));
    }
    else{
      super.trocaIcone();//chamada do mesmo metodo mas na super classe!!
    }
  }

}
