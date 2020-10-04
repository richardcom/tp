package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIMES;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.Times;

/**
 * Changes the times of an existing book in the database.
 */
public class TimesCommand extends Command {
    public static final String COMMAND_WORD = "times";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the times of the person identified "
            + "by the index number used in the last book listing. "
            + "Existing times will be overwritten by the input.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_TIMES + "[TIMES]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_TIMES + "Likes to swim.";
    
    public static final String MESSAGE_ADD_TIMES_SUCCESS = "Added times to Book: %1$s";
    public static final String MESSAGE_DELETE_TIMES_SUCCESS = "Removed times from Book: %1$s";

    private final Index index;
    private final Times times;
    /**
     * @param index of the book in the filtered book list to edit the times
     * @param times of the book being borrowed to be updated to
     */
    public TimesCommand(Index index, Times times) {
        requireAllNonNull(index, times);
        this.index = index;
        this.times = times;
    }
    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        Person editedPerson = new Person(personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                personToEdit.getAddress(), times, personToEdit.getTags());

        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

        return new CommandResult(generateSuccessMessage(editedPerson));
    }

    /**
     * Generates a command execution success message based on whether the times is added to or removed from
     * {@code bookToEdit}.
     */
    private String generateSuccessMessage(Person personToEdit) {
        String message = !times.value.isEmpty() ? MESSAGE_ADD_TIMES_SUCCESS : MESSAGE_DELETE_TIMES_SUCCESS;
        return String.format(message, personToEdit);
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
