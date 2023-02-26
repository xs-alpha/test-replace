package top.devlwst.blog.util;

/**
 * @author xiaosheng
 * @date Created at 2023/2/26
 */
public class ClassInf {
    private static volatile ClassInf ClassInfSingleTon;
    /**
     * 类名
     */
    private String className;
    /**
     * 前缀
     */
    private String prefix;
    /**
     * 后缀
     */
    private String suffix;
    /**
     * 绝对位置
     */
    private String abstractPos;

    private ClassInf() {

    }

    // 获取单例
    public static ClassInf getInstance() {
        // DCL
        if (ClassInfSingleTon == null) {
            synchronized (ClassInf.class) {
                if (ClassInfSingleTon == null) {
                    ClassInfSingleTon = new ClassInf();
                }
            }
        }
        return ClassInfSingleTon;
    }

    public String getAbstractPos() {
        return abstractPos;
    }

    public void setAbstractPos(String abstractPos) {
        this.abstractPos = abstractPos;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
