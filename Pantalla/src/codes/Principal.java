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
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Principal extends JFrame {

	private JPanel contentPane;
	private JButton botonBM;
	private JTextField cuadroUsuario;
	String usuario_principal = "";
	public static Properties config1 = new Properties();
	public static InputStream configInput = null;
	public static OutputStream configOutput = null;

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
		
		JButton botonContinuar2 = new JButton("Continuar");
		
		botonContinuar2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonContinuar2.setBounds(493, 372, 130, 35);
		contentPane.add(botonContinuar2);
		botonContinuar2.setVisible(false);
		
		JButton botonPPT = new JButton("PP&T");
		botonPPT.setEnabled(false);
		
		botonPPT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonPPT.setBounds(358, 50, 130, 35);
		contentPane.add(botonPPT);
		
		botonBM = new JButton("Buscaminas");
		botonBM.setEnabled(false);
		
		botonBM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonBM.setBounds(626, 50, 130, 35);
		contentPane.add(botonBM);
		
		JButton botonGato = new JButton("Gato");
		botonGato.setEnabled(false);
		
		botonGato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonGato.setBounds(914, 50, 130, 35);
		contentPane.add(botonGato);
		
		JButton botonNuevo = new JButton("Nuevo");
		
		botonNuevo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonNuevo.setBounds(92, 50, 130, 35);
		contentPane.add(botonNuevo);
		
		JButton botonCargar = new JButton("Cargar");
		
		botonCargar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonCargar.setBounds(538, 112, 130, 35);
		contentPane.add(botonCargar);
		
		JLabel txtUsuario = new JLabel("Usuario");
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtUsuario.setBounds(493, 212, 130, 35);
		contentPane.add(txtUsuario);
		txtUsuario.setVisible(false);
		
		cuadroUsuario = new JTextField();
		cuadroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cuadroUsuario.setBounds(493, 263, 130, 35);
		contentPane.add(cuadroUsuario);
		cuadroUsuario.setColumns(10);
		cuadroUsuario.setVisible(false);
		
		JButton botonContinuar = new JButton("Continuar");
		
		botonContinuar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonContinuar.setBounds(493, 372, 130, 35);
		contentPane.add(botonContinuar);
		botonContinuar.setVisible(false);
		
		JLabel txtBuscarUsuario = new JLabel("Buscar Usuario");
		txtBuscarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscarUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtBuscarUsuario.setBounds(493, 212, 130, 35);
		contentPane.add(txtBuscarUsuario);
		txtBuscarUsuario.setVisible(false);
		
		cuadroID = new JTextField();
		cuadroID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cuadroID.setBounds(493, 327, 130, 35);
		cuadroID.setVisible(false);
		contentPane.add(cuadroID);
		cuadroID.setColumns(10);

		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(493, 246, 45, 13);
		lblNewLabel.setVisible(false);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(493, 308, 45, 13);
		lblNewLabel_1.setVisible(false);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(92, 125, 88, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(92, 170, 59, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel textoUsuario = new JLabel("");
		textoUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		textoUsuario.setBounds(161, 125, 88, 35);
		contentPane.add(textoUsuario);
		
		JLabel textoID = new JLabel("");
		textoID.setFont(new Font("Tahoma", Font.BOLD, 16));
		textoID.setBounds(134, 163, 88, 35);
		contentPane.add(textoID);
		
		JButton botonMostrar = new JButton("Mostrar todos");
		
		botonMostrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonMostrar.setBounds(764, 112, 157, 35);
		contentPane.add(botonMostrar);
		
		JButton botonRecargar = new JButton("Refrescar");
		
		botonRecargar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonRecargar.setBounds(316, 112, 157, 35);
		contentPane.add(botonRecargar);
		botonRecargar.setEnabled(false);
		
		JLabel lblNewLabel_2_1 = new JLabel("Más jugado:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(92, 200, 88, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel textoMas = new JLabel("");
		textoMas.setFont(new Font("Tahoma", Font.BOLD, 16));
		textoMas.setBounds(190, 200, 130, 35);
		contentPane.add(textoMas);
		
		JLabel lblNewLabel_2_2 = new JLabel("Score total:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(92, 246, 88, 35);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel textoScoreTotal = new JLabel("");
		textoScoreTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		textoScoreTotal.setBounds(190, 246, 88, 35);
		contentPane.add(textoScoreTotal);
		
		botonNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setVisible(true);
				cuadroUsuario.setVisible(true);
				cuadroID.setVisible(true);
				botonContinuar.setVisible(true);
				txtBuscarUsuario.setVisible(false);
				botonContinuar2.setVisible(false);
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setVisible(true);
				lblNewLabel_1.setBounds(493, 308, 45, 13);
				cuadroID.setBounds(493, 327, 130, 35);
			}
		});
		
		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String ID;
					String usuario;
		        	Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", loadConfig("name"), loadConfig("password"));
		            PreparedStatement up_buscaminas = cn.prepareStatement("insert into proyecto.buscaminas values(?,0,0)");		          
		            PreparedStatement up_ppt = cn.prepareStatement("insert into proyecto.ppt values(?,0,0)");
		            PreparedStatement up_gato = cn.prepareStatement("insert into proyecto.gato values(?,0,0)");
		            PreparedStatement up_usuario = cn.prepareStatement("insert into proyecto.usuario values(?,?,0,0)");		           
		            PreparedStatement pst = cn.prepareStatement("select * from usuario where ID = ?");
		            
		        
		            
		            //System.out.println("Insertar ID de usuario: ");
		            ID = cuadroID.getText(); 
		            
		            pst.setString(1, ID);
		            ResultSet rs = pst.executeQuery();
		            
		            if(rs.next()) {
		            	JOptionPane.showMessageDialog(null, "Ese usuario ya se ha generado con anterioridad");
		            	// System.out.println("Ese usuario ya se ha generado con anterioridad");
		            }
		            else {
			            usuario = cuadroUsuario.getText();	
			            JOptionPane.showMessageDialog(null, "Se ha creado correctamente el usuario");
			            //System.out.println("Se ha creado correctamente el usuario");
			            usuario_principal = ID;
			            
			            up_buscaminas.setString(1, ID);
			            up_usuario.setString(1, ID);
			            up_usuario.setString(2, usuario);
			            up_ppt.setString(1, ID);
			            
			            up_gato.setString(1, ID);
			            setPropertyValue("usuario1", cuadroID.getText());
			            
			            up_buscaminas.executeUpdate();	
			            up_usuario.executeUpdate();
			            up_ppt.executeUpdate();
			            up_gato.executeUpdate();
			            //System.out.println("Usuario creado");
			            
			            textoID.setText(cuadroID.getText());
		            	textoUsuario.setText(cuadroUsuario.getText());
		            	textoMas.setText(cargarBD(cuadroID.getText(), "juego_mas"));
		            	textoScoreTotal.setText(cargarBD(cuadroID.getText(), "score"));
		            	cuadroUsuario.setText("");
		            	cuadroID.setText("");
		            	botonPPT.setEnabled(true);
		            	botonGato.setEnabled(true);
		            	botonBM.setEnabled(true);
		            	botonCargar.setEnabled(false);
		            	botonNuevo.setEnabled(false);
		            	cuadroUsuario.setEnabled(false);
		            	cuadroID.setEnabled(false);
		            	botonContinuar.setEnabled(false);
		            	botonRecargar.setEnabled(true);
		            }
		            
		            
		            
		            
		        } catch(Exception e1){
		        	System.out.println(e1);
		        }
			}
		});
		
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBuscarUsuario.setVisible(true);
				cuadroUsuario.setVisible(false);
				cuadroID.setVisible(true);
				cuadroID.setBounds(493, 263, 130, 35);
				botonContinuar2.setVisible(true);
				txtUsuario.setVisible(false);
				botonContinuar.setVisible(false);
				lblNewLabel.setVisible(false);
				lblNewLabel_1.setVisible(true);
				lblNewLabel_1.setBounds(493, 246, 45, 13);
			}
		});
		
		botonContinuar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//System.out.println("Ingrese el ID del usuario");
					String usuario = cuadroID.getText();
					
					setPropertyValue("usuario1", cuadroID.getText());
	            	
		            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", loadConfig("name"), loadConfig("password"));
		            PreparedStatement pst = cn.prepareStatement("select * from usuario where ID = ?");
		            pst.setString(1, usuario.trim());		            
		            ResultSet rs = pst.executeQuery();		            
		            if(rs.next()){
		            	JOptionPane.showMessageDialog(null, "Se ha cargado correctamente el usuario");
		            	//System.out.println("Se ha cargado correctamente el usuario");	
		            	usuario_principal = rs.getString("ID");
		            	textoID.setText(rs.getString("ID"));
		            	textoUsuario.setText(rs.getString("nombre"));
		            	textoScoreTotal.setText(rs.getString("score"));
		            	textoMas.setText(rs.getString("juego_mas"));
						cuadroID.setText("");
		            	botonPPT.setEnabled(true);
		            	botonGato.setEnabled(true);
		            	botonBM.setEnabled(true);
		            	botonCargar.setEnabled(false);
		            	botonNuevo.setEnabled(false);
		            	cuadroUsuario.setEnabled(false);
		            	cuadroID.setEnabled(false);
		            	botonContinuar2.setEnabled(false);
		            	botonRecargar.setEnabled(true);
		            } else {
		            	JOptionPane.showMessageDialog(null, "No se ha registrado ese usuario");
		                //System.out.println("No se ha registrado ese usuario");
		            }		 
		            
		        }catch(Exception e1){
		        	
		        }
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
		
		botonMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", loadConfig("name"), loadConfig("password"));
	            PreparedStatement pst = cn.prepareStatement("select * from usuario");
	            
	            ResultSet rs = pst.executeQuery();
	            int columnas = 0;
	            String texto1 = "";
	            
	            while(rs.next()){
	            	columnas++;
	            	texto1 += ("-----" + columnas + "----- \n" );
	            	texto1 +=("ID               \t    : "+ rs.getString("ID")+ "\n");		   
	            	texto1 +=("Nombre de usuario\t    : "+ rs.getString("nombre")+ "\n");
	            	texto1 +=("Score            \t    : "+ rs.getString("score")+ "\n");
	            	texto1 +=("juego mas jugado \t    : "+ rs.getString("juego_mas")+ "\n"+ "\n");
	            	// System.out.println(texto1);      
	            } 
	            JOptionPane.showMessageDialog(null, texto1);
	        }catch(Exception e1) {
	        	
			}
			}
		});
		
		botonRecargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", loadConfig("name"), loadConfig("password"));
		        PreparedStatement pst = cn1.prepareStatement("update usuario set juego_mas = ? where ID = " + usuario_principal);
		        PreparedStatement pst_gato = cn1.prepareStatement("select * from gato");
		        PreparedStatement pst_PPT = cn1.prepareStatement("select * from PPT");
		        PreparedStatement pst_buscaminas = cn1.prepareStatement("select * from buscaminas");
		        ResultSet rs_gato = pst_gato.executeQuery();
		        ResultSet rs_PPT = pst_PPT.executeQuery();
		        ResultSet rs_buscaminas = pst_buscaminas.executeQuery();

		        rs_gato.next(); // Mover el cursor al primer registro
		        int contador_gato = Integer.parseInt(rs_gato.getString("contador"));

		        rs_PPT.next(); // Mover el cursor al primer registro
		        int contador_PPT = Integer.parseInt(rs_PPT.getString("contador"));

		        rs_buscaminas.next(); // Mover el cursor al primer registro
		        int contador_buscaminas = Integer.parseInt(rs_buscaminas.getString("contador"));

		        if (contador_gato > contador_PPT && contador_gato > contador_buscaminas) {
		            pst.setString(1, "Gato");
		        } else if (contador_PPT > contador_gato && contador_PPT > contador_buscaminas) {
		            pst.setString(1, "PPT");
		        } else {
		            pst.setString(1, "Busca minas");
		        }

		        pst.executeUpdate();
		        textoMas.setText(cargarBD(loadConfig1("usuario1")+"", "juego_mas"));
		    } catch(Exception e1){
		        System.err.println("Error al actualizar el juego más jugado: " + e1.getMessage());
		    }
				
				try {
			        Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", loadConfig("name"), loadConfig("password"));
			        PreparedStatement pst = cn1.prepareStatement("update usuario set score = ? where ID = " + usuario_principal);
			        PreparedStatement pst_gato = cn1.prepareStatement("select * from gato");
			        PreparedStatement pst_PPT = cn1.prepareStatement("select * from PPT");
			        PreparedStatement pst_buscaminas = cn1.prepareStatement("select * from buscaminas");
			        ResultSet rs_gato = pst_gato.executeQuery();
			        ResultSet rs_PPT = pst_PPT.executeQuery();
			        ResultSet rs_buscaminas = pst_buscaminas.executeQuery();

			        rs_gato.next(); // Mover el cursor al primer registro
			        int contador_gato = Integer.parseInt(rs_gato.getString("score"));

			        rs_PPT.next(); // Mover el cursor al primer registro
			        int contador_PPT = Integer.parseInt(rs_PPT.getString("score"));

			        rs_buscaminas.next(); // Mover el cursor al primer registro
			        int contador_buscaminas = Integer.parseInt(rs_buscaminas.getString("score"));
			        int contador_total = contador_gato + contador_PPT + contador_buscaminas;
			        pst.setString(1, Integer.toString(contador_total));
			        pst.executeUpdate();
			        textoScoreTotal.setText(cargarBD(loadConfig1("usuario1")+"", "score"));
			    } catch(Exception e1) {
			    	
			    }
			}
		});
		
		
	}
    private JTextField cuadroID;
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
    
    public String loadConfig1(String property){
        try{
            configInput = new FileInputStream("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\src\\codes\\config.properties");
            config1.load(configInput);
            return config1.getProperty(property);
            //System.out.println(config1.getProperty("password"));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return "";
        }
    }

	void cerrar() {
		this.dispose();
	}
	
	public static void setPropertyValue(String property, String value){
        try{
            configOutput = new FileOutputStream("C:\\Users\\crisa\\workspace\\juegos\\juegos\\Pantalla\\src\\codes\\config.properties");
            config1.setProperty(property, value);
            config1.store(configOutput, null);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error guardando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
}
