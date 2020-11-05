package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.*;

import seedu.address.model.problem.Problem;

/**
 * A utility class containing a list of {@code problems} objects to be used in tests.
 */
public class TypicalProblems {
    public static final Problem P1 =
            new ProblemBuilder().withSeverity(VALID_SEVERITY_P1).withDescription(VALID_DESCRIPTION_P1).build();
    public static final Problem P2 =
            new ProblemBuilder().withSeverity(VALID_SEVERITY_P2).withDescription(VALID_DESCRIPTION_P2).build();
}
