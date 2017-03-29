package MeetingPlanner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by johnravan on 3/18/17.
 */
public class MeetingTest {

    private Meeting meeting;

    @Before
    public void setUp() {
        meeting = new Meeting();
    }

    @Test
    public void testGetMonth() {
        int month = 11;

        meeting.setMonth(month);

        assertEquals(month, meeting.getMonth());
    }

    @Test
    public void testGetDay() {
        int day = 30;

        meeting.setDay(day);

        assertEquals(day, meeting.getDay());
    }

    @Test
    public void testGetStartTime() {
        int startTime = 1200;

        meeting.setStartTime(startTime);

        assertEquals(startTime, meeting.getStartTime());
    }

    @Test
    public void testGetEndTime() {
        int endTime = 1400;

        meeting.setEndTime(endTime);

        assertEquals(endTime, meeting.getEndTime());
    }

    @Test
    public void testGetRoom() {
        Room room = new Room();

        meeting.setRoom(room);

        assertNotNull(meeting.getRoom());
        assertEquals(room, meeting.getRoom());
    }

    @Test
    public void testGetDescription() {
        String description = "Description";

        meeting.setDescription(description);

        assertNotNull(meeting.getDescription());
        assertEquals(description, meeting.getDescription());
    }
}
