package FIMS;

import gui.GUI;

import java.util.Calendar;
import java.util.GregorianCalendar;

import domain.EvaluationEligibility;
import domain.FacultyList;
import domain.FacultyMember;
import domain.PromotionEligibility;

/**
 * Handler for editing a record. 
 *
 */
public class EditRecordHandler
{
	
	FacultyMember fm = new FacultyMember();
	EvaluationEligibility ee = new EvaluationEligibility();
	PromotionEligibility pe = new PromotionEligibility();
	
	/**
	 * Edit a record. Create objects and send them to the datastore.
	 * @param frame
	 */
	public void edit(GUI frame, FacultyList fl)
	{
		char gender = frame.rdbtnMale.isSelected() ? 'M' : 
					  frame.rdbtnFemale.isSelected() ? 'F': ' ';
		
		Calendar dateOfHire = new GregorianCalendar(
				Integer.parseInt(frame.textField_year.getText()), 
				frame.comboBox_month.getSelectedIndex() + 1 , 01);
		// set faculty member data
		fm.setName(frame.textField_name.getText());
		fm.setGender(gender);
		fm.setDepartment((String) frame.comboBox_dept.getSelectedItem());
		fm.setCollege((String) frame.comboBox_college.getSelectedItem());
		fm.setRank((String) frame.comboBox_rank.getSelectedItem(), 
				   (String) frame.comboBox_rank.getSelectedItem());
		fm.setDegree((String) frame.comboBox_degree.getSelectedItem(), 
					 frame.txtInstitution.getText());
		//fm.setDateOfHire(dateOfHire);
		fm.setComments(frame.textArea_comments.getText());
		// set promotion eligibility data
		pe.setExperienceCredit(frame.textField_expCred_edit.getText());
		// set evaluation eligibility data
		ee.setYearTenureGranted(frame.textField_tenureGranted.getText());

		//db.editrecord(fm); ???
	}
}
