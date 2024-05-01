package views;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import util.ImageLoader;

public class AboutFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblLogo;
	private JSeparator separator;
	private JLabel lblAbout;
	private JLabel lblRafael;
	private JSeparator separator_1;
	private JLabel lblDesarrollo;
	private JLabel lblCollabs;
	private JLabel lblAlejandro;
	private JSeparator separator_2;
	private JLabel lblAntonio;
	public AboutFrame() {
		super("Acerca de MongoTemp...");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 415);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		ImageLoader.loadFrameIcon("/resources/image/FrameIcon.png", this);
		
		
		lblLogo = new JLabel("");
		ImageLoader.loadJLabelImage("/resources/image/LogoAbout.png", this, lblLogo);
		lblLogo.setBounds(142, 22, 150, 150);
		getContentPane().add(lblLogo);
		
		separator = new JSeparator();
		separator.setBounds(25, 189, 383, 9);
		getContentPane().add(separator);
		
		lblAbout = new JLabel("Acerca de MongoTemp");
		lblAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAbout.setBounds(89, 196, 255, 25);
		getContentPane().add(lblAbout);
		
		lblRafael = new JLabel("Rafael Beltran Caceres");
		lblRafael.setHorizontalAlignment(SwingConstants.CENTER);
		lblRafael.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRafael.setBounds(133, 264, 166, 21);
		getContentPane().add(lblRafael);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(136, 230, 161, 9);
		getContentPane().add(separator_1);
		
		lblDesarrollo = new JLabel("Desarrollador del Software");
		lblDesarrollo.setForeground(Color.BLUE);
		lblDesarrollo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesarrollo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesarrollo.setBounds(107, 240, 219, 14);
		getContentPane().add(lblDesarrollo);
		
		lblCollabs = new JLabel("Documentacion");
		lblCollabs.setHorizontalAlignment(SwingConstants.CENTER);
		lblCollabs.setForeground(Color.BLUE);
		lblCollabs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCollabs.setBounds(107, 307, 219, 14);
		getContentPane().add(lblCollabs);
		
		lblAlejandro = new JLabel("Alejandro Fernandez Franco");
		lblAlejandro.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlejandro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlejandro.setBounds(120, 323, 192, 22);
		getContentPane().add(lblAlejandro);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(136, 292, 161, 9);
		getContentPane().add(separator_2);
		
		lblAntonio = new JLabel("Antonio Sanchez Rosales");
		lblAntonio.setHorizontalAlignment(SwingConstants.CENTER);
		lblAntonio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAntonio.setBounds(120, 345, 192, 22);
		getContentPane().add(lblAntonio);
		
		setVisible(true);
	}

}
