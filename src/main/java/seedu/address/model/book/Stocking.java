package seedu.address.model.book;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;

public class Stocking {
    public static final String MESSAGE_CONSTRAINTS = "stocking needs to map from a location to the"
            + " number of stocking in that location";

    public static final String[] LOCATION = new String[]{"central library", "science library"};
    /*
     * The stocking string should map from the location to
     * the number of book in the location.
     */
    public static final String VALIDATION_REGEX =
            "^\\s*(central library)?\\s+(\\d{1,5})?\\s+(science library)?\\s+(\\d{1,5})?\\s*$";

    public final HashMap<String, Integer> storage = new HashMap<>();

    /**
     * Constructs an {@code Stocking}.
     *
     * @param stocking A valid stocking.
     */
    public Stocking(HashMap<String, Integer> stocking) {
        requireNonNull(stocking);

        for (int i = 0; i < LOCATION.length; i = i + 1) {
            this.storage.put(LOCATION[i], 0);
        }

        this.storage.putAll(stocking);
    }


    /**
     * Returns true if a given string is a valid stocking.
     */
    public static boolean isValidStocking(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return "central library " + storage.getOrDefault("central library", 0) + " "
                + "science library " + storage.getOrDefault("scienece library", 0);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Stocking // instanceof handles nulls
                && storage.equals(((Stocking) other).storage)); // state check
    }

    @Override
    public int hashCode() {
        return storage.hashCode();
    }

}
