package seedu.address.model.Problem;

public class Problem {
    private final Severity severity;
    private final Description description;

    public Problem(Severity severity, Description description) {
        this.severity = severity;
        this.description = description;
    }

    public Severity getSeverity() {
        return severity;
    }

    public Description getDescription() {
        return description;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Description: ")
                .append(getDescription())
                .append(" Severity: ")
                .append(getSeverity());
        return builder.toString();
    }
}
