package excelInsertPic;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther: liuxin
 * @Date: 2019/6/19 16:59
 * @Description:
 */
public class ExcelPic {
    public static void main(String[] args) {
        // 创建一个文件输出流实例

        FileOutputStream fileOut = null;

        /*

         * 目的：操作图片 实现：第一步-需要将图片从磁盘加载到内存中，第二步-java中有Image和BufferedImage这两种处理图片的类，

         * 第一种类似copy，不能对 图片进行操作，而BufferedImage则是将图片放入内存图片缓冲区中，可以对图片进行修改。

         */

        BufferedImage bufferImg = null;

// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray

        try {

            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();

            bufferImg = ImageIO.read(new File("E:/work/tools/attached/qr/assetsSbkSbkNo .png"));

            ImageIO.write(bufferImg, "png", byteArrayOut);


            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFCellStyle bodyStyle = wb.createCellStyle();
            bodyStyle.setVerticalAlignment(VerticalAlignment.TOP);
            bodyStyle.setBorderBottom(BorderStyle.THICK); //下边框
            bodyStyle.setBorderLeft(BorderStyle.THICK);//左边框
            bodyStyle.setBorderTop(BorderStyle.THICK);//上边框
            bodyStyle.setBorderRight(BorderStyle.THICK);//右边框

            HSSFFont font = wb.createFont();
            font.setFontName("宋体");
            font.setBold(true);
            font.setFontHeightInPoints((short) 12);

            bodyStyle.setWrapText(true);
            HSSFSheet sheet1 = wb.createSheet("sheet");

            // 画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
            HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();

            sheet1.setDefaultRowHeight((short) (12*256));
            sheet1.setDefaultColumnWidth(60);
            for (int i = 0; i < 10; i++) {
                Row row = sheet1.createRow(i);
                for (int j = 0; j < 5; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellStyle(bodyStyle);
                    String title = "\n" +
                            "    东莞市输变电工程公司固定资产\n\r\n\r";
                    HSSFRichTextString content = new HSSFRichTextString(title+"          编号 ：     00001" +
                            "\n\r\n\r   资产名称 ：     椅子" +
                            "\n\r\n\r   购买日期 ：     2019-01-31" +
                            "\n\r\n\r   资产类别 ：     办公设备");


                    content.applyFont(0,title.length(),font);

                    cell.setCellValue(content);

                    //划线
                    HSSFClientAnchor a1 = new HSSFClientAnchor(50, 50, 1000, 50, (short) j, i,(short) j, i);

                    // anchor主要用于设置图片的属性
                    HSSFClientAnchor anchor = new HSSFClientAnchor(600, 50, 930, 220, (short) j, i, (short) j, i);

                    // 插入图片
                    patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));

                    HSSFSimpleShape line = patriarch.createSimpleShape(a1);
                    line.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);
                    line.setLineStyle(HSSFShape.LINESTYLE_SOLID);
                    line.setLineWidth(6350);

                }
            }

            File file = new File("C:/Users/dell/Desktop/123.xls");

            file.createNewFile();

            fileOut = new FileOutputStream(file);

            // 写入excel文件

            wb.write(fileOut);

            System.out.println("----Excel文件已生成------");

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (fileOut != null) {

                try {

                    fileOut.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }
    }
}
