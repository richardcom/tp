package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ISBN;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.ArrayList;
import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.book.Book;

/**
 * Usages a book identified using name, isbn, or times.
 */
public class UsageByCommand extends Command {

    public static final String COMMAND_WORD = "usageBy";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Get the usage of the book identified by the name or isbn\n"
            + "Parameters: NAME OR ISBN\n"
            + "Example: " + "1. " + COMMAND_WORD + " " + PREFIX_NAME + "Linear Algebra" + "   "
            + "2. " + COMMAND_WORD + " " + PREFIX_ISBN + "123456";

    public static final String MESSAGE_USAGE_BOOK_SUCCESS = "Usage of selected book: %1$s";

    private final String target;
    private final int attribute;

    // private NameMatchesKeywordPredicate predicate;

    /**
     * Usage a book by name, isbn or times.
     * @param target a string representing the input content.
     * @param attribute indicating which attribute shall we refer to when deleting.
     */
    public UsageByCommand(String target, int attribute) {
        this.target = target;
        this.attribute = attribute;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Book> lastShownList = model.getFilteredBookList();
        Book bookToUsage = null;
        List<Book> usageList = new ArrayList<>();

        for (Book book : lastShownList) {

        }

        return new CommandResult(String.format(MESSAGE_USAGE_BOOK_SUCCESS, usageList.toString()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UsageByCommand // instanceof handles nulls
                && target.equals(((UsageByCommand) other).target)); // state check
    }

}
