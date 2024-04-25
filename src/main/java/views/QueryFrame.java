package views;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.MapFrameController;

public class QueryFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	
	public QueryFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Provincias");
		for(JCheckBox cbx : MapFrameController.getJCheckBoxList()) {
			model.addRow(new Object[] {cbx.getToolTipText()});
		}
		
		JTable table = new JTable(model);
		table.setEnabled(false);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 138, 153);
		getContentPane().add(scrollPane);
		
		setVisible(true);
	}
}
