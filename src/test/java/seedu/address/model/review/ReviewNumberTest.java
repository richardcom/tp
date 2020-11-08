package seedu.address.model.review;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static seedu.address.testutil.Assert.assertThrows;

class ReviewNumberTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ReviewNumber(null));
    }

    @Test
    void isValidReviewNumber() {
        Assertions.assertTrue(ReviewNumber.isValidReviewNumber("6"));
        Assertions.assertFalse(ReviewNumber.isValidReviewNumber("a"));
        Assertions.assertFalse(ReviewNumber.isValidReviewNumber(""));
    }
}
