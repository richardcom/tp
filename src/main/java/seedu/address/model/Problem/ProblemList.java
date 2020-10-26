package seedu.address.model.Problem;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

public class ProblemList {
    private static ArrayList<Problem> list;

    /**
     * Creates a new ProblemList.
     */
    public ProblemList() {
        this.list = new ArrayList<>();
    }

    /**
     * Adds a problem to the list.
     */
    public static void add(Problem toAdd) {
        requireNonNull(toAdd);
        list.add(toAdd);
    }

    public static ArrayList<Problem> getList() {
        return list;
    }

    public static void setList(ArrayList<Problem> newlist) {
        list = newlist;
    }
}
