package excelInsertPic;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @Auther: liuxin
 * @Date: 2019/6/19 17:24
 * @Description:
 */
public class setExcelWidthAndHeight {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("C:/Users/dell/Desktop/1234.xls");

        HSSFWorkbook wb = new HSSFWorkbook();

        /**
         * ========================================================
         * 							设置cell宽度
         *  通过sheet 对象，setColumnWidth设置cell的宽度
         * ========================================================
         */
        HSSFSheet sheet = wb.createSheet("sheet1");
        // api 段信息 Set the width (in units of 1/256th of a character width)
        sheet.setColumnWidth(0, 20 * 256);

        /**
         * ========================================================
         * 							设置行高度
         *  通过row 对象设置行高
         * ========================================================
         */
        HSSFRow row = sheet.createRow(0);
        //heightInPoints 设置的值永远是height属性值的20倍
        row.setHeightInPoints(20);

        HSSFRow row1 = sheet.createRow(5);
        // Set the row's height or set to ff (-1) for undefined/default-height.
        // Set the height in "twips" or
        // 1/20th of a point.
        row1.setHeight((short) (25 * 20));

        HSSFCell cell = row.createCell(0);

        cell.setCellValue("a1b2c3d4e5f6g7h8i9");

        //设置默认宽度、高度值
        HSSFSheet sheet2 =  wb.createSheet("sheet2");

        sheet2.setDefaultColumnWidth(20);
        sheet2.setDefaultRowHeightInPoints(20);

        //格式化单元格日期信息
        HSSFDataFormat dataFormat =  wb.createDataFormat();
        short dataformat = dataFormat.getFormat("yyyy-mm-dd HH:MM");
        HSSFCellStyle style = wb.createCellStyle();


        style.setDataFormat(dataformat);


        HSSFCell cell2 = sheet2.createRow(0).createCell(0);

        cell2.setCellValue(new Date());

        cell2.setCellStyle(style);

        try {
            wb.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
