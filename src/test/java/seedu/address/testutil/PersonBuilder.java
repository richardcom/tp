package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Author;
import seedu.address.model.person.Email;
import seedu.address.model.person.Isbn;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Times;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_ISBN = "85355255";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_TIMES = "";
    public static final String DEFAULT_AUTHOR = "a";

    private Name name;
    private Isbn isbn;
    private Email email;
    private Address address;
    private Times times;
    private Set<Tag> tags;
    private Author author;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        isbn = new Isbn(DEFAULT_ISBN);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        times = new Times(DEFAULT_TIMES);
        tags = new HashSet<>();
        author = new Author(DEFAULT_AUTHOR);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        isbn = personToCopy.getIsbn();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        times = personToCopy.getTimes();
        tags = new HashSet<>(personToCopy.getTags());
        author = personToCopy.getAuthor();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Isbn} of the {@code Person} that we are building.
     */
    public PersonBuilder withIsbn(String isbn) {
        this.isbn = new Isbn(isbn);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Times} of the {@code Book} that we are building.
     */
    public PersonBuilder withTimes(String times) {
        this.times = new Times(times);
        return this;
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withAuthor(String author) {
        this.author = new Author(author);
        return this;
    }

    public Person build() {
        return new Person(name, isbn, email, address, times, tags, author);
    }

}
