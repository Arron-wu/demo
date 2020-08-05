/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: TestLock
 * Author:   Arron-wql
 * Date:     2020/8/4 15:26
 * Description: 通过线程通信实现轮循打印
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过线程通信实现轮循打印
 *
 * @author qinglong.wu@funi365.com
 * @create 2020/8/4
 * @Version 1.0.0
 */
public class TestLock {

	private static int currentNum = 1;

	private static ReentrantLock lock = new ReentrantLock();
	private static Condition condition1 = lock.newCondition();
	private static Condition condition2 = lock.newCondition();
	private static Condition condition3 = lock.newCondition();

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <20 ; i++) {
					loopA();
				}
			}
		},"A").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <20 ; i++) {
					loopB();
				}
			}
		},"B").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <20 ; i++) {
					loopC();
				}
			}
		},"C").start();
	}

	public static void loopA(){
		lock.lock();
		try {

			//不是A执行，等待
			if (currentNum != 1){
				condition1.await();
			}

			//执行
			System.out.print(Thread.currentThread().getName());

			//唤醒B
			currentNum = 2;
			condition2.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public static void loopB(){
		lock.lock();
		try {

			//不是B执行，等待
			if (currentNum != 2){
				condition2.await();
			}

			//执行
			System.out.print(Thread.currentThread().getName());

			//唤醒C
			currentNum = 3;
			condition3.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public static void loopC(){
		lock.lock();
		try {

			//不是C执行，等待
			if (currentNum != 3){
				condition3.await();
			}

			//执行
			System.out.println(Thread.currentThread().getName());

			//唤醒A
			currentNum = 1;
			condition1.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}