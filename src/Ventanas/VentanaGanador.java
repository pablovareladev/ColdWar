package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaGanador extends JPanel implements ActionListener{

	private JLabel lblFondo;
	private JLabel ganador;
	public VentanaGanador () {
		setLayout(null);
		
		ganador = new JLabel(VentanaCreacionEquipos.vecinos.get(0).getNombre());
		ganador.setBounds(535, 370, 300, 160);
		ganador.setFont(new Font("Arial", Font.PLAIN, 48));
		ganador.setAlignmentX(SwingConstants.CENTER);
		ganador.setForeground(Color.black);

		ganador.setOpaque(false);
		add(ganador);
		
		//This gets the path to the project, but not into /src for eclipse
		String path = new File("src\\Medios\\Audios\\GanadorLasCaras.wav").getAbsolutePath();
		//Make a File object with a path to the audio file.
		File sound = new File(path);

		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip c = AudioSystem.getClip();
			c.open(ais); //Clip opens AudioInputStream
			c.start(); //Start playing audio
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//imagen establecida para el fondo
		Image fondo = new ImageIcon("src/Medios/Fondos/FondoGanador2.jpg").getImage();
		ImageIcon fondo2 = new ImageIcon(fondo.getScaledInstance(1100, 820, Image.SCALE_SMOOTH));
		lblFondo = new JLabel();
		lblFondo.setBounds(0, 0, 1100, 820);
		lblFondo.setIcon(fondo2);
		lblFondo.setOpaque(false);
		add(lblFondo);

	}
	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
