package test;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
    static XSSFWorkbook workbook;
    static XSSFSheet workSheet;

    public ExcelUtils(String excelPath, String sheetName){
        try{
            workbook = new XSSFWorkbook(excelPath);
            workSheet = workbook.getSheet(sheetName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Object getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        Object cellValue = formatter.formatCellValue(workSheet.getRow(rowNum).getCell(colNum));
        return cellValue;
    }
    public int getRowCount() {
        int rowCount = workSheet.getPhysicalNumberOfRows();
        return rowCount;
    }
}
