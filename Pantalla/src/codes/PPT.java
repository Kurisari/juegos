package codes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PPT extends JFrame {

	private JPanel contentPane;
	int contador = 0;
	int contadorMachine = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PPT frame = new PPT();
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
	public PPT() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\\\Users\\\\crisa\\\\workspace\\\\juegos\\\\juegos\\\\Pantalla\\\\imgs\\consola-de-juego.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Piedra Papel o Tijera");
		setBounds(100, 100, 1152 , 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(155, 175, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonIniciarSesion = new JButton("Iniciar Sesión");
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
		
		JButton botonPiedra = new JButton("");
		
		botonPiedra.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\eleccion\\piedra.png"));
		botonPiedra.setBounds(70, 121, 100, 122);
		contentPane.add(botonPiedra);
		
		JButton botonPapel = new JButton("");
		
		botonPapel.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\eleccion\\papel.png"));
		botonPapel.setBounds(70, 263, 100, 122);
		contentPane.add(botonPapel);
		
		JButton botonTijera = new JButton("");
		
		botonTijera.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\eleccion\\tijera.png"));
		botonTijera.setBounds(70, 403, 100, 122);
		contentPane.add(botonTijera);
		
		JLabel lblNewLabel = new JLabel("VS");
		lblNewLabel.setForeground(new Color(214, 222, 225));
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 68));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(466, 253, 198, 102);
		contentPane.add(lblNewLabel);
		
		JLabel eleccionUsuario = new JLabel("");
		
		eleccionUsuario.setBounds(229, 152, 250, 309);
		contentPane.add(eleccionUsuario);
		
		JLabel eleccionMaquina = new JLabel("");
		eleccionMaquina.setBounds(685, 152, 250, 309);
		contentPane.add(eleccionMaquina);
		
		JLabel contadorUsuario = new JLabel("0");
		contadorUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		contadorUsuario.setForeground(new Color(214, 222, 225));
		contadorUsuario.setFont(new Font("Gill Sans MT", Font.BOLD, 68));
		contadorUsuario.setBounds(249, 471, 198, 102);
		contentPane.add(contadorUsuario);
		
		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(214, 222, 225));
		lblNewLabel_2.setFont(new Font("Gill Sans MT", Font.BOLD, 68));
		lblNewLabel_2.setBounds(466, 471, 198, 102);
		contentPane.add(lblNewLabel_2);
		
		JLabel contadorMaquina = new JLabel("0");
		contadorMaquina.setHorizontalAlignment(SwingConstants.CENTER);
		contadorMaquina.setForeground(new Color(214, 222, 225));
		contadorMaquina.setFont(new Font("Gill Sans MT", Font.BOLD, 68));
		contadorMaquina.setBounds(707, 471, 198, 102);
		contentPane.add(contadorMaquina);
		
		
		botonPiedra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ganador = false;
				boolean empate = false;
				
				int maquina = (int)(Math.random()*3+1);
				eleccionUsuario.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\muestra\\piedra.png"));
				switch(maquina) {
				case 1:
					eleccionMaquina.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\muestra\\piedra.png"));
					empate = true;
					break;
				case 2:
					eleccionMaquina.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\muestra\\papel.png"));
					ganador = false;
					break;
				case 3:
					eleccionMaquina.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\muestra\\tijera.png"));
					ganador = true;
					break;
				}
				
				if(ganador) {
					contador++;
					contadorUsuario.setText(contador + "");
				} else if(empate) {
					contadorMaquina.setText(contadorMachine + "");
					contadorUsuario.setText(contador + "");
				} else {
					contadorMachine++;
					contadorMaquina.setText(contadorMachine + "");
				}
				
			}
		});
		
		botonPapel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccionUsuario.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\muestra\\papel.png"));
				boolean ganador = false;
				boolean empate = false;
				
				int maquina = (int)(Math.random()*3+1);
				switch(maquina) {
				case 1:
					eleccionMaquina.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\muestra\\piedra.png"));
					ganador = true;
					break;
				case 2:
					eleccionMaquina.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\muestra\\papel.png"));
					empate = true;
					break;
				case 3:
					eleccionMaquina.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\muestra\\tijera.png"));
					ganador = false;
					break;
				}
				
				if(ganador) {
					contador++;
					contadorUsuario.setText(contador + "");
				} else if(empate) {
					contadorMaquina.setText(contadorMachine + "");
					contadorUsuario.setText(contador + "");
				} else {
					contadorMachine++;
					contadorMaquina.setText(contadorMachine + "");
				}
			}
		});
		
		botonTijera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccionUsuario.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\muestra\\tijera.png"));
				boolean ganador = false;
				boolean empate = false;
				
				int maquina = (int)(Math.random()*3+1);
				switch(maquina) {
				case 1:
					eleccionMaquina.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\muestra\\piedra.png"));
					ganador = false;
					break;
				case 2:
					eleccionMaquina.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\muestra\\papel.png"));
					ganador = true;
					break;
				case 3:
					eleccionMaquina.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\muestra\\tijera.png"));
					empate = true;
					break;
				}
				
				if(ganador) {
					contador++;
					contadorUsuario.setText(contador + "");
				} else if(empate) {
					contadorMaquina.setText(contadorMachine + "");
					contadorUsuario.setText(contador + "");
				} else {
					contadorMachine++;
					contadorMaquina.setText(contadorMachine + "");
				}
			}
		});
	}
}
