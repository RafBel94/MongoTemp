package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		loginFrame.addLoginListener(new LoginListener());
	}
	
	private class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == loginFrame.getBtnLogin() || obj == loginFrame.getTextUsuario() || obj == loginFrame.getTextPassword()) {
				if(connectAndCheckCredentials()) {
					loginFrame.dispose();
					AdminFrame admFrame = new AdminFrame();
				}else {
					loginFrame.getLabelError().setText("El usuario o el password no son correctos");
				}
			}else if(obj == loginFrame.getBtnCancelar()) {
				loginFrame.dispose();
				new MainFrame();
			}
		}
		private boolean connectAndCheckCredentials() {
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
