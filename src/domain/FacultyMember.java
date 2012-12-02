package domain;

import java.util.Calendar;
import java.util.ArrayList;

/**
 * The <code>FacultyMember</code> class contains relevant 
 * information pertaining to a faculty member.
 */
public class FacultyMember 
{
    String name;
    int position;
    char gender;
    String department;
    String college;
   Rank rank = new Rank();
   Degree degree = new Degree();
   String dateOfHire;
   EvaluationEligibility evaluation = new EvaluationEligibility();
   PromotionEligibility promotion = new PromotionEligibility();
   SabbaticalLeaveEligibility sabbatical = new SabbaticalLeaveEligibility();
   ArrayList<String> comments = new ArrayList<String>();
   
   /**
   * No-argument constructor to set and initialize member data 
   */
   public FacultyMember()
   {
   
   }
   
   /**
    * Method to set name of faculty member
    * @param name
    */
   public void setName(String name)
   {
	   this.name = name;
   }
   
   /**
    * Met to get the name of a faculty member
    * @return name
    */
   public String getName()
   {
	   return name;
   }
   
   /**
    * Method to set the position of a faculty member
    * @param position
    */
   public void setPosition(int position)
   {
	   this.position = position;
   }
   
   /**
    * Method to get the position of a faculty member
    * @return position
    */
   public int getPosition()
   {
	   return position;
   }
   
   /**
    * Method to set the gender of a faculty member
    * @param gender
    */
   public void setGender(char gender)
   {
	   this.gender = gender;
   }
   
   /**
    * Method to get the gender of a faculty member
    * @return gender
    */
   public char getGender()
   {
	   return gender;
   }
   
   /**
    * Method to set the department of a faculty member
    * @param department
    */
   public void setDepartment(String department)
   {
	   this.department = department;
   }
   
   /**
    * Method to get the department of a faculty member
    * @return department
    */
   public String getDepartment()
   {
	   return department;
   }
   
   /**
    * Method to set the college of a faculty member
    * @param college
    */
   public void setCollege(String college)
   {
	   this.college = college;
   }
   
   /**
    * Method to get the college of a faculty memeber
    * @return college
    */
   public String getCollege()
   {
	   return college;
   }
   
   /**
    * Method to set the rank of a faculty member
    * @param rankAtHire
    * @param currentRank
    */
   public void setRank(String rankAtHire, String currentRank)
   {
	   this.rank.setCurrentRank(currentRank);
	   this.rank.setRankAtHire(rankAtHire);
   }
   
   /**
    * Method to get the rank of a faculty member
    * @return rank
    */
   public Rank getRank()
   {
	   return rank;
   }
   /**
    * Method to set the highest degree earned by a faculty member
    * @param degreeLevel
    * @param institution
    */
   public void setDegree(String degreeLevel, String institution)
   {
	   this.degree.setDegreeLevel(degreeLevel);
	   this.degree.setInstitution(institution);
   }
   
   /**
    * Method to get the highest degree earned by a faculty member
    * @return degree
    */
   public Degree getDegree()
   {
	   return degree;
   }
   
   /**
    * Method to set the date of hire
    * @param dateOfHire
    */
   public void setDateOfHire(String dateOfHire)
   {
	   this.dateOfHire = dateOfHire;
   }
   
   /**
    * Method to get the date of hire
    * @return dateOfHire
    */
   public String getDateOfHire()
   {
	   return dateOfHire;
   }
   
   /**
    * Method to set evaluation information
    * @param yearTenureGranted
    * @param evaluationLevel
    * @param yearOfEvaluation
    * @param noFurtherReview
    */
   public void setEvaluation(String yearTenureGranted, boolean noFurtherReview)
   {
	   this.evaluation.setYearTenureGranted(yearTenureGranted);
	   this.evaluation.setNoFurtherReview(noFurtherReview);
   }
   
   /**
    * 
    * @param yearOfEvaluation
    */
   public void setEvaluationYear(String yearOfEvaluation)
   {
	   this.evaluation.addYearOfEvaluation(yearOfEvaluation);
   }
   
   /**
    * Method to get evaluation information
    * @return evaluation
    */
   public EvaluationEligibility getEvaluation()
   {
	   return evaluation;
   }
   
   /**
    * Method to set promotion information
    * @param yearOfPromotion
    * @param experienceCredit
    * @param noFurtherReview
    */
   public void setPromotion(String experienceCredit, boolean noFurtherReview)
   {
	   this.promotion.setExperienceCredit(experienceCredit);
	   this.promotion.setNoFurtherReview(noFurtherReview);
   }
   
   /**
    * 
    * @param yearOfPromotion
    * @param experienceCredit
    * @param noFurtherReview
    */
   public void setPromotionYear(String yearOfPromotion)
   {
	   this.promotion.addYearOfPromotion(yearOfPromotion);
   }
   
   /**
    * Method to get promotion information
    * @return promotion
    */
   public PromotionEligibility getPromotion()
   {
	   return promotion;
   }
   
   /**
    * Method to set sabbatical information
    * @param yearsBanked
    * @param yearsUsed
    * @param lastLeaveTaken
    */
   public void setSabbatical(int yearsBanked, int yearsUsed, int lastLeaveTaken)
   {
	   this.sabbatical.setYearsBanked(yearsBanked);
	   this.sabbatical.setYearsUsed(yearsUsed);
	   this.sabbatical.setLastLeaveTaken(lastLeaveTaken);
   }
   
   /**
    * Method to get sabbatical information
    * @return sabbatical
    */
   public SabbaticalLeaveEligibility getSabbatical()
   {
	   return sabbatical;
   }
   
   /**
    * Method to set comments pertaining to a faculty member
    * @param comment
    */
   public void setComments(String comment)
   {
	   this.comments.add(comment);
   }
   
   /**
    * Method to get comments pertaining to a faculty member
    * @return comments
    */
   public ArrayList<String> getComments()
   {
	   return comments;
   }
}
   
   