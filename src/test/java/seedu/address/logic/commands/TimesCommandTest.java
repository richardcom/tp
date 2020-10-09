package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIMES_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIMES_BOB;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalBooks.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.book.Book;
import seedu.address.model.book.Times;
import seedu.address.testutil.BookBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for TimesCommand.
 */
public class TimesCommandTest {

    private static final String TIMES_STUB = "Some times";

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_addRemarkUnfilteredList_success() {
        Book firstBook = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Book editedBook = new BookBuilder(firstBook).withTimes(TIMES_STUB).build();

        TimesCommand remarkCommand = new TimesCommand(INDEX_FIRST_PERSON, new Times(editedBook.getTimes().value));

        String expectedMessage = String.format(TimesCommand.MESSAGE_ADD_TIMES_SUCCESS, editedBook);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(firstBook, editedBook);

        assertCommandSuccess(remarkCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_deleteRemarkUnfilteredList_success() {
        Book firstBook = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Book editedBook = new BookBuilder(firstBook).withTimes("").build();

        TimesCommand remarkCommand = new TimesCommand(INDEX_FIRST_PERSON,
                new Times(editedBook.getTimes().toString()));

        String expectedMessage = String.format(TimesCommand.MESSAGE_DELETE_TIMES_SUCCESS, editedBook);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(firstBook, editedBook);

        assertCommandSuccess(remarkCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_filteredList_success() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);

        Book firstBook = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Book editedBook = new BookBuilder(model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased()))
                .withTimes(TIMES_STUB).build();

        TimesCommand remarkCommand = new TimesCommand(INDEX_FIRST_PERSON, new Times(editedBook.getTimes().value));

        String expectedMessage = String.format(TimesCommand.MESSAGE_ADD_TIMES_SUCCESS, editedBook);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(firstBook, editedBook);

        assertCommandSuccess(remarkCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidPersonIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredPersonList().size() + 1);
        TimesCommand remarkCommand = new TimesCommand(outOfBoundIndex, new Times(VALID_TIMES_BOB));

        assertCommandFailure(remarkCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    /**
     * Edit filtered list where index is larger than size of filtered list,
     * but smaller than size of address book
     */
    @Test
    public void execute_invalidPersonIndexFilteredList_failure() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);
        Index outOfBoundIndex = INDEX_SECOND_PERSON;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAddressBook().getPersonList().size());

        TimesCommand remarkCommand = new TimesCommand(outOfBoundIndex, new Times(VALID_TIMES_BOB));

        assertCommandFailure(remarkCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
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

        // different times -> returns false
        assertFalse(standardCommand.equals(new TimesCommand(INDEX_FIRST_PERSON, new Times(VALID_TIMES_BOB))));
    }
}
