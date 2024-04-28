package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import views.AdminFrame;
import views.MainFrame;
import views.MapFrame;
import views.UpdateFrame;

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
				int confirm = JOptionPane.showConfirmDialog(adFrame, "¿Salir del panel de administrador?","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
				if(confirm == JOptionPane.OK_OPTION) {
					adFrame.dispose();
					new MainFrame();
				}
			} else if (obj == adFrame.getBtnConsulta()) {
				adFrame.dispose();
				new MapFrame(adFrame);
			} else if (obj == adFrame.getBtnActualizar()) {
				adFrame.dispose();
				new UpdateFrame();
			}
		}
	}
}
