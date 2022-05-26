package Ventanas;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class VentanaInicio extends JPanel implements ActionListener {

	private JLabel lbltitulo;
	private JButton btnJugar;
	private JButton btnReglas;
	private JButton btnInfo;
	private JButton btnResultados;
	private JButton btnSalir;
	private JLabel lblFondo;
	static int contMusica = 0;
	static boolean musicaPrincipal = true;

	static AudioInputStream musicaInicio;

	static AudioInputStream audioTheme;
	static Clip clipTheme;

	public VentanaInicio(){
		setLayout(null);

		if(musicaPrincipal) {
			ReproducirMusica("src\\Medios\\Audios\\CancionFondo16.wav");
			musicaPrincipal = false;	
		}


		btnJugar = new JButton();
		btnJugar.setBounds(430, 200, 250, 100 );
		btnJugar.setIcon(new ImageIcon("src/Medios/Botones/jugar.png"));
		btnJugar.setOpaque(false);
		btnJugar.setContentAreaFilled(false);
		btnJugar.setBorderPainted(false);
		btnJugar.addActionListener(this);
		btnJugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnJugar);


		btnReglas = new JButton();
		btnReglas.setBounds(430, 305, 250, 100 );
		btnReglas.setIcon(new ImageIcon("src/Medios/Botones/reglas.png"));
		btnReglas.setOpaque(false);
		btnReglas.setContentAreaFilled(false);
		btnReglas.setBorderPainted(false);
		btnReglas.addActionListener(this);
		btnReglas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnReglas);

		btnInfo = new JButton();
		btnInfo.setBounds(430, 413, 250, 100 );
		btnInfo.setIcon(new ImageIcon("src/Medios/Botones/informacion.png"));
		btnInfo.setOpaque(false);
		btnInfo.setContentAreaFilled(false);
		btnInfo.setBorderPainted(false);
		btnInfo.addActionListener(this);
		btnInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnInfo);

		btnResultados = new JButton();
		btnResultados.setBounds(430, 528, 250, 100 );
		btnResultados.setIcon(new ImageIcon("src/Medios/Botones/resultados.png"));
		btnResultados.setOpaque(false);
		btnResultados.setContentAreaFilled(false);
		btnResultados.setBorderPainted(false);
		btnResultados.addActionListener(this);
		btnResultados.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnResultados);


		Image salir = new ImageIcon("src/Medios/Botones/salir.png").getImage();
		ImageIcon salir2 = new ImageIcon(salir.getScaledInstance(100,40, Image.SCALE_SMOOTH));		
		btnSalir = new JButton();
		btnSalir.setBounds(10, 700, 100, 40 );
		btnSalir.setIcon(salir2);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.addActionListener(this);
		btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnSalir);	


		Image titulo = new ImageIcon("src/Medios/Titulo/titulo.png").getImage();
		ImageIcon titulo2 = new ImageIcon(titulo.getScaledInstance(420,190, Image.SCALE_SMOOTH));
		lbltitulo = new JLabel();
		lbltitulo.setBounds(345, -325, 1100, 800);
		lbltitulo.setIcon(titulo2);
		lbltitulo.setOpaque(false);
		add(lbltitulo);

		Image fondo = new ImageIcon("src/Medios/Fondos/fondoinicio.png").getImage();
		ImageIcon fondo2 = new ImageIcon(fondo.getScaledInstance(1100,800, Image.SCALE_SMOOTH));		
		lblFondo = new JLabel();
		lblFondo.setBounds(0, 0, 1100, 800 );
		lblFondo.setIcon(fondo2);
		lblFondo.setOpaque(false);	
		add(lblFondo);	

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(btnJugar)) {
			this.clipTheme.stop();
			JFrame VentanaInicio = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInicio.remove(this);
			VentanaInicio.getContentPane().add(new VentanaCreacionEquipos());
			VentanaInicio.setVisible(true);		

		}	
		else if(e.getSource().equals(btnReglas)) {
			JFrame VentanaInicio = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInicio.remove(this);
			VentanaInicio.getContentPane().add(new VentanaReglas());
			VentanaInicio.setVisible(true);

		}	
		else if(e.getSource().equals(btnInfo)) {
			JFrame VentanaInicio = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInicio.remove(this);
			VentanaInicio.getContentPane().add(new VentanaInfo());
			VentanaInicio.setVisible(true);

		}
		else if(e.getSource().equals(btnResultados)) {
			JFrame VentanaInicio = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInicio.remove(this);
			VentanaInicio.getContentPane().add(new VentanaResultados());
			VentanaInicio.setVisible(true);	

		}
		else if(e.getSource().equals(btnSalir)) {
			JFrame VentanaInicio = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInicio.remove(this);
			VentanaInicio.setVisible(false);
		}	


	}

	
	public static void ReproducirMusica(String nombreSonido){
		try {
			audioTheme = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
			clipTheme = AudioSystem.getClip();
			clipTheme.open(audioTheme);
			clipTheme.start();
		} catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error al reproducir el sonido.");
		}
	}
}

