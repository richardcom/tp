package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.book.Book;

/**
 * Deletes a book identified using it's displayed index from the address book.
 */
public class DeleteByNameCommand extends Command {

    public static final String COMMAND_WORD = "deleteByName";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the book identified by the name.\n"
            + "Parameters: NAME \n"
            + "Example: " + COMMAND_WORD + " Linear Algebra";

    public static final String MESSAGE_DELETE_BOOK_SUCCESS = "Deleted Book: %1$s";

    private final String targetName;

    // private NameMatchesKeywordPredicate predicate;

    public DeleteByNameCommand(String targetName) {
        this.targetName = targetName;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Book> lastShownList = model.getFilteredBookList();
        Book bookToDelete = null;

        for (Book book : lastShownList) {
            if (book.getName().fullName.equals(targetName)) {
                bookToDelete = book;
            }
        }

        if (bookToDelete == null) {
            throw new CommandException(Messages.MESSAGE_INVALID_BOOK_DELETE_NAME);
        }
        model.deleteBook(bookToDelete);


        return new CommandResult(String.format(MESSAGE_DELETE_BOOK_SUCCESS, bookToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteByNameCommand // instanceof handles nulls
                && targetName.equals(((DeleteByNameCommand) other).targetName)); // state check
    }

}
