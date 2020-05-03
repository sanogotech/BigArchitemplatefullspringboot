package com.macrosoft.gestionboot.model.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 * Description of Country.
 * 
 * @author User
 */
@Entity
public class Country {
	
	@Id
	@GeneratedValue
	//Default
	// @GeneratedValue(strategy=AUTO)
	private Long  idCountry;
	
	private String  countryName;
	/**
	 * Description of the property regions.
	 */
	@OneToOne
	private  Region region = null;



	/**
	 * The constructor.
	 */
	public Country() {
		super();
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
	

}
