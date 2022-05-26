package Ventanas;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Principal.Vecino;
import TiposPlanetas.Belen;
import TiposPlanetas.Concha;
import TiposPlanetas.Emilio;
import TiposPlanetas.Hierbas;
import TiposPlanetas.Marisa;
import TiposPlanetas.Vicenta;

import javax.swing.JFrame;

public class VentanaCreacionEquipos extends JPanel implements ActionListener{

	private JLabel lbltitulo;
	private JButton btnEmpezar;
	private JButton btnSumarJugador;
	private JButton btnInfoVecinos;
	private JLabel lblFondo;
	private JButton btnAtras;

	private JLabel jugador1;
	private JLabel jugador2;
	private JLabel jugador3;
	private JLabel jugador4;
	private JLabel jugador5;
	private JLabel jugador6;

	private JTextField nombre1;
	private JTextField nombre2;
	private JTextField nombre3;
	private JTextField nombre4;
	private JTextField nombre5;
	private JTextField nombre6;

	static JComboBox<String> escogerJugador1;
	static JComboBox<String> escogerJugador2;
	static JComboBox<String> escogerJugador3;
	static JComboBox<String> escogerJugador4;
	static JComboBox<String> escogerJugador5;
	static JComboBox<String> escogerJugador6;

	private JButton btnAleatorio1;
	private JButton btnAleatorio2;
	private JButton btnAleatorio3;
	private JButton btnAleatorio4;
	private JButton btnAleatorio5;
	private JButton btnAleatorio6;

	private JLabel noSeleccionado1;
	private JLabel noSeleccionado2;
	private JLabel noSeleccionado3;
	private JLabel noSeleccionado4;
	private JLabel noSeleccionado5;
	private JLabel noSeleccionado6;
	
	private int contMaximo = 0;

	static ArrayList<Vecino> vecinos;
	static int [] copiavecinos;
	
	static String [] nombreVecinos;
	
	static String [] tipoVecinos;

	static ArrayList<String> nombres =  new ArrayList<String>();
	static ArrayList<String> tipos =  new ArrayList<String>();



	public VentanaCreacionEquipos() {
		setLayout(null);

		vecinos = new ArrayList<Vecino>();

		//Boton para empezar la partida
		Image empezar = new ImageIcon("src/Medios/Botones/BotonEmpezar.png").getImage();
		ImageIcon empezar2 = new ImageIcon(empezar.getScaledInstance(280,130, Image.SCALE_SMOOTH));
		btnEmpezar = new JButton();
		btnEmpezar.setBounds(160, 360, 280, 130 );
		btnEmpezar.setIcon(empezar2);
		btnEmpezar.setOpaque(false);
		btnEmpezar.setContentAreaFilled(false);
		btnEmpezar.setBorderPainted(false);
		btnEmpezar.addActionListener(this);
		btnEmpezar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnEmpezar);


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

		//Boton para poder añadir mas equipos (hasta 6)
		Image equipos = new ImageIcon("src/Medios/Botones/SumarEquipo.png").getImage();
		ImageIcon equipos2 = new ImageIcon(equipos.getScaledInstance(150,75, Image.SCALE_SMOOTH));
		btnSumarJugador = new JButton();
		btnSumarJugador.setBounds(222, 260, 150, 75 );
		btnSumarJugador.setIcon(equipos2);
		btnSumarJugador.setOpaque(false);
		btnSumarJugador.setContentAreaFilled(false);
		btnSumarJugador.setBorderPainted(false);
		btnSumarJugador.addActionListener(this);
		btnSumarJugador.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnSumarJugador);

		//Botón que nos llevara a un apartado donde nos dice las caracteristicas de cada vecino
		Image info = new ImageIcon("src/Medios/Botones/InfoVecinos.png").getImage();
		ImageIcon info2 = new ImageIcon(info.getScaledInstance(80,35, Image.SCALE_SMOOTH));
		btnInfoVecinos = new JButton();
		btnInfoVecinos.setBounds(810, 22, 80, 35 );
		btnInfoVecinos.setIcon(info2);
		btnInfoVecinos.setOpaque(false);
		btnInfoVecinos.setContentAreaFilled(false);
		btnInfoVecinos.setBorderPainted(false);
		btnInfoVecinos.addActionListener(this);
		btnInfoVecinos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnInfoVecinos);

		//Boton que nos permite escoger un personaje al azar
		Image aleatorioJugadorUno = new ImageIcon("src/Medios/Botones/aleatorio.png").getImage();
		ImageIcon aleatorioJugadorUno2 = new ImageIcon(aleatorioJugadorUno.getScaledInstance(50,50, Image.SCALE_SMOOTH));
		btnAleatorio1 = new JButton();
		btnAleatorio1.setBounds(910, 98, 50, 50 );
		btnAleatorio1.setIcon(aleatorioJugadorUno2);
		btnAleatorio1.setOpaque(false);
		btnAleatorio1.setContentAreaFilled(false);
		btnAleatorio1.setBorderPainted(false);
		btnAleatorio1.addActionListener(this);
		btnAleatorio1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnAleatorio1);

		//Nombre del equipo 
		nombre1 = new JTextField();
		nombre1.setBounds(806, 98, 92, 20);
		add(nombre1);



		//desplegable para seleccionar el personaje
		escogerJugador1 = new JComboBox<String>();
		escogerJugador1.setBounds(807, 123, 90, 20 );
		escogerJugador1.addItem("Seleccione");
		escogerJugador1.addItem("Concha");
		escogerJugador1.addItem("Vicenta");
		escogerJugador1.addItem("Marisa");
		escogerJugador1.addItem("Belén");
		escogerJugador1.addItem("La Hierbas");
		escogerJugador1.addItem("Emilio");
		add(escogerJugador1);
		

		//Imagen que pone "Jugador 1"
		Image PrimerJugador = new ImageIcon("src\\Medios\\Jugadores\\jugador1.png").getImage();
		ImageIcon PrimerJugador2 = new ImageIcon(PrimerJugador.getScaledInstance(220,160, Image.SCALE_SMOOTH));
		jugador1 = new JLabel();
		jugador1.setBounds(630, 72, 220, 160);
		jugador1.setIcon(PrimerJugador2);
		jugador1.setOpaque(false);
		add(jugador1);	

		//marco para cuando no tenga seleccionado aun un personaje
		Image sinSeleccionPrimero = new ImageIcon("src\\Medios\\Jugadores\\NoSeleccionado.png").getImage();
		ImageIcon sinSeleccionPrimero2 = new ImageIcon(sinSeleccionPrimero.getScaledInstance(85, 85, Image.SCALE_SMOOTH));
		noSeleccionado1 = new JLabel();
		noSeleccionado1.setBounds(965, 73, 85, 85);
		noSeleccionado1.setIcon(sinSeleccionPrimero2);
		noSeleccionado1.setOpaque(false);
		add(noSeleccionado1);

		//dependiendo del personaje que se escoja se establece una imagen u otra
		escogerJugador1.addActionListener(new ActionListener() {//LEE A TIEMPO REAL EL JCOMBOBOX Y CAMBIA LA IMAGEN DEFAULT POR LA DEL VECINO SELECCIONADO
			public void actionPerformed(ActionEvent e) {
				if (escogerJugador1.getSelectedItem().equals("Seleccione")) {
					noSeleccionado1.setIcon(sinSeleccionPrimero2);
					noSeleccionado1.setBounds(965, 73, 85, 85);
				}
				if (escogerJugador1.getSelectedItem().equals("Concha")) {
					Image conchaPrimero = new ImageIcon("src\\Medios\\Concha(rojo)\\IconoConcha.png").getImage();
					ImageIcon conchaPrimero2 = new ImageIcon(conchaPrimero.getScaledInstance(100, 152, Image.SCALE_SMOOTH));
					noSeleccionado1.setBounds(958, 44, 100, 152);
					noSeleccionado1.setIcon(conchaPrimero2);

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
				if (escogerJugador1.getSelectedItem().equals("Vicenta")) {
					Image vicentaPrimero = new ImageIcon("src\\Medios\\Vicenta(verde)\\IconoVicenta.png").getImage();
					ImageIcon vicentaPrimero2 = new ImageIcon(vicentaPrimero.getScaledInstance(100, 152, Image.SCALE_SMOOTH));
					noSeleccionado1.setBounds(958, 51, 100, 152);
					noSeleccionado1.setIcon(vicentaPrimero2);

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
				if (escogerJugador1.getSelectedItem().equals("Marisa")) {
					Image marisaPrimero = new ImageIcon("src\\Medios\\Marisa(azul)\\IconoMarisa.png").getImage();
					ImageIcon marisaPrimero2 = new ImageIcon(marisaPrimero.getScaledInstance(78, 107, Image.SCALE_SMOOTH));
					noSeleccionado1.setBounds(969, 64, 78, 107);
					noSeleccionado1.setIcon(marisaPrimero2);

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
				if (escogerJugador1.getSelectedItem().equals("Belén")) {
					Image belenPrimero = new ImageIcon("src\\Medios\\Belen(normal)\\IconoBelen.png").getImage();
					ImageIcon belenPrimero2 = new ImageIcon(belenPrimero.getScaledInstance(140, 85, Image.SCALE_SMOOTH));
					noSeleccionado1.setBounds(936, 72, 140, 85);
					noSeleccionado1.setIcon(belenPrimero2);

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

				if (escogerJugador1.getSelectedItem().equals("La Hierbas")) {
					Image laHierbasPrimero = new ImageIcon("src\\Medios\\LaHierbas(enano)\\IconoHierbas.png").getImage();
					ImageIcon laHierbasPrimero2 = new ImageIcon(laHierbasPrimero.getScaledInstance(72, 110, Image.SCALE_SMOOTH));
					noSeleccionado1.setBounds(971, 59, 72, 110);
					noSeleccionado1.setIcon(laHierbasPrimero2);

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
				if (escogerJugador1.getSelectedItem().equals("Emilio")) {
					Image emilioPrimero = new ImageIcon("src\\Medios\\Emilio(Gigante)\\IconoEmilio.png").getImage();
					ImageIcon emilioPrimero2 = new ImageIcon(emilioPrimero.getScaledInstance(150, 115, Image.SCALE_SMOOTH));
					noSeleccionado1.setBounds(930, 62, 150, 115);
					noSeleccionado1.setIcon(emilioPrimero2);

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
		});

		Image aleatorioJugadorDos = new ImageIcon("src/Medios/Botones/aleatorio.png").getImage();
		ImageIcon aleatorioJugadorDos2 = new ImageIcon(aleatorioJugadorDos.getScaledInstance(50,50, Image.SCALE_SMOOTH));
		btnAleatorio2 = new JButton();
		btnAleatorio2.setBounds(910, 200, 50, 50 );
		btnAleatorio2.setIcon(aleatorioJugadorDos2);
		btnAleatorio2.setOpaque(false);
		btnAleatorio2.setContentAreaFilled(false);
		btnAleatorio2.setBorderPainted(false);
		btnAleatorio2.addActionListener(this);
		btnAleatorio2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnAleatorio2);

		nombre2 = new JTextField();
		nombre2.setBounds(806, 200, 92, 20);
		add(nombre2);

		escogerJugador2 = new JComboBox<String>();
		escogerJugador2.setBounds(807, 225, 90, 20 );
		escogerJugador2.addItem("Seleccione");
		escogerJugador2.addItem("Concha");
		escogerJugador2.addItem("Vicenta");
		escogerJugador2.addItem("Marisa");
		escogerJugador2.addItem("Belén");
		escogerJugador2.addItem("La Hierbas");
		escogerJugador2.addItem("Emilio");
		add(escogerJugador2);
		

		Image SegundoJugador = new ImageIcon("src\\Medios\\Jugadores\\jugador2.png").getImage();
		ImageIcon SegundoJugador2 = new ImageIcon(SegundoJugador.getScaledInstance(220,160, Image.SCALE_SMOOTH));
		jugador2 = new JLabel();
		jugador2.setBounds(640, 196, 220,160);
		jugador2.setIcon(SegundoJugador2);
		jugador2.setOpaque(false);
		add(jugador2);	

		Image sinSeleccionSegundo = new ImageIcon("src\\Medios\\Jugadores\\NoSeleccionado.png").getImage();
		ImageIcon sinSeleccionSegundo2 = new ImageIcon(sinSeleccionSegundo.getScaledInstance(85, 85, Image.SCALE_SMOOTH));
		noSeleccionado2 = new JLabel();
		noSeleccionado2.setBounds(965, 175, 85, 85);
		noSeleccionado2.setIcon(sinSeleccionSegundo2);
		noSeleccionado2.setOpaque(false);
		add(noSeleccionado2);

		escogerJugador2.addActionListener(new ActionListener() {//LEE A TIEMPO REAL EL JCOMBOBOX Y CAMBIA LA IMAGEN DEFAULT POR LA DEL VECINO SELECCIONADO
			public void actionPerformed(ActionEvent e) {
				if (escogerJugador2.getSelectedItem().equals("Seleccione")) {
					noSeleccionado2.setIcon(sinSeleccionPrimero2);
					noSeleccionado2.setBounds(965, 175, 85, 85);
				}
				if (escogerJugador2.getSelectedItem().equals("Concha")) {
					Image conchaPrimero = new ImageIcon("src\\Medios\\Concha(rojo)\\IconoConcha.png").getImage();
					ImageIcon conchaPrimero2 = new ImageIcon(conchaPrimero.getScaledInstance(100, 152, Image.SCALE_SMOOTH));
					noSeleccionado2.setBounds(959, 146, 100, 152);
					noSeleccionado2.setIcon(conchaPrimero2);

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
				if (escogerJugador2.getSelectedItem().equals("Vicenta")) {
					Image vicentaPrimero = new ImageIcon("src\\Medios\\Vicenta(verde)\\IconoVicenta.png").getImage();
					ImageIcon vicentaPrimero2 = new ImageIcon(vicentaPrimero.getScaledInstance(100, 152, Image.SCALE_SMOOTH));
					noSeleccionado2.setBounds(958, 152, 100, 152);
					noSeleccionado2.setIcon(vicentaPrimero2);

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
				if (escogerJugador2.getSelectedItem().equals("Marisa")) {
					Image marisaPrimero = new ImageIcon("src\\Medios\\Marisa(azul)\\IconoMarisa.png").getImage();
					ImageIcon marisaPrimero2 = new ImageIcon(marisaPrimero.getScaledInstance(78, 107, Image.SCALE_SMOOTH));
					noSeleccionado2.setBounds(969, 164, 78, 107);
					noSeleccionado2.setIcon(marisaPrimero2);
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
				if (escogerJugador2.getSelectedItem().equals("Belén")) {
					Image belenPrimero = new ImageIcon("src\\Medios\\Belen(normal)\\IconoBelen.png").getImage();
					ImageIcon belenPrimero2 = new ImageIcon(belenPrimero.getScaledInstance(140, 85, Image.SCALE_SMOOTH));
					noSeleccionado2.setBounds(936, 174, 140, 85);
					noSeleccionado2.setIcon(belenPrimero2);

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
				if (escogerJugador2.getSelectedItem().equals("La Hierbas")) {
					Image laHierbasPrimero = new ImageIcon("src\\Medios\\LaHierbas(enano)\\IconoHierbas.png").getImage();
					ImageIcon laHierbasPrimero2 = new ImageIcon(laHierbasPrimero.getScaledInstance(72, 110, Image.SCALE_SMOOTH));
					noSeleccionado2.setBounds(971, 161, 72, 110);
					noSeleccionado2.setIcon(laHierbasPrimero2);

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
				if (escogerJugador2.getSelectedItem().equals("Emilio")) {
					Image emilioPrimero = new ImageIcon("src\\Medios\\Emilio(Gigante)\\IconoEmilio.png").getImage();
					ImageIcon emilioPrimero2 = new ImageIcon(emilioPrimero.getScaledInstance(150, 115, Image.SCALE_SMOOTH));
					noSeleccionado2.setBounds(930, 164, 150, 115);
					noSeleccionado2.setIcon(emilioPrimero2);

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
		});

		Image aleatorioJugadorTres = new ImageIcon("src/Medios/Botones/aleatorio.png").getImage();
		ImageIcon aleatorioJugadorTres2 = new ImageIcon(aleatorioJugadorTres.getScaledInstance(50,50, Image.SCALE_SMOOTH));
		btnAleatorio3 = new JButton();
		btnAleatorio3.setBounds(910, 306, 50, 50 );
		btnAleatorio3.setIcon(aleatorioJugadorTres2);
		btnAleatorio3.setOpaque(false);
		btnAleatorio3.setContentAreaFilled(false);
		btnAleatorio3.setBorderPainted(false);
		btnAleatorio3.addActionListener(this);
		btnAleatorio3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnAleatorio3);

		nombre3 = new JTextField();
		nombre3.setBounds(806, 306, 92, 20 );
		add(nombre3);


		escogerJugador3 = new JComboBox<String>();
		escogerJugador3.setBounds(807, 331, 90, 20 );
		escogerJugador3.addItem("Seleccione");
		escogerJugador3.addItem("Concha");
		escogerJugador3.addItem("Vicenta");
		escogerJugador3.addItem("Marisa");
		escogerJugador3.addItem("Belén");
		escogerJugador3.addItem("La Hierbas");
		escogerJugador3.addItem("Emilio");
		add(escogerJugador3);

		Image TercerJugador = new ImageIcon("src\\Medios\\Jugadores\\jugador3.png").getImage();
		ImageIcon TercerJugador2 = new ImageIcon(TercerJugador.getScaledInstance(220,160, Image.SCALE_SMOOTH));
		jugador3 = new JLabel();
		jugador3.setBounds(640, 300, 220,160);
		jugador3.setIcon(TercerJugador2);
		jugador3.setOpaque(false);
		add(jugador3);	

		Image sinSeleccionTercero = new ImageIcon("src\\Medios\\Jugadores\\NoSeleccionado.png").getImage();
		ImageIcon sinSeleccionTercero2 = new ImageIcon(sinSeleccionTercero.getScaledInstance(85, 85, Image.SCALE_SMOOTH));
		noSeleccionado3 = new JLabel();
		noSeleccionado3.setBounds(965, 278, 85, 85);
		noSeleccionado3.setIcon(sinSeleccionTercero2);
		noSeleccionado3.setOpaque(false);
		add(noSeleccionado3);

		escogerJugador3.addActionListener(new ActionListener() {//LEE A TIEMPO REAL EL JCOMBOBOX Y CAMBIA LA IMAGEN DEFAULT POR LA DEL VECINO SELECCIONADO
			public void actionPerformed(ActionEvent e) {
				if (escogerJugador3.getSelectedItem().equals("Seleccione")) {
					noSeleccionado3.setIcon(sinSeleccionPrimero2);
					noSeleccionado3.setBounds(965, 278, 85, 85);
				}
				if (escogerJugador3.getSelectedItem().equals("Concha")) {
					Image conchaPrimero = new ImageIcon("src\\Medios\\Concha(rojo)\\IconoConcha.png").getImage();
					ImageIcon conchaPrimero2 = new ImageIcon(conchaPrimero.getScaledInstance(100, 152, Image.SCALE_SMOOTH));
					noSeleccionado3.setBounds(959, 248, 100, 152);
					noSeleccionado3.setIcon(conchaPrimero2);
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
				if (escogerJugador3.getSelectedItem().equals("Vicenta")) {
					Image vicentaPrimero = new ImageIcon("src\\Medios\\Vicenta(verde)\\IconoVicenta.png").getImage();
					ImageIcon vicentaPrimero2 = new ImageIcon(vicentaPrimero.getScaledInstance(100, 152, Image.SCALE_SMOOTH));
					noSeleccionado3.setBounds(958, 256, 100, 152);
					noSeleccionado3.setIcon(vicentaPrimero2);
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
				if (escogerJugador3.getSelectedItem().equals("Marisa")) {
					Image marisaPrimero = new ImageIcon("src\\Medios\\Marisa(azul)\\IconoMarisa.png").getImage();
					ImageIcon marisaPrimero2 = new ImageIcon(marisaPrimero.getScaledInstance(78, 107, Image.SCALE_SMOOTH));
					noSeleccionado3.setBounds(969, 268, 78, 107);
					noSeleccionado3.setIcon(marisaPrimero2);

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
				if (escogerJugador3.getSelectedItem().equals("Belén")) {
					Image belenPrimero = new ImageIcon("src\\Medios\\Belen(normal)\\IconoBelen.png").getImage();
					ImageIcon belenPrimero2 = new ImageIcon(belenPrimero.getScaledInstance(140, 85, Image.SCALE_SMOOTH));
					noSeleccionado3.setBounds(936, 278, 140, 85);
					noSeleccionado3.setIcon(belenPrimero2);

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
				if (escogerJugador3.getSelectedItem().equals("La Hierbas")) {
					Image laHierbasPrimero = new ImageIcon("src\\Medios\\LaHierbas(enano)\\IconoHierbas.png").getImage();
					ImageIcon laHierbasPrimero2 = new ImageIcon(laHierbasPrimero.getScaledInstance(72, 110, Image.SCALE_SMOOTH));
					noSeleccionado3.setBounds(971, 264, 72, 110);
					noSeleccionado3.setIcon(laHierbasPrimero2);

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
				if (escogerJugador3.getSelectedItem().equals("Emilio")) {
					Image emilioPrimero = new ImageIcon("src\\Medios\\Emilio(Gigante)\\IconoEmilio.png").getImage();
					ImageIcon emilioPrimero2 = new ImageIcon(emilioPrimero.getScaledInstance(150, 115, Image.SCALE_SMOOTH));
					noSeleccionado3.setBounds(930, 268, 150, 115);
					noSeleccionado3.setIcon(emilioPrimero2);

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
		});

		Image aleatorioJugadorCuatro = new ImageIcon("src/Medios/Botones/aleatorio.png").getImage();
		ImageIcon aleatorioJugadorCuatro2 = new ImageIcon(aleatorioJugadorCuatro.getScaledInstance(50,50, Image.SCALE_SMOOTH));
		btnAleatorio4 = new JButton();
		btnAleatorio4.setBounds(910, 410, 50, 50 );
		btnAleatorio4.setIcon(aleatorioJugadorCuatro2);
		btnAleatorio4.setOpaque(false);
		btnAleatorio4.setContentAreaFilled(false);
		btnAleatorio4.setBorderPainted(false);
		btnAleatorio4.addActionListener(this);
		btnAleatorio4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnAleatorio4);
		btnAleatorio4.setVisible(false);

		nombre4 = new JTextField();
		nombre4.setBounds(806, 410, 92, 20 );
		add(nombre4);
		nombre4.setVisible(false);


		escogerJugador4 = new JComboBox<String>();
		escogerJugador4.setBounds(807, 435, 90, 20 );
		escogerJugador4.addItem("Seleccione");
		escogerJugador4.addItem("Concha");
		escogerJugador4.addItem("Vicenta");
		escogerJugador4.addItem("Marisa");
		escogerJugador4.addItem("Belén");
		escogerJugador4.addItem("La Hierbas");
		escogerJugador4.addItem("Emilio");
		add(escogerJugador4);
		escogerJugador4.setVisible(false);

		Image CuartoJugador = new ImageIcon("src/Medios/Jugadores/jugador4.png").getImage();
		ImageIcon CuartoJugador2 = new ImageIcon(CuartoJugador.getScaledInstance(220,160, Image.SCALE_SMOOTH));
		jugador4 = new JLabel();
		jugador4.setBounds(640, 404, 220,160);
		jugador4.setIcon(CuartoJugador2);
		jugador4.setOpaque(false);
		add(jugador4);	
		jugador4.setVisible(false);

		Image sinSeleccionCuarto = new ImageIcon("src\\Medios\\Jugadores\\NoSeleccionado.png").getImage();
		ImageIcon sinSeleccionCuarto2 = new ImageIcon(sinSeleccionCuarto.getScaledInstance(85, 85, Image.SCALE_SMOOTH));
		noSeleccionado4 = new JLabel();
		noSeleccionado4.setBounds(965, 380, 85, 85);
		noSeleccionado4.setIcon(sinSeleccionCuarto2);
		noSeleccionado4.setOpaque(false);
		add(noSeleccionado4);
		noSeleccionado4.setVisible(false);

		escogerJugador4.addActionListener(new ActionListener() {//LEE A TIEMPO REAL EL JCOMBOBOX Y CAMBIA LA IMAGEN DEFAULT POR LA DEL VECINO SELECCIONADO
			public void actionPerformed(ActionEvent e) {
				if (escogerJugador4.getSelectedItem().equals("Seleccione")) {
					noSeleccionado4.setIcon(sinSeleccionPrimero2);
					noSeleccionado4.setBounds(965, 380, 85, 85);
				}
				if (escogerJugador4.getSelectedItem().equals("Concha")) {
					Image conchaPrimero = new ImageIcon("src\\Medios\\Concha(rojo)\\IconoConcha.png").getImage();
					ImageIcon conchaPrimero2 = new ImageIcon(conchaPrimero.getScaledInstance(100, 152, Image.SCALE_SMOOTH));
					noSeleccionado4.setBounds(959, 350, 100, 152);
					noSeleccionado4.setIcon(conchaPrimero2);
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
				if (escogerJugador4.getSelectedItem().equals("Vicenta")) {
					Image vicentaPrimero = new ImageIcon("src\\Medios\\Vicenta(verde)\\IconoVicenta.png").getImage();
					ImageIcon vicentaPrimero2 = new ImageIcon(vicentaPrimero.getScaledInstance(100, 152, Image.SCALE_SMOOTH));
					noSeleccionado4.setBounds(958, 358, 100, 152);
					noSeleccionado4.setIcon(vicentaPrimero2);
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
				if (escogerJugador4.getSelectedItem().equals("Marisa")) {
					Image marisaPrimero = new ImageIcon("src\\Medios\\Marisa(azul)\\IconoMarisa.png").getImage();
					ImageIcon marisaPrimero2 = new ImageIcon(marisaPrimero.getScaledInstance(78, 107, Image.SCALE_SMOOTH));
					noSeleccionado4.setBounds(969, 370, 78, 107);
					noSeleccionado4.setIcon(marisaPrimero2);

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
				if (escogerJugador4.getSelectedItem().equals("Belén")) {
					Image belenPrimero = new ImageIcon("src\\Medios\\Belen(normal)\\IconoBelen.png").getImage();
					ImageIcon belenPrimero2 = new ImageIcon(belenPrimero.getScaledInstance(140, 85, Image.SCALE_SMOOTH));
					noSeleccionado4.setBounds(936, 380, 140, 85);
					noSeleccionado4.setIcon(belenPrimero2);

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
				if (escogerJugador4.getSelectedItem().equals("La Hierbas")) {
					Image laHierbasPrimero = new ImageIcon("src\\Medios\\LaHierbas(enano)\\IconoHierbas.png").getImage();
					ImageIcon laHierbasPrimero2 = new ImageIcon(laHierbasPrimero.getScaledInstance(72, 110, Image.SCALE_SMOOTH));
					noSeleccionado4.setBounds(971, 366, 72, 110);
					noSeleccionado4.setIcon(laHierbasPrimero2);

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

				if (escogerJugador4.getSelectedItem().equals("Emilio")) {
					Image emilioPrimero = new ImageIcon("src\\Medios\\Emilio(Gigante)\\IconoEmilio.png").getImage();
					ImageIcon emilioPrimero2 = new ImageIcon(emilioPrimero.getScaledInstance(150, 115, Image.SCALE_SMOOTH));
					noSeleccionado4.setBounds(930, 370, 150, 115);
					noSeleccionado4.setIcon(emilioPrimero2);

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
		});

		Image aleatorioJugadorCinco = new ImageIcon("src/Medios/Botones/aleatorio.png").getImage();
		ImageIcon aleatorioJugadorCinco2 = new ImageIcon(aleatorioJugadorCinco.getScaledInstance(50,50, Image.SCALE_SMOOTH));
		btnAleatorio5 = new JButton();
		btnAleatorio5.setBounds(910, 515, 50, 50 );
		btnAleatorio5.setIcon(aleatorioJugadorCinco2);
		btnAleatorio5.setOpaque(false);
		btnAleatorio5.setContentAreaFilled(false);
		btnAleatorio5.setBorderPainted(false);
		btnAleatorio5.addActionListener(this);
		btnAleatorio5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnAleatorio5);
		btnAleatorio5.setVisible(false);

		nombre5 = new JTextField();
		nombre5.setBounds(806, 515, 92, 20 );
		add(nombre5);
		nombre5.setVisible(false);


		escogerJugador5 = new JComboBox<String>();
		escogerJugador5.setBounds(807, 540, 90, 20 );
		escogerJugador5.addItem("Seleccione");
		escogerJugador5.addItem("Concha");
		escogerJugador5.addItem("Vicenta");
		escogerJugador5.addItem("Marisa");
		escogerJugador5.addItem("Belén");
		escogerJugador5.addItem("La Hierbas");
		escogerJugador5.addItem("Emilio");
		add(escogerJugador5);
		escogerJugador5.setVisible(false);

		Image QuintoJugador = new ImageIcon("src/Medios/Jugadores/jugador5.png").getImage();
		ImageIcon QuintoJugador2 = new ImageIcon(QuintoJugador.getScaledInstance(220,160, Image.SCALE_SMOOTH));
		jugador5 = new JLabel();
		jugador5.setBounds(631, 510, 220,160 );
		jugador5.setIcon(QuintoJugador2);
		jugador5.setOpaque(false);
		add(jugador5);
		jugador5.setVisible(false);

		Image sinSeleccionQuinto = new ImageIcon("src\\Medios\\Jugadores\\NoSeleccionado.png").getImage();
		ImageIcon sinSeleccionQuinto2 = new ImageIcon(sinSeleccionQuinto.getScaledInstance(85, 85, Image.SCALE_SMOOTH));
		noSeleccionado5 = new JLabel();
		noSeleccionado5.setBounds(965, 485, 85, 85);
		noSeleccionado5.setIcon(sinSeleccionQuinto2);
		noSeleccionado5.setOpaque(false);
		add(noSeleccionado5);
		noSeleccionado5.setVisible(false);

		escogerJugador5.addActionListener(new ActionListener() {//LEE A TIEMPO REAL EL JCOMBOBOX Y CAMBIA LA IMAGEN DEFAULT POR LA DEL VECINO SELECCIONADO
			public void actionPerformed(ActionEvent e) {
				if (escogerJugador5.getSelectedItem().equals("Seleccione")) {
					noSeleccionado5.setIcon(sinSeleccionPrimero2);
					noSeleccionado5.setBounds(965, 485, 85, 85);
				}
				if (escogerJugador5.getSelectedItem().equals("Concha")) {

					Image conchaPrimero = new ImageIcon("src\\Medios\\Concha(rojo)\\IconoConcha.png").getImage();
					ImageIcon conchaPrimero2 = new ImageIcon(conchaPrimero.getScaledInstance(100, 152, Image.SCALE_SMOOTH));
					noSeleccionado5.setBounds(959, 454, 100, 152);
					noSeleccionado5.setIcon(conchaPrimero2);
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
				if (escogerJugador5.getSelectedItem().equals("Vicenta")) {

					Image vicentaPrimero = new ImageIcon("src\\Medios\\Vicenta(verde)\\IconoVicenta.png").getImage();
					ImageIcon vicentaPrimero2 = new ImageIcon(vicentaPrimero.getScaledInstance(100, 152, Image.SCALE_SMOOTH));
					noSeleccionado5.setBounds(958, 462, 100, 152);
					noSeleccionado5.setIcon(vicentaPrimero2);
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
				if (escogerJugador5.getSelectedItem().equals("Marisa")) {

					Image marisaPrimero = new ImageIcon("src\\Medios\\Marisa(azul)\\IconoMarisa.png").getImage();
					ImageIcon marisaPrimero2 = new ImageIcon(marisaPrimero.getScaledInstance(78, 107, Image.SCALE_SMOOTH));
					noSeleccionado5.setBounds(969, 474, 78, 107);
					noSeleccionado5.setIcon(marisaPrimero2);

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
				if (escogerJugador5.getSelectedItem().equals("Belén")) {

					Image belenPrimero = new ImageIcon("src\\Medios\\Belen(normal)\\IconoBelen.png").getImage();
					ImageIcon belenPrimero2 = new ImageIcon(belenPrimero.getScaledInstance(140, 85, Image.SCALE_SMOOTH));
					noSeleccionado5.setBounds(936, 484, 140, 85);
					noSeleccionado5.setIcon(belenPrimero2);

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
				if (escogerJugador5.getSelectedItem().equals("La Hierbas")) {

					Image laHierbasPrimero = new ImageIcon("src\\Medios\\LaHierbas(enano)\\IconoHierbas.png").getImage();
					ImageIcon laHierbasPrimero2 = new ImageIcon(laHierbasPrimero.getScaledInstance(72, 110, Image.SCALE_SMOOTH));
					noSeleccionado5.setBounds(971, 470, 72, 110);
					noSeleccionado5.setIcon(laHierbasPrimero2);

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
				if (escogerJugador5.getSelectedItem().equals("Emilio")) {

					Image emilioPrimero = new ImageIcon("src\\Medios\\Emilio(Gigante)\\IconoEmilio.png").getImage();
					ImageIcon emilioPrimero2 = new ImageIcon(emilioPrimero.getScaledInstance(150, 115, Image.SCALE_SMOOTH));
					noSeleccionado5.setBounds(930, 474, 150, 115);
					noSeleccionado5.setIcon(emilioPrimero2);

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
		});

		Image aleatorioJugadorSeis = new ImageIcon("src/Medios/Botones/aleatorio.png").getImage();
		ImageIcon aleatorioJugadorSeis2 = new ImageIcon(aleatorioJugadorSeis.getScaledInstance(50,50, Image.SCALE_SMOOTH));
		btnAleatorio6 = new JButton();
		btnAleatorio6.setBounds(910, 617, 50, 50 );
		btnAleatorio6.setIcon(aleatorioJugadorSeis2);
		btnAleatorio6.setOpaque(false);
		btnAleatorio6.setContentAreaFilled(false);
		btnAleatorio6.setBorderPainted(false);
		btnAleatorio6.addActionListener(this);
		btnAleatorio6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnAleatorio6);
		btnAleatorio6.setVisible(false);

		nombre6 = new JTextField();
		nombre6.setBounds(806, 617, 92, 20 );
		add(nombre6);
		nombre6.setVisible(false);


		escogerJugador6 = new JComboBox<String>();
		escogerJugador6.setBounds(807, 642, 90, 20 );
		escogerJugador6.addItem("Seleccione");
		escogerJugador6.addItem("Concha");
		escogerJugador6.addItem("Vicenta");
		escogerJugador6.addItem("Marisa");
		escogerJugador6.addItem("Belén");
		escogerJugador6.addItem("La Hierbas");
		escogerJugador6.addItem("Emilio");
		add(escogerJugador6);
		escogerJugador6.setVisible(false);

		Image SextoJugador = new ImageIcon("src/Medios/Jugadores/jugador6.png").getImage();
		ImageIcon SextoJugador2 = new ImageIcon(SextoJugador.getScaledInstance(220,160, Image.SCALE_SMOOTH));
		jugador6 = new JLabel();
		jugador6.setBounds(637, 613, 220,160 );
		jugador6.setIcon(SextoJugador2);
		jugador6.setOpaque(false);
		add(jugador6);
		jugador6.setVisible(false);

		Image sinSeleccionSexto = new ImageIcon("src\\Medios\\Jugadores\\NoSeleccionado.png").getImage();
		ImageIcon sinSeleccionSexto2 = new ImageIcon(sinSeleccionSexto.getScaledInstance(85, 85, Image.SCALE_SMOOTH));
		noSeleccionado6 = new JLabel();
		noSeleccionado6.setBounds(965, 590, 85, 85);
		noSeleccionado6.setIcon(sinSeleccionSexto2);
		noSeleccionado6.setOpaque(false);
		add(noSeleccionado6);
		noSeleccionado6.setVisible(false);

		escogerJugador6.addActionListener(new ActionListener() {//LEE A TIEMPO REAL EL JCOMBOBOX Y CAMBIA LA IMAGEN DEFAULT POR LA DEL VECINO SELECCIONADO
			public void actionPerformed(ActionEvent e) {
				if (escogerJugador6.getSelectedItem().equals("Seleccione")) {
					noSeleccionado6.setIcon(sinSeleccionPrimero2);
					noSeleccionado6.setBounds(965, 590, 85, 85);
				}
				if (escogerJugador6.getSelectedItem().equals("Concha")) {
					Image conchaPrimero = new ImageIcon("src\\Medios\\Concha(rojo)\\IconoConcha.png").getImage();
					ImageIcon conchaPrimero2 = new ImageIcon(conchaPrimero.getScaledInstance(100, 152, Image.SCALE_SMOOTH));
					noSeleccionado6.setBounds(959, 560, 100, 152);
					noSeleccionado6.setIcon(conchaPrimero2);
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
				if (escogerJugador6.getSelectedItem().equals("Vicenta")) {
					Image vicentaPrimero = new ImageIcon("src\\Medios\\Vicenta(verde)\\IconoVicenta.png").getImage();
					ImageIcon vicentaPrimero2 = new ImageIcon(vicentaPrimero.getScaledInstance(100, 152, Image.SCALE_SMOOTH));
					noSeleccionado6.setBounds(958, 568, 100, 152);
					noSeleccionado6.setIcon(vicentaPrimero2);
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
				if (escogerJugador6.getSelectedItem().equals("Marisa")) {
					Image marisaPrimero = new ImageIcon("src\\Medios\\Marisa(azul)\\IconoMarisa.png").getImage();
					ImageIcon marisaPrimero2 = new ImageIcon(marisaPrimero.getScaledInstance(78, 107, Image.SCALE_SMOOTH));
					noSeleccionado6.setBounds(969, 580, 78, 107);
					noSeleccionado6.setIcon(marisaPrimero2);

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
				if (escogerJugador6.getSelectedItem().equals("Belén")) {
					Image belenPrimero = new ImageIcon("src\\Medios\\Belen(normal)\\IconoBelen.png").getImage();
					ImageIcon belenPrimero2 = new ImageIcon(belenPrimero.getScaledInstance(140, 85, Image.SCALE_SMOOTH));
					noSeleccionado6.setBounds(936, 590, 140, 85);
					noSeleccionado6.setIcon(belenPrimero2);

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
				if (escogerJugador6.getSelectedItem().equals("La Hierbas")) {
					Image laHierbasPrimero = new ImageIcon("src\\Medios\\LaHierbas(enano)\\IconoHierbas.png").getImage();
					ImageIcon laHierbasPrimero2 = new ImageIcon(laHierbasPrimero.getScaledInstance(72, 110, Image.SCALE_SMOOTH));
					noSeleccionado6.setBounds(971, 576, 72, 110);
					noSeleccionado6.setIcon(laHierbasPrimero2);

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
				if (escogerJugador6.getSelectedItem().equals("Emilio")) {
					Image emilioPrimero = new ImageIcon("src\\Medios\\Emilio(Gigante)\\IconoEmilio.png").getImage();
					ImageIcon emilioPrimero2 = new ImageIcon(emilioPrimero.getScaledInstance(150, 115, Image.SCALE_SMOOTH));
					noSeleccionado6.setBounds(930, 580, 150, 115);
					noSeleccionado6.setIcon(emilioPrimero2);

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
		});

		//Titulo para el usuario, para saber en que ventana está
		Image titulo = new ImageIcon("src/Medios/Titulo/tituloescoger.png").getImage();
		ImageIcon titulo2 = new ImageIcon(titulo.getScaledInstance(520,305, Image.SCALE_SMOOTH));
		lbltitulo = new JLabel();
		lbltitulo.setBounds(60, -300, 1100, 800);
		lbltitulo.setIcon(titulo2);
		lbltitulo.setOpaque(false);
		add(lbltitulo);

		//imagen establecida para el fondo
		Image fondo = new ImageIcon("src/Medios/Fondos/FondoEquipos.png").getImage();
		ImageIcon fondo2 = new ImageIcon(fondo.getScaledInstance(1200,760, Image.SCALE_SMOOTH));
		lblFondo = new JLabel();
		lblFondo.setBounds(-105, -18, 1200, 800 );
		lblFondo.setIcon(fondo2);
		lblFondo.setOpaque(false);
		add(lblFondo);			

		//ponemos la variable a 3 ya que de por si hay 3 equipos como minimo
		contMaximo = 3;		



	}	

	@Override
	public void actionPerformed(ActionEvent e) {

		//si pulsa el boton añadir equipo se añadiran hasta 6
		if(e.getSource().equals(btnSumarJugador) && contMaximo == 3) {
			contMaximo ++;

			btnAleatorio4.setVisible(true);
			nombre4.setVisible(true);
			escogerJugador4.setVisible(true);
			jugador4.setVisible(true);	
			noSeleccionado4.setVisible(true);
		}

		else if(e.getSource().equals(btnSumarJugador) && contMaximo == 4) {
			contMaximo ++;
			btnAleatorio5.setVisible(true);
			nombre5.setVisible(true);
			escogerJugador5.setVisible(true);
			jugador5.setVisible(true);	
			noSeleccionado5.setVisible(true);
		}
		else if(e.getSource().equals(btnSumarJugador) && contMaximo == 5) {
			contMaximo ++;
			btnAleatorio6.setVisible(true);
			nombre6.setVisible(true);
			escogerJugador6.setVisible(true);
			jugador6.setVisible(true);	
			noSeleccionado6.setVisible(true);
		}
		//si pulsa el boton aleatorio se le asigna un personaje al azar
		else if(e.getSource().equals(btnAleatorio1)){
			int random = (int) Math.floor(Math.random()*(6)+1);
			escogerJugador1.setSelectedIndex(random);
		}
		else if(e.getSource().equals(btnAleatorio2)){
			int random = (int) Math.floor(Math.random()*(6)+1);
			escogerJugador2.setSelectedIndex(random);
		}
		else if(e.getSource().equals(btnAleatorio3)){
			int random = (int) Math.floor(Math.random()*(6)+1);
			escogerJugador3.setSelectedIndex(random);
		}
		else if(e.getSource().equals(btnAleatorio4)){
			int random = (int) Math.floor(Math.random()*(6)+1);
			escogerJugador4.setSelectedIndex(random);
		}
		else if(e.getSource().equals(btnAleatorio5)){
			int random = (int) Math.floor(Math.random()*(6)+1);
			escogerJugador5.setSelectedIndex(random);
		}
		else if(e.getSource().equals(btnAleatorio6)){
			int random = (int) Math.floor(Math.random()*(6)+1);
			escogerJugador6.setSelectedIndex(random);
		}

		//boton que nos lleva a la informacion de los vecinos
		else if(e.getSource().equals(btnInfoVecinos)) {
			JFrame VentanaCreacionEquipos = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaCreacionEquipos.remove(this);
			VentanaCreacionEquipos.getContentPane().add(new VentanaInfoVecinos());
			VentanaCreacionEquipos.setVisible(true);
		}

		//boton para ir atras
		else if(e.getSource().equals(btnAtras)) {
			JFrame VentanaCreacionEquipos = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaCreacionEquipos.remove(this);
			VentanaCreacionEquipos.getContentPane().add(new VentanaInicio());
			VentanaCreacionEquipos.setVisible(true);
			VentanaInicio.musicaPrincipal = true;
		}

		//boton para empezar la partida
		else if(e.getSource().equals(btnEmpezar)) {
			
			//este array se usara en otra pestaña, añadimos el tipo de vecino
			tipos.add((String)escogerJugador1.getSelectedItem());
			tipos.add((String)escogerJugador2.getSelectedItem());
			tipos.add((String)escogerJugador3.getSelectedItem());
			
		
			//creamos una boolean para comprobar que cada usuario meta los datos
			boolean comprobar = true;

			comprobar = comprobarDatos(escogerJugador1, nombre1, "jugador 1", nombres);

			if(comprobar) {
				comprobar = comprobarDatos(escogerJugador2, nombre2, "jugador 2", nombres);
			}

			if(comprobar) {
				comprobar = comprobarDatos(escogerJugador3, nombre3, "jugador 3", nombres);
			}

			if(comprobar && contMaximo == 4) {
				comprobar = comprobarDatos(escogerJugador4, nombre4, "jugador 4", nombres);
			}

			if(comprobar && contMaximo == 5) {
				comprobar = comprobarDatos(escogerJugador5, nombre5, "jugador 5", nombres);
			}

			if(comprobar && contMaximo == 6) {
				comprobar = comprobarDatos(escogerJugador6, nombre6, "jugador 6", nombres);
			}

			if (comprobar) {

				vecinos.add(crearEquipos(escogerJugador1, nombre1));
				vecinos.add(crearEquipos(escogerJugador2, nombre2));
				vecinos.add(crearEquipos(escogerJugador3, nombre3));

				if(contMaximo == 4) {
					vecinos.add(crearEquipos(escogerJugador4, nombre4));
					
					//este array se usara en otra pestaña, añadimos el tipo de vecino
					tipos.add((String)escogerJugador4.getSelectedItem());

				}else if(contMaximo == 5) {
					vecinos.add(crearEquipos(escogerJugador4, nombre4));
					vecinos.add(crearEquipos(escogerJugador5, nombre5));
					
					//este array se usara en otra pestaña, añadimos el tipo de vecino
					tipos.add((String)escogerJugador4.getSelectedItem());
					tipos.add((String)escogerJugador5.getSelectedItem());
				}
				else if (contMaximo == 6) {
					vecinos.add(crearEquipos(escogerJugador4, nombre4));
					vecinos.add(crearEquipos(escogerJugador5, nombre5));
					vecinos.add(crearEquipos(escogerJugador6, nombre6));
					
					//este array se usara en otra pestaña, añadimos el tipo de vecino
					tipos.add((String)escogerJugador4.getSelectedItem());
					tipos.add((String)escogerJugador5.getSelectedItem());
					tipos.add((String)escogerJugador6.getSelectedItem());
				}

				copiavecinos= new int [vecinos.size()];
				nombreVecinos = new String [vecinos.size()];
				tipoVecinos = new String [vecinos.size()];
				
				
				for (int i = 0; i < copiavecinos.length; i++) {
					copiavecinos[i] = vecinos.get(i).getEurosPagar();
					nombreVecinos[i] = vecinos.get(i).getNombre();
					tipoVecinos[i] = tipos.get(i);
				}
				
				//				copiavecinos = (ArrayList) vecinos.clone();

				JFrame VentanaCreacionEquipos = (JFrame) SwingUtilities.getWindowAncestor(this);
				VentanaCreacionEquipos.remove(this);
				VentanaCreacionEquipos.getContentPane().add(new VentanaAtaqueDefensa());
				VentanaCreacionEquipos.setVisible(true);
			}
		}
	}
	//funcion que comprobará si se ha escogido los nombres y los tipos de los jugadores
	private boolean comprobarDatos(JComboBox<String> escogerJugador, JTextField nombre, String nombreEquipo, ArrayList<String>nombres) {

		if(nombre.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "El "+ nombreEquipo + " no ha escogido el nombre");
			return false;
		}
		if(escogerJugador.getSelectedItem().equals("Seleccione")) {
			JOptionPane.showMessageDialog(null, "El "+ nombreEquipo + " no ha escogido el tipo");
			return false;
		}

		//comprobar nombres repetidos

		if(nombres.contains(nombre.getText())) {
			JOptionPane.showMessageDialog(null, "Existe algún nombre repetido, por favor, cambielo");
			//reseteamos el array ya que tendra valores repetidos
			nombres.clear();	
			return false;	
		}else {
			nombres.add(nombre.getText());	

		}

		return true;
	}

	private Vecino crearEquipos(JComboBox<String> escogerJugador, JTextField nombre) {
		if(escogerJugador.getSelectedItem().equals("Belén")) {
			Belen belen = new Belen(nombre.getText(), "src\\Medios\\Belen(normal)\\IconoBelen.png");
			return belen;

		}else if(escogerJugador.getSelectedItem().equals("Concha")){
			Concha concha = new Concha(nombre.getText(), "src\\Medios\\Concha(rojo)\\IconoConcha.png");
			return concha;
		}
		else if(escogerJugador.getSelectedItem().equals("Emilio")){
			Emilio emilio = new Emilio(nombre.getText(), "src\\Medios\\Emilio(Gigante)\\IconoEmilio.png");
			return emilio;
		}
		else if(escogerJugador.getSelectedItem().equals("La Hierbas")){
			Hierbas hierbas = new Hierbas(nombre.getText(), "src\\Medios\\LaHierbas(enano)\\IconoHierbas.png");
			return hierbas;
		}
		else if(escogerJugador.getSelectedItem().equals("Marisa")){
			Marisa marisa = new Marisa(nombre.getText(), "src\\Medios\\Marisa(azul)\\IconoMarisa.png");
			return marisa;
		}
		else if(escogerJugador.getSelectedItem().equals("Vicenta")){
			Vicenta vicenta = new Vicenta(nombre.getText(), "src\\Medios\\Vicenta(verde)\\IconoVicenta.png");
			return vicenta;
		}

		else{
			return null;
		}

	}
}
