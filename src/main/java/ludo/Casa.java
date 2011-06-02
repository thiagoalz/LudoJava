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

public abstract class Casa extends JLabel {
  protected ArrayList ocupantes;

  public Casa(){
    super();
    ocupantes=new ArrayList();
    this.setIcon(null);
  }

  abstract ArrayList addPeao(Peao p);
  abstract Peao tiraPeao(Jogador jog);

  public void resetaCasa(){
    ocupantes=new ArrayList();
    this.setIcon(null);
  }

  public int getQtdPeoes(){
    return ocupantes.size();
  }

  public boolean temPeaoLivre(String cor,int dado){//para ver se tem algum peao do jogador atual q pode mover!
    boolean ret=false;
    Peao p=null;
    for(int i=0;i<ocupantes.size();i++){
      p=(Peao)ocupantes.get(i);
      if(p.getCor().equals(cor)){
        ret=true;
        break;
      }
    }
    if(p!=null)
      if((p.getCasasPercorridas()==0)&&(dado!=6)){//testa se bote tirar da base!
        ret=false;
      }
    return ret;
  }

  protected void trocaIcone(){//atualiza a imagem da quantidade de peoes!!
    if(ocupantes.size()==0){
      this.setIcon(null);
    }else{
      Peao p=(Peao)ocupantes.get(0);
      if(p.getCor().equals("Azul")){
        switch(ocupantes.size()){
          case 1:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaAzul.png")));
            break;
          case 2:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaAzul2.png")));
            break;
          case 3:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaAzul3.png")));
            break;
          case 4:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaAzul4.png")));
            break;
        }
      }
      if(p.getCor().equals("Verde")){
        switch(ocupantes.size()){
          case 1:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaVerde.png")));
            break;
          case 2:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaVerde2.png")));
            break;
          case 3:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaVerde3.png")));
            break;
          case 4:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaVerde4.png")));
            break;
        }
      }
      if(p.getCor().equals("Vermelho")){
        switch(ocupantes.size()){
          case 1:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaVermelha.png")));
            break;
          case 2:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaVermelha2.png")));
            break;
          case 3:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaVermelha3.png")));
            break;
          case 4:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaVermelha4.png")));
            break;
        }
      }
      if(p.getCor().equals("Rosa")){
        switch(ocupantes.size()){
          case 1:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaRosa.png")));
            break;
          case 2:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaRosa2.png")));
            break;
          case 3:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaRosa3.png")));
            break;
          case 4:
            this.setIcon(new ImageIcon(Casa.class.getResource("/images/pecaRosa4.png")));
            break;
        }
      }

    }
  }


}
