package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.AboutDialog;
import views.LoginDialog;
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
				AboutDialog abtDialog = new AboutDialog();
			}else if(obj == mainFrame.getBtnLogin()) {
				LoginDialog lgnDialog = new LoginDialog(mainFrame);
			}
		}
	}
}
