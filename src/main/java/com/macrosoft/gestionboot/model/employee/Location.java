package com.macrosoft.gestionboot.model.employee;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;



/**
 * Description of Location.
 * 
 * @author User
 */
@Entity
public class Location {
	
	@Id
	@GeneratedValue
	//Default
	// @GeneratedValue(strategy=AUTO)
	private Long  idLocation;
	
	private String  streetAdress;
	
	private String  city;
	
	private String  postalCode;
	
	private String  stateProvince;
	/**
	/**
	 * Description of the property countrys.
	 */
	 @OneToOne
	private  Country country = null;

	/**
	 * The constructor.
	 */
	public Location() {
		super();
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Long getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(Long idLocation) {
		this.idLocation = idLocation;
	}

	public String getStreetAdress() {
		return streetAdress;
	}

	public void setStreetAdress(String streetAdress) {
		this.streetAdress = streetAdress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	
	


}
