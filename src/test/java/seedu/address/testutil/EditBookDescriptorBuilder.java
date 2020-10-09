package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.category.Category;
import seedu.address.model.book.*;
import seedu.address.model.book.Book;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditBookDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditBookDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditBookDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code book}'s details
     */
    public EditBookDescriptorBuilder(Book book) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(book.getName());
        descriptor.setIsbn(book.getIsbn());
        descriptor.setEmail(book.getEmail());
        descriptor.setAddress(book.getAddress());
        descriptor.setCategories(book.getCategories());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditBookDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Isbn} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditBookDescriptorBuilder withIsbn(String isbn) {
        descriptor.setIsbn(new Isbn(isbn));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditBookDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditBookDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Parses the {@code categories} into a {@code Set<Category>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditBookDescriptorBuilder withCategories(String... categories) {
        Set<Category> categorySet = Stream.of(categories).map(Category::new).collect(Collectors.toSet());
        descriptor.setCategories(categorySet);
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
