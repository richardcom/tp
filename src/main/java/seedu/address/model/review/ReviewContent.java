package seedu.address.model.review;

import seedu.address.model.book.Stocking;

import java.util.HashMap;

import static java.util.Objects.requireNonNull;

public class ReviewContent {
    public static final String MESSAGE_CONSTRAINTS = "review cannot be empty";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */

    public static final String VALIDATION_REGEX = "^\\s*(\\S.*)\\s*$";

    public final String content;

    //public final int stockingInCentralLibrary;
    //public final int stockingInScienceLibrary;

    /**
     * Constructs an {@code Address}.
     *
     * @param content A valid stocking.
     */
    public ReviewContent(String content) {
        requireNonNull(content);
        this.content = content;
    }


    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidContent(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReviewContent // instanceof handles nulls
                && content.equals(((ReviewContent) other).content)); // state check
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
