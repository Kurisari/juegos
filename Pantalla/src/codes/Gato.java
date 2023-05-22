package codes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Gato extends JFrame {

	private JPanel contentPane;
	private static int FILAS = 3;
	private static int COLUMNAS = 3;
	private static char jugador_x = 'X';
	private static char jugador_o = 'O';
	private static char vacio = ' ';
	private char[][] tablero = new char[FILAS][COLUMNAS];
	private static int conteoGanar = 3;
	int contadorPartidas = 0;
	int vecesJugadas = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gato frame = new Gato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gato() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\\\Users\\\\crisa\\\\workspace\\\\juegos\\\\juegos\\\\Pantalla\\\\imgs\\consola-de-juego.png"));
		setTitle("Gato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152 , 648);
		contentPane = 	new JPanel();
		contentPane.setBackground(new Color(155, 175, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonIniciar = new JButton("Iniciar");
		
		botonIniciar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonIniciar.setBounds(70, 316, 130, 35);
		contentPane.add(botonIniciar);
		
		JButton botonPPT = new JButton("PP&T");
		
		
		botonPPT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonPPT.setBounds(358, 50, 130, 35);
		contentPane.add(botonPPT);	
		
		JButton botonBM = new JButton("Buscaminas");
		
		botonBM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonBM.setBounds(626, 50, 130, 35);
		contentPane.add(botonBM);
		
		JButton botonGato = new JButton("Gato");
		botonGato.setEnabled(false);
		
		botonGato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonGato.setBounds(914, 50, 130, 35);
		contentPane.add(botonGato);
		
		JButton pos11 = new JButton("");
		
		pos11.setEnabled(false);
		pos11.setFont(new Font("Tahoma", Font.BOLD, 90));
		pos11.setBounds(358, 139, 130, 130);
		contentPane.add(pos11);
		
		JButton pos21 = new JButton("");
		
		pos21.setEnabled(false);
		pos21.setBounds(498, 139, 130, 130);
		pos21.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos21);
		
		JButton pos31 = new JButton("");
		
		pos31.setEnabled(false);
		pos31.setBounds(638, 139, 130, 130);
		pos31.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos31);
		
		JButton pos12 = new JButton("");
		
		pos12.setEnabled(false);
		pos12.setBounds(358, 279, 130, 130);
		pos12.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos12);
		
		JButton pos22 = new JButton("");
		
		pos22.setEnabled(false);
		pos22.setBounds(498, 279, 130, 130);
		pos22.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos22);
		
		JButton pos32 = new JButton("");
		
		pos32.setEnabled(false);
		pos32.setBounds(638, 279, 130, 130);
		pos32.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos32);
		
		JButton pos13 = new JButton("");
		
		pos13.setEnabled(false);
		pos13.setBounds(358, 419, 130, 130);
		pos13.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos13);
		
		JButton pos23 = new JButton("");
		
		pos23.setEnabled(false);
		pos23.setBounds(498, 419, 130, 130);
		pos23.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos23);
		
		JButton pos33 = new JButton("");
		
		pos33.setEnabled(false);
		pos33.setBounds(638, 419, 130, 130);
		pos33.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos33);
		
		JButton tuTurno = new JButton("Tu Turno");
		tuTurno.setForeground(new Color(0, 0, 0));
		tuTurno.setFont(new Font("Tahoma", Font.BOLD, 19));
		tuTurno.setEnabled(false);
		tuTurno.setBackground(new Color(255, 0, 0));
		tuTurno.setBounds(70, 139, 130, 60);
		contentPane.add(tuTurno);
		
		JLabel lblNewLabel = new JLabel("Partidas ganadas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(70, 256, 130, 27);
		contentPane.add(lblNewLabel);
		
		JLabel partidasGanadas = new JLabel("0");
		partidasGanadas.setFont(new Font("Tahoma", Font.BOLD, 16));
		partidasGanadas.setBounds(70, 279, 64, 27);
		contentPane.add(partidasGanadas);
		
		JButton botonHome = new JButton("");
		
		botonHome.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\casa (1).png"));
		botonHome.setBounds(10, 551, 50, 50);
		contentPane.add(botonHome);
		
		JButton botonGuardar = new JButton("Guardar");
		
		botonGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonGuardar.setBounds(70, 50, 130, 35);
		contentPane.add(botonGuardar);
		
		botonBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscaminas frame4 = new Buscaminas();
				frame4.setVisible(true);
				cerrar();
			}
		});
		
		botonIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vecesJugadas++;
				limpiarTablero(tablero);
				pos11.setEnabled(true);
				pos21.setEnabled(true);
				pos31.setEnabled(true);
				pos12.setEnabled(true);
				pos22.setEnabled(true);
				pos32.setEnabled(true);
				pos13.setEnabled(true);
				pos23.setEnabled(true);
				pos33.setEnabled(true);
				pos11.setText("");
				pos21.setText("");
				pos31.setText("");
				pos12.setText("");
				pos22.setText("");
				pos32.setText("");
				pos13.setText("");
				pos23.setText("");
				pos33.setText("");
				tuTurno.setBackground(new Color(0, 255, 0));
			}
		}); 
		
		botonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal frame3 = new Principal();
				frame3.setVisible(true);
				cerrar();
			}
		});
		
		pos11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char jugadorActual = jugador_o;
				
				jugadorActual = jugador_x;
				int[] coordenadas = new int[2];
				pos11.setText(jugador_x + "");
				colocarPieza(0, 0, jugador_x, tablero);
				pos11.setEnabled(false);
				tuTurno.setBackground(new Color(255, 0, 0));
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
					return;
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
			        return;
	            }
				jugadorActual = jugador_o;
				coordenadas = elegirCoordenadasCpu(jugador_o, tablero);
				colocarPieza(coordenadas[1], coordenadas[0], jugador_o, tablero);
				if(coordenadas[0] == 0 && coordenadas[1] == 0) {
					pos11.setText(jugador_o + "");
					pos11.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 1) {
					pos12.setText(jugador_o + "");
					pos12.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 2) {
					pos13.setText(jugador_o + "");
					pos13.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 0) {
					pos21.setText(jugador_o + "");
					pos21.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 1) {
					pos22.setText(jugador_o + "");
					pos22.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 2) {
					pos23.setText(jugador_o + "");
					pos23.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 0) {
					pos31.setText(jugador_o + "");
					pos31.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 1) {
					pos32.setText(jugador_o + "");
					pos32.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 2) {
					pos33.setText(jugador_o + "");
					pos33.setEnabled(false);
				}
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
	            }
				tuTurno.setBackground(new Color(0, 255, 0));
			}
		});
		
		pos21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char jugadorActual = jugador_o;
				
				jugadorActual = jugador_x;
				int[] coordenadas = new int[2];
				pos21.setText(jugador_x + "");
				colocarPieza(0, 1, jugador_x, tablero);
				pos21.setEnabled(false);
				tuTurno.setBackground(new Color(255, 0, 0));
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
					return;
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
			        return;
	            }
				jugadorActual = jugador_o;
				coordenadas = elegirCoordenadasCpu(jugador_o, tablero);
				colocarPieza(coordenadas[1], coordenadas[0], jugador_o, tablero);
				if(coordenadas[0] == 0 && coordenadas[1] == 0) {
					pos11.setText(jugador_o + "");
					pos11.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 1) {
					pos12.setText(jugador_o + "");
					pos12.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 2) {
					pos13.setText(jugador_o + "");
					pos13.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 0) {
					pos21.setText(jugador_o + "");
					pos21.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 1) {
					pos22.setText(jugador_o + "");
					pos22.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 2) {
					pos23.setText(jugador_o + "");
					pos23.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 0) {
					pos31.setText(jugador_o + "");
					pos31.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 1) {
					pos32.setText(jugador_o + "");
					pos32.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 2) {
					pos33.setText(jugador_o + "");
					pos33.setEnabled(false);
				}
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
	            }
				tuTurno.setBackground(new Color(0, 255, 0));
			}
		});
		
		pos31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char jugadorActual = jugador_o;
				
				jugadorActual = jugador_x;
				int[] coordenadas = new int[2];
				pos31.setText(jugador_x + "");
				colocarPieza(0, 2, jugador_x, tablero);
				pos31.setEnabled(false);
				tuTurno.setBackground(new Color(255, 0, 0));
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
					return;
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
			        return;
	            }
				jugadorActual = jugador_o;
				coordenadas = elegirCoordenadasCpu(jugador_o, tablero);
				colocarPieza(coordenadas[1], coordenadas[0], jugador_o, tablero);
				if(coordenadas[0] == 0 && coordenadas[1] == 0) {
					pos11.setText(jugador_o + "");
					pos11.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 1) {
					pos12.setText(jugador_o + "");
					pos12.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 2) {
					pos13.setText(jugador_o + "");
					pos13.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 0) {
					pos21.setText(jugador_o + "");
					pos21.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 1) {
					pos22.setText(jugador_o + "");
					pos22.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 2) {
					pos23.setText(jugador_o + "");
					pos23.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 0) {
					pos31.setText(jugador_o + "");
					pos31.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 1) {
					pos32.setText(jugador_o + "");
					pos32.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 2) {
					pos33.setText(jugador_o + "");
					pos33.setEnabled(false);
				}
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
	            }
				tuTurno.setBackground(new Color(0, 255, 0));
			}
		});
		
		pos12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char jugadorActual = jugador_o;
				
				jugadorActual = jugador_x;
				int[] coordenadas = new int[2];
				pos12.setText(jugador_x + "");
				colocarPieza(1, 0, jugador_x, tablero);
				pos12.setEnabled(false);
				tuTurno.setBackground(new Color(255, 0, 0));
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
					return;
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
			        return;
	            }
				jugadorActual = jugador_o;
				coordenadas = elegirCoordenadasCpu(jugador_o, tablero);
				colocarPieza(coordenadas[1], coordenadas[0], jugador_o, tablero);
				if(coordenadas[0] == 0 && coordenadas[1] == 0) {
					pos11.setText(jugador_o + "");
					pos11.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 1) {
					pos12.setText(jugador_o + "");
					pos12.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 2) {
					pos13.setText(jugador_o + "");
					pos13.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 0) {
					pos21.setText(jugador_o + "");
					pos21.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 1) {
					pos22.setText(jugador_o + "");
					pos22.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 2) {
					pos23.setText(jugador_o + "");
					pos23.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 0) {
					pos31.setText(jugador_o + "");
					pos31.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 1) {
					pos32.setText(jugador_o + "");
					pos32.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 2) {
					pos33.setText(jugador_o + "");
					pos33.setEnabled(false);
				}
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
	            }
				tuTurno.setBackground(new Color(0, 255, 0));
			}
		});
		
		pos22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char jugadorActual = jugador_o;
				
				jugadorActual = jugador_x;
				int[] coordenadas = new int[2];
				pos22.setText(jugador_x + "");
				colocarPieza(1, 1, jugador_x, tablero);
				pos22.setEnabled(false);
				tuTurno.setBackground(new Color(255, 0, 0));
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
					return;
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
			        return;
	            }
				jugadorActual = jugador_o;
				coordenadas = elegirCoordenadasCpu(jugador_o, tablero);
				colocarPieza(coordenadas[1], coordenadas[0], jugador_o, tablero);
				if(coordenadas[0] == 0 && coordenadas[1] == 0) {
					pos11.setText(jugador_o + "");
					pos11.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 1) {
					pos12.setText(jugador_o + "");
					pos12.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 2) {
					pos13.setText(jugador_o + "");
					pos13.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 0) {
					pos21.setText(jugador_o + "");
					pos21.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 1) {
					pos22.setText(jugador_o + "");
					pos22.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 2) {
					pos23.setText(jugador_o + "");
					pos23.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 0) {
					pos31.setText(jugador_o + "");
					pos31.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 1) {
					pos32.setText(jugador_o + "");
					pos32.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 2) {
					pos33.setText(jugador_o + "");
					pos33.setEnabled(false);
				}
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
	            }
				tuTurno.setBackground(new Color(0, 255, 0));
			}
		});
		
		pos32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char jugadorActual = jugador_o;
				
				jugadorActual = jugador_x;
				int[] coordenadas = new int[2];
				pos32.setText(jugador_x + "");
				colocarPieza(1, 2, jugador_x, tablero);
				pos32.setEnabled(false);
				tuTurno.setBackground(new Color(255, 0, 0));
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
					return;
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
			        return;
	            }
				jugadorActual = jugador_o;
				coordenadas = elegirCoordenadasCpu(jugador_o, tablero);
				colocarPieza(coordenadas[1], coordenadas[0], jugador_o, tablero);
				if(coordenadas[0] == 0 && coordenadas[1] == 0) {
					pos11.setText(jugador_o + "");
					pos11.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 1) {
					pos12.setText(jugador_o + "");
					pos12.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 2) {
					pos13.setText(jugador_o + "");
					pos13.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 0) {
					pos21.setText(jugador_o + "");
					pos21.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 1) {
					pos22.setText(jugador_o + "");
					pos22.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 2) {
					pos23.setText(jugador_o + "");
					pos23.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 0) {
					pos31.setText(jugador_o + "");
					pos31.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 1) {
					pos32.setText(jugador_o + "");
					pos32.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 2) {
					pos33.setText(jugador_o + "");
					pos33.setEnabled(false);
				}
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
	            }
				tuTurno.setBackground(new Color(0, 255, 0));
			}
		});
		
		pos13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char jugadorActual = jugador_o;
				
				jugadorActual = jugador_x;
				int[] coordenadas = new int[2];
				pos13.setText(jugador_x + "");
				colocarPieza(2, 0, jugador_x, tablero);
				pos13.setEnabled(false);
				tuTurno.setBackground(new Color(255, 0, 0));
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
					return;
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
			        return;
	            }
				jugadorActual = jugador_o;
				coordenadas = elegirCoordenadasCpu(jugador_o, tablero);
				colocarPieza(coordenadas[1], coordenadas[0], jugador_o, tablero);
				if(coordenadas[0] == 0 && coordenadas[1] == 0) {
					pos11.setText(jugador_o + "");
					pos11.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 1) {
					pos12.setText(jugador_o + "");
					pos12.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 2) {
					pos13.setText(jugador_o + "");
					pos13.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 0) {
					pos21.setText(jugador_o + "");
					pos21.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 1) {
					pos22.setText(jugador_o + "");
					pos22.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 2) {
					pos23.setText(jugador_o + "");
					pos23.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 0) {
					pos31.setText(jugador_o + "");
					pos31.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 1) {
					pos32.setText(jugador_o + "");
					pos32.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 2) {
					pos33.setText(jugador_o + "");
					pos33.setEnabled(false);
				}
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
	            }
				tuTurno.setBackground(new Color(0, 255, 0));
			}
		});
		
		pos23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char jugadorActual = jugador_o;
				
				jugadorActual = jugador_x;
				int[] coordenadas = new int[2];
				pos23.setText(jugador_x + "");
				colocarPieza(2, 1, jugador_x, tablero);
				pos23.setEnabled(false);
				tuTurno.setBackground(new Color(255, 0, 0));
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
					return;
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
			        return;
	            }
				jugadorActual = jugador_o;
				coordenadas = elegirCoordenadasCpu(jugador_o, tablero);
				colocarPieza(coordenadas[1], coordenadas[0], jugador_o, tablero);
				if(coordenadas[0] == 0 && coordenadas[1] == 0) {
					pos11.setText(jugador_o + "");
					pos11.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 1) {
					pos12.setText(jugador_o + "");
					pos12.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 2) {
					pos13.setText(jugador_o + "");
					pos13.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 0) {
					pos21.setText(jugador_o + "");
					pos21.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 1) {
					pos22.setText(jugador_o + "");
					pos22.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 2) {
					pos23.setText(jugador_o + "");
					pos23.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 0) {
					pos31.setText(jugador_o + "");
					pos31.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 1) {
					pos32.setText(jugador_o + "");
					pos32.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 2) {
					pos33.setText(jugador_o + "");
					pos33.setEnabled(false);
				}
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
	            }
				tuTurno.setBackground(new Color(0, 255, 0));
			}
		});
		
		pos33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char jugadorActual = jugador_o;
				jugadorActual = jugador_x;
				int[] coordenadas = new int[2];
				pos33.setText(jugador_x + "");
				colocarPieza(2, 2, jugador_x, tablero);
				pos33.setEnabled(false);
				tuTurno.setBackground(new Color(255, 0, 0));
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
					return;
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
			        return;
	            }
				jugadorActual = jugador_o;
				coordenadas = elegirCoordenadasCpu(jugador_o, tablero);
				colocarPieza(coordenadas[1], coordenadas[0], jugador_o, tablero);
				if(coordenadas[0] == 0 && coordenadas[1] == 0) {
					pos11.setText(jugador_o + "");
					pos11.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 1) {
					pos12.setText(jugador_o + "");
					pos12.setEnabled(false);
				} else if(coordenadas[0] == 0 && coordenadas[1] == 2) {
					pos13.setText(jugador_o + "");
					pos13.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 0) {
					pos21.setText(jugador_o + "");
					pos21.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 1) {
					pos22.setText(jugador_o + "");
					pos22.setEnabled(false);
				} else if(coordenadas[0] == 1 && coordenadas[1] == 2) {
					pos23.setText(jugador_o + "");
					pos23.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 0) {
					pos31.setText(jugador_o + "");
					pos31.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 1) {
					pos32.setText(jugador_o + "");
					pos32.setEnabled(false);
				} else if(coordenadas[0] == 2 && coordenadas[1] == 2) {
					pos33.setText(jugador_o + "");
					pos33.setEnabled(false);
				}
				if (comprobarSiGana(jugadorActual, tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "El jugador " + jugadorActual + " gana");
	                pos11.setEnabled(false);
					pos21.setEnabled(false);
					pos31.setEnabled(false);
					pos12.setEnabled(false);
					pos22.setEnabled(false);
					pos32.setEnabled(false);
					pos13.setEnabled(false);
					pos23.setEnabled(false);
					pos33.setEnabled(false);
					if(jugadorActual == jugador_x) {
						contadorPartidas++;
						partidasGanadas.setText(contadorPartidas+"");
					}
	            } else if (empate(tablero)) {
	                JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Empate");
	            }
				tuTurno.setBackground(new Color(0, 255, 0));
			}
		});
		
		botonPPT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PPT frame2 = new PPT();
				frame2.setVisible(true);
				cerrar();
			}
		});
		
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	static char[][] clonarMatriz(char[][] tableroOriginal) {
        char[][] copia = new char[FILAS][COLUMNAS];
        for (int y = 0; y < FILAS; y++) {
            for (int x = 0; x < COLUMNAS; x++) {
                copia[y][x] = tableroOriginal[y][x];
            }
        }
        return copia;
    }

    static void limpiarTablero(char[][] tablero) {
        for (int y = 0; y < FILAS; y++) {
            for (int x = 0; x < COLUMNAS; x++) {
                tablero[y][x] = vacio;
            }
        }
    }

    static void imprimirTablero(char[][] tablero) {
        System.out.print("\n");
        int y;
        int x;
        System.out.print("| ");
        for (x = 0; x < COLUMNAS; x++) {
            System.out.printf("|%d", x + 1);
        }
        System.out.print("|\n");
        for (y = 0; y < FILAS; y++) {
            System.out.printf("|%d", y + 1);
            for (x = 0; x < COLUMNAS; x++) {
                System.out.printf("|%c", tablero[y][x]);
            }
            System.out.print("|\n");
        }
    }

    static boolean coordenadasVacias(int y, int x, char[][] tablero) {
        return tablero[y][x] == vacio;
    }

    static void colocarPieza(int y, int x, char pieza, char[][] tablero) {
        if (y < 0 || y >= FILAS) {
            System.out.print("Fila incorrecta");
            return;
        }

        if (x < 0 || x >= COLUMNAS) {
            System.out.print("Columna incorrecta");
            return;
        }
        if (pieza != jugador_o && pieza != jugador_x) {
            System.out.printf("La pieza debe ser %c o %c", jugador_o, jugador_x);
            return;
        }
        if (!coordenadasVacias(y, x, tablero)) {
            System.out.print("Coordenadas ya ocupadas");
            return;
        }
        tablero[y][x] = pieza;
    }

    static int contarHaciaArriba(int x, int y, char jugador, char[][] tablero) {
        int yInicio = (y - conteoGanar >= 0) ? y - conteoGanar + 1 : 0;
        int contador = 0;
        for (; yInicio <= y; yInicio++) {
            if (tablero[yInicio][x] == jugador) {
                contador++;
            } else {
                contador = 0;
            }
        }
        return contador;
    }

    static int contarHaciaDerecha(int x, int y, char jugador, char[][] tablero) {
        int xFin = (x + conteoGanar < COLUMNAS) ? x + conteoGanar - 1 : COLUMNAS - 1;
        int contador = 0;
        for (; x <= xFin; x++) {
            if (tablero[y][x] == jugador) {
                contador++;
            } else {
                contador = 0;
            }
        }
        return contador;
    }

    static int contarHaciaArribaDerecha(int x, int y, char jugador, char[][] tablero) {
        int xFin = (x + conteoGanar < COLUMNAS) ? x + conteoGanar - 1 : COLUMNAS - 1;
        int yInicio = (y - conteoGanar >= 0) ? y - conteoGanar + 1 : 0;
        int contador = 0;
        while (x <= xFin && yInicio <= y) {
            if (tablero[y][x] == jugador) {
                contador++;
            } else {
                contador = 0;
            }
            x++;
            y--;
        }
        return contador;
    }

    static int contarHaciaAbajoDerecha(int x, int y, char jugador, char[][] tablero) {
        int xFin = (x + conteoGanar < COLUMNAS) ? x + conteoGanar - 1 : COLUMNAS - 1;
        int yFin = (y + conteoGanar < FILAS) ? y + conteoGanar - 1 : FILAS - 1;
        int contador = 0;
        while (x <= xFin && y <= yFin) {
            if (tablero[y][x] == jugador) {
                contador++;
            } else {
                contador = 0;
            }
            x++;
            y++;
        }
        return contador;
    }

    static boolean comprobarSiGana(char jugador, char[][] tablero) {
        int y;
        for (y = 0; y < FILAS; y++) {
            int x;
            for (x = 0; x < COLUMNAS; x++) {
                if (
                        contarHaciaArriba(x, y, jugador, tablero) >= conteoGanar ||
                                contarHaciaDerecha(x, y, jugador, tablero) >= conteoGanar ||
                                contarHaciaArribaDerecha(x, y, jugador, tablero) >= conteoGanar ||
                                contarHaciaAbajoDerecha(x, y, jugador, tablero) >= conteoGanar) {
                    return true;
                }
            }
        }
        return false;
    }

    static char oponenteDe(char jugador) {
        if (jugador == jugador_o) {
            return jugador_x;
        } else {
            return jugador_o;
        }
    }

    static void hablar(String mensaje, char jugador) {
        System.out.printf("\nCPU (%c) dice: %s\n\n", jugador, mensaje);
    }

    static boolean empate(char[][] tableroOriginal) {
        int y;
        for (y = 0; y < FILAS; y++) {
            int x;
            for (x = 0; x < COLUMNAS; x++) {
                if (tableroOriginal[y][x] == vacio) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int aleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    static int[] obtenerCoordenadasAleatorias(char jugador, char[][] tableroOriginal) {
        int x, y;
        do {
            x = aleatorioEnRango(0, COLUMNAS - 1);
            y = aleatorioEnRango(0, FILAS - 1);
        } while (!coordenadasVacias(y, x, tableroOriginal));
        return new int[]{x, y};
    }

    static int[] coordenadasParaGanar(char jugador, char[][] tableroOriginal) {
        int y, x;
        for (y = 0; y < FILAS; y++) {
            for (x = 0; x < COLUMNAS; x++) {
                char[][] copiaTablero = clonarMatriz(tableroOriginal);
                if (coordenadasVacias(y, x, copiaTablero)) {
                    colocarPieza(y, x, jugador, copiaTablero);
                    if (comprobarSiGana(jugador, copiaTablero)) {
                        return new int[]{x, y};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int contarSinSaberCoordenadas(char jugador, char[][] copiaTablero) {
        int conteoMayor = 0;
        int x, y;
        for (y = 0; y < FILAS; y++) {
            for (x = 0; x < COLUMNAS; x++) {
                int conteoTemporal;
                conteoTemporal = contarHaciaArriba(x, y, jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                }
                conteoTemporal = contarHaciaArribaDerecha(x, y, jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                }

                conteoTemporal = contarHaciaDerecha(x, y, jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                }

                conteoTemporal = contarHaciaAbajoDerecha(x, y, jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                }
            }
        }
        return conteoMayor;
    }

    static int[] coordenadasParaMayorPuntaje(char jugador, char[][] tableroOriginal) {
        int y, x;
        int conteoMayor = 0,
                xConteoMayor = -1,
                yConteoMayor = -1;
        for (y = 0; y < FILAS; y++) {
            for (x = 0; x < COLUMNAS; x++) {
                char[][] copiaTablero = clonarMatriz(tableroOriginal);
                if (!coordenadasVacias(y, x, copiaTablero)) {
                    continue;
                }
                // Colocamos y contamos el puntaje
                colocarPieza(y, x, jugador, copiaTablero);
                int conteoTemporal = contarSinSaberCoordenadas(jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                    yConteoMayor = y;
                    xConteoMayor = x;
                }
            }
        }
        return new int[]{conteoMayor, xConteoMayor, yConteoMayor};
    }

    static int[] elegirCoordenadasCpu(char jugador, char[][] tablero) {

        int y, x, conteoJugador, conteoOponente;
        int yOponente, xOponente;
        int[] coordenadas = new int[2];
        char oponente = oponenteDe(jugador);
        // 1
        coordenadas = coordenadasParaGanar(jugador, tablero);
        x = coordenadas[0];
        y = coordenadas[1];
        if (y != -1 && x != -1) {
            return new int[]{x, y};
        }
        coordenadas = coordenadasParaGanar(oponente, tablero);
        x = coordenadas[0];
        y = coordenadas[1];
        if (y != -1 && x != -1) {
            return new int[]{x, y};
        }
        int[] coordenadasJugador = coordenadasParaMayorPuntaje(jugador, tablero);
        int[] coordenadasOponente = coordenadasParaMayorPuntaje(oponente, tablero);
        conteoJugador = coordenadasJugador[0];
        x = coordenadasJugador[1];
        y = coordenadasJugador[2];
        conteoOponente = coordenadasOponente[0];
        xOponente = coordenadasOponente[1];
        yOponente = coordenadasOponente[2];
        if (conteoOponente > conteoJugador) {
            return new int[]{xOponente, yOponente};
        } else if (conteoJugador > 0) {
            return new int[]{x, y};
        }
        if (coordenadasVacias(0, 0, tablero)) {
            return new int[]{0, 0};
        }
        coordenadas = obtenerCoordenadasAleatorias(jugador, tablero);
        return coordenadas;
    }

    static char jugadorAleatorio() {
        if (aleatorioEnRango(0, 1) == 0) {
            return jugador_o;
        } else {
            return jugador_x;
        }
    }
    
    void cerrar() {
		this.dispose();
	}
}
