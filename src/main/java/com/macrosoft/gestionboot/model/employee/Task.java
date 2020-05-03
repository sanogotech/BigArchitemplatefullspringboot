package com.macrosoft.gestionboot.model.employee;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Description of Task.
 * 
 * @author User
 */
@Entity
public class Task {
	
	@Id
	@GeneratedValue
	//Default
	// @GeneratedValue(strategy=AUTO)
	private Long  idTask;
	
	private String  taskTitle;
	
	private String  taskDescription;
	

	/**
	 * The constructor.
	 */
	public Task() {
		super();
	}


	public String getTaskTitle() {
		return taskTitle;
	}


	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}


	public String getTaskDescription() {
		return taskDescription;
	}


	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	


}
