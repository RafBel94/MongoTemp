package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import util.MongoDBConnection;
import views.MapFrame;
import views.QueryFrame;
import views.QueryHelpFrame;

public class QueryFrameController {
	private DefaultTableModel model;
	private JTable table;
	private QueryFrame qFrame;

	public QueryFrameController(QueryFrame qFrame) {
		this.qFrame = qFrame;
		
		this.qFrame.addActListener(new ActListener());
		this.qFrame.addItmListener(new ItmListener());
		
		setCombos();
		setInitialJTable();
	}
	
	//////////
	// METHODS
	
	public void setInitialJTable() {
		model = new DefaultTableModel();
		model.addColumn("Provincias");
		model.addColumn("Año");
		model.addColumn("Mes");
		model.addColumn(("Dia"));
		model.addColumn("T.Min");
		model.addColumn("T.Max");
		model.addColumn("T.Media");
		
		for(int i = 0 ; i < 14 ; i++) {
			model.addRow(new Object[] {"","","","","",""});
		}
		
		table = new JTable(model);
		table.setEnabled(false);
		
		qFrame.getScrollPane().getViewport().add(table);
	}
	
	public void setCombos() {
		// Provinces JComboBox Set
		List<JCheckBox> provincesList = MapFrameController.getJCheckBoxList();
		for(int i = 0 ; i < provincesList.size() ; i ++) {
			qFrame.getComboProv().addItem(provincesList.get(i).getToolTipText());
		}
		
		// Ages JComboBox Set
		String [] ages = {"2017","2018","2019","2020"};
		for(String m : ages) {
			qFrame.getComboAnio().addItem(m);
		}
		
		// Months JComboBox Set
		String [] months = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		for(String m : months) {
			qFrame.getComboMeses().addItem(m);
		}
	}
	
	
	//////////////////
	// PRIVATE CLASSES
	
	private class ActListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == qFrame.getBtnVolver()) {
				qFrame.dispose();
				MapFrameController.getJCheckBoxList().clear();
				new MapFrame();
			}else if (obj == qFrame.getBtnConsultar()) {
				MongoDBConnection conn = MongoDBConnection.getInstance();
				MongoDatabase db = conn.getDatabase();
				MongoCollection<Document> collection = db.getCollection("temperatures");
				
				String province = (String) qFrame.getComboProv().getSelectedItem();
				int age = Integer.parseInt((String) qFrame.getComboAnio().getSelectedItem());
				String month = (String) qFrame.getComboMeses().getSelectedItem();
				
				if(checkTempBoxValues() == -1) {
					JOptionPane.showMessageDialog(qFrame, "Los limites de las temperaturas no pueden ser valores decimales o caracteres");
				} else if(checkTempBoxValues() == 0) {
					noTempFilterQuery(collection,province,age,month);
				} else if (checkTempBoxValues() == 1) {
					maxTempFilterQuery(collection,province,age,month);
				} else if(checkTempBoxValues() == 2) {
					minTempFilterQuery(collection,province,age,month);
				} else if(checkTempBoxValues() == 3) {
					bothTempFilterQuery(collection,province,age,month);
				}
			}else if (obj == qFrame.getBtnAyuda()) {
				new QueryHelpFrame();
			}
		}
		
		private void bothTempFilterQuery(MongoCollection<Document> collection, String province, int age, String month) {
			Document maxTempFilter = new Document("$lte",Integer.parseInt(qFrame.getTextMax().getText()));
			Document minTempFilter = new Document("$gte",Integer.parseInt(qFrame.getTextMin().getText()));
			Document filter = new Document("provincia",province).append("anio", age).append("mes", month).append("minTemp", minTempFilter).append("maxTemp", maxTempFilter);
			makeQuery(filter, collection, province, age, month);
		}

		private void maxTempFilterQuery(MongoCollection<Document> collection, String province, int age, String month) {
			Document maxTempFilter = new Document("$lte",Integer.parseInt(qFrame.getTextMax().getText()));
			Document filter = new Document("provincia",province).append("anio", age).append("mes", month).append("maxTemp", maxTempFilter);
			makeQuery(filter, collection, province, age, month);
		}

		private void minTempFilterQuery(MongoCollection<Document> collection, String province, int age, String month) {
			Document minTempFilter = new Document("$gte",Integer.parseInt(qFrame.getTextMin().getText()));
			Document filter = new Document("provincia",province).append("anio", age).append("mes", month).append("minTemp", minTempFilter);
			makeQuery(filter, collection, province, age, month);
		}

		private void noTempFilterQuery(MongoCollection collection, String province, int age, String month) {
			Document filter = new Document("provincia",province).append("anio", age).append("mes", month);
			makeQuery(filter, collection, province, age, month);
		}
		
		private void makeQuery(Document document, MongoCollection collection, String province, int age, String month) {
			MongoCursor<Document> docList = collection.find(document).iterator();
			
			// Limpiamos la tabla
			model.setRowCount(0);
			
			int contTemp = 0;
			int minTotal = Integer.MAX_VALUE;
			int maxTotal = Integer.MIN_VALUE;
			int monthAvg = 0;
			
			while(docList.hasNext()) {
				Document doc = docList.next();
				
				// Coger valores
				int minTemp = Integer.parseInt(String.valueOf(doc.get("minTemp")));
				int maxTemp = Integer.parseInt(String.valueOf(doc.get("maxTemp")));
				double avgTemp = (minTemp + maxTemp) /(double) 2;
				String strAvgTemp = String.format("%.2f", avgTemp);
				
				// Agregar fila
				model.addRow(new Object [] {doc.get("provincia"),doc.get("anio"),doc.get("mes"),doc.get("dia"),doc.get("minTemp"),doc.get("maxTemp"),strAvgTemp});
				
				// Comprobacion de minima y maxima
				if(minTemp < minTotal)
					minTotal = minTemp;
				if(maxTemp > maxTotal)
					maxTotal = maxTemp;
				
				// Suma de medias para calculo de media total
				monthAvg += avgTemp;
				
				contTemp++;
			}
			
			// Calculo y asignacion a los JTextFields
			if(contTemp != 0) {
				String avgTotalTemp = String.format("%.1f", monthAvg / (float)contTemp);
				qFrame.getTextMinimaTotal().setText(String.valueOf(minTotal));
				qFrame.getTextMaximaTotal().setText(String.valueOf(maxTotal));
				qFrame.getTextMediaTotal().setText(avgTotalTemp);
			}else {
				qFrame.getTextMinimaTotal().setText("0");
				qFrame.getTextMaximaTotal().setText("0");
				qFrame.getTextMediaTotal().setText("0");
			}
			
			// Actualizamos la ventana para mostrar la nueva informacion
			qFrame.getScrollPane().getParent().revalidate();
			qFrame.getScrollPane().getParent().repaint();
		}
		
		private int checkTempBoxValues() {
			String minTemp = qFrame.getTextMin().getText();
			String maxTemp = qFrame.getTextMax().getText();

			// Si ambos campos estan en blanco
			if (minTemp.isBlank() && maxTemp.isBlank()) {
				return 0;
			} else {
				// Si minTemp esta en blanco y maxTemp es un numero
				if (minTemp.isBlank() && maxTemp.matches("-?[0-9]+")) {
					return 1;
				// Si maxTemp esta en blanco y minTemp es un numero
				} else if(maxTemp.isBlank() && minTemp.matches("-?[0-9]+")) {
					return 2;
				// Si ningun campo esta en blanco
				} else if (maxTemp.matches("-?[0-9]+") && minTemp.matches("[0-9]+")) {
					return 3;
				// Si ningun campo esta en blanco y alguno de los dos no es un numero
				}else {
					if(!maxTemp.matches("-?[0-9]+") || !minTemp.matches("-?[0-9]+")) {
						return -1;
					}else {
						return -2;
					}
				}
			}
		}
	}
	
	private class ItmListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			JComboBox combo = (JComboBox) e.getSource();
		}
	}
}
