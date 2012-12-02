package FIMS;

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
	 * Search for a record. Create objects and pass them to the datastore
	 * @param frame
	 */
	public void search(GUI frame, FacultyList fl) 
	{
		fm.setName(frame.textField_search_name.getText());
		fm.setCollege((String) frame.comboBox_search_college.getSelectedItem());
		fm.setDepartment((String) frame.comboBox_search_dept.getSelectedItem());
		fm.setRank((String) frame.comboBox_search_rank.getSelectedItem(), (String) frame.comboBox_search_rank.getSelectedItem());
		
		String promotionYear = (String) frame.comboBox_search_promo.getSelectedItem();
		String evalYear = (String) frame.comboBox_search_eval.getSelectedItem();
		String sabbaticalYear = (String) frame.comboBox_search_sab.getSelectedItem();
		
		//db.searchForRecord(fm, promotionYear, evalYear, sabbaticalYear);
	}
}
