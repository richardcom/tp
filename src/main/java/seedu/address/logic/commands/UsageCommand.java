package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.book.Book;

/**
 * Check usage of a book identified using it's displayed index from the address book.
 */
public class UsageCommand extends Command {
    public static final String COMMAND_WORD = "usage";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Usages the book identified by the index number used in the displayed book list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_USAGE_BOOK_SUCCESS = "Usage of selected book: %1$s";

    private final Index targetIndex;

    public UsageCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Book> lastShownList = model.getFilteredBookList();

        if (targetIndex.getZeroBased() >= lastShownList.size() || targetIndex.getZeroBased() <= 0) {
            throw new CommandException(Messages.MESSAGE_INVALID_BOOK_DISPLAYED_INDEX);
        }

        return new CommandResult(String.format(MESSAGE_USAGE_BOOK_SUCCESS,
                lastShownList.get(targetIndex.getZeroBased()).getTimes().getValue()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UsageCommand // instanceof handles nulls
                && targetIndex.equals(((UsageCommand) other).targetIndex)); // state check
    }
}
