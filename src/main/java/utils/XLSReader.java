package utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import static utils.Drivers.propertyFileReader;

public class XLSReader {
    public static String testDataPath = propertyFileReader.getProperty("config","TEST_DATA_PATH");

    @DataProvider(name = "logindata")
    public Object[][] getData(Method m) throws IOException {
        String filePath=testDataPath;
        String sheet = m.getName();
        File f = new File(filePath);
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(sheet);

        int totalRows = sheetName.getLastRowNum();
        //System.out.println("Total Rows: "+totalRows);
        Row rowCells = sheetName.getRow(0);
        int totalCols = rowCells.getLastCellNum();
        //System.out.println("Total Columns: "+totalCols);

        DataFormatter format = new DataFormatter();

        String testData [][]=new String[totalRows][totalCols];
        for (int r=1;r<=totalRows;r++){
            for (int c=0;c<totalCols;c++){
                testData[r-1][c]=format.formatCellValue(sheetName.getRow(r).getCell(c));
                //System.out.println(testData[r-1][c]);
            }
        }
        return testData;
    }
}
