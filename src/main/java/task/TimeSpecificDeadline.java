package task;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A time-specific deadline task
 *
 * @author IsaacPangTH
 */
public class TimeSpecificDeadline extends Deadline {

    private LocalTime dueTime;

    /**
     * Constructor for <code>TimeSpecificDeadline</code>.
     *
     * @param description Description of the deadline.
     * @param dueDate Due date of the deadline.
     * @param dueTime Due time of the deadline.
     */
    public TimeSpecificDeadline(String description, LocalDate dueDate, LocalTime dueTime, boolean isCompleted) {
        super(description, dueDate, isCompleted);
        this.dueTime = dueTime;
    }

    /**
     * Returns data of the time-specific deadline as a string.
     *
     * @return data in form "type|completion status|description|due date /at due time".
     */
    @Override
    public String toData() {
        assert this.dueTime != null : "Due time should not be null";
        return super.toData() + "/at " + dueTime;
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst("\\)", " at " + dueTime + ")");
    }
}
