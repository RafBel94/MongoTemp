package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.AboutFrame;
import views.LoginFrame;
import views.MainFrame;
import views.MapFrame;

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
				new AboutFrame();
			}else if(obj == mainFrame.getBtnLogin()) {
				new LoginFrame();
				mainFrame.dispose();
			}else if(obj == mainFrame.getBtnConsulta()) {
				new MapFrame(mainFrame);
				mainFrame.dispose();
			}
		}
	}
}
