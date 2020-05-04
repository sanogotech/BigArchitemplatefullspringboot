package com.macrosoft.gestionboot.model.employee;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



/**
 * Description of Employee.
 * 
 * @author User
 */
@Entity
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue
	//Default
	// @GeneratedValue(strategy=AUTO)
	private Long  id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	private long salary;
	
	private LocalDate hireDate;
	
	
	  @ManyToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="manager_id")
	  private Employee manager;
	 
	//`manager_id` BIGINT(20) NULL DEFAULT NULL
	//@ManyToOne
	//+s employee --- 0 or 1 Manager
	
	
	  @OneToMany(mappedBy="manager")
	  private Set<Employee> subordinates;
	  //private Set<Employee> subordinates = new HashSet<Employee>();
	  
	 
	
	/*
	@Column(name = "local_time", columnDefinition = "TIME")
	private LocalTime localTime;
	08:20:45.123456789
	 
	@Column(name = "local_date", columnDefinition = "DATE")
	private LocalDate localDate; 
    *  yyyy-MM-dd 
	 
	@Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime localDateTime;
	https://howtodoinjava.com/java/date-time/localdate-format-example/
	
	//1 - default time pattern
String time = "2019-03-27T10:15:30";
//2 - specific date time pattern
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
String time1 = "2019-03-27 10:15:30 AM";
LocalDateTime localTimeObj1 = LocalDateTime.parse(time1, formatter);

	
	

	/**
	 * Description of the property jobs.
	 */
	@OneToMany
	public Set<Job> jobs;



	/**
	 * The constructor.
	 */
	public Employee() {
		super();
	}

	

	public Employee(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	/**
	 * Returns jobs.
	 * @return jobs 
	 */
	public Set<Job> getJobs() {
		return this.jobs;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	
	  public Employee getManager() {
		  return manager; 
	  }
	  
	  public void setManager(Employee manager) { 
		  this.manager = manager;
	  }
	 

	
	  public Set<Employee> getSubordinates() { 
		  return subordinates; 
	  }
	  
	  public void setSubordinates(Set<Employee> subordinates) { 
		  this.subordinates = subordinates; 
	 }
	 

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	

}
