package main.java;

import java.util.ArrayList;

public class TaskList {
    ArrayList<Task> list;

    public TaskList() {
        list = new ArrayList<Task>();
    }

    public void delete(int index) throws BobIndexOutOfBoundsException {
        try {
            list.remove(index-1);
        } catch (IndexOutOfBoundsException e) {
            throw new BobIndexOutOfBoundsException();
        }
    }

    public void add(Task task) {
        list.add(task);
    }

    public Task get(int index) throws BobIndexOutOfBoundsException {
        try {
            return list.get(index - 1);
        } catch(IndexOutOfBoundsException e) {
            throw new BobIndexOutOfBoundsException();
        }
    }

    public int size() {return list.size(); }

    public boolean isEmpty() {return list.isEmpty();}

    TaskList contains(String keyWord) throws BobIndexOutOfBoundsException {
        TaskList keyWordTasks = new TaskList();
        for(int i = 1; i < this.size(); i++) {
            if (this.get(i).toString().contains(keyWord)) {
                keyWordTasks.add(this.get(i));
            }
        }
        return keyWordTasks;
    }
}
