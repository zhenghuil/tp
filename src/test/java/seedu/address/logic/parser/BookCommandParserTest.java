package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.BOOKING_DESC_TEST;
import static seedu.address.logic.commands.CommandTestUtil.END_TIME_DESC_TEST;
import static seedu.address.logic.commands.CommandTestUtil.START_TIME_DESC_TEST;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.BookCommand;
import seedu.address.model.booking.Booking;
import seedu.address.testutil.BookingBuilder;

public class BookCommandParserTest {

    private final BookCommandParser parser = new BookCommandParser();
    @Test
    public void parse_validArguments_returnBookCommand() {
        // No note is still valid
        BookingBuilder bookingBuilder = new BookingBuilder();

        Booking expectedBookingWithNote = bookingBuilder.build();
        String userInputWithNote = bookingBuilder.getBookingString();

        assertParseSuccess(parser,
                userInputWithNote,
                new BookCommand(expectedBookingWithNote));
    }

    @Test
    public void parse_missingRequiredFields_failure() {
        // Missing description
        String userInputMissingDescription = START_TIME_DESC_TEST + END_TIME_DESC_TEST;
        assertParseFailure(parser, userInputMissingDescription,
                           String.format(MESSAGE_INVALID_COMMAND_FORMAT, BookCommand.MESSAGE_USAGE));

        // Missing start time
        String userInputMissingStartTime = BOOKING_DESC_TEST + END_TIME_DESC_TEST;
        assertParseFailure(parser, userInputMissingStartTime,
                           String.format(MESSAGE_INVALID_COMMAND_FORMAT, BookCommand.MESSAGE_USAGE));

        // Missing end time
        String userInputMissingEndTime = BOOKING_DESC_TEST + START_TIME_DESC_TEST;
        assertParseFailure(parser, userInputMissingEndTime,
                           String.format(MESSAGE_INVALID_COMMAND_FORMAT, BookCommand.MESSAGE_USAGE));
    }

}
