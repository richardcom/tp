package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.book.Book;

/**
 * Panel containing the list of persons.
 */
public class BookListPanel extends UiPart<Region> {
    private static final String FXML = "BookListPanel.fxml";
    private static Mode mode = Mode.NORMAL;
    private final Logger logger = LogsCenter.getLogger(BookListPanel.class);

    @FXML
    private ListView<Book> personListView;

    /**
     * Creates a {@code BookListPanel} with the given {@code ObservableList}.
     */
    public BookListPanel(ObservableList<Book> bookList) {
        super(FXML);

        personListView.setItems(bookList);
        personListView.setCellFactory(listView -> new PersonListViewCell());
    }

    public static void setMode(Mode mode) {
        BookListPanel.mode = mode;
    }


    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Book} using a {@code BookCard}.
     */
    class PersonListViewCell extends ListCell<Book> {
        @Override
        protected void updateItem(Book book, boolean empty) {
            super.updateItem(book, empty);

            if (empty || book == null) {
                setGraphic(null);
                setText(null);
            } else {
                if (mode.equals(Mode.NORMAL)) {
                    //System.out.println("In book list panel, the mode is normal mode");
                    setGraphic(new BookCard(book, getIndex() + 1).getRoot());
                } else {
                    //System.out.println("In book list panel, the mode is detail mode");
                    setGraphic(new LibraryBookDetailCard(book, getIndex() + 1).getRoot());
                }
            }
        }
    }
}
