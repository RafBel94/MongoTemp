package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
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
import views.EditFrame;
import views.InsertFrame;
import views.MainFrame;
import views.MapFrame;
import views.QueryFrame;
import views.QueryHelpFrame;

public class QueryFrameController {
	List<String> yearList = new ArrayList<>();
	private DefaultTableModel model;
	private JTable table;
	private QueryFrame qFrame;
	private int contConsultas = 0;

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
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("Provincias");
		model.addColumn("Año");
		model.addColumn("Mes");
		model.addColumn(("Dia"));
		model.addColumn("T.Min");
		model.addColumn("T.Max");
		model.addColumn("T.Media");

		for (int i = 0; i < 14; i++) {
			model.addRow(new Object[] { "", "", "", "", "", "" });
		}

		table = new JTable(model);
		if (qFrame.getMapOwner() instanceof MainFrame)
			table.setEnabled(false);

		qFrame.getScrollPane().getViewport().add(table);
	}

	public void setCombos() {
		// Provinces JComboBox Set
		List<JCheckBox> provincesList = MapFrameController.getJCheckBoxList();
		for (int i = 0; i < provincesList.size(); i++) {
			qFrame.getComboProv().addItem(provincesList.get(i).getToolTipText());
		}

		// Ages JComboBox Set
		loadYears();
		updateYearsCombo();

		// Months JComboBox Set
		String[] months = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		for (String m : months) {
			qFrame.getComboMeses().addItem(m);
		}
	}

	public void updateYearsCombo() {
		qFrame.getComboAnio().removeAllItems();
		for (String year : yearList) {
			qFrame.getComboAnio().addItem(year);
		}
	}

	private void loadYears() {
		MongoDatabase db = MongoDBConnection.getInstance().getDatabase();
		MongoCollection<Document> collection = db.getCollection("temperatures");

		MongoCursor<Document> list = collection.find().iterator();
		while (list.hasNext()) {
			Document doc = list.next();
			String year = String.valueOf(doc.get("anio"));

			if (!yearList.contains(year)) {
				yearList.add(year);
			}
		}
	}

	public List<String> getYearList() {
		return yearList;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public JTable getTable() {
		return table;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public QueryFrame getqFrame() {
		return qFrame;
	}

	//////////////////
	// PRIVATE CLASSES

	private class ActListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();

			if (obj == qFrame.getBtnVolver()) {
				qFrame.dispose();
				MapFrameController.getJCheckBoxList().clear();
				new MapFrame(qFrame.getMapOwner());
			} else if (obj == qFrame.getBtnConsultar()) {
				MongoDBConnection conn = MongoDBConnection.getInstance();
				MongoDatabase db = conn.getDatabase();
				MongoCollection<Document> collection = db.getCollection("temperatures");

				String province = (String) qFrame.getComboProv().getSelectedItem();
				int year = Integer.parseInt((String) qFrame.getComboAnio().getSelectedItem());
				String month = (String) qFrame.getComboMeses().getSelectedItem();

				if (checkTempBoxValues() == -1) {
					JOptionPane.showMessageDialog(qFrame,
							"Los limites de las temperaturas no pueden ser valores decimales o caracteres");
				} else if (checkTempBoxValues() == 0) {
					noTempFilterQuery(collection, province, year, month);
					contConsultas++;
				} else if (checkTempBoxValues() == 1) {
					maxTempFilterQuery(collection, province, year, month);
					contConsultas++;
				} else if (checkTempBoxValues() == 2) {
					minTempFilterQuery(collection, province, year, month);
					contConsultas++;
				} else if (checkTempBoxValues() == 3) {
					bothTempFilterQuery(collection, province, year, month);
					contConsultas++;

				}
			} else if (obj == qFrame.getBtnAyuda()) {
				new QueryHelpFrame();

			} else if (obj == qFrame.getBtnEditar()) {
				int selectedRow = table.getSelectedRow();

				if (selectedRow != -1 && contConsultas != 0) {
					qFrame.setEnabled(false);
					new EditFrame(QueryFrameController.this);
				} else if (selectedRow == -1)
					JOptionPane.showMessageDialog(qFrame, "Debe seleccionar una fila valida para poder editar", "Error",
							JOptionPane.ERROR_MESSAGE);
				else if (contConsultas == 0)
					JOptionPane.showMessageDialog(qFrame, "Debe realizar primero una consulta", "Error",
							JOptionPane.ERROR_MESSAGE);

			} else if (obj == qFrame.getBtnEliminar()) {
				if (contConsultas != 0) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						int election = JOptionPane.showConfirmDialog(qFrame,
								"¿Seguro que quiere eliminar el registro seleccionado?", "Confirmacion",
								JOptionPane.INFORMATION_MESSAGE);
						if (election == JOptionPane.OK_OPTION) {
							deleteTemp(selectedRow);

						}
					} else {
						JOptionPane.showMessageDialog(qFrame, "Debe seleccionar una fila valida para poder eliminarla",
								"Error", JOptionPane.ERROR_MESSAGE);

					}
				} else {
					JOptionPane.showMessageDialog(qFrame, "Debe realizar primero una consulta", "Error",
							JOptionPane.ERROR_MESSAGE);

				}
			} else if (obj == qFrame.getBtnInsertar()) {
				qFrame.setEnabled(false);
				new InsertFrame(qFrame);
			}
		}

		private void deleteTemp(int selectedRow) {
			MongoDBConnection conn = MongoDBConnection.getInstance();
			MongoDatabase db = conn.getDatabase();
			MongoCollection<Document> collection = db.getCollection("temperatures");

			String province = String.valueOf(table.getValueAt(selectedRow, 0));
			int year = Integer.parseInt(String.valueOf(table.getValueAt(selectedRow, 1)));
			String month = String.valueOf(table.getValueAt(selectedRow, 2));
			int day = Integer.parseInt(String.valueOf(table.getValueAt(selectedRow, 3)));

			Document filter = new Document("provincia", province).append("anio", year).append("mes", month)
					.append("dia", day);
			Document deleted = collection.findOneAndDelete(filter);

			if (deleted != null) {
				JOptionPane.showMessageDialog(qFrame,
						"El registro se ha eliminado con exito, vuelva a realizar la consulta para ver los cambios",
						"Eliminacion correcta", JOptionPane.INFORMATION_MESSAGE);
				yearList.remove(String.valueOf(year));
				updateYearsCombo();
			} else
				JOptionPane.showMessageDialog(qFrame, "Documento no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
		}

		private void bothTempFilterQuery(MongoCollection<Document> collection, String province, int year,
				String month) {
			Document maxTempFilter = new Document("$lte", Integer.parseInt(qFrame.getTextMax().getText()));
			Document minTempFilter = new Document("$gte", Integer.parseInt(qFrame.getTextMin().getText()));
			Document filter = new Document("provincia", province).append("anio", year).append("mes", month)
					.append("minTemp", minTempFilter).append("maxTemp", maxTempFilter);
			makeQuery(filter, collection, province, year, month);
		}

		private void maxTempFilterQuery(MongoCollection<Document> collection, String province, int year, String month) {
			Document maxTempFilter = new Document("$lte", Integer.parseInt(qFrame.getTextMax().getText()));
			Document filter = new Document("provincia", province).append("anio", year).append("mes", month)
					.append("maxTemp", maxTempFilter);
			makeQuery(filter, collection, province, year, month);
		}

		private void minTempFilterQuery(MongoCollection<Document> collection, String province, int year, String month) {
			Document minTempFilter = new Document("$gte", Integer.parseInt(qFrame.getTextMin().getText()));
			Document filter = new Document("provincia", province).append("anio", year).append("mes", month)
					.append("minTemp", minTempFilter);
			makeQuery(filter, collection, province, year, month);
		}

		private void noTempFilterQuery(MongoCollection collection, String province, int year, String month) {
			Document filter = new Document("provincia", province).append("anio", year).append("mes", month);
			makeQuery(filter, collection, province, year, month);
		}

		private void makeQuery(Document document, MongoCollection collection, String province, int year, String month) {
			MongoCursor<Document> docList = collection.find(document).iterator();

			// Limpiamos la tabla
			model.setRowCount(0);

			int contTemp = 0;
			int minTotal = Integer.MAX_VALUE;
			int maxTotal = Integer.MIN_VALUE;
			int monthAvg = 0;

			while (docList.hasNext()) {
				Document doc = docList.next();

				// Coger valores
				int minTemp = Integer.parseInt(String.valueOf(doc.get("minTemp")));
				int maxTemp = Integer.parseInt(String.valueOf(doc.get("maxTemp")));
				double avgTemp = (minTemp + maxTemp) / (double) 2;
				String strAvgTemp = String.format("%.2f", avgTemp);

				// Agregar fila
				model.addRow(new Object[] { doc.get("provincia"), doc.get("anio"), doc.get("mes"), doc.get("dia"),
						doc.get("minTemp"), doc.get("maxTemp"), strAvgTemp });

				// Comprobacion de minima y maxima
				if (minTemp < minTotal)
					minTotal = minTemp;
				if (maxTemp > maxTotal)
					maxTotal = maxTemp;

				// Suma de medias para calculo de media total
				monthAvg += avgTemp;

				contTemp++;
			}

			// Calculo y asignacion a los JTextFields
			if (contTemp != 0) {
				String avgTotalTemp = String.format("%.1f", monthAvg / (float) contTemp);
				qFrame.getTextMinimaTotal().setText(String.valueOf(minTotal));
				qFrame.getTextMaximaTotal().setText(String.valueOf(maxTotal));
				qFrame.getTextMediaTotal().setText(avgTotalTemp);
			} else {
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
				} else if (maxTemp.isBlank() && minTemp.matches("-?[0-9]+")) {
					return 2;
					// Si ningun campo esta en blanco
				} else if (maxTemp.matches("-?[0-9]+") && minTemp.matches("[0-9]+")) {
					return 3;
					// Si ningun campo esta en blanco y alguno de los dos no es un numero
				} else {
					if (!maxTemp.matches("-?[0-9]+") || !minTemp.matches("-?[0-9]+")) {
						return -1;
					} else {
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
