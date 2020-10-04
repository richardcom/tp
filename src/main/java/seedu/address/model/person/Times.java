package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents how many times a book is borrowed before.
 * Guarantees: immutable; is always valid
 */
public class Times {
    public final String value;

    public Times(String times) {
        requireNonNull(times);
        value = times;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Times // instanceof handles nulls
                && value.equals(((Times) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}