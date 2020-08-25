package main.java;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.LocalDateTime;



public class Event extends Task {
    private LocalDateTime start;
    private LocalDateTime end;
    private static DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM d yyyy HHmm");

    public Event (String description, String period) {
        super(description);
        this.start = LocalDateTime.parse(period.substring(0,15), inputFormatter);
        this.end = LocalDateTime.parse(period.substring(19), inputFormatter);
    }

    public Event(boolean isDone, String description, String period) {
        super(isDone, description);
        this.start = LocalDateTime.parse(period.substring(0,15), inputFormatter);
        this.end = LocalDateTime.parse(period.substring(19), inputFormatter);
    }

    String getPeriod() {
        return this.start.format(outputFormatter).toString() + " to " + this.end.format(outputFormatter).toString();
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription() + " (at: " + getPeriod() +")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Event) {
            Event task = (Event) o;
            return this.description.equals(task.description) && this.start.equals(task.start)
                    && this.end.equals(task.end) && this.isDone == task.isDone;
        } else {
            return false;
        }
    }

    @Override
    public String saveFormat() {
        if (isDone) {
            return "E | 1 | " + this.getDescription() + " | " + this.start.format(inputFormatter)
                    + " to " + this.end.format(inputFormatter);
        } else {
            return "E | 0 | " + this.getDescription() + " | " + this.start.format(inputFormatter)
                    + " to " + this.end.format(inputFormatter);
        }
    }
}

