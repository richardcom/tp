package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TimesTest {

    @Test
    public void equals() {
        Times times = new Times("Hello");

        // same object -> returns true
        assertTrue(times.equals(times));

        // same values -> returns true
        Times remarkCopy = new Times(times.value);
        assertTrue(times.equals(remarkCopy));

        // different types -> returns false
        assertFalse(times.equals(1));

        // null -> returns false
        assertFalse(times.equals(null));

        // different remark -> returns false
        Times differentRemark = new Times("Bye");
        assertFalse(times.equals(differentRemark));
    }
}
