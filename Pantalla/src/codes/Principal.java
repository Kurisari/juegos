package codes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JButton botonBM;
	private JTextField cuadroUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\\\Users\\\\crisa\\\\workspace\\\\juegos\\\\juegos\\\\Pantalla\\\\imgs\\consola-de-juego.png"));
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152 , 648);
		contentPane = 	new JPanel();
		contentPane.setBackground(new Color(155, 175, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonPPT = new JButton("PP&T");
		
		botonPPT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonPPT.setBounds(358, 50, 130, 35);
		contentPane.add(botonPPT);
		
		botonBM = new JButton("Buscaminas");
		
		botonBM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonBM.setBounds(626, 50, 130, 35);
		contentPane.add(botonBM);
		
		JButton botonGato = new JButton("Gato");
		
		botonGato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonGato.setBounds(914, 50, 130, 35);
		contentPane.add(botonGato);
		
		JButton botonNuevo = new JButton("Nuevo");
		
		botonNuevo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonNuevo.setBounds(92, 50, 130, 35);
		contentPane.add(botonNuevo);
		
		JButton botonCargar = new JButton("Cargar");
		
		botonCargar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonCargar.setBounds(493, 112, 130, 35);
		contentPane.add(botonCargar);
		
		JLabel txtUsuario = new JLabel("Usuario");
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtUsuario.setBounds(493, 212, 130, 35);
		contentPane.add(txtUsuario);
		txtUsuario.setVisible(false);
		
		cuadroUsuario = new JTextField();
		cuadroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cuadroUsuario.setBounds(493, 247, 130, 35);
		contentPane.add(cuadroUsuario);
		cuadroUsuario.setColumns(10);
		cuadroUsuario.setVisible(false);
		
		JButton botonContinuar = new JButton("Continuar");
		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonContinuar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonContinuar.setBounds(493, 292, 130, 35);
		contentPane.add(botonContinuar);
		botonContinuar.setVisible(false);
		
		JLabel txtBuscarUsuario = new JLabel("Buscar Usuario");
		txtBuscarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscarUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtBuscarUsuario.setBounds(493, 212, 130, 35);
		contentPane.add(txtBuscarUsuario);
		txtBuscarUsuario.setVisible(false);
		
		JButton botonContinuar2 = new JButton("Continuar");
		botonContinuar2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonContinuar2.setBounds(493, 292, 130, 35);
		contentPane.add(botonContinuar2);
		botonContinuar2.setVisible(false);
		
		botonNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setVisible(true);
				cuadroUsuario.setVisible(true);
				botonContinuar.setVisible(true);
				txtBuscarUsuario.setVisible(false);
				botonContinuar2.setVisible(false);
			}
		});
		
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscarUsuario.setVisible(true);
				cuadroUsuario.setVisible(true);
				botonContinuar2.setVisible(true);
				txtUsuario.setVisible(false);
				botonContinuar.setVisible(false);
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
		
		botonBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscaminas frame4 = new Buscaminas();
				frame4.setVisible(true);
				cerrar();
			}
		});
		
		
	}

	Properties config = new Properties();
    InputStream configInput = null;
    public void loadConfig(){
        try{
            configInput = new FileInputStream("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\src\\codes\\config.properties");
            config.load(configInput);
            System.out.println(config.getProperty("password"));
            System.out.println(config.getProperty("name"));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	void cerrar() {
		this.dispose();
	}
}
