package FIMS;

import gui.GUI;

import domain.FacultyList;
import domain.FacultyMember;

/**
 * Handler for editing a record.
 * 
 */
public class EditRecordHandler
{
  FacultyMember fm = new FacultyMember();

  /**
   * Edit a record. Create objects and send them to the datastore.
   * 
   * @param frame
   */
  public void edit(GUI frame, FacultyList fl)
  {
    char gender = frame.rdbtnMale.isSelected() ? 'M' : frame.rdbtnFemale
        .isSelected() ? 'F' : ' ';

    // set faculty member data
    fm.setPosition(frame.lblHidden_position.getText());
    fm.setName(frame.textField_name_edit.getText());
    fm.setGender(gender);
    fm.setDateOfHire(frame.comboBox_month_edit.getSelectedItem() + "/1/"
        + frame.textField_year_edit.getText());
    fm.setDepartment((String) frame.comboBox_dept_edit.getSelectedItem());
    fm.setCollege((String) frame.comboBox_college_edit.getSelectedItem());
    fm.setRank((String) frame.comboBox_rank_edit.getSelectedItem(),
        (String) frame.comboBox_rank_edit.getSelectedItem());
    fm.setDegree((String) frame.comboBox_degree_edit.getSelectedItem(),
        frame.txtInstitution_edit.getText());
    fm.setComments(frame.textArea_comments_edit.getText());
    fl.editRecord(fm);
  }

  /**
   * Populate the frame with the data of a selected faculty member
   * 
   * @param frame
   * @param fl
   * @param selectedPerson
   */
  public void populate(GUI frame, FacultyList fl, int selectedPerson)
  {
    FacultyMember fm = new FacultyMember();
    fm = fl.getRecord(selectedPerson);

    String[] date = createDate(fm.getDateOfHire());
    String month = date[0];
    String year = date[2];

    frame.lblHidden_position.setText(fm.getPosition());
    frame.textField_name_edit.setText(fm.getName());
    frame.comboBox_college_edit.setSelectedItem(fm.getCollege());
    frame.comboBox_dept_edit.setSelectedItem(fm.getDepartment());

    if (String.valueOf(fm.getGender()).equals("F"))
    {
      frame.rdbtnFemale_edit.setSelected(true);
    } else
    {
      frame.rdbtnMale_edit.setSelected(true);
    }
    frame.comboBox_rank_edit.setSelectedItem(fm.getRank().getRankAtHire());
    frame.comboBox_month_edit.setSelectedItem(month);
    frame.textField_year_edit.setText(year);
    frame.comboBox_degree_edit.setSelectedItem(fm.getDegree().getDegreeLevel());
    frame.txtInstitution_edit.setText(fm.getDegree().getInstitution());
    frame.textArea_comments_edit.setText(fm.getComments().get(0));
    frame.textField_expCred_edit.setText(fm.getPromotion()
        .getExperienceCredit());
    frame.comboBox_currentRank.setSelectedItem(fm.getRank().getCurrentRank());
  }

  /**
   * Creates an array of strings from the date of hire. Splits date in format
   * mm/dd/yyyy into individual parts for manipulation
   * 
   * @param dateOfHire
   * @return
   */
  private String[] createDate(String dateOfHire)
  {
    String[] dateExplode;
    dateExplode = dateOfHire.split("/");
    return dateExplode;
  }
}
