package cn;

import java.io.*;

public class IOApp {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;//FileReader的包装升级版，可输出一行
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader("C:\\Users\\欧家明\\Desktop\\作业.md");
            fw = new FileWriter("F:\\abc.txt");
            br = new BufferedReader(fr);//对FileReader进行包装
            bw = new BufferedWriter(fw);//对FileWriter进行包装
            String a = "";
            int b=0;
            /*while((b = fr.read())!=-1){//单个字符输出abc
                System.out.print((char)b);
                fw.write(b);//写入Buffer(缓冲器)
            }*/
            while ((a = br.readLine()) != null) {//一行字符输出
                System.out.println(a);
                fw.write(a);
            }
            fw.flush();//写入硬盘
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
