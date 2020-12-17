import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;


public class CreateXL {
    /** Excel �ļ�Ҫ��ŵ�λ�ã��ٶ���F����*/
    public static String outputFile = "F:\\test.xls";
    public static void main(String argv[]) {

        //�����ά����
        String xf[][]={
                {"���","ѧ��","�γ̴���","�γ�����","ѧ��","�ɼ�","�ƻ�ѧ��","�ƻ�����","�ƻ��γ�","�ƻ�ѧ��","�γ�����"},
        {"1","2018-2019_2","BG000000210","��ѧ���������","3","74","2018-2019_1","BG000000210","��ѧ���������","3","BGͨʶ����"},
        {"2","2019-2020_1","BG0000006X0","��ѧӢ��3","3.5","69","2019-2020_1","BG0000006X0","��ѧӢ��3","3.5","BGͨʶ����"}
        };


        try {
            // �����µ�Excel ������
            HSSFWorkbook workbook = new HSSFWorkbook();
            // ��Excel�������н�һ����������Ϊȱʡֵ
            // ��Ҫ�½�һ��Ϊ"Ч��ָ��"�Ĺ����������Ϊ��
            HSSFSheet sheet = workbook.createSheet("ѧ���ɼ�");
            // ������0��λ�ô����У���˵��У�

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
            //������0��λ�ô�����Ԫ�����϶ˣ�
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

            // �ڵ�Ԫ��������һЩ����

            /*
            cell01.setCellValue("���");
            cell02.setCellValue("ѧ��");
            cell03.setCellValue("�γ̴���");
            cell04.setCellValue("�γ�����");
            cell05.setCellValue("ѧ��");
            cell06.setCellValue("�ɼ�");
            cell07.setCellValue("�ƻ�ѧ��");
            cell08.setCellValue("�ƻ�����");
            cell09.setCellValue("�ƻ��γ�");
            cell10.setCellValue("�ƻ�ѧ��");
            cell11.setCellValue("�γ�����");
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