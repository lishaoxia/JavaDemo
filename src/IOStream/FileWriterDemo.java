package IOStream;

import java.io.*;

/**
 *  new FileWriter 和close方法都抛出了异常，下面是标准的异常处理格式
 */

public class FileWriterDemo {
    public static void main(String[] args){
        String path = "C:\\Users\\l2638\\Desktop\\lichao.txt";
        //创建一个FileWriter对象，如果目录下没有该文件会创建一个文件；如果目录下已有重名文件，会覆盖创建一个空的新文件

        FileWriter fw = null;   //fw 定义在try外面，不然finally块访问不到
        try{
            fw = new FileWriter(path,true); //append为true时，续写，且有重名文件时，不会覆盖创建新文件

            fw.write("写入一段字符串");//运行后并没有直接写到文件中，而是写到内存中的流中

            fw.flush();//的数刷新流内缓冲区据，将数据刷到目标文件内，刷新后流可以继续使用
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try{    //close方法throws异常，需要捕捉
                if(fw!=null)    //fw如果初始化失败，对象不存在，无法使用close方法，这里需要判断
                {
                    fw.close();//关闭流，关闭之前默认会刷新一次流内缓冲区的数据，刷新后流关闭，不可使用
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}
