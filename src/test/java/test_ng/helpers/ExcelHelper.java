package test_ng.helpers;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelHelper {

    /**
     *
     * @param filePath đường dẫn file excel
     * @param sheetName tên sheet
     * @return Mảng dữ liệu 2 chiều được lấy ra từ excel
     */
    public static Object[][] readExcel(String filePath, String sheetName) {
        Object[][] data = null;

        try {
//            Lấy file
            FileInputStream file = new FileInputStream(new File(filePath));
//            Khởi tạo file định dạng excel
            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            Khởi tạo định dạng sheet của file excel vừa khởi tạo
            XSSFSheet sheet = workbook.getSheet(sheetName);
//            Lấy số lượng row & col có chứa dữ liệu
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

//            Khởi tạo mảng hai chiều với kích thước tương ứng
            data = new Object[rowCount-1][colCount];
            DataFormatter formatter = new DataFormatter(); // Công cụ giúp định dạng mọi loại dữ liệu (số, chữ) thành String
            for (int i = 1; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    if (j == 2) {
                        data[i-1][j] = sheet.getRow(i).getCell(j).getBooleanCellValue();
                    } else {
                        data[i-1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                    }
                }
            }
            workbook.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
