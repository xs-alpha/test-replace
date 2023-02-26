package top.devlwst.blog.util;

/**
 * @author xiaosheng
 * @date Created at 2023/2/26
 */
public interface ClassInformation {
    /**
     * get class inf
     */
    void storeClassInf(Class clazz) throws ClassNotFoundException;

    /**
     * 设置类绝对路径
     *
     * @param clazz
     */
    void setPath(Class clazz);

    /**
     * 设置类绝对路径
     *
     * @param clazz
     * @param path
     */
    void setPath(Class clazz, String path);

    /**
     * 读取文件信息
     */
    void getClassEntityText();
}
