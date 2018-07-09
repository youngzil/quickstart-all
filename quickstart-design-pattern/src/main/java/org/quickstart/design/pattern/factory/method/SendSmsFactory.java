/**
 * 项目名称：quickstart-design-pattern 
 * 文件名：SendSmsFactory.java
 * 版本信息：
 * 日期：2018年1月25日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.design.pattern.factory.method;

import org.quickstart.design.pattern.factory.common.Sender;
import org.quickstart.design.pattern.factory.common.SmsSender;

/**
 * SendSmsFactory
 * 
 * @author：yangzl@asiainfo.com
 * @2018年1月25日 下午12:23:49
 * @since 1.0
 */
public class SendSmsFactory implements Provider {

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
