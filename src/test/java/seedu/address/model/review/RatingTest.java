package seedu.address.model.review;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RatingTest {

    @Test
    void isValidRating() {
        Assertions.assertTrue(Rating.isValidRating("5"));
        Assertions.assertFalse(Rating.isValidRating("a"));
    }
}
