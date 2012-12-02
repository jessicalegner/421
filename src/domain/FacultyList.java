package domain;

import java.util.ArrayList;
import java.io.File;

/**
 * The <code>Database</code> class contains a list of faculty records,
 * as well as multiple methods to manipulate the database data.  These
 * include adding, updating, and deleting a record, recover the DataBase 
 * by importing a CSV file, generate a report, search records, and view a file.
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
   * Method adds record to the database.
   * @param newFacultyMember the new faculty member to be added to the system
   */
   public void addRecord(FacultyMember newFacultyMember)
   {
	   faculty.add(newFacultyMember);
   }
  
   /**
   * Method updates record in the database.
   * @param updatedFacultyMember the updated record of faculty member
   */  
   public void updateRecord(FacultyMember updatedFacultyMember)
   {
	  
   }
   
   /**
   * Method deletes record in the database.
   * @param position the unique position id of the faculty member to be deleted
   */  
   public void deleteRecord()
   {
	   for(int i = 0; i < faculty.size(); i++){
		   System.out.println(faculty.get(i).getName());
	   }
   }
   
   /**
   * Method recovers the database when the user uploads a CSV file with 
   * faculty information.
   * @param filename the CSV file with faculty information
   */  
   public void recoverDB(File filename)
   {
   
   }
   
   /**
   * Method creates and displays a report to the screen.
   * @param updatedFacultyMember the updated record of faculty member
   */  
   public void generateReport(ArrayList<FacultyMember> searchResults)
   {
   
   }
   
   /**
   * Method searches the database for records according to search criteria
   * and returns a list of matching records.
   * @return list of faculty records matching search criteria
   */  
   public ArrayList<FacultyMember> searchRecords()
   {
      return null;
   }
   
   /**
   * Method shows details of one record
   * @param position the unique id of the record to be viewed
   */  
   public void viewRecord(int position)
   {
   
   }
   
   public FacultyMember getRecord(int index)
   {
	   return faculty.get(index);
   }
   
   public int getSize()
   {
	   return faculty.size();
   }
}