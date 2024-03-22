package Wedding.Planner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event1 {
	
	  private String name;
	    private LocalDate date;
	    private List<Task> tasks;

	    public Event1(String name, LocalDate date) {
	        this.name = name;
	        this.date = date;
	        this.tasks = new ArrayList<>();
	    }

	    public void addTask(Task task) {
	        tasks.add(task);
	    }

	    public List<Task> getTasks() {
	        return tasks;
	    }

	    public void displayEventDetails() {
	        System.out.println("Event: " + name + " on " + date);
	        for (Task task : tasks) {
	            System.out.println("   " + task);
	        }
	    }
	    
}
