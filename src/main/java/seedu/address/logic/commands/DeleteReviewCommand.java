package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.book.*;
import seedu.address.model.category.Category;
import seedu.address.model.review.Review;
import seedu.address.model.review.ReviewNumber;
import seedu.address.ui.Mode;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class DeleteReviewCommand extends Command {
    public static final String COMMAND_WORD = "deleteReview";

    public static final String MESSAGE_DELETE_REVIEW_SUCCESS = "The review has been deleted for the book %1$s";

    private final Index bookIndex;
    private final int reviewIndex;

    public DeleteReviewCommand(Index bookIndex, ReviewNumber reviewIndex) {
        requireNonNull(bookIndex);
        requireNonNull(reviewIndex);

        this.bookIndex = bookIndex;
        this.reviewIndex = reviewIndex.reviewNumber;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Book> lastShownList = model.getFilteredBookList();

        if(bookIndex.getZeroBased() > lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_BOOK_DISPLAYED_INDEX);
        }

        Book bookToReview = lastShownList.get(bookIndex.getZeroBased());

        if (bookToReview.getReviews().size() < reviewIndex) {
            throw new CommandException(Messages.MESSAGE_INVALID_REVIEW_DISPLAYED_INDEX);
        }

        Book newBook = createdChangedBook(bookToReview, reviewIndex);

        model.setBook(bookToReview, newBook);

        List<String> keywords = new ArrayList<>(Arrays.asList((newBook.getName().fullName).split(" ")));

        NameMatchesKeywordPredicate nameMacthedKeywordsPredicate = new NameMatchesKeywordPredicate(keywords);
        model.updateFilteredBookList(nameMacthedKeywordsPredicate, Mode.REVIEW);

        return new CommandResult(String.format(MESSAGE_DELETE_REVIEW_SUCCESS, newBook));
    }

    private static Book createdChangedBook(Book book, int reviewIndex) {
        Name name = book.getName();
        Isbn isbn = book.getIsbn();
        Email email = book.getEmail();
        Address address = book.getAddress();
        //Set<Review> reviews = new HashSet<>(book.getReviews());
        List<Review> reviewList = book.getReviews()
                .stream()
                .sorted(Comparator.comparing(review -> review.getContent().content))
                .collect(Collectors.toList());
        reviewList.remove(reviewIndex - 1);

        HashSet<Review> reviews = new HashSet<>(reviewList);

        Times times = book.getTimes();
        Set<Category> categories = book.getCategories();
        Author author = book.getAuthor();
        Publisher publisher = book.getPublisher();
        Stocking stocking = book.getStocking();

        return new Book(name, isbn, email, address, times, categories, stocking, reviews, author, publisher);

    }
}
