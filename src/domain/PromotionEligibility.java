package domain;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * The <code>PromotionEligibility</code> class contains relevant 
 * information pertaining to a faculty member's promotions.  This includes
 * the faculty member's current rank, the year that each promotion has occured, 
 * the experience credit of the faculty member, and whether the faculty member
 * needs to be reviewed further.
 */
public class PromotionEligibility
{
   ArrayList<String> yearOfPromotions = new ArrayList<String>();
   String experienceCredit;
   boolean noFurtherReview;
   
   /**
   * No-argument constructor to set and initialize member data 
   */
   public PromotionEligibility() 
   {
      
   }
   
   /**
   * Method calculates and returns the year of the next promotion
   * to be given.  Method should not be called if noFurtherReview
   * is true.
   * @param dateOfHire the date a faculty member is hired
   * @param rankAtHire the rank of a faculty member when hired
   * @param experienceCredits the years of experience a faculty member has before hired
   * @return the year of the next evaluation to be conducted
   */
   public int calculateEligibility(Calendar dateOfHire, 
              String rankAtHire, double experienceCredits)
   {
      return 1;
   }
   
   /**
    * Method to add a year of promotion
   * @param yearOfPromotion
   */
   public void addYearOfPromotion(String yearOfPromotion)
   {
      this.yearOfPromotions.add(yearOfPromotion);
   }
   
   /**
    * Method to return all years of promotion
   * @return yearOfPromotions
   */
   public ArrayList<String> getYearOfPromotions()
   {
     return yearOfPromotions;
   }
   
   /**
    * Method to set the number of years of previous experience
    * obtained at other institutions or by other experience
    * @param experienceCredit
    */
   public void setExperienceCredit(String experienceCredit)
   {
	   this.experienceCredit = experienceCredit;
   }
   
   /**
    * Method to get the number of years of previous experience
    * obtained at other institutions or by other experience
    * @return experienceCredit
    */
   public String getExperienceCredit()
   {
	   return experienceCredit;
   }
   
   /**
    * Method to set a boolean to indicate that the faculty
    * member will not be reviewed any further
   * @param noFurtherReview
   */
   public void setNoFurtherReview(boolean noFurtherReview)
   {
      this.noFurtherReview = noFurtherReview;
   }
   
   /**
    * Method to get a boolean to indicate that the faculty
    * member will not be reviewed any further
   * @return noFurtherReview
   */
   public boolean getNoFurtherReview()
   {
     return noFurtherReview;
   }
}