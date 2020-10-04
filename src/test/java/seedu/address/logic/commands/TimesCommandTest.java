package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static seedu.address.logic.commands.CommandTestUtil.VALID_TIMES_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIMES_BOB;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.TimesCommand.MESSAGE_ARGUMENTS;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Times;

/**
 * Contains integration tests (interaction with the Model) and unit tests for TimesCommand.
 */
public class TimesCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute() {
        final String times = "Some times";

        assertCommandFailure(new TimesCommand(INDEX_FIRST_PERSON, new Times(times)), model,
                String.format(MESSAGE_ARGUMENTS, INDEX_FIRST_PERSON.getOneBased(), times));
    }
        
    @Test
    public void equals() {
        final TimesCommand standardCommand = new TimesCommand(INDEX_FIRST_PERSON, new Times(VALID_TIMES_AMY));

        // same values -> returns true
        TimesCommand commandWithSameValues = new TimesCommand(INDEX_FIRST_PERSON, new Times (VALID_TIMES_AMY));
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new TimesCommand(INDEX_SECOND_PERSON, new Times(VALID_TIMES_AMY))));

        // different remark -> returns false
        assertFalse(standardCommand.equals(new TimesCommand(INDEX_FIRST_PERSON, new Times(VALID_TIMES_BOB))));
    }
}