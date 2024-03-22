package Wedding.Planner;

import java.time.LocalDate;

public class Task {
	   private String description;
	    private LocalDate dueDate;
	    private boolean isCompleted;

	    public Task(String description, LocalDate dueDate) {
	        this.description = description;
	        this.dueDate = dueDate;
	        this.isCompleted = false;
	    }

	    public void markCompleted() {
	        isCompleted = true;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public LocalDate getDueDate() {
	        return dueDate;
	    }

	    @Override
	    public String toString() {
	        return "Task: " + description + " | Due: " + dueDate + " | Completed: " + isCompleted;
	    }
	

}
