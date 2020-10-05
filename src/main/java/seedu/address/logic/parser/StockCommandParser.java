package seedu.address.logic.parser;

import seedu.address.logic.commands.StockCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.Arrays;
import java.util.List;

public class StockCommandParser implements Parser<StockCommand> {
    @Override
    public StockCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(
                userInput,
                CliSyntax.PREFIX_NAME,
                CliSyntax.PREFIX_PHONE
        );

        List<String> names = null;
        List<String> numbers = null;

        if(argumentMultimap.getValue(CliSyntax.PREFIX_NAME).isPresent()) {
            names = Arrays.asList(argumentMultimap.getValue(CliSyntax.PREFIX_NAME).get().split("\\s+"));
        }
        if(argumentMultimap.getValue(CliSyntax.PREFIX_PHONE).isPresent()) {
            numbers = Arrays.asList(argumentMultimap.getValue(CliSyntax.PREFIX_PHONE).get().split("\\s+"));
        }
        return new StockCommand(names, numbers);
    }
}
