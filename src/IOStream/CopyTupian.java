package IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTupian {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try
        {
            fis = new FileInputStream("C:\\Users\\lichao\\Desktop\\1.png");
            fos = new FileOutputStream("C:\\Users\\lichao\\Desktop\\2.png");

            byte[] buf = new byte[1024];
            int len = 0;
            while((len=fis.read(buf))!=-1)
            {
                fos.write(buf,0,len);
            }

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try{
                if(fis!=null)
                    fis.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException("输入流关闭失败");
            }
            try{
                if(fos!=null)
                    fos.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException("输出流关闭失败");
            }
        }
    }
}
