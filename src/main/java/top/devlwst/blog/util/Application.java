package top.devlwst.blog.util;

import top.devlwst.blog.po.ApiPageBO;

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
        Class<ApiPageBO> clazz = ApiPageBO.class;
        classInformation.storeClassInf(clazz);

        // 可以用setPath的重载方法,自己填充绝对路径
        classInformation.setPath(clazz);

        // 读取文件信息
        classInformation.getClassEntityText();

        Application app = new Application();
        app.replaceAnnotation();

        Util util = new Util();
        // 将注解的import丢进去
        util.writeImports("import ", "import io.swagger.annotations.ApiModel;\n" +
                "import io.swagger.annotations.ApiModelProperty;\n");

        ClassInf c = ClassInf.getInstance();
        util.writeCodeWithAnnotation(c.getPrefix() + c.getSuffix(), c.getAbstractPos(), false);
    }

    public void replaceAnnotation() {
        ClassInf instance = ClassInf.getInstance();
        String suffix = instance.getSuffix();
        // linux
        String replace = suffix.replace("    /**\n", "").replace(
                "     * ", "\t@ApiModelProperty(value = \"").replace("\n     */", "\")");

        // windows
        replace = replace.replace("\t/**\n" ,
                "").replace(
                "\t * ", "\t@ApiModelProperty(value = \"").replace("\n" +
                "\t */", "\")");

        System.out.println("[*]: replace annotation success");
        instance.setSuffix(replace);
    }

    public void replaceAnnotation(boolean flag) {
        // todo: 正则替换
    }

    // /home/xiaosheng/java/test/test-replace/test-replace/src/main/java/top/devlwst/blog/po/entity.java
}
