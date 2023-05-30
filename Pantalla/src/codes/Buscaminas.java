package codes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class Buscaminas extends JFrame {
	private JPanel jPanel1 = new JPanel();
	private JButton jButton1 = new JButton();
	public int ancho = 10;
	public int alto = 8;
	public JButton Botones[][] = new JButton[ancho][alto];
	public String[][] elArray = new String[ancho][alto];
	int vecesJugadas = 0;
	public static Properties config1 = new Properties();
	public static InputStream configInput = null;

	public static void main(String[] args) {
		Buscaminas TabBuscaMin = new Buscaminas();
	}

	public Buscaminas() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\consola-de-juego.png"));
		getContentPane().setBackground(new Color(155, 175, 181));
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		// Esta linea es para modificar El cuador principal
		this.setSize(new Dimension(1152, 648));
		this.setBackground(new Color(55, 175, 181));
		this.setTitle("Busca Minas");
		// Esta linea es para modificar el rectangulo naranga (posicion x, posicion y,
		// ancho, altura)
		jPanel1.setBounds(new Rectangle(100, 100, 952, 448));
		// Modificar color
		jPanel1.setBackground(new Color(162, 175, 227));
		jPanel1.setLayout(null);
		this.getContentPane().add(jPanel1, null);
		jButton1.setBounds(71, 50, 125, 40);
		getContentPane().add(jButton1);

		jButton1.setText("Iniciar");
		jButton1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
		jButton1.setAlignmentY((float) 0.0);
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

		try {
			configInput = new FileInputStream(
					"C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\src\\codes\\config.properties");
			try {
				config1.load(configInput);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}

		JLabel textoUsuario = new JLabel("");
		textoUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		textoUsuario.setBounds(169, 566, 88, 35);
		textoUsuario.setText(cargarBD(config1.getProperty("usuario1") + "", "nombre"));
		getContentPane().add(textoUsuario);

		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(100, 566, 88, 35);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(314, 573, 59, 20);
		getContentPane().add(lblNewLabel_3);

		JLabel textoID = new JLabel("");
		textoID.setFont(new Font("Tahoma", Font.BOLD, 16));
		textoID.setBounds(356, 566, 88, 35);
		textoID.setText(cargarBD(config1.getProperty("usuario1") + "", "ID"));
		getContentPane().add(textoID);

		JLabel textoScore = new JLabel((String) null);
		textoScore.setFont(new Font("Tahoma", Font.BOLD, 16));
		textoScore.setBounds(556, 566, 88, 35);
		textoScore.setText(cargarPropia(config1.getProperty("usuario1") + "", "score"));
		getContentPane().add(textoScore);

		JLabel lblNewLabel_2_1_1 = new JLabel("Score:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(487, 566, 88, 35);
		getContentPane().add(lblNewLabel_2_1_1);

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
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton1_actionPerformed(e);
			}
		});

		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vecesJugadas++;
				try {
					configInput = new FileInputStream(
							"C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\src\\codes\\config.properties");
					config1.load(configInput);

					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", loadConfig("name"),
							loadConfig("password"));
					// busca minas
					PreparedStatement pst_buscaminas = cn
							.prepareStatement("update buscaminas set score = ?, contador = ? where ID = ?");
					PreparedStatement pst1_buscaminas = cn.prepareStatement("select * from buscaminas");
					ResultSet rs_buscaminas = pst1_buscaminas.executeQuery();
					rs_buscaminas.next(); // Mover el cursor al primer registro de "buscaminas"
					int contador_buscaminas = Integer.parseInt(rs_buscaminas.getString("contador"));
					int score_buscaminas = Integer.parseInt(rs_buscaminas.getString("score"));
					contador_buscaminas++;
					score_buscaminas += 100;
					pst_buscaminas.setString(1, Integer.toString(score_buscaminas));
					pst_buscaminas.setString(2, Integer.toString(contador_buscaminas));
					pst_buscaminas.setString(3, config1.getProperty("usuario1") + "");
					pst_buscaminas.executeUpdate();
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		cargarTablero();
		colocarBomba(getAncho());
		comprueba();

		this.setVisible(true);

		// —- Oculta los botones del contorno que no participaran en el juego.

		ocultaBotones();
	}

	private void jButton1_actionPerformed(ActionEvent e) {
		vecesJugadas++;
		for (int i = 0; i < ancho; i++) {
			for (int z = 0; z < alto; z++) {
				elArray[i][z] = " ";
				Botones[i][z].setEnabled(true);
				Botones[i][z].setText(" ");
			}
		}
		colocarBomba(getAncho());
		comprueba();
		this.setTitle("Busca Minas");
		jButton1.setText("Iniciar");
	}
	// —– Inicializa el tablero a 0

	public void cargarTablero() {
		for (int i = 0; i < ancho; i++) {
			for (int z = 0; z < alto; z++) {
				elArray[i][z] = " ";
				Botones[i][z] = new JButton();
				jPanel1.add(Botones[i][z]);
				// Esta linea es para modificar la posicion de los botones
				Botones[i][z].setBounds((i * 75) + 100, (z * 45) + 50, 75, 45);
				// Botones[i][z].setMargin(new Insets(100, 100, 100, 100));
				Botones[i][z].setFont(new Font("Tahoma", Font.PLAIN, 16));

				Botones[i][z].addActionListener(
						new ActionListener() {
							public void actionPerformed(ActionEvent ar) {
								for (int i = 0; i < ancho; i++) {
									for (int z = 0; z < alto; z++) {
										if (ar.getSource() == Botones[i][z]) {
											showTextTop(i, z);
											// —– Cada Evento llama al método pulsarBoton.
										}
									}
								}
							}
						});

			}
		}
	}
	// —- Coloca el numero de bombas dependiendo el ancho.

	public void colocarBomba(int numeroBombas) {
		double i = 0;
		double z = 0;
		int condicion = 0;
		do {
			i = Math.random() * getAncho();
			z = Math.random() * getAlto();
			i = (int) i;
			z = (int) z;
			if (z != 0 && i != 0 && z != alto - 1 && i != ancho - 1) {
				// Botones[(int) i][(int) z].setText("B");
				elArray[(int) i][(int) z] = "B";
				condicion++;
			}
		} while (condicion <= ancho);
	}

	public void setAncho(int sAncho) {
		ancho = sAncho;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAlto(int sAlto) {
		alto = sAlto;
	}

	public int getAlto() {
		return alto;
	}

	// —- Asigna un número a cada boton dependiendo de las B que tenga al lado.
	// --- codigo Busca Minas
	public void comprueba() {
		for (int i = 0; i < ancho; i++) {
			for (int z = 0; z < alto; z++) {
				int numeroComprueba = 0; // el numero que voy a asignar al boton
				if (elArray[i][z] != ("B")) {
					if (z != 0 && i != 0 && z != alto - 1 && i != ancho - 1) {
						// System.out.println(i+ " "+ z +" "+ ancho +" " +alto);

						if (elArray[i][z - 1] == "B") {
							numeroComprueba++;
						}
						if (elArray[i - 1][z - 1] == "B") {
							numeroComprueba++;
						}
						if (elArray[i + 1][z - 1] == "B") {
							numeroComprueba++;
						}
						if (elArray[i][z + 1] == "B") {
							numeroComprueba++;
						}
						if (elArray[i + 1][z + 1] == "B") {
							numeroComprueba++;
						}
						if (elArray[i - 1][z + 1] == "B") {
							numeroComprueba++;
						}
						if (elArray[i + 1][z] == "B") {
							numeroComprueba++;
						}
						if (elArray[i - 1][z] == "B") {
							numeroComprueba++;
						}
						if (numeroComprueba != 0) {
							elArray[i][z] = (String.valueOf(numeroComprueba));
						}
					}
				}
			}
		}
	}

	// —- Oculta los botones de los laterales.
	public void ocultaBotones() {
		for (int i = 0; i < ancho; i++) {
			for (int z = 0; z < alto; z++) {
				if (z == 0 || i == 0 || z == alto - 1 || i == ancho - 1) {
					Botones[i][z].setVisible(false);
				}
			}
		}

	}

	// —- Muestra el texto en todos los botones cuando hay bomba.

	public void textoBotones() {
		for (int i = 0; i < ancho; i++) {
			for (int z = 0; z < alto; z++) {
				Botones[i][z].setText(elArray[i][z]);
				Botones[i][z].setEnabled(false);
				// codigo para mostrar el texto encima del boton.
			}
		}

	}
	// —- Muestra el Numero encima del boton.
	// —- Cambia las propiedades del boton mostrado.

	public void showTextTop(int i, int z) {
		Botones[i][z].setText(elArray[i][z]);
		Botones[i][z].setEnabled(false);

		if (elArray[i][z] == " ") {
			Botones[i][z].setEnabled(false);
			metodoStackOverFlow(i, z);
		} else {
			Botones[i][z].setEnabled(false);
		}
		if (Botones[i][z].getText() == "B") {
			textoBotones();
		}

	}
	// —- Pone el numero en los botones cercanos.

	private void metodoStackOverFlow(int i, int z) {
		if (z != 0 && i != 0 && z != alto - 1 && i != ancho - 1) {
			Botones[i - 1][z].setEnabled(false);
			Botones[i - 1][z - 1].setEnabled(false);
			Botones[i - 1][z + 1].setEnabled(false);
			Botones[i][z - 1].setEnabled(false);
			Botones[i][z + 1].setEnabled(false);
			Botones[i + 1][z].setEnabled(false);
			Botones[i + 1][z + 1].setEnabled(false);
			Botones[i + 1][z - 1].setEnabled(false);

			Botones[i - 1][z].setText(elArray[i - 1][z]);
			Botones[i - 1][z - 1].setText(elArray[i - 1][z - 1]);
			Botones[i - 1][z + 1].setText(elArray[i - 1][z + 1]);
			Botones[i][z - 1].setText(elArray[i][z - 1]);
			Botones[i][z + 1].setText(elArray[i][z + 1]);
			Botones[i + 1][z].setText(elArray[i + 1][z]);
			Botones[i + 1][z + 1].setText(elArray[i + 1][z + 1]);
			Botones[i + 1][z - 1].setText(elArray[i + 1][z - 1]);
		}
	}

	// —- Este es el metodo que mostrara el final del game.
	// —- 17 columnas por 10 lineas visibles= 170 Botones[][]
	// —- 170 - 19 Bombas = 171 Botones con Texto
	// --- codigo Busca Minas

	public void finalGame() {
		int contadorFinal = 0;
		for (int i = 1; i < ancho - 1; i++) {
			for (int z = 1; z < alto - 1; z++) {
				if (Botones[i][z].getText() == " " || Botones[i][z].getText() == "1" ||
						Botones[i][z].getText() == "2" || Botones[i][z].getText() == "3" ||
						Botones[i][z].getText() == "5" || Botones[i][z].getText() == "4") {
					contadorFinal++;
					if (contadorFinal == 171) {
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

	public String loadConfig(String property) {
		try {
			configInput = new FileInputStream(
					"C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\src\\codes\\globalConfig.properties");
			config1.load(configInput);
			return config1.getProperty(property);
			// System.out.println(config1.getProperty("password"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			return "";
		}
	}

	public String cargarBD(String nombre, String propiedad) {
		try {
			// System.out.println("Ingrese el ID del usuario");
			String usuario = nombre;

			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", loadConfig("name"),
					loadConfig("password"));
			PreparedStatement pst = cn.prepareStatement("select * from usuario where ID = ?");
			pst.setString(1, usuario.trim());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				// JOptionPane.showMessageDialog(null, "Se ha cargado correctamente el
				// usuario");
				// System.out.println("Se ha cargado correctamente el usuario");
				return rs.getString(propiedad);
			} else {
				JOptionPane.showMessageDialog(null, "No se ha registrado ese usuario");
				// System.out.println("No se ha registrado ese usuario");
				return "";
			}

		} catch (Exception e1) {

		}
		return "";
	}

	public String cargarPropia(String nombre, String propiedad) {
		try {
			// System.out.println("Ingrese el ID del usuario");
			String usuario = nombre;

			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", loadConfig("name"),
					loadConfig("password"));
			PreparedStatement pst = cn.prepareStatement("select * from buscaminas where ID = ?");
			pst.setString(1, usuario.trim());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				// JOptionPane.showMessageDialog(null, "Se ha cargado correctamente el
				// usuario");
				// System.out.println("Se ha cargado correctamente el usuario");
				return rs.getString(propiedad);
			} else {
				JOptionPane.showMessageDialog(null, "No se ha registrado ese usuario");
				// System.out.println("No se ha registrado ese usuario");
				return "";
			}

		} catch (Exception e1) {
			System.out.println(e1);
		}
		return "";
	}
}