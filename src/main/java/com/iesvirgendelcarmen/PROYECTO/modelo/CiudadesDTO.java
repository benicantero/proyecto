package com.iesvirgendelcarmen.PROYECTO.modelo;

public class CiudadesDTO {

	private int id;
	private String City;
	private String Country;
	private String Postal_Code;
	private Double Latitude;
	private Double Longitude;

	public CiudadesDTO(int id, String City, String Country, String Postal_Code, Double Latitude, Double Longitude) {
		super();
		this.id = id;
		this.City = City;
		this.Country = Country;
		this.Postal_Code = Postal_Code;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
	}

	
	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		Country = country;
	}


	public String getPostal_Code() {
		return Postal_Code;
	}


	public void setPostal_Code(String postal_Code) {
		Postal_Code = postal_Code;
	}


	public double getLatitude() {
		return Latitude;
	}


	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}


	public Double getLongitude() {
		return Longitude;
	}


	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Listado ciudades: [ID=" + id + ", City=" + City + ", Country=" + Country + ", Postal_Code=" + Postal_Code
				+ ", Latitude=" + Latitude + ", Longitude=" + Longitude + "]";
	}

}
