package domain;

import java.util.Calendar;

/**
 * The <code>SabbaticalEligibility</code> class contains relevant information
 * pertaining to a faculty member's sabbatical leave. This includes the number
 * of years of leave that are banked, the number of years of leave previously
 * used, and the year of the last leave taken.
 */
public class SabbaticalLeaveEligibility
{
	int yearsBanked;
	int yearsUsed;
	int lastLeaveTaken;

	/**
	 * No-argument constructor to set and initialize member data
	 * 
	 */
	public SabbaticalLeaveEligibility()
	{
		yearsBanked = 0;
		yearsUsed = 0;
		lastLeaveTaken = 0;
	}

	/**
	 * Method calculates and returns the year that the next sabbatical leave can
	 * be taken.
	 * 
	 * @param dateOfHire
	 *          the date the faculty member was hired
	 * @return the year the next sabbatical leave may be taken
	 */
	public int calculateEligibility(Calendar dateOfHire)
	{
		return 1;
	}

	/**
	 * Method to set the years that have been saved up for sabbatical leave
	 * 
	 * @param yearsBanked
	 */
	public void setYearsBanked(int yearsBanked)
	{
		this.yearsBanked = yearsBanked;
	}

	/**
	 * Method to get the years that have been saved up for sabbatical leave
	 * 
	 * @return yearsBanked
	 */
	public int getYearsBanked()
	{
		return yearsBanked;
	}

	/**
	 * Method to set the years that have been used on leave
	 * 
	 * @param yearsUsed
	 */
	public void setYearsUsed(int yearsUsed)
	{
		this.yearsUsed = yearsUsed;
	}

	/**
	 * Method to get the years that have been used on leave
	 * 
	 * @return yearsUsed
	 */
	public int getYearsUsed()
	{
		return yearsUsed;
	}

	/**
	 * Method to set the year the last sabbatical leave was taken
	 * 
	 * @param lastLeaveTaken
	 */
	public void setLastLeaveTaken(int lastLeaveTaken)
	{
		this.lastLeaveTaken = lastLeaveTaken;
	}

	/**
	 * Method to fet the year the last sabbatical leave was taken
	 * 
	 * @return lastLeaveTaken
	 */
	public int lastLeaveTaken()
	{
		return lastLeaveTaken;
	}

}