package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import domain.FacultyList;
import domain.FacultyMember;

public class WriteObjects
{
  /**
   * Method to write all of the faculty members back to spreadsheet including
   * any changes that were made
   * 
   * @param fl
   */
  public static void writeDataToExcelFile(FacultyList fl)
  {
    try
    {
      String fileOut = "C:\\Users\\Owner\\Desktop\\facultydata.xls";

      HSSFWorkbook myWorkBook = new HSSFWorkbook();
      HSSFSheet mySheet = myWorkBook.createSheet();
      HSSFRow myRow = null;
      HSSFCell myCell = null;

      for (int rowNum = 0; rowNum < fl.getSize(); rowNum++)
      {
        myRow = mySheet.createRow(rowNum);

        FacultyMember fm = new FacultyMember();
        fm = fl.getRecord(rowNum);

        int currCell = 0;
        myCell = myRow.createCell(currCell++);
        myCell.setCellValue(fm.getName());

        myCell = myRow.createCell(currCell++);
        myCell.setCellValue(fm.getPosition());

        myCell = myRow.createCell(currCell++);
        myCell.setCellValue(String.valueOf(fm.getGender()));

        myCell = myRow.createCell(currCell++);
        myCell.setCellValue(fm.getDepartment());

        myCell = myRow.createCell(currCell++);
        myCell.setCellValue(fm.getCollege());

        myCell = myRow.createCell(currCell++);
        myCell.setCellValue(fm.getDateOfHire());

        myCell = myRow.createCell(currCell++);
        myCell.setCellValue(fm.getRank().getRankAtHire());

        myCell = myRow.createCell(currCell++);
        myCell.setCellValue(fm.getDegree().getDegreeLevel());

        myCell = myRow.createCell(currCell++);
        myCell.setCellValue(fm.getDegree().getInstitution());

        myCell = myRow.createCell(currCell++);
        myCell.setCellValue(fm.getPromotion().getExperienceCredit());

        if (!fm.getEvaluation().getYearOfEvaluations().isEmpty())
        {
          myCell = myRow.createCell(currCell++);
          myCell.setCellValue(fm.getEvaluation().getYearOfEvaluations().get(0)
              .toString());

          myCell = myRow.createCell(currCell++);
          myCell.setCellValue(fm.getEvaluation().getYearOfEvaluations().get(1)
              .toString());

          myCell = myRow.createCell(currCell++);
          myCell.setCellValue(fm.getEvaluation().getYearOfEvaluations().get(2)
              .toString());

          myCell = myRow.createCell(currCell++);
          myCell.setCellValue(fm.getEvaluation().getYearOfEvaluations().get(3)
              .toString());
        } else
        {
          myCell = myRow.createCell(currCell++);
          myCell.setCellValue("");

          myCell = myRow.createCell(currCell++);
          myCell.setCellValue("");

          myCell = myRow.createCell(currCell++);
          myCell.setCellValue("");

          myCell = myRow.createCell(currCell++);
          myCell.setCellValue("");
        }

        myCell = myRow.createCell(currCell++);
        myCell.setCellValue(fm.getEvaluation().getYearTenureGranted());

        myCell = myRow.createCell(currCell++);
        myCell.setCellValue("");

        if (!fm.getPromotion().getYearOfPromotions().isEmpty())
        {
          myCell = myRow.createCell(currCell++);
          myCell.setCellValue(fm.getPromotion().getYearOfPromotions().get(0)
              .toString());

          myCell = myRow.createCell(currCell++);
          myCell.setCellValue(fm.getPromotion().getYearOfPromotions().get(1)
              .toString());

          myCell = myRow.createCell(currCell++);
          myCell.setCellValue(fm.getPromotion().getYearOfPromotions().get(2)
              .toString());
        } else
        {
          myCell = myRow.createCell(currCell++);
          myCell.setCellValue("");

          myCell = myRow.createCell(currCell++);
          myCell.setCellValue("");

          myCell = myRow.createCell(currCell++);
          myCell.setCellValue("");
        }

        myCell = myRow.createCell(currCell++);
        myCell.setCellValue("");

        myCell = myRow.createCell(currCell++);
        StringBuilder builder = new StringBuilder();
        builder.append(fm.getComments().get(0));
        for (int i = 1; i < fm.getComments().size(); i++)
        {
          builder.append(fm.getComments().get(i));
        }
        String result = builder.toString();
        myCell.setCellValue(result);
      }

      try
      {
        FileOutputStream out = new FileOutputStream(fileOut);
        myWorkBook.write(out);
        out.close();
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    } finally
    {
    }
  }
}
