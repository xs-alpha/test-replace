package top.devlwst.blog.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author xiaosheng
 * @date Created at 2023/2/26
 */
public class ClassInformationImpl implements ClassInformation {

    public static void main(String[] args) {
        ClassInf instance = ClassInf.getInstance();
        String suffix = instance.getSuffix();
        String replace = suffix.replace("    /**\n", "").replace(
                "     * ", "\t@ApiModelProperty(value = \"").replace("\n     */", "\")");

        System.out.println("-----");
        System.out.println(replace);
    }

    @Override
    public void getClassEntityText() {
        BufferedReader reader;
        ClassInf instance = ClassInf.getInstance();
        try {
            reader = new BufferedReader(new FileReader(instance.getAbstractPos()));
            String line = reader.readLine();

            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            boolean flag = false;

            while (line != null) {
                if (!flag) {
                    prefix.append(line);
                    prefix.append("\n");
                }
                if (flag) {
                    suffix.append(line);
                    suffix.append("\n");
                }
                if (line.contains("public class " + instance.getClassName())) {
                    flag = true;
                    System.out.println("[*]: contains-class:"+instance.getClassName());
                }
                // read next line
                line = reader.readLine();
            }
            reader.close();

            instance.setPrefix(prefix.toString());
            instance.setSuffix(suffix.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeClassInf(Class clazz) throws ClassNotFoundException {
        String className = clazz.getSimpleName();
        ClassInf classInf = ClassInf.getInstance();
        classInf.setClassName(className);
        System.out.println("[*]: ");
    }

    @Override
    public void setPath(Class clazz) {
        String packageName = clazz.getName().replace(".", "/");
        System.out.println(packageName);

        // 获取系统路径
        String systemPath = System.getProperty("user.dir");

        String tempPath = "/src/main/java/";
        systemPath = systemPath + tempPath + packageName + ".java";
        System.out.println(systemPath);

        ClassInf.getInstance().setAbstractPos(systemPath);
        System.out.println("[*]: current path:"+ systemPath);
    }

    @Override
    public void setPath(Class clazz, String path) {
        if (path.endsWith("/")) {
            path += "/";
        }
        String systemPath = path + clazz.getSimpleName() + ".java";
        System.out.println(systemPath);

        ClassInf.getInstance().setAbstractPos(systemPath);
    }
}
