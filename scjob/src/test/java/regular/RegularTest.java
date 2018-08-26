package regular;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author szh
 * @create 2018-08-26 18:11
 **/
public class RegularTest {
    @Test
    public void readAndRegular() throws IOException {
        FileInputStream fileInputStream  =new FileInputStream(new File("D:\\disk\\regular.txt"));
        Reader reader =new InputStreamReader(fileInputStream,"UTF-8");
//        byte[] bytes =new byte[1024];
//        int len;
//        StringBuffer sb = new StringBuffer();
//        while ((len = fileInputStream.read(bytes)) != -1) {
//            String s = new String(bytes, 0, len);
//            sb.append(s);
//        }
//        char[] chars =new
        int len;
        char[] a =new char[1024];
        StringBuffer sb =new StringBuffer();
        Pattern parent = null;
        Matcher matcher = null;
//        parent = Pattern.compile("<ul class=\"l2\">[^.]+<span><li>(\\d+\\.\\d+\\.\\d+\\.\\d+)<\\/li><\\/span>[^.]+<span style=\"width: 100px;\"><li class=\"port .*?\">(\\d+)</li></span>" +
//                "[^.]+<span style=\".*?\"><li><a class=\"href\" href=\".*?>(.*?)</a></li></span>" +
//                "[^.]+<span style=\".*?\"><li><a class=\"href\" href=\".*?>(.*?)</a></li></span>" +
//                "[^.]+<span style=\".*?\"><li><a class=\"href\" href=\".*?>(.*?)</a></li></span>");
        parent = Pattern.compile("<ul class=\"l2\">[^.]+<span><li>(\\d+\\.\\d+\\.\\d+\\.\\d+)</li></span>[^.]+<span style=\"width: 100px;\"><li class=\"port .*?\">(\\d+)</li></span>" +
                "[^.]+<span style=\".*?\"><li><a class=\"href\" href=\".*?\">(.*?)</a></li></span>" +
                "[^.]+<span style=\".*?\"><li><a class=\"href\" href=\".*?\">(.*?)</a></li></span>" +
//                "[^.]+<span style=\".*?\"><li><a class=\"href\" href=\".*?\">(.*?)</a></li></span>" +
                "[^.]+<span><li><a class=\"href\" href=\".*?>(.*?)</a></li></span>");
        Map<String, Boolean> map = new HashMap<>();
        while ((len=reader.read(a))!= -1)  //以字节流去读pdf文件
        {
           String s1=   new String(a,0,len) ;
            sb.append(s1);
            matcher = parent.matcher(s1);
            if (matcher.find()) {
                String cutresult = matcher.group().toString();
                if (map.get(cutresult) == null)
                    map.put(cutresult, false);
            }
//            if (map.get(cutresult) == null)
//                map.put(cutresult, false);
        }
        reader.close();

//        matcher = parent.matcher(result);
//        Map<String, Boolean> map = new HashMap<>();
//        if (matcher.find()) {
//            String cutresult = matcher.group().toString();
//            if (map.get(cutresult) == null)
//                map.put(cutresult, false);
//        }
        System.out.println(map.size());
//        matcher= parent.matcher(result);
//        Pattern pattern1= matcher.pattern();
//        System.out.println(pattern1.toString());
        String result = sb.toString();
        String[] str=parent.split(result);
//        String pa ="<ul class=\"l2\">[^.]+<span><li>(\\d+\\.\\d+\\.\\d+\\.\\d+)<\\/li><\\/span>[^.]+<span style=\"width: 100px;\"><li class=\"port .*?\">(\\d+)</li></span>" +
//                "[^.]+<span style=\".*?\"><li><a class=\"href\" href=\".*?>(.*?)</a></li></span>" +
//                "[^.]+<span style=\".*?\"><li><a class=\"href\" href=\".*?>(.*?)</a></li></span>";
//        String[] s= result.split(pa,0);
        System.out.println(str.length);
    }
}
