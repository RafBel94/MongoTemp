package views;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import controllers.InsertFrameController;
import util.ImageLoader;

public class InsertFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private InsertFrameController iFrameController;
	private QueryFrame qFrame;
	private JLabel lblProvince;
	private JLabel lblYear;
	private JLabel lblMonth;
	private JLabel lblDay;
	private JLabel lblMinTemp;
	private JLabel lblMaxTemp;
	private JTextField fieldMinTemp;
	private JTextField fieldMaxTemp;
	private JTextField fieldYear;
	private JButton btnInsert;
	private JButton btnVolver;
	private JComboBox comboProvinces;
	private JComboBox comboMonths;
	private JSpinner spinnerDays;
	private JSeparator separator;

	/**
	 * Create the frame.
	 */
	public InsertFrame(QueryFrame qFrame) {
		super("Insertar datos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 394, 218);
		setResizable(false);
		setLocationRelativeTo(qFrame);
		getContentPane().setLayout(null);
		this.qFrame = qFrame;

		ImageLoader.loadFrameIcon("/resources/image/FrameIcon.png", this);

		lblProvince = new JLabel("Provincia:");
		lblProvince.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProvince.setBounds(14, 11, 81, 14);
		getContentPane().add(lblProvince);

		lblYear = new JLabel("Año:");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYear.setBounds(14, 38, 81, 14);
		getContentPane().add(lblYear);

		lblMonth = new JLabel("Mes:");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMonth.setBounds(14, 65, 81, 14);
		getContentPane().add(lblMonth);

		lblDay = new JLabel("Dia:");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDay.setBounds(14, 92, 81, 14);
		getContentPane().add(lblDay);

		lblMinTemp = new JLabel("Temp. Minima:");
		lblMinTemp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMinTemp.setBounds(205, 34, 110, 14);
		getContentPane().add(lblMinTemp);

		fieldMinTemp = new JTextField();
		fieldMinTemp.setColumns(10);
		fieldMinTemp.setBounds(315, 30, 53, 20);
		getContentPane().add(fieldMinTemp);

		lblMaxTemp = new JLabel("Temp. Maxima:");
		lblMaxTemp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaxTemp.setBounds(205, 63, 110, 14);
		getContentPane().add(lblMaxTemp);

		fieldMaxTemp = new JTextField();
		fieldMaxTemp.setColumns(10);
		fieldMaxTemp.setBounds(315, 59, 53, 20);
		getContentPane().add(fieldMaxTemp);

		btnInsert = new JButton("Insertar");
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInsert.setBounds(148, 140, 89, 28);
		getContentPane().add(btnInsert);

		btnVolver = new JButton("");
		ImageLoader.loadJButtonImage("/resources/image/Return25.png", this, btnVolver);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(337, 140, 28, 28);
		getContentPane().add(btnVolver);

		separator = new JSeparator();
		separator.setBounds(14, 130, 354, 8);
		getContentPane().add(separator);

		String[] provinces = { "Cadiz", "Malaga", "Sevilla", "Huelva", "Granada", "Cordoba", "Almeria", "Jaen" };
		comboProvinces = new JComboBox(provinces);
		comboProvinces.setBounds(79, 8, 86, 22);
		getContentPane().add(comboProvinces);

		String[] months = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		comboMonths = new JComboBox(months);
		comboMonths.setBounds(79, 62, 86, 22);
		getContentPane().add(comboMonths);

		spinnerDays = new JSpinner();
		spinnerDays.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDays.setBounds(79, 90, 45, 20);
		getContentPane().add(spinnerDays);

		fieldYear = new JTextField("2017");
		fieldYear.setBounds(79, 36, 86, 20);
		getContentPane().add(fieldYear);
		fieldYear.setColumns(10);

		setVisible(true);

		iFrameController = new InsertFrameController(this);
	}

	public void addActListener(ActionListener listener) {
		btnInsert.addActionListener(listener);
		btnVolver.addActionListener(listener);
	}

	public InsertFrameController getiFrameController() {
		return iFrameController;
	}

	public JTextField getFieldYear() {
		return fieldYear;
	}

	public QueryFrame getqFrame() {
		return qFrame;
	}

	public JTextField getFieldMinTemp() {
		return fieldMinTemp;
	}

	public JTextField getFieldMaxTemp() {
		return fieldMaxTemp;
	}

	public JButton getBtnInsert() {
		return btnInsert;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public JComboBox getComboProvinces() {
		return comboProvinces;
	}

	public JComboBox getComboMonths() {
		return comboMonths;
	}

	public JSpinner getSpinnerDays() {
		return spinnerDays;
	}

	public void setqFrame(QueryFrame qFrame) {
		this.qFrame = qFrame;
	}

	public void setFieldMinTemp(JTextField fieldMinTemp) {
		this.fieldMinTemp = fieldMinTemp;
	}

	public void setFieldMaxTemp(JTextField fieldMaxTemp) {
		this.fieldMaxTemp = fieldMaxTemp;
	}

	public void setBtnInsert(JButton btnInsert) {
		this.btnInsert = btnInsert;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public void setComboProvinces(JComboBox comboProvinces) {
		this.comboProvinces = comboProvinces;
	}

	public void setComboMonths(JComboBox comboMonths) {
		this.comboMonths = comboMonths;
	}

	public void setFieldYear(JTextField fieldYear) {
		this.fieldYear = fieldYear;
	}

	public void setSpinnerDays(JSpinner spinnerDays) {
		this.spinnerDays = spinnerDays;
	}
}
