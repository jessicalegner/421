package FIMS;

import gui.GUI;

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
		fm.setDateOfHire(frame.comboBox_month_edit.getSelectedItem() + "/1/" +
										 frame.textField_year_edit.getText());
		fm.setDepartment((String) frame.comboBox_dept_edit.getSelectedItem());
		fm.setCollege((String) frame.comboBox_college_edit.getSelectedItem());
		fm.setRank((String) frame.comboBox_rank_edit.getSelectedItem(),
				(String) frame.comboBox_rank_edit.getSelectedItem());
		fm.setDegree((String) frame.comboBox_degree_edit.getSelectedItem(),
				frame.txtInstitution_edit.getText());
		fm.setComments(frame.textArea_comments_edit.getText());
		fl.editRecord(fm);
	}
	
	public void populate(GUI frame, FacultyList fl, int selectedPerson)
	{
		String[] date = createDate(fl.getRecord(selectedPerson).getDateOfHire());
		String month = date[0];
		String year = date[2];
		
		frame.lblHidden_position.setText(fl.getRecord(selectedPerson).getPosition());
		frame.textField_name_edit.setText(fl.getRecord(selectedPerson).getName());
		frame.comboBox_college_edit.setSelectedItem(fl.getRecord(selectedPerson)
				.getCollege());
		frame.comboBox_dept_edit.setSelectedItem(fl.getRecord(selectedPerson)
				.getDepartment());

		if (String.valueOf(fl.getRecord(selectedPerson).getGender())
				.equals("F"))
		{
			frame.rdbtnFemale_edit.setSelected(true);
		}
		else
		{
			frame.rdbtnMale_edit.setSelected(true);
		}
		frame.comboBox_rank_edit.setSelectedItem(fl.getRecord(selectedPerson).getRank().getRankAtHire());
		frame.comboBox_month_edit.setSelectedItem(month);
		frame.textField_year_edit.setText(year);
		frame.comboBox_degree_edit.setSelectedItem(fl.getRecord(selectedPerson).getDegree().getDegreeLevel());
		frame.txtInstitution_edit.setText(fl.getRecord(selectedPerson).getDegree().getInstitution());
		frame.textArea_comments_edit.setText(fl.getRecord(selectedPerson).getComments().get(0));
		frame.textField_expCred_edit.setText(fl.getRecord(selectedPerson).getPromotion().getExperienceCredit());
		frame.comboBox_currentRank.setSelectedItem(fl.getRecord(selectedPerson).getRank().getCurrentRank());
	}
	
	private String[] createDate(String dateOfHire)
	{
		String[] dateExplode;
		dateExplode = dateOfHire.split("/");
		return dateExplode;
	}
}
