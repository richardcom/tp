package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_BOOKS;

import seedu.address.model.Model;
import seedu.address.ui.Mode;

/**
 * Lists all books in the language book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all books";

    /**
     * Execute usage command on model and return with result.
     *
     * @param model {@code Model} which the command should operate on.
     * @return a new CommandResult object
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        model.updateFilteredBookList((book -> false), Mode.NORMAL);
        model.updateFilteredBookList(PREDICATE_SHOW_ALL_BOOKS, Mode.NORMAL);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
