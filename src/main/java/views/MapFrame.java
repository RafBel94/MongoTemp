package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import controllers.MapFrameController;

public class MapFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblImagen;
	private JSeparator separator;
	private JLabel lblSeleccion;
	private JSeparator separator_1;
	private JButton btnVolver;
	private JButton btnContinuar;
	private JCheckBox cbSevilla;
	private JCheckBox cbHuelva;
	private JCheckBox cbCadiz;
	private JCheckBox cbCordoba;
	private JCheckBox cbJaen;
	private JCheckBox cbGranada;
	private JCheckBox cbMalaga;
	private JCheckBox cbAlmeria;
	/**
	 * Create the frame.
	 */
	public MapFrame() {
		setTitle("Seleccion de provincia");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 609, 517);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		cbAlmeria = new JCheckBox("");
		cbAlmeria.setBackground(new Color(233, 221, 175));
		cbAlmeria.setBounds(502, 268, 21, 23);
		getContentPane().add(cbAlmeria);
		
		cbMalaga = new JCheckBox("");
		cbMalaga.setBackground(new Color(200, 183, 196));
		cbMalaga.setBounds(267, 295, 21, 23);
		getContentPane().add(cbMalaga);
		
		cbGranada = new JCheckBox("");
		cbGranada.setBackground(new Color(233, 175, 175));
		cbGranada.setBounds(387, 260, 21, 23);
		getContentPane().add(cbGranada);
		
		cbJaen = new JCheckBox("");
		cbJaen.setBackground(new Color(233, 198, 175));
		cbJaen.setBounds(393, 162, 21, 23);
		getContentPane().add(cbJaen);
		
		cbCordoba = new JCheckBox("");
		cbCordoba.setBackground(new Color(175, 198, 233));
		cbCordoba.setBounds(269, 155, 21, 23);
		getContentPane().add(cbCordoba);
		
		cbCadiz = new JCheckBox("");
		cbCadiz.setBackground(new Color(175, 175, 233));
		cbCadiz.setBounds(156, 326, 21, 23);
		getContentPane().add(cbCadiz);
		
		cbSevilla = new JCheckBox("");
		cbSevilla.setBackground(new Color(183, 196, 200));
		getContentPane().add(cbSevilla);
		cbSevilla.setBounds(167, 218, 21, 23);
		
		cbHuelva = new JCheckBox("");
		cbHuelva.setBackground(new Color(175, 221, 233));
		cbHuelva.setBounds(63, 208, 21, 23);
		getContentPane().add(cbHuelva);
		
		lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon("image/mapa.png"));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(4, 44, 584, 366);
		getContentPane().add(lblImagen);
		
		separator = new JSeparator();
		separator.setBounds(20, 36, 554, 9);
		getContentPane().add(separator);
		
		lblSeleccion = new JLabel("Selecciona las provincias sobre las que desea hacer la consulta");
		lblSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSeleccion.setBounds(83, 11, 429, 14);
		getContentPane().add(lblSeleccion);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(20, 419, 554, 9);
		getContentPane().add(separator_1);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(20, 439, 89, 23);
		getContentPane().add(btnVolver);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnContinuar.setBounds(476, 439, 98, 23);
		getContentPane().add(btnContinuar);
		
		setVisible(true);
		
		MapFrameController mFController = new MapFrameController(this);
	}
	
	public void addActListener(ActionListener actionListener) {
		btnContinuar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
	}
	
	public void addItmListener(ItemListener itmListener) {
		cbAlmeria.addItemListener(itmListener);
		cbCordoba.addItemListener(itmListener);
		cbHuelva.addItemListener(itmListener);
		cbJaen.addItemListener(itmListener);
		cbGranada.addItemListener(itmListener);
		cbSevilla.addItemListener(itmListener);
		cbCadiz.addItemListener(itmListener);
		cbMalaga.addItemListener(itmListener);
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnContinuar() {
		return btnContinuar;
	}

	public void setBtnContinuar(JButton btnContinuar) {
		this.btnContinuar = btnContinuar;
	}

	public JCheckBox getCbSevilla() {
		return cbSevilla;
	}

	public void setCbSevilla(JCheckBox cbSevilla) {
		this.cbSevilla = cbSevilla;
	}

	public JCheckBox getCbHuelva() {
		return cbHuelva;
	}

	public void setCbHuelva(JCheckBox cbHuelva) {
		this.cbHuelva = cbHuelva;
	}

	public JCheckBox getCbCadiz() {
		return cbCadiz;
	}

	public void setCbCadiz(JCheckBox cbCadiz) {
		this.cbCadiz = cbCadiz;
	}

	public JCheckBox getCbCordoba() {
		return cbCordoba;
	}

	public void setCbCordoba(JCheckBox cbCordoba) {
		this.cbCordoba = cbCordoba;
	}

	public JCheckBox getCbJaen() {
		return cbJaen;
	}

	public void setCbJaen(JCheckBox cbJaen) {
		this.cbJaen = cbJaen;
	}

	public JCheckBox getCbGranada() {
		return cbGranada;
	}

	public void setCbGranada(JCheckBox cbGranada) {
		this.cbGranada = cbGranada;
	}

	public JCheckBox getCbMalaga() {
		return cbMalaga;
	}

	public void setCbMalaga(JCheckBox cbMalaga) {
		this.cbMalaga = cbMalaga;
	}

	public JCheckBox getCbAlmeria() {
		return cbAlmeria;
	}

	public void setCbAlmeria(JCheckBox cbAlmeria) {
		this.cbAlmeria = cbAlmeria;
	}
	
}
