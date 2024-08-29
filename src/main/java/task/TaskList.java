package task;

import exceptions.AlreadyCompletedException;
import exceptions.TaskDoesNotExistException;

import java.util.ArrayList;


public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public void add(Task item) {
        list.add(item);
    }

    public void complete(int index) throws AlreadyCompletedException, TaskDoesNotExistException {
        try {
            Task task = list.get(index);
            if (task == null) throw new TaskDoesNotExistException(index);
            task.complete();
        } catch (IndexOutOfBoundsException e) {
            throw new TaskDoesNotExistException(index);
        }
    }

    public String taskAt(int index) {
        return list.get(index).toString();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String delete(int index) throws TaskDoesNotExistException {
        try {
            Task task = list.get(index);
            if (task == null) throw new TaskDoesNotExistException(index);
            list.remove(index);
            return task.toString();
        } catch (IndexOutOfBoundsException e) {
            throw new TaskDoesNotExistException(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            output.append(String.format("%d.[%s][%s] %s\n", i + 1, list.get(i).getTypeIcon(), list.get(i).getStatusIcon(), list.get(i)));
        }
        return output.toString();
    }
}