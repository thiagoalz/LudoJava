package ludo;
import javax.swing.*;
import java.util.*;

public class Casa extends JLabel implements java.io.Serializable{
  private boolean coroa;
  private ArrayList ocupantes;
  public Casa() {
    super();
    coroa=false;
    ocupantes=new ArrayList();
    this.setIcon(null);
  }
  public Casa(boolean coroa) {
    super();
    this.coroa=coroa;
    ocupantes=new ArrayList();
    this.setIcon(null);
  }
  public void resetaCasa(){
    ocupantes=new ArrayList();
    this.setIcon(null);
  }

  public int getQtdPeoes(){
    return ocupantes.size();
  }
  public boolean getCoroa(){
    return coroa;
  }
  public String getCorPeao(){
    try{
      Peao aux=(Peao)ocupantes.get(0);
      return aux.getCor();
    }catch(IndexOutOfBoundsException e){
    }
    return null;
  }

  public ArrayList addPeao(Peao p){
    ArrayList aux=null;
    if(ocupantes.size()>0){
      Peao p_aux=(Peao)ocupantes.get(0);
      if(!p.getCor().equals(p_aux.getCor())){
        aux = new ArrayList();
        for(int i=0;i<ocupantes.size();i++){
          aux.add(ocupantes.get(i));
        }
        ocupantes.clear();
      }
    }
    ocupantes.add(p);
    trocaIcone();
    return aux;
  }

  public Peao tiraPeao(){
    Peao p=(Peao)ocupantes.remove(0);
    trocaIcone();
    return p;
  }
  public void atualiza(Casa c){
    this.ocupantes = c.ocupantes;
    trocaIcone();
  }

  private void trocaIcone(){
    if(ocupantes.size()==0){
      this.setIcon(null);
    }else{
      Peao p=(Peao)ocupantes.get(0);
      if(p.getCor().equals("Azul")){
        switch(ocupantes.size()){
          case 1:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaAzul.gif")));
            break;
          case 2:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaAzul2.gif")));
            break;
          case 3:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaAzul3.gif")));
            break;
          case 4:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaAzul4.gif")));
            break;
        }
      }
      if(p.getCor().equals("Verde")){
        switch(ocupantes.size()){
          case 1:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaVerde.gif")));
            break;
          case 2:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaVerde2.gif")));
            break;
          case 3:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaVerde3.gif")));
            break;
          case 4:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaVerde4.gif")));
            break;
        }
      }
      if(p.getCor().equals("Vermelho")){
        switch(ocupantes.size()){
          case 1:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaVermelha.gif")));
            break;
          case 2:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaVermelha2.gif")));
            break;
          case 3:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaVermelha3.gif")));
            break;
          case 4:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaVermelha4.gif")));
            break;
        }
      }
      if(p.getCor().equals("Rosa")){
        switch(ocupantes.size()){
          case 1:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaRosa.gif")));
            break;
          case 2:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaRosa2.gif")));
            break;
          case 3:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaRosa3.gif")));
            break;
          case 4:
            this.setIcon(new ImageIcon(Casa.class.getResource("pecaRosa4.gif")));
            break;
        }
      }

    }
  }
}





