package ludo;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**  setToltipText-> para aparecer quando dexa o mouse parado em cima!!
  * soh a interface mapeada
  * array de labels-> livro pg 614 adicionar actionlistener em tds,
  * tb ver botando action listener soh na ksa q tem peao da cor do jogador;
 */

public class Tabuleiro extends JFrame{
  // objetos de mouselistener
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
  //cursores
  Cursor hand= new Cursor(Cursor.HAND_CURSOR);
  Cursor seta= new Cursor(Cursor.DEFAULT_CURSOR);
  //Design
  Casa[] vetCasas=new Casa[88];
  Ludo jogo;
  JLabel jLabelTabuleiro = new JLabel();
  JFrame formLudo=new JFrame();
  JCheckBox jCheckBoxAzul = new JCheckBox();
  JCheckBox jCheckBoxRosa = new JCheckBox();
  JLabel jLabelquant = new JLabel();
  JButton jButtonOk = new JButton();
  JTextField jTextFieldVermelho = new JTextField();
  JComboBox jComboBoxQuant = new JComboBox();
  JButton jButtonCancelar = new JButton();
  JTextField jTextFieldVerde = new JTextField();
  JCheckBox jCheckBoxVermelho = new JCheckBox();
  JTextField jTextFieldAzul = new JTextField();
  JCheckBox jCheckBoxVerde = new JCheckBox();
  JTextField jTextFieldRosa = new JTextField();
  ButtonGroup buttonGroupAzul = new ButtonGroup();
  ButtonGroup buttonGroupVerde = new ButtonGroup();
  ButtonGroup buttonGroupVermelho = new ButtonGroup();
  ButtonGroup buttonGroupRosa = new ButtonGroup();
  //Chooser
  JFileChooser chooser = new JFileChooser("Z:/");
  LudoFileFilter filter = new LudoFileFilter(new String("lud"), "Ludo Games");
  //Casas
  Casa casa1 = new Casa();
  Casa casa2 = new Casa(true);
  Casa casa3 = new Casa();
  Casa casa4 = new Casa();
  Casa casa5 = new Casa(true);
  Casa casa6 = new Casa();
  Casa casa7 = new Casa();
  Casa casa8 = new Casa(true);
  Casa casa9 = new Casa();
  Casa casa10 = new Casa();
  Casa casa11 = new Casa(true);
  Casa casa12 = new Casa();
  Casa casa13 = new Casa();
  Casa casa14 = new Casa(true);
  Casa casa15 = new Casa();
  Casa casa16 = new Casa();
  Casa casa17 = new Casa(true);
  Casa casa18 = new Casa();
  Casa casa19 = new Casa();
  Casa casa20 = new Casa(true);
  Casa casa21 = new Casa();
  Casa casa22 = new Casa();
  Casa casa23 = new Casa(true);
  Casa casa24 = new Casa();
  Casa casa25 = new Casa();
  Casa casa26 = new Casa(true);
  Casa casa27 = new Casa();
  Casa casa28 = new Casa();
  Casa casa29 = new Casa(true);
  Casa casa30 = new Casa();
  Casa casa31 = new Casa();
  Casa casa32 = new Casa(true);
  Casa casa33 = new Casa();
  Casa casa34 = new Casa();
  Casa casa35 = new Casa(true);
  Casa casa36 = new Casa();
  Casa casa37 = new Casa();
  Casa casa38 = new Casa(true);
  Casa casa39 = new Casa();
  Casa casa40 = new Casa();
  Casa casa41 = new Casa(true);
  Casa casa42 = new Casa();
  Casa casa43 = new Casa();
  Casa casa44 = new Casa(true);
  Casa casa45 = new Casa();
  Casa casa46 = new Casa();
  Casa casa47 = new Casa(true);
  Casa casa0 = new Casa();
  Casa baseVerm2 = new Casa();
  Casa baseVerm1 = new Casa();
  Casa baseVerm3 = new Casa();
  Casa baseVerm4 = new Casa();
  Casa baseRosa1 = new Casa();
  Casa baseRosa4 = new Casa();
  Casa baseRosa3 = new Casa();
  Casa baseRosa2 = new Casa();
  Casa baseVerde2 = new Casa();
  Casa baseVerde4 = new Casa();
  Casa baseVerde1 = new Casa();
  Casa baseVerde3 = new Casa();
  Casa baseAzul3 = new Casa();
  Casa baseAzul2 = new Casa();
  Casa baseAzul1 = new Casa();
  Casa baseAzul4 = new Casa();
  Casa cRosa2 = new Casa();
  Casa cRosa3 = new Casa();
  Casa cRosa4 = new Casa();
  Casa cRosa5 = new Casa();
  Casa cRosa6 = new Casa();
  Casa cAzul2 = new Casa();
  Casa cAzul3 = new Casa();
  Casa cAzul4 = new Casa();
  Casa cAzul5 = new Casa();
  Casa cAzul6 = new Casa();
  Casa cVerde2 = new Casa();
  Casa cVerde3 = new Casa();
  Casa cVerde4 = new Casa();
  Casa cVerde5 = new Casa();
  Casa cVerde6 = new Casa();
  Casa cVerm2 = new Casa();
  Casa cVerm3 = new Casa();
  Casa cVerm4 = new Casa();
  Casa cVerm5 = new Casa();
  Casa cVerm6 = new Casa();
  JLabel jLabelVez = new JLabel();
  JTextField jTextFieldJogador = new JTextField();
  JButton jButtonJogar = new JButton();
  private JButton jButtonPassar = new JButton();
  JLabel jLabeldado = new JLabel();
  JLabel jLabel1 = new JLabel();
  public Tabuleiro() {
    super("Ludo Java 1.0<<<<<<Por Thygo e John>>>>>>>>");
    formLudo.setSize(420,250);
    formLudo.setVisible(false);
    chooser.addChoosableFileFilter(filter);
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
    JMenuItem gravarItem=new JMenuItem("Salvar");
    gravarItem.setMnemonic('s');
    gravarItem.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          if(jButtonJogar.isEnabled()==true){
            int returnVal = chooser.showSaveDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION){
              File file = chooser.getSelectedFile();
              String nomeArq= file.getName();
              if (nomeArq.equals(null) == false) {
                jogo.salvar(vetCasas, nomeArq);
              }
              System.out.println("Saving: " + file.getName() + ".");
            } else {
              System.out.println("Save command cancelled by user.");
            }
          } else {
            JOptionPane.showMessageDialog(null, "Não é possível gravar o jogo neste momento.");
          }
        }
      }
    );
    JMenuItem abrirItem=new JMenuItem("Abrir");
    abrirItem.setMnemonic('a');
    abrirItem.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
          File file = chooser.getSelectedFile();
          jogo = new Ludo();
          ArrayList array = jogo.recuperar(vetCasas.length, file);
          if(array!=null){
            for (int i = 0; i < vetCasas.length; i++) {
              vetCasas[i].resetaCasa();
            }
            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
            for (int i = 0; i <vetCasas.length; i++) {
              Casa c = (Casa)array.get(i);
              vetCasas[i].atualiza(c);
            }
            alteraTextFieldJogador(jogo.getJogadorAtual());
            jButtonJogar.setEnabled(true);
          }
          System.out.println("Opening: " + file.getName() + ".");
        } else {
          System.out.println("Open command cancelled by user.");
        }
      }
    });
    menuJogo.add(novoJogoItem);
    menuJogo.add(gravarItem);
    menuJogo.add(abrirItem);
    menuJogo.addSeparator();
    JMenuItem sairItem=new JMenuItem("Sair");
    sairItem.setMnemonic('i');
    sairItem.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          System.exit(0);
        }
      }
    );
    menuJogo.add(sairItem);
    bar.add(menuJogo);
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

    tab.setSize(550,490);
    tab.show();
  }
  private void jbInit() throws Exception {
    jLabelTabuleiro.setIcon(new ImageIcon(Tabuleiro.class.getResource("tabuleiro.jpg")));
    jLabelTabuleiro.setBounds(new Rectangle(107, 2, 432, 441));
    this.getContentPane().setLayout(null);
    formLudo.getContentPane().setLayout(null);
    jCheckBoxAzul.setBackground(Color.white);
    jCheckBoxAzul.setText("Azul");
    jCheckBoxAzul.setBounds(new Rectangle(5, 37, 88, 17));
    jCheckBoxRosa.setBounds(new Rectangle(5, 129, 88, 17));
    jCheckBoxRosa.setBackground(Color.white);
    jCheckBoxRosa.setSelectedIcon(null);
    jCheckBoxRosa.setText("Rosa");
    jLabelquant.setText("Qnt pecas");
    jLabelquant.setBounds(new Rectangle(248, 39, 71, 17));
    jButtonOk.setBounds(new Rectangle(257, 116, 85, 26));
    jButtonOk.setText("Ok");
    jButtonOk.addActionListener(new Tabuleiro_jButtonOk_actionAdapter(this));
    jTextFieldVermelho.setBounds(new Rectangle(109, 95, 110, 20));
    jTextFieldVermelho.setText("Vermelho");
    jComboBoxQuant.setBackground(Color.white);
    jComboBoxQuant.setBorder(BorderFactory.createLineBorder(Color.black));
    jComboBoxQuant.setBounds(new Rectangle(259, 67, 46, 21));
    jButtonCancelar.setText("Cancelar");
    jButtonCancelar.addActionListener(new Tabuleiro_jButtonCancelar_actionAdapter(this));
    jButtonCancelar.setBounds(new Rectangle(257, 145, 85, 26));
    jTextFieldVerde.setBounds(new Rectangle(109, 64, 110, 20));
    jTextFieldVerde.setText("Verde");
    jCheckBoxVermelho.setBounds(new Rectangle(5, 97, 88, 17));
    jCheckBoxVermelho.setBackground(Color.white);
    jCheckBoxVermelho.setRolloverEnabled(true);
    jCheckBoxVermelho.setSelected(false);
    jCheckBoxVermelho.setText("Vermelho");
    jTextFieldAzul.setText("Azul");
    jTextFieldAzul.setBounds(new Rectangle(109, 35, 110, 20));
    jCheckBoxVerde.setBounds(new Rectangle(5, 66, 88, 17));
    jCheckBoxVerde.setBackground(Color.white);
    jCheckBoxVerde.setText("Verde");
    jTextFieldRosa.setBounds(new Rectangle(109, 127, 110, 20));
    jTextFieldRosa.setText("Rosa");
    formLudo.getContentPane().setBackground(Color.white);
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
    jTextFieldJogador.setDisabledTextColor(Color.black);
    jTextFieldJogador.setEditable(false);
    jTextFieldJogador.setText("Jogo Não Iniciado");
    jTextFieldJogador.setBounds(new Rectangle(8, 52, 117, 19));
    jButtonJogar.setBackground(Color.lightGray);
    jButtonJogar.setBounds(new Rectangle(21, 245, 73, 23));
    jButtonJogar.setEnabled(false);
    jButtonJogar.setBorder(BorderFactory.createEtchedBorder());
    jButtonJogar.setActionCommand("jButton1");
    jButtonJogar.setText("Jogar!");
    jButtonJogar.addActionListener(new Tabuleiro_jButtonJogar_actionAdapter(this));
    jButtonPassar.setText("Passar...");
    jButtonPassar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButtonPassar_actionPerformed(e);
      }
    });
    jButtonPassar.setActionCommand("jButton1");
    jButtonPassar.setBorder(BorderFactory.createEtchedBorder());
    jButtonPassar.setEnabled(false);
    jButtonPassar.setBounds(new Rectangle(21, 273, 74, 23));
    jButtonPassar.setBackground(Color.lightGray);
    jLabel1.setText("");
    jLabel1.setBounds(new Rectangle(16, 156, 82, 77));
    jLabel1.setText("");
    jLabel1.setBounds(new Rectangle(27, 158, 60, 71));
    chooser.setAcceptAllFileFilterUsed(false);
    formLudo.getContentPane().add(jCheckBoxAzul, null);
    formLudo.getContentPane().add(jCheckBoxRosa, null);
    formLudo.getContentPane().add(jTextFieldVermelho, null);
    formLudo.getContentPane().add(jTextFieldVerde, null);
    formLudo.getContentPane().add(jCheckBoxVermelho, null);
    formLudo.getContentPane().add(jTextFieldAzul, null);
    formLudo.getContentPane().add(jCheckBoxVerde, null);
    formLudo.getContentPane().add(jTextFieldRosa, null);
    formLudo.getContentPane().add(jLabelquant, null);
    formLudo.getContentPane().add(jComboBoxQuant, null);
    formLudo.getContentPane().add(jButtonOk, null);
    formLudo.getContentPane().add(jButtonCancelar, null);
    jComboBoxQuant.addItem("4");
    jComboBoxQuant.addItem("3");
    jComboBoxQuant.addItem("2");
    jComboBoxQuant.addItem("1");
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
    this.getContentPane().add(casa0, null);
    vetCasas[0]=casa0;
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
    this.getContentPane().add(jLabelTabuleiro, null);
    this.getContentPane().add(jButtonPassar, null);
    this.getContentPane().add(jButtonJogar, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jLabel1, null);
  }

  void relacionaCasas(){
    vetCasas[1]=casa1;
    vetCasas[2]=casa2;
    vetCasas[3]=casa3;
    vetCasas[4]=casa4;
    vetCasas[5]=casa5;
    vetCasas[6]=casa6;
    vetCasas[7]=casa7;
    vetCasas[8]=casa8;
    vetCasas[9]=casa9;
    vetCasas[10]=casa10;
    vetCasas[11]=casa11;
    vetCasas[12]=casa12;
    vetCasas[13]=casa13;
    vetCasas[14]=casa14;
    vetCasas[15]=casa15;
    vetCasas[16]=casa16;
    vetCasas[17]=casa17;
    vetCasas[18]=casa18;
    vetCasas[19]=casa19;
    vetCasas[20]=casa20;
    vetCasas[21]=casa21;
    vetCasas[22]=casa22;
    vetCasas[23]=casa23;
    vetCasas[24]=casa24;
    vetCasas[25]=casa25;
    vetCasas[26]=casa26;
    vetCasas[27]=casa27;
    vetCasas[28]=casa28;
    vetCasas[29]=casa29;
    vetCasas[30]=casa30;
    vetCasas[31]=casa31;
    vetCasas[32]=casa32;
    vetCasas[33]=casa33;
    vetCasas[34]=casa34;
    vetCasas[35]=casa35;
    vetCasas[36]=casa36;
    vetCasas[37]=casa37;
    vetCasas[38]=casa38;
    vetCasas[39]=casa39;
    vetCasas[40]=casa40;
    vetCasas[41]=casa41;
    vetCasas[42]=casa42;
    vetCasas[43]=casa43;
    vetCasas[44]=casa44;
    vetCasas[45]=casa45;
    vetCasas[46]=casa46;
    vetCasas[47]=casa47;
    vetCasas[0]=casa0;
    vetCasas[48]=baseVerm2;
    vetCasas[49]=baseVerm1;
    vetCasas[50]=baseVerm3;
    vetCasas[51]=baseVerm4;
    vetCasas[52]=baseRosa4;
    vetCasas[53]=baseRosa1;
    vetCasas[54]=baseRosa3;
    vetCasas[55]=baseRosa2;
    vetCasas[56]=baseVerde2;
    vetCasas[57]=baseVerde4;
    vetCasas[58]=baseVerde1;
    vetCasas[59]=baseVerde3;
    vetCasas[60]=baseAzul4;
    vetCasas[61]=baseAzul3;
    vetCasas[62]=baseAzul2;
    vetCasas[63]=baseAzul1;
    //casas coloridas
    vetCasas[64]=casa38;
    vetCasas[65]=cRosa2;
    vetCasas[66]=cRosa3;
    vetCasas[67]=cRosa4;
    vetCasas[68]=cRosa5;
    vetCasas[69]=casa26;
    vetCasas[70]=cAzul2;
    vetCasas[71]=cAzul3;
    vetCasas[72]=cAzul4;
    vetCasas[73]=cAzul5;
    vetCasas[74]=casa14;
    vetCasas[75]=cVerde2;
    vetCasas[76]=cVerde3;
    vetCasas[77]=cVerde4;
    vetCasas[78]=cVerde5;
    vetCasas[79]=casa2;
    vetCasas[80]=cVerm2;
    vetCasas[81]=cVerm3;
    vetCasas[82]=cVerm4;
    vetCasas[83]=cVerm5;
    vetCasas[84]=cRosa6;
    vetCasas[85]=cAzul6;
    vetCasas[86]=cVerde6;
    vetCasas[87]=cVerm6;
  }

  void jButtonOk_actionPerformed(ActionEvent e) {
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
      try{
       for (int i = 0; i < vetCasas.length-4; i++) {
         vetCasas[i].removeMouseListener(actFocus);
         vetCasas[i].removeMouseListener(actClick);
       }
     }catch(Exception ex){
     }
     jogo = new Ludo(); //cria o objeto de jogo!!!! e inicia!!!
     for (int i = 0; i < vetCasas.length; i++) {
       vetCasas[i].resetaCasa();
     }
     int x = 0;
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
     if (jCheckBoxRosa.isSelected()) {
       jogo.insereJogador(jCheckBoxRosa.getText(), jTextFieldRosa.getText(), x);
     }
     if (jCheckBoxAzul.isSelected()) {
       jogo.insereJogador(jCheckBoxAzul.getText(), jTextFieldAzul.getText(), x);
     }
     if (jCheckBoxVerde.isSelected()) {
       jogo.insereJogador(jCheckBoxVerde.getText(), jTextFieldVerde.getText(), x);
     }
     if (jCheckBoxVermelho.isSelected()) {
       jogo.insereJogador(jCheckBoxVermelho.getText(), jTextFieldVermelho.getText(), x);
     }
     ArrayList peoes = jogo.iniciaJogo();
     //pinta os peaoes nas bases
     for (int i = 0; i < peoes.size(); i++) {
       Peao aux = (Peao) peoes.get(i);
       vetCasas[jogo.getBase(aux)].addPeao(aux);
     }
     formLudo.hide();
     jButtonJogar.setEnabled(true);
     this.alteraTextFieldJogador(jogo.getJogadorAtual());
   }else{
     JOptionPane.showMessageDialog(null,"Adicione 2 ou mais Jogadores","ERRO",JOptionPane.ERROR_MESSAGE);
   }
  }

  void jButtonCancelar_actionPerformed(ActionEvent e) {
    formLudo.hide();
  }

  void jButtonJogar_actionPerformed(ActionEvent e) {
   jogo.rolaDado();//muda face do dado
   if(jogo.getNSorteado()==1)
    jLabel1.setIcon(new ImageIcon(Tabuleiro.class.getResource("Dado1.gif")));
    if(jogo.getNSorteado()==2)
        jLabel1.setIcon(new ImageIcon(Tabuleiro.class.getResource("Dado2.gif")));
     if(jogo.getNSorteado()==3)
        jLabel1.setIcon(new ImageIcon(Tabuleiro.class.getResource("Dado3.gif")));
      if(jogo.getNSorteado()==4)
         jLabel1.setIcon(new ImageIcon(Tabuleiro.class.getResource("Dado4.gif")));
        if (jogo.getNSorteado()==5)
           jLabel1.setIcon(new ImageIcon(Tabuleiro.class.getResource("Dado5.gif")));
          if(jogo.getNSorteado()==6)
             jLabel1.setIcon(new ImageIcon(Tabuleiro.class.getResource("Dado6.gif")));


    jButtonJogar.setEnabled(false);
    jogo.getJogadorAtual().decChance();
    for(int i=0; i<vetCasas.length-4; i++){
      if((i!=64)&&(i!=69)&&(i!=74)&&(i!=79))
        vetCasas[i].addMouseListener(actFocus);
    }
  }

  void casa_mouseEntered(MouseEvent e) {
    Casa cSource = (Casa)e.getSource();
    if(jogo.getJogadorAtual().getCor().equals(cSource.getCorPeao())){
      for(int i=0; i<vetCasas.length-4; i++){
        if (vetCasas[i].equals(cSource)){
          if ((i>47)&&(i<64)){
            if(jogo.testeJogadaBase(vetCasas,cSource)){
              cSource.addMouseListener(actClick);
              cSource.setCursor(hand);
            } else {
              jButtonPassar.setEnabled(true);
            }
          } else {
            if((i!=64)&&(i!=69)&&(i!=74)&&(i!=79)){
              if(jogo.testeJogada(vetCasas,i)){
                cSource.addMouseListener(actClick);
                cSource.setCursor(hand);
              }
            }
          }
        }
      }
    }
  }

  void casa_mouseExited(MouseEvent e) {
    Casa cSource = (Casa)e.getSource();
    cSource.setCursor(seta);
    try{
      cSource.removeMouseListener(actClick);
    }catch(Exception ex){
    }
  }

  void casa_mouseClicked(MouseEvent e) {
    Casa cSource = (Casa)e.getSource();
    jButtonJogar.setEnabled(true);
    jButtonPassar.setEnabled(false);
    cSource.removeMouseListener(actClick);
    cSource.setCursor(seta);
    Peao p=cSource.tiraPeao();
    int casaDestino=jogo.andaPeao(p);
    ArrayList aux=vetCasas[casaDestino].addPeao(p);
    if(aux!=null){
      for (int i = 0; i < aux.size(); i++) {
        p = (Peao) aux.get(i);
        vetCasas[jogo.mandaBase(p)].addPeao(p);
      }
    }
    try{
      for (int i = 0; i < vetCasas.length-4; i++) {
        vetCasas[i].removeMouseListener(actFocus);
        vetCasas[i].removeMouseListener(actClick);
      }
    }catch(Exception ex){
    }
    int pos=0;
    while(!(vetCasas[pos].equals(cSource))&&(pos<vetCasas.length)){
      pos++;
    }
    if ((jogo.getNSorteado()==6)&&((pos<48)||(pos>63))){
      jogo.getJogadorAtual().incChance();
    }
    jogo.testeDaCoroa(vetCasas,casaDestino,p);
    String vencedor = jogo.testeVencedor();
    if(vencedor.equals("")==false){
      jButtonJogar.setEnabled(false);
      JOptionPane.showMessageDialog(null, vencedor+" venceu!! Pagabéns meu camagada! =]");
    }
    if(jogo.getJogadorAtual().getChances()==0){
      jogo.passaTurno();
    }
    this.alteraTextFieldJogador(jogo.getJogadorAtual());
  }

  public void alteraTextFieldJogador(Jogador j){
    jTextFieldJogador.setText(j.getNome());
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

  void jButtonPassar_actionPerformed(ActionEvent e) {
    try{
      for (int i = 0; i < vetCasas.length-4; i++) {
        vetCasas[i].removeMouseListener(actFocus);
        vetCasas[i].removeMouseListener(actClick);
      }
    }catch(Exception ex){
    }
    jogo.passaTurno();

    this.alteraTextFieldJogador(jogo.getJogadorAtual());
    jButtonJogar.setEnabled(true);
    jButtonPassar.setEnabled(false);
  }

 }

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
