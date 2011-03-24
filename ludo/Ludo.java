package ludo;
import java.util.*;
import java.io.*;

public class Ludo{
  private Dado dado=new Dado();
  private int nSorteado;
  private ArrayList jogadores = new ArrayList();
  private int jogadorAtual; //Pointer p/ a posição do jog atual no Array
  private LudoBD bd = new LudoBD();
  public Ludo() {
    jogadorAtual=0;
  }

  public ArrayList iniciaJogo(){
    //pega as cores de cada jogador, e a quant d epecas e e retorna um array list pro tabuleiro desenha na base!!
    Jogador jog;
    ArrayList peoes=new ArrayList();
    ArrayList aux;
    jogadorAtual=(int)(Math.random()*(jogadores.size()));
    this.getJogadorAtual().incChance();
    for(int i=0;i<jogadores.size();i++){
      jog=(Jogador)jogadores.get(i);
      aux=jog.getNaBase();
      for(int y=0;y<aux.size();y++){
        peoes.add(aux.get(y));
      }
    }
    return peoes;
  }
  public void insereJogador(String cor, String nome, int qtdPeças){
    Jogador j = new Jogador(nome,cor,qtdPeças);
    jogadores.add(j);
  }

  public int andaPeao(Peao p){
    int ret=0;
    if (p.getCasasPercorridas()==0){
      Jogador j =(Jogador)jogadores.get(jogadorAtual);
      ret=this.tiraBase(p);
    }else{
      p.anda(dado.getDadoFace());
      if(p.getCasasPercorridas()>48){
        ret=this.andaPeaoFinal(p);
      }else{
        ret=this.andaPeaoTab(p);
      }
    }
    return ret;
  }

  public int mandaBase(Peao p){
   int i=0;
   Jogador j;
   do{
     j=(Jogador)jogadores.get(i);
     i++;
   }while(!p.getCor().equals(j.getCor()));
   j.colocaPeaoNaBase(p);
   return getBase(p);
  }

  public int getBase(Peao p){
   int base=0;
   if(p.getCor().equals("Azul")){
     switch(p.getBase()){
       case 0:
         base=63;
         break;
       case 1:
         base=62;
         break;
       case 2:
         base=61;
         break;
       case 3:
         base=60;
         break;
     }
   }
   if(p.getCor().equals("Verde")){
     switch(p.getBase()){
       case 0:
         base=58;
         break;
       case 1:
         base=56;
         break;
       case 2:
         base=59;
         break;
       case 3:
         base=57;
         break;
     }
   }
   if(p.getCor().equals("Vermelho")){
     switch(p.getBase()){
       case 0:
         base=49;
         break;
       case 1:
         base=48;
         break;
       case 2:
         base=50;
         break;
       case 3:
         base=51;
         break;
     }
   }
   if(p.getCor().equals("Rosa")){
     switch(p.getBase()){
       case 0:
         base=53;
         break;
       case 1:
         base=55;
         break;
       case 2:
         base=54;
         break;
       case 3:
         base=52;
         break;
     }
   }
   return base;
  }

  private int tiraBase(Peao p){
    int ret=0;
    Jogador j=(Jogador)jogadores.get(jogadorAtual);
    j.colocaPeaoNoJogo(p);
    int x=0;
    if(j.getCor().equals("Rosa"))
       x=0;
    if(j.getCor().equals("Azul"))
       x=1;
    if(j.getCor().equals("Verde"))
       x=2;
    if(j.getCor().equals("Vermelho"))
       x=3;
    switch(x){
      case 0:
        ret=38;
        break;
      case 1:
        ret=26;
        break;
      case 2:
        ret=14;
        break;
      case 3:
        ret=2;
        break;
    }
    return ret;
  }

  private int andaPeaoTab(Peao p){
    int ret=0;
    Jogador j=(Jogador)jogadores.get(jogadorAtual);
    int x=0;
    if(j.getCor().equals("Rosa"))
       x=0;
    if(j.getCor().equals("Azul"))
       x=1;
    if(j.getCor().equals("Verde"))
       x=2;
    if(j.getCor().equals("Vermelho"))
       x=3;
    switch(x){
      case 0:
        ret=38;
        break;
      case 1:
        ret=26;
        break;
      case 2:
        ret=14;
        break;
      case 3:
        ret=2;
        break;
    }
    ret=p.getCasasPercorridas()+ret-1;
    if(ret>47)
      ret=ret-48;
    return ret;
  }

  private int andaPeaoFinal(Peao p){
    int ret=0;
    int cont=p.getCasasPercorridas()-48;
   if(cont!=6){
    if (cont>6){
      switch(cont){
        case 11:
          ret=1;
          break;
        case 10:
          ret=2;
          break;
        case 9:
          ret=3;
          break;
        case 8:
          ret=4;
          break;
        case 7:
          ret=5;
          break;
      }
    }else{
      ret=cont;
    }
    p.setPercorridas(48+ret);
    Jogador j=(Jogador)jogadores.get(jogadorAtual);
    int x=0;
    if(j.getCor().equals("Rosa"))
      x=0;
    if(j.getCor().equals("Azul"))
      x=1;
    if(j.getCor().equals("Verde"))
      x=2;
    if(j.getCor().equals("Vermelho"))
      x=3;
    switch(x){
      case 0:
        ret=ret+63;
        break;
      case 1:
        ret=ret+68;
        break;
      case 2:
        ret=ret+73;
        break;
      case 3:
        ret=ret+78;
        break;
    }
   }else{
     ret=this.ultimaCasa(p);

   }
    return ret;
  }
  private int ultimaCasa(Peao p){
    int ret=0;
    Jogador j=(Jogador)jogadores.get(jogadorAtual);
    j.tiraPeaoDoJogo(p);
    int x=0;
    if(j.getCor().equals("Rosa"))
       x=0;
    if(j.getCor().equals("Azul"))
       x=1;
    if(j.getCor().equals("Verde"))
       x=2;
    if(j.getCor().equals("Vermelho"))
       x=3;
    switch(x){
      case 0:
        ret=84;
        break;
      case 1:
        ret=85;
        break;
      case 2:
        ret=86;
        break;
      case 3:
        ret=87;
        break;
    }
    return ret;
  }

  public int rolaDado(){
    dado.rolaDado();
    nSorteado=dado.getDadoFace();
    return nSorteado;
  }

  public void passaTurno(){
    jogadorAtual=(jogadorAtual + 1) % jogadores.size();
    this.getJogadorAtual().incChance();
  }

  public Jogador getJogadorAtual(){
    Jogador j = (Jogador)jogadores.get(jogadorAtual);
    return j;
  }

  public boolean testeJogadaBase(Casa[] vetCasas,Casa cSource){
    int i=-1;
    if(cSource.getCorPeao().equals("Vermelho")){
      i=2;
    }else{
      if(cSource.getCorPeao().equals("Azul")){
        i=26;
      }else{
        if(cSource.getCorPeao().equals("Verde")){
          i=14;
        }else{
          if(cSource.getCorPeao().equals("Rosa")){
            i=38;
          }
        }
      }
    }
    int n=vetCasas[i].getQtdPeoes();
    if (n==0){
      if((nSorteado==6)||(nSorteado==1)){
        return true;
      }
    } else {
      if (vetCasas[i].getCorPeao().equals(cSource.getCorPeao())){
        if((nSorteado==6)||(nSorteado==1)){
          return true;
        }
      } else {
        if(((nSorteado==6)||(nSorteado==1))&&(n<2)){
          return true;
        }
      }
    }
    return false;
  }

  public boolean testeJogada(Casa[] vetCasas, int pos){
    if (pos<48){
      if (vetCasas[pos + nSorteado].getQtdPeoes() > 1) {
        return false;
      }
    }
    return true;
  }

  public void testeDaCoroa(Casa[] vetCasas, int pos, Peao p){
    if ((p.getCasasPercorridas()<50)&&(p.getCasasPercorridas()>1)){
      if (vetCasas[pos].getCoroa()==true){
        this.getJogadorAtual().incChance();
      }
    }
  }

  public String testeVencedor(){
    Jogador j = (Jogador)jogadores.get(jogadorAtual);
    if ((j.getQtBase()+j.getQtEmJogo())==0){
      return j.getNome();
    } else {
      return "";
    }
  }

  public int getNSorteado(){
    return nSorteado;
  }

  public void salvar(Casa vetCasas[], String nomeArq){
    ArrayList array = new ArrayList();
    for(int i=0; i<vetCasas.length; i++){
      array.add(vetCasas[i]);
    }
    for(int i=0; i<jogadores.size();i++){
      array.add(jogadores.get(i));
    }
    bd.gravar(array, nomeArq);
  }
  public ArrayList recuperar(int tamVetCasas, File file){
    ArrayList array = bd.recuperar(file);
    if (array!=null){
      jogadores.clear();
      for(int i=tamVetCasas; i<array.size();i++){
        Jogador j = (Jogador)array.get(i);
        jogadores.add(j);
      }
    }
    return array;
  }
}
