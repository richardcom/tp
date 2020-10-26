package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.Problem.Problem;
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
        String problem_string = "";
        for (Problem problem: list) {
            problem_string += problem.toString();
            problem_string += "\n";
        }
        //System.out.println(list_of_problems);
        return new CommandResult(problem_string);
    }
}
