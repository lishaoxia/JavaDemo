package IOStream;

import java.io.*;
import java.io.FileReader;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("C:\\Users\\l2638\\Desktop\\lichao.txt");
        //为了提高效率，加入缓冲技术，将字符读取流对象作为参数传递给缓冲对象的构造函数
        BufferedReader bufr = new BufferedReader(fr);
        String line = null;
        /**
         * BufferReader对象提供了一个读一行方法readLine()，FileReader对象没有该方法
         * 返回改行内容的字符串，不包含任何终止符，如果已达到流末尾，则返回null
         */
        line = bufr.readLine();
        while (line!=null)
        {
            System.out.println(line);
            line = bufr.readLine();
        }
        bufr.close();
    }
}
