package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.DeleteByNameCommand;
import seedu.address.logic.parser.exceptions.ParseException;





/**
 * Parses input arguments and creates a new DeleteByNameCommand object
 */
public class DeleteByNameCommandParser implements Parser<DeleteByNameCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteByNameCommand object for execution.
     * * @return DeleteByNameCommand.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteByNameCommand parse(String args) throws ParseException {
        try {
            String trimmedArgs = args.trim();
            if (trimmedArgs.isEmpty()) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteByNameCommand.MESSAGE_USAGE));
            }
            return new DeleteByNameCommand(trimmedArgs);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteByNameCommand.MESSAGE_USAGE), pe);
        }
    }

}
