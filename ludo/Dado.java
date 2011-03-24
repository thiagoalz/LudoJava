package ludo;

import java.util.*;
public class Dado {
  private int faceUp;
  private Random r;
  public Dado() {
    faceUp=0;
    r=new Random();
  }
  public int rolaDado(){
    faceUp=r.nextInt(6)+1;
    return faceUp;
  }
  public int getDadoFace(){
    return faceUp;
  }
}
