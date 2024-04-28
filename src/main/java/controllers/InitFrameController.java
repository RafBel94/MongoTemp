package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import util.MongoDBConnection;
import views.MainFrame;

public class InitFrameController {
	private static List<String> yearsList = new ArrayList<>();
	
	public void connect() {
		MongoDBConnection connection = MongoDBConnection.getInstance();
		loadYearsCombo(connection);
		new MainFrame();
	}

	private void loadYearsCombo(MongoDBConnection conn) {
		List <String> ages = new ArrayList<>();
		
		MongoDatabase db = conn.getDatabase();
		MongoCollection<Document> collection = db.getCollection("temperatures");
		
		MongoCursor<Document> list = collection.find().iterator();
		while(list.hasNext()) {
			Document doc = list.next();
			String year = String.valueOf(doc.get("anio"));
			
			if(!ages.contains(year)) {
				ages.add(year);
			}
		}
		
		for(String age : ages)
			yearsList.add(age);
	}

	public static List<String> getYearsList() {
		return yearsList;
	}
}
