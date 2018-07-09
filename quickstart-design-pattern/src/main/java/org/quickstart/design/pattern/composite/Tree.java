/**
 * 项目名称：quickstart-design-pattern 
 * 文件名：Tree.java
 * 版本信息：
 * 日期：2018年1月26日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.design.pattern.composite;

/**
 * Tree
 * 
 * @author：yangzl@asiainfo.com
 * @2018年1月26日 下午11:05:15
 * @since 1.0
 */
public class Tree {

    TreeNode root = null;

    public Tree(String name) {
        root = new TreeNode(name);
    }

}
