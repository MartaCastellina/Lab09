package it.polito.tdp.borders.model;

public class gradoStato {
	private Country stato;
	private int grado;
	public gradoStato(Country stato, int grado) {
		super();
		this.stato = stato;
		this.grado = grado;
	}
	public Country getStato() {
		return stato;
	}
	public void setStato(Country stato) {
		this.stato = stato;
	}
	public int getGrado() {
		return grado;
	}
	public void setGrado(int grado) {
		this.grado = grado;
	}
	@Override
	public String toString() {
		return "gradoStato [stato=" + stato + ", grado=" + grado + "]";
	}
	
	
	

}
