package seedu.address.storage;


import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonSerializableLibraryTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableLibraryTest");
    private static final Path TYPICAL_BOOKS_FILE = TEST_DATA_FOLDER.resolve("typicalBookLibrary.json");
    private static final Path INVALID_BOOK_FILE = TEST_DATA_FOLDER.resolve("invalidBookLibrary.json");
    private static final Path DUPLICATE_BOOK_FILE = TEST_DATA_FOLDER.resolve("duplicateBookLibrary.json");

    /* @Test
    public void toModelType_typicalBooksFile_success() throws Exception {
        JsonSerializableLanguageBook dataFromFile = JsonUtil.readJsonFile(TYPICAL_BOOKS_FILE,
                JsonSerializableLanguageBook.class).get();
        LanguageBook languageBookFromFile = dataFromFile.toModelType();
        LanguageBook typicalBooksLanguageBook = TypicalBooks.getTypicalLanguageBook();
        assertEquals(languageBookFromFile, typicalBooksLanguageBook);
    } // storage parser */

    /* @Test
    public void toModelType_invalidBookFile_throwsIllegalValueException() throws Exception {
        JsonSerializableLibrary dataFromFile = JsonUtil.readJsonFile(INVALID_BOOK_FILE,
                JsonSerializableLibrary.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    } */

    /* @Test
    public void toModelType_duplicateBooks_throwsIllegalValueException() throws Exception {
        JsonSerializableLanguageBook dataFromFile = JsonUtil.readJsonFile(DUPLICATE_BOOK_FILE,
                JsonSerializableLanguageBook.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableLanguageBook.MESSAGE_DUPLICATE_BOOK,
                dataFromFile::toModelType);
    } // storage parser */

}
