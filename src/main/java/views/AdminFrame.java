package views;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import controllers.AdminFrameController;
import util.ImageLoader;

public class AdminFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JLabel labelLogo;
	private JSeparator separator;
	private JButton btnAdministrar;

	/**
	 * Create the frame.
	 */
	public AdminFrame() {
		setTitle("Panel de administrador");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 237);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		ImageLoader.loadFrameIcon("/resources/image/FrameIcon.png", this);

		labelLogo = new JLabel();
		labelLogo.setBounds(23, 16, 250, 62);
		ImageLoader.loadJLabelImage("/resources/image/LogoAdmin.png", this, labelLogo);
		getContentPane().add(labelLogo);

		separator = new JSeparator();
		separator.setBounds(12, 91, 271, 11);
		getContentPane().add(separator);

		btnVolver = new JButton("");
		ImageLoader.loadJButtonImage("/resources/image/Return.png", this, btnVolver);
		btnVolver.setBounds(129, 154, 34, 34);
		getContentPane().add(btnVolver);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btnAdministrar = new JButton("Admin BBDD");
		btnAdministrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdministrar.setBounds(76, 102, 141, 41);
		getContentPane().add(btnAdministrar);

		setVisible(true);

		AdminFrameController adFrameController = new AdminFrameController(this);
	}

	public void addListeners(ActionListener actionListener) {
		btnAdministrar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
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

	public JButton getBtnAdministrar() {
		return btnAdministrar;
	}

	public void setBtnAdministrar(JButton btnAdministrar) {
		this.btnAdministrar = btnAdministrar;
	}
}
