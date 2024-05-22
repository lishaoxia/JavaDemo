package IOStream;

import java.io.*;
import java.util.Scanner;

/**
 *OutputStreamWriter 将输出字符流转成输出字节流，输出流只能将字符流转为字节流，不能将字节流转成字符流，
 * 根据字节编码输出到文件，一个汉字UTF-8编码占3个字节，GBK占2个字节
 */
public class OutputSreamWriterDemo {
    public static void main(String[] args) {
        System.out.println("请输入一段字符串");
        try{
        InputStreamReader fis = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(fis);
        String s = br.readLine();
        writeUTF(s);
        writeGBK(s);
        br.close();
        fis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void writeUTF(String s) throws  IOException{
            FileOutputStream fos = new FileOutputStream("C:\\Users\\l2638\\Desktop\\UTF.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            osw.write(s);
            osw.close();
            fos.close();
    }

    public static void writeGBK(String s)throws  IOException{
        FileOutputStream fos = new FileOutputStream("C:\\Users\\l2638\\Desktop\\GBK.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
        osw.write(s);
        osw.close();
        fos.close();
    }
}