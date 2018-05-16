package it.polito.tdp.borders.model;

public class Border {

	
	private int stato1;
	
	private int stato2;

	public Border(int stato1, int stato2) {
		super();
		this.stato1 = stato1;
		this.stato2 = stato2;
	}

	public int getStato1() {
		return stato1;
	}

	public void setStato1(int stato1) {
		this.stato1 = stato1;
	}

	public int getStato2() {
		return stato2;
	}

	public void setStato2(int stato2) {
		this.stato2 = stato2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stato1;
		result = prime * result + stato2;
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
		Border other = (Border) obj;
		if (stato1 != other.stato1)
			return false;
		if (stato2 != other.stato2)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Border [stato1=" + stato1 + ", stato2=" + stato2 + "]";
	}

	
	
	
}