package codes;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Toolkit;

public class Buscaminas extends JFrame {
private JPanel jPanel1 = new JPanel();
private JButton jButton1 = new JButton();
public int ancho=10;
public int alto=8;
public  JButton Botones[][]=new JButton [ancho][alto];
public  String [][] elArray =new String [ancho][alto];
int vecesJugadas = 0;


public static void main (String [] args){
Buscaminas TabBuscaMin = new Buscaminas();
}
public Buscaminas()  {
	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\consola-de-juego.png"));
	getContentPane().setBackground(new Color(155, 175, 181));
  try    {
    jbInit();
  }
  catch(Exception e)    {
    e.printStackTrace();
  }
}

private void jbInit() throws Exception  {
  this.getContentPane().setLayout(null);
  // Esta linea es para modificar El cuador principal
  this.setSize(new Dimension(1152, 648));
  this.setBackground(new Color(55, 175, 181));
  this.setTitle("Busca Minas");
  //Esta linea es para modificar el rectangulo naranga (posicion x, posicion y, ancho, altura)
  jPanel1.setBounds(new Rectangle(100, 100, 952, 448));
  //Modificar color
  jPanel1.setBackground(new Color(162, 175, 227));
  jPanel1.setLayout(null);
  this.getContentPane().add(jPanel1, null);
  jButton1.setBounds(71, 50, 125, 40);
  getContentPane().add(jButton1);
  
  jButton1.setText("Iniciar");
  jButton1.setFont(new Font("Tahoma", Font.PLAIN, 16));
  jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
  jButton1.setAlignmentY((float)0.0);
  jButton1.setMargin(new Insets(2, 14, 2, 12));
	
	JButton botonPPT = new JButton("PP&T");
	botonPPT.setFont(new Font("Tahoma", Font.PLAIN, 16));
	botonPPT.setBounds(358, 50, 130, 35);
	getContentPane().add(botonPPT);
	
	JButton botonBM = new JButton("Buscaminas");
	
	botonBM.setFont(new Font("Tahoma", Font.PLAIN, 16));
	botonBM.setBounds(626, 50, 130, 35);
	botonBM.setEnabled(false);
	getContentPane().add(botonBM);
	
	JButton botonGato = new JButton("Gato");
	
	botonGato.setFont(new Font("Tahoma", Font.PLAIN, 16));
	botonGato.setBounds(914, 50, 130, 35);
	getContentPane().add(botonGato);
	
	JButton botonHome = new JButton("");
	
	botonHome.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\casa (1).png"));
	botonHome.setBounds(10, 551, 50, 50);
	getContentPane().add(botonHome);
	
	JButton botonGuardar = new JButton("Guardar");
	
	botonGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
	botonGuardar.setBounds(914, 558, 130, 35);
	getContentPane().add(botonGuardar);
	
	botonHome.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Principal frame3 = new Principal();
			frame3.setVisible(true);
			cerrar();
		}
	});
	
	botonPPT.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PPT frame2 = new PPT();
			frame2.setVisible(true);
			cerrar();
		}
	});
	
	botonGato.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Gato frame3 = new Gato();
			frame3.setVisible(true);
			cerrar();
		}
	});
  jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        jButton1_actionPerformed(e);
      }
    });
  cargarTablero();
  colocarBomba(getAncho());
  comprueba();

  this.setVisible(true);  

//—- Oculta los botones del contorno que no participaran en el juego.

  ocultaBotones();
}
private void jButton1_actionPerformed(ActionEvent e)  {
	vecesJugadas++;
for (int i=0;i<ancho;i++){
    for (int z=0;z<alto;z++){
      elArray[i][z]=" ";
      Botones[i][z].setEnabled(true);
      Botones[i][z].setText(" ");
      }
}
colocarBomba(getAncho());
comprueba();
this.setTitle("Busca Minas");
jButton1.setText("Iniciar");
}
//—– Inicializa el tablero a 0

public void cargarTablero(){
  for (int i=0;i<ancho;i++){
    for (int z=0;z<alto;z++){
    elArray[i][z]=" ";
      Botones[i][z]= new JButton();
          jPanel1.add(Botones[i][z]);
          //Esta linea es para modificar la posicion de los botones
          Botones[i][z].setBounds((i*75) + 100,(z*45) + 50,75,45);
          //Botones[i][z].setMargin(new Insets(100, 100, 100, 100));
          Botones[i][z].setFont(new Font("Tahoma", Font.PLAIN,16));


          Botones[i][z].addActionListener(
            new ActionListener(){
    public void actionPerformed(ActionEvent ar) {
    for (int i=0;i<ancho;i++){
          for (int z=0;z<alto;z++){
          if (ar.getSource()==Botones[i][z]){
                showTextTop(i,z);
//—– Cada Evento llama al método pulsarBoton.
          }                }        }            }               }             );             

          }               }       }
//—- Coloca el numero de bombas dependiendo el ancho.

public void colocarBomba(int numeroBombas){
double i=0;
double z=0;
int condicion=0;
do  {
  i=Math.random()*getAncho();
      z=Math.random()*getAlto();
        i=(int)i;
        z=(int)z;
        if  (z!=0 && i!=0 && z!=alto-1 && i!=ancho-1){
          // Botones[(int) i][(int) z].setText("B");
            elArray[(int)i][(int) z ]="B";
            condicion++;
        }
    }
while (condicion<=ancho);
}
public void setAncho (int sAncho){
ancho=sAncho;
}
public int getAncho (){
return ancho;
}
public void setAlto (int sAlto){
alto=sAlto;
}
public int getAlto (){
return alto;
}

//—- Asigna un número a cada boton dependiendo de las B que tenga al lado.
//--- codigo Busca Minas
public void comprueba(){
for (int i=0;i<ancho;i++){
    for (int z=0;z<alto;z++){
    int numeroComprueba=0;   //el numero que voy a asignar al boton
    if (elArray[i][z]!=("B")){
      if  (z!=0 && i!=0 && z!=alto-1 && i!=ancho-1){
        System.out.println(i+ " "+ z +" "+ ancho +" " +alto);

        if (elArray[i][z-1]=="B"){
                numeroComprueba++;
              }
              if (elArray[i-1][z-1]=="B"){
                numeroComprueba++;
              }
              if (elArray[i+1][z-1]=="B"){
                numeroComprueba++;
              }
              if (elArray[i][z+1]=="B"){
                numeroComprueba++;
              }
              if (elArray[i+1][z+1]=="B"){
                numeroComprueba++;
              }
              if (elArray[i-1][z+1]=="B"){
                numeroComprueba++;
              }
              if (elArray[i+1][z]=="B"){
                numeroComprueba++;
              }
              if (elArray[i-1][z]=="B"){
                numeroComprueba++;
              }
              if (numeroComprueba!=0){
              elArray[i][z]=(String.valueOf(numeroComprueba));
            }          }         }                }     }
}
//—- Oculta los botones de los laterales.
public void ocultaBotones(){
for (int i=0;i<ancho;i++){
    for (int z=0;z<alto;z++){
if  (z==0 || i==0 || z==alto-1 || i==ancho-1){
    Botones[i][z].setVisible(false);
}       }    }   

}

//—- Muestra el texto en todos los botones cuando hay bomba.

public void textoBotones(){
for (int i=0;i<ancho;i++){
    for (int z=0;z<alto;z++){
    Botones[i][z].setText(elArray[i][z]);
    Botones[i][z].setEnabled(false);
//codigo para mostrar el texto encima del boton.
}   }   

}
//—- Muestra el Numero encima del boton.
//—- Cambia las propiedades del boton mostrado.

public void showTextTop(int i,int z){
  Botones[i][z].setText(elArray[i][z]);
  Botones[i][z].setEnabled(false);

  if (elArray[i][z]==" "){
  Botones[i][z].setEnabled(false);
  metodoStackOverFlow(i,z);
  }
  else {
  Botones[i][z].setEnabled(false);
  }
  if (Botones[i][z].getText()=="B"){
      textoBotones();
      }

}
//—-  Pone el numero en los botones cercanos.

private void metodoStackOverFlow(int i, int z) {
  if ( z!=0 && i!=0 && z!=alto-1 && i!=ancho-1){
  Botones[i-1][z].setEnabled(false);
  Botones[i-1][z-1].setEnabled(false);
  Botones[i-1][z+1].setEnabled(false);
  Botones[i][z-1].setEnabled(false);
  Botones[i][z+1].setEnabled(false);
  Botones[i+1][z].setEnabled(false);
  Botones[i+1][z+1].setEnabled(false);
  Botones[i+1][z-1].setEnabled(false);

  Botones[i-1][z].setText(elArray[i-1][z]);
  Botones[i-1][z-1].setText(elArray[i-1][z-1]);
  Botones[i-1][z+1].setText(elArray[i-1][z+1]);
  Botones[i][z-1].setText(elArray[i][z-1]);
  Botones[i][z+1].setText(elArray[i][z+1]);
  Botones[i+1][z].setText(elArray[i+1][z]);
  Botones[i+1][z+1].setText(elArray[i+1][z+1]);
  Botones[i+1][z-1].setText(elArray[i+1][z-1]);
  }
}

//—- Este es el metodo que mostrara el final del game.
//—- 17 columnas por 10 lineas visibles= 170 Botones[][]
//—- 170 - 19 Bombas = 171 Botones con Texto
//--- codigo Busca Minas

public void finalGame (){
int contadorFinal=0;
  for (int i=1;i<ancho-1;i++){
    for (int z=1;z<alto-1;z++){
    if (Botones[i][z].getText()==" " || Botones[i][z].getText()=="1" ||
      Botones[i][z].getText()=="2" || Botones[i][z].getText()=="3" ||
      Botones[i][z].getText()=="5" || Botones[i][z].getText()=="4" ){
          contadorFinal++;
              if (contadorFinal==171){
                this.setTitle("Has Ganado… oooooo…..");
                jButton1.setText("NEW…");
                
                // Aqui irá el contador de veces ganadas que se subirá a la base de datos
          }        
        }  
      }  
    }     
  }
void cerrar() {
	this.dispose();
}
}