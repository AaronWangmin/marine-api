package net.sf.marineapi.nmea.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import net.sf.marineapi.nmea.sentence.RMBSentence;
import net.sf.marineapi.nmea.util.DataStatus;
import net.sf.marineapi.nmea.util.Direction;
import net.sf.marineapi.nmea.util.Waypoint;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the RMB sentence parser.
 * 
 * @author Kimmo Tuukkanen
 */
public class RMBTest {

    /** Example sentence */
    public static final String EXAMPLE = "$GPRMB,A,0.00,R,,RUSKI,5536.200,N,01436.500,E,432.3,234.9,,V*58";

    private RMBSentence rmb;

    /**
     * setUp
     */
    @Before
    public void setUp() {
        try {
            rmb = new RMBParser(EXAMPLE);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.RMBParser#getStatus()}.
     */
    @Test
    public void testGetStatus() {
        assertEquals(DataStatus.INVALID, rmb.getStatus());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.RMBParser#getCrossTrackError()}.
     */
    @Test
    public void testGetCrossTrackError() {
        assertEquals(0.0, rmb.getCrossTrackError(), 0.001);
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.RMBParser#getSteerTo()}.
     */
    @Test
    public void testGetSteerTo() {
        assertEquals(Direction.RIGHT, rmb.getSteerTo());
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.RMBParser#getOriginId()}.
     */
    @Test
    public void testGetOriginId() {
        // FIXME test data should contain ID
        try {
            assertEquals("", rmb.getOriginId());
            fail("Did not throw ParseException");
        } catch (Exception e) {
            assertTrue(e instanceof DataNotAvailableException);
        }
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.RMBParser#getDestination()} .
     */
    @Test
    public void testGetDestination() {
        final String id = "RUSKI";
        final double lat = 55 + (36.200 / 60);
        final double lon = 14 + (36.500 / 60);

        Waypoint wp = rmb.getDestination();
        assertNotNull(wp);
        assertEquals(id, wp.getId());
        assertEquals(lat, wp.getLatitude(), 0.0000001);
        assertEquals(lon, wp.getLongitude(), 0.0000001);
        assertEquals(Direction.NORTH, wp.getLatHemisphere());
        assertEquals(Direction.EAST, wp.getLonHemisphere());
    }

    /**
     * Test method for {@link net.sf.marineapi.nmea.parser.RMBParser#getRange()}
     * .
     */
    @Test
    public void testGetRange() {
        assertEquals(432.3, rmb.getRange(), 0.001);
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.RMBParser#getBearing()} .
     */
    @Test
    public void testGetBearing() {
        assertEquals(234.9, rmb.getBearing(), 0.001);
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.RMBParser#getVelocity()}.
     */
    @Test
    public void testGetVelocity() {
        // FIXME test data should contain velocity
        try {
            assertEquals(0.0, rmb.getVelocity(), 0.001);
            fail("Did not throw ParseException");
        } catch (Exception e) {
            assertTrue(e instanceof DataNotAvailableException);
        }
    }

    /**
     * Test method for
     * {@link net.sf.marineapi.nmea.parser.RMBParser#getArrivalStatus()}.
     */
    @Test
    public void testGetArrivalStatus() {
        assertEquals(DataStatus.VALID, rmb.getArrivalStatus());
        assertTrue(rmb.hasArrived());
    }

}
