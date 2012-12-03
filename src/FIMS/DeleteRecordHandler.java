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
	 * Delete a record. Obtain a unique key to find in datastore.
	 * 
	 * @param frame
	 */
	public void delete(GUI frame, FacultyList fl)
	{
		int selectedPerson1 = frame.list.getSelectedIndex();
		// String selectedPersonName = frame.names[selectedPerson1];

		// db.delete(selectedPersonName);
	}
}
