package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.List;

public class Country implements Comparable<Country>{
	private String stateAbb;
	private int cCode;
	private String stateName;
	private List <Border> confini; 
	
	public Country(String stateAbb, int code, String stateName) {
		super();
		this.stateAbb = stateAbb;
		this.cCode = code;
		this.stateName = stateName;
		confini=new ArrayList<Border>();
	}
	
	

	public String getStateAbb() {
		return stateAbb;
	}

	public void setStateAbb(String stateAbb) {
		this.stateAbb = stateAbb;
	}

	public int getCode() {
		return cCode;
	}

	public void setCode(int code) {
		this.cCode = code;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (cCode != other.cCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return stateName;
	}



	@Override
	public int compareTo(Country o) {
		
		return (this.getStateName().compareTo(o.getStateName()));
	}
	
	
	

}
