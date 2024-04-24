package views;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.InitFrameController;

public class InitFrame extends JFrame {

	private static final long serialVersionUID = 1L;
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

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelLogo = new JLabel();
		labelLogo.setBounds(94, 23, 250, 78);
		labelLogo.setIcon(new ImageIcon("image/Logo.png"));
		contentPane.add(labelLogo);
		
		labelConectando = new JLabel("Conectando...");
		labelConectando.setHorizontalAlignment(SwingConstants.CENTER);
		labelConectando.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelConectando.setBounds(144, 112, 150, 14);
		contentPane.add(labelConectando);
		
		setVisible(true);

		Thread connectionThread = new Thread(new Runnable() {
			public void run() {
				InitFrameController controller = new InitFrameController();
				controller.connect();
				dispose();
			}
		});
		connectionThread.start();
	}
}
