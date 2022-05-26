package VentanasInfoVecinos;

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

import Ventanas.VentanaInfoVecinos;
import Ventanas.VentanaInicio;

public class InfoConcha extends JPanel implements ActionListener{
	private JLabel lblFondo;
	private JButton btnAtras;

	public InfoConcha() {
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
		Image fondo = new ImageIcon("src/Medios/Fondos/FondoConchaInfo.jpg").getImage();
		ImageIcon fondo2 = new ImageIcon(fondo.getScaledInstance(1100, 820, Image.SCALE_SMOOTH));
		lblFondo = new JLabel();
		lblFondo.setBounds(0, 0, 1100, 820);
		lblFondo.setIcon(fondo2);
		lblFondo.setOpaque(false);
		add(lblFondo);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//boton para ir atras
		if(e.getSource().equals(btnAtras)) {
			JFrame InfoConcha = (JFrame) SwingUtilities.getWindowAncestor(this);
			InfoConcha.remove(this);
			InfoConcha.getContentPane().add(new VentanaInfoVecinos());
			InfoConcha.setVisible(true);
		}
	}
}
