package program;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import model.Temperature;

public class QuickStart {
	public static void main(String[] args) {
		CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),pojoCodecRegistry);
        MongoClientSettings settings = MongoClientSettings.builder().codecRegistry(codecRegistry).build();

        // Atlas Connection String -->
     	// mongodb+srv://beltrancaraf23:<password>@proyectobbdd.apuoxqd.mongodb.net/?retryWrites=true&w=majority&appName=ProyectoBBDD
        ConnectionString connectionString = new ConnectionString("mongodb+srv://beltrancaraf23:Pitubibi94.@proyectobbdd.apuoxqd.mongodb.net/?retryWrites=true&w=majority&appName=ProyectoBBDD");

        // Creamos la configuracion para el cliente
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
        
		// Creamos la conexion y le pasamos la configuracion
		MongoClient mongoClient = MongoClients.create(clientSettings);

		// Obtenemos la base de datos que queramos
		MongoDatabase database = mongoClient.getDatabase("ProyectoTemperaturas");

		// Obtenemos las colecciones que queramos
		MongoCollection<Document> tempCollection = database.getCollection("temperatures");
		MongoCollection<Document> adminCollection = database.getCollection("admin");
		
		// Obtenemos la coleccion pero en vez de con "Document", esta vez lo hacemos con "Grade" para el mapeo a POJO
		MongoCollection<Temperature> collectionTemperature = database.getCollection("temperatures", Temperature.class);
		
		// --> Descomentar las siguientes lineas si es necesario
		//insertOneTemperature(collection);
		//insertManyTemperatures(collection);
		
		//findFirstByProvince(collection, "provincia", "Cadiz");
		//findByMaxTempRange(collection, 22, 25);
		//insertAsJavaObject(collectionTemperature);
		//List<Temperature> listaTemps = findAsJavaObject(collectionTemperature);
		
		//findAllByYear(collection, 2017);
		
	}
	
	private static List<Temperature> findAsJavaObject(MongoCollection<Temperature> col) {
		List<Temperature> listaTemp = new ArrayList<>();
		Iterator<Temperature> it = col.find().iterator();
		while(it.hasNext()) {
			Temperature temp = it.next();
			listaTemp.add(temp);
		}
		return listaTemp;
	}
	
	// Este metodo recibe una MongoCollection de Temperature, en lugar de Document para trabajar como un objeto Java plano
	private static void insertAsJavaObject(MongoCollection<Temperature> col) {
		Temperature tmp = new Temperature().setProvincia("Cadiz").setAnio(2017).setMes("enero").setDia(5).setMinTemp(12).setMaxTemp(28);
		
		col.insertOne(tmp);
	}

	// Busca documentos en el cual la temperaturar maxima este entre un rango de valores maximos y minimos
	private static void findByMaxTempRange(MongoCollection<Document> col, int min, int max) {
		Document filtroRangos = new Document("$gte", min).append("$lte", max);
		Document filtro = new Document("maxTemp", filtroRangos);
		
		MongoCursor<Document> temps = col.find(filtro).iterator();
		
		while(temps.hasNext()) {
			Document doc = temps.next();
			System.out.println("Temperatura en " + doc.get("provincia") + " el " + doc.get("dia") + " de " + doc.get("mes") + " del " + doc.get("anio") + ":");
			System.out.println("Minima: " + doc.get("minTemp") + " || Maxima: " + doc.get("maxTemp"));
		}
	}

	// Encuentra y obtiene el primer documento buscando por la provincia
	public static void findFirstByProvince(MongoCollection<Document> col, String key, String value){
		// Creamos un documento para buscar por los valores que le pasamos
		// es decir, sirve para hacer de "filtro"
		Document search = new Document(key,value);
		
		// Creamos este documento en el que guardaremos el resultado, es decir, el documento que 
		// encuentre la consulta que hemos hecho ( en este caso, devuelve el primer documento que
		// se corresponda con la clave key y el valor value que hemos pasado al documento search)
		// -- En realidad .find() devuelve un FindIterable<Document>, pero al ser un solo documento
		// -- podemos asignarlo directamente a un objeto Document.
		Document res = col.find(search).first();
		
		// Si ha encontrado algo ( es decir, el documento no es nulo ), obtenemos los campos que queramos del documento
		// como lo hariamos con un HashMap
		if(res != null) {
			System.out.println("Documento encontrado");
			System.out.println("Temperatura minima: " + res.get("minTemp") + " || Temperatura maxima: " + res.get("maxTemp"));
		}
	}

	// Encuentra y obtiene todos los documentos buscando por el anio
	public static void findAllByYear(MongoCollection<Document> col, int anio) {
		// Creamos un documento para que haga de filtro
		Document filter = new Document("anio", anio);
		
		// Obtenemos el conjunto de documentos aplicando el filtro a la coleccion con .find() y luego con el metodo
		// iterator() nos devuelve un objeto MongoCursor<Document> con todos los documentos que encuentre, el cual podemos recorrer
		MongoCursor<Document> resultDocument = col.find(filter).iterator();
		
		// Recorremos el objeto MongoCursor<Document> igual que siempre con un iterador
		while(resultDocument.hasNext()) {
			Document doc = resultDocument.next();
			System.out.println("Temperatura en " + doc.get("provincia") + " el " + doc.get("dia") + " de " + doc.get("mes") + " del " + doc.get("anio") + ":");
			System.out.println("Minima: " + doc.get("minTemp") + " || Maxima: " + doc.get("maxTemp"));
		}
	}
	
	// Crea e inserta un solo documento en la coleccion
	private static void insertOneTemperature(MongoCollection<Document> col) {
		// Creamos el documento y con .append() vamos agregando los campos necesarios
		Document doc1 = new Document("provincia","Cadiz");
		doc1.append("anio", 2017);
		doc1.append("mes", "enero");
		doc1.append("dia", 1);
		doc1.append("maxTemp", 22);
		doc1.append("minTemp", 15);
		
		// Insertamos el documento en la coleccion
		col.insertOne(doc1);
	}
	
	// Crea e inserta varios documentos en la coleccion
	private static void insertManyTemperatures(MongoCollection<Document> col) {
		// Creamos una lista en la que meteremos los documentos que queremos insertar en la coleccion
		List<Document> listaInsertar = new ArrayList<>();
		
		// Creamos los documentos y con .append() vamos agregando los campos necesarios
		// El formato seria --> doc.append("clave", valor)
		Document doc1 = new Document("provincia","Cadiz");
		doc1.append("anio", 2017);
		doc1.append("mes", "enero");
		doc1.append("dia", 2);
		doc1.append("maxTemp", 25);
		doc1.append("minTemp", 12);
		
		Document doc2 = new Document("provincia","Cadiz");
		doc2.append("anio", 2017);
		doc2.append("mes", "enero");
		doc2.append("dia", 3);
		doc2.append("maxTemp", 27);
		doc2.append("minTemp", 14);
		
		Document doc3 = new Document("provincia","Cadiz");
		doc3.append("anio", 2017);
		doc3.append("mes", "enero");
		doc3.append("dia", 4);
		doc3.append("maxTemp", 23);
		doc3.append("minTemp", 11);
		
		// Agregamos los documentos al ArrayList
		listaInsertar.add(doc1);
		listaInsertar.add(doc2);
		listaInsertar.add(doc3);
		
		// Insertamos los documentos en la coleccion
		col.insertMany(listaInsertar);
	}

	/*
	private static MongoCollection<Document> connectToDatabaseAndGetCollection() {
		// Atlas Connection String -->
		// mongodb+srv://beltrancaraf23:<password>@proyectobbdd.apuoxqd.mongodb.net/?retryWrites=true&w=majority&appName=ProyectoBBDD
		String uri = "mongodb+srv://beltrancaraf23:Pitubibi94.@proyectobbdd.apuoxqd.mongodb.net/?retryWrites=true&w=majority&appName=ProyectoBBDD";
		
		// Creamos la conexion y le pasamos la uri
		MongoClient mongoClient = MongoClients.create(uri);

		// Obtenemos la base de datos que queramos
		MongoDatabase database = mongoClient.getDatabase("ProyectoTemperaturas");

		// Obtenemos la coleccion que queramos
		MongoCollection<Document> collection = database.getCollection("temperatures");
		
		return collection;
	}
	*/

}
