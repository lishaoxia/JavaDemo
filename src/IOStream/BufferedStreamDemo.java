package IOStream;

import java.io.*;

/**
 * 演示通过字节流缓冲区复制mp3
 * BufferedInputStream对象没有readline()方法
 * BufferedOutputStream对象没有newline()方法
 */

public class BufferedStreamDemo {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        copy_1();
        long end = System.currentTimeMillis();
        System.out.println((end -start )+"毫秒");

    }
    public  static  void copy_1() throws IOException
    {
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("C:\\Users\\lichao\\Desktop\\One Love.mp3"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\lichao\\Desktop\\One Love_1.mp3"));
        byte[] buf = new byte[1024]; //1024是单次读取的最大长度，while里循环读取，所以源文件可以是大于1024字节的文件
        int len = 0;
        while((len=bufis.read(buf))!=-1)
        {
            bufos.write(buf,0,len);
        }
        bufis.close();
        bufos.close();
    }
}
