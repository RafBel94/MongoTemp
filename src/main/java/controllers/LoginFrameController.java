package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import util.MongoDBConnection;
import views.AdminFrame;
import views.LoginFrame;
import views.MainFrame;

public class LoginFrameController {
	private LoginFrame loginFrame;
	private JFrame owner;
	
	public LoginFrameController(LoginFrame lFrame, JFrame owner) {
		this.loginFrame = lFrame;
		this.owner = owner;
		
		loginFrame.addLoginListener(new LoginListener());
	}
	
	private class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == loginFrame.getBtnLogin()) {
				System.out.println("Pulsado!");
				if(connectAndCheckCredentials()) {
					AdminFrame admFrame = new AdminFrame();
					owner.dispose();
					loginFrame.dispose();
				}else {
					loginFrame.getLabelError().setText("El usuario o el password no son correctos");
				}
			}else if(obj == loginFrame.getBtnCancelar()) {
				owner.setEnabled(true);
				loginFrame.dispose();
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
