package test;

import java.io.*;

public class Test6 {
    static String pathName = "F:\\欧家明\\png.list.txt";

    public static void main(String[] args) throws IOException {
        File file = new File("F:\\欧家明\\BIGIMAGE");//读取文件
        File files[] = file.listFiles();//将文件的每行数据存入数组

        FileWriter fw = new FileWriter(pathName);//读取文件写入的文件地址

        for (File f : files) {
            if (f.getName().endsWith(".png")) {//对比字符串末尾是否有相同的串
                fw.write(f.getAbsolutePath());//获取文件的绝对路径
                fw.write("\r");//回车
                fw.write("\n");//换行
            }
        }
        fw.close();//关闭流

        FileReader fr = new FileReader(pathName);
        BufferedReader br = new BufferedReader(fr);

        FileOutputStream fos = new FileOutputStream("F:\\欧家明\\图片合成.dat");//指定文件输出流的地址
        FileInputStream fis = null;
        String pngName ="";
        while ((pngName = br.readLine()) != null) {
            fis = new FileInputStream(pngName);
            int a=0;
            byte by[] = new byte[1024];
            while((a=fis.read(by))!=-1){
                fos.write(by,0,a);
            }
            fis.close();
        }
        fr.close();
        fos.close();
    }
}
