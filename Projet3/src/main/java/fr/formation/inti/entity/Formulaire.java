package fr.formation.inti.entity;

public class Formulaire {
	
	private String keywords;
	private String city;
	private String information;
	private String accessibility;
//	private Date startdate;
//	private Date starttime;
	
	
	
	
	public Formulaire() {
	}


	public String getAccessibility() {
		return accessibility;
	}


	public void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
	}


//	public Date getStartdate() {
//		return startdate;
//	}
//
//
//	public void setStartdate(Date startdate) {
//		this.startdate = startdate;
//	}
//
//
//	public Date getStarttime() {
//		return starttime;
//	}
//
//
//	public void setStarttime(Date starttime) {
//		this.starttime = starttime;
//	}


	public String getInformation() {
		return information;
	}


	public void setInformation(String information) {
		this.information = information;
	}


	public String getKeywords() {
		return keywords;
	}


	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	
}
