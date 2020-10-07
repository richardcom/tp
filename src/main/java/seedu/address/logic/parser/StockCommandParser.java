package seedu.address.logic.parser;

import java.util.Arrays;
import java.util.List;

import seedu.address.logic.commands.StockCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new StockCommand object
 */
public class StockCommandParser implements Parser<StockCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the StockingCommand
     * and returns a StockingCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public StockCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(
                userInput,
                CliSyntax.PREFIX_NAME,
                CliSyntax.PREFIX_ISBN
        );

        List<String> names = null;
        List<String> numbers = null;

        if (argumentMultimap.getValue(CliSyntax.PREFIX_NAME).isPresent()) {
            names = Arrays.asList(argumentMultimap.getValue(CliSyntax.PREFIX_NAME).get().split("\\s+"));
        }
        if (argumentMultimap.getValue(CliSyntax.PREFIX_ISBN).isPresent()) {
            numbers = Arrays.asList(argumentMultimap.getValue(CliSyntax.PREFIX_ISBN).get().split("\\s+"));
        }
        return new StockCommand(names, numbers);
    }
}
