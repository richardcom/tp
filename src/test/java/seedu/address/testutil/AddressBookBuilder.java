package seedu.address.testutil;

import seedu.address.model.AddressBook;
import seedu.address.model.book.Book;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withBook("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private AddressBook addressBook;

    public AddressBookBuilder() {
        addressBook = new AddressBook();
    }

    public AddressBookBuilder(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Book} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withBook(Book book) {
        addressBook.addBook(book);
        return this;
    }

    public AddressBook build() {
        return addressBook;
    }
}
