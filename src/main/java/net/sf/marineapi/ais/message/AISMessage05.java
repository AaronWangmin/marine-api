package net.sf.marineapi.ais.message;

/**
 * Static and Voyage Related Data.
 * 
 * @author Lázár József
 */
public interface AISMessage05 extends AISMessage {

	/**
	 * Returns the AIS version indicator for the current message.
	 * @return AIS version indicator
	 */
	int getAISVersionIndicator();

	/**
	 * Returns the IMO number of the transmitting ship.
	 * @return an integer value representing the IMO number (1-999999999)
	 */
	int getIMONumber();

	/**
	 * Returns the call sign of the transmitting ship.
	 * @return at most 7 characters, representing the call sign
	 */
	String getCallSign();

	/**
	 * Returns the name of the transmitting ship.
	 * @return maximum 20 characters, representing the name
	 */
	String getName();

	/**
	 * Returns the type of ship and cargo.
	 * @return an integer value representing the type of ship and cargo
	 */
	int getTypeOfShipAndCargoType();

	/**
	 * Returns the distance from the reference point to the bow.
	 */
	int getBow();

	/**
	 * Returns the distance from the reference point to the stern of the ship.
	 */
	int getStern();

	/**
	 * Returns the distance from the reference point to the port side of the ship.
	 */
	int getPort();

	/**
	 * Returns the distance from the reference point to the starboard side of the ship.
	 */
	int getStarboard();

	/**
	 * Returns the type of electronic position fixing device.
	 * @return an integer value the the type of EPFD
	 */
	int getTypeOfEPFD();

	/**
	 * Returns the month, day, hour and minute parts of the estimated time of arrival (ETA).
	 */
	int getETAMonth();

	int getETADay();
	
	int getETAHour();
	
	int getETAMinute();
	
	/**
	 * Returns the maximum draught.
	 * @return an integer value of the maximum static draught in 1/10 m
	 */
	int getMaximumDraught();

	/**
	 * Returns the destination.
	 * @return maximum 20 characters, representing the destination
	 */
	String getDestination();
}
