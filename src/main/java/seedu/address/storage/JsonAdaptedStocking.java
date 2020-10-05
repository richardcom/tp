package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Stocking;
import seedu.address.model.tag.Tag;

import java.util.HashMap;

public class JsonAdaptedStocking {
    private final int centralLibrary;
    private final int scienceLibrary;

    /**
     * Constructs a {@code JsonAdaptedTag} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedStocking(@JsonProperty("centralLibrary") int centralLibrary, @JsonProperty("scienceLibrary") int scienceLibrary) {
        this.centralLibrary = centralLibrary;
        this.scienceLibrary = scienceLibrary;
    }

    /**
     * Converts a given {@code Tag} into this class for Jackson use.
     */
    public JsonAdaptedStocking(Stocking stocking) {
        if(stocking == null) {
            this.centralLibrary = 0;
            this.scienceLibrary = 0;
        } else {
            this.centralLibrary = stocking.storage.getOrDefault("central library", 0);
            this.scienceLibrary = stocking.storage.getOrDefault("science library", 0);
        }
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public Stocking toModelType() throws IllegalValueException {
        /*
        if (!Tag.isValidTagName(tagName)) {
            throw new IllegalValueException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(tagName);
        */
        HashMap<String, Integer> storage = new HashMap<>();

        if (!Stocking.isValidStocking("central library: " + centralLibrary + " science library: " + scienceLibrary)) {
            throw new IllegalValueException(Stocking.MESSAGE_CONSTRAINTS);
        }
        storage.put("central library", this.centralLibrary);
        storage.put("science library", this.scienceLibrary);

        return new Stocking(storage);
    }
}
