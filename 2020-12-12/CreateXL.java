import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;


public class CreateXL {
    /** Excel ????????¦Ë????????F????*/
    public static String outputFile = "F:\\test.xls";
    public static void main(String argv[]) {
        try {
            // ???????Excel ??????
            HSSFWorkbook workbook = new HSSFWorkbook();
            // ??Excel???????§ß????????????????
            // ??????????"§¹?????"???????????????
            HSSFSheet sheet = workbook.createSheet("??????");
            // ??????0??¦Ë??????§µ???????§µ?
			
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
            //??????0??¦Ë????????????????
			
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
            // ?????????????§»????
			
			cell[0][0].setCellValue("???");
			cell[0][1].setCellValue("????");
			cell[1][0].setCellValue("????");
			cell[1][1].setCellValue("100");
			cell[2][0].setCellValue("???");
			cell[2][1].setCellValue("98");
			cell[3][0].setCellValue("???");
			cell[3][1].setCellValue("95");
			
			/*
			cell00.setCellValue("???");
			cell01.setCellValue("????");
			cell10.setCellValue("????");
			cell11.setCellValue("100");
			cell20.setCellValue("???");
			cell21.setCellValue("98");
			cell30.setCellValue("???");
			cell31.setCellValue("95");
			*/
	
            // ????????????
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // ???????Excel ??????????
            workbook.write(fOut);
            fOut.flush();
            // ????????????????
            fOut.close();
            System.out.println("???????...");
        } catch (Exception e) {
            System.out.println("?????? xlCreate() : " + e);
        }
    }
}