package seedu.address.model.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockingTest {

    @Test
    void isValidStocking() {
        Assertions.assertTrue(Stocking.isValidStocking("central library 10 science library 10"));
        Assertions.assertTrue(Stocking.isValidStocking("central library 30 science library 45"));
        Assertions.assertTrue(Stocking.isValidStocking("central library 10"));
        Assertions.assertTrue(Stocking.isValidStocking("science library 10"));
        Assertions.assertTrue(Stocking.isValidStocking(" "));
        Assertions.assertTrue(Stocking.isValidStocking(""));
        Assertions.assertFalse(Stocking.isValidStocking("some library 10"));
        Assertions.assertFalse(Stocking.isValidStocking("some library"));
    }
}
