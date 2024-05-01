package controllers;

import util.MongoDBConnection;
import views.MainFrame;

public class InitFrameController {
	
	public void connect() {
		MongoDBConnection connection = MongoDBConnection.getInstance();
		new MainFrame();
	}
}
