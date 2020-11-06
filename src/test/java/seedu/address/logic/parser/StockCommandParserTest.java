package seedu.address.logic.parser;

import static seedu.address.logic.commands.CommandTestUtil.ISBN_DESC_BOOK1;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_BOOK1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ISBN_BOOK1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOOK1;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.StockCommand;

class StockCommandParserTest {

    private StockCommandParser stockCommandParser = new StockCommandParser();

    @Test
    void parse_validArgs_returnsStockCommand() {
        assertParseSuccess(stockCommandParser,
                NAME_DESC_BOOK1,
                new StockCommand(Arrays.asList(VALID_NAME_BOOK1.split("\\s+")), null));

        assertParseSuccess(stockCommandParser,
                ISBN_DESC_BOOK1,
                new StockCommand(null, Arrays.asList(VALID_ISBN_BOOK1.split("\\s+"))));
    }
}
