package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import controllers.MapFrameController;
import util.ImageLoader;

public class MapFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame lastFrame;
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
	private JButton btnTodo;
	private JButton btnNada;
	
	public MapFrame(JFrame lastFrame) {
		setTitle("Seleccion de provincia");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 609, 517);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.lastFrame = lastFrame;
		
		ImageLoader.loadFrameIcon("/resources/image/FrameIcon.png", this);
		
		btnNada = new JButton("");
		btnNada.setToolTipText("Deseleccionar todo");
		ImageLoader.loadJButtonImage("/resources/image/DeselectAll.png", this, btnNada);
		btnNada.setBounds(548, 44, 26, 25);
		getContentPane().add(btnNada);
		
		btnTodo = new JButton("");
		btnTodo.setToolTipText("Seleccionar todo");
		ImageLoader.loadJButtonImage("/resources/image/SelectAll.png", this, btnTodo);
		btnTodo.setBounds(514, 44, 26, 25);
		getContentPane().add(btnTodo);
		
		cbAlmeria = new JCheckBox("");
		cbAlmeria.setToolTipText("Almeria");
		cbAlmeria.setBackground(new Color(233, 221, 175));
		cbAlmeria.setBounds(502, 268, 21, 23);
		getContentPane().add(cbAlmeria);
		
		cbMalaga = new JCheckBox("");
		cbMalaga.setToolTipText("Malaga");
		cbMalaga.setBackground(new Color(200, 183, 196));
		cbMalaga.setBounds(267, 295, 21, 23);
		getContentPane().add(cbMalaga);
		
		cbGranada = new JCheckBox("");
		cbGranada.setToolTipText("Granada");
		cbGranada.setBackground(new Color(233, 175, 175));
		cbGranada.setBounds(387, 260, 21, 23);
		getContentPane().add(cbGranada);
		
		cbJaen = new JCheckBox("");
		cbJaen.setToolTipText("Jaen");
		cbJaen.setBackground(new Color(233, 198, 175));
		cbJaen.setBounds(393, 162, 21, 23);
		getContentPane().add(cbJaen);
		
		cbCordoba = new JCheckBox("");
		cbCordoba.setToolTipText("Cordoba");
		cbCordoba.setBackground(new Color(175, 198, 233));
		cbCordoba.setBounds(269, 155, 21, 23);
		getContentPane().add(cbCordoba);
		
		cbCadiz = new JCheckBox("");
		cbCadiz.setToolTipText("Cadiz");
		cbCadiz.setBackground(new Color(175, 175, 233));
		cbCadiz.setBounds(156, 326, 21, 23);
		getContentPane().add(cbCadiz);
		
		cbSevilla = new JCheckBox("");
		cbSevilla.setToolTipText("Sevilla");
		cbSevilla.setBackground(new Color(183, 196, 200));
		getContentPane().add(cbSevilla);
		cbSevilla.setBounds(167, 218, 21, 23);
		
		cbHuelva = new JCheckBox("");
		cbHuelva.setToolTipText("Huelva");
		cbHuelva.setBackground(new Color(175, 221, 233));
		cbHuelva.setBounds(63, 208, 21, 23);
		getContentPane().add(cbHuelva);
		
		lblImagen = new JLabel();
		ImageLoader.loadJLabelImage("/resources/image/mapa.png", this, lblImagen);
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
		btnTodo.addActionListener(actionListener);
		btnNada.addActionListener(actionListener);
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
	
	public List<JCheckBox> getAllJCheckBox(){
		List<JCheckBox> list = new ArrayList<>();
		list.add(cbAlmeria);
		list.add(cbCordoba);
		list.add(cbHuelva);
		list.add(cbJaen);
		list.add(cbGranada);
		list.add(cbSevilla);
		list.add(cbCadiz);
		list.add(cbMalaga);
		
		return list;
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

	public JButton getBtnTodo() {
		return btnTodo;
	}

	public void setBtnTodo(JButton btnTodo) {
		this.btnTodo = btnTodo;
	}

	public JButton getBtnNada() {
		return btnNada;
	}

	public void setBtnNada(JButton btnNada) {
		this.btnNada = btnNada;
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

	public JFrame getLastFrame() {
		return lastFrame;
	}

	public void setLastFrame(JFrame lastFrame) {
		this.lastFrame = lastFrame;
	}
	
}
