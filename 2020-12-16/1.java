import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;


public class CreateXL {
    /** Excel 文件要存放的位置，假定在F盘下*/
    public static String outputFile = "F:\\test.xls";
    public static void main(String argv[]) {

        //定义二维数组
        String xf[][]={
                {"序号","学期","课程代号","课程名称","学分","成绩","计划学期","计划代码","计划课程","计划学分","课程性质"},
        {"1","2018-2019_2","BG000000210","大学计算机基础","3","74","2018-2019_1","BG000000210","大学计算机基础","3","BG通识必修"},
        {"2","2019-2020_1","BG0000006X0","大学英语3","3.5","69","2019-2020_1","BG0000006X0","大学英语3","3.5","BG通识必修"}
        };


        try {
            // 创建新的Excel 工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表，其名为缺省值
            // 如要新建一名为"效益指标"的工作表，其语句为：
            HSSFSheet sheet = workbook.createSheet("学生成绩");
            // 在索引0的位置创建行（最顶端的行）

            //HSSFRow row = sheet.createRow((short)0);

            HSSFRow row[] = new HSSFRow[3];
            HSSFCell cell[][] =new HSSFCell[3][11];

            for(int i=0;i<row.length;i++){
                 row[i] = sheet.createRow((short)i);
            }
            for(int i=0;i<cell.length;i++){
                for(int j=0;j<cell[i].length;j++)
                     cell[i][j] = row[i].createCell((short)j);
            }

            for(int i=0;i<cell.length;i++){
                for(int j=0;j<cell[i].length;j++)
                    cell[i][j].setCellValue(xf[i][j]);
            }
            //在索引0的位置创建单元格（左上端）
            /*
            HSSFCell cell01 = row.createCell((short)0);

            HSSFCell cell02 = row.createCell((short)1);

            HSSFCell cell03 = row.createCell((short)2);

            HSSFCell cell04 = row.createCell((short)3);

            HSSFCell cell05 = row.createCell((short)4);

            HSSFCell cell06 = row.createCell((short)5);

            HSSFCell cell07 = row.createCell((short)6);

            HSSFCell cell08 = row.createCell((short)7);

            HSSFCell cell09 = row.createCell((short)8);

            HSSFCell cell10 = row.createCell((short)9);

            HSSFCell cell11 = row.createCell((short)10);
            */

            // 在单元格中输入一些内容

            /*
            cell01.setCellValue("序号");
            cell02.setCellValue("学期");
            cell03.setCellValue("课程代号");
            cell04.setCellValue("课程名称");
            cell05.setCellValue("学分");
            cell06.setCellValue("成绩");
            cell07.setCellValue("计划学期");
            cell08.setCellValue("计划代码");
            cell09.setCellValue("计划课程");
            cell10.setCellValue("计划学分");
            cell11.setCellValue("课程性质");
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