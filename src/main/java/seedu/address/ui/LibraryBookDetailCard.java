package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.book.Book;

/**
 * An UI component that displays detailed information of a {@code Book}.
 */
public class LibraryBookDetailCard extends UiPart<Region> {
    private static final String FXML = "LibraryBookDetailCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Book book;

    @javafx.fxml.FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label isbn;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private Label times;
    @FXML
    private Label author;
    @FXML
    private FlowPane categories;
    @FXML
    private FlowPane stocking;

    /**
     * Creates a {@code BookCode} with the given {@code Book} and index to display.
     */
    public LibraryBookDetailCard(Book book, int displayedIndex) {
        super(FXML);
        this.book = book;
        id.setText(displayedIndex + ". ");
        name.setText(book.getName().fullName);
        isbn.setText(book.getIsbn().value);
        address.setText(book.getAddress().value);
        email.setText(book.getEmail().value);
        times.setText(book.getTimes().value);
        book.getCategories().stream()
                .sorted(Comparator.comparing(category -> category.categoryName))
                .forEach(category -> categories.getChildren().add(new Label(category.categoryName)));
        book.getStocking().storage.forEach((location, storage) -> {
            if (storage > 0) {
                stocking.getChildren().add(new Label(location + ": " + storage + " "));
            }
        });
        author.setText(book.getAuthor().author);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof LibraryBookDetailCard)) {
            return false;
        }

        // state check
        LibraryBookDetailCard card = (LibraryBookDetailCard) other;
        return id.getText().equals(card.id.getText())
                && book.equals(card.book);
    }
}
