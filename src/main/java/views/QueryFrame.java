package views;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QueryFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	
	public QueryFrame(List<JCheckBox> cbxList) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Provincia");
		for(JCheckBox cbx : cbxList) {
			model.addRow(new Object[] {cbx.getToolTipText()});
		}
		
		JTable table = new JTable(model);
		table.setEnabled(false);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 138, 239);
		getContentPane().add(scrollPane);
		
		setVisible(true);
	}
}
