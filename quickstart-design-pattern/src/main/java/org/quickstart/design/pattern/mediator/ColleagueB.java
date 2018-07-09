/**
 * 项目名称：quickstart-design-pattern 
 * 文件名：ColleagueB.java
 * 版本信息：
 * 日期：2018年1月27日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.design.pattern.mediator;

/**
 * ColleagueB
 * 
 * @author：yangzl@asiainfo.com
 * @2018年1月27日 下午1:31:10
 * @since 1.0
 */
public class ColleagueB extends AbstractColleague {

    @Override
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.BaffectA();
    }
}
