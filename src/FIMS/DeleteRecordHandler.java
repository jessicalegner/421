package FIMS;

import domain.FacultyList;
import gui.GUI;

/**
 * Handler for deleting a record.
 * 
 */
public class DeleteRecordHandler
{
	/**
	 * Delete a record according to selected index.
	 * 
	 * @param frame
	 */
	public void delete(GUI frame, FacultyList fl)
	{
		int selectedPerson = frame.list.getSelectedIndex();
		fl.deleteRecord(selectedPerson);
	}
}
