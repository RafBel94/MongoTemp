package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controllers.AdminFrameController;

public class AdminFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnInsertar;
	private JButton btnVolver;
	private JLabel labelLogo;
	private JSeparator separator;
	private JButton btnConsulta;
	private JPanel buttonPanel;

	/**
	 * Create the frame.
	 */
	public AdminFrame(){
		setTitle("Panel de administrador");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 372);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		try (InputStream stream = getClass().getResourceAsStream("/resources/image/FrameIcon.png")){
			setIconImage(new ImageIcon(ImageIO.read(stream)).getImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 103, 271, 229);
		getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new BtnEditarActionListener());
		btnActualizar.setBounds(65, 65, 141, 41);
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonPanel.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(65, 171, 141, 41);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonPanel.add(btnEliminar);

		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(65, 118, 141, 41);
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonPanel.add(btnInsertar);

		btnConsulta = new JButton("Consulta");
		btnConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConsulta.setBounds(65, 12, 141, 41);
		buttonPanel.add(btnConsulta);

		btnVolver = new JButton("");
		try (InputStream stream = getClass().getResourceAsStream("/resources/image/Return.png")){
			btnVolver.setIcon(new ImageIcon(ImageIO.read(stream)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		btnVolver.setBounds(237, 178, 34, 34);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonPanel.add(btnVolver);

		labelLogo = new JLabel();
		labelLogo.setBounds(23, 16, 250, 62);
		try (InputStream stream = getClass().getResourceAsStream("/resources/image/LogoAdmin.png")){
			labelLogo.setIcon(new ImageIcon(ImageIO.read(stream)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		getContentPane().add(labelLogo);

		separator = new JSeparator();
		separator.setBounds(12, 91, 271, 11);
		getContentPane().add(separator);

		setVisible(true);

		AdminFrameController adFrameController = new AdminFrameController(this);
	}

	public void addListeners(ActionListener actionListener) {
		btnActualizar.addActionListener(actionListener);
		btnEliminar.addActionListener(actionListener);
		btnInsertar.addActionListener(actionListener);
		btnConsulta.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnEditar) {
		this.btnActualizar = btnEditar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnInsertar() {
		return btnInsertar;
	}

	public void setBtnInsertar(JButton btnInsertar) {
		this.btnInsertar = btnInsertar;
	}

	public JButton getBtnConsulta() {
		return btnConsulta;
	}

	public void setBtnConsulta(JButton btnConsulta) {
		this.btnConsulta = btnConsulta;
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

	private class BtnEditarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
}
