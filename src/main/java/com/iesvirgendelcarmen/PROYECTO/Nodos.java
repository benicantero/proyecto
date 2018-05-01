package com.iesvirgendelcarmen.PROYECTO;

public class Nodos {

	private String city;
	private String country;
	private String post_code;
	private String latitude;
	private String longitude;
	
	public Nodos(String city, String country, String post_code, String latitude, String longitude) {
		super();
		this.city = city;
		this.country = country;
		this.post_code = post_code;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Nodos [city=" + city + ", country=" + country + ", post_code=" + post_code + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

}
