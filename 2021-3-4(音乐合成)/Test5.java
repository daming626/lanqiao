package cn;
import java.io.*;
/*
音乐文件合并
 */

public class Test5 {
    static String pathName = "F:\\欧家明\\mp3.list.txt";

    public static void main(String[] args) {
        File file = new File("F:\\欧家明\\歌曲合并");
        File files[] = file.listFiles();//将目录下的每条数据以数组存起来

        FileWriter fw = null;//写文件
        BufferedWriter bw = null;

        FileReader fr = null;//读文件
        BufferedReader br = null;

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("F:\\欧家明\\合并.mp3");
            fw = new FileWriter(pathName);//将文件名写入文件mp3.list.txt
            bw = new BufferedWriter(fw);
            for (File f : files) {
                if (f.getName().endsWith(".mp3")) {
                    bw.write((f.getAbsolutePath()));//写入缓冲器
                    bw.newLine();//换行
                }
            }
            bw.flush();//写入文件

            fr = new FileReader(pathName);//将文件mp3.list.txt的每条数据合并到合并.mp3
            br = new BufferedReader(fr);
            String mp3Name = "";//构建容器
            while ((mp3Name = br.readLine()) != null) {
                FileInputStream fis = new FileInputStream(mp3Name);
                int b = 0;//构建容器
                byte by[] = new byte[1024];
                while ((b = fis.read(by)) != -1) {//单次传输1024字节的数据
                    fos.write(by, 0, b);
                }
                fis.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
