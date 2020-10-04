package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIMES;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.TimesCommand;

public class TimesCommandParserTest {
    private TimesCommandParser parser = new TimesCommandParser();
    private final String nonEmptyRemark = "Some times";

    @Test
    public void parse_indexSpecified_success() {
        // have remark
        Index targetIndex = INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + " " + PREFIX_TIMES + nonEmptyRemark;
        TimesCommand expectedCommand = new TimesCommand(INDEX_FIRST_PERSON, nonEmptyRemark);
        assertParseSuccess(parser, userInput, expectedCommand);

        // no remark
        userInput = targetIndex.getOneBased() + " " + PREFIX_TIMES;
        expectedCommand = new TimesCommand(INDEX_FIRST_PERSON, "");
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingCompulsoryField_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, TimesCommand.MESSAGE_USAGE);

        // no parameters
        assertParseFailure(parser, TimesCommand.COMMAND_WORD, expectedMessage);

        // no index
        assertParseFailure(parser, TimesCommand.COMMAND_WORD + " " + nonEmptyRemark, expectedMessage);
    }
}