package test;

public class ExcelTest {

    public static void main(String args[]){
        String excelPath = "./TestData/testdata.xlsx";
        String excelSheet = "login";
        ExcelUtils excel = new ExcelUtils(excelPath,excelSheet);

        excel.getCellData(1,0);
        excel.getRowCount();

    }
}
