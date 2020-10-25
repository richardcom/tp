package seedu.address.model.review;

import static java.util.Objects.requireNonNull;

public class ReviewNumber {
    public static final String MESSAGE_CONSTRAINTS = "review index needs to be an integer";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "\\s*(\\d{1,5})\\s*";

    public final Integer reviewNumber;

    /**
     * Constructs an {@code Address}.
     *
     * @param reviewNumber A valid rating.
     */
    public ReviewNumber(Integer reviewNumber) {
        requireNonNull(reviewNumber);
        this.reviewNumber = reviewNumber;
    }


    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidReviewNumber(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return reviewNumber.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReviewNumber // instanceof handles nulls
                && reviewNumber.equals(((ReviewNumber) other).reviewNumber)); // state check
    }

    @Override
    public int hashCode() {
        return reviewNumber.hashCode();
    }
}
