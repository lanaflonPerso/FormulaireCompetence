package fr.dawan.utils;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class LocalDateTools.
 */
public class LocalDateTools{

	/**
	 * Checks if the LocalDate is before (or equal) today
	 *
	 * @param ld the ld
	 * @return true, if is before or equal
	 */
	public static boolean isBeforeOrEqual(LocalDate ld) {
		LocalDate now = LocalDate.now();
		return now.isBefore(ld) || now.isEqual(ld);
	}
	
	/**
	 * Checks if the LocalDate is after (or equal) today
	 *
	 * @param ld the localDate 
	 * @return true, if is after or equal
	 */
	public static boolean isAfterOrEqual(LocalDate ld) {
		LocalDate now = LocalDate.now();
		return now.isAfter(ld) || now.isEqual(ld);
	}
	
	/**
	 * Checks if is include between.
	 *
	 * @param begin the begin
	 * @param end the end
	 * @return true, if is include between
	 */
	public static boolean isIncludeBetween(LocalDate begin, LocalDate end) {
		return isAfterOrEqual(begin) && isBeforeOrEqual(end);
	}
	
}
