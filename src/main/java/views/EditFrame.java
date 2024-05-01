package views;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controllers.EditFrameController;
import controllers.QueryFrameController;
import util.ImageLoader;

public class EditFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private QueryFrameController qFrameController;
	private JTextField fieldProvince;
	private JLabel lblProvince;
	private JLabel lblAge;
	private JTextField fieldAge;
	private JLabel lblMonth;
	private JTextField fieldMonth;
	private JLabel lblDay;
	private JTextField fieldDay;
	private JPanel panel;
	private JLabel lblMinTempNow;
	private JTextField fieldTempMinNow;
	private JLabel lblMaxTempNow;
	private JTextField fieldTempMaxNow;
	private JLabel lblTempMinNew;
	private JTextField fieldTempMinNew;
	private JLabel lblTempMaxNew;
	private JTextField fieldTempMaxNew;
	private JButton btnApply;
	private JButton btnVolver;
	public EditFrame(QueryFrameController qFrameController) {
		setTitle("Editar temperatura");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 246);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		this.qFrameController = qFrameController;
		
		ImageLoader.loadFrameIcon("/resources/image/FrameIcon.png", this);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.activeCaption));
		panel.setBounds(10, 59, 414, 103);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		fieldProvince = new JTextField();
		fieldProvince.setHorizontalAlignment(SwingConstants.CENTER);
		fieldProvince.setEditable(false);
		fieldProvince.setBounds(10, 28, 85, 20);
		getContentPane().add(fieldProvince);
		fieldProvince.setColumns(10);
		
		fieldAge = new JTextField();
		fieldAge.setHorizontalAlignment(SwingConstants.CENTER);
		fieldAge.setEditable(false);
		fieldAge.setColumns(10);
		fieldAge.setBounds(121, 28, 83, 20);
		getContentPane().add(fieldAge);
		
		fieldMonth = new JTextField();
		fieldMonth.setHorizontalAlignment(SwingConstants.CENTER);
		fieldMonth.setEditable(false);
		fieldMonth.setColumns(10);
		fieldMonth.setBounds(230, 28, 88, 20);
		getContentPane().add(fieldMonth);
		
		fieldDay = new JTextField();
		fieldDay.setHorizontalAlignment(SwingConstants.CENTER);
		fieldDay.setEditable(false);
		fieldDay.setColumns(10);
		fieldDay.setBounds(344, 28, 80, 20);
		getContentPane().add(fieldDay);
		
		fieldTempMinNow = new JTextField();
		fieldTempMinNow.setHorizontalAlignment(SwingConstants.CENTER);
		fieldTempMinNow.setEditable(false);
		fieldTempMinNow.setColumns(10);
		fieldTempMinNow.setBounds(126, 23, 65, 20);
		panel.add(fieldTempMinNow);
		
		fieldTempMinNew = new JTextField();
		fieldTempMinNew.setHorizontalAlignment(SwingConstants.CENTER);
		fieldTempMinNew.setColumns(10);
		fieldTempMinNew.setBounds(334, 23, 65, 20);
		panel.add(fieldTempMinNew);
		
		fieldTempMaxNew = new JTextField();
		fieldTempMaxNew.setHorizontalAlignment(SwingConstants.CENTER);
		fieldTempMaxNew.setColumns(10);
		fieldTempMaxNew.setBounds(334, 62, 65, 20);
		panel.add(fieldTempMaxNew);
		
		lblProvince = new JLabel("Provincia");
		lblProvince.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProvince.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvince.setBounds(10, 11, 85, 14);
		getContentPane().add(lblProvince);
		
		lblAge = new JLabel("Año");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAge.setBounds(121, 11, 83, 14);
		getContentPane().add(lblAge);
		
		lblMonth = new JLabel("Mes");
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMonth.setBounds(230, 11, 88, 14);
		getContentPane().add(lblMonth);
		
		lblMinTempNow = new JLabel("Tem.Min. Actual:");
		lblMinTempNow.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinTempNow.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMinTempNow.setBounds(5, 25, 129, 14);
		panel.add(lblMinTempNow);
		
		lblMaxTempNow = new JLabel("Tem.Max. Actual:");
		lblMaxTempNow.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxTempNow.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaxTempNow.setBounds(5, 64, 129, 14);
		panel.add(lblMaxTempNow);
		
		lblTempMaxNew = new JLabel("Tem.Max. Nueva:");
		lblTempMaxNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempMaxNew.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTempMaxNew.setBounds(209, 64, 129, 14);
		panel.add(lblTempMaxNew);
		
		lblDay = new JLabel("Dia");
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDay.setBounds(344, 11, 80, 14);
		getContentPane().add(lblDay);
		
		fieldTempMaxNow = new JTextField();
		fieldTempMaxNow.setHorizontalAlignment(SwingConstants.CENTER);
		fieldTempMaxNow.setEditable(false);
		fieldTempMaxNow.setColumns(10);
		fieldTempMaxNow.setBounds(126, 62, 65, 20);
		panel.add(fieldTempMaxNow);
		
		lblTempMinNew = new JLabel("Tem.Min. Nueva:");
		lblTempMinNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempMinNew.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTempMinNew.setBounds(209, 25, 129, 14);
		panel.add(lblTempMinNew);
		
		btnApply = new JButton("Aplicar");
		btnApply.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnApply.setBounds(171, 170, 89, 28);
		getContentPane().add(btnApply);
		
		btnVolver = new JButton("");
		ImageLoader.loadJButtonImage("/resources/image/Return25.png", this, btnVolver);
		btnVolver.setBounds(399, 170, 28, 28);
		getContentPane().add(btnVolver);
		
		setVisible(true);
		
		setFields();
		
		EditFrameController eFrameController = new EditFrameController(this);
	}
	
	private void setFields() {
		JTable table = qFrameController.getTable();
		
		int selectedRow = table.getSelectedRow();
		if(selectedRow != -1) {
			String province = String.valueOf(table.getValueAt(selectedRow, 0));
			String age = String.valueOf(table.getValueAt(selectedRow, 1));
			String month = String.valueOf(table.getValueAt(selectedRow, 2));
			String day = String.valueOf(table.getValueAt(selectedRow, 3));
			String minTemp = String.valueOf(table.getValueAt(selectedRow, 4));
			String maxTemp = String.valueOf(table.getValueAt(selectedRow, 5));
			
			fieldProvince.setText(province);
			fieldAge.setText(age);
			fieldMonth.setText(month);
			fieldDay.setText(day);
			fieldTempMinNow.setText(minTemp);
			fieldTempMaxNow.setText(maxTemp);
		}else
			JOptionPane.showMessageDialog(EditFrame.this, "Debe seleccionar una fila de una consulta para poder editar","Error",JOptionPane.ERROR_MESSAGE);
	}

	public void addActListener(ActionListener listener) {
		btnApply.addActionListener(listener);
		btnVolver.addActionListener(listener);
	}

	public JTextField getFieldProvince() {
		return fieldProvince;
	}

	public JTextField getFieldAge() {
		return fieldAge;
	}

	public JTextField getFieldMonth() {
		return fieldMonth;
	}

	public JTextField getFieldDay() {
		return fieldDay;
	}

	public JTextField getFieldTempMinNow() {
		return fieldTempMinNow;
	}

	public JTextField getFieldTempMaxNow() {
		return fieldTempMaxNow;
	}

	public JTextField getFieldTempMinNew() {
		return fieldTempMinNew;
	}

	public JTextField getFieldTempMaxNew() {
		return fieldTempMaxNew;
	}

	public JButton getBtnApply() {
		return btnApply;
	}

	public QueryFrameController getqFrameController() {
		return qFrameController;
	}

	public void setqFrameController(QueryFrameController qFrameController) {
		this.qFrameController = qFrameController;
	}

	public void setFieldProvince(JTextField fieldProvince) {
		this.fieldProvince = fieldProvince;
	}

	public void setFieldAge(JTextField fieldAge) {
		this.fieldAge = fieldAge;
	}

	public void setFieldMonth(JTextField fieldMonth) {
		this.fieldMonth = fieldMonth;
	}

	public void setFieldDay(JTextField fieldDay) {
		this.fieldDay = fieldDay;
	}

	public void setFieldTempMinNow(JTextField fieldTempMinNow) {
		this.fieldTempMinNow = fieldTempMinNow;
	}

	public void setFieldTempMaxNow(JTextField fieldTempMaxNow) {
		this.fieldTempMaxNow = fieldTempMaxNow;
	}

	public void setFieldTempMinNew(JTextField fieldTempMinNew) {
		this.fieldTempMinNew = fieldTempMinNew;
	}

	public void setFieldTempMaxNew(JTextField fieldTempMaxNew) {
		this.fieldTempMaxNew = fieldTempMaxNew;
	}

	public void setBtnApply(JButton btnApply) {
		this.btnApply = btnApply;
	}
}
