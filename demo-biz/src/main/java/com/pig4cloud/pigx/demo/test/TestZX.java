/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: TestZX
 * Author:   Arron-wql
 * Date:     2020/8/6 19:34
 * Description: 自旋锁
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自旋锁
 *
 * @author qinglong.wu
 * @create 2020/8/6
 * @Version 1.0.0
 */
public class TestZX {
	 AtomicInteger atomicInteger = new AtomicInteger(1);

	public  void lock(){
		System.out.println(Thread.currentThread().getName()+" come in");
			while (!atomicInteger.compareAndSet(1,2)){
				System.out.println("当前等待线程 : "+ Thread.currentThread().getName());
			}
	}

	public void unLock(){
		System.out.println(Thread.currentThread().getName()+" set value : " + atomicInteger.get());
		atomicInteger.compareAndSet(2,1);
	}

	public static void main(String[] args) {
		TestZX testZX = new TestZX();
		new Thread(new Runnable() {
			@Override
			public void run() {
				testZX.lock();
				try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) { e.printStackTrace();}
				testZX.unLock();
			}
		},"A").start();
		try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
		new Thread(new Runnable() {
			@Override
			public void run() {
				testZX.lock();
				testZX.unLock();
			}
		},"B").start();
	}


}
