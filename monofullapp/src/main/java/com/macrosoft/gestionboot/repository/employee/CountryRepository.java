package com.macrosoft.gestionboot.repository.employee;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.macrosoft.gestionboot.model.employee.Country;

//@PreAuthorize("hasRole('ROLE_USER')") 
//@Secured("ROLE_USER") 
/*@CrossOrigin(origins = "http://domain2.example",
  methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE },
  maxAge = 3600)*/
@RepositoryRestResource
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

	/*
	public List<Country> findByCountryName(@Param("countryName") String countryName);
	
	@Override
	@RestResource(exported = false)
	public void deleteById(Long aLong);
	*/

}
