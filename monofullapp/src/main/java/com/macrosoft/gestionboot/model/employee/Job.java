package com.macrosoft.gestionboot.model.employee;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



/**
 * Description of Job.
 * 
 * @author User
 */
@Entity
public class Job {
	
	@Id
	@GeneratedValue
	//Default
	// @GeneratedValue(strategy=AUTO)
	private Long  idJob;
	
	private String  jobTitle;
	
	private Long  minSalary;
	
	private Long  maxSalary;
	/**
	/**
	 * Description of the property tasks.
	 */
	@ManyToMany
	public Set<Task> tasks;


	/**
	 * The constructor.
	 */
	public Job() {
		super();
	}


	/**
	 * Returns tasks.
	 * @return tasks 
	 */
	public Set<Task> getTasks() {
		return this.tasks;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public Long getMinSalary() {
		return minSalary;
	}


	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}


	public Long getMaxSalary() {
		return maxSalary;
	}


	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}


	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	

}
