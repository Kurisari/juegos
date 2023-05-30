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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class PPT extends JFrame {

	private JPanel contentPane;
	int contador = 0;
	int contadorMachine = 0;
	int vecesJugadas = 0;
	public static Properties config1 = new Properties();
	public static InputStream configInput = null;

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
		
		JButton botonGuardar = new JButton("Guardar");
		
		botonGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonGuardar.setBounds(70, 50, 130, 35);
		contentPane.add(botonGuardar);
		
		JButton botonPPT = new JButton("PP&T");
		botonPPT.setEnabled(false);
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
		
		JButton botonHome = new JButton("");
		
		botonHome.setIcon(new ImageIcon("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\imgs\\casa (1).png"));
		botonHome.setBounds(10, 551, 50, 50);
		contentPane.add(botonHome);
		
		try {
			configInput = new FileInputStream("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\src\\codes\\config.properties");
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
		textoUsuario.setBounds(1040, 471, 88, 35);
		textoUsuario.setText(cargarBD(config1.getProperty("usuario1")+"", "nombre"));
		contentPane.add(textoUsuario);
		
		JLabel lblNewLabel_2_1 = new JLabel("Usuario:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(971, 471, 88, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(971, 516, 59, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel textoID = new JLabel("");
		textoID.setFont(new Font("Tahoma", Font.BOLD, 16));
		textoID.setBounds(1013, 509, 88, 35);
		textoID.setText(cargarBD(config1.getProperty("usuario1")+"", "ID"));
		contentPane.add(textoID);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Score:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(971, 548, 88, 35);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel textoScore = new JLabel((String) null);
		textoScore.setFont(new Font("Tahoma", Font.BOLD, 16));
		textoScore.setBounds(1040, 548, 88, 35);
		textoScore.setText(cargarPropia(config1.getProperty("usuario1")+"", "score"));
		contentPane.add(textoScore);
		
		botonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal frame3 = new Principal();
				frame3.setVisible(true);
				cerrar();
			}
		});
		
		botonPiedra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vecesJugadas++;
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
				vecesJugadas++;
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
				vecesJugadas++;
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
		
		botonGato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gato frame3 = new Gato();
				frame3.setVisible(true);
				cerrar();
			}
		});
		
		botonBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscaminas frame4 = new Buscaminas();
				frame4.setVisible(true);
				cerrar();
			}
		});
		
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				configInput = new FileInputStream("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\src\\codes\\config.properties");
	            config1.load(configInput);
	            
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", loadConfig("name"), loadConfig("password"));
		        PreparedStatement pst = cn.prepareStatement("update PPT set score = ?, contador = ? where ID = ?");
		        PreparedStatement pst1 = cn.prepareStatement("select * from PPT");
		        ResultSet rs = pst1.executeQuery();
		        rs.next(); // Mover el cursor al primer registro
		        int contador1 = Integer.parseInt(rs.getString("contador"));
		        int score = Integer.parseInt(rs.getString("score"));
		        contador1+= contador;
                score += 100*contador1;
                pst.setString(1, Integer.toString(score));
                pst.setString(2, Integer.toString(contador));
                pst.setString(3, config1.getProperty("usuario1")+"");
                //System.out.println(config1.getProperty("usuario1")+"");
                pst.executeUpdate();
				} catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		
	}
	void cerrar() {
		this.dispose();
	}
	public String loadConfig(String property){
        try{
            configInput = new FileInputStream("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\src\\codes\\globalConfig.properties");
            config1.load(configInput);
            return config1.getProperty(property);
            //System.out.println(config1.getProperty("password"));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return "";
        }
    }
	public String cargarBD(String nombre, String propiedad) {
		try{
			//System.out.println("Ingrese el ID del usuario");
			String usuario = nombre;
			
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", loadConfig("name"), loadConfig("password"));
            PreparedStatement pst = cn.prepareStatement("select * from usuario where ID = ?");
            pst.setString(1, usuario.trim());		            
            ResultSet rs = pst.executeQuery();		            
            if(rs.next()){
            	//JOptionPane.showMessageDialog(null, "Se ha cargado correctamente el usuario");
            	//System.out.println("Se ha cargado correctamente el usuario");	
            	return rs.getString(propiedad);
            } else {
            	JOptionPane.showMessageDialog(null, "No se ha registrado ese usuario");
                //System.out.println("No se ha registrado ese usuario");
            	return "";
            }		 
            
        }catch(Exception e1){
        	System.out.println(e1);
        }
		return "";
	}
	
	public String cargarPropia(String nombre, String propiedad) {
		try{
			//System.out.println("Ingrese el ID del usuario");
			String usuario = nombre;
			
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", loadConfig("name"), loadConfig("password"));
            PreparedStatement pst = cn.prepareStatement("select * from ppt where ID = ?");
            pst.setString(1, usuario.trim());		            
            ResultSet rs = pst.executeQuery();		            
            if(rs.next()){
            	//JOptionPane.showMessageDialog(null, "Se ha cargado correctamente el usuario");
            	//System.out.println("Se ha cargado correctamente el usuario");	
            	return rs.getString(propiedad);
            } else {
            	JOptionPane.showMessageDialog(null, "No se ha registrado ese usuario");
                //System.out.println("No se ha registrado ese usuario");
            	return "";
            }		 
            
        }catch(Exception e1){
        	System.out.println(e1);
        }
		return "";
	}
}
