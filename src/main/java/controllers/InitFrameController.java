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
	private static List<String> agesList = new ArrayList<>();
	
	public void connect() {
		MongoDBConnection connection = MongoDBConnection.getInstance();
		loadAgesCombo(connection);
		new MainFrame();
	}

	private void loadAgesCombo(MongoDBConnection conn) {
		List <String> ages = new ArrayList<>();
		
		MongoDatabase db = conn.getDatabase();
		MongoCollection<Document> collection = db.getCollection("temperatures");
		
		MongoCursor<Document> list = collection.find().iterator();
		while(list.hasNext()) {
			Document doc = list.next();
			String age = String.valueOf(doc.get("anio"));
			
			if(!ages.contains(age)) {
				ages.add(age);
			}
		}
		
		for(String age : ages)
			agesList.add(age);
	}

	public static List<String> getAgesList() {
		return agesList;
	}
}
