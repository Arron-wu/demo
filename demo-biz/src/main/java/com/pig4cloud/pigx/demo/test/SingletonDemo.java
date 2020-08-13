/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: SingletonDemo
 * Author:   Arron-wql
 * Date:     2020/8/11 14:47
 * Description: 多线程下安全的单例模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.test;

/**
 * 多线程下安全的单例模式
 *
 * DCL(双重检查) + volatile（禁止指令重排）
 *
 * @author qinglong.wu@funi365.com
 * @create 2020/8/11
 * @Version 1.0.0
 */
public class SingletonDemo {
	private static volatile SingletonDemo singletonDemo = null;
	private SingletonDemo(){}
	public static SingletonDemo getInstance(){
		if (singletonDemo==null){
			synchronized (SingletonDemo.class){
				if (singletonDemo==null){
					return singletonDemo = new SingletonDemo();
				}
			}
		}
		return singletonDemo;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"获取单例: "+SingletonDemo.getInstance());
				}
			},"A").start();
		}
	}
}