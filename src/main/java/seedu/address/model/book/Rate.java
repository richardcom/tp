package seedu.address.model.book;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Book's rate in the address book(0-5).
 * Guarantees: immutable; is valid as declared in {@link #isValidRate(String)}
 */
public class Rate {

    public static final String MESSAGE_CONSTRAINTS =
            "Rate numbers should only contain numbers, and it should be in the range 0-5";
    public static final String VALIDATION_REGEX = "\\d*";
    public final String value;

    /**
     * Constructs a {@code Rate}.
     *
     * @param rate A valid rate number.
     */
    public Rate(String rate) {
        requireNonNull(rate);
        checkArgument(isValidRate(rate), MESSAGE_CONSTRAINTS);
        value = rate;
    }

    /**
     * Returns true if a given string is a valid rate number.
     */
    public static boolean isValidRate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Rate // instanceof handles nulls
                && value.equals(((Rate) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
