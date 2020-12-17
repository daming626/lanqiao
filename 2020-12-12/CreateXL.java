import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;


public class CreateXL {
    /** Excel 文件要存放的位置，假定在F盘下*/
    public static String outputFile = "F:\\test.xls";
    public static void main(String argv[]) {
        try {
            // 创建新的Excel 工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表，其名为缺省值
            // 如要新建一名为"效益指标"的工作表，其语句为：
            HSSFSheet sheet = workbook.createSheet("学生成绩");
            // 在索引0的位置创建行（最顶端的行）
			
			HSSFRow row[] = new HSSFRow[4];
			HSSFCell cell[][] = new HSSFCell[4][2];
			for(int i=0;i<row.length;i++){
				row[i] = sheet.createRow((short)i);
			}
			
            /*
			HSSFRow row0 = sheet.createRow((short)0);
			HSSFRow row1 = sheet.createRow((short)1);
			HSSFRow row2 = sheet.createRow((short)2);
			HSSFRow row3 = sheet.createRow((short)3);
			*/
            //在索引0的位置创建单元格（左上端）
			
			for(int i=0;i<cell.length;i++)
				for(int j=0;j<cell[i].length;j++){
					cell[i][j] = row[i].createCell((short)j);
				}
			
            /*
			HSSFCell cell00 = row0.createCell((short)0);
			HSSFCell cell01 = row0.createCell((short)1);
            HSSFCell cell10 = row1.createCell((short)0);
			HSSFCell cell11 = row1.createCell((short)1);
			HSSFCell cell20 = row2.createCell((short)0);
			HSSFCell cell21 = row2.createCell((short)1);
			HSSFCell cell30 = row3.createCell((short)0);
			HSSFCell cell31 = row3.createCell((short)1);
			*/
            // 在单元格中输入一些内容
			
			cell[0][0].setCellValue("科目");
			cell[0][1].setCellValue("分数");
			cell[1][0].setCellValue("语文");
			cell[1][1].setCellValue("100");
			cell[2][0].setCellValue("数学");
			cell[2][1].setCellValue("98");
			cell[3][0].setCellValue("英语");
			cell[3][1].setCellValue("95");
			
			/*
			cell00.setCellValue("科目");
			cell01.setCellValue("分数");
			cell10.setCellValue("语文");
			cell11.setCellValue("100");
			cell20.setCellValue("数学");
			cell21.setCellValue("98");
			cell30.setCellValue("英语");
			cell31.setCellValue("95");
			*/
	
            // 新建一输出文件流
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // 把相应的Excel 工作簿存盘
            workbook.write(fOut);
            fOut.flush();
            // 操作结束，关闭文件
            fOut.close();
            System.out.println("文件生成...");
        } catch (Exception e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }
}