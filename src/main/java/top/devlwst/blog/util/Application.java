package top.devlwst.blog.util;

import top.devlwst.blog.po.entity;

import javax.annotation.Resource;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author xiaosheng
 * @date Created at 2023/2/26
 */
public class Application {

    /**
     * getStartPosition(reflect)->entity(startPos:"",prefix:"",suffix:"",pos:"")->获取路径->读取io->replace
     */
    public static void main(String[] args) throws ClassNotFoundException {
        ClassInformation classInformation = new ClassInformationImpl();

        // 要替换的类名
        Class<entity> clazz = entity.class;
        classInformation.storeClassInf(clazz);

        // 可以用setPath的重载方法,自己填充绝对路径
        classInformation.setPath(clazz);

        // 读取文件信息
        classInformation.getClassEntityText();

        Application app = new Application();
        app.replaceAnnotation();

        // TODO:将注解的import丢进去

        ClassInf c = ClassInf.getInstance();
        app.writeCodeWithAnnotation(c.getPrefix() + c.getSuffix(), c.getAbstractPos(), false);
    }

    public void replaceAnnotation() {
        ClassInf instance = ClassInf.getInstance();
        String suffix = instance.getSuffix();
        String replace = suffix.replace("    /**\n", "").replace(
                "     * ", "\t@ApiModelProperty(value = \"").replace("\n     */", "\")");

        System.out.println("-----");
        instance.setSuffix(replace);
    }

    public void writeCodeWithAnnotation(String content, String filePath, boolean append) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filePath, append);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // /home/xiaosheng/java/test/test-replace/test-replace/src/main/java/top/devlwst/blog/po/entity.java
}
