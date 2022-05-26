package Ventanas;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VentanaInfo extends JPanel implements ActionListener{
	private JLabel lblFondo;
	private JButton btnAtras;

	public VentanaInfo() {
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


		//imagen establecida para el fondo
		Image fondo = new ImageIcon("src/Medios/Fondos/proyectofondoInfo.jpg").getImage();
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
			JFrame VentanaInfo = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaInfo.remove(this);
			VentanaInfo.getContentPane().add(new VentanaInicio());
			VentanaInfo.setVisible(true);
			VentanaInicio.musicaPrincipal = false;
		}
	}
}
