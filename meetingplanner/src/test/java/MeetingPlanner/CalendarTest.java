package MeetingPlanner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by johnravan on 3/18/17.
 */
public class CalendarTest {

    private Calendar calendar;

    @Before
    public void setUp() {
        calendar = new Calendar();
    }

    @Test
    public void testIsBusy_ValidDate_Busy() throws TimeConflictException {

        int month = 1;
        int day   = 12;
        int start = 10;
        int end   = 12;

        boolean isBusy = calendar.isBusy(month, day, start, end);

        assertFalse(isBusy);

    }

    @Test(expected = TimeConflictException.class)
    public void testIsBusy_Exception() throws TimeConflictException {

        int month = 1;
        int day   = 32;
        int start = 10;
        int end   = 17;

        calendar.isBusy(month, day, start, end);

    }

    @Test
    public void testIsBusy_ValidDate_NotBusy() throws TimeConflictException {

        int month = 9;
        int day   = 31;
        int start = 22;
        int end   = 23;

        boolean isBusy = calendar.isBusy(month, day, start, end);

        assertTrue(isBusy);

    }

    @Test
    public void testPrintAgenda_NormalString() {

        int month = 12;

        String agenda = calendar.printAgenda(month);

        assertNotNull(agenda);
        assertEquals(agenda, "Agenda for 12:\n");

    }

    @Test
    public void testPrintAgenda_WithDay_NormalString() {

        int month = 12;
        int day = 11;

        String agenda = calendar.printAgenda(month, day);

        assertNotNull(agenda);
        assertEquals(agenda, "Agenda for 12/11:\n");

    }

}
