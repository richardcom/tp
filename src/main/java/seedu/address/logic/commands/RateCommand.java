package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.book.Book;

/**
 * Rates a book identified using it's displayed index from the address book.
 */
public class RateCommand extends Command {

    public static final String COMMAND_WORD = "rate";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Rates the book identified by the index number used in the displayed book list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_RATE_BOOK_SUCCESS = "Rated Book: %1$s";

    private final int rating;
    private final Index targetIndex;

    public RateCommand(Index index, int rating) {
        this.targetIndex = index;
        this.rating = rating;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Book> lastShownList = model.getFilteredBookList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_BOOK_DISPLAYED_INDEX);
        }

        Book bookToRate = lastShownList.get(targetIndex.getZeroBased());
        model.rateBook(bookToRate);
        return new CommandResult(String.format(MESSAGE_RATE_BOOK_SUCCESS, bookToRate));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RateCommand // instanceof handles nulls
                && targetIndex.equals(((RateCommand) other).targetIndex)); // state check
    }
}
