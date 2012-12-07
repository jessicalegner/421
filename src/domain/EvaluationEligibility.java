package domain;

import java.util.Calendar;
import java.util.ArrayList;

/**
 * The <code>EvaluationEligibility</code> class contains relevant information
 * pertaining to a faculty member's evaluation. This includes the year tenure is
 * granted, the level of last evaluation, a list of all evaluations conducted,
 * and whether the faculty member must be reviewed further.
 */
public class EvaluationEligibility
{
  String yearTenureGranted;
  String evaluationLevel;
  ArrayList<String> yearOfEvaluations = new ArrayList<String>();
  boolean noFurtherReview;

  /**
   * No-argument constructor to set and initialize member data
   */
  public EvaluationEligibility()
  {
    yearTenureGranted = "";
    evaluationLevel = "";
    noFurtherReview = false;
  }

  /**
   * Method calculates and returns the year of the next evaluation to be
   * conducted. Method should not be called if noFurtherReview is true.
   * 
   * @param dateOfHire
   *          the date a faculty member is hired
   * @return the year of the next evaluation to be conducted
   */
  public void calculateEligibility(String yearOfHire)
  {
    int twoDigitYear = Integer.parseInt(yearOfHire.substring(2, 4));

    addYearOfEvaluation(twoDigitYear + "-" + (twoDigitYear + 1));
    addYearOfEvaluation((twoDigitYear + 1) + "-" + (twoDigitYear + 2));
    addYearOfEvaluation((twoDigitYear + 3) + "-" + (twoDigitYear + 4));
    addYearOfEvaluation((twoDigitYear + 4) + "-" + (twoDigitYear + 5));
  }

  /**
   * Method to set the year tenture was granted
   * 
   * @param yearTenureGranted
   */
  public void setYearTenureGranted(String yearTenureGranted)
  {
    this.yearTenureGranted = yearTenureGranted;
  }

  /**
   * Method to get the year tenure was granted
   * 
   * @return yearTenureGranted
   */
  public String getYearTenureGranted()
  {
    return yearTenureGranted;
  }

  /**
   * Method to set the current evaluation level 1 year, 2 year, pre-tenure,
   * tenure
   * 
   * @param evaluationLevel
   */
  public void setEvaluationLevel(String evaluationLevel)
  {
    this.evaluationLevel = evaluationLevel;
  }

  /**
   * Method to get the current evaluation level
   * 
   * @return evaluationLevel
   */
  public String getEvaluationLevel()
  {
    return evaluationLevel;
  }

  /**
   * Method to set the year of evaluation
   * 
   * @param yearOfEvaluation
   */
  public void addYearOfEvaluation(String yearOfEvaluation)
  {
    this.yearOfEvaluations.add(yearOfEvaluation);
  }

  /**
   * Method to get year of evaluation
   * 
   * @return yearOfEvaluations
   */
  public ArrayList<String> getYearOfEvaluations()
  {
    return this.yearOfEvaluations;
  }

  /**
   * Method to set an indicator of no reviews needed
   * 
   * @param noFurtherReview
   */
  public void setNoFurtherReview(boolean noFurtherReview)
  {
    this.noFurtherReview = noFurtherReview;
  }

  /**
   * Method to get indicator of further reviews
   * 
   * @return noFurtherReview
   */
  public boolean getNoFurtherReview()
  {
    return noFurtherReview;
  }
}