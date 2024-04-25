package views;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import controllers.AdminFrameController;

public class AdminFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnInsertar;
	private JButton btnVolver;
	private JLabel labelLogo;
	private JSeparator separator;
	/**
	 * Create the frame.
	 */
	public AdminFrame() {
		setTitle("Panel de administrador");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 305);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(33, 113, 152, 63);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(195, 113, 152, 63);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnEliminar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(357, 113, 152, 63);
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnInsertar);
		
		labelLogo = new JLabel();
		labelLogo.setBounds(146, 15, 250, 62);
		labelLogo.setIcon(new ImageIcon("image/LogoAdmin.png"));
		add(labelLogo);
		
		separator = new JSeparator();
		separator.setBounds(23, 91, 496, 11);
		add(separator);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(195, 187, 152, 63);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnVolver);
		
		setVisible(true);
		
		AdminFrameController adFrameController = new AdminFrameController(this);
	}
	
	public void addListeners (ActionListener actionListener) {
		btnEditar.addActionListener(actionListener);
		btnEliminar.addActionListener(actionListener);
		btnInsertar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
	}
	public JButton getBtnEditar() {
		return btnEditar;
	}
	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	public JButton getBtnInsertar() {
		return btnInsertar;
	}
	public void setBtnInsertar(JButton btnInsertar) {
		this.btnInsertar = btnInsertar;
	}
	public JLabel getLabelLogo() {
		return labelLogo;
	}
	public void setLabelLogo(JLabel labelLogo) {
		this.labelLogo = labelLogo;
	}
	public JButton getBtnVolver() {
		return btnVolver;
	}
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
}
