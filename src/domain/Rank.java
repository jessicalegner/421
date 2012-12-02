package domain;

/**
 * The <code>Rank</code> class contains information about
 * a faculty members current rank and rank at hire.
 */

public class Rank {
	String currentRank;
	String rankAtHire;
	
	/**
   * No-argument constructor to set and initialize member data 
   */
	public Rank()
	{
	
	}
	
	/**
	 * Method to set the current rank of a faculty member
	 * @param currentRank
	 */
	public void setCurrentRank(String currentRank)
	{
		this.currentRank = currentRank;
	}
	
	/**
	 * Method to get the current rank of a faculty member
	 * @return currentRank
	 */
	public String getCurrentRank()
	{
		return currentRank;
	}
	
	/**
	 * Method to set the rank at hire of a faculty member
	 * @param rankAtHire
	 */
	public void setRankAtHire(String rankAtHire)
	{
		this.rankAtHire = rankAtHire;
	}
	
	/**
	 * Method to get the rank at hire of a faculty member
	 * @return rankAtHire
	 */
	public String getRankAtHire()
	{
		return rankAtHire;
	}
}
