package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.book.NameContainsKeywordsPredicate;
import seedu.address.model.book.NumberContainsKeywordPredicate;
import seedu.address.model.book.Book;
import seedu.address.ui.Mode;

public class StockCommand extends Command {
    public static final String COMMAND_WORD = "stock";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Search for the stocking of all the books with"
            + "the corresponding keyword and shows them as a list.\n"
            + "Parameters: KEYWORD\n"
            + "Example: " + COMMAND_WORD + " n/ a brief history of time";

    private Predicate<Book> predicate;

    /**
     * Creates a StockCommand to search for the stocking information in each location.
     *
     * @param names The list of names that are used as keyword.
     * @param numbers The list of numbers that are used as keyword.
     */
    public StockCommand(List<String> names, List<String> numbers) {
        //Predicate<Book> personPredicate;
        NameContainsKeywordsPredicate nameContainsKeywordsPredicate;
        NumberContainsKeywordPredicate numberContainsKeywordPredicate;
        if (names != null && numbers != null) {
            nameContainsKeywordsPredicate = new NameContainsKeywordsPredicate(names);
            numberContainsKeywordPredicate = new NumberContainsKeywordPredicate(numbers);
            predicate = (person -> nameContainsKeywordsPredicate.test(person)
                    || numberContainsKeywordPredicate.test(person));
        } else if (names != null) {
            predicate = new NameContainsKeywordsPredicate(names);
        } else if (numbers != null) {
            System.out.println("In stock command, the number is used as the search key");
            predicate = new NumberContainsKeywordPredicate(numbers);
        } else {
            predicate = Model.PREDICATE_SHOW_ALL_PERSONS;
        }
    };

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.updateFilteredPersonList((person -> false), Mode.NORMAL);
        model.updateFilteredPersonList(predicate, Mode.DETAIL);
        System.out.println("In stock command, set the mode to detail mode");
        return new CommandResult(String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW,
                model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof StockCommand
                    && this.predicate.equals(((StockCommand) other).predicate));
    }
}
