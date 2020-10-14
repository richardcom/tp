package seedu.address.model.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.book.Address;
import seedu.address.model.book.Author;
import seedu.address.model.book.Book;
import seedu.address.model.book.Email;
import seedu.address.model.book.Isbn;
import seedu.address.model.book.Name;
import seedu.address.model.book.Publisher;
import seedu.address.model.book.Stocking;
import seedu.address.model.book.Times;
import seedu.address.model.category.Category;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Book[] getSampleBooks() {
        HashMap<String, Integer> storage = new HashMap<>();
        storage.put("centralLibrary", 10);
        storage.put("scienceLibrary", 8);
        Stocking stocking = new Stocking(storage);
        return new Book[] {
            new Book(new Name("Pride and Prejudice"), new Isbn("9780141439518"), new Email("pride&prejudice@example.com"),
                new Address("English"), new Times("195"), getCategorySet("Novels"), stocking,
                    new Author("Jane Auste"), new Publisher("Penguin Publishing Group")),
            new Book(new Name("A Brief History Of Time From Big Bang To Black Holes"), new Isbn("9780553175219"),
                    new Email("abriefhistoryoftime@example.com"), new Address("English"), new Times("20278"),
                getCategorySet("Science"), stocking,
                    new Author("Stephen Hawking"), new Publisher("Bantam")),
            new Book(new Name("The Great Gatsby"), new Isbn("9780743273565"), new Email("thegreatgatsby@example.com"),
                new Address("English"), new Times("6529"), getCategorySet("Classics"), stocking,
                    new Author("F. Scott Fitzgerald"), new Publisher("Scribner")),
            new Book(new Name("Introduction to Linear Algebra"), new Isbn("9780980232776"),
                    new Email("introtolinearalgebra@example.com"), new Address("English"), new Times("243"),
                getCategorySet("Textbook"), stocking,
                    new Author("Gilbert Strang"), new Publisher("Wellesley-Cambridge Press"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Book sampleBook : getSampleBooks()) {
            sampleAb.addBook(sampleBook);
        }
        return sampleAb;
    }

    /**
     * Returns a category set containing the list of strings given.
     */
    public static Set<Category> getCategorySet(String... strings) {
        return Arrays.stream(strings)
                .map(Category::new)
                .collect(Collectors.toSet());
    }

}
