package seedu.address.storage;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Stocking;



/**
 * Jackson-friendly version of {@link Stocking}.
 */
public class JsonAdaptedStocking {
    private final int centralLibrary;
    private final int scienceLibrary;

    /**
     * Constructs a {@code JsonAdaptedStocking} with the given stocking information.
     */
    @JsonCreator
    public JsonAdaptedStocking(@JsonProperty("centralLibrary") int centralLibrary,
                               @JsonProperty("scienceLibrary") int scienceLibrary) {
        this.centralLibrary = centralLibrary;
        this.scienceLibrary = scienceLibrary;
    }

    /**
     * Converts a given {@code Stocking} into this class for Jackson use.
     */
    public JsonAdaptedStocking(Stocking stocking) {
        if (stocking == null) {
            this.centralLibrary = 0;
            this.scienceLibrary = 0;
        } else {
            this.centralLibrary = stocking.storage.getOrDefault("central library", 0);
            this.scienceLibrary = stocking.storage.getOrDefault("science library", 0);
        }
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Stocking} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted stocking.
     */
    public Stocking toModelType() throws IllegalValueException {
        HashMap<String, Integer> storage = new HashMap<>();

        if (!Stocking.isValidStocking("central library: " + centralLibrary + " science library: " + scienceLibrary)) {
            throw new IllegalValueException(Stocking.MESSAGE_CONSTRAINTS);
        }
        storage.put("central library", this.centralLibrary);
        storage.put("science library", this.scienceLibrary);

        return new Stocking(storage);
    }
}
