package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;

/**
 * The <code>FacultyList</code> class contains a list of faculty records, as
 * well as multiple methods to manipulate the ArrayList data. These include
 * adding, updating, and deleting a record, recover the ArrayList by importing a
 * CSV file, generate a report, search records, and view a file.
 */
public class FacultyList
{
  ArrayList<FacultyMember> faculty = new ArrayList<FacultyMember>();

  /**
   * No-argument constructor to set and initialize member data
   */
  public FacultyList()
  {

  }

  /**
   * Method adds record to the ArrayList.
   * 
   * @param newFacultyMember
   *          the new faculty member to be added to the system
   */
  public void addRecord(FacultyMember newFacultyMember)
  {
    faculty.add(newFacultyMember);
  }

  /**
   * Method updates record in the ArrayList.
   * 
   * @param updatedFacultyMember
   *          the updated record of faculty member
   */
  public void editRecord(FacultyMember updatedFacultyMember)
  {
    int selectedPerson = -1;

    for (FacultyMember fm : faculty)
    {
      if (fm.getPosition() == updatedFacultyMember.getPosition())
      {
        selectedPerson = faculty.indexOf(fm);
      }
    }

    if (selectedPerson >= 0)
    {
      faculty.set(selectedPerson, updatedFacultyMember);
    }
  }

  /**
   * Method deletes record in the ArrayList.
   * 
   * @param position
   *          the unique position id of the faculty member to be deleted
   */
  public void deleteRecord(int index)
  {
    faculty.remove(index);
  }

  /**
   * Method creates and displays a report to the screen.
   * 
   * @param updatedFacultyMember
   *          the updated record of faculty member
   */
  public void generateReport(ArrayList<FacultyMember> searchResults)
  {

  }

  /**
   * Method searches the ArrayList for records according to search criteria and
   * returns a list of matching records.
   * 
   * @param sabbaticalYear
   * @param evalYear
   * @param promotionYear
   * @return list of faculty records matching search criteria
   */
  public ArrayList<FacultyMember> searchRecords(FacultyMember fm,
      String promotionYear, String evalYear, String sabbaticalYear)
  {
    ArrayList<FacultyMember> searchResults = new ArrayList<FacultyMember>();

    for (FacultyMember f : faculty)
    {
      if (f.getName().equalsIgnoreCase(fm.getName()))
      {
        searchResults.add(f);
      } else if (f.getCollege().equals(fm.getCollege()))
      {
        searchResults.add(f);
      } else if (f.getDepartment().equals(fm.getDepartment()))
      {
        searchResults.add(f);
      } else if (f.getRank().getCurrentRank()
          .equals(fm.getRank().getCurrentRank()))
      {
        searchResults.add(f);
      } else if (f.getPromotion().getYearOfPromotions().contains(promotionYear))
      {
        searchResults.add(f);
      } else if (f.getEvaluation().getYearOfEvaluations().contains(evalYear))
      {
        searchResults.add(f);
      }
    }
    return searchResults;
  }

  /**
   * Method shows details of one record
   * 
   * @param position
   *          the unique id of the record to be viewed
   */
  public void viewRecord(int position)
  {

  }

  /**
   * Method to get a specific record
   * 
   * @param index
   * @return
   */
  public FacultyMember getRecord(int index)
  {
    return faculty.get(index);
  }

  /**
   * Method to retrieve the size of the faculty list
   * 
   * @return
   */
  public int getSize()
  {
    return faculty.size();
  }

  public void sortName()
  {
    Collections.sort(faculty, FacultyMember.COMPARE_BY_NAME);
  }
}