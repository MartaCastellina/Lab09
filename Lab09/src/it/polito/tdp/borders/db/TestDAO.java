package it.polito.tdp.borders.db;

import java.util.List;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.CountryIdMap;
import it.polito.tdp.borders.model.Model;
import it.polito.tdp.borders.model.Border;

public class TestDAO {

	public static void main(String[] args) {
		Model model=new Model();
		BordersDAO dao = new BordersDAO();
		int anno=1902;
		List <Country> countries=dao.loadAllCountries(new CountryIdMap());
		List <Border> borders=dao.getCountryPairs(anno);
		System.out.println("Lista di tutte le nazioni:");
		System.out.println(countries);
		System.out.println(model.calcolaConfini(1902));
	}
}
