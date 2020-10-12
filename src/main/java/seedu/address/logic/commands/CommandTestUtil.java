package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AUTHOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ISBN;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PUBLISHER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STOCKING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIMES;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_ISBN_AMY = "11111111";
    public static final String VALID_ISBN_BOB = "22222222";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_TIMES_AMY = "23";
    public static final String VALID_TIMES_BOB = "2";
    public static final String VALID_CATEGORY_HUSBAND = "husband";
    public static final String VALID_CATEGORY_FRIEND = "friend";
    public static final String VALID_STOCKING_AMY = "central library 10 science library 10";
    public static final String VALID_STOCKING_BOB = "central library 30 science library 15";
    public static final String VALID_AUTHOR_BOB = "a";
    public static final String VALID_PUBLISHER_BOB = "pub";
    public static final String VALID_AUTHOR_AMY = "a";
    public static final String VALID_PUBLISHER_AMY = "pub";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String ISBN_DESC_AMY = " " + PREFIX_ISBN + VALID_ISBN_AMY;
    public static final String ISBN_DESC_BOB = " " + PREFIX_ISBN + VALID_ISBN_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;
    public static final String TIMES_DESC_AMY = " " + PREFIX_TIMES + VALID_TIMES_AMY;
    public static final String TIMES_DESC_BOB = " " + PREFIX_TIMES + VALID_TIMES_BOB;
    public static final String CATEGORY_DESC_FRIEND = " " + PREFIX_CATEGORY + VALID_CATEGORY_FRIEND;
    public static final String CATEGORY_DESC_HUSBAND = " " + PREFIX_CATEGORY + VALID_CATEGORY_HUSBAND;
    public static final String STOCKING_DESC_AMY = " " + PREFIX_STOCKING + VALID_STOCKING_AMY;
    public static final String STOCKING_DESC_BOB = " " + PREFIX_STOCKING + VALID_STOCKING_BOB;
    public static final String AUTHOR_DESC_BOB = " " + PREFIX_AUTHOR + VALID_AUTHOR_BOB;
    public static final String PUBLISHER_DESC_BOB = " " + PREFIX_PUBLISHER + VALID_PUBLISHER_BOB;
    public static final String AUTHOR_DESC_AMY = " " + PREFIX_AUTHOR + VALID_AUTHOR_AMY;
    public static final String PUBLISHER_DESC_AMY = " " + PREFIX_PUBLISHER + VALID_PUBLISHER_AMY;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_ISBN_DESC = " " + PREFIX_ISBN + "911a"; // 'a' not allowed in isbns
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_CATEGORY_DESC =
            " " + PREFIX_CATEGORY + "hubby*"; // '*' not allowed in categories
    public static final String INVALID_STOCKING_DESC = " " + PREFIX_STOCKING + "the library 20";
    public static final String INVALID_TIMES_DESC = " " + PREFIX_TIMES + "zero time";
    public static final String INVALID_PUBLISHER_DESC = " " + PREFIX_PUBLISHER; // empty string not allowed
    public static final String INVALID_AUTHOR_DESC = " " + PREFIX_AUTHOR; // empty string not allowed for authors

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";
}
