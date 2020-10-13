package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.book.Book;

/**
 * Deletes a book identified using name, isbn, or times.
 */
public class DeleteByCommand extends Command {

    public static final String COMMAND_WORD = "deleteBy";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the book identified by the name.\n"
            + "Parameters: NAME \n"
            + "Example: " + COMMAND_WORD + " Linear Algebra";

    public static final String MESSAGE_DELETE_BOOK_SUCCESS = "Deleted Book: %1$s";

    private final String targetName;
    private final int attribute;

    // private NameMatchesKeywordPredicate predicate;

    /**
     * Delete a book by name, isbn or times.
     * @param targetName a string representing the input content.
     * @param attribute indicating which attribute shall we refer to when deleting.
     */
    public DeleteByCommand(String targetName, int attribute) {
        this.targetName = targetName;
        this.attribute = attribute;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Book> lastShownList = model.getFilteredBookList();
        Book bookToDelete = null;

        for (Book book : lastShownList) {
            switch (attribute) {
            case 0:
                if (book.getName().fullName.equals(targetName)) {
                    bookToDelete = book;
                }
                break;
            case 1:
                if (book.getIsbn().value.equals(targetName)) {
                    bookToDelete = book;
                }
                break;
            default:
                if (Integer.parseInt(book.getTimes().value) >= Integer.parseInt(targetName)) {
                    bookToDelete = book;
                }
                break;
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
                || (other instanceof DeleteByCommand // instanceof handles nulls
                && targetName.equals(((DeleteByCommand) other).targetName)); // state check
    }

}
