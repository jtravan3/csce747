package edu.sc.csce747.MeetingPlanner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by johnravan on 3/18/17.
 */
public class OrganizationTest {

    private Organization organization;

    @Before
    public void setUp() {
        organization = new Organization();
    }

    @Test(expected = Exception.class)
    public void testGetRoom_Exception() throws Exception {
        String id = "1245";

        organization.getRoom(id);
    }

    @Test
    public void testGetRoom() throws Exception {
        String id = "2A01";

        Room room = organization.getRoom(id);

        assertNotNull(room);
    }

    @Test(expected = Exception.class)
    public void testGetEmployee_Exception() throws Exception {
        String id = "12345";

        organization.getEmployee(id);
    }

    @Test
    public void testGetEmployee() throws Exception {
        String id = "John Rose";

        Person person = organization.getEmployee(id);

        assertNotNull(person);
    }
}
