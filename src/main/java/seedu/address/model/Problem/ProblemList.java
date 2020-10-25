package seedu.address.model.Problem;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

public class ProblemList {
    private ArrayList<Problem> list;

    /**
     * Creates a new ProblemList.
     */
    public ProblemList() {
        this.list = new ArrayList<>();
    }
    
    /**
     * Adds a problem to the list.
     */
    public void add(Problem toAdd) {
        requireNonNull(toAdd);
        list.add(toAdd);
    }
}
