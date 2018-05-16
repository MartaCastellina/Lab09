package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		List <gradoStato> g=new ArrayList<>();
		g=model.calcolaConfini(1902);
		System.out.println(g);
		int s=model.getConnessi();
		System.out.println(s);
		
//		System.out.println("Creo il grafo relativo al 2000");
//		model.createGraph(2000);
		
//		List<Country> countries = model.getCountries();
//		System.out.format("Trovate %d nazioni\n", countries.size());

//		System.out.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents());
		
//		Map<Country, Integer> stats = model.getCountryCounts();
//		for (Country country : stats.keySet())
//			System.out.format("%s %d\n", country, stats.get(country));		
		
	}

}
