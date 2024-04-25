package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.AboutFrame;
import views.LoginFrame;
import views.MainFrame;

public class MainFrameController{
	private MainFrame mainFrame;
	
	public MainFrameController(MainFrame mFrame) {
		this.mainFrame = mFrame;
		
		mainFrame.addLoginListener(new LoginListener());
	}
	
	private class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == mainFrame.getBtnAbout()) {
				AboutFrame abtFrame = new AboutFrame();
			}else if(obj == mainFrame.getBtnLogin()) {
				LoginFrame lgnFrame = new LoginFrame();
				mainFrame.dispose();
			}
		}
	}
}
