import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaMaBang_20200429 {
    public static void main(String[] args) {
        String in_path  = "C:\\Users\\lichao\\Desktop\\data.txt";
        String out_path  = "C:\\Users\\lichao\\Desktop\\data_new.txt";
        List<String> list = new ArrayList<String>();
        try
        {
            list = getFileContext(in_path);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        write_file(list,out_path);


    }


    /**
     * 获取txt文件内容并按行放入list中
     */
    public static List<String> getFileContext(String path) throws Exception {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<String>();
        String line = null;
        line = bufferedReader.readLine();
        int n =1;
        while (line!= null) {
            System.out.println("正在处理第"+n+"行数据");
            /**
             * JSONObject对象，键按首字母排序的问题
             * JSON.parseObject(line)，这种写法的json对象，键是无序排列的
             * JSON.parseObject(line, Feature.OrderedField); 这种写法的json对象，键是有序排列的
             */
            JSONObject ob = JSON.parseObject(line, Feature.OrderedField);   //添加Feature.OrderedField参数，json对象的键是有序排列的
            if(ob.getBooleanValue("bool_isComment")==false)
            {
                list.add(line);
            }
            else if(ob.getBooleanValue("bool_isComment")==true)
            {
                String kw_url = ob.getString("kw_url");
                String url_id = kw_url.split("/")[(kw_url.split("/").length)-1];
                url_id = url_id.split("_")[0];
                Integer floor = ob.getInteger("long_floor");
                String kw_id = url_id + floor.toString();
                ob.put("kw_id",kw_id);
                String jsonstr = ob.toJSONString();     //json.toString() 和json.toJSONString() 没什么区别,json.toString()内部调用了json.toJSONString()
                list.add(jsonstr);
            }
            line = bufferedReader.readLine();
            n= n+1;
        }
        return list;
    }


    public static void write_file(List<String> list,String path){
        FileWriter fw = null;
        Iterator iter = list.iterator();
        try{
            fw = new FileWriter(path);
            while(iter.hasNext())
            {
                fw.write(iter.next().toString()+"\r\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try{
                if(fw!=null)
                {
                    fw.close();
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}
