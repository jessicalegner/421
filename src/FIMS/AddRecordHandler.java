package FIMS;

import domain.FacultyList;
import domain.FacultyMember;
import gui.GUI;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Handler for adding a record
 * 
 */
public class AddRecordHandler
{
	FacultyMember fm = new FacultyMember();

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

		// Calendar dateOfHire = new
		// GregorianCalendar(Integer.parseInt(frame.textField_year.getText()),
		// frame.comboBox_month.getSelectedIndex() + 1 , 01);

		// set faculty member data
		fm.setName(frame.textField_name.getText());
		fm.setGender(gender);
		fm.setDepartment((String) frame.comboBox_dept.getSelectedItem());
		fm.setCollege((String) frame.comboBox_college.getSelectedItem());
		fm.setRank((String) frame.comboBox_rank.getSelectedItem(),
				(String) frame.comboBox_rank.getSelectedItem());
		fm.setDegree((String) frame.comboBox_degree.getSelectedItem(),
				frame.txtInstitution.getText());
		fm.setDateOfHire((String) frame.textField_year.getText());
		fm.setComments(frame.textArea_comments.getText());

		fl.addRecord(fm);
	}
}
