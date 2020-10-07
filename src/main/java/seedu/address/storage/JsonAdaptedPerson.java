package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.category.Category;
import seedu.address.model.person.Address;
import seedu.address.model.person.Author;
import seedu.address.model.person.Email;
import seedu.address.model.person.Isbn;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Times;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private String name;
    private String isbn;
    private String email;
    private String address;
    private String times;
    private final List<JsonAdaptedCategory> categoried = new ArrayList<>();
    private String author;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("isbn") String isbn,
                             @JsonProperty("email") String email, @JsonProperty("address") String address,
                             @JsonProperty("times") String times,
                             @JsonProperty("categoried") List<JsonAdaptedCategory> categoried,
                             @JsonProperty("author") String author) {

        this.name = name;
        this.isbn = isbn;
        this.email = email;
        this.address = address;
        this.times = times;
        if (categoried != null) {
            this.categoried.addAll(categoried);
        }
        this.author = author;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        isbn = source.getIsbn().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        times = source.getTimes().value;
        categoried.addAll(source.getCategories().stream()
                .map(JsonAdaptedCategory::new)
                .collect(Collectors.toList()));
        author = source.getAuthor().author;
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        final List<Category> personCategories = new ArrayList<>();
        for (JsonAdaptedCategory category : categoried) {
            personCategories.add(category.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (isbn == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Isbn.class.getSimpleName()));
        }
        if (!Isbn.isValidIsbn(isbn)) {
            throw new IllegalValueException(Isbn.MESSAGE_CONSTRAINTS);
        }
        final Isbn modelIsbn = new Isbn(isbn);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);
        if (times == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Times.class.getSimpleName()));
        }
        final Times modelTimes = new Times(times);
        final Set<Category> modelCategories = new HashSet<>(personCategories);

        if (author == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Author.class.getSimpleName()));
        }
        if (!Author.isValidAuthor(author)) {
            throw new IllegalValueException(Author.MESSAGE_CONSTRAINTS);
        }
        final Author modelAuthor = new Author(author);

        return new Person(modelName, modelIsbn, modelEmail, modelAddress, modelTimes,
                modelCategories, modelAuthor);

    }

}
