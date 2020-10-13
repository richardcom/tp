package seedu.address.model.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockingTest {

    @Test
    void isValidStocking() {
        Assertions.assertTrue(Stocking.isValidStocking("central library 10 science library 10"));
    }
}
