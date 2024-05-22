package IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
字符流：
FileReader
FileWriter

BufferReader
BufferWriter

字节流：
FileInputStream
FileOutputStream

Bufferred

*/

public class FileStreamDemo {
    private final static String  file = "C:\\Users\\l2638\\Desktop\\lichao.txt";
    public static void main(String[] args) throws IOException{
//    writeFile();
//    readFileChar();
    readFileCharBuf();//最优读取方式
//    readFileCharBuf_2();//文件过大容易造成内存溢出

    }
    public  static  void writeFile() throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        fos.write("这是字节流写入\t\n".getBytes());
        fos.write("这是Second Line".getBytes());
        //执行完上一行代码，目标文件中已经写入了内容。所以这儿不需要flush
        fos.close();
    }
    public  static  void readFileChar() throws IOException{
        FileInputStream fis = new FileInputStream(file);
        int ch =0;
        while((ch=fis.read())!=-1)
        {
            System.out.print((char)ch); //如果是中文，打印是乱码
        }
        fis.close();
    }

    public  static  void readFileCharBuf() throws IOException{
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[1024];
        int len = 0;
        while((len=fis.read(buf))!=-1)
        {
            System.out.print(new String(buf,0,len)); //可以打印中文，不是乱码
        }
        fis.close();
    }

    public  static  void readFileCharBuf_2() throws IOException{
        FileInputStream fis = new FileInputStream(file);
        /*
        * available()返回fis对象的长度
        * 定义一个长度刚刚好的byte[]，当文件很大时，不能使用这个方式，比如一个2G的电影，使用下面的代码容易造成内存溢出
        * */
        byte[] buf = new byte[fis.available()];
        int len = 0;
        while((len=fis.read(buf))!=-1)
        {
            System.out.print(new String(buf,0,len)); //可以打印中文，不是乱码
        }
        fis.close();
    }
}
