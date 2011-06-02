package ludo;

/*
 *
 *
*/
import java.util.*;
public class Jogo {
  private Dado dado;
  private ArrayList jogadores;
  private int jogadorAtual; //"apontador" p/ a posição do jog atual no ArrayList

  public Jogo() {
    jogadorAtual=0;
    jogadores = new ArrayList();
    dado=new Dado();
  }

  public ArrayList iniciaJogo(){
    //pega as cores de cada jogador, e a quant d epecas e e retorna um array list pro tabuleiro desenha na base!!
    Jogador jog;
    ArrayList peoes=new ArrayList();
    ArrayList aux;
    jogadorAtual=(int)(Math.random()*(jogadores.size()));
    for(int i=0;i<jogadores.size();i++){
      jog=(Jogador)jogadores.get(i);
      aux=jog.getNaBase();
      for(int y=0;y<aux.size();y++){
        peoes.add(aux.get(y));
      }
    }
    return peoes;
  }
  public void insereJogador(String cor, String nome, boolean pc, int qtdPeças){
    //Jogador j;//se der pau fazer co um objeto de Jog_Pc e um de Jogador;
    if(pc){
     Computador j_pc=new Computador(nome, cor, qtdPeças); //testar botando (Jog_Pc) ali na frente
     jogadores.add(j_pc);
    }else{
      Jogador j= new Jogador(nome, cor, qtdPeças);
      jogadores.add(j);
    }
  }

  public int andaPeao(Peao p,Casa[] vetCasas){//movimento do peao!
    int ret=0;
    if (p.getCasasPercorridas()==0){
      Jogador j =(Jogador)jogadores.get(jogadorAtual);
      ret=this.tiraBase(p);
    }else{
      if(p.getCasasPercorridas()+dado.getDadoFace()>48){
        ret=this.andaPeaoFinal(p);//movimentacao nas ultimas casas!
      }else{
        ret=this.andaPeaoTab(p,vetCasas);//movimentacao comun!
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

  public int getBase(Peao p){//retorna a posicao da base do respectivo peao!
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

  private int tiraBase(Peao p){//retorna a primeira casa do respectivo peao dependendo da sua cor
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

  private int andaPeaoTab(Peao p,Casa[] vetCasas){ //movimentacao comun!

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
    boolean frente=true;
    Casa casa=null;
    for(int i=0;i<dado.getDadoFace();i++){ //pega a proxima casa(ou a anterior)
      if(frente){                          //para ver se ela esta bloqueada ou nao(2 ou mais peoes)
        if(ret==47){
          casa=vetCasas[0];
        }else{
          casa=vetCasas[ret+1]; //para sesolver o problema do vetor nao ser circular!
        }                       //pode subistituir pror (x+1)%tamanho (testar depois!)
      }else{
        if(ret==0){
          casa=vetCasas[47];
        }else{
          casa=vetCasas[ret-1];
        }
      }
      if((casa.getQtdPeoes()>1)&&(!(casa instanceof CasaCoroa ))){
        CasaSimples c=(CasaSimples)casa;
        if(!c.getTimeOcupante().equals(p.getCor())){
          frente=!frente;
          i++;
        }else if (frente) {
          p.anda();
          ret++;
          if(ret>47)
            ret=ret-48;
        }else {
          p.volta();
          ret--;
          if(ret<0)
            ret=ret+48;
        }
      }else{
        if (frente) {
          p.anda();
          ret++;
          if(ret>47)
            ret=ret-48;
        }
        else {
          p.volta();
          ret--;
          if(ret<0)
            ret=ret+48;
        }
      }

    }
    return ret;
  }

  private int andaPeaoFinal(Peao p){//movimentacao nas ultimas casas!
    int ret=0;
    int cont=p.getCasasPercorridas()-48+dado.getDadoFace();
   if(cont!=6){
    if (cont>6){
      switch(cont){
        case 11:
          ret=2;
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

  private int ultimaCasa(Peao p){//poe na ultima casa e tira o peao do jogo!
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
    return dado.rolaDado();
  }
  public int getDadoFace(){
    return dado.getDadoFace();
  }

  public void passaTurno(){
    jogadorAtual=(jogadorAtual + 1) % jogadores.size();
  }

  public Jogador getJogadorAtual(){
    Jogador j = (Jogador)jogadores.get(jogadorAtual);
    return j;
  }

  public boolean testaAcabou(){
    boolean ret=false;
    Jogador j=(Jogador)jogadores.get(jogadorAtual);
    if((j.getEmJogo().size()==0)&&(j.getNaBase().size()==0)){
      ret=true;
    }
    return ret;
  }
  public int getCasaAtual(Peao p){
    int ret=0;
    int x=0;
    if(p.getCor().equals("Rosa"))
       x=0;
    if(p.getCor().equals("Azul"))
       x=1;
    if(p.getCor().equals("Verde"))
       x=2;
    if(p.getCor().equals("Vermelho"))
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
    if(p.getCasasPercorridas()==0){
      ret = this.getBase(p);
    }else if(p.getCasasPercorridas()>48) {
      ret=p.getCasasPercorridas()-48;
      int y=0;
      if(p.getCor().equals("Rosa"))
        y=0;
      if(p.getCor().equals("Azul"))
        y=1;
      if(p.getCor().equals("Verde"))
        y=2;
      if(p.getCor().equals("Vermelho"))
        y=3;
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
      ret += p.getCasasPercorridas() - 1;
      if(ret>47)
        ret-=48;
    }
    return ret;
  }
}
