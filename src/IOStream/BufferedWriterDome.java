package IOStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 缓冲区的出现时为了提高流的操作效率而出现的
 * 所以在创建缓冲区之前，先要有流对象
 * 该缓冲区提供了一个跨平台的换行方法newline()
 */
public class BufferedWriterDome {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\l2638\\Desktop\\lichao.txt");

        //只需要将流对象作为参数传递给缓冲区的构造方法即可
        BufferedWriter bufw = new BufferedWriter(fw);
        bufw.write("Demo");
        bufw.newLine(); //跨平台的换行方法，windows换行符\t\n,linux换行符\n
        bufw.write("第二行");
        bufw.flush();   //习惯性的写上，写一部分刷一次，避免停电等外部因素造成所有数据都没有写入
        bufw.close();
    }

}
