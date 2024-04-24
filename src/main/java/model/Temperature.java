package model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Temperature {
	private ObjectId id;
	@BsonProperty(value = "provincia")
	private String provincia;
	@BsonProperty(value = "mes")
	private String mes;
	@BsonProperty(value = "dia")
	private int dia;
	@BsonProperty(value = "anio")
	private int anio;
	@BsonProperty(value = "minTemp")
	private int minTemp;
	@BsonProperty(value = "maxTemp")
	private int maxTemp;

	public ObjectId getId() {
		return id;
	}


	public Temperature setId(ObjectId id) {
		this.id = id;
		return this;
	}

	public Temperature setProvincia(String provincia) {
		this.provincia = provincia;
		return this;
	}

	public Temperature setMes(String mes) {
		this.mes = mes;
		return this;
	}


	public Temperature setDia(int dia) {
		this.dia = dia;
		return this;
	}


	public Temperature setAnio(int anio) {
		this.anio = anio;
		return this;
	}


	public Temperature setMinTemp(int minTemp) {
		this.minTemp = minTemp;
		return this;
	}


	public Temperature setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
		return this;
	}


	public String getProvincia() {
		return provincia;
	}


	public String getMes() {
		return mes;
	}


	public int getDia() {
		return dia;
	}


	public int getAnio() {
		return anio;
	}


	public int getMinTemp() {
		return minTemp;
	}


	public int getMaxTemp() {
		return maxTemp;
	}


	@Override
	public String toString() {
		return "Temperatura en " + provincia + " el " + dia + " de " + mes + " del " + anio + ": " + "Temperatura minima: " + minTemp + " || Temperatura maxima: " + maxTemp;
	}
}
