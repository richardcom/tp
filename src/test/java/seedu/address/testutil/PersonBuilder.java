package seedu.address.testutil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import seedu.address.model.category.Category;
import seedu.address.model.person.Address;
import seedu.address.model.person.Author;
import seedu.address.model.person.Email;
import seedu.address.model.person.Isbn;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Stocking;
import seedu.address.model.person.Times;
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
    public static final HashMap<String, Integer> DEFAULT_STOCKING = new HashMap<>();

    private Name name;
    private Isbn isbn;
    private Email email;
    private Address address;
    private Times times;
    private Set<Category> categories;
    private Author author;
    private Stocking stocking;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        isbn = new Isbn(DEFAULT_ISBN);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        times = new Times(DEFAULT_TIMES);
        categories = new HashSet<>();
        author = new Author(DEFAULT_AUTHOR);
        stocking = new Stocking(DEFAULT_STOCKING);
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
        categories = new HashSet<>(personToCopy.getCategories());
        author = personToCopy.getAuthor();
        stocking = personToCopy.getStocking();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code categories} into a {@code Set<Category>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withCategories(String ... categories) {
        this.categories = SampleDataUtil.getCategorySet(categories);
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

    /**
     * Sets the {@code Stocking} of the {@code Person} that we are building.
     */
    public PersonBuilder withStocking(HashMap<String, Integer> map) {
        this.stocking = new Stocking(map);
        return this;
    }

    public Person build() {
        return new Person(name, isbn, email, address, times, categories, stocking, author);
    }
}
