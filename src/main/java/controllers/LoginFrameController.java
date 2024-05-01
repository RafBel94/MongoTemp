package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import util.MongoDBConnection;
import views.AdminFrame;
import views.LoginFrame;
import views.MainFrame;

public class LoginFrameController {
	private LoginFrame loginFrame;
	
	public LoginFrameController(LoginFrame lFrame) {
		this.loginFrame = lFrame;
		
		loginFrame.addActListener(new ActListener());
	}
	
	private class ActListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == loginFrame.getBtnLogin() || obj == loginFrame.getTextUsuario() || obj == loginFrame.getTextPassword()) {
				if(checkCredentials()) {
					loginFrame.dispose();
					new AdminFrame();
				}else {
					loginFrame.getLabelError().setText("El usuario o el password no son correctos");
				}
			}else if(obj == loginFrame.getBtnCancelar()) {
				loginFrame.dispose();
				new MainFrame();
			}
		}
		private boolean checkCredentials() {
			MongoDBConnection connection = MongoDBConnection.getInstance();
			MongoCollection<Document> adminCollection = connection.getDatabase().getCollection("admin");

			String user = loginFrame.getTextUsuario().getText().strip();
			String password = loginFrame.getTextPassword().getText().strip();

			Document search = new Document("user", user).append("password", password);
			Document find = adminCollection.find(search).first();

			if (find != null) {
				return true;
			} else {
				return false;
			}
		}
	}
}
