package seedu.address.model.booking;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a booking
 */
public class Booking {
    /** Name of the booking */
    private Description description;
    /** Start time of the booking */
    private StartTime start;
    /** End time of the booking */
    private EndTime end;
    /** Notes for the booking */
    private Notes note;

    /**
     * Constructs a booking
     * @param description Description of the booking
     * @param start Start time in ISO_LOCAL_DATE_TIME format (2023-12-31T19:00)
     * @param end End time in ISO_LOCAL_DATE_TIME format
     */
    public Booking(Description description, StartTime start, EndTime end, Notes note) {
        requireAllNonNull(description, start, end);
        this.description = description;
        this.start = start;
        this.end = end;
        this.note = note;
    }

    public Description getDescription() {
        return description;
    }

    public StartTime getStart() {
        return start;
    }

    public EndTime getEnd() {
        return end;
    }

    public Notes getNotes() {
        return this.note;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Booking)) {
            return false;
        }
        Booking otherBooking = (Booking) other;

        return Objects.equals(description, otherBooking.description)
                && Objects.equals(start, otherBooking.start)
                && Objects.equals(end, otherBooking.end)
                && Objects.equals(this.note, otherBooking.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, start, end, note);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("description", description)
                .add("start", start)
                .add("end", end)
                .add("note", note)
                .toString();
    }
}
