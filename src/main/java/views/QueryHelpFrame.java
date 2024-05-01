package views;

import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import util.ImageLoader;

public class QueryHelpFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblImagen;
	private JLabel lblMinTemp;
	private JScrollPane scrollPane;
	private JTextArea tAreaMinTemp;
	private JLabel lblMaxTemp;
	private JScrollPane scrollPane_1;
	private JTextArea tAreaMaxTemp;
	
	public QueryHelpFrame() {
		super("Ventana de ayuda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 331);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		ImageLoader.loadFrameIcon("/resources/image/FrameIcon.png", this);
		
		lblImagen = new JLabel("");
		ImageLoader.loadJLabelImage("/resources/image/Help55.png", this, lblImagen);
		lblImagen.setBounds(189, 18, 55, 57);
		getContentPane().add(lblImagen);
		
		lblMinTemp = new JLabel("Temperatura minima");
		lblMinTemp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMinTemp.setBounds(10, 91, 137, 14);
		getContentPane().add(lblMinTemp);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 109, 414, 70);
		getContentPane().add(scrollPane);
		
		tAreaMinTemp = new JTextArea();
		tAreaMinTemp.setEditable(false);
		tAreaMinTemp.setFont(new Font("Monospaced", Font.PLAIN, 11));
		tAreaMinTemp.setText("En este campo puede establecer una temperatura minima por la cual filtrar los resultados. \r\nEstablecer un valor en este campo hara que solo se muestren resultados que tengan el mismo valor o sea superior.\r\nSi no establece ningun valor, no se aplicara ningun filtro.");
		tAreaMinTemp.setLineWrap(true);
		scrollPane.setViewportView(tAreaMinTemp);
		
		lblMaxTemp = new JLabel("Temperatura maxima");
		lblMaxTemp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaxTemp.setBounds(10, 190, 137, 14);
		getContentPane().add(lblMaxTemp);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 207, 414, 70);
		getContentPane().add(scrollPane_1);
		
		tAreaMaxTemp = new JTextArea();
		tAreaMaxTemp.setEditable(false);
		tAreaMaxTemp.setLineWrap(true);
		tAreaMaxTemp.setFont(new Font("Monospaced", Font.PLAIN, 11));
		tAreaMaxTemp.setText("En este campo puede establecer una temperatura maxima por la cual filtrar los resultados. \r\nEstablecer un valor en este campo hara que solo se muestren resultados que tengan el mismo valor o sea inferior.\r\nSi no establece ningun valor, no se aplicara ningun filtro.");
		scrollPane_1.setViewportView(tAreaMaxTemp);
		
		setVisible(true);
	}
}
