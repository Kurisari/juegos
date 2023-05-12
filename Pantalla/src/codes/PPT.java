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

public class PPT extends JFrame {

	private JPanel contentPane;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\crisa\\Downloads\\consola-de-juego.png"));
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
		
		JButton btnNewButton = new JButton("New button");
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\crisa\\Downloads\\piedra (1).png"));
		btnNewButton.setBounds(307, 303, 200, 247);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
