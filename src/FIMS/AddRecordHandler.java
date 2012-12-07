package FIMS;

import domain.FacultyList;
import domain.FacultyMember;
import gui.GUI;

/**
 * Handler for adding a record
 * 
 */
public class AddRecordHandler
{
  FacultyMember fm = new FacultyMember();
  private int highestPositionNum = 0;

  /**
   * Method to set the unique position number when reading data in from file
   * 
   * @param positionNum
   */
  public void setHighPosNum(String positionNum)
  {
    if ((Integer.parseInt(positionNum)) > highestPositionNum)
    {
      highestPositionNum = Integer.parseInt(positionNum);
    }
  }

  /**
   * Method to retrieve and increment the highest position number This is a
   * unique id used to identify faculty members
   * 
   * @return integer - highest position available
   */
  public int getHighPosNum()
  {
    return highestPositionNum + 1;
  }

  /**
   * Add a record. Start by creating and setting a faculty member then give it
   * to the data store utility.
   * 
   * @param frame
   */
  public void add(GUI frame, FacultyList fl)
  {
    char gender = frame.rdbtnMale.isSelected() ? 'M' : frame.rdbtnFemale
        .isSelected() ? 'F' : ' ';

    String date = (String) frame.comboBox_month.getSelectedItem() + "/1/"
        + frame.textField_year.getText();

    // set faculty member data
    fm.setPosition(Integer.toString(getHighPosNum()));
    fm.setName(frame.textField_name.getText());
    fm.setGender(gender);
    fm.setDepartment((String) frame.comboBox_dept.getSelectedItem());
    fm.setCollege((String) frame.comboBox_college.getSelectedItem());
    fm.setDateOfHire(date);
    fm.setRank((String) frame.comboBox_rank.getSelectedItem(),
        (String) frame.comboBox_rank.getSelectedItem());
    fm.setDegree((String) frame.comboBox_degree.getSelectedItem(),
        frame.txtInstitution.getText());
    fm.setComments(frame.textArea_comments.getText());
    fm.setNewEvals(frame.textField_year.getText());
    fm.setPromotion(frame.textField_expCred_add.getText(), false);
    fm.setNewPromos(frame.textField_year.getText(),
        (String) frame.comboBox_rank.getSelectedItem());

    fl.addRecord(fm);
  }
}
