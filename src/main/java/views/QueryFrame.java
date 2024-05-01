package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controllers.QueryFrameController;
import util.ImageLoader;

public class QueryFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	QueryFrameController qFrameController;
	private JScrollPane scrollPane;
	private JFrame mapOwner;
	private JComboBox comboProv;
	private JComboBox comboAnio;
	private JComboBox comboMeses;
	private JLabel lblProv;
	private JLabel lblAnios;
	private JLabel lblMeses;
	private JLabel lblMin;
	private JLabel lblMax;
	private JTextField textMin;
	private JTextField textMax;
	private JSeparator separator;
	private JButton btnVolver;
	private JButton btnConsultar;
	private JButton btnAyuda;
	private JTextField textMinimaTotal;
	private JTextField textMaximaTotal;
	private JTextField textMediaTotal;
	private JLabel lblMinimaTotal;
	private JLabel lblTempMaxima;
	private JLabel lblMediaTotal;
	private JPanel adminPanel;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnInsertar;
	private JLabel lblAdminTools;
	
	public QueryFrame(JFrame mapOwner) {
		super("Consultas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 513);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		this.mapOwner = mapOwner;
		
		ImageLoader.loadFrameIcon("/resources/image/FrameIcon.png", this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 63, 495, 247);
		getContentPane().add(scrollPane);
		
		comboProv = new JComboBox();
		comboProv.setBounds(15, 30, 88, 22);
		getContentPane().add(comboProv);
		
		comboAnio = new JComboBox();
		comboAnio.setMaximumRowCount(5);
		comboAnio.setBounds(118, 30, 88, 22);
		getContentPane().add(comboAnio);
		
		comboMeses = new JComboBox();
		comboMeses.setBounds(221, 30, 88, 22);
		getContentPane().add(comboMeses);
		
		lblProv = new JLabel("Provincia");
		lblProv.setHorizontalAlignment(SwingConstants.CENTER);
		lblProv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProv.setBounds(15, 11, 88, 14);
		getContentPane().add(lblProv);
		
		lblAnios = new JLabel("Año");
		lblAnios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAnios.setBounds(116, 11, 88, 14);
		getContentPane().add(lblAnios);
		
		lblMeses = new JLabel("Mes");
		lblMeses.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeses.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMeses.setBounds(218, 12, 88, 14);
		getContentPane().add(lblMeses);
		
		lblMin = new JLabel("T.Minima");
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMin.setBounds(320, 12, 88, 14);
		getContentPane().add(lblMin);
		
		lblMax = new JLabel("T.Maxima");
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMax.setBounds(422, 12, 88, 14);
		getContentPane().add(lblMax);

		lblMinimaTotal = new JLabel("Temp. Minima:");
		lblMinimaTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMinimaTotal.setBounds(89, 321, 94, 19);
		getContentPane().add(lblMinimaTotal);
		
		lblTempMaxima = new JLabel("Temp. Maxima:");
		lblTempMaxima.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTempMaxima.setBounds(239, 321, 88, 19);
		getContentPane().add(lblTempMaxima);
		
		lblMediaTotal = new JLabel("Temp. Media:");
		lblMediaTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMediaTotal.setBounds(386, 321, 88, 19);
		getContentPane().add(lblMediaTotal);
		
		textMin = new JTextField();
		textMin.setBounds(324, 31, 86, 20);
		getContentPane().add(textMin);
		textMin.setColumns(10);
		
		textMax = new JTextField();
		textMax.setColumns(10);
		textMax.setBounds(425, 31, 86, 20);
		getContentPane().add(textMax);
		
		textMinimaTotal = new JTextField();
		textMinimaTotal.setEditable(false);
		textMinimaTotal.setColumns(10);
		textMinimaTotal.setBounds(177, 321, 45, 20);
		getContentPane().add(textMinimaTotal);
		
		textMaximaTotal = new JTextField();
		textMaximaTotal.setEditable(false);
		textMaximaTotal.setColumns(10);
		textMaximaTotal.setBounds(325, 321, 45, 20);
		getContentPane().add(textMaximaTotal);
		
		textMediaTotal = new JTextField();
		textMediaTotal.setEditable(false);
		textMediaTotal.setColumns(10);
		textMediaTotal.setBounds(465, 321, 45, 20);
		getContentPane().add(textMediaTotal);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(15, 363, 89, 25);
		getContentPane().add(btnVolver);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultar.setBounds(222, 363, 89, 25);
		getContentPane().add(btnConsultar);
		
		btnAyuda = new JButton("");
		ImageLoader.loadJButtonImage("/resources/image/Help.png", this, btnAyuda);
		btnAyuda.setBounds(485, 362, 26, 26);
		getContentPane().add(btnAyuda);
		
		separator = new JSeparator();
		separator.setBounds(16, 351, 495, 14);
		getContentPane().add(separator);
		
		adminPanel = new JPanel();
		adminPanel.setBorder(new LineBorder(new Color(153, 180, 209)));
		adminPanel.setBounds(15, 399, 502, 68);
		getContentPane().add(adminPanel);
		adminPanel.setLayout(null);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEditar.setBounds(352, 34, 89, 23);
		adminPanel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminar.setBounds(205, 34, 89, 23);
		adminPanel.add(btnEliminar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInsertar.setBounds(58, 34, 89, 23);
		adminPanel.add(btnInsertar);
		
		lblAdminTools = new JLabel("Herramientas de administrador");
		lblAdminTools.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminTools.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdminTools.setBounds(145, 7, 212, 14);
		adminPanel.add(lblAdminTools);
		
		if(mapOwner instanceof MainFrame) {
			btnInsertar.setEnabled(false);
			btnEliminar.setEnabled(false);
			btnEditar.setEnabled(false);
		}
		
		setVisible(true);
		
		qFrameController = new QueryFrameController(this);
	}
	
	public void addActListener(ActionListener listener) {
		btnAyuda.addActionListener(listener);
		btnConsultar.addActionListener(listener);
		btnVolver.addActionListener(listener);
		btnEditar.addActionListener(listener);
		btnEliminar.addActionListener(listener);
		btnInsertar.addActionListener(listener);
	}
	
	public void addItmListener(ItemListener listener) {
		comboProv.addItemListener(listener);
		comboAnio.addItemListener(listener);
		comboMeses.addItemListener(listener);
	}

	// GETTERS Y SETTERS
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public QueryFrameController getqFrameController() {
		return qFrameController;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JComboBox getComboProv() {
		return comboProv;
	}

	public void setComboProv(JComboBox comboProv) {
		this.comboProv = comboProv;
	}

	public JComboBox getComboAnio() {
		return comboAnio;
	}

	public void setComboAnio(JComboBox comboAnio) {
		this.comboAnio = comboAnio;
	}

	public JComboBox getComboMeses() {
		return comboMeses;
	}

	public void setComboMeses(JComboBox comboMeses) {
		this.comboMeses = comboMeses;
	}

	public JTextField getTextMinimaTotal() {
		return textMinimaTotal;
	}

	public void setTextMinimaTotal(JTextField textMinimaTotal) {
		this.textMinimaTotal = textMinimaTotal;
	}

	public JTextField getTextMaximaTotal() {
		return textMaximaTotal;
	}

	public void setTextMaximaTotal(JTextField textMaximaTotal) {
		this.textMaximaTotal = textMaximaTotal;
	}

	public JTextField getTextMediaTotal() {
		return textMediaTotal;
	}

	public void setTextMediaTotal(JTextField textMediaTotal) {
		this.textMediaTotal = textMediaTotal;
	}

	public JTextField getTextMin() {
		return textMin;
	}

	public void setTextMin(JTextField textMin) {
		this.textMin = textMin;
	}

	public JTextField getTextMax() {
		return textMax;
	}

	public void setTextMax(JTextField textMax) {
		this.textMax = textMax;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(JButton btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public JButton getBtnAyuda() {
		return btnAyuda;
	}

	public void setBtnAyuda(JButton btnAyuda) {
		this.btnAyuda = btnAyuda;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
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

	public JFrame getMapOwner() {
		return mapOwner;
	}

	public void setMapOwner(JFrame mapOwner) {
		this.mapOwner = mapOwner;
	}
}
