package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.book.Book;

/**
 * Check usage of a book identified using its displayed index from the list.
 */
public class UsageCommand extends Command {
    public static final String COMMAND_WORD = "usage";

    private final Index targetIndex;

    public UsageCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Book> lastShownList = model.getFilteredBookList();
        int size = lastShownList.size();

        if (invalidSizeComparedTo(size)) {
            throw new CommandException(Messages.MESSAGE_INVALID_BOOK_DISPLAYED_INDEX);
        }

        return new CommandResult(String.format(Messages.MESSAGE_USAGE_BOOK_SUCCESS,
                getUsage(lastShownList.get(targetIndex.getZeroBased()))));
    }

    private boolean invalidSizeComparedTo(int size) {
        return targetIndex.getZeroBased() >= size || targetIndex.getZeroBased() < 0;
    }

    private int getUsage(Book book) {
        return book.getTimes().getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UsageCommand // instanceof handles nulls
                && targetIndex.equals(((UsageCommand) other).targetIndex)); // state check
    }
}
