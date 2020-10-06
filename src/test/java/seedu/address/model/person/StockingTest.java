package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StockingTest {

    @Test
    void isValidStocking() {
        assertTrue(Stocking.isValidStocking("central library: 10 science library: 10"));
    }
}
