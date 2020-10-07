package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.category.Category;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Isbn isbn;
    private final Email email;
    private final Author author;

    // Data fields
    private final Address address;
    private final Times times;
    private final Set<Category> categories = new HashSet<>();

    private final Stocking stocking;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Isbn isbn, Email email, Address address,
                  Times times, Set<Category> categories, Stocking stocking, Author author) {
        requireAllNonNull(name, isbn, email, address, times, categories, author);
        this.name = name;
        this.isbn = isbn;
        this.email = email;
        this.address = address;
        this.times = times;
        this.categories.addAll(categories);
        // add
        this.author = author;
        this.stocking = stocking;
    }

    public Name getName() {
        return name;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }


    public Author getAuthor() {
        return author;
    }


    public Times getTimes() {
        return times;
    }


    /**
     * Returns an immutable category set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Category> getCategories() {
        return Collections.unmodifiableSet(categories);
    }

    public Stocking getStocking() {
        return this.stocking;
    }

    /**
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName())
                && (otherPerson.getIsbn().equals(getIsbn()) || otherPerson.getEmail().equals(getEmail()));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getName().equals(getName())
                && otherPerson.getIsbn().equals(getIsbn())
                && otherPerson.getEmail().equals(getEmail())
                && otherPerson.getAddress().equals(getAddress())
                && otherPerson.getCategories().equals(getCategories())
                && otherPerson.getAuthor().equals(getAuthor());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, isbn, email, address, categories, author);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Isbn: ")
                .append(getIsbn())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(" Times: ")
                .append(getTimes())
                .append(getAddress())
                .append(" Categories: ");
        getCategories().forEach(builder::append);
        builder.append(" Author: ").append(getAuthor());
        return builder.toString();
    }

}
