package ludo;
import java.util.*;

public class Jogador {
  protected String corDoPeão;
  protected ArrayList qtdNaBase;
  protected ArrayList qtdNoJogo;
  protected String nome;
  protected int jogadas;

  public Jogador(String nome,String cor,int qt) {
    this.nome=nome;
    this.jogadas=0;
    this.corDoPeão=cor;
    qtdNaBase = new ArrayList();
    qtdNoJogo = new ArrayList();
    for(int i=0;i<qt;i++){
      Peao aux=new Peao(corDoPeão,i);
      qtdNaBase.add(aux);
    }
  }

  public void incJogadas(){
    jogadas++;
  }
  public void decJogadas(){
    jogadas--;
  }


  //gets
  public int getJogadas(){
    return jogadas;
  }

  public String getNome(){
    return nome;
  }

  public ArrayList getNaBase(){
    return qtdNaBase;
  }

  public int getQtBase(){
    return qtdNaBase.size();
  }

  public ArrayList getEmJogo(){
    return qtdNoJogo;
  }

  public int getQtEmJogo(){
    return qtdNoJogo.size();
  }
  public String getCor(){
    return corDoPeão;
  }

  //mexer os peoes!!
  public void tiraPeaoDoJogo(Peao p){
    qtdNoJogo.remove(p);
  }

  public void colocaPeaoNaBase(Peao p){
    qtdNaBase.add((Peao)qtdNoJogo.remove(qtdNoJogo.indexOf(p)));
    p.voltaBase();
  }
  public void colocaPeaoNoJogo(Peao p){
    qtdNoJogo.add((Peao)qtdNaBase.remove(qtdNaBase.indexOf(p)));
    p.vaiProJogo();
  }
}

