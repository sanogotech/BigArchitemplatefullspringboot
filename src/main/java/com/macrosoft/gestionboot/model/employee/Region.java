package com.macrosoft.gestionboot.model.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import  org.springframework.data.rest.core.annotation.RestResource;


/**
 * Description of Region.
 * 
 * @author User
 */
@Entity
//@RestResource
public class Region {
	
	
	@Id
	@GeneratedValue
	//Default
	// @GeneratedValue(strategy=AUTO)
	private Long  idRegion;
	
	private String  regionName;
	
	/**
	// Start of user code (user defined attributes for Region)

	// End of user code

	/**
	 * The constructor.
	 */
	public Region() {
		super();
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	


}
