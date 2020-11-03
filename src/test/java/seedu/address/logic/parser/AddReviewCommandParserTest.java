package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_BOOK;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddReviewCommand;
import seedu.address.model.review.Rating;
import seedu.address.model.review.Review;
import seedu.address.model.review.ReviewContent;

class AddReviewCommandParserTest {

    private final static String MESSAGE_INVALID_FORMAT =
            String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, AddReviewCommand.MESSAGE_USAGE);

    private AddReviewCommandParser addReviewCommandParser = new AddReviewCommandParser();

    private final String valid_rating = " " + CliSyntax.PREFIX_RATING + "5";
    private final String previous_valid_rating = " " + CliSyntax.PREFIX_RATING + "4";
    private final String valid_review_content = " " + CliSyntax.PREFIX_REVIEW + "The book is interesting";
    private final String previous_valid_review_content = " " + CliSyntax.PREFIX_REVIEW + "The book is inspiring";
    private final String invalid_rating = " " + CliSyntax.PREFIX_RATING + "6";
    private final String invalid_review_content = " " + CliSyntax.PREFIX_REVIEW + "";

    @Test
    void parse_allFieldSpecified_success() {
        Index index = INDEX_FIRST_BOOK;
        String enteredCommand = index.getOneBased() + valid_rating + valid_review_content;

        Rating expectedRating = new Rating(5);
        ReviewContent expectedReviewContent = new ReviewContent("The book is interesting");
        AddReviewCommand expectedReviewCommand = new AddReviewCommand(index,
                new Review(expectedRating, expectedReviewContent));
        assertParseSuccess(addReviewCommandParser, enteredCommand, expectedReviewCommand);
    }

    @Test
    void parse_repeatedField_success() {
        Index index = INDEX_FIRST_BOOK;
        String enteredCommand = index.getOneBased() + previous_valid_rating + valid_rating + valid_review_content;

        Rating expectedRating = new Rating(5);
        ReviewContent expectedReviewContent = new ReviewContent("The book is interesting");
        AddReviewCommand expectedReviewCommand = new AddReviewCommand(index,
                new Review(expectedRating, expectedReviewContent));
        assertParseSuccess(addReviewCommandParser, enteredCommand, expectedReviewCommand);

        enteredCommand = index.getOneBased() + valid_rating + previous_valid_review_content + valid_review_content;
        assertParseSuccess(addReviewCommandParser, enteredCommand, expectedReviewCommand);
    }

    @Test
    void parse_validFieldAfterInvalidField_success() {
        Index index = INDEX_FIRST_BOOK;
        String enteredCommand = index.getOneBased() + invalid_rating + valid_rating + valid_review_content;

        Rating expectedRating = new Rating(5);
        ReviewContent expectedReviewContent = new ReviewContent("The book is interesting");
        AddReviewCommand expectedReviewCommand = new AddReviewCommand(index,
                new Review(expectedRating, expectedReviewContent));
        assertParseSuccess(addReviewCommandParser, enteredCommand, expectedReviewCommand);

        enteredCommand = index.getOneBased() + valid_rating + invalid_review_content + valid_review_content;
        assertParseSuccess(addReviewCommandParser, enteredCommand, expectedReviewCommand);
    }

    @Test
    void parse_invalidFieldAfterValidField_failure() {
        Index index = INDEX_FIRST_BOOK;
        String enteredCommand = index.getOneBased() + valid_rating + invalid_rating + valid_review_content;

        assertParseFailure(addReviewCommandParser, enteredCommand, Rating.MESSAGE_CONSTRAINTS);

        enteredCommand = index.getOneBased() + valid_rating + valid_review_content + invalid_review_content;
        assertParseFailure(addReviewCommandParser, enteredCommand, ReviewContent.MESSAGE_CONSTRAINTS);
    }

    @Test
    void parse_missingField_failure() {
        Index index = INDEX_FIRST_BOOK;
        String enteredCommand = valid_rating;

        assertParseFailure(addReviewCommandParser, enteredCommand, MESSAGE_INVALID_FORMAT);

        enteredCommand = valid_review_content;
        assertParseFailure(addReviewCommandParser, enteredCommand, MESSAGE_INVALID_FORMAT);

        enteredCommand = String.valueOf(index.getOneBased());
        assertParseFailure(addReviewCommandParser, enteredCommand, MESSAGE_INVALID_FORMAT);

        enteredCommand = index.getOneBased() + valid_rating;
        assertParseFailure(addReviewCommandParser, enteredCommand, MESSAGE_INVALID_FORMAT);

        enteredCommand = index.getOneBased() + valid_review_content;
        assertParseFailure(addReviewCommandParser, enteredCommand, MESSAGE_INVALID_FORMAT);

        enteredCommand = valid_rating + valid_review_content;
        assertParseFailure(addReviewCommandParser, enteredCommand, MESSAGE_INVALID_FORMAT);
    }

    @Test
    void parse_invalidField_failure() {
        Index index = INDEX_FIRST_BOOK;
        String enteredCommand = index.getOneBased() + invalid_rating + valid_review_content;

        assertParseFailure(addReviewCommandParser, enteredCommand, Rating.MESSAGE_CONSTRAINTS);

        enteredCommand = index.getOneBased() + valid_rating + invalid_review_content;
        assertParseFailure(addReviewCommandParser, enteredCommand, ReviewContent.MESSAGE_CONSTRAINTS);
    }
}