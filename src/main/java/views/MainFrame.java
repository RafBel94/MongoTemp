package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
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
import util.ImageLoader;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private MainFrameController mFrameController;
	private JPanel contentPane;
	private JLabel labelLogo;
	private JLabel lblNewLabel;
	private JPanel panelLogin;
	private JButton btnConsulta;
	private JButton btnAbout;
	private JButton btnLogin;
	private JSeparator separator;

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

		ImageLoader.loadFrameIcon("/resources/image/FrameIcon.png", this);

		panelLogin = new JPanel();
		panelLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLogin.setBounds(47, 227, 190, 64);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);

		labelLogo = new JLabel();
		ImageLoader.loadJLabelImage("/resources/image/Logo.png", this, labelLogo);
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setBounds(17, 5, 250, 87);
		contentPane.add(labelLogo);

		btnConsulta = new JButton("Realizar Consulta");
		btnConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConsulta.setBounds(35, 126, 213, 72);
		contentPane.add(btnConsulta);

		btnAbout = new JButton("");
		ImageLoader.loadJButtonImage("/resources/image/AboutButton.png", this, btnAbout);
		btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAbout.setBounds(248, 261, 30, 30);
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

		mFrameController = new MainFrameController(this);
	}

	public MainFrameController getmFrameController() {
		return mFrameController;
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

	public void addActListener(ActionListener listener) {
		btnLogin.addActionListener(listener);
		btnAbout.addActionListener(listener);
		btnConsulta.addActionListener(listener);
	}
}
