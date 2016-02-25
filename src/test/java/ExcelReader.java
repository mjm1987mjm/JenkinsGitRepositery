import org.apache.poi.ss.formula.functions.Index;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ExcelReader {

    public FileInputStream fis = null;
    public FileOutputStream fileout = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;

    String path = null;

    //constructor

    public ExcelReader() throws IOException {
        path = System.getProperty("user.dir") + "\\testdata\\TestData.xlsx";
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0);

    }

    //Provides total number of rows in sheet - testcase
    public int getSheetRows(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);

        return (sheet.getLastRowNum() + 1);
    }

    //Provides total number of column in sheet - testcase
    public int getSheetColumns(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);

        row = sheet.getRow(0);
        return (row.getLastCellNum());
    }

    //Provides cell value - testdata
    public String getCellDate(String sheetName, int colNum, int rowNum) {
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);

        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        return (cell.getStringCellValue());
    }

    //Provides cell value - testdata
    public String getCellDate(String sheetName, String colName, int rowNum) {
        int colNum = -1;
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);

        for (int i = 0; i < getSheetColumns(sheetName); i++) {
            row = sheet.getRow(0);
            cell = row.getCell(i);

            if (cell.getStringCellValue().equals(colName)) {
                colNum = cell.getColumnIndex();
                break;
            }
        }
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        return (cell.getStringCellValue());
    }

    public static void main(String args[]) throws IOException {
        ExcelReader reader = new ExcelReader();
        System.out.println(reader.getSheetRows("SignUp"));
        System.out.println(reader.getSheetColumns("SignUp"));
        System.out.println(reader.getCellDate("SignUp", 1, 1));
        System.out.println(reader.getCellDate("LogIn", "Password", 1));
        reader.setCellData("LogIn", 1, 1, "Hello World");
    }

    public void setCellData(String sheetName, int colNum, int rowNum, String str) throws IOException {
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);
        row = sheet.getRow(rowNum);
        cell = row.createCell(colNum);
        cell.setCellValue(str);
        fileout = new FileOutputStream(path);
        try {
            workbook.write(fileout);
            fileout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

