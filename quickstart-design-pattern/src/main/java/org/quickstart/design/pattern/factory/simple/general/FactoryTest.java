/**
 * 项目名称：quickstart-design-pattern 
 * 文件名：FactoryTest.java
 * 版本信息：
 * 日期：2018年1月25日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.design.pattern.factory.simple.general;

import org.quickstart.design.pattern.factory.common.Sender;

/**
 * FactoryTest
 * 
 * @author：yangzl@asiainfo.com
 * @2018年1月25日 下午12:15:27
 * @since 1.0
 */
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.send();
    }

}
