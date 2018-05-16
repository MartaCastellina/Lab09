package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import it.polito.tdp.borders.db.BordersDAO;


public class Model {
	
	
	SimpleGraph<Country, DefaultEdge> grafo;
	BordersDAO dao;
	List <Country> listCountry;
	Map <Integer, Country> mappaId;
	CountryIdMap mappaPaesi;

	
	
	public Model() {
		grafo=new SimpleGraph<>(DefaultEdge.class);
		dao=new BordersDAO();
		mappaPaesi=new CountryIdMap();
		listCountry=dao.loadAllCountries(mappaPaesi);
		mappaId=new HashMap<Integer,Country>();
	}

	public List <gradoStato> calcolaConfini(int anno) {
		Graphs.addAllVertices(grafo, listCountry);
		List <Border> confini=dao.getCountryPairs(anno);
		for (Border b:confini) {
			Country stato1=mappaPaesi.get(b.getStato1());
			Country stato2=mappaPaesi.get(b.getStato2());
			grafo.addEdge(stato1, stato2);
		}
		List <gradoStato> lista=new ArrayList<gradoStato>();
		for(Country c:grafo.vertexSet()) {
			lista.add(new gradoStato(c, grafo.degreeOf(c)));
		}
		System.out.println(lista);
		return lista;
		
	}

	public int getConnessi() {
		ConnectivityInspector<Country, DefaultEdge> ci = new ConnectivityInspector<Country, DefaultEdge>(grafo);
		return ci.connectedSets().size();
		
	}
	public List <Country> getStati(){
		List<Country> country= dao.loadAllCountries(mappaPaesi);
		List <Country> stati=new ArrayList<Country>();
		for (Country c: country) {
			stati.add(c);
		}
		return stati;
	}

	public List<Country> trovaVicini(Country c) {
		
		//iterativo	
		List <Country> vicini=new ArrayList<Country>();
		BreadthFirstIterator<Country,DefaultEdge> bfi= new BreadthFirstIterator<>(grafo,c);
		while (bfi.hasNext()) {
			vicini.add(bfi.next());
		}
		
		return vicini;
	}

	public Set<Country> trovaViciniRecursive(Country c) {

		Set <Country> cConnessa=new LinkedHashSet<Country>();
		this.recursive(cConnessa,c);
		return cConnessa;
	}

	private void recursive(Set<Country> cConnessa,Country inizio) {
		
		boolean flag=false;
		if(!cConnessa.contains(inizio)) {
			cConnessa.add(inizio);
			flag=true;
		}
		if(flag) {
			for(Country c:Graphs.neighborListOf(grafo, inizio)) {
				recursive(cConnessa,c);
			
			}
		}
		
		
		
		
		
//		for(Country c:Graphs.neighborListOf(grafo, inizio)) {
//		if(!cConnessa.contains(c)) {
//		cConnessa.add(c);
//		recursive(cConnessa,c);
//		}
//		
//	}
		
	}

}
