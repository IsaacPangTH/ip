package task;

public class ToDo extends Task {
    public ToDo(String title) {
        super(title);
    }

    @Override
    public String getTypeIcon() {
        return "T";
    }
}
