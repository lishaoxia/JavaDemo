import com.vdurmont.emoji.*;

import java.io.*;

public class EmojiToStr {
    public static void main(String[] args)throws IOException {
        FileReader fr = new FileReader("C:\\Users\\lichao\\Desktop\\data\\data.txt");
        FileWriter fw = new FileWriter("C:\\Users\\lichao\\Desktop\\data\\data_new.txt");

        BufferedReader bufr = new BufferedReader(fr);
        BufferedWriter bufw = new BufferedWriter(fw);
        String line = null;
        String str = null;

        line = bufr.readLine();
        while (line!=null)
        {
//            System.out.println("----------------------------------------------------------------");
//            System.out.println(line);
//            System.out.println("to aliases 之后：");
            System.out.println(EmojiParser.parseToAliases(line));
//            System.out.println(EmojiParser.parseToAliases(line, EmojiParser.FitzpatrickAction.PARSE));
//            System.out.println(EmojiParser.parseToAliases(line, EmojiParser.FitzpatrickAction.REMOVE));
//            System.out.println(EmojiParser.parseToAliases(line, EmojiParser.FitzpatrickAction.IGNORE));
//            System.out.println("----------------------------------------------------------------");
            str = EmojiParser.parseToAliases(line);
            bufw.write(str);
            bufw.newLine();
            bufw.flush();
            line = bufr.readLine();
        }
        bufr.close();
        bufw.close();

        System.out.println("运行结束");

    }
}
