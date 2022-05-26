package Ventanas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import Principal.Vecino;

public class VentanaResumenRonda extends JPanel implements ActionListener{

	private JLabel lblFondo;
	private JButton btnContinuar;
	private JTextArea resumen;

	public VentanaResumenRonda() {
		setLayout(null);


		VentanaAtaqueDefensa.contRonda++;

		//reiniciamos los euros de cada vecino
		Vecino.reiniciarEuros(VentanaCreacionEquipos.vecinos, VentanaAtaqueDefensa.contRonda -1);

		//comprobamos los equipos vivos
		Vecino.comprobarEquiposVivos(VentanaCreacionEquipos.vecinos);

		VentanaCreacionEquipos.copiavecinos= new int [VentanaCreacionEquipos.vecinos.size()];

		for (int i = 0; i < VentanaCreacionEquipos.copiavecinos.length; i++) {
			VentanaCreacionEquipos.copiavecinos[i] = VentanaCreacionEquipos.vecinos.get(i).getEurosPagar();
		}



		Image continuar = new ImageIcon("src/Medios/Botones/BotonContinuarRonda.png").getImage();
		ImageIcon continuar2 = new ImageIcon(continuar.getScaledInstance(100, 45, Image.SCALE_SMOOTH));
		btnContinuar = new JButton();
		btnContinuar.setBounds(965, 700, 100, 45);
		btnContinuar.setIcon(continuar2);
		btnContinuar.setOpaque(false);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setBorderPainted(false);
		btnContinuar.addActionListener(this);
		btnContinuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnContinuar);

		resumen = new JTextArea (VentanaAtaqueDefensa.guardaryRobar);
		resumen.setBounds(250, 490, 1000, 500);
		resumen.setOpaque(false);
		resumen.setFont(new Font("Arial", Font.PLAIN, 18));
		resumen.setEditable(false);
		add(resumen);
		resumen.setVisible(true);

		//imagen establecida para el fondo
		Image fondo = new ImageIcon("src/Medios/Fondos/FondoResumenRonda.jpg").getImage();
		ImageIcon fondo2 = new ImageIcon(fondo.getScaledInstance(1200, 800, Image.SCALE_SMOOTH));
		lblFondo = new JLabel();
		lblFondo.setBounds(-75, 0, 1200, 800);
		lblFondo.setIcon(fondo2);
		lblFondo.setOpaque(false);
		add(lblFondo);


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(btnContinuar) ) {

			if(VentanaCreacionEquipos.vecinos.size() == 1) {
				JFrame VentanaResumenRonda2 = (JFrame) SwingUtilities.getWindowAncestor(this);
				VentanaResumenRonda2.remove(this);
				VentanaResumenRonda2.getContentPane().add(new VentanaGanador());
				VentanaResumenRonda2.setVisible(true);
			}else {
				VentanaAtaqueDefensa.guardaryRobar = "";
				VentanaAtaqueDefensa.cont = 0;
				JFrame VentanaResumenRonda = (JFrame) SwingUtilities.getWindowAncestor(this);
				VentanaResumenRonda.remove(this);
				VentanaResumenRonda.getContentPane().add(new VentanaAtaqueDefensa());
				VentanaResumenRonda.setVisible(true);
				//reiniciamos la variable para que este vacia para la siguiente ronda
				

			}		
		}


	}
}
