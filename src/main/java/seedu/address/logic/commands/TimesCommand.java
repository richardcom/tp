package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIMES;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Changes the remark of an existing person in the address book.
 */
public class TimesCommand extends Command {

    public static final String COMMAND_WORD = "times";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the times of the person identified "
            + "by the index number used in the last book listing. "
            + "Existing times will be overwritten by the input.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_TIMES + "[TIMES]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_TIMES + "1";

    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Times: %2$s";


    private final Index index;
    private final String times;

    /**
     * @param index of the book in the filtered book list to edit the remark
     * @param times of the book to be updated to
     */
    public TimesCommand(Index index, String times) {
        requireAllNonNull(index, times);

        this.index = index;
        this.times = times;
    }
    
    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException(String.format(MESSAGE_ARGUMENTS, index.getOneBased(), times));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TimesCommand)) {
            return false;
        }

        // state check
        TimesCommand e = (TimesCommand) other;
        return index.equals(e.index)
                && times.equals(e.times);
    }
}