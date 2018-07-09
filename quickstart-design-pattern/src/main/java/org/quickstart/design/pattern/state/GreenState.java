/**
 * 项目名称：quickstart-design-pattern 
 * 文件名：GreenState.java
 * 版本信息：
 * 日期：2018年1月27日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.design.pattern.state;

import java.awt.Color;

/**
 * GreenState
 * 
 * @author：yangzl@asiainfo.com
 * @2018年1月27日 上午10:39:12
 * @since 1.0
 */
public class GreenState extends State {

    public void handlepush(Context c) {
        System.out.println("变成黑色");
        c.setState(new BlackState());
    }

    public void handlepull(Context c) {
        System.out.println("变成蓝色");
        c.setState(new BlueState());
    }

    public Color getcolor() {
        return (Color.green);
    }
}
