package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.Arrays;
import java.util.stream.Stream;

import seedu.address.logic.commands.AddProfCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.NameContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new AddProfCommand object
 */
public class AddProfCommandParser implements Parser<AddProfCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddProfCommand
     * and returns an AddProfCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddProfCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddProfCommand.MESSAGE_USAGE));
        }
        String trimmedArgs = argMultimap.getValue(PREFIX_NAME).get().trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }
        String[] nameKeywords = trimmedArgs.split("\\s+");
        return new AddProfCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
