import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;


public class CreateXL {
    /** Excel �ļ�Ҫ��ŵ�λ�ã��ٶ���F����*/
    public static String outputFile = "F:\\test.xls";
    public static void main(String argv[]) {
        try {
            // �����µ�Excel ������
            HSSFWorkbook workbook = new HSSFWorkbook();
            // ��Excel�������н�һ����������Ϊȱʡֵ
            // ��Ҫ�½�һ��Ϊ"Ч��ָ��"�Ĺ����������Ϊ��
            HSSFSheet sheet = workbook.createSheet("ѧ���ɼ�");
            // ������0��λ�ô����У���˵��У�
			
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
            //������0��λ�ô�����Ԫ�����϶ˣ�
			
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
            // �ڵ�Ԫ��������һЩ����
			
			cell[0][0].setCellValue("��Ŀ");
			cell[0][1].setCellValue("����");
			cell[1][0].setCellValue("����");
			cell[1][1].setCellValue("100");
			cell[2][0].setCellValue("��ѧ");
			cell[2][1].setCellValue("98");
			cell[3][0].setCellValue("Ӣ��");
			cell[3][1].setCellValue("95");
			
			/*
			cell00.setCellValue("��Ŀ");
			cell01.setCellValue("����");
			cell10.setCellValue("����");
			cell11.setCellValue("100");
			cell20.setCellValue("��ѧ");
			cell21.setCellValue("98");
			cell30.setCellValue("Ӣ��");
			cell31.setCellValue("95");
			*/
	
            // �½�һ����ļ���
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // ����Ӧ��Excel ����������
            workbook.write(fOut);
            fOut.flush();
            // �����������ر��ļ�
            fOut.close();
            System.out.println("�ļ�����...");
        } catch (Exception e) {
            System.out.println("������ xlCreate() : " + e);
        }
    }
}