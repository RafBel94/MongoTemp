package views;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.InitFrameController;
import util.ImageLoader;

public class InitFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private InitFrameController controller;
	private JPanel contentPane;
	private JLabel labelLogo;
	private JLabel labelConectando;

	/**
	 * Create the frame.
	 */
	public InitFrame() {
		super("MongoTemp");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 184);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		ImageLoader.loadFrameIcon("/resources/image/FrameIcon.png", this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		labelLogo = new JLabel();
		labelLogo.setBounds(94, 23, 250, 78);
		ImageLoader.loadJLabelImage("/resources/image/Logo.png", this, labelLogo);
		contentPane.add(labelLogo);

		labelConectando = new JLabel("Conectando...");
		labelConectando.setHorizontalAlignment(SwingConstants.CENTER);
		labelConectando.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelConectando.setBounds(144, 112, 150, 14);
		contentPane.add(labelConectando);

		setVisible(true);

		Thread connectionThread = new Thread(new Runnable() {
			public void run() {
				controller = new InitFrameController();
				controller.connect();
				dispose();
			}
		});
		connectionThread.start();
	}

	public InitFrameController getController() {
		return controller;
	}

	public JLabel getLabelLogo() {
		return labelLogo;
	}

	public JLabel getLabelConectando() {
		return labelConectando;
	}

	public void setLabelLogo(JLabel labelLogo) {
		this.labelLogo = labelLogo;
	}

	public void setLabelConectando(JLabel labelConectando) {
		this.labelConectando = labelConectando;
	}

}
