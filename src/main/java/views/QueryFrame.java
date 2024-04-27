package views;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controllers.MapFrameController;
import controllers.QueryFrameController;

public class QueryFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
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
	
	public QueryFrame() {
		super("Consultas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 416);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Provincias");
		model.addColumn("Año");
		model.addColumn("Mes");
		model.addColumn("T.Min");
		model.addColumn("T.Max");
		model.addColumn("T.Media");
		for(JCheckBox cbx : MapFrameController.getJCheckBoxList()) {
			model.addRow(new Object[] {cbx.getToolTipText()});
		}
		
		JTable table = new JTable(model);
		table.setEnabled(false);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(15, 63, 495, 255);
		getContentPane().add(scrollPane);
		
		comboProv = new JComboBox();
		comboProv.setBounds(15, 30, 88, 22);
		getContentPane().add(comboProv);
		
		comboAnio = new JComboBox();
		comboAnio.setBounds(118, 30, 88, 22);
		getContentPane().add(comboAnio);
		
		comboMeses = new JComboBox();
		comboMeses.setBounds(221, 30, 88, 22);
		getContentPane().add(comboMeses);
		
		lblProv = new JLabel("Provincias");
		lblProv.setHorizontalAlignment(SwingConstants.CENTER);
		lblProv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProv.setBounds(15, 11, 88, 14);
		getContentPane().add(lblProv);
		
		lblAnios = new JLabel("Años");
		lblAnios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAnios.setBounds(116, 11, 88, 14);
		getContentPane().add(lblAnios);
		
		lblMeses = new JLabel("Meses");
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
		
		textMin = new JTextField();
		textMin.setBounds(324, 31, 86, 20);
		getContentPane().add(textMin);
		textMin.setColumns(10);
		
		textMax = new JTextField();
		textMax.setColumns(10);
		textMax.setBounds(425, 31, 86, 20);
		getContentPane().add(textMax);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(14, 341, 89, 25);
		getContentPane().add(btnVolver);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultar.setBounds(221, 341, 89, 25);
		getContentPane().add(btnConsultar);
		
		btnAyuda = new JButton("");
		btnAyuda.setIcon(new ImageIcon("image/Help.png"));
		btnAyuda.setBounds(484, 342, 26, 26);
		getContentPane().add(btnAyuda);
		
		separator = new JSeparator();
		separator.setBounds(15, 328, 495, 14);
		getContentPane().add(separator);
		
		setVisible(true);
		
		QueryFrameController qFrameController = new QueryFrameController(this);
	}
	
	public void addActListener(ActionListener listener) {
		btnAyuda.addActionListener(listener);
		btnConsultar.addActionListener(listener);
		btnVolver.addActionListener(listener);
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
}
