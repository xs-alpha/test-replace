package top.devlwst.blog.util;

import java.io.*;

/**
 * @author xiaosheng
 * @date Created at 2023/2/26
 */
public class Util {

    /**
     * 处理annotation
     * @param content
     * @param filePath
     * @param append
     */
    public void writeCodeWithAnnotation(String content, String filePath, boolean append) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filePath, append);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
            System.out.println("[*]: write code success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将imports写入prefix
     * @param keyWord
     * @param appendStr
     */
    public void writeImports(String keyWord, String appendStr){
        BufferedReader reader;
        ClassInf instance = ClassInf.getInstance();
        try {
            reader = new BufferedReader(new StringReader(instance.getPrefix()));
            String line = reader.readLine();

            boolean flag = false;
            StringBuilder res = new StringBuilder();

            while (line != null) {
                res.append(line);
                res.append("\n");
                if (line.contains(keyWord)&&!flag) {
                    flag = true;
                    res.append(appendStr);
                    System.out.println("contains-keyWord:"+ keyWord);
                }
                // read next line
                line = reader.readLine();
            }
            reader.close();
            instance.setPrefix(res.toString());
            System.out.println("[*]: write imports success");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
