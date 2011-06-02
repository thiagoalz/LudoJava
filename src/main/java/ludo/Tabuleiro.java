package ludo;
//import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
//import java.applet.*;

/**
 * <p>Tulo: Jogo de Ludo</p>
 * <p>Copyright: Thiago Lechuga Copyright (c) 2004</p >
 * <p>Company: Paulista´s company</p>
 * @version 1.0
 */

 
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
/**
  * setToltipText-> para aparecer quando dexa o mouse parado em cima!!
 */

public class Tabuleiro extends JFrame{
  //tipos de cursor!
  Cursor hand=new Cursor(Cursor.HAND_CURSOR);
  Cursor seta=new Cursor(Cursor.DEFAULT_CURSOR);
  //sons
  //TocaSons tocaSoms=new TocaSons();
  //os 2 objetos de Mouse listener!
  MouseListener actFocus=new java.awt.event.MouseAdapter() {
    public void mouseEntered(MouseEvent e) {
      casa_mouseEntered(e);
    }

    public void mouseExited(MouseEvent e) {
      casa_mouseExited(e);
    }
  };

  MouseListener actClick=new java.awt.event.MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
      casa_mouseClicked(e);
    }
  };

  Casa[] vetCasas=new Casa[88];
  Jogo jogo;
  JLabel jLabelTabuleiro = new JLabel();
  JFrame formLudo=new JFrame("Novo Jogo");
  //JFrame regras=new JFrame("Regras");
  //JFrame creditos=new JFrame("Creditos");
  JRadioButton jRadioButtonPcVermelho = new JRadioButton();
  JCheckBox jCheckBoxAzul = new JCheckBox();
  JCheckBox jCheckBoxRosa = new JCheckBox();
  JRadioButton jRadioButtonPcVerde = new JRadioButton();
  JLabel jLabelquant = new JLabel();
  JButton jButtonOk = new JButton();
  JRadioButton jRadioButtonJogVermelho = new JRadioButton();
  JTextField jTextFieldVermelho = new JTextField();
  JRadioButton jRadioButtonPcAzul = new JRadioButton();
  JRadioButton jRadioButtonPcRosa = new JRadioButton();
  JComboBox jComboBoxQuant = new JComboBox();
  JButton jButtonCancelar = new JButton();
  JTextField jTextFieldVerde = new JTextField();
  JRadioButton jRadioButtonJogRosa = new JRadioButton();
  JRadioButton jRadioButtonJogAzul = new JRadioButton();
  JRadioButton jRadioButtonJogVerde = new JRadioButton();
  JCheckBox jCheckBoxVermelho = new JCheckBox();
  JTextField jTextFieldAzul = new JTextField();
  JCheckBox jCheckBoxVerde = new JCheckBox();
  JTextField jTextFieldRosa = new JTextField();
  ButtonGroup buttonGroupAzul = new ButtonGroup();
  ButtonGroup buttonGroupVerde = new ButtonGroup();
  ButtonGroup buttonGroupVermelho = new ButtonGroup();
  ButtonGroup buttonGroupRosa = new ButtonGroup();
  Casa casa0 = new CasaSimples();
  Casa casa1 = new CasaSimples();
  Casa casa2 = new CasaCoroa();
  Casa casa3 = new CasaSimples();
  Casa casa4 = new CasaSimples();
  Casa casa5 = new CasaCoroa();
  Casa casa6 = new CasaSimples();
  Casa casa7 = new CasaSimples();
  Casa casa8 = new CasaCoroa();
  Casa casa9 = new CasaSimples();
  Casa casa10 = new CasaSimples();
  Casa casa11 = new CasaCoroa();
  Casa casa12 = new CasaSimples();
  Casa casa13 = new CasaSimples();
  Casa casa14 = new CasaCoroa();
  Casa casa15 = new CasaSimples();
  Casa casa16 = new CasaSimples();
  Casa casa17 = new CasaCoroa();
  Casa casa18 = new CasaSimples();
  Casa casa19 = new CasaSimples();
  Casa casa20 = new CasaCoroa();
  Casa casa21 = new CasaSimples();
  Casa casa22 = new CasaSimples();
  Casa casa23 = new CasaCoroa();
  Casa casa24 = new CasaSimples();
  Casa casa25 = new CasaSimples();
  Casa casa26 = new CasaCoroa();
  Casa casa27 = new CasaSimples();
  Casa casa28 = new CasaSimples();
  Casa casa29 = new CasaCoroa();
  Casa casa30 = new CasaSimples();
  Casa casa31 = new CasaSimples();
  Casa casa32 = new CasaCoroa();
  Casa casa33 = new CasaSimples();
  Casa casa34 = new CasaSimples();
  Casa casa35 = new CasaCoroa();
  Casa casa36 = new CasaSimples();
  Casa casa37 = new CasaSimples();
  Casa casa38 = new CasaCoroa();
  Casa casa39 = new CasaSimples();
  Casa casa40 = new CasaSimples();
  Casa casa41 = new CasaCoroa();
  Casa casa42 = new CasaSimples();
  Casa casa43 = new CasaSimples();
  Casa casa44 = new CasaCoroa();
  Casa casa45 = new CasaSimples();
  Casa casa46 = new CasaSimples();
  Casa casa47 = new CasaCoroa();
  Casa baseVerm2 = new CasaSimples();
  Casa baseVerm1 = new CasaSimples();
  Casa baseVerm3 = new CasaSimples();
  Casa baseVerm4 = new CasaSimples();
  Casa baseRosa1 = new CasaSimples();
  Casa baseRosa4 = new CasaSimples();
  Casa baseRosa3 = new CasaSimples();
  Casa baseRosa2 = new CasaSimples();
  Casa baseVerde2 = new CasaSimples();
  Casa baseVerde4 = new CasaSimples();
  Casa baseVerde1 = new CasaSimples();
  Casa baseVerde3 = new CasaSimples();
  Casa baseAzul3 = new CasaSimples();
  Casa baseAzul2 = new CasaSimples();
  Casa baseAzul1 = new CasaSimples();
  Casa baseAzul4 = new CasaSimples();
  Casa cRosa2 = new CasaSimples();
  Casa cRosa3 = new CasaSimples();
  Casa cRosa4 = new CasaSimples();
  Casa cRosa5 = new CasaSimples();
  Casa cRosa6 = new CasaSimples();
  Casa cAzul2 = new CasaSimples();
  Casa cAzul3 = new CasaSimples();
  Casa cAzul4 = new CasaSimples();
  Casa cAzul5 = new CasaSimples();
  Casa cAzul6 = new CasaSimples();
  Casa cVerde2 = new CasaSimples();
  Casa cVerde3 = new CasaSimples();
  Casa cVerde4 = new CasaSimples();
  Casa cVerde5 = new CasaSimples();
  Casa cVerde6 = new CasaSimples();
  Casa cVerm2 = new CasaSimples();
  Casa cVerm3 = new CasaSimples();
  Casa cVerm4 = new CasaSimples();
  Casa cVerm5 = new CasaSimples();
  Casa cVerm6 = new CasaSimples();
  JLabel jLabelVez = new JLabel();
  JTextField jTextFieldJogador = new JTextField();
  JButton jButtonJogar = new JButton();
  JLabel jLabelDado = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  TitledBorder titledBorder1;
  JTextPane jTextPaneHistorico = new JTextPane();
  JButton jButtonHistorico = new JButton();
  Border border1;
  TitledBorder titledBorder2;
  Border border2;
  TitledBorder titledBorder3;
  Border border3;
  TitledBorder titledBorder4;
  //TitledBorder titledBorder1;
  public Tabuleiro() {
    super("Ludo Java 1.0");
    formLudo.setSize(500,250);
    formLudo.setVisible(false);
    //construçao da barra de menu!
    JMenuBar bar=new JMenuBar();
    setJMenuBar(bar);
    JMenu menuJogo=new JMenu("Jogo");
    menuJogo.setMnemonic('J');
    JMenuItem novoJogoItem=new JMenuItem("Novo Jogo");
    novoJogoItem.setMnemonic('n');
    novoJogoItem.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          formLudo.show();
        }
      }
    );
    menuJogo.add(novoJogoItem);
    menuJogo.addSeparator();
    JMenuItem sairItem=new JMenuItem("Sair");
    sairItem.setMnemonic('s');
    sairItem.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          System.exit(0);
        }
      }
    );
    menuJogo.add(sairItem);
    bar.add(menuJogo);
  /*JMenu menuHelp=new JMenu("Help");
    menuJogo.setMnemonic('h');
    JMenuItem regrasItem=new JMenuItem("Regras");
    regrasItem.setMnemonic('r');
    regrasItem.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          regras.show();
        }
      }
    );
    menuHelp.add(regrasItem);
    menuHelp.addSeparator();
    JMenuItem creditosItem=new JMenuItem("Creditos");
    creditosItem.setMnemonic('c');
    creditosItem.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          creditos.show();
        }
      }
    );
    menuHelp.add(creditosItem);
    bar.add(menuHelp);*/
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Tabuleiro tab=new Tabuleiro();
    tab.addWindowListener(
      new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
        }
      }
    );

    tab.setSize(850,490);
    tab.show();
    tab.setSize(555,490);
  }
  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    border1 = BorderFactory.createLineBorder(Color.black,2);
    titledBorder2 = new TitledBorder(border1,"Historico");
    border2 = BorderFactory.createLineBorder(Color.black,2);
    titledBorder3 = new TitledBorder(border2,"Historico");
    border3 = BorderFactory.createLineBorder(new Color(127, 157, 185),2);
    titledBorder4 = new TitledBorder(BorderFactory.createLineBorder(Color.black,2),"Historico");
    jButtonJogar.setToolTipText("Clique Para Rolar o Dado");
    jLabelTabuleiro.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/tabuleiro.png")));
    //jLabelTabuleiro.setDisabledIcon(new ImageIcon(Interface.class.getResource("ludo.JPG")));
    jLabelTabuleiro.setBounds(new Rectangle(107, 2, 432, 441));
    this.getContentPane().setLayout(null);
    formLudo.getContentPane().setLayout(null);
    jRadioButtonPcVermelho.setBounds(new Rectangle(313, 95, 53, 20));
    jRadioButtonPcVermelho.setBackground(new Color(241, 234, 64));
    jRadioButtonPcVermelho.setText("PC");
    jRadioButtonPcVermelho.setSelected(true);
    jCheckBoxAzul.setBackground(new Color(241, 234, 64));
    jCheckBoxAzul.setText("Azul");
    jCheckBoxAzul.setBounds(new Rectangle(5, 37, 88, 17));
    jCheckBoxRosa.setBounds(new Rectangle(5, 129, 88, 17));
    jCheckBoxRosa.setBackground(new Color(241, 234, 64));
    jCheckBoxRosa.setSelectedIcon(null);
    jCheckBoxRosa.setText("Rosa");
    jRadioButtonPcVerde.setBounds(new Rectangle(313, 64, 53, 20));
    jRadioButtonPcVerde.setBackground(new Color(241, 234, 64));
    jRadioButtonPcVerde.setText("PC");
    jRadioButtonPcVerde.setSelected(true);
    jLabelquant.setText("Qant pecas");
    jLabelquant.setBounds(new Rectangle(391, 39, 71, 17));
    jButtonOk.setBounds(new Rectangle(269, 168, 85, 26));
    jButtonOk.setText("Ok");
    jButtonOk.addActionListener(new Tabuleiro_jButtonOk_actionAdapter(this));
    jButtonHistorico.addActionListener(new Tabuleiro_jButtonHistorico_actionAdapter(this));
    jRadioButtonJogVermelho.setBounds(new Rectangle(234, 95, 79, 21));
    jRadioButtonJogVermelho.setText("Jogador");
    jRadioButtonJogVermelho.setBackground(new Color(241, 234, 64));
    jRadioButtonJogVermelho.setSelected(false);
    jTextFieldVermelho.setBounds(new Rectangle(109, 95, 110, 20));
    jTextFieldVermelho.setText("Vermelho");
    jRadioButtonPcAzul.setBackground(new Color(241, 234, 64));
    jRadioButtonPcAzul.setText("PC");
    jRadioButtonPcAzul.setBounds(new Rectangle(313, 35, 53, 20));
    jRadioButtonPcAzul.setSelected(true);
    jRadioButtonPcRosa.setBounds(new Rectangle(313, 127, 53, 20));
    jRadioButtonPcRosa.setBackground(new Color(241, 234, 64));
    jRadioButtonPcRosa.setText("PC");
    jRadioButtonPcRosa.setSelected(true);
    jComboBoxQuant.setBackground(new Color(241, 234, 64));
    jComboBoxQuant.setBorder(BorderFactory.createLineBorder(Color.black));
    jComboBoxQuant.setBounds(new Rectangle(402, 67, 46, 21));
    jButtonCancelar.setText("Cancelar");
    jButtonCancelar.addActionListener(new Tabuleiro_jButtonCancelar_actionAdapter(this));
    jButtonCancelar.setBounds(new Rectangle(363, 167, 85, 26));
    jTextFieldVerde.setBounds(new Rectangle(109, 64, 110, 20));
    jTextFieldVerde.setText("Verde");
    jRadioButtonJogRosa.setBounds(new Rectangle(234, 127, 79, 21));
    jRadioButtonJogRosa.setText("Jogador");
    jRadioButtonJogRosa.setBackground(new Color(241, 234, 64));
    jRadioButtonJogRosa.setSelected(false);
    jRadioButtonJogAzul.setBackground(new Color(241, 234, 64));
    jRadioButtonJogAzul.setSelected(false);
    jRadioButtonJogAzul.setText("Jogador");
    jRadioButtonJogAzul.setBounds(new Rectangle(234, 35, 79, 21));
    jRadioButtonJogVerde.setBounds(new Rectangle(234, 64, 79, 21));
    jRadioButtonJogVerde.setText("Jogador");
    jRadioButtonJogVerde.setBackground(new Color(241, 234, 64));
    jRadioButtonJogVerde.setSelected(false);
    jCheckBoxVermelho.setBounds(new Rectangle(5, 97, 88, 17));
    jCheckBoxVermelho.setBackground(new Color(241, 234, 64));
    jCheckBoxVermelho.setRolloverEnabled(true);
    jCheckBoxVermelho.setSelected(false);
    jCheckBoxVermelho.setText("Vermelho");
    jTextFieldAzul.setText("Azul");
    jTextFieldAzul.setBounds(new Rectangle(109, 35, 110, 20));
    jCheckBoxVerde.setBounds(new Rectangle(5, 66, 88, 17));
    jCheckBoxVerde.setBackground(new Color(241, 234, 64));
    jCheckBoxVerde.setText("Verde");
    jTextFieldRosa.setBounds(new Rectangle(109, 127, 110, 20));
    jTextFieldRosa.setText("Rosa");
    formLudo.getContentPane().setBackground(new Color(241, 234, 64));
    this.getContentPane().setBackground(new Color(0, 128, 128));
    casa1.setText("");
    casa1.setBounds(new Rectangle(120, 173, 29, 29));
    casa2.setBounds(new Rectangle(152, 173, 29, 29));
    casa2.setText("");
    casa3.setBounds(new Rectangle(184, 173, 29, 29));
    casa3.setText("");
    casa4.setBounds(new Rectangle(216, 173, 29, 29));
    casa4.setText("");
    casa5.setBounds(new Rectangle(248, 173, 29, 29));
    casa5.setText("");
    casa6.setBounds(new Rectangle(248, 141, 29, 29));
    casa6.setText("");
    casa7.setBounds(new Rectangle(280, 141, 29, 29));
    casa7.setText("");
    casa8.setBounds(new Rectangle(280, 109, 29, 29));
    casa8.setText("");
    casa9.setBounds(new Rectangle(280, 77, 29, 29));
    casa9.setText("");
    casa10.setBounds(new Rectangle(280, 45, 29, 29));
    casa10.setText("");
    casa11.setBounds(new Rectangle(280, 13, 29, 29));
    casa11.setText("");
    casa12.setBounds(new Rectangle(312, 13, 29, 29));
    casa12.setText("");
    casa13.setBounds(new Rectangle(344, 13, 29, 29));
    casa13.setText("");
    casa14.setBounds(new Rectangle(344, 45, 29, 29));
    casa14.setText("");
    casa15.setBounds(new Rectangle(344, 77, 29, 29));
    casa15.setText("");
    casa16.setBounds(new Rectangle(344, 109, 29, 29));
    casa16.setText("");
    casa17.setBounds(new Rectangle(344, 141, 29, 29));
    casa17.setText("");
    casa18.setBounds(new Rectangle(376, 141, 29, 29));
    casa18.setText("");
    casa19.setBounds(new Rectangle(376, 173, 29, 29));
    casa19.setText("");
    casa20.setBounds(new Rectangle(408, 173, 29, 29));
    casa20.setText("");
    casa21.setBounds(new Rectangle(440, 173, 29, 29));
    casa21.setText("");
    casa22.setBounds(new Rectangle(472, 173, 29, 29));
    casa22.setText("");
    casa23.setBounds(new Rectangle(504, 173, 29, 29));
    casa23.setText("");
    casa24.setBounds(new Rectangle(504, 205, 29, 29));
    casa24.setText("");
    casa25.setBounds(new Rectangle(504, 237, 29, 29));
    casa25.setText("");
    casa26.setBounds(new Rectangle(472, 237, 29, 29));
    casa26.setText("");
    casa27.setBounds(new Rectangle(440, 236, 29, 29));
    casa27.setText("");
    casa28.setBounds(new Rectangle(408, 237, 29, 29));
    casa28.setAlignmentY((float) 0.5);
    casa28.setText("");
    casa29.setBounds(new Rectangle(376, 237, 29, 29));
    casa29.setText("");
    casa30.setBounds(new Rectangle(376, 269, 29, 29));
    casa30.setText("");
    casa31.setBounds(new Rectangle(344, 269, 29, 29));
    casa31.setText("");
    casa32.setBounds(new Rectangle(344, 301, 29, 29));
    casa32.setText("");
    casa33.setBounds(new Rectangle(344, 333, 29, 29));
    casa33.setText("");
    casa34.setBounds(new Rectangle(344, 365, 29, 29));
    casa34.setText("");
    casa35.setBounds(new Rectangle(344, 397, 29, 29));
    casa35.setText("");
    casa36.setBounds(new Rectangle(312, 397, 29, 29));
    casa36.setText("");
    casa37.setBounds(new Rectangle(280, 397, 29, 29));
    casa37.setText("");
    casa38.setBounds(new Rectangle(280, 365, 29, 29));
    casa38.setText("");
    casa39.setBounds(new Rectangle(280, 333, 29, 29));
    casa39.setText("");
    casa40.setBounds(new Rectangle(280, 301, 29, 29));
    casa40.setText("");
    casa41.setBounds(new Rectangle(279, 269, 29, 29));
    casa41.setText("");
    casa42.setBounds(new Rectangle(248, 269, 29, 29));
    casa42.setText("");
    casa43.setBounds(new Rectangle(248, 237, 29, 29));
    casa43.setText("");
    casa44.setBounds(new Rectangle(216, 237, 29, 29));
    casa44.setText("");
    casa45.setBounds(new Rectangle(184, 237, 29, 29));
    casa45.setText("");
    casa46.setBounds(new Rectangle(152, 237, 29, 29));
    casa46.setText("");
    casa47.setBounds(new Rectangle(120, 236, 29, 29));
    casa47.setText("");
    casa0.setBounds(new Rectangle(120, 205, 29, 29));
    casa0.setText("");
    baseVerm2.setText("");
    baseVerm2.setBounds(new Rectangle(137, 105, 32, 31));
    baseVerm1.setText("");
    baseVerm1.setBounds(new Rectangle(182, 105, 32, 31));
    baseVerm3.setText("");
    baseVerm3.setBounds(new Rectangle(182, 46, 32, 31));
    baseVerm4.setText("");
    baseVerm4.setBounds(new Rectangle(137, 46, 32, 31));
    baseRosa1.setBounds(new Rectangle(182, 312, 32, 31));
    baseRosa1.setText("");
    baseRosa4.setBounds(new Rectangle(137, 377, 32, 31));
    baseRosa4.setText("");
    baseRosa3.setBounds(new Rectangle(182, 377, 32, 31));
    baseRosa3.setText("");
    baseRosa2.setBounds(new Rectangle(137, 312, 32, 31));
    baseRosa2.setText("");
    baseVerde2.setText("");
    baseVerde2.setBounds(new Rectangle(466, 105, 32, 31));
    baseVerde4.setText("");
    baseVerde4.setBounds(new Rectangle(466, 46, 32, 31));
    baseVerde1.setText("");
    baseVerde1.setBounds(new Rectangle(421, 105, 32, 31));
    baseVerde3.setText("");
    baseVerde3.setBounds(new Rectangle(421, 46, 32, 31));
    baseAzul3.setBounds(new Rectangle(421, 377, 32, 31));
    baseAzul3.setText("");
    baseAzul2.setBounds(new Rectangle(466, 312, 32, 31));
    baseAzul2.setText("");
    baseAzul1.setBounds(new Rectangle(421, 312, 32, 31));
    baseAzul1.setText("");
    baseAzul4.setBounds(new Rectangle(466, 377, 32, 31));
    baseAzul4.setText("");
    cRosa2.setBounds(new Rectangle(312, 365, 29, 29));
    cRosa2.setText("");
    cRosa3.setBounds(new Rectangle(312, 333, 29, 29));
    cRosa3.setText("");
    cRosa4.setBounds(new Rectangle(312, 301, 29, 29));
    cRosa4.setText("");
    cRosa5.setBounds(new Rectangle(312, 269, 29, 29));
    cRosa5.setText("");
    cRosa6.setBounds(new Rectangle(311, 234, 29, 29));
    cRosa6.setText("");
    cAzul2.setText("");
    cAzul2.setBounds(new Rectangle(472, 205, 29, 29));
    cAzul3.setText("");
    cAzul3.setBounds(new Rectangle(440, 205, 29, 29));
    cAzul4.setText("");
    cAzul4.setBounds(new Rectangle(408, 205, 29, 29));
    cAzul5.setText("");
    cAzul5.setBounds(new Rectangle(376, 205, 29, 29));
    cAzul6.setText("");
    cAzul6.setBounds(new Rectangle(340, 206, 29, 29));
    cVerde2.setText("");
    cVerde2.setBounds(new Rectangle(311, 45, 29, 29));
    cVerde3.setText("");
    cVerde3.setBounds(new Rectangle(312, 77, 29, 29));
    cVerde4.setText("");
    cVerde4.setBounds(new Rectangle(312, 109, 29, 29));
    cVerde5.setText("");
    cVerde5.setBounds(new Rectangle(312, 141, 29, 29));
    cVerde6.setText("");
    cVerde6.setBounds(new Rectangle(311, 177, 29, 29));
    cVerm2.setText("");
    cVerm2.setBounds(new Rectangle(152, 205, 29, 29));
    cVerm3.setText("");
    cVerm3.setBounds(new Rectangle(184, 205, 29, 29));
    cVerm4.setText("");
    cVerm4.setBounds(new Rectangle(216, 205, 29, 29));
    cVerm5.setText("");
    cVerm5.setBounds(new Rectangle(248, 205, 29, 29));
    cVerm6.setText("");
    cVerm6.setBounds(new Rectangle(282, 206, 29, 29));
    jLabelVez.setRequestFocusEnabled(true);
    jLabelVez.setText(" Jogador Da Vez :");
    jLabelVez.setBounds(new Rectangle(17, 28, 101, 19));
    jTextFieldJogador.setEnabled(false);
    jTextFieldJogador.setFont(new java.awt.Font("Dialog", 1, 11));
    jTextFieldJogador.setDisabledTextColor(Color.white);
    jTextFieldJogador.setEditable(false);
    jTextFieldJogador.setText("  Jogo Não Iniciado");
    jTextFieldJogador.setBounds(new Rectangle(8, 52, 117, 19));
    jButtonJogar.setBackground(new Color(0, 128, 128));
    jButtonJogar.setBounds(new Rectangle(37, 183, 47, 58));
    jButtonJogar.setEnabled(false);
    jButtonJogar.setBorder(BorderFactory.createRaisedBevelBorder());
    jButtonJogar.setActionCommand("jButton1");
    jButtonJogar.setContentAreaFilled(false);
    jButtonJogar.setIcon(null);
    jButtonJogar.setText("Jogar!");
    jButtonJogar.addActionListener(new Tabuleiro_jButtonJogar_actionAdapter(this));
    jLabelDado.setToolTipText("Clique em um peao para andar!");
    jLabelDado.setText("");
    jLabelDado.setBounds(new Rectangle(38, 183, 46, 59));
    jLabelDado.addMouseListener(new Tabuleiro_jLabelDado_mouseAdapter(this));
    jScrollPane1.getViewport().setBackground(UIManager.getColor("TabbedPane.foreground"));
    jScrollPane1.setBorder(titledBorder4);
    jScrollPane1.setBounds(new Rectangle(548, 19, 281, 407));
    jTextPaneHistorico.setBackground(new Color(0, 128, 128));
    jTextPaneHistorico.setForeground(Color.black);
    jTextPaneHistorico.setBorder(null);
    jTextPaneHistorico.setCaretColor(Color.black);
    jTextPaneHistorico.setEditable(false);
    jTextPaneHistorico.setSelectionColor(Color.lightGray);
    jTextPaneHistorico.setText("Jogo Nao Iniciado!!");
    jButtonHistorico.setBounds(new Rectangle(418, 362, 116, 41));
    jButtonHistorico.setBackground(new Color(0, 128, 128));
    jButtonHistorico.setBounds(new Rectangle(12, 275, 101, 32));
    jButtonHistorico.setBorder(BorderFactory.createRaisedBevelBorder());
    jButtonHistorico.setOpaque(false);
    jButtonHistorico.setBorderPainted(true);
    jButtonHistorico.setContentAreaFilled(false);
    jButtonHistorico.setSelected(false);
    jButtonHistorico.setText("Mostrar Log");
    formLudo.getContentPane().add(jRadioButtonPcVermelho, null);
    formLudo.getContentPane().add(jCheckBoxAzul, null);
    formLudo.getContentPane().add(jCheckBoxRosa, null);
    formLudo.getContentPane().add(jRadioButtonPcVerde, null);
    formLudo.getContentPane().add(jLabelquant, null);
    formLudo.getContentPane().add(jButtonOk, null);
    formLudo.getContentPane().add(jRadioButtonJogVermelho, null);
    formLudo.getContentPane().add(jTextFieldVermelho, null);
    formLudo.getContentPane().add(jRadioButtonPcAzul, null);
    formLudo.getContentPane().add(jRadioButtonPcRosa, null);
    formLudo.getContentPane().add(jComboBoxQuant, null);
    formLudo.getContentPane().add(jButtonCancelar, null);
    formLudo.getContentPane().add(jTextFieldVerde, null);
    formLudo.getContentPane().add(jRadioButtonJogRosa, null);
    formLudo.getContentPane().add(jRadioButtonJogAzul, null);
    formLudo.getContentPane().add(jRadioButtonJogVerde, null);
    formLudo.getContentPane().add(jCheckBoxVermelho, null);
    formLudo.getContentPane().add(jTextFieldAzul, null);
    formLudo.getContentPane().add(jCheckBoxVerde, null);
    formLudo.getContentPane().add(jTextFieldRosa, null);
    jComboBoxQuant.addItem("4");
    jComboBoxQuant.addItem("3");
    jComboBoxQuant.addItem("2");
    jComboBoxQuant.addItem("1");
    buttonGroupAzul.add(jRadioButtonJogAzul);
    buttonGroupAzul.add(jRadioButtonPcAzul);
    buttonGroupVerde.add(jRadioButtonJogVerde);
    buttonGroupVerde.add(jRadioButtonPcVerde);
    buttonGroupVermelho.add(jRadioButtonJogVermelho);
    buttonGroupVermelho.add(jRadioButtonPcVermelho);
    buttonGroupRosa.add(jRadioButtonJogRosa);
    buttonGroupRosa.add(jRadioButtonPcRosa);
    //casas comuns
    this.getContentPane().add(casa0, null);
    vetCasas[0]=casa0;
    this.getContentPane().add(casa1, null);
    vetCasas[1]=casa1;
    this.getContentPane().add(casa2, null);
    vetCasas[2]=casa2;
    this.getContentPane().add(casa3, null);
    vetCasas[3]=casa3;
    this.getContentPane().add(casa4, null);
    vetCasas[4]=casa4;
    this.getContentPane().add(casa5, null);
    vetCasas[5]=casa5;
    this.getContentPane().add(casa6, null);
    vetCasas[6]=casa6;
    this.getContentPane().add(casa7, null);
    vetCasas[7]=casa7;
    this.getContentPane().add(casa8, null);
    vetCasas[8]=casa8;
    this.getContentPane().add(casa9, null);
    vetCasas[9]=casa9;
    this.getContentPane().add(casa10, null);
    vetCasas[10]=casa10;
    this.getContentPane().add(casa11, null);
    vetCasas[11]=casa11;
    this.getContentPane().add(casa12, null);
    vetCasas[12]=casa12;
    this.getContentPane().add(casa13, null);
    vetCasas[13]=casa13;
    this.getContentPane().add(casa14, null);
    vetCasas[14]=casa14;
    this.getContentPane().add(casa15, null);
    vetCasas[15]=casa15;
    this.getContentPane().add(casa16, null);
    vetCasas[16]=casa16;
    this.getContentPane().add(casa17, null);
    vetCasas[17]=casa17;
    this.getContentPane().add(casa18, null);
    vetCasas[18]=casa18;
    this.getContentPane().add(casa19, null);
    vetCasas[19]=casa19;
    this.getContentPane().add(casa20, null);
    vetCasas[20]=casa20;
    this.getContentPane().add(casa21, null);
    vetCasas[21]=casa21;
    this.getContentPane().add(casa22, null);
    vetCasas[22]=casa22;
    this.getContentPane().add(casa23, null);
    vetCasas[23]=casa23;
    this.getContentPane().add(casa24, null);
    vetCasas[24]=casa24;
    this.getContentPane().add(casa25, null);
    vetCasas[25]=casa25;
    this.getContentPane().add(casa26, null);
    vetCasas[26]=casa26;
    this.getContentPane().add(casa27, null);
    vetCasas[27]=casa27;
    this.getContentPane().add(casa28, null);
    vetCasas[28]=casa28;
    this.getContentPane().add(casa29, null);
    vetCasas[29]=casa29;
    this.getContentPane().add(casa30, null);
    vetCasas[30]=casa30;
    this.getContentPane().add(casa31, null);
    vetCasas[31]=casa31;
    this.getContentPane().add(casa32, null);
    vetCasas[32]=casa32;
    this.getContentPane().add(casa33, null);
    vetCasas[33]=casa33;
    this.getContentPane().add(casa34, null);
    vetCasas[34]=casa34;
    this.getContentPane().add(casa35, null);
    vetCasas[35]=casa35;
    this.getContentPane().add(casa36, null);
    vetCasas[36]=casa36;
    this.getContentPane().add(casa37, null);
    vetCasas[37]=casa37;
    this.getContentPane().add(casa38, null);
    vetCasas[38]=casa38;
    this.getContentPane().add(casa39, null);
    vetCasas[39]=casa39;
    this.getContentPane().add(casa40, null);
    vetCasas[40]=casa40;
    this.getContentPane().add(casa41, null);
    vetCasas[41]=casa41;
    this.getContentPane().add(casa42, null);
    vetCasas[42]=casa42;
    this.getContentPane().add(casa43, null);
    vetCasas[43]=casa43;
    this.getContentPane().add(casa44, null);
    vetCasas[44]=casa44;
    this.getContentPane().add(casa45, null);
    vetCasas[45]=casa45;
    this.getContentPane().add(casa46, null);
    vetCasas[46]=casa46;
    this.getContentPane().add(casa47, null);
    vetCasas[47]=casa47;

  //Casas da Base
    this.getContentPane().add(baseVerm2, null);
    vetCasas[48]=baseVerm2;
    this.getContentPane().add(baseVerm1, null);
    vetCasas[49]=baseVerm1;
    this.getContentPane().add(baseVerm3, null);
    vetCasas[50]=baseVerm3;
    this.getContentPane().add(baseVerm4, null);
    vetCasas[51]=baseVerm4;

    this.getContentPane().add(baseRosa4, null);
    vetCasas[52]=baseRosa4;
    this.getContentPane().add(baseRosa1, null);
    vetCasas[53]=baseRosa1;
    this.getContentPane().add(baseRosa3, null);
    vetCasas[54]=baseRosa3;
    this.getContentPane().add(baseRosa2, null);
    vetCasas[55]=baseRosa2;

    this.getContentPane().add(baseVerde2, null);
    vetCasas[56]=baseVerde2;
    this.getContentPane().add(baseVerde4, null);
    vetCasas[57]=baseVerde4;
    this.getContentPane().add(baseVerde1, null);
    vetCasas[58]=baseVerde1;
    this.getContentPane().add(baseVerde3, null);
    vetCasas[59]=baseVerde3;

    this.getContentPane().add(baseAzul4, null);
    vetCasas[60]=baseAzul4;
    this.getContentPane().add(baseAzul3, null);
    vetCasas[61]=baseAzul3;
    this.getContentPane().add(baseAzul2, null);
    vetCasas[62]=baseAzul2;
    this.getContentPane().add(baseAzul1, null);
    vetCasas[63]=baseAzul1;

  //casas coloridas
    vetCasas[64]=casa38;
    this.getContentPane().add(cRosa2, null);
    vetCasas[65]=cRosa2;
    this.getContentPane().add(cRosa3, null);
    vetCasas[66]=cRosa3;
    this.getContentPane().add(cRosa4, null);
    vetCasas[67]=cRosa4;
    this.getContentPane().add(cRosa5, null);
    vetCasas[68]=cRosa5;

    vetCasas[69]=casa26;
    this.getContentPane().add(cAzul2, null);
    vetCasas[70]=cAzul2;
    this.getContentPane().add(cAzul3, null);
    vetCasas[71]=cAzul3;
    this.getContentPane().add(cAzul4, null);
    vetCasas[72]=cAzul4;
    this.getContentPane().add(cAzul5, null);
    vetCasas[73]=cAzul5;

    vetCasas[74]=casa14;
    this.getContentPane().add(cVerde2, null);
    vetCasas[75]=cVerde2;
    this.getContentPane().add(cVerde3, null);
    vetCasas[76]=cVerde3;
    this.getContentPane().add(cVerde4, null);
    vetCasas[77]=cVerde4;
    this.getContentPane().add(cVerde5, null);
    vetCasas[78]=cVerde5;

    vetCasas[79]=casa2;
    this.getContentPane().add(cVerm2, null);
    vetCasas[80]=cVerm2;
    this.getContentPane().add(cVerm3, null);
    vetCasas[81]=cVerm3;
    this.getContentPane().add(cVerm4, null);
    vetCasas[82]=cVerm4;
    this.getContentPane().add(cVerm5, null);
    vetCasas[83]=cVerm5;

    //Ultima casa!
    this.getContentPane().add(cRosa6, null);
    vetCasas[84]=cRosa6;
    this.getContentPane().add(cAzul6, null);
    vetCasas[85]=cAzul6;
    this.getContentPane().add(cVerde6, null);
    vetCasas[86]=cVerde6;
    this.getContentPane().add(cVerm6, null);
    vetCasas[87]=cVerm6;

    this.getContentPane().add(jLabelVez, null);
    this.getContentPane().add(jTextFieldJogador, null);
    this.getContentPane().add(jButtonJogar, null);
    this.getContentPane().add(jLabelDado, null);
    this.getContentPane().add(jScrollPane1, null);
    jScrollPane1.getViewport().add(jTextPaneHistorico, null);
    this.getContentPane().add(jButtonHistorico, null);
    this.getContentPane().add(jLabelTabuleiro, null);

    jRadioButtonJogAzul.setSelected(true);
    jRadioButtonJogVerde.setSelected(true);
    jRadioButtonJogVermelho.setSelected(true);
    jRadioButtonJogRosa.setSelected(true);
     this.setSize(new Dimension(721, 490));
     jScrollPane1.setVisible(false);
  }

  /*void jComboBoxDupla_actionPerformed(ActionEvent e) {
    if(jComboBoxDupla.getSelectedIndex()==1){
      jCheckBoxAzul.setEnabled(false);
      jCheckBoxVerde.setEnabled(false);
      jCheckBoxVermelho.setEnabled(false);
      jCheckBoxAmarelo.setEnabled(false);
      jCheckBoxAzul.setSelected(true);
      jCheckBoxVerde.setSelected(true);
      jCheckBoxVermelho.setSelected(true);
      jCheckBoxRosa.setSelected(true);
      jCheckBoxVerde.setText("Azul");
      jCheckBoxRosa.setText("Vermelho");
    }else{
      jCheckBoxAzul.setEnabled(true);
      jCheckBoxVerde.setEnabled(true);
      jCheckBoxVermelho.setEnabled(true);
      jCheckBoxRosa.setEnabled(true);
      jCheckBoxAzul.setSelected(false);
      jCheckBoxVerde.setSelected(false);
      jCheckBoxVermelho.setSelected(false);
      jCheckBoxRosa.setSelected(false);
      jCheckBoxVerde.setText("Verde");
      jCheckBoxAmarelo.setText("Rosa");
    }
  }*/

  void jButtonOk_actionPerformed(ActionEvent e) {
    //testa se tem pelo menos 2 jogadores!!
    int cont=0;
    if(jCheckBoxRosa.isSelected())
      cont++;
    if(jCheckBoxVerde.isSelected())
      cont++;
    if(jCheckBoxVermelho.isSelected())
      cont++;
    if(jCheckBoxAzul.isSelected())
      cont++;
    if(cont>=2){
      jTextPaneHistorico.setText(" Novo Jogo Iniciado\n ------------------------------------------------------------");
      for (int i = 0; i < vetCasas.length; i++) {
        try{ //remome todos os MouseListener e os peoas das casas( para caso o jogador jah tivesse iniciado um jogo antes)
          vetCasas[i].removeMouseListener(actFocus);
          vetCasas[i].removeMouseListener(actClick);
          vetCasas[i].resetaCasa();
        }catch(Exception ex){
        }
      }
     jogo = new Jogo(); //cria o objeto de jogo!!!!p/ poder iniciar!
     int x = 0;//testa quantos peoes deve criar!
     switch (jComboBoxQuant.getSelectedIndex()) {
       case 0:
         x = 4;
         break;
       case 1:
         x = 3;
         break;
       case 2:
         x = 2;
         break;
       case 3:
         x = 1;
         break;
     }
   //testa quantos jogadores deve criar!
     if (jCheckBoxRosa.isSelected()) {
       jogo.insereJogador(jCheckBoxRosa.getText(), jTextFieldRosa.getText(),
                          jRadioButtonPcRosa.isSelected(), x);
       jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n "+ jTextFieldRosa.getText()+" Com a Cor->"+jCheckBoxRosa.getText());
       if(jRadioButtonPcRosa.isSelected()){
         jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"(Computador)");
       }else{
         jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"(Usuario)");
       }
     }
     if (jCheckBoxAzul.isSelected()) {
       jogo.insereJogador(jCheckBoxAzul.getText(), jTextFieldAzul.getText(),
                          jRadioButtonPcAzul.isSelected(), x);
       jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n "+ jTextFieldAzul.getText()+" Com a Cor->"+jCheckBoxAzul.getText());
       if(jRadioButtonPcAzul.isSelected()){
         jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"(Computador)");
       }else{
         jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"(Usuario)");
       }

     }
     if (jCheckBoxVerde.isSelected()) {
       jogo.insereJogador(jCheckBoxVerde.getText(), jTextFieldVerde.getText(),
                          jRadioButtonPcVerde.isSelected(), x);
       jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n "+ jTextFieldVerde.getText()+" Com a Cor->"+jCheckBoxVerde.getText());
       if(jRadioButtonPcVerde.isSelected()){
         jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"(Computador)");
       }else{
         jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"(Usuario)");
       }

     }
     if (jCheckBoxVermelho.isSelected()) {
       jogo.insereJogador(jCheckBoxVermelho.getText(),jTextFieldVermelho.getText(),
                          jRadioButtonPcVermelho.isSelected(), x);
       jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n "+ jTextFieldVermelho.getText()+" Com a Cor->"+jCheckBoxVermelho.getText());
       if(jRadioButtonPcVermelho.isSelected()){
         jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"(Computador)");
       }else{
         jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"(Usuario)");
       }
     }
     jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n ------------------------------------------------------------");
     ArrayList peoes = jogo.iniciaJogo();
     //pinta os peaoes nas bases
     for (int i = 0; i < peoes.size(); i++) {
       Peao aux = (Peao) peoes.get(i);
       vetCasas[jogo.getBase(aux)].addPeao(aux);
     }
     formLudo.hide();
     jButtonJogar.setVisible(true);
     jButtonJogar.setEnabled(true);//libera para rolar o dado!
     jLabelDado.setVisible(false);
     this.alteraTextFieldJogador(jogo.getJogadorAtual());
     if(jogo.getJogadorAtual() instanceof Computador){
         Computador jog=(Computador)jogo.getJogadorAtual();
         this.jogadaPc(jog);
     }
   }else{
     JOptionPane.showMessageDialog(null,"O Ludo exige um minimo de 2 Jogadores","ERRO",JOptionPane.ERROR_MESSAGE);
   }
  }

  void jButtonCancelar_actionPerformed(ActionEvent e) {//botao cancelar do formulario para criar jogo
    formLudo.hide();
  }

  void jButtonJogar_actionPerformed(ActionEvent e) {//rolar o dado!
      jogo.rolaDado();
      this.alteraDado();
      Jogador j_at = jogo.getJogadorAtual();
      if ( (j_at.getQtEmJogo()==0) && (jogo.getDadoFace() != 6)) {
        jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n "+ j_at.getNome()+" Nao Pode Mover Nenhuma Peao");
        //tocar som q n pode mover beeee
        //if(!(jogo.getJogadorAtual() instanceof Computador))
          //tocaSoms.playAudioNJoga();
        //JOptionPane.showMessageDialog(null, "Nenhum Peao pode ser Movido",
                                      //"<<<:PP>>>", JOptionPane.ERROR_MESSAGE);
        jogo.passaTurno();
        jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n ---" );
        this.alteraTextFieldJogador(jogo.getJogadorAtual());
        jLabelDado.setVisible(false);
        jButtonJogar.setVisible(true);
        jButtonJogar.setEnabled(true);
        if(jogo.getJogadorAtual() instanceof Computador){
          Computador jog=(Computador)jogo.getJogadorAtual();
          this.jogadaPc(jog);
        }
      }else{
        jButtonJogar.setEnabled(false);//blokeia para nao jogar o dado d novo!
        for(int i=0; i<vetCasas.length-4; i++){ //adiciona os metodos de Focus-> MouseEntered e MouseExited,
          if((i!=64)&&(i!=69)&&(i!=74)&&(i!=79)) //menos na casa final de cada cor!
            vetCasas[i].addMouseListener(actFocus);
        }
      }
  }

  void casa_mouseEntered(MouseEvent e) {
    Casa cSource = (Casa)e.getSource();
    //testa se nessa casa tem algum peao q ele pode mover!
    if(cSource.temPeaoLivre(jogo.getJogadorAtual().getCor(),jogo.getDadoFace())){
      //muda ponteiro do mouse e ativa o metodo de MouseClicked
      cSource.addMouseListener(actClick);
      cSource.setCursor(hand);
    }
  }

  void casa_mouseExited(MouseEvent e) {
    Casa cSource = (Casa)e.getSource();
    //mudar de volta o ponteiro e retira o metodo de MouseClicked
    cSource.setCursor(seta);
    try{
      cSource.removeMouseListener(actClick);
    }catch(Exception ex){
    }
  }

  void casa_mouseClicked(MouseEvent e) {
     Casa cSource = (Casa)e.getSource();
     cSource.removeMouseListener(actClick);
     Peao p=cSource.tiraPeao(jogo.getJogadorAtual());//retira o peao do lugarq  ele ta!!
     ArrayList aux=vetCasas[jogo.andaPeao(p,vetCasas)].addPeao(p);//coloca ele na nova casa!
     if(aux.size()>0)
       //if(!(jogo.getJogadorAtual() instanceof Computador))
         //tocaSoms.playAudioVoltaBase();
      //tocar som q volto alguem pra base
     if(aux!=null){
       for (int i = 0; i < aux.size(); i++) {  //manda pra base os q estavam na ksa nova!
         p = (Peao) aux.get(i);
         vetCasas[jogo.mandaBase(p)].addPeao(p);
         jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n "+jogo.getJogadorAtual().getNome()+" Mandou um Peao "+p.getCor()+" Pra Base");
       }
     }
     try{
        for (int i = 0; i < vetCasas.length; i++) {
          vetCasas[i].removeMouseListener(actFocus);  //remove os MouseListener
          vetCasas[i].removeMouseListener(actClick);  //(para obrigar o jogador a rolar o dado de novo)
        }
      }catch(Exception ex){
      }
     //testar se o cara ganhou!!
     if(!jogo.testaAcabou()){
       //passa a vez pro proximo jogador e libera para ele rolar o dado!
       if(jogo.getDadoFace()!=6){
         jogo.passaTurno();
         jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n ---" );
       }else{
         //tocar som q joga d novo
         //if(!(jogo.getJogadorAtual() instanceof Computador))
          // tocaSoms.playAudioJogaDNovo();
        }
        this.alteraTextFieldJogador(jogo.getJogadorAtual());
        jLabelDado.setVisible(false);
        jButtonJogar.setVisible(true);
        jButtonJogar.setEnabled(true);
        cSource.setCursor(seta);
        if(jogo.getJogadorAtual() instanceof Computador){
          Computador jog=(Computador)jogo.getJogadorAtual();
          this.jogadaPc(jog);
        }
      }else{
        //tocar som de q acabou
        // tocaSoms.playAudioFim();
        jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n ------------------------------------------------------------\n Fim de Jogo:->"
                                   +jTextFieldJogador.getText()+" é o Vencedor!!!");
        JOptionPane.showMessageDialog(null, "O "+jTextFieldJogador.getText()+" é o Vencedor",
                                      "Fim de Jogo", JOptionPane.ERROR_MESSAGE);
      }
  }

  void casa_mouseClicked(Casa cSource) {
    cSource.removeMouseListener(actClick);
    Peao p=cSource.tiraPeao(jogo.getJogadorAtual());//retira o peao do lugarq  ele ta!!
    ArrayList aux=vetCasas[jogo.andaPeao(p,vetCasas)].addPeao(p);//coloca ele na nova casa!
    if(aux.size()>0)
      //if(!(jogo.getJogadorAtual() instanceof Computador))
        //tocaSoms.playAudioVoltaBase();
      //tocar som q volto alguem pra base
    if(aux!=null){
      for (int i = 0; i < aux.size(); i++) {  //manda pra base os q estavam na ksa nova!
        p = (Peao) aux.get(i);
        jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n "+jogo.getJogadorAtual().getNome()+" Mandou um Peao "+p.getCor()+" Pra Base");
        vetCasas[jogo.mandaBase(p)].addPeao(p);
      }
    }
    try{
       for (int i = 0; i < vetCasas.length; i++) {
         vetCasas[i].removeMouseListener(actFocus);  //remove os MouseListener
         vetCasas[i].removeMouseListener(actClick);  //(para obrigar o jogador a rolar o dado de novo)
       }
     }catch(Exception ex){
     }
    //testar se o cara ganhou!!
    if(!jogo.testaAcabou()){
    //passa a vez pro proximo jogador e libera para ele rolar o dado!
      if(jogo.getDadoFace()!=6){
        jogo.passaTurno();
        jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n ---" );
      }else{
        //tocar som q joga d novo
        //if(!(jogo.getJogadorAtual() instanceof Computador))
          //tocaSoms.playAudioJogaDNovo();
      }
      this.alteraTextFieldJogador(jogo.getJogadorAtual());
      jLabelDado.setVisible(false);
      jButtonJogar.setVisible(true);
      jButtonJogar.setEnabled(true);
      cSource.setCursor(seta);
      if(jogo.getJogadorAtual() instanceof Computador){
        Computador jog=(Computador)jogo.getJogadorAtual();
        this.jogadaPc(jog);
      }
    }else{
      //tocar som de que acabou
        //tocaSoms.playAudioFim();
      jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n ------------------------------------------------------------\n Fim de Jogo:->"
                                +jTextFieldJogador.getText()+" é o Vencedor!!!");
      JOptionPane.showMessageDialog(null, "O "+jTextFieldJogador.getText()+" é o Vencedor!!! HAHAHA O computador ganhouuu!!",
                                      "Fim de Jogo", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void alteraTextFieldJogador(Jogador j){ //metodo para alterar o textfield do jogador atual!
    jTextFieldJogador.setText(" "+j.getNome());
    String cor=j.getCor();
    if(cor.equals("Vermelho")){
      jTextFieldJogador.setBackground(Color.red);
    }else{
      if(cor.equals("Azul")){
         jTextFieldJogador.setBackground(Color.blue);
       }else{
         if(cor.equals("Verde")){
           jTextFieldJogador.setBackground(new Color(1, 128, 1));
         }else{
           if(cor.equals("Rosa")){
             jTextFieldJogador.setBackground(new Color(255, 0, 254));
           }
         }
       }
     }
   }

   public void alteraDado(){
     jButtonJogar.setVisible(false);
     jLabelDado.setVisible(true);
     jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n "+jogo.getJogadorAtual().getNome()+" Tirou->"+jogo.getDadoFace());
     if(jogo.getDadoFace()==6)
       jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"(Portanto Ira Jogar novamente)");
     switch(jogo.getDadoFace()){
       case 1:
         jLabelDado.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Dado1.png")));
         break;
       case 2:
         jLabelDado.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Dado2.png")));
         break;
       case 3:
         jLabelDado.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Dado3.png")));
         break;
       case 4:
         jLabelDado.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Dado4.png")));
         break;
       case 5:
         jLabelDado.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Dado5.png")));
         break;
       case 6:
         jLabelDado.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Dado6.png")));
         break;
     }
     //if(!(jogo.getJogadorAtual() instanceof Computador))
         //tocaSoms.playAudioJogaDNovo();
   }
   public void jogadaPc(Computador jog){
    int i=0;
    jTextPaneHistorico.setText(jTextPaneHistorico.getText()+"\n Computador Rolando o Dado:");
    ActionEvent e=new ActionEvent(jButtonJogar,0,"");
   // try {
      //Thread.sleep(10);
   // }
   // catch (InterruptedException ex1) {
   // }
    jButtonJogar_actionPerformed(e);
    if(jogo.getJogadorAtual().equals(jog)){
      try{
        Peao p = jog.fazJogada(jogo.getDadoFace());
        i = jogo.getCasaAtual(p);
        casa_mouseClicked(vetCasas[i]);
      }catch(Exception ex){
        //System.out.println("nenhuma jogada pode ser feita");
      }
    }
   }

  void jButtonHistorico_actionPerformed(ActionEvent e) {
    if(jButtonHistorico.getText().equals("Mostrar Log")){
      jButtonHistorico.setText("Ocultar Log");
      jScrollPane1.setVisible(true);
      this.setSize(850,490);
    }else{
      jButtonHistorico.setText("Mostrar Log");
      jScrollPane1.setVisible(false);
      this.setSize(555,490);
    }
  }

  void jLabelDado_mouseClicked(MouseEvent e) {
    JOptionPane.showMessageDialog(null, "Clique em um Peao "+jogo.getJogadorAtual().getCor()+" Para andar!",
                                      "Nananinanão!", JOptionPane.ERROR_MESSAGE);
  }



 }

//classes internas dos action listener dos botoes!!
class Tabuleiro_jButtonOk_actionAdapter implements java.awt.event.ActionListener {
  Tabuleiro adaptee;

  Tabuleiro_jButtonOk_actionAdapter(Tabuleiro adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonOk_actionPerformed(e);
  }
}

class Tabuleiro_jButtonCancelar_actionAdapter implements java.awt.event.ActionListener {
  Tabuleiro adaptee;

  Tabuleiro_jButtonCancelar_actionAdapter(Tabuleiro adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonCancelar_actionPerformed(e);
  }
}

class Tabuleiro_jButtonJogar_actionAdapter implements java.awt.event.ActionListener {
  Tabuleiro adaptee;

  Tabuleiro_jButtonJogar_actionAdapter(Tabuleiro adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonJogar_actionPerformed(e);
  }
}

class Tabuleiro_jButtonHistorico_actionAdapter implements java.awt.event.ActionListener {
  Tabuleiro adaptee;

  Tabuleiro_jButtonHistorico_actionAdapter(Tabuleiro adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonHistorico_actionPerformed(e);
  }
}

class Tabuleiro_jLabelDado_mouseAdapter extends java.awt.event.MouseAdapter {
  Tabuleiro adaptee;

  Tabuleiro_jLabelDado_mouseAdapter(Tabuleiro adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jLabelDado_mouseClicked(e);
  }
}
