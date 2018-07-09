/**
 * 项目名称：quickstart-design-pattern 
 * 文件名：TemplateMethodTest.java
 * 版本信息：
 * 日期：2018年1月26日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.design.pattern.template.method.example;

/**
 * TemplateMethodTest
 * 
 * @author：yangzl@asiainfo.com
 * @2018年1月26日 下午11:57:40
 * @since 1.0
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp, "\\+");
        System.out.println(result);
    }
}
