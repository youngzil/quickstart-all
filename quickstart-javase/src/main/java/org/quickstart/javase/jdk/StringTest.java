/**
 * 项目名称：quickstart-javase 
 * 文件名：StringTest.java
 * 版本信息：
 * 日期：2018年3月19日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.javase.jdk;

import java.util.concurrent.TimeUnit;

/**
 * StringTest
 * 
 * @author：yangzl@asiainfo.com
 * @2018年3月19日 下午4:37:01
 * @since 1.0
 */
public class StringTest {

    public static void main(String[] args) throws InterruptedException {
        
        TimeUnit.SECONDS.sleep(1);
        
        
        String formatString = String.format("nThreads: %d (expected: > 0)", 10);
        System.out.println("formatString=" + formatString);
    }

}
