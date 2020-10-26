package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.Problem.Problem;
import seedu.address.model.Problem.ProblemList;
import seedu.address.model.book.Book;
import seedu.address.model.book.UniqueBookList;
import seedu.address.storage.StorageForProblem;

/**
 * Wraps all data at the library level Duplicates are not allowed (by
 * .isSameBook comparison)
 */
public class Library implements ReadOnlyLibrary {

    private final UniqueBookList books;
    private ProblemList problems;
    StorageForProblem storageForProblem;

    /*
     * The 'unusual' code block below is a non-static initialization block,
     * sometimes used to avoid duplication between constructors. See
     * https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other
     * ways to avoid duplication among constructors.
     */
    {
        books = new UniqueBookList();
        problems = new ProblemList();
        try {
            storageForProblem = new StorageForProblem("File.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Library() {}

    /**
     * Creates an Library using the Books in the {@code toBeCopied}
     */
    public Library(ReadOnlyLibrary toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the book list with {@code books}.
     * {@code books} must not contain duplicate books.
     */
    public void setBooks(List<Book> books) {
        this.books.setBooks(books);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyLibrary newData) {
        requireNonNull(newData);

        setBooks(newData.getBookList());
    }

    //// book-level operations

    /**
     * Returns true if a book with the same identity as {@code book} exists in the library.
     */
    public boolean hasBook(Book book) {
        requireNonNull(book);
        return books.contains(book);
    }

    /**
     * Adds a book to the library.
     * The book must not already exist in the library.
     */
    public void addBook(Book p) {
        books.add(p);
    }

    /**
     * Replaces the given book {@code target} in the list with {@code editedBook}.
     * {@code target} must exist in the library.
     * The book identity of {@code editedBook} must not be the same as another existing book in the library.
     */
    public void setBook(Book target, Book editedBook) {
        requireNonNull(editedBook);

        books.setBook(target, editedBook);
    }

    /**
     * Removes {@code key} from this {@code Library}.
     * {@code key} must exist in the address book.
     */
    public void removeBook(Book key) {
        books.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return books.asUnmodifiableObservableList().size() + " books";
        // TODO: refine later
    }

    @Override
    public ObservableList<Book> getBookList() {
        return books.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Library // instanceof handles nulls
                && books.equals(((Library) other).books));
    }

    @Override
    public int hashCode() {
        return books.hashCode();
    }

    /**
     * Adds a book to the library.
     * The book must not already exist in the library.
     */
    public void addProblem(Problem problem) {
        problems.add(problem);
    }

    public ProblemList getProblemList() {
        return problems;
    }

    public StorageForProblem getProblemStorage() {
        return storageForProblem;
    }
}
