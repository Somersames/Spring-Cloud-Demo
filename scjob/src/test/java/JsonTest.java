import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.dto.LagouDto;
import org.junit.Test;
import poj.RealPoj;

import java.io.*;

/**
 * @author szh
 * @create 2018-08-12 22:41
 **/
public class JsonTest {
    @Test
    public void toMap() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\SZH\\Documents\\jsonfile\\jsonFile.txt"));
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
              catch (IOException e) {
                e.printStackTrace();
            }
//        Reader reader =new InputStreamReader(new FileInputStream(new File("C:\\Users\\SZH\\Documents\\jsonfile\\jsonFile.txt")));
//        int len;
//        char[] a =new char[1024];
//        StringBuffer sb =new StringBuffer();
//        while ((len=reader.read(a))!= -1)  //以字节流去读pdf文件
//        {
//            sb.append(new String(a,0,len));
//        }

//        File file = new File("C:\\Users\\SZH\\Documents\\jsonfile\\jsonFile.txt");
//        StringBuffer sb =new StringBuffer();
//        InputStream in = null;
//        try {
//            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
//            // 一次读一个字节
//            in = new FileInputStream(file);
//            int tempbyte;
//            while ((tempbyte = in.read()) != -1) {
//                sb.append(tempbyte);
//                System.out.write(tempbyte);
//            }
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return;
//        }
            String content = sb.toString();
            LagouDto response = JSON.parseObject(content, new TypeReference<LagouDto>() {
            });
            System.out.println(response.getCode() == null);
        }
    }
