package domain;

public class Degree 
{
   String degreeLevel;
   String institution;
   
   /**
   * No-argument constructor to set and initialize member data 
   */
   public Degree() 
   {
   
   }
   
   /**
    * Method to set the degree level
   * @param degreeLevel
   */
   public void setDegreeLevel(String degreeLevel)
   {
      this.degreeLevel = degreeLevel;
   }
   
   /**
    * Method to get the degree level
   * @return degreeLevel
   */
   public String getDegreeLevel()
   {
     return degreeLevel;
   }
   
   /**
    * Method to set institution where degree was obtained
   * @param institution
   */
   public void setInstitution(String institution)
   {
     this.institution = institution;
   }
   
   /**
    * Method to get institution where degree was obtained
   * @return institution
   */
   public String getInstitution()
   {
     return institution;
   }

}