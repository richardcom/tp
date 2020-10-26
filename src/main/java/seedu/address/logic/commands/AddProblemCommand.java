package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SEVERITY;

import java.io.IOException;

import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.Problem.Problem;
import seedu.address.model.Problem.ProblemList;
import seedu.address.storage.StorageForProblem;

/**
 * Adds a book to the address book.
 */
public class AddProblemCommand extends Command {

    public static final String COMMAND_WORD = "report";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Reports a problem. " + "Parameters: " + PREFIX_SEVERITY
            + "severity " + PREFIX_DESCRIPTION + "description ";

    public static final String MESSAGE_SUCCESS = "Problem reported: %1$s";

    private final Problem toAdd;

    /**
     * Creates an AddProblemCommand to add the specified {@code Problem}
     */
    public AddProblemCommand(Problem problem) {
        requireNonNull(problem);
        toAdd = problem;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException, IOException {
        requireNonNull(model);

        //model.addProblem(toAdd);
        ProblemList.setList(StorageForProblem.load());
        ProblemList.add(toAdd);
        //ProblemList problemList = model.getProblemList();
        //StorageForProblem storageForProblem = model.getProblemStorage();
        StorageForProblem.writeData(ProblemList.getList());
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddProblemCommand // instanceof handles nulls
                && toAdd.equals(((AddProblemCommand) other).toAdd));
    }
}
