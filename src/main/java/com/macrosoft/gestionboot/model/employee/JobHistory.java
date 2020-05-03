package com.macrosoft.gestionboot.model.employee;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 * Description of JobHistory.
 * 
 * @author User
 */
@Entity
public class JobHistory {
	
	@Id
	@GeneratedValue
	//Default
	// @GeneratedValue(strategy=AUTO)
	private Long  idJobHistory;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	/**
	/**
	 * Description of the property employees.
	 */
    @OneToOne
	private Employee employees = null;

	/**
	 * Description of the property jobs.
	 */
    @OneToOne
	private Job jobs = null;

	/**
	 * Description of the property departements.
	 */
    @OneToOne
	private  Departement departements = null;


	/**
	 * The constructor.
	 */
	public JobHistory() {
		super();
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public Job getJobs() {
		return jobs;
	}

	public void setJobs(Job jobs) {
		this.jobs = jobs;
	}

	public Departement getDepartements() {
		return departements;
	}

	public void setDepartements(Departement departements) {
		this.departements = departements;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	

	
}
