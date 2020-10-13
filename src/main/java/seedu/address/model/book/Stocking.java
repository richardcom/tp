package seedu.address.model.book;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;

public class Stocking {
    public static final String MESSAGE_CONSTRAINTS = "stocking needs to map from a location to the"
            + " number of stocking in that location";

    public static final String[] LOCATION = new String[]{"central library", "science library"};
    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX =
            "^\\s*(central library)?\\s+(\\d{1,5})?\\s+(science library)?\\s+(\\d{1,5})?\\s*$";

    public final HashMap<String, Integer> storage = new HashMap<>();

    //public final int stockingInCentralLibrary;
    //public final int stockingInScienceLibrary;

    /**
     * Constructs an {@code Address}.
     *
     * @param stocking A valid stocking.
     */
    public Stocking(HashMap<String, Integer> stocking) {
        requireNonNull(stocking);
        //checkArgument(isValidAddress(stocking), MESSAGE_CONSTRAINTS);
        //value = address;
        //this.stockingInCentralLibrary = stocking[0];
        //this.stockingInScienceLibrary = stocking[1];
        for (int i = 0; i < LOCATION.length; i = i + 1) {
            this.storage.put(LOCATION[i], 0);
        }

        this.storage.putAll(stocking);
    }


    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidStocking(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return "central library: " + storage.getOrDefault("central library", 0) + "\n"
                + "science library: " + storage.getOrDefault("scienece library", 0);
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
