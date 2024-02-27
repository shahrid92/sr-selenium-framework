package common.utilities.testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;

    public static Object[][] getTableArray(String filePath, String sheetName) throws Exception {
        String[][] tabArray = null;

        try (FileInputStream excelFile = new FileInputStream(filePath)) {
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(excelFile);
            ExcelWSheet = ExcelWBook.getSheet(sheetName);

            int startRow = 1;
            int startCol = 1;

            int totalRows = ExcelWSheet.getLastRowNum();
            int totalCols = 2; // You may want to determine this dynamically based on your data

            tabArray = new String[totalRows][totalCols];

            for (int i = startRow; i <= totalRows; i++) {
                for (int j = startCol; j <= totalCols; j++) {
                    tabArray[i - 1][j - 1] = getCellData(i, j);
                    System.out.println(tabArray[i - 1][j - 1]);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }

        return tabArray;
    }

    public static String getCellData(int rowNum, int colNum) throws Exception {
        try {
            Cell = ExcelWSheet.getRow(rowNum).getCell(colNum);

            if (Cell == null || Cell.getCellType() == CellType.BLANK) {
                return "";
            } else {
                return Cell.getStringCellValue();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}