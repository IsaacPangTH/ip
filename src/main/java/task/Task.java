package task;

import exceptions.AlreadyCompletedException;
import exceptions.StartAfterEndException;

public abstract class Task {

    private boolean isCompleted = false;
    private String title;

    public Task(String title) {
        this.title = title;
    }

    public static Task of(String data) throws AlreadyCompletedException, StartAfterEndException {
        String[] args = data.split("\\|");
        //@formatter:off
        return switch (args[0]) {
        case "T" -> ToDo.of(args);
        case "D" -> Deadline.of(args);
        case "E" -> Event.of(args);
        default -> null;
        };
        //@formatter:on
    }

    public void complete() throws AlreadyCompletedException {
        if (this.isCompleted) {
            throw new AlreadyCompletedException();
        }
        this.isCompleted = true;
    }

    public String getStatusIcon() {
        return (this.isCompleted ? "X" : " ");
    }

    public abstract String getTypeIcon();

    public String toData() {
        return String.format("%s|%b|%s", this.getTypeIcon(), this.isCompleted, this.title);
    }

    @Override
    public String toString() {
        return this.title;
    }
}

