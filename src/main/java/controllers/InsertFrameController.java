package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import util.MongoDBConnection;
import views.InsertFrame;
import views.QueryFrame;

public class InsertFrameController {
	private InsertFrame iFrame;
	private QueryFrame qFrame;
	
	public InsertFrameController(InsertFrame iFrame) {
		this.iFrame = iFrame;
		this.qFrame = iFrame.getqFrame();
		
		iFrame.addActListener(new ActListener());
	}
	
	private class ActListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == iFrame.getBtnInsert()) {
				insertTemperature();
			}else if(obj == iFrame.getBtnVolver()) {
				iFrame.dispose();
				qFrame.setEnabled(true);
			}
		}

		private void insertTemperature() {
			String province = String.valueOf(iFrame.getComboProvinces().getSelectedItem());
			String month = String.valueOf(iFrame.getComboMonths().getSelectedItem());
			
			if(!iFrame.getFieldMinTemp().getText().isBlank() && !iFrame.getFieldMaxTemp().getText().isBlank()) {
				MongoDBConnection conn = MongoDBConnection.getInstance();
				MongoDatabase db = conn.getDatabase();
				MongoCollection<Document> collection = db.getCollection("temperatures");
				
				int year = Integer.parseInt(String.valueOf(iFrame.getFieldYear().getText()));
				int day = (int) iFrame.getSpinnerDays().getValue();
				int minTemp = Integer.parseInt(String.valueOf(iFrame.getFieldMinTemp().getText()));
				int maxTemp = Integer.parseInt(String.valueOf(iFrame.getFieldMaxTemp().getText()));
				
				if(!checkRepeated(province,month,year,day,collection)) {
					String avgStrTemp = String.format("%.1f", (minTemp + maxTemp) / (float)2).replace(",", ".");
					double avgTemp = Double.parseDouble(avgStrTemp);
					
					Document toInsert = new Document("provincia",province).append("mes", month).append("dia", day).append("anio", year).append("minTemp", minTemp).append("maxTemp", maxTemp).append("tempMedia", avgTemp);
					collection.insertOne(toInsert);
					JOptionPane.showMessageDialog(iFrame, "Documento insertado correctamente, vuelva a realizar una consulta para ver los cambios","Insercion correcta",JOptionPane.INFORMATION_MESSAGE);
					iFrame.dispose();
					qFrame.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(iFrame, "Ya existe un registro con esa fecha en la base de datos","Error",JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(iFrame, "Los campos de temperaturas no pueden estar vacios","Error",JOptionPane.ERROR_MESSAGE);
			}
		}

		private boolean checkRepeated(String province, String month, int year, int day, MongoCollection<Document> col) {
			Document filter = new Document("provincia",province).append("anio", year).append("mes", month).append("dia", day);
			Document foundDocument = col.find(filter).first();
			if(foundDocument != null) {
				return true;
			}else {
				return false;
			}
		}
	}
}
