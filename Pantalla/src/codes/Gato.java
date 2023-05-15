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
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gato extends JFrame {

	private JPanel contentPane;
	private static int FILAS = 3;
	private static int COLUMNAS = 3;
	private static char jugador_x = 'X';
	private static char jugador_o = 'O';
	private static char vacio = ' ';
	private static char jugador_cpu = jugador_o;
	private char[][] tablero = new char[FILAS][COLUMNAS];
	private static int conteoGanar = 3;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\crisa\\Downloads\\consola-de-juego.png"));
		setTitle("Gato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152 , 648);
		contentPane = 	new JPanel();
		contentPane.setBackground(new Color(155, 175, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonIniciarSesion = new JButton("Iniciar");
		
		botonIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonIniciarSesion.setBounds(70, 50, 130, 35);
		contentPane.add(botonIniciarSesion);
		
		JButton botonPPT = new JButton("PP&T");
		
		botonPPT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonPPT.setBounds(358, 50, 130, 35);
		contentPane.add(botonPPT);	
		
		JButton botonBM = new JButton("Buscaminas");
		botonBM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonBM.setBounds(626, 50, 130, 35);
		contentPane.add(botonBM);
		
		JButton botonGato = new JButton("Gato");
		
		botonGato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonGato.setBounds(914, 50, 130, 35);
		contentPane.add(botonGato);
		
		JButton pos1 = new JButton("");
		pos1.setEnabled(false);
		pos1.setFont(new Font("Tahoma", Font.BOLD, 90));
		pos1.setBounds(358, 139, 130, 130);
		contentPane.add(pos1);
		
		JButton pos2 = new JButton("");
		pos2.setEnabled(false);
		pos2.setBounds(498, 139, 130, 130);
		pos2.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos2);
		
		JButton pos3 = new JButton("");
		pos3.setEnabled(false);
		pos3.setBounds(638, 139, 130, 130);
		pos3.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos3);
		
		JButton pos4 = new JButton("");
		pos4.setEnabled(false);
		pos4.setBounds(358, 279, 130, 130);
		pos4.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos4);
		
		JButton pos5 = new JButton("");
		pos5.setEnabled(false);
		pos5.setBounds(498, 279, 130, 130);
		pos5.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos5);
		
		JButton pos6 = new JButton("");
		pos6.setEnabled(false);
		pos6.setBounds(638, 279, 130, 130);
		pos6.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos6);
		
		JButton pos7 = new JButton("");
		pos7.setEnabled(false);
		pos7.setBounds(358, 419, 130, 130);
		pos7.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos7);
		
		JButton pos8 = new JButton("");
		pos8.setEnabled(false);
		pos8.setBounds(498, 419, 130, 130);
		pos8.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos8);
		
		JButton pos9 = new JButton("");
		pos9.setEnabled(false);
		pos9.setBounds(638, 419, 130, 130);
		pos9.setFont(new Font("Tahoma", Font.BOLD, 90));
		contentPane.add(pos9);
		
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
		
		botonIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTablero(tablero);
			}
		});
		
	}
	public static char[][] clonarMatriz(char[][] tableroOriginal){
		char[][] copiaMatriz = new char[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                copiaMatriz[i][j] = tableroOriginal[i][j];
            }
        }
        return copiaMatriz;
	}
	public static void limpiarTablero(char[][] tablero){
		for(int i = 0; i < FILAS; i++) {
			for(int j = 0; j < COLUMNAS; j++) {
				tablero[i][j] = vacio;
			}
		}
	}
	public static boolean coordenadasVacias(int y, int x, char[][] tablero) {
		return tablero[y][x] == vacio;
	}
	public static void colocarPieza(int y, int x, char ficha, char[][] tablero) {
		tablero[y][x] = ficha;
	}
	public static int contarArriba(int x, int y, char jugador, char[][] tablero) {
		int yInicio = (y - conteoGanar >= 0) ? y - conteoGanar + 1 : 0;
		int contador = 0;
		for(; yInicio <= y; yInicio++) {
			if(tablero[yInicio][x] == jugador) {
				contador++;
			} else {
				contador = 0;
			}
		}
		return contador;
	}
	public static int contarDerecha(int x, int y, char jugador, char[][] tablero) {
		int xFin = (x - conteoGanar >= 0) ? x - conteoGanar + 1 : 0;
		int contador = 0;
		for(; xFin <= y; x++) {
			if(tablero[y][x] == jugador) {
				contador++;
			} else {
				contador = 0;
			}
		}
		return contador;
	}
	public static int contarArribaDerecha(int x, int y, char jugador, char[][] tablero) {
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
	public static int contarAbajoDerecha(int x, int y, char jugador, char[][] tablero) {
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
	public static boolean comprobarGana(char jugador, char[][] tablero) {
		for(int y = 0; y < FILAS; y++) {
			for(int x = 0; x < COLUMNAS; x++) {
				if(contarArriba(x, y, jugador, tablero) >= conteoGanar ||
                        contarDerecha(x, y, jugador, tablero) >= conteoGanar ||
                        contarArribaDerecha(x, y, jugador, tablero) >= conteoGanar ||
                        contarAbajoDerecha(x, y, jugador, tablero) >= conteoGanar) {
					return true;
				}
			}
		}
		return false;
	}
	public static char oponente(char jugador) {
		if(jugador == jugador_o) return jugador_x;
		else return jugador_o;
	}
	public static boolean empate(char[][] tableroOriginal) {
		for(int y = 0; y < FILAS; y++) {
			for(int x = 0; x < COLUMNAS; x++) {
				if(tableroOriginal[y][x] == vacio) return false; 
			}
		}
		return true;
	}
	public static int aleatorio(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	public static int[] coordenadasAleatorias(char jugador, char[][] tableroOriginal) {
		int x, y;
		do {
			x = aleatorio(0, COLUMNAS -1);
			y = aleatorio(0, FILAS - 1);
		} while(!coordenadasVacias(y, x, tableroOriginal));
		return new int[] {x, y};
	}
	public static int[] coordenadasGanar(char jugador, char[][] tableroOriginal) {
        int y, x;
        for (y = 0; y < FILAS; y++) {
            for (x = 0; x < COLUMNAS; x++) {
                char[][] copiaTablero = clonarMatriz(tableroOriginal);
                if (coordenadasVacias(y, x, copiaTablero)) {
                    colocarPieza(y, x, jugador, copiaTablero);
                    if (comprobarGana(jugador, copiaTablero)) {
                        return new int[]{x, y};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
	public static int contarSinSaberCoordenadas(char jugador, char[][] copiaTablero) {
        int conteoMayor = 0;
        int x, y;
        for (y = 0; y < FILAS; y++) {
            for (x = 0; x < COLUMNAS; x++) {
                int conteoTemporal;
                conteoTemporal = contarArriba(x, y, jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                }
                conteoTemporal = contarArribaDerecha(x, y, jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                }

                conteoTemporal = contarDerecha(x, y, jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                }

                conteoTemporal = contarAbajoDerecha(x, y, jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                }
            }
        }
        return conteoMayor;
    }
	public static int[] coordenadasParaMayorPuntaje(char jugador, char[][] tableroOriginal) {
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
	public static int[] elegirCoordenadasCpu(char jugador, char[][] tablero) {
        int y, x, conteoJugador, conteoOponente;
        int yOponente, xOponente;
        int[] coordenadas = new int[2];
        char oponente = oponente(jugador);
        coordenadas = coordenadasGanar(jugador, tablero);
        x = coordenadas[0];
        y = coordenadas[1];
        if (y != -1 && x != -1) {
            return new int[]{x, y};
        }
        coordenadas = coordenadasGanar(oponente, tablero);
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
        coordenadas = coordenadasAleatorias(jugador, tablero);
        return coordenadas;
    }
	public static char jugadorAleatorio() {
        if (aleatorio(0, 1) == 0) {
            return jugador_o;
        } else {
            return jugador_x;
        }
    }
}
