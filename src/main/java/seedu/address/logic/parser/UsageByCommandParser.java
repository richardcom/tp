package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ISBN;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIMES;

import java.util.stream.Stream;

import seedu.address.logic.commands.UsageByCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.book.Isbn;
import seedu.address.model.book.Name;
import seedu.address.model.book.Times;


/**
 * Parses input arguments and creates a new UsageByCommand object
 */
public class UsageByCommandParser implements Parser<UsageByCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the UsageCommand
     * and returns a UsageByCommand object for execution.
     * * @return UsageByCommand.
     * @throws ParseException if the user input does not conform the expected format
     */
    public UsageByCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_ISBN, PREFIX_TIMES);
        String content = "";

        boolean isNamePresent = isPrefixesPresent(argMultimap, PREFIX_NAME)
                && !arePrefixesPresent(argMultimap, PREFIX_ISBN, PREFIX_TIMES);
        boolean isIsbnPresent = isPrefixesPresent(argMultimap, PREFIX_ISBN)
                && !arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_TIMES);
        
        if ((arePrefixesPresent(argMultimap, PREFIX_ISBN, PREFIX_TIMES)
                || arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_TIMES)
                || arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_ISBN))
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    UsageByCommand.MESSAGE_USAGE));
        }

        if (isNamePresent) {
            Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
            content = name.fullName;
        } else if (isIsbnPresent) {
            Isbn isbn = ParserUtil.parseIsbn(argMultimap.getValue(PREFIX_ISBN).get());
            content = isbn.value;
        }
        try {
            String trimmedArgs = content.trim();
            if (trimmedArgs.isEmpty()) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, UsageByCommand.MESSAGE_USAGE));
            }
            return new UsageByCommand(trimmedArgs);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, UsageByCommand.MESSAGE_USAGE), pe);
        }
    }

    private static boolean isPrefixesPresent(ArgumentMultimap argumentMultimap, Prefix prefix) {
        return argumentMultimap.getValue(prefix).isPresent();
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
