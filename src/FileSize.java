import java.io.File;

public class FileSize {


    public static long getFileSize(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return -1;
        }
        return file.length(); //文件字节大小，比如174字节，则返回174，   1.72KB 则返回 1764

    }

    public static void main(String[] args) {
        String path = "C:\\Users\\lichao\\Desktop\\新建文本文档.txt";
        long size = getFileSize(path);
        System.out.println(size);
    }


}
