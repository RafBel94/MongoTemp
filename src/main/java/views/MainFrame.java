package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.MainFrameController;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnConsulta;
	private JSeparator separator;
	private JLabel labelLogo;
	private JButton btnAbout;
	private JLabel lblNewLabel;
	private JPanel panelLogin;
	private JButton btnLogin;
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("MongoTemp");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 343);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelLogin = new JPanel();
		panelLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLogin.setBounds(48, 227, 190, 64);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		labelLogo = new JLabel();
		labelLogo.setIcon(new ImageIcon("image/Logo.png"));
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setBounds(17, 5, 250, 87);
		contentPane.add(labelLogo);
		
		btnConsulta = new JButton("Realizar Consulta");
		btnConsulta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulta.setBounds(37, 126, 213, 72);
		contentPane.add(btnConsulta);
		
		btnAbout = new JButton("?");
		btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAbout.setBounds(249, 268, 25, 23);
		contentPane.add(btnAbout);
		
		separator = new JSeparator();
		separator.setBounds(17, 103, 250, 12);
		contentPane.add(separator);
		
		lblNewLabel = new JLabel("¿Eres administrador?");
		lblNewLabel.setBounds(10, 6, 170, 16);
		panelLogin.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.setBounds(51, 33, 89, 23);
		panelLogin.add(btnLogin);
		
		setVisible(true);
		
		MainFrameController mfController = new MainFrameController(this);
	}
	
	public JButton getBtnConsulta() {
		return btnConsulta;
	}

	public void setBtnConsulta(JButton btnConsulta) {
		this.btnConsulta = btnConsulta;
	}

	public JButton getBtnAbout() {
		return btnAbout;
	}

	public void setBtnAbout(JButton btnAbout) {
		this.btnAbout = btnAbout;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public void addLoginListener(ActionListener listener) {
		btnLogin.addActionListener(listener);
		btnAbout.addActionListener(listener);
		btnConsulta.addActionListener(listener);
	}
}
