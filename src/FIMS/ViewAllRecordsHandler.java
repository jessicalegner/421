package FIMS;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import domain.FacultyList;
import domain.FacultyMember;
import gui.GUI;

/**
 * Handler for viewing all records
 * 
 */
public class ViewAllRecordsHandler
{
  /**
   * Method to add items to the view all screen
   * 
   * @param frame
   * @param fl
   */
  public static void viewAll(GUI frame, FacultyList fl)
  {
    frame.list.setCellRenderer(new MyCellRenderer());

    // first number is number of rows, second is number of columns
    String[][] columnData = new String[fl.getSize()][7];
    fl.sortName();
    // dynamic setting of String[][]
    for (int i = 0; i < fl.getSize(); i++)
    {
      columnData[i][0] = fl.getRecord(i).getName();
      columnData[i][1] = fl.getRecord(i).getDepartment();
      columnData[i][2] = fl.getRecord(i).getCollege();
      columnData[i][3] = fl.getRecord(i).getRank().getCurrentRank();
      columnData[i][4] = fl.getRecord(i).getDateOfHire();
      columnData[i][5] = fl.getRecord(i).getDegree().getDegreeLevel();
      columnData[i][6] = fl.getRecord(i).getDegree().getInstitution();
    }
    frame.list.setListData(columnData);
  }

  /**
   * Method to add search results to the view all screen
   * 
   * @param frame
   * @param fl
   */
  public static void viewAll(final GUI frame, ArrayList<FacultyMember> fl)
  {
    // first number is number of rows, second is number of columns

    frame.list.setCellRenderer(new MyCellRenderer());

    String[][] columnData = new String[fl.size()][7];
    if (fl.get(0) != null)
    {
      for (int i = 0; i < fl.size(); i++)
      {
        columnData[i][0] = fl.get(i).getName();
        columnData[i][1] = fl.get(i).getDepartment();
        columnData[i][2] = fl.get(i).getCollege();
        columnData[i][3] = fl.get(i).getRank().getCurrentRank();
        columnData[i][4] = fl.get(i).getDateOfHire();
        columnData[i][5] = fl.get(i).getDegree().getDegreeLevel();
        columnData[i][6] = fl.get(i).getDegree().getInstitution();
      }
      frame.list.setListData(columnData);
    }
  }

  static class MyCellRenderer extends JPanel implements ListCellRenderer
  {
    JLabel one, two, three, four, five, six, seven;

    MyCellRenderer()
    {
      setLayout(new GridLayout(1, 7));
      one = new JLabel();
      two = new JLabel();
      three = new JLabel();
      four = new JLabel();
      five = new JLabel();
      six = new JLabel();
      seven = new JLabel();

      one.setOpaque(true);
      two.setOpaque(true);
      three.setOpaque(true);
      four.setOpaque(true);
      five.setOpaque(true);
      six.setOpaque(true);
      seven.setOpaque(true);

      add(one);
      add(two);
      add(three);
      add(four);
      add(five);
      add(six);
      add(seven);
    }

    public Component getListCellRendererComponent(JList list, Object value,
        int index, boolean isSelected, boolean cellHasFocus)
    {
      String oneData = ((String[]) value)[0];
      String twoData = ((String[]) value)[1];
      String threeData = ((String[]) value)[2];
      String fourData = ((String[]) value)[3];
      String fiveData = ((String[]) value)[4];
      String sixData = ((String[]) value)[5];
      String sevenData = ((String[]) value)[6];

      one.setText(oneData);
      two.setText(twoData);
      three.setText(threeData);
      four.setText(fourData);
      five.setText(fiveData);
      six.setText(sixData);
      seven.setText(sevenData);

      if (isSelected)
      {
        one.setBackground(list.getSelectionBackground());
        one.setForeground(list.getSelectionForeground());
        two.setBackground(list.getSelectionBackground());
        two.setForeground(list.getSelectionForeground());
        three.setBackground(list.getSelectionBackground());
        three.setForeground(list.getSelectionForeground());
        four.setBackground(list.getSelectionBackground());
        four.setForeground(list.getSelectionForeground());
        five.setBackground(list.getSelectionBackground());
        five.setForeground(list.getSelectionForeground());
        six.setBackground(list.getSelectionBackground());
        six.setForeground(list.getSelectionForeground());
        seven.setBackground(list.getSelectionBackground());
        seven.setForeground(list.getSelectionForeground());
      } else
      {
        one.setBackground(list.getBackground());
        one.setForeground(list.getForeground());
        two.setBackground(list.getBackground());
        two.setForeground(list.getForeground());
        three.setBackground(list.getBackground());
        three.setForeground(list.getForeground());
        four.setBackground(list.getBackground());
        four.setForeground(list.getForeground());
        five.setBackground(list.getBackground());
        five.setForeground(list.getForeground());
        six.setBackground(list.getBackground());
        six.setForeground(list.getForeground());
        seven.setBackground(list.getBackground());
        seven.setForeground(list.getForeground());
      }
      setEnabled(list.isEnabled());
      setFont(list.getFont());
      return this;
    }
  }
}
