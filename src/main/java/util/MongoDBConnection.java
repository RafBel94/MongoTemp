package util;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
	private static MongoDBConnection instance = null;
	private MongoClient mongoClient;
    private MongoDatabase database;
    
    private MongoDBConnection() {
        // Inicializa la conexión a MongoDB
    	ConnectionString connectionString = new ConnectionString("mongodb+srv://beltrancaraf23:Pitubibi94.@proyectobbdd.apuoxqd.mongodb.net/?retryWrites=true&w=majority&appName=ProyectoBBDD");
		mongoClient = MongoClients.create(connectionString);
		database = mongoClient.getDatabase("ProyectoTemperaturas");
    }

    public static MongoDBConnection getInstance() {
        if (instance == null) {
            instance = new MongoDBConnection();
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}