package com.macrosoft.gestionboot.repository.employee;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.macrosoft.gestionboot.model.employee.Region;




@Repository
public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {


}