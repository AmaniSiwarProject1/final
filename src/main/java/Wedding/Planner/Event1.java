package Wedding.Planner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Event1 {

    private static final Logger logger = Logger.getLogger(Event1.class.getName());
    
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
        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("Event: %s on %s", name, date));
            for (Task task : tasks) {
                logger.info("   " + task);
            }
        }
    }
    
}
