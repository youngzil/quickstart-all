/**
 * 项目名称：quickstart-javase 
 * 文件名：ResourceManager.java
 * 版本信息：
 * 日期：2017年7月26日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.javase.example.ThreadDeadLock;

/**
 * ResourceManager 资源管理类，对资源数据操作的接口
 * 
 * @author：yangzl@asiainfo.com
 * @2017年7月26日 下午7:42:42
 * @version 2.0
 */
public class ResourceManager {

    /**
     * 管理的两个资源
     */
    private Resource resourceA = new Resource();
    private Resource resourceB = new Resource();

    /**
     * 创建一个新的实例 ResourceManager.
     */
    public ResourceManager() {
        this.resourceA.setValue(0);
        this.resourceB.setValue(0);
    }

    /**
     * 资源的读取
     */
    public int read() {
        synchronized (this.resourceA) {
            System.out.println(Thread.currentThread().getName() + "线程拿到了资源 resourceA 的对象锁");
            synchronized (resourceB) {
                System.out.println(Thread.currentThread().getName() + "线程拿到了资源 resourceB 的对象锁");
                return this.resourceA.getValue() + this.resourceB.getValue();
            }
        }
    }

    /**
     * 资源的改写
     */
    public void write(int a, int b) {
        synchronized (this.resourceB) {
            System.out.println(Thread.currentThread().getName() + "线程拿到了资源 resourceB 的对象锁");
            synchronized (this.resourceA) {
                System.out.println(Thread.currentThread().getName() + "线程拿到了资源 resourceA 的对象锁");
                this.resourceA.setValue(a);
                this.resourceB.setValue(b);
            }
        }
    }
}
