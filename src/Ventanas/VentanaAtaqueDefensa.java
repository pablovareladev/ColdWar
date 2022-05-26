package Ventanas;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.plaf.basic.BasicSpinnerUI;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import Principal.Vecino;
import TiposPlanetas.Belen;

public class VentanaAtaqueDefensa extends JPanel implements ActionListener{
	private JLabel lblFondo;
	private JButton btnGuardarEuros;
	private JButton btnRobarEuros;
	private JButton btnContinuar;
	private JButton btnSiguienteRonda;
	private JLabel jugador1;
	private JTextArea jugadoresTipos;
	private JLabel nombreJugadorAtaca;
	private JLabel eurosJugadorAtaca;
	private JLabel lblpreguntaAtaque;
	private JLabel eurosJugadorParaAtacar;
	private JLabel lbleurosDisponibles;
	private JLabel lblpreguntaCuanto;
	private JSpinner eurosRobarGuardar;

	private boolean sigRonda = false;
	
	static String tipos = "";
	static int cont = 0;
	static String resumenRonda = "";
	private JComboBox<String> escogerJugador1;
	static boolean comprobar;
	private boolean comprobar_2 = true;
	static boolean guardarEuros;
	static String guardaryRobar = "";
	static int contRonda;
	//	ArrayList<Vecino> copiavecinos = (ArrayList) VentanaCreacionEquipos.vecinos.clone();
	public VentanaAtaqueDefensa() {
		setLayout(null);
		//reiniciamos la variable
		tipos ="";

		//		Se muestra la imagen del jugador que va a atacar en ese turno
		// hacemos else if para saber que imagen poner dependiendo de la eleccion del jugador
		Image ImagenPrimerJugador = new ImageIcon(VentanaCreacionEquipos.vecinos.get(cont).getUrl()).getImage();
		if(VentanaCreacionEquipos.vecinos.get(cont).getUrl() == "src\\Medios\\Belen(normal)\\IconoBelen.png") {
			ImageIcon ImagenPrimerJugador2 = new ImageIcon(ImagenPrimerJugador.getScaledInstance(410, 250, Image.SCALE_SMOOTH));
			jugador1 = new JLabel();
			jugador1.setBounds(350, 10, 410, 250);
			jugador1.setIcon(ImagenPrimerJugador2);
			jugador1.setOpaque(false);
			add(jugador1);
		}
		else if(VentanaCreacionEquipos.vecinos.get(cont).getUrl() == "src\\Medios\\Concha(rojo)\\IconoConcha.png") {
			ImageIcon ImagenPrimerJugador2 = new ImageIcon(ImagenPrimerJugador.getScaledInstance(300,450, Image.SCALE_SMOOTH));
			jugador1 = new JLabel();
			jugador1.setBounds(400, -80, 300, 450 );
			jugador1.setIcon(ImagenPrimerJugador2);
			jugador1.setOpaque(false);
			add(jugador1);
		}
		else if(VentanaCreacionEquipos.vecinos.get(cont).getUrl() == "src\\Medios\\Emilio(Gigante)\\IconoEmilio.png") {
			ImageIcon ImagenPrimerJugador2 = new ImageIcon(ImagenPrimerJugador.getScaledInstance(475, 340, Image.SCALE_SMOOTH));
			jugador1 = new JLabel();
			jugador1.setBounds(310, -35, 475, 340);
			jugador1.setIcon(ImagenPrimerJugador2);
			jugador1.setOpaque(false);
			add(jugador1);
		}
		else if(VentanaCreacionEquipos.vecinos.get(cont).getUrl() == "src\\Medios\\LaHierbas(enano)\\IconoHierbas.png") {
			ImageIcon ImagenPrimerJugador2 = new ImageIcon(ImagenPrimerJugador.getScaledInstance(230, 340, Image.SCALE_SMOOTH));
			jugador1 = new JLabel();
			jugador1.setBounds(440, -55, 230, 340);
			jugador1.setIcon(ImagenPrimerJugador2);
			jugador1.setOpaque(false);
			add(jugador1);
		}
		else if(VentanaCreacionEquipos.vecinos.get(cont).getUrl() == "src\\Medios\\Marisa(azul)\\IconoMarisa.png") {
			ImageIcon ImagenPrimerJugador2 = new ImageIcon(ImagenPrimerJugador.getScaledInstance(235, 310, Image.SCALE_SMOOTH));
			jugador1 = new JLabel();
			jugador1.setBounds(440, -10, 235, 310);
			jugador1.setIcon(ImagenPrimerJugador2);
			jugador1.setOpaque(false);
			add(jugador1);
		}
		else if(VentanaCreacionEquipos.vecinos.get(cont).getUrl() == "src\\Medios\\Vicenta(verde)\\IconoVicenta.png") {
			ImageIcon ImagenPrimerJugador2 = new ImageIcon(ImagenPrimerJugador.getScaledInstance(300,450, Image.SCALE_SMOOTH));
			jugador1 = new JLabel();
			jugador1.setBounds(405, -70, 300, 450 );
			jugador1.setIcon(ImagenPrimerJugador2);
			jugador1.setOpaque(false);
			add(jugador1);
		}


		//nombre de los jugadores y el tipo de planeta que son
		for (int i = 0; i < VentanaCreacionEquipos.nombreVecinos.length; i++) {
			tipos += (VentanaCreacionEquipos.nombreVecinos[i] + " ("+ VentanaCreacionEquipos.tipoVecinos[i] + ")" + "\n");
		}

		jugadoresTipos = new JTextArea(tipos);
		jugadoresTipos.setBounds(85, 515, 220, 700);
		jugadoresTipos.setFont(new Font("Arial", Font.PLAIN, 22));
		jugadoresTipos.setAlignmentX(SwingConstants.CENTER);
		jugadoresTipos.setForeground(Color.black);
		jugadoresTipos.setEditable(false);
		jugadoresTipos.setOpaque(false);
		add(jugadoresTipos);



		//El nombre del jugador que va a atacar en este turno
		nombreJugadorAtaca = new JLabel(VentanaCreacionEquipos.vecinos.get(cont).getNombre());
		nombreJugadorAtaca.setBounds(510, 180, 220, 160);
		nombreJugadorAtaca.setFont(new Font("Arial", Font.PLAIN, 32));
		nombreJugadorAtaca.setAlignmentX(SwingConstants.CENTER);
		nombreJugadorAtaca.setForeground(Color.white);

		nombreJugadorAtaca.setOpaque(false);
		add(nombreJugadorAtaca);

		//		Dinero del jugador que va atacar
		eurosJugadorAtaca = new JLabel("Saldo: " + String.valueOf(VentanaCreacionEquipos.copiavecinos[cont]));
		eurosJugadorAtaca.setBounds(495, 210, 220, 160);
		eurosJugadorAtaca.setFont(new Font("Arial", Font.PLAIN, 24));
		eurosJugadorAtaca.setAlignmentX(SwingConstants.CENTER);
		eurosJugadorAtaca.setForeground(Color.white);
		eurosJugadorAtaca.setOpaque(false);
		add(eurosJugadorAtaca);

		//Boton para guardar euros
		Image guardar = new ImageIcon("src/Medios/Botones/botonGuardarEuros.png").getImage();
		ImageIcon guardar2 = new ImageIcon(guardar.getScaledInstance(280,130, Image.SCALE_SMOOTH));
		btnGuardarEuros = new JButton();
		btnGuardarEuros.setBounds(70, 170, 280, 130 );
		btnGuardarEuros.setIcon(guardar2);
		btnGuardarEuros.setOpaque(false);
		btnGuardarEuros.setContentAreaFilled(false);
		btnGuardarEuros.setBorderPainted(false);
		btnGuardarEuros.addActionListener(this);
		btnGuardarEuros.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnGuardarEuros);

		//Boton para robar euros
		Image robar = new ImageIcon("src/Medios/Botones/botonRobar.png").getImage();
		ImageIcon robar2 = new ImageIcon(robar.getScaledInstance(280,130, Image.SCALE_SMOOTH));
		btnRobarEuros = new JButton();
		btnRobarEuros.setBounds(740, 170, 280, 130 );
		btnRobarEuros.setIcon(robar2);
		btnRobarEuros.setOpaque(false);
		btnRobarEuros.setContentAreaFilled(false);
		btnRobarEuros.setBorderPainted(false);
		btnRobarEuros.addActionListener(this);
		btnRobarEuros.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnRobarEuros);

		//Label para la pregunta quien quiere atacar
		Image preguntaAtaque = new ImageIcon("src/Medios/Titulo/ataqueQuienAtacar.png").getImage();
		ImageIcon preguntaAtaque2 = new ImageIcon(preguntaAtaque.getScaledInstance(500,400, Image.SCALE_SMOOTH));
		lblpreguntaAtaque = new JLabel();
		lblpreguntaAtaque.setBounds(300, 250, 500, 400 );
		lblpreguntaAtaque.setIcon(preguntaAtaque2);
		lblpreguntaAtaque.setOpaque(false);
		add(lblpreguntaAtaque);
		lblpreguntaAtaque.setVisible(false);

		//Un ComboBox en los que te dicen los nombres de los vecinos a los que pueden atacar 
		escogerJugador1 = new JComboBox<String>();
		escogerJugador1.setBounds(490, 465, 115, 25);

		//Bucle for para que sea dinamico
		for(int i = 0; i < VentanaCreacionEquipos.vecinos.size(); i++) {	
			if(!VentanaCreacionEquipos.vecinos.get(cont).getNombre().equals(VentanaCreacionEquipos.vecinos.get(i).getNombre())) {
				escogerJugador1.addItem(VentanaCreacionEquipos.vecinos.get(i).getNombre() + " (" + VentanaCreacionEquipos.copiavecinos[i] +"€)");	
			}

		}
		add(escogerJugador1);
		escogerJugador1.setVisible(false);

		//Euros que dispone el vecino que ataca para atacar 
		eurosJugadorParaAtacar = new JLabel(String.valueOf(VentanaCreacionEquipos.vecinos.get(cont).getEuros()));
		eurosJugadorParaAtacar.setBounds(600, 615, 220, 160);
		eurosJugadorParaAtacar.setOpaque(false);
		eurosJugadorParaAtacar.setFont(new Font("Arial", Font.PLAIN, 24));
		eurosJugadorParaAtacar.setForeground(Color.white);
		add(eurosJugadorParaAtacar);
		eurosJugadorParaAtacar.setVisible(true);

		//Un label de Euros disponibles
		Image eurosDisponibles = new ImageIcon("src/Medios/Titulo/ataqueEurosDisponibles.png").getImage();
		ImageIcon eurosDisponibles2 = new ImageIcon(eurosDisponibles.getScaledInstance(250, 260, Image.SCALE_SMOOTH));
		lbleurosDisponibles = new JLabel();
		lbleurosDisponibles.setBounds(400, 575, 250, 260);
		lbleurosDisponibles.setIcon(eurosDisponibles2);
		lbleurosDisponibles.setOpaque(false);
		add(lbleurosDisponibles);
		lbleurosDisponibles.setVisible(true);

		//Label con la pregunta cuanto
		Image preguntaCuanto = new ImageIcon("src/Medios/Titulo/ataqueCuanto.png").getImage();
		ImageIcon preguntaCuanto2 = new ImageIcon(preguntaCuanto.getScaledInstance(280, 290, Image.SCALE_SMOOTH));
		lblpreguntaCuanto = new JLabel();
		lblpreguntaCuanto.setBounds(410, 440 , 280, 290);
		lblpreguntaCuanto.setIcon(preguntaCuanto2);
		lblpreguntaCuanto.setOpaque(false);
		add(lblpreguntaCuanto);
		lblpreguntaCuanto.setVisible(false);

		//Spinner para decir con cuantos euros quiere robar o guardarse
		SpinnerModel model1 = new SpinnerNumberModel(0, 0, VentanaCreacionEquipos.vecinos.get(cont).getEuros(), 1);
		eurosRobarGuardar = new JSpinner(model1);
		eurosRobarGuardar.setBounds(510, 600, 59, 22);
		eurosRobarGuardar.setEditor(new JSpinner.DefaultEditor(eurosRobarGuardar));
		add(eurosRobarGuardar);
		eurosRobarGuardar.setVisible(false);

		//Boton siguiente turno
		Image turno = new ImageIcon("src/Medios/Botones/BotonContinuarRonda.png").getImage();
		ImageIcon turno2 = new ImageIcon(turno.getScaledInstance(100, 45, Image.SCALE_SMOOTH));
		btnContinuar = new JButton();
		btnContinuar.setBounds(965, 700, 100, 45);
		btnContinuar.setIcon(turno2);
		btnContinuar.setOpaque(false);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setBorderPainted(false);
		btnContinuar.addActionListener(this);
		btnContinuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnContinuar);

		//Boton siguiente ronda
		Image ronda = new ImageIcon("src/Medios/Botones/BotonSiguienteRonda.png").getImage();
		ImageIcon ronda2 = new ImageIcon(ronda.getScaledInstance(100, 45, Image.SCALE_SMOOTH));
		btnSiguienteRonda = new JButton();
		btnSiguienteRonda.setBounds(965, 700, 100, 45);
		btnSiguienteRonda.setIcon(ronda2);
		btnSiguienteRonda.setOpaque(false);
		btnSiguienteRonda.setContentAreaFilled(false);
		btnSiguienteRonda.setBorderPainted(false);
		btnSiguienteRonda.addActionListener(this);
		btnSiguienteRonda.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnSiguienteRonda);

		//Bucle if para indicar cuando aparece el boton siguiente turno o siguiente ronda
		if(cont < VentanaCreacionEquipos.vecinos.size() && VentanaCreacionEquipos.vecinos.get(cont).getEuros() != 0){
			btnContinuar.setVisible(true);
		}



		//imagen establecida para el fondo
		Image fondo = new ImageIcon("src/Medios/Fondos/FondoAtaqueDefensa11.jpg").getImage();
		ImageIcon fondo2 = new ImageIcon(fondo.getScaledInstance(1200,760, Image.SCALE_SMOOTH));
		lblFondo = new JLabel();
		lblFondo.setBounds(-40, -18, 1200, 800 );
		lblFondo.setIcon(fondo2);
		lblFondo.setOpaque(false);
		add(lblFondo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//Cuando le damos al boton robar
		if(e.getSource().equals(btnRobarEuros)) {
			lblpreguntaAtaque.setVisible(true);
			escogerJugador1.setVisible(true);
			eurosJugadorParaAtacar.setVisible(true);
			lblpreguntaCuanto.setVisible(true);

			//se usa el mismo spiner para guardar o para robar
			eurosRobarGuardar.setVisible(true);
			//ponemos la boolean a false ya que robará euros
			guardarEuros = false;

			//Cuando le damos al boton guardar
		}else if(e.getSource().equals(btnGuardarEuros)){	
			lblpreguntaAtaque.setVisible(false);
			escogerJugador1.setVisible(false);
			lblpreguntaCuanto.setVisible(true);

			//se usa el mismo spiner para guardar o para robar
			eurosRobarGuardar.setVisible(true);
			//ponemos la boolean en true para indicar al codigo que se quieren guardar euros
			guardarEuros = true;
		}

		//Cuando le damos al boton siguiente turno
		if(e.getSource().equals(btnContinuar) && comprobarDatos(eurosRobarGuardar) == true){

			if(guardarEuros) {
				guardaryRobar += VentanaCreacionEquipos.vecinos.get(cont).defensa((int) eurosRobarGuardar.getValue(), VentanaCreacionEquipos.vecinos, cont);
			}
			else if(!guardarEuros) {

				int atacado = 0;
				for(int i = 0; i <  VentanaCreacionEquipos.vecinos.size(); i++) {

					String nombre = escogerJugador1.getSelectedItem().toString();
					String [] nom = nombre.split(" ");

					if(VentanaCreacionEquipos.vecinos.get(i).getNombre().equals(nom[0])){
						//guardamos la posicion del que queremos atacar
						atacado = i;
					}		
				}
				guardaryRobar += VentanaCreacionEquipos.vecinos.get(cont).ataque((int) eurosRobarGuardar.getValue(),VentanaCreacionEquipos.vecinos.get(atacado));			
			}

			if(VentanaCreacionEquipos.vecinos.get(cont).getEuros() == 0){
				cont++;
				
				//esto nos sirve para comprobar los turnos, cuando jueguen todos se pondra a true, para jugar el ultimo turno
				if(cont == (VentanaCreacionEquipos.vecinos.size()-1)){
					comprobar = true;
				}else if(cont == VentanaCreacionEquipos.vecinos.size()) {
					
					sigRonda = true;
					
					JFrame VentanaAtaqueDefensa = (JFrame) SwingUtilities.getWindowAncestor(this);
					VentanaAtaqueDefensa.remove(this);
					VentanaAtaqueDefensa.getContentPane().add(new VentanaResumenRonda());
					VentanaAtaqueDefensa.setVisible(true);
				}
			}		
			
			if(!sigRonda) {
				JFrame VentanaAtaqueDefensa = (JFrame) SwingUtilities.getWindowAncestor(this);
				VentanaAtaqueDefensa.remove(this);
				VentanaAtaqueDefensa.getContentPane().add(new VentanaAtaqueDefensa());
				VentanaAtaqueDefensa.setVisible(true);
				sigRonda = false;
			}
		

		} 
	}
	//funcion que comprobará si se ha escogido los nombres y los tipos de los jugadores
	private boolean comprobarDatos(JSpinner euros) {

		if(euros.getValue().equals(0)) {
			JOptionPane.showMessageDialog(null, "¡No pueden ser 0 euros!");
			return false;
		}
		return true;
	}


}
