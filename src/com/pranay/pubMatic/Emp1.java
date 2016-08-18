package com.pranay.pubMatic;

import java.util.Comparator;

public class Emp1 {
	private String name;
	private String city;
	private String industry;
	private String Descipline;
	private String experience;
	private int isUsed = 0;
	
	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}
	public int getIsUsed() {
		return isUsed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getDescipline() {
		return Descipline;
	}
	public void setDescipline(String descipline) {
		Descipline = descipline;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public static Comparator<Emp1> cityComparator = new Comparator<Emp1>() {
		@Override
		public int compare(Emp1 e1, Emp1 e2) {
			return e1.getCity().compareTo(e2.getCity());
		}
	};


	@Override
	public String toString() {
		return  name + "," + city + ","+ industry + "," + Descipline + ","+ experience;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Descipline == null) ? 0 : Descipline.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((experience == null) ? 0 : experience.hashCode());
		result = prime * result
				+ ((industry == null) ? 0 : industry.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Emp1 e = (Emp1) obj;
		return (name==e.name || name!=null && name.equals(e.getName()))
				&& (city==e.city || city!=null && city.equals(e.getCity()))
				&& (industry==e.industry || industry!=null && industry.equals(e.getIndustry()))
				&& (Descipline==e.Descipline || Descipline!=null && Descipline.equals(e.getDescipline()))
				&& (experience==e.experience || experience!=null && experience.equals(e.getExperience()));
	}
}
