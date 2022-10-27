import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class SplitFile {

    public static String stringToAscii(String value) {
        StringBuilder sb = new StringBuilder();
        char[] chars = value.toCharArray();
        for (char aChar : chars) {
            sb.append((int) aChar);
        }
        return sb.toString();
    }

    public static void splitFile(String fileName, int line) throws Exception{
        FileReader read = new FileReader(fileName);
        BufferedReader br = new BufferedReader(read);
        boolean isStop = false;
        int index = 1;
        while (!isStop) {
            int star = 1;
            FileWriter writer = new FileWriter(fileName.substring(0, fileName.length() - 4)+"_"+index+".txt");
            while (star < line) {
                String str = br.readLine();
                if (str == null) {
                    isStop = true;
                    break;
                }
                writer.append(str).append("\r\n");
                star++;
            }
            index++;
            writer.close();
        }
        br.close();

    }

    public static void splitFile1(String fileName, int line) throws Exception{
        FileReader read = new FileReader(fileName);
        BufferedReader br = new BufferedReader(read);
        boolean isStop = false;
        int index = 1;
        while (!isStop) {
            int star = 1;
            FileWriter writer = new FileWriter(fileName.substring(0, fileName.length() - 5)+"_"+index+".xlsx");
            while (star < line) {
                String str = br.readLine();
                if (str == null) {
                    isStop = true;
                    break;
                }
                writer.append(stringToAscii(str)).append("\r\n");
                star++;
            }
            index++;
            writer.close();
        }
        br.close();

    }

    public static void main(String[] args) throws Exception{
//        splitFile("./qqqq.txt", 5000);
        splitFile1("word/选词频率.xlsx", 5000);
    }
}
