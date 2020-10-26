package seedu.address.model.Problem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.book.Book;
import seedu.address.model.book.UniqueBookList;
import seedu.address.model.book.exceptions.DuplicateBookException;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

public class ProblemList implements Iterable<Problem> {
    private final ObservableList<Problem> list = FXCollections.observableArrayList();
    private final ObservableList<Problem> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(list);

    /**
     * Returns true if the list contains an equivalent book as the given argument.
     */
    public boolean contains(Problem toCheck) {
        requireNonNull(toCheck);
        return list.stream().anyMatch(toCheck::isSameProblem);
    }

    /**
     * Adds a problem to the list.
     */
    public void add(Problem toAdd) {
        requireNonNull(toAdd);
        list.add(toAdd);
    }

    /**
     * Deletes a problem to the list.
     */
    public void delete(Problem toDelete) {
        requireNonNull(toDelete);
        list.add(toDelete);
    }

    public List<Problem> getList() {
        return list;
    }

    public void setProblems(ProblemList replacement) {
        requireNonNull(replacement);
        list.setAll(replacement.list);
    }

    public void setProblems(List<Problem> problems) {
        requireAllNonNull(problems);
        list.setAll(problems);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Problem> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Problem> iterator() {
        return list.iterator();
    }
}
