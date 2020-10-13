package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalBooks.getTypicalAddressBook;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_BOOK;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.book.Book;


/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * {@code DeleteCommand}.
 */
public class DeleteByNameCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validBookToBeDeleted_success() {
        Book bookToDelete = model.getFilteredBookList().get(INDEX_FIRST_BOOK.getZeroBased());
        String name1 = bookToDelete.getName().fullName;
        DeleteByNameCommand deleteByNameCommand = new DeleteByNameCommand(name1);

        String expectedMessage = String.format(DeleteByNameCommand.MESSAGE_DELETE_BOOK_SUCCESS, bookToDelete);

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.deleteBook(bookToDelete);

        assertCommandSuccess(deleteByNameCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidBookName_throwsCommandException() {
        String bookName = " ";

        DeleteByNameCommand deleteByNameCommand = new DeleteByNameCommand(bookName);

        assertCommandFailure(deleteByNameCommand, model, Messages.MESSAGE_INVALID_BOOK_DELETE_NAME);
    }

    @Test
    public void equals() {
        DeleteByNameCommand deleteFirstCommand = new DeleteByNameCommand("TEST");
        DeleteByNameCommand deleteSecondCommand = new DeleteByNameCommand("TEST2");

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        DeleteByNameCommand deleteFirstCommandCopy = new DeleteByNameCommand("TEST");
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different book -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }

}
