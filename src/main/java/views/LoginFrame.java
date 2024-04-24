package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.LoginFrameController;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame owner;
	private JLabel labelUsuario;
	private JTextField textUsuario;
	private JLabel labelPassword;
	private JPasswordField textPassword;
	private JButton btnLogin;
	private JButton btnCancelar;
	private JLabel labelError;
	/**
	 * Create the dialog.
	 */
	public LoginFrame(JFrame owner) {
		this.owner = owner;
		setTitle("Login");
		setResizable(false);
		setBounds(100, 100, 346, 239);
		getContentPane().setLayout(null);
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
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

		LoginFrameController loginDController = new LoginFrameController(this);
	}
	
	public JFrame getOwner() {
		return owner;
	}

	public void setOwner(JFrame owner) {
		this.owner = owner;
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

	public void addLoginListener(ActionListener listener) {
		btnLogin.addActionListener(listener);
		btnCancelar.addActionListener(listener);
	}
}
