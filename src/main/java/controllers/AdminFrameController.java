package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import views.AdminFrame;
import views.MainFrame;

public class AdminFrameController {
	private AdminFrame adFrame;
	
	public AdminFrameController(AdminFrame adFrame) {
		this.adFrame = adFrame;
		
		adFrame.addListeners(new ActListener());
	}
	
	private class ActListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == adFrame.getBtnVolver()) {
				int confirm = JOptionPane.showConfirmDialog(adFrame, "¿Salir del panel de administrador?");
				if(confirm == JOptionPane.OK_OPTION) {
					adFrame.dispose();
					new MainFrame();
				}
			}
		}
	}
}
