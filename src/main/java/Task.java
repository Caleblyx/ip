package main.java;


public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(boolean isDone, String description) {
        this.description = description;
        this.isDone = isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getDescription() {
        return this.description;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Task) {
            Task task = (Task) o;
            return this.description.equals(task.description) && this.isDone == task.isDone;
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }

    public String saveFormat() {
        if (isDone) {
            return "T | 1 | " + this.getDescription();
        } else {
            return "T | 0 | " + this.getDescription();
        }
    }
}

