package ludo;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TocaSons extends Thread{
  private AudioFormat audioFormat;
  private AudioInputStream audioInputStream;
  private SourceDataLine sourceDataLine;

  public TocaSons() {
  }

  public void playAudioFim() {
     try{
       File arquivoSom = new File("Applause.wav");
       audioInputStream = AudioSystem.getAudioInputStream(arquivoSom);
       audioFormat = audioInputStream.getFormat();
       DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
       sourceDataLine = (SourceDataLine)AudioSystem.getLine(dataLineInfo);
       new PlayThread().start();
     }
      catch (Exception e) {
       e.printStackTrace();
       System.exit(0);
     }
   }
   public void playAudioNJoga() {
     try{
       File arquivoSom = new File("pee.wav");
       audioInputStream = AudioSystem.getAudioInputStream(arquivoSom);
       audioFormat = audioInputStream.getFormat();
       DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
       sourceDataLine = (SourceDataLine)AudioSystem.getLine(dataLineInfo);
       new PlayThread().start();
     }
      catch (Exception e) {
       e.printStackTrace();
       System.exit(0);
     }
   }
   public void playAudioVoltaBase() {
     try{
       File arquivoSom = new File("Dmbullo.wav");
       audioInputStream = AudioSystem.getAudioInputStream(arquivoSom);
       audioFormat = audioInputStream.getFormat();
       DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
       sourceDataLine = (SourceDataLine)AudioSystem.getLine(dataLineInfo);
       new PlayThread().start();
     }
      catch (Exception e) {
       e.printStackTrace();
       System.exit(0);
     }
   }
   public void playAudioJogaDNovo() {
     try{
       File arquivoSom = new File("yeah.wav");
       audioInputStream = AudioSystem.getAudioInputStream(arquivoSom);
       audioFormat = audioInputStream.getFormat();
       DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
       sourceDataLine = (SourceDataLine)AudioSystem.getLine(dataLineInfo);
       new PlayThread().start();
     }
      catch (Exception e) {
       e.printStackTrace();
       System.exit(0);
     }
   }




   class PlayThread extends Thread{
     byte tempBuffer[] = new byte[100];

     public void run(){
       try{
         sourceDataLine.open(audioFormat);
         sourceDataLine.start();

         int cnt;
         //Keep looping until the input read method
         // returns -1 for empty stream or the
      // user clicks the Stop button causing
      // stopPlayback to switch from false to
      // true.
      while((cnt = audioInputStream.read(tempBuffer,0,tempBuffer.length)) != -1){
        if(cnt > 0){
          //Write data to the internal buffer of
          // the data line where it will be
          // delivered to the speaker.
          sourceDataLine.write(tempBuffer, 0, cnt);
        }//end if
      }//end while
      //Block and wait for internal buffer of the
      // data line to empty.
      ///*//*/*/*/*/*/*/*/*/*/*/*/**/*/**//*qqqqqqqqqqqqqq
      //sourceDataLine.drain();
      sourceDataLine.close();
    }catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }//end catch
  }//end run
}////end inner class PlayThread

}

