package program;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel labelUsuario;
	private JTextField textUsuario;
	private JLabel labelPassword;
	private JPasswordField textPassword;
	private JButton btnLogin;
	private JButton btnCancelar;
	private JLabel labelError;
	/**
	 * Create the dialog.
	 */
	public LoginDialog(Frame owner) {
		super(owner);
		setTitle("Login");
		setBounds(100, 100, 346, 239);
		getContentPane().setLayout(null);
		setLocationRelativeTo(getParent());
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		ActListener actListenner = new ActListener();
		
		labelUsuario = new JLabel("Usuario:");
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUsuario.setBounds(130, 11, 58, 14);
		getContentPane().add(labelUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(82, 31, 154, 20);
		getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		labelPassword = new JLabel("Password");
		labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPassword.setBounds(123, 62, 72, 14);
		getContentPane().add(labelPassword);
		
		textPassword = new JPasswordField();
		textPassword.setColumns(10);
		textPassword.setBounds(82, 82, 154, 20);
		getContentPane().add(textPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.setBounds(50, 156, 89, 23);
		btnLogin.addActionListener(actListenner);
		getContentPane().add(btnLogin);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(189, 157, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnCancelar);
		
		labelError = new JLabel("");
		labelError.setForeground(new Color(255, 0, 0));
		labelError.setHorizontalAlignment(SwingConstants.CENTER);
		labelError.setBounds(24, 104, 280, 46);
		getContentPane().add(labelError);
		setVisible(true);

	}
	
	private class ActListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == btnLogin) {
				if(connectAndCheckCredentials()) {
					AdminFrame admFrame = new AdminFrame();
					LoginDialog.this.getOwner().dispose();
					dispose();
				}else {
					labelError.setText("El usuario o el password\n no son correctos");
				}
			}
			
		}
		
		private boolean connectAndCheckCredentials(){
			ConnectionString connectionString = new ConnectionString("mongodb+srv://beltrancaraf23:Pitubibi94.@proyectobbdd.apuoxqd.mongodb.net/?retryWrites=true&w=majority&appName=ProyectoBBDD");
			MongoClient mongoClient = MongoClients.create(connectionString);
			MongoDatabase mongoDatabase = mongoClient.getDatabase("ProyectoTemperaturas");
			MongoCollection<Document> adminCollection = mongoDatabase.getCollection("admin");
			
			String user = textUsuario.getText().strip();
			String password = textPassword.getText().strip();
			Document search = new Document("user", user).append("password", password);
			Document find = adminCollection.find(search).first();
			mongoClient.close();
			
			if(find != null) {
				return true;
			}else {
				return false;
			}
		}
	}
}
