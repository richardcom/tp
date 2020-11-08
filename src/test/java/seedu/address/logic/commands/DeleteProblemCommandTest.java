package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.book.Book;
import seedu.address.model.problem.Problem;
import seedu.address.ui.Mode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.TypicalIndexes.*;
import static seedu.address.testutil.TypicalProblems.getTypicalReportLibrary;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * {@code DeleteCommand}.
 */
public class DeleteProblemCommandTest {

    private Model model = new ModelManager(getTypicalReportLibrary(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Problem problemToDelete = model.getFilteredProblemList().get(INDEX_FIRST_REPORT.getZeroBased());
        DeleteProblemCommand deleteProblemCommand = new DeleteProblemCommand(INDEX_FIRST_REPORT);

        String expectedMessage = String.format(DeleteProblemCommand.MESSAGE_DELETE_PROBLEM_SUCCESS, problemToDelete);

        ModelManager expectedModel = new ModelManager(model.getLibrary(), new UserPrefs());
        expectedModel.deleteProblem(problemToDelete);
        assertCommandSuccess(deleteProblemCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredBookList().size() + 1);
        DeleteCommand deleteCommand = new DeleteCommand(outOfBoundIndex);

        assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_BOOK_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showBookAtIndex(model, INDEX_FIRST_BOOK);

        Book bookToDelete = model.getFilteredBookList().get(INDEX_FIRST_BOOK.getZeroBased());
        DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST_BOOK);

        String expectedMessage = String.format(DeleteCommand.MESSAGE_DELETE_BOOK_SUCCESS, bookToDelete);

        Model expectedModel = new ModelManager(model.getLibrary(), new UserPrefs());
        expectedModel.deleteBook(bookToDelete);
        showNoBook(expectedModel);

        assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showBookAtIndex(model, INDEX_FIRST_BOOK);

        Index outOfBoundIndex = INDEX_SECOND_BOOK;
        // ensures that outOfBoundIndex is still in bounds of library list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getLibrary().getBookList().size());

        DeleteCommand deleteCommand = new DeleteCommand(outOfBoundIndex);

        assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_BOOK_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        DeleteCommand deleteFirstCommand = new DeleteCommand(INDEX_FIRST_BOOK);
        DeleteCommand deleteSecondCommand = new DeleteCommand(INDEX_SECOND_BOOK);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        DeleteCommand deleteFirstCommandCopy = new DeleteCommand(INDEX_FIRST_BOOK);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different book -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }

    /**
     * Updates {@code model}'s filtered list to show no one.
     */
    private void showNoBook(Model model) {
        model.updateFilteredBookList(p -> false, Mode.NORMAL);

        assertTrue(model.getFilteredBookList().isEmpty());
    }
}
