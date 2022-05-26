package Ventanas;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import VentanasInfoVecinos.InfoBelen;
import VentanasInfoVecinos.InfoConcha;
import VentanasInfoVecinos.InfoEmilio;
import VentanasInfoVecinos.InfoHierbas;
import VentanasInfoVecinos.InfoMarisa;
import VentanasInfoVecinos.InfoVicenta;

public class VentanaInfoVecinos extends JPanel implements ActionListener{

	private JLabel lblFondo;
	private JLabel lblTitulo;
	private JLabel btnInfoConcha;
	private JLabel btnInfoVicenta;
	private JLabel btnInfoMarisa;
	private JLabel btnInfoBelen;
	private JLabel btnInfoHierbas;
	private JLabel btnInfoEmilio;

	private JButton btnFalso1;
	private JButton btnFalso2;
	private JButton btnFalso3;
	private JButton btnFalso4;
	private JButton btnFalso5;
	private JButton btnFalso6;

	private JButton btnAtras;



	public VentanaInfoVecinos(){
		setLayout(null);

		//Boton para salir a la ventana anterior
		Image atras = new ImageIcon("src/Medios/Botones/botonAtras.png").getImage();
		ImageIcon atras2 = new ImageIcon(atras.getScaledInstance(100, 40, Image.SCALE_SMOOTH));
		btnAtras = new JButton();
		btnAtras.setBounds(10, 700, 100, 40);
		btnAtras.setIcon(atras2);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		btnAtras.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnAtras);

		//Boton falso para poder clicar en la imagen adecuadamente
		Image primerFalso = new ImageIcon("src/Medios/Botones/BotonFalso.png").getImage();
		ImageIcon primerFalso2 = new ImageIcon(primerFalso.getScaledInstance(200, 210, Image.SCALE_SMOOTH));
		btnFalso1 = new JButton();
		btnFalso1.setBounds(250, 30, 200, 210);
		btnFalso1.setIcon(primerFalso2);
		btnFalso1.setOpaque(false);
		btnFalso1.setContentAreaFilled(false);
		btnFalso1.setBorderPainted(false);
		btnFalso1.addActionListener(this);
		btnFalso1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnFalso1);

		//Boton falso para poder clicar en la imagen adecuadamente
		Image segundoFalso = new ImageIcon("src/Medios/Botones/BotonFalso.png").getImage();
		ImageIcon segundoFalso2 = new ImageIcon(segundoFalso.getScaledInstance(200, 210, Image.SCALE_SMOOTH));
		btnFalso2 = new JButton();
		btnFalso2.setBounds(250, 285, 200, 210);
		btnFalso2.setIcon(segundoFalso2);
		btnFalso2.setOpaque(false);
		btnFalso2.setContentAreaFilled(false);
		btnFalso2.setBorderPainted(false);
		btnFalso2.addActionListener(this);
		btnFalso2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnFalso2);

		//Boton falso para poder clicar en la imagen adecuadamente
		Image terceroFalso = new ImageIcon("src/Medios/Botones/BotonFalso.png").getImage();
		ImageIcon terceroFalso2 = new ImageIcon(terceroFalso.getScaledInstance(200, 210, Image.SCALE_SMOOTH));
		btnFalso3 = new JButton();
		btnFalso3.setBounds(250, 540, 200, 210);
		btnFalso3.setIcon(terceroFalso2);
		btnFalso3.setOpaque(false);
		btnFalso3.setContentAreaFilled(false);
		btnFalso3.setBorderPainted(false);
		btnFalso3.addActionListener(this);
		btnFalso3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnFalso3);

		//Boton falso para poder clicar en la imagen adecuadamente
		Image cuartoFalso = new ImageIcon("src/Medios/Botones/BotonFalso.png").getImage();
		ImageIcon cuartoFalso2 = new ImageIcon(cuartoFalso.getScaledInstance(200, 210, Image.SCALE_SMOOTH));
		btnFalso4 = new JButton();
		btnFalso4.setBounds(665, 30, 200, 210);
		btnFalso4.setIcon(cuartoFalso2);
		btnFalso4.setOpaque(false);
		btnFalso4.setContentAreaFilled(false);
		btnFalso4.setBorderPainted(false);
		btnFalso4.addActionListener(this);
		btnFalso4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnFalso4);

		//Boton falso para poder clicar en la imagen adecuadamente
		Image quintoFalso = new ImageIcon("src/Medios/Botones/BotonFalso.png").getImage();
		ImageIcon quintoFalso2 = new ImageIcon(quintoFalso.getScaledInstance(200, 210, Image.SCALE_SMOOTH));
		btnFalso5 = new JButton();
		btnFalso5.setBounds(665, 285, 200, 210);
		btnFalso5.setIcon(quintoFalso2);
		btnFalso5.setOpaque(false);
		btnFalso5.setContentAreaFilled(false);
		btnFalso5.setBorderPainted(false);
		btnFalso5.addActionListener(this);
		btnFalso5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnFalso5);

		//Boton falso para poder clicar en la imagen adecuadamente
		Image sextoFalso = new ImageIcon("src/Medios/Botones/BotonFalso.png").getImage();
		ImageIcon sextoFalso2 = new ImageIcon(sextoFalso.getScaledInstance(200, 210, Image.SCALE_SMOOTH));
		btnFalso6 = new JButton();
		btnFalso6.setBounds(665, 540, 200, 210);
		btnFalso6.setIcon(sextoFalso2);
		btnFalso6.setOpaque(false);
		btnFalso6.setContentAreaFilled(false);
		btnFalso6.setBorderPainted(false);
		btnFalso6.addActionListener(this);
		btnFalso6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnFalso6);

		Image infoConcha = new ImageIcon("src\\Medios\\Concha(rojo)\\IconoConcha.png").getImage();
		ImageIcon infoConcha2 = new ImageIcon(infoConcha.getScaledInstance(300,450, Image.SCALE_SMOOTH));
		btnInfoConcha = new JLabel();
		btnInfoConcha.setBounds(200, -80, 300, 450 );
		btnInfoConcha.setIcon(infoConcha2);
		btnInfoConcha.setOpaque(false);
		add(btnInfoConcha);

		Image infoVicenta = new ImageIcon("src\\Medios\\Vicenta(verde)\\IconoVicenta.png").getImage();
		ImageIcon infoVicenta2 = new ImageIcon(infoVicenta.getScaledInstance(300,450, Image.SCALE_SMOOTH));
		btnInfoVicenta = new JLabel();
		btnInfoVicenta.setBounds(200, 200, 300, 450 );
		btnInfoVicenta.setIcon(infoVicenta2);
		btnInfoVicenta.setOpaque(false);
		add(btnInfoVicenta);

		Image infoMarisa = new ImageIcon("src\\Medios\\Marisa(azul)\\IconoMarisa.png").getImage();
		ImageIcon infoMarisa2 = new ImageIcon(infoMarisa.getScaledInstance(235, 310, Image.SCALE_SMOOTH));
		btnInfoMarisa = new JLabel();
		btnInfoMarisa.setBounds(230, 500, 235, 310);
		btnInfoMarisa.setIcon(infoMarisa2);
		btnInfoMarisa.setOpaque(false);
		add(btnInfoMarisa);

		Image infoBelen = new ImageIcon("src\\Medios\\Belen(normal)\\IconoBelen.png").getImage();
		ImageIcon infoBelen2 = new ImageIcon(infoBelen.getScaledInstance(410, 250, Image.SCALE_SMOOTH));
		btnInfoBelen = new JLabel();
		btnInfoBelen.setBounds(560, 10, 410, 250);
		btnInfoBelen.setIcon(infoBelen2);
		btnInfoBelen.setOpaque(false);
		add(btnInfoBelen);

		Image infoHierbas = new ImageIcon("src\\Medios\\LaHierbas(enano)\\IconoHierbas.png").getImage();
		ImageIcon infoHierbas2 = new ImageIcon(infoHierbas.getScaledInstance(230, 340, Image.SCALE_SMOOTH));
		btnInfoHierbas = new JLabel();
		btnInfoHierbas.setBounds(650, 210, 230, 340);
		btnInfoHierbas.setIcon(infoHierbas2);
		btnInfoHierbas.setOpaque(false);
		add(btnInfoHierbas);

		Image infoEmilio = new ImageIcon("src\\Medios\\Emilio(Gigante)\\IconoEmilio.png").getImage();
		ImageIcon infoEmilio2 = new ImageIcon(infoEmilio.getScaledInstance(475, 340, Image.SCALE_SMOOTH));
		btnInfoEmilio = new JLabel();
		btnInfoEmilio.setBounds(520, 485, 475, 340);
		btnInfoEmilio.setIcon(infoEmilio2);
		btnInfoEmilio.setOpaque(false);
		add(btnInfoEmilio);

		//Titulo para el usuario, para saber en que ventana está
		Image titulo = new ImageIcon("src/Medios/Titulo/TituloInfoVecinos.png").getImage();
		ImageIcon titulo2 = new ImageIcon(titulo.getScaledInstance(330, 280, Image.SCALE_SMOOTH));
		lblTitulo = new JLabel();
		lblTitulo.setBounds(385, 110, 330, 280);
		lblTitulo.setIcon(titulo2);
		lblTitulo.setOpaque(false);
		add(lblTitulo);

		//imagen establecida para el fondo
		Image fondo = new ImageIcon("src/Medios/Fondos/FondoInfoVecinos.jpg").getImage();
		ImageIcon fondo2 = new ImageIcon(fondo.getScaledInstance(1200,760, Image.SCALE_SMOOTH));
		lblFondo = new JLabel();
		lblFondo.setBounds(-105, -18, 1200, 800 );
		lblFondo.setIcon(fondo2);
		lblFondo.setOpaque(false);
		add(lblFondo);	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//boton para ir atras
		if(e.getSource().equals(btnAtras)) {
			JFrame VentanaInfoVecinos = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInfoVecinos.remove(this);
			VentanaInfoVecinos.getContentPane().add(new VentanaCreacionEquipos());
			VentanaInfoVecinos.setVisible(true);
		}

		else if(e.getSource().equals(btnFalso1)) {
			JFrame VentanaInfoVecinos = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInfoVecinos.remove(this);
			VentanaInfoVecinos.getContentPane().add(new InfoConcha());
			VentanaInfoVecinos.setVisible(true);

			//This gets the path to the project, but not into /src for eclipse
			String path = new File("src\\Medios\\Audios\\ConchaElegida16.wav").getAbsolutePath();
			//Make a File object with a path to the audio file.
			File sound = new File(path);

			try {
				AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
				Clip c = AudioSystem.getClip();
				c.open(ais); //Clip opens AudioInputStream
				c.start(); //Start playing audio


			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}

		else if(e.getSource().equals(btnFalso2)) {
			JFrame VentanaInfoVecinos = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInfoVecinos.remove(this);
			VentanaInfoVecinos.getContentPane().add(new InfoVicenta());
			VentanaInfoVecinos.setVisible(true);

			//This gets the path to the project, but not into /src for eclipse
			String path = new File("src\\Medios\\Audios\\VicentaElegida.wav").getAbsolutePath();
			//Make a File object with a path to the audio file.
			File sound = new File(path);

			try {
				AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
				Clip c = AudioSystem.getClip();
				c.open(ais); //Clip opens AudioInputStream
				c.start(); //Start playing audio


			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
		else if(e.getSource().equals(btnFalso3)) {
			JFrame VentanaInfoVecinos = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInfoVecinos.remove(this);
			VentanaInfoVecinos.getContentPane().add(new InfoMarisa());
			VentanaInfoVecinos.setVisible(true);

			//This gets the path to the project, but not into /src for eclipse
			String path = new File("src\\Medios\\Audios\\MarisaElegida.wav").getAbsolutePath();
			//Make a File object with a path to the audio file.
			File sound = new File(path);

			try {
				AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
				Clip c = AudioSystem.getClip();
				c.open(ais); //Clip opens AudioInputStream
				c.start(); //Start playing audio


			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
		else if(e.getSource().equals(btnFalso4)) {
			JFrame VentanaInfoVecinos = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInfoVecinos.remove(this);
			VentanaInfoVecinos.getContentPane().add(new InfoBelen());
			VentanaInfoVecinos.setVisible(true);

			//This gets the path to the project, but not into /src for eclipse
			String path = new File("src\\Medios\\Audios\\BelenElegida.wav").getAbsolutePath();
			//Make a File object with a path to the audio file.
			File sound = new File(path);

			try {
				AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
				Clip c = AudioSystem.getClip();
				c.open(ais); //Clip opens AudioInputStream
				c.start(); //Start playing audio


			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
		else if(e.getSource().equals(btnFalso5)) {
			JFrame VentanaInfoVecinos = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInfoVecinos.remove(this);
			VentanaInfoVecinos.getContentPane().add(new InfoHierbas());
			VentanaInfoVecinos.setVisible(true);

			//This gets the path to the project, but not into /src for eclipse
			String path = new File("src\\Medios\\Audios\\HierbasElegida.wav").getAbsolutePath();
			//Make a File object with a path to the audio file.
			File sound = new File(path);

			try {
				AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
				Clip c = AudioSystem.getClip();
				c.open(ais); //Clip opens AudioInputStream
				c.start(); //Start playing audio


			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
		else if(e.getSource().equals(btnFalso6)) {
			JFrame VentanaInfoVecinos = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInfoVecinos.remove(this);
			VentanaInfoVecinos.getContentPane().add(new InfoEmilio());
			VentanaInfoVecinos.setVisible(true);

			//This gets the path to the project, but not into /src for eclipse
			String path = new File("src\\Medios\\Audios\\EmilioElegido.wav").getAbsolutePath();
			//Make a File object with a path to the audio file.
			File sound = new File(path);

			try {
				AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
				Clip c = AudioSystem.getClip();
				c.open(ais); //Clip opens AudioInputStream
				c.start(); //Start playing audio


			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
}
