package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.book.Book;
import seedu.address.model.book.NameContainsKeywordsPredicate;
import seedu.address.model.book.NumberContainsKeywordPredicate;
import seedu.address.model.review.Review;
import seedu.address.ui.Mode;

/**
 * Searches for the review of the corresponding book.
 */
public class SearchReviewCommand extends Command {
    public static final String COMMAND_WORD = "searchReview";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Show the review for all the books with"
            + "the corresponding keyword and shows them as a list.\n"
            + "Parameters: KEYWORD\n"
            + "Example: " + COMMAND_WORD + " n/ a brief history of time";

    private Predicate<Book> predicate;

    private Review review;

    /**
     * Creates a StockCommand to search for the stocking information in each location.
     *
     * @param names The list of names that are used as keyword.
     * @param numbers The list of numbers that are used as keyword.
     */
    public SearchReviewCommand(List<String> names, List<String> numbers) {
        //Predicate<Book> bookPredicate;
        NameContainsKeywordsPredicate nameContainsKeywordsPredicate;
        NumberContainsKeywordPredicate numberContainsKeywordPredicate;
        if (names != null && numbers != null) {
            nameContainsKeywordsPredicate = new NameContainsKeywordsPredicate(names);
            numberContainsKeywordPredicate = new NumberContainsKeywordPredicate(numbers);
            predicate = (book -> nameContainsKeywordsPredicate.test(book)
                    || numberContainsKeywordPredicate.test(book));
        } else if (names != null) {
            predicate = new NameContainsKeywordsPredicate(names);
        } else if (numbers != null) {
            predicate = new NumberContainsKeywordPredicate(numbers);
        } else {
            predicate = Model.PREDICATE_SHOW_ALL_BOOKS;
        }
    };

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.updateFilteredBookList((book -> false), Mode.NORMAL);
        model.updateFilteredBookList(predicate, Mode.REVIEW);
        return new CommandResult(String.format(Messages.MESSAGE_BOOKS_LISTED_OVERVIEW,
                model.getFilteredBookList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof SearchReviewCommand
                && this.predicate.equals(((SearchReviewCommand) other).predicate));
    }
}
