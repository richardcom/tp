package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.book.Book;
import seedu.address.testutil.BookBuilder;
import seedu.address.ui.Mode;

public class AddCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddCommand(null));
    }

    @Test
    public void execute_personAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
        Book validBook = new BookBuilder().build();

        CommandResult commandResult = new AddCommand(validBook).execute(modelStub);

        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validBook), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validBook), modelStub.personsAdded);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Book validBook = new BookBuilder().build();
        AddCommand addCommand = new AddCommand(validBook);
        ModelStub modelStub = new ModelStubWithPerson(validBook);

        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_PERSON, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Book alice = new BookBuilder().withName("Alice").build();
        Book bob = new BookBuilder().withName("Bob").build();
        AddCommand addAliceCommand = new AddCommand(alice);
        AddCommand addBobCommand = new AddCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddCommand addAliceCommandCopy = new AddCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different book -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Book book) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Book book) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Book target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Book target, Book editedBook) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Book> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Book> predicate, Mode mode) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single book.
     */
    private class ModelStubWithPerson extends ModelStub {
        private final Book book;

        ModelStubWithPerson(Book book) {
            requireNonNull(book);
            this.book = book;
        }

        @Override
        public boolean hasPerson(Book book) {
            requireNonNull(book);
            return this.book.isSamePerson(book);
        }
    }

    /**
     * A Model stub that always accept the book being added.
     */
    private class ModelStubAcceptingPersonAdded extends ModelStub {
        final ArrayList<Book> personsAdded = new ArrayList<>();

        @Override
        public boolean hasPerson(Book book) {
            requireNonNull(book);
            return personsAdded.stream().anyMatch(book::isSamePerson);
        }

        @Override
        public void addPerson(Book book) {
            requireNonNull(book);
            personsAdded.add(book);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }

}
