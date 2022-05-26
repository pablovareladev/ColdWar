package Ventanas;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	static int panel = 1;
	static double sumaT = 0;

	public VentanaPrincipal() {
		
	

		setTitle("Sobrevive a la Derrama");
		setResizable(false);

		setBounds(425, 155, 1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if(panel == 1) {
			VentanaInicio VentanaInicio = new VentanaInicio(); 
			add(VentanaInicio);
		}else if(panel == 2) {
			VentanaCreacionEquipos VentanaCreacionEquipos = new VentanaCreacionEquipos();
			add(VentanaCreacionEquipos);
		}
		setVisible(true);
		

	}

}
