package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import util.MongoDBConnection;
import views.EditFrame;

public class EditFrameController {
	private EditFrame eFrame;
	
	public EditFrameController(EditFrame eFrame) {
		this.eFrame = eFrame;
		
		eFrame.addActListener(new ActListener());
	}
	
	private class ActListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == eFrame.getBtnApply()) {
				MongoDBConnection conn = MongoDBConnection.getInstance();
				MongoDatabase db = conn.getDatabase();
				MongoCollection<Document> collection = db.getCollection("temperatures");
				
				String province = eFrame.getFieldProvince().getText();
				int year = Integer.parseInt(eFrame.getFieldAge().getText());
				String month = eFrame.getFieldMonth().getText();
				int day = Integer.parseInt(eFrame.getFieldDay().getText());
				
				int checkTempValue = checkTempFields();
				if(checkTempValue == 0) {
					JOptionPane.showMessageDialog(eFrame, "Ambos campos de temperaturas no pueden estar vacios, debe rellenar uno como minimo.","Error",JOptionPane.ERROR_MESSAGE);
				}else if(checkTempValue == 1){
					updateMaxTemp(province,year,month,day, collection);
				}else if(checkTempValue == 2) {
					updateMinTemp(province,year,month,day, collection);
				}else if(checkTempValue == 3) {
					updateBothTemps(province,year,month,day, collection);
				}else if(checkTempValue == -1) {
					JOptionPane.showMessageDialog(eFrame, "Los valores no pueden ser letras ni decimales","Error",JOptionPane.ERROR_MESSAGE);
				}
			}else {
				eFrame.dispose();
				eFrame.getqFrameController().getqFrame().setEnabled(true);
			}
		}

		private void updateBothTemps(String province, int year, String month, int day, MongoCollection<Document> col) {
			int newMinTemp = Integer.parseInt(eFrame.getFieldTempMinNew().getText());
			int newMaxTemp = Integer.parseInt(eFrame.getFieldTempMaxNew().getText());
			
			Document filter = new Document("provincia",province).append("anio", year).append("mes", month).append("dia", day);
			Document update = new Document("$set", new Document("minTemp", newMinTemp).append("maxTemp", newMaxTemp));
			
			col.findOneAndUpdate(filter, update);
			
			JOptionPane.showMessageDialog(eFrame, "Temperaturas actualizadas, vuelva a ejecutar la consulta para ver los cambios","Actualizacion correcta",JOptionPane.INFORMATION_MESSAGE);
			
			eFrame.dispose();
			eFrame.getqFrameController().getqFrame().setEnabled(true);
		}

		private void updateMinTemp(String province, int year, String month, int day, MongoCollection<Document> col) {
			int newMinTemp = Integer.parseInt(eFrame.getFieldTempMinNew().getText());
			
			Document filter = new Document("provincia",province).append("anio", year).append("mes", month).append("dia", day);
			Document update = new Document("$set", new Document("minTemp", newMinTemp));
			
			col.findOneAndUpdate(filter, update);
			
			JOptionPane.showMessageDialog(eFrame, "Temperatura minima actualizada, vuelva a ejecutar la consulta para ver los cambios","Actualizacion correcta",JOptionPane.INFORMATION_MESSAGE);
			
			eFrame.dispose();
			eFrame.getqFrameController().getqFrame().setEnabled(true);
		}

		private void updateMaxTemp(String province, int year, String month, int day, MongoCollection<Document> col) {
			int newMaxTemp = Integer.parseInt(eFrame.getFieldTempMaxNew().getText());
			
			Document filter = new Document("provincia",province).append("anio", year).append("mes", month).append("dia", day);
			Document update = new Document("$set", new Document("maxTemp", newMaxTemp));
			
			col.findOneAndUpdate(filter, update);
			
			JOptionPane.showMessageDialog(eFrame, "Temperatura maxima actualizada, vuelva a ejecutar la consulta para ver los cambios","Actualizacion correcta",JOptionPane.INFORMATION_MESSAGE);
			
			eFrame.dispose();
			eFrame.getqFrameController().getqFrame().setEnabled(true);
		}

		private int checkTempFields() {
			String minTemp = eFrame.getFieldTempMinNew().getText();
			String maxTemp = eFrame.getFieldTempMaxNew().getText();

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
}
