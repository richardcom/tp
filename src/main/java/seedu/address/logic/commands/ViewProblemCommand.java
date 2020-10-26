package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.problem.Problem;
import seedu.address.storage.StorageForProblem;

public class ViewProblemCommand extends Command {
    public static final String COMMAND_WORD = "view";
    public static final String MESSAGE_SUCCESS = "View problems";

    public ViewProblemCommand() {

    }

    @Override
    public CommandResult execute(Model model) throws CommandException, FileNotFoundException {
        requireNonNull(model);

        ArrayList<Problem> list = StorageForProblem.load();
        StringBuilder problemString = new StringBuilder();
        for (Problem problem: list) {
            problemString.append(problem.toString());
            problemString.append("\n");
        }

        return new CommandResult(problemString.toString());
    }
}
