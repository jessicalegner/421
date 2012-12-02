package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import domain.FacultyList;
import domain.FacultyMember;

public class ReadObjects {
	public static FacultyList readObjects() throws Exception 
	{
        //
        // An excel file name. You can create a file name with a full 
        // path information.
        //
        String filename = "C:\\Users\\Owner\\Desktop\\facultydata.xls";
 
        //
        // Create an ArrayList to store the data read from excel sheet.
        //
        List sheetData = new ArrayList();
 
        FileInputStream fis = null;
        try {
            //
            // Create a FileInputStream that will be use to read the 
            // excel file.
            //
            fis = new FileInputStream(filename);
 
            //
            // Create an excel workbook from the file system.
            //
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            //
            // Get the first sheet on the workbook.
            //
            HSSFSheet sheet = workbook.getSheetAt(0);
 
            //
            // When we have a sheet object in hand we can iterator on 
            // each sheet's rows and on each row's cells. We store the 
            // data read on an ArrayList so that we can printed the 
            // content of the excel to the console.
            //
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();
 
                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }
 
                sheetData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
 
       return showExcelData(sheetData);
    }
 
    private static FacultyList showExcelData(List sheetData) {
        //
        // Iterates the data and print it out to the console.
        HSSFCell cell;
    	
    	FacultyList FL = new FacultyList();
    	
        for (int i = 4; i < sheetData.size(); i++) { // row 	
        	FacultyMember fm = new FacultyMember();
        	
            List list = (List) sheetData.get(i);

            cell = (HSSFCell) list.get(1);			// column
            fm.setName(cell.getRichStringCellValue().getString());
            
            cell = (HSSFCell) list.get(2);
            fm.setPosition(Integer.parseInt(cell.getRichStringCellValue().getString()));
            
            cell = (HSSFCell) list.get(3);
            fm.setGender(cell.getRichStringCellValue().getString().charAt(0));
            
            cell = (HSSFCell) list.get(4);
            fm.setDepartment(cell.getRichStringCellValue().getString());
            
            cell = (HSSFCell) list.get(5);
            fm.setCollege(cell.getRichStringCellValue().getString());
            
            cell = (HSSFCell) list.get(6);
            fm.setDateOfHire(cell.getRichStringCellValue().getString());
            
            cell = (HSSFCell) list.get(7);
            String RAH = cell.getRichStringCellValue().getString();
            
            cell = (HSSFCell) list.get(8);
            String CR = cell.getRichStringCellValue().getString();
            
            fm.setRank(RAH, CR);
            cell = (HSSFCell) list.get(9);
            String DL = cell.getRichStringCellValue().getString();
            
            cell = (HSSFCell) list.get(10);
            String INST = cell.getRichStringCellValue().getString();
            
            fm.setDegree(DL, INST);
            
            cell = (HSSFCell) list.get(11);
            String EC = cell.getRichStringCellValue().getString();
            
            cell = (HSSFCell) list.get(12);
            fm.setEvaluationYear(cell.getRichStringCellValue().getString());
            
            cell = (HSSFCell) list.get(13);
            fm.setEvaluationYear(cell.getRichStringCellValue().getString());
            
            cell = (HSSFCell) list.get(14);
            fm.setEvaluationYear(cell.getRichStringCellValue().getString());
            
            cell = (HSSFCell) list.get(15);
            fm.setEvaluationYear(cell.getRichStringCellValue().getString());
            
            cell = (HSSFCell) list.get(16);
            String TG = cell.getRichStringCellValue().getString();
            
            fm.setEvaluation(TG,false);
            
            cell = (HSSFCell) list.get(17);
            //SKIPPING
            cell = (HSSFCell) list.get(18);
            fm.setPromotionYear(cell.getRichStringCellValue().getString());
            
            cell = (HSSFCell) list.get(19);
            fm.setPromotionYear(cell.getRichStringCellValue().getString());
            
            cell = (HSSFCell) list.get(20);
            fm.setPromotionYear(cell.getRichStringCellValue().getString());
            
            cell = (HSSFCell) list.get(21);
            //SKIPPING
            
            fm.setPromotion(EC, false);
            
            cell = (HSSFCell) list.get(22);
            fm.setComments(cell.getRichStringCellValue().getString());
            
            FL.addRecord(fm);
            
        }
        
        return FL;
    }
}
