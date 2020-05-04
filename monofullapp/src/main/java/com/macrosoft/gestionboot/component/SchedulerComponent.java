package com.macrosoft.gestionboot.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerComponent {
	
	
	//@Scheduled(fixedDelay = 1000, initialDelay = 1000)
	
	// The task will be executed a first time after the initialDelay value
	//– and it will continue to be executed according to the fixedDelay.
	
	
	/**
	 * 
	 *  in this example, that we're scheduling a task to be executed at 10:15 AM
	 *   on the 15th day of every month.
	 */
	@Scheduled(cron = "0 15 10 15 * ?")
	public void scheduleTaskUsingCronExpression() {
	  
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "schedule tasks using cron jobs - " + now);
	}
	
	
	//Parameterizing the Schedule in  application.properties
	
	@Scheduled(cron = "${schedule.mycron.task.param}")
	public void scheduleParmTaskUsingCronExpression() {
	  
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "schedule tasks using cron jobs - " + now);
	}
	
	/**
	 * 
	 * The following is a sample code that shows how to execute 
	 * the task every minute starting at 9:00 AM and ending at 9:59 AM, every day
	 */
	  @Scheduled(cron = "0 30 9 * * ?")
	   public void cronJobSch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Java cron job expression:: " + strDate);
	   }

}
