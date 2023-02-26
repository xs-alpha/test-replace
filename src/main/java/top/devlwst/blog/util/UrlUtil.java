package top.devlwst.blog.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;

/**
 * @author xiaosheng
 * @date Created at 2023/2/26
 */
public class UrlUtil {

    /**
     * Description:取得当前类所在的文件
     *
     * @param clazz
     * @return
     */
    public static File getClassFile(Class clazz) {
        URL path = clazz.getResource(clazz.getName().substring(
                clazz.getName().lastIndexOf(".") + 1)
                + ".class");
        if (path == null) {
            String name = clazz.getName().replaceAll("[.]", "/");
            path = clazz.getResource("/" + name + ".class");
        }
        return new File(path.getFile());
    }

    /**
     * Description:同getClassFile 解决中文编码问题
     *
     * @param clazz
     * @return
     */
    public static String getClassFilePath(Class clazz) {
        try {
            return java.net.URLDecoder.decode(getClassFile(clazz)
                    .getAbsolutePath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Description:取得当前类所在的ClassPath目录
     *
     * @param clazz
     * @return
     */
    public static File getClassPathFile(Class clazz) {
        File file = getClassFile(clazz);
        for (int i = 0, count = clazz.getName().split("[.]").length; i < count; i++)
            file = file.getParentFile();
        if (file.getName().toUpperCase().endsWith(".JAR!")) {
            file = file.getParentFile();
        }
        return file;
    }

    /**
     * Description: 同getClassPathFile 解决中文编码问题
     *
     * @param clazz
     * @return
     */
    public static String getClassPath(Class clazz) {
        try {
            return java.net.URLDecoder.decode(getClassPathFile(clazz)
                    .getAbsolutePath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(getClassFilePath(UrlUtil.class));
        System.out.println(getClassPath(UrlUtil.class));
    }
}
