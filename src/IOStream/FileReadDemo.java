package IOStream;

import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;

public class FileReadDemo {
    private final static String file = "C:\\Users\\l2638\\Desktop\\新建文本文档.txt";
    public static void main(String[] args) throws IOException {
//        frReadChar();//一个字符一个字符的读
        frReadCharBuf();//一次读取多个字符装到字符数组
    }

    /**
     *  fr的read方法，读单个字符
     */
    public static void frReadChar() throws IOException{
        //创建一个文件读取流对象，和指定名称的文件相关联
        //要保证该文件是已经存在的，如果不存在，会发生异常
        FileReader fr = new FileReader(file);
        while(true)
        {
            int ch = fr.read();//read方法，读取一个字符，返回int类型ASCII码
            if(ch ==-1) //读到流末尾返回-1
            {
                break;
            }
            //System.out.print("ch="+ch);
            System.out.print((char)ch); //将ASCII码转成字符，可直接打印中文
        }
        fr.close();
    }

    /**
     * 读取一个
     * @throws IOException
     */

    public static void frReadCharBuf() throws IOException{
        FileReader fr = new FileReader(file);
        //定义一个字符数组，用于存储读到的字符。
        //read(char[])返回的是读取字符的个数，读取了100个字符则返回100.读取了1024个字符则返回1024
        char[] buf = new char[1024];//初始定义大小一般为1024的整数倍

        int num = 0;
        num = fr.read(buf);//将字符数组作为参数传递给read方法，会读取多个字符装到字符数组，读取的字符个数等于字符数组的长度
                            //如果读到的内容中包含换行符，换行符也会装到字符数组
        while(num!=-1)
        {
            /*
            这里用的print而不是println，因为FileReader的read()方法会读取换行符，打印出来会换行，如果
            使用println,假如一次循环没有读取完所有字符，打印会换行，打印出的结构与原来不一致
            */
            System.out.print(new String(buf,0,num));
            num = fr.read(buf);
        }
        fr.close();
    }

}
