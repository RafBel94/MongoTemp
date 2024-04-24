package program;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class AdminFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnInsertar;
	private JLabel labelLogo;
	private JSeparator separator;
	/**
	 * Create the frame.
	 */
	public AdminFrame() {
		setTitle("Panel de administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditar.setBounds(43, 113, 152, 63);
		contentPane.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEliminar.setBounds(238, 113, 152, 63);
		contentPane.add(btnEliminar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsertar.setBounds(138, 187, 152, 63);
		contentPane.add(btnInsertar);
		
		labelLogo = new JLabel();
		labelLogo.setIcon(new ImageIcon("image/LogoAdmin.png"));
		labelLogo.setBounds(89, 15, 250, 62);
		contentPane.add(labelLogo);
		
		separator = new JSeparator();
		separator.setBounds(23, 91, 387, 11);
		contentPane.add(separator);
		
		setVisible(true);
	}

}
