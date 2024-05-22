package IOStream;

import java.io.*;

/**
 * InputStreamReader转换流，将字节输入流转换成字符输入流.输入流只能将字节流转换成字符流，不能将字符流转成字节流，字节流的缓冲区对象没有readline()方法，只有字符流的缓冲区对象有readline()方法
 * 为什么将字节流转字符，因为有些输入不只是通过文本文件获取的，比如键盘输入，网络传输，都是获取到的字节流，转换成字符流，可以使用readline()方法，方便操作
 */

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\lichao\\Desktop\\lichao.txt";
        FileInputStream  fis = new FileInputStream(file);
//        BufferedInputStream bfis = new BufferedInputStream(fis);
//        byte[] by = new byte[1024];
//        int len=0;
//        while((len=bfis.read(by))!=-1)
//        {
//            System.out.println(new String(by,0,len));
//        }
        //字节流没有readline()方法，无法直接读取一行
        //创建一个字节流转字符流的转换流对象,将字节流转换成字符流
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        System.out.println(br.readLine());

//        bfis.close();
        br.close();

    }
}
