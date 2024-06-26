package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.LoginFrameController;
import util.ImageLoader;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private LoginFrameController lFrameController;
	private JLabel labelUsuario;
	private JLabel labelPassword;
	private JLabel labelError;
	private JButton btnLogin;
	private JButton btnCancelar;
	private JTextField textUsuario;
	private JPasswordField textPassword;

	/**
	 * Create the dialog.
	 */
	public LoginFrame() {
		setTitle("Login");
		setResizable(false);
		setBounds(100, 100, 346, 239);
		getContentPane().setLayout(null);
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		ImageLoader.loadFrameIcon("/resources/image/FrameIcon.png", this);

		labelUsuario = new JLabel("Usuario:");
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUsuario.setBounds(130, 11, 58, 14);
		getContentPane().add(labelUsuario);

		textUsuario = new JTextField();
		textUsuario.setBounds(82, 31, 154, 20);
		getContentPane().add(textUsuario);
		textUsuario.setColumns(10);

		labelPassword = new JLabel("Password");
		labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPassword.setBounds(123, 62, 72, 14);
		getContentPane().add(labelPassword);

		textPassword = new JPasswordField();
		textPassword.setColumns(10);
		textPassword.setBounds(82, 82, 154, 20);
		getContentPane().add(textPassword);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.setBounds(50, 156, 89, 23);
		getContentPane().add(btnLogin);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(189, 157, 89, 23);
		getContentPane().add(btnCancelar);

		labelError = new JLabel("");
		labelError.setForeground(new Color(255, 0, 0));
		labelError.setHorizontalAlignment(SwingConstants.CENTER);
		labelError.setBounds(24, 104, 280, 46);
		getContentPane().add(labelError);
		setVisible(true);

		lFrameController = new LoginFrameController(this);
	}

	public LoginFrameController getlFrameController() {
		return lFrameController;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JTextField getTextUsuario() {
		return textUsuario;
	}

	public void setTextUsuario(JTextField textUsuario) {
		this.textUsuario = textUsuario;
	}

	public JPasswordField getTextPassword() {
		return textPassword;
	}

	public void setTextPassword(JPasswordField textPassword) {
		this.textPassword = textPassword;
	}

	public JLabel getLabelError() {
		return labelError;
	}

	public void setLabelError(JLabel labelError) {
		this.labelError = labelError;
	}

	public void addActListener(ActionListener listener) {
		btnLogin.addActionListener(listener);
		btnCancelar.addActionListener(listener);
		textUsuario.addActionListener(listener);
		textPassword.addActionListener(listener);
	}
}
