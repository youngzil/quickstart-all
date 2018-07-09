/**
 * 项目名称：quickstart-example 
 * 文件名：GainPathUrlDemo.java
 * 版本信息：
 * 日期：2017年8月12日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.example;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * GainPathUrlDemo
 * 
 * @author：yangzl@asiainfo.com
 * @2017年8月12日 上午10:42:05
 * @since 1.0
 */
public class GainPathUrlDemo {
    public static void main(String[] args) {
        GainPathUrlDemo muDemo = new GainPathUrlDemo();
        try {
            muDemo.showURL();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void showURL() throws IOException {

        // 第一种：获取类加载的根路径 D:\git\daotie\daotie\target\classes
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);

        // 获取当前类的所在工程路径; 如果不加“/” 获取当前类的加载目录 D:\git\daotie\daotie\target\classes\my
        File f2 = new File(this.getClass().getResource("").getPath());
        System.out.println(f2);

        // 第二种：获取项目路径 D:\git\daotie\daotie
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);

        // 第三种： file:/D:/git/daotie/daotie/target/classes/
        URL xmlpath = this.getClass().getClassLoader().getResource("");
        System.out.println(xmlpath);

        // 第四种： D:\git\daotie\daotie
        System.out.println(System.getProperty("user.dir"));
        /*
         * 结果： C:\Documents and Settings\Administrator\workspace\projectName
         * 获取当前工程路径
         */

        // 第五种： 获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));

    }
}
