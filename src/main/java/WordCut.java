import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class WordCut {
    public static void main(String[] args) throws Exception{
        String fileName = "word/选词频率.xlsx";
        FileReader read = new FileReader(fileName);
        BufferedReader br = new BufferedReader(read);
        String str = null;
        String ss = null;
        int i = 0; // 总字符串
        int b = 0; // 汉字数
        int c = 0; // 字母数
        int d = 0; // 数子数
        int e = 0; // 其他
        StringBuffer sb;
        FileWriter writer = new FileWriter(fileName.substring(0, fileName.length() - 4)+"_格式化.txt");
        while ((str = br.readLine()) != null) {
            i += str.length();
            sb = new StringBuffer();
            for (int j = 0; j < str.length(); j++) {
                ss = Character.toString(str.charAt(j));
                if (ss.matches("[\\u4e00-\\u9fa5]")) {
                    sb.append(ss);
                    b++;
                }else if(ss.matches("[A-Z]")){//if语句的条件，判断是否为大写字母
                    c++;//若为大写字母则c2自增
                } else if(ss.matches("[a-z]")){//if语句的条件，判断是否为小写字母
                    c++;//若为小写字母则c3自增
                } else if(ss.matches("[0-9]")){//if语句的条件，判断是否为数字
                    d++;//若为数字则c4自增
                } else if (ss.matches("/")) {
                    e++;
                } else {//否则可判断为其他字符
                    sb.append(ss);
                    e++;//若为其他字符则c5自增e
                }
            }
            writer.append(sb.toString()).append("\r\n");
        }
        writer.close();
        br.close();
        System.out.println("总字符数：" + i);
        System.out.println("总汉字数：" + b);
        System.out.println("总字母数：" + c);
        System.out.println("总数字数：" + d);
        System.out.println("其他：" + e);

    }

}
