package ludo;
import java.util.*;

public class CasaSimples extends Casa{
  private String timeOcupante;

  public CasaSimples() {
    super();
    timeOcupante="";
  }

  public String getTimeOcupante(){
    return timeOcupante;
  }

  public ArrayList addPeao(Peao p){//retorna todos os peoes q estavam na casa caso sejam de cor diferente..
    ArrayList aux=new ArrayList();            //retorna eles,e adiciona o novo peao!
    if(ocupantes.size()>0){
      Peao p_aux=(Peao)ocupantes.get(0);
      if(!p.getCor().equals(p_aux.getCor())){
        for(int i=0;i<ocupantes.size();i++){
          aux.add(ocupantes.get(i));
        }
        ocupantes.clear();
      }
    }
    ocupantes.add(p);
    timeOcupante=p.getCor();
    trocaIcone();
    return aux;
  }


  public Peao tiraPeao(Jogador jog){
    Peao p=(Peao)ocupantes.remove(0);
    if(ocupantes.size()==0){
      this.timeOcupante="";
    }
    trocaIcone();
    return p;
  }


}
