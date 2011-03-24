package ludo;
import java.io.*;
import java.util.ArrayList;

public class LudoBD {
  public LudoBD() {
  }
  public void gravar(Object obj, String nomeArquivo){
    try{
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo+".LUD"));
      out.writeObject(obj);
      out.close();
    }catch(Exception e){
      System.out.println(e.toString());
      System.out.println("Não foi possivel gravar!");
    }
  }
  public ArrayList recuperar(File file){
    ArrayList array = new ArrayList();
    try{
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
      array = (ArrayList)in.readObject();
      in.close();
      return array;
    }catch(Exception ex_qq){
      System.out.println("DEU PAU!");
      return null;
    }
  }
}
