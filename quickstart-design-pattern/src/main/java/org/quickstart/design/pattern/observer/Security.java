/**
 * 项目名称：quickstart-design-pattern 
 * 文件名：Security.java
 * 版本信息：
 * 日期：2018年1月26日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.design.pattern.observer;

/**
 * Security
 * 
 * @author：yangzl@asiainfo.com
 * @2018年1月26日 下午11:51:54
 * @since 1.0
 */
public class Security implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，保安贴身保护");
    }
}
