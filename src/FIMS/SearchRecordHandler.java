package FIMS;

import java.util.ArrayList;

import domain.FacultyList;
import domain.FacultyMember;
import gui.GUI;

/**
 * Handler for searching for a record.
 * 
 */
public class SearchRecordHandler
{
	FacultyMember fm = new FacultyMember();
	
	/**
	 * Search for a record. Create objects and pass them to the FacultyList
	 * Only sets items that were entered
	 * @param frame
	 */
	public ArrayList<FacultyMember> search(GUI frame, FacultyList fl)
	{
		String promotionYear = "";
		String evalYear = "";
		String sabbaticalYear = "";
		
		if (frame.textField_search_name.getText() != null)
		{
			fm.setName(frame.textField_search_name.getText());
		}
		
		if ((String)frame.comboBox_search_college.getSelectedItem() != null)
		{
		fm.setCollege((String) frame.comboBox_search_college.getSelectedItem());
		}
		
		if ((String) frame.comboBox_search_dept.getSelectedItem() != null)
		{
			fm.setDepartment((String) frame.comboBox_search_dept.getSelectedItem());
		}
		
		if((String) frame.comboBox_search_rank.getSelectedItem() != null)
		{
			fm.setRank((String) frame.comboBox_search_rank.getSelectedItem(),
				(String) frame.comboBox_search_rank.getSelectedItem());
		}

		if ((String) frame.comboBox_search_promo.getSelectedItem() != null)
		{
			promotionYear = (String) frame.comboBox_search_promo.getSelectedItem();
		}
		
		if ((String) frame.comboBox_search_eval.getSelectedItem() != null)
		{
			evalYear = (String) frame.comboBox_search_eval.getSelectedItem();
		}
		
		if ((String) frame.comboBox_search_sab.getSelectedItem() != null)
		{
			sabbaticalYear = (String) frame.comboBox_search_sab.getSelectedItem();
		}

		return fl.searchRecords(fm, promotionYear, evalYear, sabbaticalYear);
	}
}
