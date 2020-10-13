package seedu.address.storage;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
//import seedu.address.model.AddressBook;
//import seedu.address.testutil.TypicalBooks;

public class JsonSerializableAddressBookTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableAddressBookTest");
    private static final Path TYPICAL_BOOKS_FILE = TEST_DATA_FOLDER.resolve("typicalBookAddressBook.json");
    private static final Path INVALID_BOOK_FILE = TEST_DATA_FOLDER.resolve("invalidBookAddressBook.json");
    private static final Path DUPLICATE_BOOK_FILE = TEST_DATA_FOLDER.resolve("duplicateBookAddressBook.json");

    /* @Test
    public void toModelType_typicalBooksFile_success() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(TYPICAL_BOOKS_FILE,
                JsonSerializableAddressBook.class).get();
        AddressBook addressBookFromFile = dataFromFile.toModelType();
        AddressBook typicalBooksAddressBook = TypicalBooks.getTypicalAddressBook();
        assertEquals(addressBookFromFile, typicalBooksAddressBook);
    } // storage parser */

    @Test
    public void toModelType_invalidBookFile_throwsIllegalValueException() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(INVALID_BOOK_FILE,
                JsonSerializableAddressBook.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    /* @Test
    public void toModelType_duplicateBooks_throwsIllegalValueException() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(DUPLICATE_BOOK_FILE,
                JsonSerializableAddressBook.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableAddressBook.MESSAGE_DUPLICATE_BOOK,
                dataFromFile::toModelType);
    } // storage parser */

}
