/**
 * 项目名称：quickstart-design-pattern 
 * 文件名：MySubject.java
 * 版本信息：
 * 日期：2018年1月27日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.design.pattern.observer.example;

/**
 * MySubject
 * 
 * @author：yangzl@asiainfo.com
 * @2018年1月27日 上午12:01:08
 * @since 1.0
 */
public class MySubject extends AbstractSubject {

    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }

}
