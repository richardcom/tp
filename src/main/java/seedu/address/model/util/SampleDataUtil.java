package seedu.address.model.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.category.Category;
import seedu.address.model.book.*;
import seedu.address.model.book.Book;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    public static final Times EMPTY_TIMES = new Times("");

    public static Book[] getSamplePersons() {
        HashMap<String, Integer> storage = new HashMap<>();
        storage.put("centralLibrary", 10);
        storage.put("scienceLibrary", 10);
        Stocking stocking = new Stocking(storage);
        return new Book[] {
            new Book(new Name("Alex Yeoh"), new Isbn("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"), EMPTY_TIMES,
                getCategorySet("friends"), stocking, new Author("abc"), new Publisher("PKU")),
            new Book(new Name("Bernice Yu"), new Isbn("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), EMPTY_TIMES,
                getCategorySet("colleagues", "friends"), stocking, new Author("abc"), new Publisher("PKU")),
            new Book(new Name("Charlotte Oliveiro"), new Isbn("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), EMPTY_TIMES,
                getCategorySet("neighbours"), stocking, new Author("abc"), new Publisher("PKU")),
            new Book(new Name("David Li"), new Isbn("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), EMPTY_TIMES,
                getCategorySet("family"), stocking, new Author("abc"), new Publisher("PKU")),
            new Book(new Name("Irfan Ibrahim"), new Isbn("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"), EMPTY_TIMES,
                getCategorySet("classmates"), stocking, new Author("abc"), new Publisher("PKU")),
            new Book(new Name("Roy Balakrishnan"), new Isbn("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"), EMPTY_TIMES,
                getCategorySet("colleagues"), stocking, new Author("abc"), new Publisher("PKU"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Book sampleBook : getSamplePersons()) {
            sampleAb.addPerson(sampleBook);
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
