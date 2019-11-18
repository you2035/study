package javaBase.IO;

import java.io.*;

public class FileOperate {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Downloads\\pic");
//        listAllFiles(file);
        String src = "D:\\复制\\javaNotes.pdf";
        String toDist  = "D:\\java学习资料\\1.pdf";
//        copyFile(src,toDist);
        String filePath = "D:\\复制\\桌面\\桌面\\java初级.txt";
        readFileContent(filePath);
//        writeContentToFile(filePath);
    }

    public static void listAllFiles(File dir){
        if(dir == null || !dir.exists()){
            return;
        }
        if(dir.isFile()){
            System.out.println(dir.getName());
            return;
        }

        if(dir.isDirectory()){
            for (File file  :dir.listFiles() ) {
                listAllFiles(file);
            }
        }
    }

    //复制文件
    public static void copyFile(String src, String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);

        byte[] buffer = new byte[20 * 1024];
        int cnt;

        // read() 最多读取 buffer.length 个字节
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读到 eof，即文件尾
        while ((cnt = in.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, cnt);
        }

        in.close();
        out.close();
    }

    public static void readFileContent(String filePath) throws IOException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(filePath)), "GBK");
//        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(isr);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
        // 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
        // 因此只要一个 close() 调用即可
        bufferedReader.close();
    }

    public static void writeContentToFile(String filePath) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File(filePath)),"GBK");
        BufferedWriter bufferedWriter = new BufferedWriter(osw);
        String s = " 我是谁";
        try {
            bufferedWriter.append(s);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bufferedWriter.close();
        }

    }

}
